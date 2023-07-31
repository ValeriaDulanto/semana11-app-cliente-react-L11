const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');

class App extends React.Component {
	constructor(props) {
		super(props);
		this.state = {instrumentos: []};
	}
	componentDidMount() {
		client({method: 'GET', path: '/api/instrumentos'}).done(response => {
			this.setState({instrumentos: response.entity._embedded.instrumentos});
		});
	}
	render() {
		return (
			<InstrumentosList instrumentos={this.state.instrumentos}/>
		)
	}
}

class InstrumentosList extends React.Component{
	render() {
		const instrumentos = this.props.instrumentos.map(instrumentos =>
			<Instrumentos key={instrumento._links.self.href} instrumento={instrumento}/>
		);
		return (
			<table>
				<tbody>
					<tr>
						<th>nombre</th>
						<th>categoria</th>
						<th>Description</th>
					</tr>
					{instrumentos}
				</tbody>
			</table>
		)
	}
}

class Instrumentos extends React.Component{
	render() {
		return (
			<tr>
				<td>{this.props.instrumentos.nombre}</td>
				<td>{this.props.instrumentos.categoria}</td>
				<td>{this.props.instrumentos.description}</td>
			</tr>
		)
	}
}

ReactDOM.render(
	<App />,
	document.getElementById('react')
)

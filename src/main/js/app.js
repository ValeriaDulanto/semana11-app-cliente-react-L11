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
			<InstrumentoList instrumentos={this.state.instrumentos}/>
		)
	}
}

class InstrumentoList extends React.Component{
	render() {
		const instrumentos = this.props.instrumentos.map(instrumento =>
			<Instrumento key={instrumento._links.self.href} instrumento={instrumento}/>
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

class Instrumento extends React.Component{
	render() {
		return (
			<tr>
				<td>{this.props.instrumento.nombre}</td>
				<td>{this.props.instrumento.categoria}</td>
				<td>{this.props.instrumento.description}</td>
			</tr>
		)
	}
}

ReactDOM.render(
	<App />,
	document.getElementById('react')
)

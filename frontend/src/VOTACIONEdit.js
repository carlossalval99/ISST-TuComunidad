import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import AppNavbar from './AppNavbar';

class VOTACIONEdit extends Component {

    emptyItem = {
        idvotacion: '',
        tema: '',
        fechayhoralimite: '',
        votos: 0,
    };

    constructor(props) {
        super(props);
        this.state = {
            item: this.emptyItem
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    async componentDidMount() {
        if (this.props.match.params.idvotacion !== 'new') {
            const votacion = await (await fetch(`/votacions/${this.props.match.params.idvotacion}`)).json();
            this.setState({item: votacion});
        }
    }

    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        let item = {...this.state.item};
        item[name] = value;
        this.setState({item});
    }

async handleSubmit(event) {
    event.preventDefault();
    const {item} = this.state;

    await fetch('/votacions' + ((this.props.match.params.idvotacion !== 'new') ? '/' + item.idvotacion : ''), {
        method: (this.props.match.params.idvotacion !== 'new') ? 'PUT' : 'POST', //(item.email) ? 'PUT' : 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(item),
    });
    this.props.history.push('/votacions');
}

    render() {
        const {item} = this.state;
        const title = <h2>{item.idvotacion ? 'Editar votacion' : 'Añadir votacion'}</h2>;

        return <div>
            <AppNavbar/>
            <Container>
                {title}
                <Form onSubmit={this.handleSubmit}>
                    <FormGroup>
                        <Label for="fechayhoralimite">FECHA Y HORA LÍMITE</Label>
                        <Input type="text" name="fechayhoralimite" id="fechayhoralimite" value={item.fechayhoralimite || ''}
                               onChange={this.handleChange} autoComplete="fechayhoralimite"/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="tema">Tema</Label>
                        <Input type="text" name="tema" id="tema" value={item.tema || ''}
                               onChange={this.handleChange} autoComplete="tema"/>
                    </FormGroup>
                    <FormGroup>
                        <Button color="primary" type="submit">Guardar</Button>{' '}
                        <Button color="secondary" tag={Link} to="/votacions">Cancelar</Button>
                    </FormGroup>
                </Form>
            </Container>
        </div>
    }
}

export default withRouter(VOTACIONEdit);
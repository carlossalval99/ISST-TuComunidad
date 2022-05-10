import React, { Component } from 'react';
import './App.css';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';
import { Button, Container } from 'reactstrap';
import './Home.css';
import logoComVec from './logoComVec.png'
//import buenosdias from './bn.gif'

class Home extends Component {
/*
    state= {
        form:{
            piso: '',
            contraseña: ''
        }
    }

    handleChange= async e=>{
        await this.setState({
            form:{
                ...this.state.form,
                [e.target.name]: e.target.value
            }
        });
    }

    iniciarSesion = async ()=>{
        await fetch(`/vecinos`, {
            method: "GET", 
            headers: {
              Accept: "application/json",
              "Content-Type": "application/json",
            }
        

    })
    .then((response) => response.json())
    .then((data) => console.log(data));

    }*/

    
    
            
            /*
            <div>
                <img src={buenosdias}  className="logo"/>
                <Button className="boton" color="link"><Link to="/infos">NO ME SALIAN LAS COSAS CON EL CSS ASI Q DEJE ESTO, EN EL CODIGO ESTA LO Q INTENTABA COMENTADO</Link></Button>
            </div>
*/

    render() {
        const divStyle = {
          height: "300",
          innerWidth: "300",
          display: "flex",
          alignItems: "center",
          justifyContent: "center",
        };
        const divStyle2 = {
        
            display: "flex",
            alignItems: "space-between",
            justifyContent: "center",
            padding: "50px"
            
            
          };
          const divStyle3 = {
        
            display: "flex",
            alignItems: "space-between",
            justifyContent: "center",
            padding: "50px",
            textDecoration: "underline"
            
          };
        return (
          <div>
            <div style={divStyle3}>
              <h2>Pulsa el botón para acceder a tu aplicación</h2>
            </div>

            <div style={divStyle}>
              <img src={logoComVec} className="logo" />
            </div>
            <div style={divStyle2}>
              <Button className="boton" color="link">
                <Link to="/infos">BIENVENIDO A TUCOMUNIDAD</Link>
              </Button>
            </div>
          </div>
        );
        /*return (
            <div>
                <img src={logoComVec}  className="logo"/>
            <div className= "containerPrincipal">
                <div className= "containerSecundario">
                    <div className= "form-group">
                        <label>Usuario:</label>
                        <br />
                        <input 
                        type="text" 
                        className="form-control" 
                        name="piso"
                        onChange={this.handleChange}
                        />
                        <label>Contraseña:</label>
                        <br />
                        <input type="password" 
                        className="form-control"
                         name="contraseña"
                         onChange={this.handleChange}
                        />
                        <br />

                <Container fluid>
                <Button color="link"><Link to="/infos">INICIAR SESION</Link></Button>
                </Container>
                </div>
            </div>
        </div>
        </div>
        );*/
    }
}

export default Home;
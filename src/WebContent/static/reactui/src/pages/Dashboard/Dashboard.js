import React, { Component } from "react";
import Viewport from "../../components/Viewport";
import { List, ListItem } from "../../components/List";
import { Col, Row, Container } from "../../components/Grid";
import API from "../../utils/API";


class Dashboard extends Component {
  state = {
    stocks: [],
    weather: []
  };

  componentDidMount() {
    this.loadStocks();
    this.loadWeather();
  }

  loadStocks = () => {
    API.getStocks()
      .then(res => this.setState({ stocks: res.data }))
      .catch(err => console.log(err));
  };

  loadWeather = () => {
    API.getWeather()
      .then(res => this.setState({weather: res.data}))
      .catch(err => console.log(err));
  };

  render() {  
    return (
      <Container fluid>
        <Row>
          <Col size="md-6">
            <Viewport>
              <h1>Socks on Stocks</h1>

                {this.state.stocks.length ? (
              <List>
                {this.state.stocks.map(stock => (
                  <ListItem key={stock._id}>
                    <a href={"/stocks/" + stock._id}>
                      <strong>
                        {stock}
                      </strong>
                    </a>
                  </ListItem>
                ))}
              </List>
            ) : (
              <h3>No Results to Display</h3>
            )}

            </Viewport>
          </Col>
          <Col size="md-6">
                <Viewport>
                  <h1>Rain Rain Go Away...</h1>
    
                    {this.state.weather.length ? (
                  <List>
                    {this.state.weather.map(weather => (
                      <ListItem key={weather._id}>
                        <a href={"/weather/" + weather._id}>
                          <strong>
                            {weather}
                          </strong>
                        </a>
                      </ListItem>
                    ))}
                  </List>
                ) : (
                  <h3>Look outside or ask Alexa</h3>
                )}
    
                </Viewport>
              </Col>

        </Row>
      </Container>
    );
  }
}

export default Dashboard;

import React, { Component } from 'react';

class DataFetcher extends Component {
  // Initialize state to store fetched data and loading/error states
  constructor(props) {
    super(props);
    this.state = {
      data: null,
      loading: true,
      error: null
    };
  }

  // Fetch data when the component mounts
  componentDidMount() {
    // Replace this with any API endpoint you want to fetch data from
    const apiUrl = 'https://jsonplaceholder.typicode.com/posts'; // Example API

    // Fetch data from the API
    fetch(apiUrl)
      .then(response => response.json())
      .then(data => {
        // Update the state with fetched data
        this.setState({ data, loading: false });
      })
      .catch(error => {
        // Handle any errors that occur during the fetch
        this.setState({ error, loading: false });
      });
  }

  render() {
    const { data, loading, error } = this.state;

    // While data is loading, show loading message
    if (loading) {
      return <div>Loading...</div>;
    }

    // If there is an error, show error message
    if (error) {
      return <div>Error: {error.message}</div>;
    }

    // If data is fetched, display it
    return (
      <div>
        <h1>Fetched Data</h1>
        <ul>
          {data && data.map(item => (
            <li key={item.id}>
              <h3>{item.title}</h3>
              <p>{item.body}</p>
            </li>
          ))}
        </ul>
      </div>
    );
  }
}

export default DataFetcher;

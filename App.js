import logo from './logo.svg';
import './App.css';
import HelloWorld from './Components/HelloWorld';
import Counter from './Components/Counter';
import Form from './Components/Form';
import DataFetcher from './Components/DataFetcher';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
      <HelloWorld/>
      <Counter/>
      <Form/>
      <DataFetcher/>
    </div>
  );
}

export default App;

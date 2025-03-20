import React, { useState, useEffect } from "react";
import ProgressBar from "./components/ProgressBar";

const App = () => {
  const [progress, setProgress] = useState(0);

  useEffect(() => {
    const interval = setInterval(() => {
      setProgress((oldProgress) => {
        const newProgress = oldProgress + 10;
        return newProgress > 100 ? 100 : newProgress;
      });
    }, 1000);

    return () => clearInterval(interval);
  }, []);

  return (
    <div style={{ width: "50%", margin: "50px auto", textAlign: "center" }}>
      <h2>Custom Progress Bar</h2>
      <ProgressBar progress={progress} />
    </div>
  );
};

export default App;
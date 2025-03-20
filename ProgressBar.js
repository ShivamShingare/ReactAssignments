import React from "react";
import "./ProgressBar.css"; // Import CSS for styling

const ProgressBar = ({ progress, height = "20px", color = "#4caf50" }) => {
  return (
    <div className="progress-container" style={{ height }}>
      <div
        className="progress-bar"
        style={{
          width: `${progress}%`,
          backgroundColor: color,
          height: "100%",
        }}
      >
        <span className="progress-text">{progress}%</span>
      </div>
    </div>
  );
};
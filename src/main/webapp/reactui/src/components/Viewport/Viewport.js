import React from "react";
import "./Viewport.css";

const Viewport = ({ children }) =>
  <div style={{ height: 300, clear: 'both' }} className="viewport">
    {children}
  </div>;

export default Viewport;

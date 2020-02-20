import React from "react";
import { connect } from "react-redux";

import Navbar from "modules/navbar/Navbar";
import SummaryContainer from "modules/summary/SummaryContainer";
import ReportContainer from "modules/report/ReportContainer";

import "./Xbdd.css";

class Xbdd extends React.Component {
  switchPage() {
    const { user, product, version, build } = this.props;
    if (user) {
      if (product && version && build) {
        return <ReportContainer product={product} version={version} build={build} />;
      } else {
        return <SummaryContainer />;
      }
    } else {
      return <div />;
    }
  }

  render() {
    return (
      <div className="xbdd-app">
        <Navbar />
        {this.switchPage()}
      </div>
    );
  }
}

const mapStateToProps = state => ({
  user: state.app.user,
  product: state.app.product,
  version: state.app.version,
  build: state.app.build,
});

export default connect(mapStateToProps)(Xbdd);

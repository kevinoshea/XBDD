/**
 * This module was automatically generated by `ts-interface-builder`
 */
import * as t from 'ts-interface-checker';
// tslint:disable:object-literal-key-quotes

export const ResponseDataElement = t.iface([], {
  tag: 'string',
  features: t.array('SimplefeatureResponseData'),
});

export const ResponseData = t.array('ResponseDataElement');

const exportedTypeSuite: t.ITypeSuite = {
  ResponseDataElement,
  ResponseData,
};
export default exportedTypeSuite;
define(
    function (require) {

        var Image = require('./Image');

        /**
         * @alias zrender/shape/Image
         * @constructor
         * @extends module:zrender/shape/Base
         * @param {Object} options
         */
        var CircleImage = function (options) {
            Image.call(this, options);
            this._clipShape = [{

            }]
        };

        CircleImage.prototype = {
            type: 'circle-image'
        };

        require('../tool/util').inherits(CircleImage, Image);
        return CircleImage;
    }
);

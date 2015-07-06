define(
    function (require) {

        var Base = require('./Base');

        var DoubleArcAround = function (options) {
            this.brushTypeOnly = 'stroke';
            Base.call(this, options);
        };

        DoubleArcAround.prototype = {
            type: 'cellular',

            buildPath: function (ctx, style) {
                var i;
                var x = style.x;
                var y = style.y;
                var r = style.r;
                var colorStyle = style.colorStyle;
                var initRadian = Math.PI * 2 / 3;

                for (i = 0; i < 2; i++) {
                    ctx.beginPath();
                    ctx.arc(x, y, r + i, -(initRadian - Math.PI / 2) - Math.PI / 4, -(initRadian - Math.PI / 2) + Math.PI / 4, false);
                    ctx.strokeStyle = colorStyle;
                    ctx.stroke();
                    ctx.beginPath();
                    ctx.arc(x, y, r + i, Math.PI * 3 / 2 - initRadian - Math.PI / 4, Math.PI * 3 / 2 - initRadian + Math.PI / 4, false);
                    ctx.strokeStyle = colorStyle;
                    ctx.stroke();
                }
            },
            getRect: function (style) {
                if (style.__rect) {
                    return style.__rect;
                }
                return {
                    x: style.x,
                    y: style.y,
                    width: style.x + style.r,
                    height: style.y + style.r
                }
            }
        };
        require('../tool/util').inherits(DoubleArcAround, Base);
        return DoubleArcAround;
    }
);

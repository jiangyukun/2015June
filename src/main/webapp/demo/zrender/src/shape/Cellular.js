define(
    function (require) {

        var computeBoundingBox = require('../tool/computeBoundingBox');
        var Base = require('./Base');
        var PI = Math.PI;

        var Cellular = function (options) {
            this.brushTypeOnly = 'stroke';
            Base.call(this, options);
        };

        Cellular.prototype = {
            type: 'cellular',

            buildPath: function (ctx, style) {
                var i, j;
                var x = style.x;
                var y = style.y;
                var angle = 2 * PI - style.angle;
                var borderWidth = style.borderWidth;
                var colorStyle = style.colorStyle;
                var radius = style.radius;

                for (j = 0; j < borderWidth; j++) {
                    ctx.beginPath();
                    ctx.arc(x, y, radius + j, angle + PI / 6, angle - PI / 6, true);
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
                    width: style.x + style.radius * style.count,
                    height: style.y
                }
            }
        };
        require('../tool/util').inherits(Cellular, Base);
        return Cellular;
    }
);

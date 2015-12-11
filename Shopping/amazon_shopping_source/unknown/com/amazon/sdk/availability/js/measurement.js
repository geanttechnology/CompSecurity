(function(context) {
    function _toUriInner(intent, uri, scheme, flags) {
        var extraType = {
            'string': 'S',
            'bool': 'B',
            'byte': 'b',
            'char': 'c',
            'double': 'd',
            'float': 'f',
            'int': 'i',
            'long': 'l',
            'short': 's'
        },
        i = null,
        property = null,
        value = null,
        type = null;

        if(scheme) {
            uri.push('scheme=' + scheme + ';');
        }
        if(intent.action) {
            uri.push('action=' + encodeURI(intent.action) + ';');
        }
        if(intent.categories) {
            for(i = 0; i < intent.categories.length; i += 1) {
                uri.push('category=' + encodeURI(intent.categories[i]) + ';');
            }
        }
        if(intent.type) {
            uri.push('type=' + encodeURI(intent.type, '/') + ';');
        }
        if(intent.flags) {
            uri.push('launchFlags=0x' + intent.flags.toString(16) + ';');
        }
        if(intent.packageName) {
            uri.push('package=' + encodeURI(intent.packageName) + ';');
        }
        if(intent.className) {
            if(!intent.packageName) {
                intent.packageName = 'com.amazon.venezia';
            }
            uri.push('component=' + intent.packageName + '/' + intent.className + ';');
        }
        if(intent.extras) {
            for (property in intent.extras) {
                if(intent.extras.hasOwnProperty(property)) {
                    value = intent.extras[property];
                    type = value.type || 'string';
                    uri.push(extraType[type] + '.' + encodeURI(property) + '=' + encodeURI(
                        (typeof(value) === 'string' ? value : value.value + '')) + ';');
                }
            }
        }
    };

    function toUri(intent, schemeFlags) {
        var N, c, i, data = intent.data,
            uri = [],
            scheme = null;

        if(data) {
            if(schemeFlags) { //  if ((flags&URI_INTENT_SCHEME) != 0) {
                N = data.length;
                for(i = 0; i < N; i += 1) {
                    c = data.charAt(i);
                    if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c === '.' || c === '-') {
                        continue;
                    }
                    if(c == ':' && i > 0) {
                        // Valid scheme.
                        scheme = data.substring(0, i);
                        uri.push('intent:');
                        data = data.substring(i + 1);
                        break;
                    }
                    // No scheme.
                    break;
                }
            }
            uri.push(data);
        } else if(schemeFlags) { // ((flags&URI_INTENT_SCHEME) != 0) {
            uri.push('intent:');
        }

        uri.push('#Intent;');

        _toUriInner(intent, uri, scheme);
        uri.push('end');
        return uri.join('');
    };

    MeasurementManager = function() {
        // empty constructor
    };

    /**
     * This is what a measurement looks like :
     *
     * {
     *   'clientId' : <clientId>,
     *   'clientVersion' : <clientVersion>,
     *   'measurementName' : <measurementName>,
     *   'measurementValueNumber' : <measurementValueNumber>,
     *   'metadata': {
     *     <arbitrary key value pairs>
     *   }
     * }
     */
    MeasurementManager.prototype.putMeasurement = function(measurement) {
        if (measurement) {
            var intentDefinition = {
                className: 'com.amazon.sdk.availability.AvailabilityService',
                action: 'PutMeasurement',
                extras: {
                    'payload': JSON.stringify(measurement)
                }
            };

            if(context.IntentBridge) {
                context.IntentBridge.startService(toUri(intentDefinition));
            }
        }
    };

    context.MeasurementManager = MeasurementManager;

})(this);

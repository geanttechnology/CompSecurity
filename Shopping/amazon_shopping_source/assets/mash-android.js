/*global console : false , webclient : false , cordova : false, amznJQ : false , app : false , P : false, window : false , mashCallbackMgt : false , document : false*/
/**
 * MASH API 1.2 & 1.1
 * see https://w.amazon.com/index.php?title=MShop/Mobile_Shopping_Hybrid_App_Framework/MASH_1.1_API
 * see https://w.amazon.com/index.php?title=MShop/Mobile_Shopping_Hybrid_App_Framework/MASH_1.2_API
 * Java Script interface of the Mobile Application Shell (MASH)
 */

/**
 * MASH Async Callback Management, see java code com.amazon.mShop.android.web.AmazonWebViewJavaScriptClient.MASHcallback
 */
window.amazon = window.amazon || {};
window.app = window.app || {};
if (window.app.willReappear === undefined) {
    window.app.willReappear = function () {'use strict'; return; };
}

(function (amazon) {
    'use strict';
    window.mashCallbackMgt = window.mashCallbackMgt || {
        callbackId: 0,
        callbacks: {},
        /**
         * Called by native code when returning successful result
         */
        callbackSuccess: function (callbackId, args) {
            if (mashCallbackMgt.callbacks[callbackId]) {
                try {
                    if (mashCallbackMgt.callbacks[callbackId].success) {
                        // args.message is the arguments passed to callback, up to the definition of the callback to be called
                        // 1. it can just be a simple parameter, example
                        //    the definition of callback is successCallback(buttonIndex), then args.message=3 where 3 is the buttonIndex of tapped button
                        // 2. it can also be a JS object containing more parameters, example
                        //    the definition of callback is successCallback(o), where o is defined to use o.arg1 and o.arg2,  then args.message={arg1:value1, arg2:value2}
                        // The 2nd example can be used to expand to a callback with more than 1 parameter, is flexible
                        mashCallbackMgt.callbacks[callbackId].success(args.message);
                    }
                } catch (e) {
                    console.error("Error in MASH success callback: " + callbackId + " = " + e);
                }
                // Clear callback if not expecting any more results
                if (!args.keepCallback) {
                    delete mashCallbackMgt.callbacks[callbackId];
                }
            }
        },
        /**
         * Called by native code when returning error result
         */
        callbackError: function (callbackId, args) {
            if (mashCallbackMgt.callbacks[callbackId]) {
                try {
                    if (mashCallbackMgt.callbacks[callbackId].fail) {
                        // args.message is a string passed to fail callback, describing the failure message
                        // like the value of args.message='Show Alert Fail' , note it must contain '' .
                        mashCallbackMgt.callbacks[callbackId].fail(args.message);
                    }
                } catch (e) {
                    console.error("Error in MASH error callback: " + callbackId + " = " + e);
                }
                // Clear callback if not expecting any more results
                if (!args.keepCallback) {
                    delete mashCallbackMgt.callbacks[callbackId];
                }
            }
        }
    };

    /**
     * Save Async callback for later invoking from native code
     */
    function mashSaveCallback(o) {
        if (o && (o.successCallback || o.failCallback)) {
            mashCallbackMgt.callbackId += 1;
            mashCallbackMgt.callbacks[mashCallbackMgt.callbackId] = {success: o.successCallback, fail: o.failCallback};
            return mashCallbackMgt.callbackId;
        }
        return -1;
    }

    /**
     * Mash sync callback success
     */
    function mashOnSuccess(o) {
        if (o && typeof o.successCallback === "function") {
            o.successCallback();
        }
    }

    /**
     * Mash sync callback error
     */
    function mashOnError(message, o) {
        console.error(message);
        if (o && typeof o.failCallback === "function") {
            o.failCallback(message);
        }
    }

    /**
     * mashOnErrorObject sync callback error with error object.
     */
    function mashOnErrorObject(message, error, o) {
        console.error(message);
        if (o && typeof o.failCallback === "function") {
            o.failCallback(error);
        }
    }
    /**
     * Since MASH 1.5, in Embedded Browser, report PERMISSION_DENIED string for API 1.1&1.2.
     * Because PERMISSION_DENIED error code is defined since V1.3.
     */
    function permissionDenied(o) {
        if (window.webclient === undefined) {
            mashOnError("PERMISSION_DENIED", o);
            return true;
        }
        return false;
    }
    /**
     * ShellButton Object
     */
    function ShellButton(controlId) {
        this.getId = function () {
            if (controlId === "navButtonLeft") {
                return 0;
            }
            if (controlId === "navButtonRight") {
                return 1;
            }
        };
        this.id = this.getId(controlId);
        /**
         * ShellButton.show
         */
        this.show = function (o) {
            if (permissionDenied(o)) { return; }
            // text required
            if (typeof o.text !== "string") {
                mashOnError("show Error: text is not a string", o);
                return;
            }
            // tapCallback required
            if (typeof o.tapCallback !== "function") {
                mashOnError("show Error: tapCallback is not a function", o);
                return;
            }
            var isEnabled;
            if (typeof o.isEnabled === "boolean") {
                isEnabled = o.isEnabled;
            } else {
                isEnabled = true;
            }
            try {
                webclient.showBottomButton(this.id, o.text, isEnabled, mashSaveCallback({successCallback: o.tapCallback}));
                mashOnSuccess(o);
            } catch (e) {
                mashOnError("show Error: " + e, o);
            }
        };
        /**
         * ShellButton.setTapCallback
         */
        this.setTapCallback = function (o) {
            if (permissionDenied(o)) { return; }
            // tapCallback required
            if (typeof o.tapCallback !== "function") {
                mashOnError("setTapCallback Error: tapCallback is not a function", o);
                return;
            }
            try {
                var callbackId = mashSaveCallback({successCallback: o.tapCallback});
                webclient.setBottomButtonOnTouch(this.id, callbackId);
                mashOnSuccess(o);
            } catch (e) {
                mashOnError("setTapCallback Error: " + e, o);
            }
        };
        /**
         * ShellButton.setEnabled , this method should be called after show()
         */
        this.setEnabled = function (o) {
            if (permissionDenied(o)) { return; }
            // isEnabled required
            if (typeof o.isEnabled !== "boolean") {
                mashOnError("setEnabled Error: isEnabled is not a boolean", o);
                return;
            }
            try {
                webclient.setBottomButtonEnabled(this.id, o.isEnabled);
                mashOnSuccess(o);
            } catch (e) {
                mashOnError("setEnabled Error: setEnabled " + e, o);
            }
        };
        /**
         * ShellButton.setText , this method should be called after show()
         */
        this.setText = function (o) {
            if (permissionDenied(o)) { return; }
            if (typeof o.text !== "string") {
                mashOnError("setText Error: text is not a string", o);
                return;
            }
            try {
                webclient.setBottomButtonText(this.id, o.text);
                mashOnSuccess(o);
            } catch (e) {
                mashOnError("setText Error: setText " + e, o);
            }
        };
        /**
         * ShellButton.hide, this method should be called after show()
         */
        this.hide = function (o) {
            if (permissionDenied(o)) { return; }
            try {
                webclient.hideBottomButton(this.id);
                mashOnSuccess(o);
            } catch (e) {
                mashOnError("hide Error: hide" + e, o);
            }
        };
    }
    /**
     * MobileAppCart object
     */
    function MobileAppCart() {
        /**
         * amazon.mash.cart.didUpdate
         */
        this.didUpdate = function (o) {
            if (permissionDenied(o)) { return; }
            // newCartQuantity required
            if (typeof o.newCartQuantity !== "number") {
                mashOnError("didUpdate Error: newCartQuantity is not a number", o);
                return;
            }
            try {
                webclient.updateCartCount(o.newCartQuantity);
                mashOnSuccess(o);
            } catch (e) {
                mashOnError("didUpdate Error: cart.didUpdate" + e, o);
            }
        };
    }
    /**
     * App shell object
     */
    function MobileAppShell() {
        // For sub-packages like mash.search to access mash's content.
        // Fix JIRA https://jira1.amazon.com/browse/ANDROID-2102
        var mash = this,
            exec = function (successCallback, failCallback, action, args) {
                try {
                    cordova.exec(successCallback, failCallback, "Mash", action, args);
                } catch (e) {
                    // Catch exception to call failCallback function to notify API caller.
                    mashOnErrorObject("exec Error: " + e, {'code': this.Error.UNKNOWN}, {'failCallback': failCallback});
                }
            };

        this.Error = {
            PERMISSION_DENIED : 1001,
            TIMEOUT : 1002,
            NOT_SUPPORTED : 1003,
            OUT_OF_MEM : 1004,
            UNKNOWN : 1005,
            USER_CANCELED : 1006,
            INVALID_ARGUMENTS : 1007,
            OPERATION_IN_PROGRESS : 1008
        };

        this.cart = new MobileAppCart();
        /**
         * amazon.mash.showChooser
         */
        this.showChooser = function (o) {
            if (permissionDenied(o)) { return; }
            // buttonTitles required
            if (typeof o.buttonTitles !== "object") {
                mashOnError('showChooser Error: buttonTitles is not a array', o);
                return;
            }
            // successCallback required
            if (typeof o.successCallback !== "function") {
                mashOnError('showChooser Error: successCallback is not a function', o);
                return;
            }
            try {
                var callbackId = mashSaveCallback(o);
                webclient.showChooser(o.title, o.buttonTitles, o.cancelButtonTitle, callbackId);
            } catch (e) {
                mashOnError('showChooser Error: ' + e, o);
            }
        };
        /**
         * amazon.mash.showAlert
         */
        this.showAlert = function (o) {
            if (permissionDenied(o)) { return; }
            // message required
            if (typeof o.message !== "string") {
                mashOnError('showAlert Error: message is not a string', o);
                return;
            }
            // buttonTitles required
            if (typeof o.buttonTitles !== "object") {
                mashOnError('showAlert Error: buttonTitles is not an string array', o);
                return;
            }
            if (o.buttonTitles.length > 2) {
                mashOnError('showAlert Error: buttonTitles length must <=2 , if >2 you should use show chooser', o);
                return;
            }
            // successCallback required
            if (typeof o.successCallback !== "function") {
                mashOnError('showAlert Error: successCallback is not a function', o);
                return;
            }
            try {
                var callbackId = mashSaveCallback(o);
                webclient.showAlert(o.title, o.message, o.cancelButtonTitle, o.buttonTitles, callbackId);
            } catch (e) {
                mashOnError('showAlert Error: ' + e, o);
            }
        };
        /**
         * amazon.mash.openInExternalBrowser
         */
        this.openInExternalBrowser = function (o) {
            if (permissionDenied(o)) { return; }
            // url required
            if (typeof o.url !== "string") {
                mashOnError('openInExternalBrowser Error: url is not a string', o);
                return;
            }
            try {
                webclient.openInExternalBrowser(o.url);
                mashOnSuccess(o);
            } catch (e) {
                mashOnError("openInExternalBrowser Error: " + e, o);
            }
        };
        /**
         * amazon.mash.getControl
         */
        this.getControl = function (o) {
            if (permissionDenied(o)) { return; }
            // controlId required
            if (typeof o.controlId !== "string") {
                mashOnError("getControl Error: controlId is not a string", o);
                return;
            }
            if (o.controlId !== "navButtonLeft" && o.controlId !== "navButtonRight") {
                mashOnError("getControl Error: controlId must be navButtonLeft or navButtonRight", o);
                return;
            }
            var button = new ShellButton(o.controlId);
            mashOnSuccess(o);
            return button;
        };
        /**
         * amazon.mash.showImageGallery
         */
        this.showImageGallery = function (o) {
            if (permissionDenied(o)) { return; }
            if (typeof o.title !== "string") {
                mashOnError("showImageGallery Error: title is not a string", o);
                return;
            }
            if (typeof o.imageUrls !== "object" || o.imageUrls === null || o.imageUrls.constructor !== Array || o.imageUrls.length === 0) {
                // o.imageUrls has to be a non-empty array object.
                mashOnError("showImageGallery Error: imageUrls is empty or not a string-array", o);
                return;
            }
            if (o.startIndex === "undefined") {
                o.startIndex = -1;
            }
            try {
                webclient.showImageGallery(o.title, o.startIndex, o.imageUrls);
                mashOnSuccess(o);
            } catch (e) {
                mashOnError("showImageGallery Error: " + e, o);
            }
        };
        /**
         * amazon.mash.buyNowWithOneClick
         */
        this.buyNowWithOneClick = function (o) {
            if (permissionDenied(o)) { return; }
            if (typeof o.oneClickShippingSpeed !== "string") {
                mashOnError("buyNowWithOneClick Error: oneClickShippingSpeed is not a string", o);
                return;
            }
            this.buyAsin(o, "buyNowWithOneClick");
        };
        /**
         * amazon.mash.buyNow
         */
        this.buyNow = function (o) {
            if (permissionDenied(o)) { return; }
            this.buyAsin(o, "buyNow");
        };
        // Private API for buyNow & buyNowWithOneClick
        this.buyAsin = function (o, methodName) {
            if (permissionDenied(o)) { return; }
            if (typeof o.asin !== "string") {
                mashOnError(methodName + " Error: asin is not a string", o);
                return;
            }
            if (typeof o.offerId !== "string") {
                mashOnError(methodName + " Error: offerId is not a string", o);
                return;
            }
            try {
                webclient.buyAsin(o.asin, o.offerId, o.listId,
                        o.listItemId, o.dealId, o.clickStream,
                        o.oneClickShippingSpeed);
                mashOnSuccess(o);
            } catch (e) {
                mashOnError(methodName + " Error: " + e, o);
            }
        };
        /**
         * amazon.mash.addToWishList
         */
        this.addToWishList = function (o) {
            if (permissionDenied(o)) { return; }
            if (typeof o.asin !== "string") {
                mashOnError("addToWishList Error: asin is not a string", o);
                return;
            }
            try {
                webclient.addToWishList(o.asin);
                mashOnSuccess(o);
            } catch (e) {
                mashOnError("addToWishList Error: " + e, o);
            }
        };
        /**
         * amazon.mash.navigate
         */
        this.navigate = function (o) {
            if (permissionDenied(o)) { return; }
            try {
                if (!o.transitionEffect) {
                    o.transitionEffect = "slide";
                }
                webclient.navigate(o.url, o.transitionEffect, mashSaveCallback(o));
            } catch (e) {
                mashOnError("navigate Error: " + e, o);
            }
        };
        /**
         * amazon.mash.goBack
         */
        this.goBack = function (o) {
            if (permissionDenied(o)) { return; }
            try {
                webclient.goBack();
                mashOnSuccess(o);
            } catch (e) {
                mashOnError("goBack Error: " + e, o);
            }
        };
        /**
         * amazon.mash.showNotificationSettings
         */
        this.showNotificationSettings  = function (o) {
            if (permissionDenied(o)) { return; }
            try {
                webclient.showNotificationSettings(o.category);
                mashOnSuccess(o);
            } catch (e) {
                mashOnError("showNotificationSettings Error: " + e, o);
            }
        };
        /**
         * amazon.mash.showProgressDialog
         */
        this.showProgressDialog = function (o) {
            if (permissionDenied(o)) { return; }
            if (typeof o.dialogTitle !== "string") {
                mashOnError("showProgressDialog Error: dialogTitle is not a string", o);
                return;
            }
            try {
                if (typeof o.cancelCallback === "function") {
                    webclient.showProgressDialog(o.dialogTitle, mashSaveCallback({failCallback: o.cancelCallback}));
                } else {
                    webclient.showProgressDialog(o.dialogTitle, "");
                }
                mashOnSuccess(o);
            } catch (e) {
                mashOnError("showProgressDialog Error: " + e, o);
            }
        };
        /**
         * amazon.mash.hideProgressDialog
         */
        this.hideProgressDialog = function (o) {
            if (permissionDenied(o)) { return; }
            try {
                webclient.hideProgressDialog();
                mashOnSuccess(o);
            } catch (e) {
                mashOnError("hideProgressDialog Error: " + e, o);
            }
        };
        /**
         * amazon.mash.showLoginDialog
         */
        this.showLoginDialog = function (o) {
            if (permissionDenied(o)) { return; }
            try {
                var callbackId = mashSaveCallback(o);
                webclient.showLoginDialog(callbackId);
            } catch (e) {
                mashOnError("showLoginDialog Error: " + e, o);
            }
        };

        // mash argument type validation helper functions
        function isEmpty(s) {
            return (s === undefined || s === null || s === "");
        }

        //-------API 1.3.0------ 
        // amazon.mash.search
        this.search = this.search || {};

        this.search.SearchType = {
            TEXT: 1
        };

        /**
         * amazon.mash.search.registerForNotifications
         */
        this.search.registerForNotifications = function (o) {
            o = o || {};
            if (webclient === undefined) {
                mashOnErrorObject("search.RegisterForNotifications Error", {'code': mash.Error.PERMISSION_DENIED}, o);
                return;
            }
            //  notificationHandler is required.
            if (isEmpty(o.notificationHandler)
                    || typeof o.notificationHandler.onPrefetch !== "function"
                    || typeof o.notificationHandler.onShowResults !== "function") {

                mashOnErrorObject("search.RegisterForNotifications Error: notificationHandler, "
                          + "oPrefecth or onShowResults is not correct", {'code': mash.Error.INVALID_ARGUMENTS}, o);

                return;
            }

            try {
                var callbackId = mashSaveCallback({
                    successCallback : function (result) {
                        if (result.method === "register") {
                            if (o.successCallback !== undefined) {
                                o.successCallback(result.args);
                            }
                        } else if (result.method === "prefetch") {
                            o.notificationHandler.onPrefetch(result.args);
                        } else if (result.method === "showResults") {
                            o.notificationHandler.onShowResults(result.args);
                        }
                    },
                    failCallback : o.failCallback
                });
                webclient.registerForNotifications(callbackId);
            } catch (e) {
                mashOnErrorObject("search.RegisterForNotifications Error: " + e, {'code': mash.Error.UNKNOWN},  o);
            }
        };


        //-------API 1.4.0------
        // mash argument validation helper functions
        function isString(s) {
            return (typeof s === "string");
        }

        function isFunction(s) {
            return (typeof s === "function");
        }

        /**
         * amazon.mash.showContactPicker
         */
        this.showContactPicker = function (o) {
            o = o || {};

            // To return all available fields set this value to undefined. 
            if (o.fields === undefined) {
                o.fields = ["*"];
            }

            // A zero length array is invalid argument.
            if (o.fields.length === 0) {
                mashOnErrorObject("showContactPicker Invalid argument : fields", {'code': mash.Error.INVALID_ARGUMENTS}, o);
                return;
            }

            if (!isFunction(o.successCallback)) {
                mashOnErrorObject("showContactPicker Invalid argument : successCallback", {'code': mash.Error.INVALID_ARGUMENTS}, o);
                return;
            }

            exec(o.successCallback, o.failCallback, "ShowContactPicker", o.fields);
        };

        /**
         * amazon.mash.showOneClickSettings
         */
        this.showOneClickSettings = function (o) {
            o = o || {};
            exec(o.successCallback, o.failCallback, "ShowOneClickSettings", []);
        };

        /**
         * amazon.mash.launchIntentURL
         */
        this.launchIntentURL = function (o) {
            o = o || {};

            if (!isString(o.url)) {
                mashOnErrorObject("launchIntentURL Invalid arguments : url", {'code': this.Error.INVALID_ARGUMENTS}, o);
                return;
            }

            exec(o.successCallback, o.failCallback, "LaunchIntentURL", [o.url]);
        };


        /**
         * amazon.mash.canLaunchIntentURL
         */
        this.canLaunchIntentURL = function (o) {
            o = o || {};

            if (!isString(o.url)) {
                mashOnErrorObject("Invalid arguments", {'code': this.Error.INVALID_ARGUMENTS}, o);
                return;
            }

            if (!isFunction(o.successCallback)) {
                mashOnErrorObject("canLaunchIntentURL Invalid argument : successCallback", {'code': mash.Error.INVALID_ARGUMENTS}, o);
                return;
            }

            exec(function (canLaunch) {
                o.successCallback(canLaunch === "true");
            }, o.failCallback, "CanLaunchIntentURL", [o.url]);
        };


        /**
         * amazon.mash.showOfferListingPage  [Upgrade from mash v1.2]
         */
        this.showOfferListingPage = function (o) {
            o = o || {};
            if (permissionDenied(o)) { return; }
            if (!isString(o.asin)) {
                mashOnError("showOfferListingPage Invalid argument : asin", o);
                return;
            }
            exec(o.successCallback, o.failCallback, "ShowOfferListingPage", [o.asin, o.listId, o.listItemId]);
        };

        /**
         * navigator.geolocation
         * This API has already been supported by android framework. we just need enable it from the setting of web view.
         */

        /**
         * document.title
         * Android will receive the Dom's title change event, and set the Dom's title as the webview's title.
         */

        /**
         * MASH Events
         * 
         *    MASHEvent Object
         *    Field     Type     Description
         *    type        String     The type of event being fired
         *    detail     Object     An event-specific object. Check the type to understand how to read the details. 
         */

        /**
         * amazon.mash.addEventListener
         */
        this.addEventListener = function (eventName, handler) {
            var channel = cordova.require('cordova/channel');
            if (!isString(eventName)) {
                mashOnError("addEventListener eventName is invalid argument.");
                return;
            }

            if (!isFunction(handler)) {
                mashOnError("addEventListener handler is invalid argument.");
                return;
            }

            if (channel[eventName] === undefined) {
                channel.create(eventName);

                // onHasSubscribersChange is a member of Channel object.
                // this Function will be called when the first listener is subscribed, or when
                // the last listener is unsubscribed.
                channel[eventName].onHasSubscribersChange = function () {

                    if (this.numHandlers === 1) {
                        exec(function (event) {
                            channel[eventName].fire(event);
                        }, function (e) { mashOnError("AddEventListener Error: " + e.code); }, "AddEventListener", [eventName]);
                    }

                    if (this.numHandlers === 0) {
                        exec(function (event) {
                            console.log("All listeners of " + event.type + " have been removed.");
                        }, function (e) { mashOnError("RemoveEventListener Error: " + e.code); }, "RemoveEventListener", [eventName]);
                    }
                };
            }

            channel[eventName].subscribe(handler);
        };

        /**
         * amazon.mash.removeEventListener
         */
        this.removeEventListener = function (eventName, handler) {
            var channel = cordova.require('cordova/channel');
            if (!isString(eventName)) {
                mashOnError("removeEventListener eventName is invalid argument.");
                return;
            }

            if (!isFunction(handler)) {
                mashOnError("removeEventListener handler is invalid argument.");
                return;
            }

            if (channel[eventName] === undefined) {
                return;
            }

            channel[eventName].unsubscribe(handler);
        };

        /**
         * amazon.mash.dispatchEvent
         */
        this.dispatchEvent = function (o) {
            o = o || {};

            if (!isString(o.type)) {
                mashOnErrorObject("dispatchEvent Invalid argument : type", {'code': mash.Error.INVALID_ARGUMENTS}, o);
                return;
            }

            exec(o.successCallback, o.failCallback, "DispatchEvent", [o.type, o.detail]);
        };

        /**
         * amazon.mash.requestFullscreen
         */
        this.requestFullscreen = function (o) {
            o = o || {};
            exec(o.successCallback, o.failCallback, "RequestFullscreen", []);
        };

        /**
         * amazon.mash.cancelFullscreen
         */
        this.cancelFullscreen = function (o) {
            o = o || {};
            exec(o.successCallback, o.failCallback, "CancelFullscreen", []);
        };

        /**
         * amazon.mash.showDeliveryDestinationPicker
         */
        this.showDeliveryDestinationPicker = function (o) {
            o = o || {};
            try {
                exec(o.successCallback, o.failCallback, "ShowDeliveryDestinationPicker", []);
            } catch (e) {
                mashOnErrorObject("showDeliveryDestinationPicker Error: " + e, {'code': mash.Error.UNKNOWN}, o);
            }
        };

        /**
         * amazon.mash.showAdsPreferences
         */
        this.showAdsPreferences = function (o) {
            o = o || {};
            exec(o.successCallback, o.failCallback, "ShowAdsPreferences", []);
        };
        /**
         * amazon.mash.share[upgrade from MASH 1.1]
         */
        this.share = function (o) {
            if (permissionDenied(o)) { return; }
            // subject required
            if (!isString(o.subject)) {
                mashOnError("share Invalid argument : subject", o);
                return;
            }
            // messagePlain160 required, even it's not used in android app
            if (!isString(o.messagePlain160)) {
                mashOnError("share Invalid argument : messagePlain160", o);
                return;
            }
            // messagePlain140 required, even it's not used in android app
            if (!isString(o.messagePlain140)) {
                mashOnError("share Invalid argument : messagePlain140", o);
                return;
            }
            // messageHTML required, even it's not used in android app
            if (!isString(o.messageHTML)) {
                mashOnError("share Invalid argument : messageHTML", o);
                return;
            }
            // messagePlain required
            if (!isString(o.messagePlain)) {
                mashOnError("share Invalid argument : messagePlain", o);
                return;
            }

            try {
                var selectedCallback = function (sharingType) {
                    if (sharingType === "null") { sharingType = null; }
                    o.shareServiceSelectedCallback(sharingType);
                };
                exec(selectedCallback, o.failCallback, "Share", [o.messagePlain160, o.messagePlain140, o.messageHTML, o.messagePlain, o.subject, o.imageURL, o.url]);
                mashOnSuccess(o);
            } catch (e) {
                mashOnError("share Error : " + e, o);
            }
        };

        /**
         * amazon.mash.showAmazonPoints
         */
        this.showAmazonPoints = function (o) {
            o = o || {};
            exec(o.successCallback, o.failCallback, "ShowAmazonPoints", []);
        };

        //-------API 1.5.0------  
        /**
         * amazon.mash.showBarcodeScanner
         */
        this.showBarcodeScanner = function (o) {
            o = o || {};
            if (!isFunction(o.successCallback)) {
                mashOnErrorObject("showBarcodeScanner: Invalid argument : successCallback", {'code': mash.Error.INVALID_ARGUMENTS}, o);
                return;
            }
            try {
                exec(o.successCallback, o.failCallback, "ShowBarcodeScanner", []);
            } catch (e) {
                mashOnErrorObject(e.message, {'code': mash.Error.NOT_SUPPORTED}, o);
            }
        };
        /**
         * amazon.mash.showEmbeddedBrowser
         */
        this.showEmbeddedBrowser = function (o) {
            o = o || {};
            if (!isString(o.targetURL)) {
                mashOnErrorObject("showEmbeddedBrowser: Invalid argument : targetURL", {'code': mash.Error.INVALID_ARGUMENTS}, o);
                return;
            }
            if (!isFunction(o.successCallback)) {
                mashOnErrorObject("showEmbeddedBrowser: Invalid argument : successCallback", {'code': mash.Error.INVALID_ARGUMENTS}, o);
                return;
            }
            o.method = o.method || "GET";
            if (o.method !== "GET" && o.method !== "POST") {
                mashOnErrorObject("showEmbeddedBrowser: Invalid argument : method", {'code': mash.Error.INVALID_ARGUMENTS}, o);
                return;
            }
            o.postParameters = o.postParameters || {};
            o.showAmazonLogo = o.showAmazonLogo || false;
            exec(o.successCallback, o.failCallback, "ShowEmbeddedBrowser", [o.targetURL, o.method, o.postParameters, o.showAmazonLogo]);
        };
        /**
         * amazon.mash.exitEmbeddedBrowser
         */
        this.exitEmbeddedBrowser = function (o) {
            o = o || {};
            if (!isFunction(o.successCallback)) {
                mashOnErrorObject("exitEmbeddedBrowser: Invalid argument : successCallback", {'code': mash.Error.INVALID_ARGUMENTS}, o);
                return;
            }
            o.targetURL = o.targetURL || "";
            o.method = o.method || "GET";
            if (o.method !== "GET" && o.method !== "POST") {
                mashOnErrorObject("exitEmbeddedBrowser: Invalid argument : method", {'code': mash.Error.INVALID_ARGUMENTS}, o);
                return;
            }
            o.postParameters = o.postParameters || {};
            exec(o.successCallback, o.failCallback, "ExitEmbeddedBrowser", [o.targetURL, o.method, o.postParameters]);
        };
        /**
         * amazon.mash.navMenu.focusOnItem
         */
        this.navMenu = this.navMenu || {};
        this.navMenu.focusOnItem = function (o) {
            o = o || {};
            if (!isString(o.id)) {
                mashOnErrorObject("focusOnItem: Invalid argument : id", {'code': mash.Error.INVALID_ARGUMENTS}, o);
                return;
            }
            exec(o.successCallback, o.failCallback, "FocusOnItem", [o.id]);
        };

        // amazon.mash.aiv
        this.aiv = this.aiv || {};

        /**
         * whisperCache
         */
        this.aiv.whisperCache = function (o) {
            o = o || {};
            if (typeof o.asins !== "Array") {
                mashOnErrorObject("whisperCache Invalid argument : asins", {'code': mash.Error.INVALID_ARGUMENTS}, o);
                return;
            }
            exec(o.successCallback, o.failCallback, "aiv.WhisperCache", [o.asins]);
        };

        /**
         * amazon.mash.aiv.isPlaybackSustainable
         */
        this.aiv.isPlaybackSustainable = function (o) {
            o = o || {};
            if (typeof o.successCallback !== "function") {
                mashOnErrorObject("isPlaybackSustainable Invalid argument : successCallback", {'code': mash.Error.INVALID_ARGUMENTS}, o);
                return;
            }
            exec(o.successCallback, o.failCallback, "aiv.IsPlaybackSustainable", []);
        };

        /**
         * amazon.mash.aiv.startPlayback
         */
        this.aiv.startPlayback = function (o) {
            o = o || {};
            if (typeof o.asin !== "string") {
                mashOnErrorObject("startPlayback Invalid argument : asin", {'code': mash.Error.INVALID_ARGUMENTS}, o);
                return;
            }
            if (typeof o.timecode !== "number") {
                mashOnErrorObject("startPlayback Invalid argument : timecode", {'code': mash.Error.INVALID_ARGUMENTS}, o);
                return;
            }
            exec(o.successCallback, o.failCallback, "aiv.StartPlayback", [o.asin, o.timecode]);
        };

        /**
         * amazon.mash.aiv.startTrailer
         */
        this.aiv.startTrailer = function (o) {
            o = o || {};
            if (typeof o.asin !== "string") {
                mashOnErrorObject("startTrailer Invalid argument : asin", {'code': mash.Error.INVALID_ARGUMENTS}, o);
                return;
            }
            exec(o.successCallback, o.failCallback, "aiv.StartTrailer", [o.asin]);
        };
    }

    amazon.mash = new MobileAppShell();
    amazon.cordova = {
        notification : {
            // vibrate API
            vibrate : function (milliseconds) {
                if (typeof milliseconds !== "number") {
                    mashOnError("parameter 'milliseconds' is not a number");
                    return;
                }
                webclient.vibrate(milliseconds);
            }
        }
    };

    var onDeviceReady = function () {
        // Fix https://jira1.amazon.com/browse/MASH-205 
        // Use LOAD_URL mode to call back from native to JS because we have multiple webviews in our App.
        // The default ONLINE_EVENT mode can only be used in the App with only webview, which is not our case.
        var cordovaExec = cordova.require("cordova/exec");
        cordovaExec.setNativeToJsBridgeMode(cordovaExec.nativeToJsModes.LOAD_URL);

        // Declare MASH available.
        if (typeof amznJQ === 'object' && amznJQ !== null && typeof amznJQ.declareAvailable === "function") {
            amznJQ.declareAvailable('mash');
        }
        if (typeof app === 'object' && app !== null && typeof app.ready === "function") {
            app.ready();
        }
        // aui-compatibility layer
        if (typeof P === "object" && P !== null && typeof P.register === "function") {
            P.register("mash", function () {
                return window.amazon.mash;
            });
        }
    };

    // Bootstrap Cordova
    (function () {
        var head = document.head || document.getElementsByTagName('head')[0] || document.documentElement || document.getElementsByTagName('html')[0],
            script = document.createElement('script');
        script.async = 'async';
        script.onload = function () {
            var channel = window.cordova.require('cordova/channel');
            channel.onDeviceReady.subscribe(onDeviceReady);
        };
        script.src = 'content://amazon.mShop.android.AssetContentProvider/cordova.android.js';
        head.appendChild(script);
    }());

}(window.amazon));

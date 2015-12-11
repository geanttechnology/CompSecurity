// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            z, ce, cu, co, 
//            ds, bs, ea, ak, 
//            cr, bi, cv, f, 
//            h, e, dw, do, 
//            cn, aj, db, cd, 
//            da, dy, bw, cq, 
//            cj, at, ae, bp, 
//            bh, de, d, az, 
//            dq, ah, dz, aw, 
//            AdActivity, by, dv, cl, 
//            cx, l, cs

class ci
    implements z
{
    static final class a
    {

        a()
        {
        }
    }

    private static final class b extends ce.b
    {

        private final ci b;

        public final JSONObject a()
        {
            ci ci1 = b;
            if (!ci1.g.a.j.a())
            {
                ci1.a("Unable to close ad in its current state.", "close");
            }
            return null;
        }

        public b(ci ci1)
        {
            super("Close");
            b = ci1;
        }
    }

    private static final class c extends ce.b
    {

        private final ci b;

        public final JSONObject a()
        {
            ci ci1 = b;
            Object obj = cd.a(null, "description", null);
            Object obj1 = cd.a(null, "location", null);
            String s1 = cd.a(null, "summary", null);
            String s2 = cd.a(null, "start", null);
            String s3 = cd.a(null, "end", null);
            if (!at.a(14))
            {
                ci1.a.b("API version does not support calendar operations.", null);
                ci1.a("API version does not support calendar operations.", "createCalendarEvent");
                return null;
            }
            try
            {
                obj = new az(((String) (obj)), ((String) (obj1)), s1, s2, s3);
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                ci1.a.b(illegalargumentexception.getMessage(), null);
                ci1.a(illegalargumentexception.getMessage(), "createCalendarEvent");
                return null;
            }
            obj1 = (new Intent("android.intent.action.INSERT")).setType("vnd.android.cursor.item/event");
            ((Intent) (obj1)).putExtra("title", ((az) (obj)).b);
            if (!dq.a(((az) (obj)).c))
            {
                ((Intent) (obj1)).putExtra("eventLocation", ((az) (obj)).c);
            }
            if (!dq.a(((az) (obj)).d))
            {
                ((Intent) (obj1)).putExtra("description", ((az) (obj)).d);
            }
            ((Intent) (obj1)).putExtra("beginTime", ((az) (obj)).e.getTime());
            if (((az) (obj)).f != null)
            {
                ((Intent) (obj1)).putExtra("endTime", ((az) (obj)).f.getTime());
            }
            ci1.g.b().startActivity(((Intent) (obj1)));
            return null;
        }

        public c(ci ci1)
        {
            super("CreateCalendarEvent");
            b = ci1;
        }
    }

    private static final class d extends ce.b
    {

        private final ci b;

        public final JSONObject a()
        {
            Object obj = b;
            String s1 = cd.a(null, "url", null);
            if (((ci) (obj)).g.a.u())
            {
                ((ci) (obj)).a("Unable to expand an interstitial ad placement", "expand");
                return null;
            }
            if (((ci) (obj)).g.d())
            {
                ((ci) (obj)).a("Unable to expand while expanded.", "expand");
                return null;
            }
            if (!((ci) (obj)).g.c())
            {
                ((ci) (obj)).a("Unable to expand ad while it is not visible.", "expand");
                return null;
            }
            if (((ci) (obj)).d.a < 50 || ((ci) (obj)).d.b < 50)
            {
                ((ci) (obj)).a("Expand size is too small, must leave room for close.", "expand");
                return null;
            }
            bi bi1 = ((ci) (obj)).d;
            if (!dq.b(s1))
            {
                if (ea.a(s1))
                {
                    com.amazon.device.ads.f f1 = ((ci) (obj)).g;
                    obj = ((_cls1) (obj)). new cx(bi1) {

                        final bi a;
                        final ci b;

                        public final void a(String s1)
                        {
                            ci.a(b).b("mraidBridge.stateChange('expanded');");
                            ci.a(b).b("mraidBridge.ready();");
                            b.a(a, s1);
                        }

            
            {
                b = ci.this;
                a = bi1;
                super();
            }
                    };
                    f1.a.i.a(s1, true, ((cx) (obj)));
                    return null;
                } else
                {
                    ((ci) (obj)).a("Unable to expand with invalid URL.", "expand");
                    return null;
                }
            } else
            {
                ((ci) (obj)).a(bi1, null);
                return null;
            }
        }

        public d(ci ci1)
        {
            super("Expand");
            b = ci1;
        }
    }

    private static final class e extends ce.b
    {

        private final ci b;

        public final JSONObject a()
        {
            ci ci1 = b;
            if (ci1.g.a.t() == null)
            {
                ci1.a("Current position is unavailable because the ad has not yet been displayed.", "getCurrentPosition");
                return (new cv(new do(0, 0), 0, 0)).a();
            } else
            {
                return ci1.g.a.t().a();
            }
        }

        public e(ci ci1)
        {
            super("GetCurrentPosition");
            b = ci1;
        }
    }

    private static final class f extends ce.b
    {

        private final ci b;

        public final JSONObject a()
        {
            return b.f.a();
        }

        public f(ci ci1)
        {
            super("GetDefaultPosition");
            b = ci1;
        }
    }

    private static final class g extends ce.b
    {

        private final ci b;

        public final JSONObject a()
        {
            return b.d.a();
        }

        public g(ci ci1)
        {
            super("GetExpandProperties");
            b = ci1;
        }
    }

    private static final class h extends ce.b
    {

        private final ci b;

        public final JSONObject a()
        {
            do do1 = b.g.a.v();
            if (do1 == null)
            {
                return (new do(0, 0)).a();
            } else
            {
                return do1.a();
            }
        }

        public h(ci ci1)
        {
            super("GetMaxSize");
            b = ci1;
        }
    }

    private static final class i extends ce.b
    {

        private final ci b;

        public final JSONObject a()
        {
            JSONObject jsonobject = new JSONObject();
            String s1;
            if (b.g.a.u())
            {
                s1 = "interstitial";
            } else
            {
                s1 = "inline";
            }
            cd.b(jsonobject, "placementType", s1);
            return jsonobject;
        }

        public i(ci ci1)
        {
            super("GetPlacementType");
            b = ci1;
        }
    }

    private static final class j extends ce.b
    {

        private final ci b;

        public final JSONObject a()
        {
            return b.e.a;
        }

        public j(ci ci1)
        {
            super("GetResizeProperties");
            b = ci1;
        }
    }

    private static final class k extends ce.b
    {

        private final ci b;

        public final JSONObject a()
        {
            Object obj = b.g.a;
            Object obj1 = new DisplayMetrics();
            ((WindowManager)((com.amazon.device.ads.h) (obj)).b.getSystemService("window")).getDefaultDisplay().getMetrics(((DisplayMetrics) (obj1)));
            int j1 = ((DisplayMetrics) (obj1)).widthPixels;
            int i1 = ((DisplayMetrics) (obj1)).heightPixels;
            obj1 = ((com.amazon.device.ads.h) (obj)).e;
            j1 = aj.a(j1);
            obj = ((com.amazon.device.ads.h) (obj)).e;
            return (new do(j1, aj.a(i1))).a();
        }

        public k(ci ci1)
        {
            super("GetScreenSize");
            b = ci1;
        }
    }

    private static final class l extends ce.b
    {

        private final ci b;

        public final JSONObject a()
        {
            Object obj = b;
            String s1 = cd.a(null, "url", null);
            if (!((ci) (obj)).g.c())
            {
                ((ci) (obj)).a("Unable to open a URL while the ad is not visible", "open");
                return null;
            }
            ((ci) (obj)).a.b((new StringBuilder("Opening URL ")).append(s1).toString(), null);
            if (ea.a(s1))
            {
                String s2 = dz.b(s1);
                if ("http".equals(s2) || "https".equals(s2))
                {
                    by.a a1 = new by.a();
                    a1.c = ((ci) (obj)).g.b();
                    a1.e = true;
                    a1.d = s1;
                    if (a1.c == null)
                    {
                        throw new IllegalArgumentException("Context must not be null");
                    }
                    if (dq.b(a1.d))
                    {
                        throw new IllegalArgumentException("Url must not be null or white space");
                    }
                    if (!a1.b.b())
                    {
                        a1.a.d("Could not load application assets, failed to open URI: %s", new Object[] {
                            a1.d
                        });
                        return null;
                    } else
                    {
                        obj = new Intent(a1.c, com/amazon/device/ads/AdActivity);
                        ((Intent) (obj)).putExtra("adapter", com/amazon/device/ads/by.getName());
                        ((Intent) (obj)).putExtra("extra_url", a1.d);
                        ((Intent) (obj)).putExtra("extra_open_btn", a1.e);
                        ((Intent) (obj)).addFlags(0x10000000);
                        a1.c.startActivity(((Intent) (obj)));
                        return null;
                    }
                } else
                {
                    ((ci) (obj)).g.a.i.a(s1, false, null);
                    return null;
                }
            } else
            {
                s1 = (new StringBuilder("URL ")).append(s1).append(" is not a valid URL").toString();
                ((ci) (obj)).a.b(s1, null);
                ((ci) (obj)).a(s1, "open");
                return null;
            }
        }

        public l(ci ci1)
        {
            super("Open");
            b = ci1;
        }
    }

    private static final class m extends ce.b
    {

        private final ci b;

        public final JSONObject a()
        {
            ci ci1 = b;
            Object obj = cd.a(null, "url", null);
            if (!ci1.g.c())
            {
                ci1.a("Unable to play a video while the ad is not visible", "playVideo");
                return null;
            }
            if (dq.a(((String) (obj))))
            {
                ci1.a("Unable to play a video without a URL", "playVideo");
                return null;
            }
            try
            {
                Bundle bundle = new Bundle();
                bundle.putString("url", ((String) (obj)));
                obj = new Intent(ci1.g.b(), com/amazon/device/ads/AdActivity);
                ((Intent) (obj)).putExtra("adapter", com/amazon/device/ads/dv.getName());
                ((Intent) (obj)).putExtras(bundle);
                ci1.g.b().startActivity(((Intent) (obj)));
            }
            catch (ActivityNotFoundException activitynotfoundexception)
            {
                ci1.a.b("Failed to open VideoAction activity", null);
                ci1.a("Internal SDK Failure. Unable to launch VideoActionHandler", "playVideo");
                return null;
            }
            return null;
        }

        public m(ci ci1)
        {
            super("PlayVideo");
            b = ci1;
        }
    }

    private static final class n extends ce.b
    {

        private final ci b;

        public final JSONObject a()
        {
            ci ci1 = b;
            if (ci1.g.a.u())
            {
                ci1.a("Unable to resize an interstitial ad placement.", "resize");
            } else
            if (ci1.g.d())
            {
                ci1.a("Unable to resize while expanded.", "resize");
            } else
            if (!ci1.g.c())
            {
                ci1.a("Unable to resize ad while it is not visible.", "resize");
            } else
            if (ci1.e == null)
            {
                ci1.a("Resize properties must be set before calling resize.", "resize");
            } else
            if (ci1.e.a() < 50 || ci1.e.b() < 50)
            {
                ci1.a("Resize width and height must be at least 50 dp in order to fit the close button.", "resize");
            } else
            {
                db db1 = ci1.e;
                int j1 = db1.a();
                int i1 = db1.b();
                Object obj = ci1.h;
                j1 = aj.b(j1);
                obj = ci1.h;
                obj = new do(j1, aj.b(i1));
                ci1.i.a(ci1. new Runnable(db1, ((do) (obj))) {

                    final db a;
                    final do b;
                    final ci c;

                    public final void run()
                    {
                        ci.a(c, a, b);
                    }

            
            {
                c = ci.this;
                a = db1;
                b = do1;
                super();
            }
                }, ds.b.a, ds.c.a);
            }
            return null;
        }

        public n(ci ci1)
        {
            super("Resize");
            b = ci1;
        }
    }

    private static final class o extends ce.b
    {

        private final ci b;

        public final JSONObject a()
        {
            ci ci1 = b;
            int i1 = cd.a(null, "width", 0);
            int j1 = cd.a(null, "height", 0);
            boolean flag = cd.a(null, "useCustomClose", false);
            ci1.d.a = i1;
            ci1.d.b = j1;
            ci1.a(flag);
            return null;
        }

        public o(ci ci1)
        {
            super("SetExpandProperties");
            b = ci1;
        }
    }

    private static final class p extends ce.b
    {

        private final ci b;

        public final JSONObject a()
        {
            ci ci1 = b;
            boolean flag = cd.a(null, "allowOrientationChange", false);
            String s1 = cd.a(null, "forceOrientation", null);
            if (ci1.g.a.u() && !ci1.g.d())
            {
                com.amazon.device.ads.h h1 = ci1.g.a;
                if (!h1.G)
                {
                    h1.G = true;
                    h1.f.a(ck.a.ae);
                }
            }
            ci1.c.a = Boolean.valueOf(flag);
            if (!dq.a(s1))
            {
                try
                {
                    bp bp1 = bp.valueOf(s1.toUpperCase(Locale.US));
                    ci1.c.b = bp1;
                }
                catch (IllegalArgumentException illegalargumentexception)
                {
                    ci1.a.c((new StringBuilder("Not a valid orientation to force:")).append(s1).toString(), null);
                }
            }
            ci1.g();
            return null;
        }

        public p(ci ci1)
        {
            super("SetOrientationProperties");
            b = ci1;
        }
    }

    private static final class q extends ce.b
    {

        private final ci b;

        public final JSONObject a()
        {
            ci ci1 = b;
            int i1 = cd.a(null, "width", 0);
            int j1 = cd.a(null, "height", 0);
            int k1 = cd.a(null, "offsetX", 0);
            int l1 = cd.a(null, "offsetY", 0);
            String s1 = cd.a(null, "customClosePosition", null);
            boolean flag = cd.a(null, "allowOffscreen", false);
            if (ci1.e == null)
            {
                ci1.e = new db();
            }
            db db1 = ci1.e;
            Boolean boolean1 = Boolean.valueOf(flag);
            if (boolean1 != null)
            {
                cd.b(db1.a, "allowOffscreen", boolean1.booleanValue());
            }
            db1 = ci1.e;
            if (s1 != null)
            {
                cd.b(db1.a, "customClosePosition", s1);
            }
            cd.b(ci1.e.a, "width", i1);
            cd.b(ci1.e.a, "height", j1);
            cd.b(ci1.e.a, "offsetX", k1);
            cd.b(ci1.e.a, "offsetY", l1);
            return null;
        }

        public q(ci ci1)
        {
            super("SetResizeProperties");
            b = ci1;
        }
    }

    private static final class r extends ce.b
    {

        private final ci b;

        public final JSONObject a()
        {
            ci ci1 = b;
            String s1 = cd.a(null, "url", null);
            cu cu1 = ci1.b;
            if (!cu.a(ci1.g.b(), "android.permission.WRITE_EXTERNAL_STORAGE"))
            {
                ci1.a("Picture could not be stored because permission was denied.", "storePicture");
                return null;
            } else
            {
                ci1.i.a(ci1. new Runnable(s1) {

                    final String a;
                    final ci b;

                    public final void run()
                    {
                        ci.a(b, a);
                    }

            
            {
                b = ci.this;
                a = s1;
                super();
            }
                }, ds.b.a, ds.c.b);
                return null;
            }
        }

        public r(ci ci1)
        {
            super("StorePicture");
            b = ci1;
        }
    }

    private static final class s extends ce.b
    {

        private final ci b;

        public final JSONObject a()
        {
            return b.e();
        }

        public s(ci ci1)
        {
            super("Supports");
            b = ci1;
        }
    }

    private static final class t extends ce.b
    {

        private final ci b;

        public final JSONObject a()
        {
            b.a(cd.a(null, "useCustomClose", false));
            return null;
        }

        public t(ci ci1)
        {
            super("UseCustomClose");
            b = ci1;
        }
    }


    private static final String j = com/amazon/device/ads/ci.getSimpleName();
    private static final String k = (new StringBuilder("(function (window, console) {\n    var is_array = function (obj) {\n        return Object.prototype.toString.call(obj) === '[object Array]';\n    },\n    forEach = function (array, fn) {\n        var i;\n        for (i = 0; i < array.length; i++) {\n            if (i in array) {\n                fn.call(null, array[i], i);\n            }\n        }\n    },\n    events = {\n            error: 'error',\n            ready: 'ready',\n            sizeChange: 'sizeChange',\n            stateChange: 'stateChange',\n            viewableChange: 'viewableChange'\n    },\n    states = [\"loading\",\"default\",\"expanded\",\"resized\",\"hidden\"],\n    placementTypes = [\"inline\", \"interstitial\"],\n    listeners = [],\n    version = '2.0',\n    currentState = \"loading\",\n    supportedFeatures = null,\n    orientationProperties = {\"allowOrientationChange\":true,\"forceOrientation\":\"none\"},\n    // Error Event fires listeners\n    invokeListeners = function(event, args) {\n        var eventListeners = listeners[event] || [];\n        // fire all the listeners\n        forEach(eventListeners, function(listener){\n            try {\n                listener.apply(null, args);\n            }catch(e){\n                debug(\"Error executing \" + event + \" listener\");\n                debug(e);\n            }\n        });\n    },\n    debug = function(msg) {\n        console.log(\"MRAID log: \" + msg);\n    },\n    readyEvent = function() {\n        debug(\"MRAID ready\");\n        invokeListeners(\"ready\");\n    },\n    errorEvent = function(message, action) {\n        debug(\"error: \" + message + \" action: \" + action);\n        var args = [message, action];\n        invokeListeners(\"error\", args);\n    },\n    stateChangeEvent = function(state) {\n        debug(\"stateChange: \" + state);\n        var args = [state];\n        currentState = state;\n        invokeListeners(\"stateChange\", args);\n    },\n    viewableChangeEvent = function(viewable) {\n        debug(\"viewableChange: \" + viewable);\n        var args = [viewable];\n        invokeListeners(\"viewableChange\", args);\n    }, \n    sizeChangeEvent = function(width, height) {\n        debug(\"sizeChange: \" + width + \"x\" + height);\n        var args = [width, height];\n        invokeListeners(\"sizeChange\", args);\n    };\n    window.mraidBridge = {\n            error : errorEvent,\n            ready : readyEvent,\n            stateChange : stateChangeEvent,\n            sizeChange : sizeChangeEvent,\n            viewableChange : viewableChangeEvent\n    };\n    // Define the mraid object\n    window.mraid = {\n            // Command Flow\n            addEventListener : function(event, listener){\n                var eventListeners = listeners[event] || [],\n                alreadyRegistered = false;\n                \n                //verify the event is one that will actually occur\n                if (!events.hasOwnProperty(event)){\n                    return;\n                }\n                \n                //register first set of listeners for this event\n                if (!is_array(listeners[event])) {\n                    listeners[event] = eventListeners;\n                }\n                \n                forEach(eventListeners, function(l){ \n                    // Listener already registered, so no need to add it.\n                        if (listener === l){\n                            alreadyRegistered = true;\n                        }\n                    }\n                );\n                if (!alreadyRegistered){\n                    listeners[event].push(listener);\n                }\n            },\n            removeEventListener : function(event, listener){\n                if (listeners.hasOwnProperty(event)) {\n                    var eventListeners = listeners[event];\n                    if (eventListeners) {\n                        var idx = eventListeners.indexOf(listener);\n                        if (idx !== -1) {\n                            eventListeners.splice(idx, 1);\n                        }\n                    }\n                }\n            },\n            useCustomClose: function(bool){\n                mraidObject.")).append(ce.a()).append("(\"UseCustomClose\", JSON.stringify({useCustomClose: bool}));\n            },\n            // Support\n            supports: function(feature){\n                if (!supportedFeatures)\n                {\n                    supportedFeatures = JSON.parse(mraidObject.").append(ce.a()).append("(\"Supports\", null));\n                }\n                return supportedFeatures[feature];\n            },\n            // Properties\n            getVersion: function(){\n                return version;\n            },\n            getState: function(){\n                return currentState;\n            },\n            getPlacementType: function(){\n                var json = JSON.parse(mraidObject.").append(ce.a()).append("(\"GetPlacementType\", null));\n                return json.placementType;\n            },\n            isViewable: function(){\n                // TODO - should we ask the OS if the widget is visible.\n                return currentState !== \"hidden\" && currentState !== \"loading\";\n            },\n            getExpandProperties: function(){\n                return JSON.parse(mraidObject.").append(ce.a()).append("(\"GetExpandProperties\", null));\n            },\n            setExpandProperties: function(properties){\n                var currentProperties = mraid.getExpandProperties(),\n                //properties aren't all required, map to existing value if not set.\n                width = properties.hasOwnProperty('width') ? properties.width : currentProperties.width,\n                height = properties.hasOwnProperty('height') ? properties.height : currentProperties.height,\n                useClose = properties.hasOwnProperty('useCustomClose') ? properties.useCustomClose : currentProperties.useCustomClose;\n                //Backwards compatibility with MRAID 1.0 creatives\n                if (!!properties.lockOrientation){\n                    mraid.setOrientationProperties({\"allowOrientationChange\":false});\n                }\n                mraidObject.").append(ce.a()).append("(\"SetExpandProperties\", JSON.stringify({\n                        width: width, \n                        height: height, \n                        useClose: useClose}));\n            },\n            getOrientationProperties: function(){\n                return orientationProperties;\n            },\n            setOrientationProperties: function(properties){\n                if (properties.hasOwnProperty(\"allowOrientationChange\")) {\n                    orientationProperties.allowOrientationChange = properties.allowOrientationChange;\n                }\n                if (properties.hasOwnProperty(\"forceOrientation\")) {\n                    orientationProperties.forceOrientation = properties.forceOrientation;\n                }\n                mraidObject.").append(ce.a()).append("(\"SetOrientationProperties\", JSON.stringify({\n                        allowOrientationChange: orientationProperties.allowOrientationChange, \n                        forceOrientation: orientationProperties.forceOrientation}));\n            },\n            getResizeProperties: function(){\n                return JSON.parse(mraidObject.").append(ce.a()).append("(\"GetResizeProperties\", null));\n            },\n            setResizeProperties: function(properties){\n                if (!properties.customClosePosition){\n                   properties.customClosePosition = null;\n                }\n                if (!properties.hasOwnProperty('allowOffscreen')){\n                   properties.allowOffscreen = true;\n                }\n                mraidObject.").append(ce.a()).append("(\"SetResizeProperties\", JSON.stringify({\n                        width: properties.width, \n                        height: properties.height, \n                        offsetX: properties.offsetX, \n                        offsetY: properties.offsetY, \n                        customClosePosition: properties.customClosePosition, \n                        allowOffscreen: properties.allowOffscreen}));\n            },\n            getCurrentPosition: function(){\n                return JSON.parse(mraidObject.").append(ce.a()).append("(\"GetCurrentPosition\", null));\n            },\n            getMaxSize: function(){\n                return JSON.parse(mraidObject.").append(ce.a()).append("(\"GetMaxSize\", null));\n            },\n            getDefaultPosition: function(){\n                return JSON.parse(mraidObject.").append(ce.a()).append("(\"GetDefaultPosition\", null));\n            },\n            getScreenSize: function(){\n                return JSON.parse(mraidObject.").append(ce.a()).append("(\"GetScreenSize\", null));\n            },\n            // Operations\n            open: function(url) {\n                mraidObject.").append(ce.a()).append("(\"Open\", JSON.stringify({url: url}));\n            },\n            close: function() {\n                mraidObject.").append(ce.a()).append("(\"Close\", null);\n            },\n            expand: function(url) {\n                if (url !== undefined) {\n                    mraidObject.").append(ce.a()).append("(\"Expand\", JSON.stringify({url: url}));\n                } else {\n                    mraidObject.").append(ce.a()).append("(\"Expand\", JSON.stringify({url: \"\"}));\n                }\n            },\n            resize: function() {\n                mraidObject.").append(ce.a()).append("(\"Resize\", null);\n            },\n            createCalendarEvent: function(eventObject) {\n                mraidObject.").append(ce.a()).append("(\"CreateCalendarEvent\", JSON.stringify({\n                        description: eventObject.description || null, \n                        location: eventObject.customClosePosition || null, \n                        summary: eventObject.summary || null, \n                        start: eventObject.start || null, \n                        end: eventObject.end || null}));\n            },\n            playVideo: function(url){\n                mraidObject.").append(ce.a()).append("(\"PlayVideo\", JSON.stringify({url: url}));\n            },\n            storePicture: function(url){\n                mraidObject.").append(ce.a()).append("(\"StorePicture\", JSON.stringify({url: url}));\n            }\n    };\n})(window, console);\n").toString();
    final cn a;
    final cu b;
    final cr c;
    final bi d;
    db e;
    final cv f;
    final com.amazon.device.ads.f g;
    final ak h;
    final ds.k i;
    private final dy.d l;
    private boolean m;
    private de n;
    private final ce o;
    private final ea p;
    private final bs q;
    private final a r;
    private ViewGroup s;
    private ViewGroup t;
    private FrameLayout u;
    private ViewGroup v;

    ci(com.amazon.device.ads.f f1, ce ce1)
    {
        cu cu1 = new cu();
        new co();
        this(f1, ce1, cu1, new dy.d(), ds.a(), new bs(), new a(), new ea(), new ak());
    }

    private ci(com.amazon.device.ads.f f1, ce ce1, cu cu1, dy.d d1, ds.k k1, bs bs1, a a1, 
            ea ea1, ak ak1)
    {
        c = new cr();
        d = new bi();
        f = new cv();
        m = true;
        g = f1;
        o = ce1;
        a = co.a(j);
        b = cu1;
        l = d1;
        i = k1;
        q = bs1;
        r = a1;
        p = ea1;
        h = ak1;
        o.a(new b(this));
        o.a(new c(this));
        o.a(new d(this));
        o.a(new e(this));
        o.a(new f(this));
        o.a(new g(this));
        o.a(new h(this));
        o.a(new i(this));
        o.a(new j(this));
        o.a(new k(this));
        o.a(new l(this));
        o.a(new m(this));
        o.a(new n(this));
        o.a(new o(this));
        o.a(new p(this));
        o.a(new q(this));
        o.a(new r(this));
        o.a(new s(this));
        o.a(new t(this));
    }

    static com.amazon.device.ads.f a(ci ci1)
    {
        return ci1.g;
    }

    static void a(ci ci1, Bitmap bitmap)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(ci1.g.b());
        builder.setTitle("Would you like to save the image to your gallery?");
        builder.setPositiveButton("Yes", ci1. new android.content.DialogInterface.OnClickListener(bitmap) {

            final Bitmap a;
            final ci b;

            public final void onClick(DialogInterface dialoginterface, int i1)
            {
                ci.c(b);
                dialoginterface = bs.a(ci.b(b), a, "AdImage", "Image created by rich media ad.");
                if (dq.a(dialoginterface))
                {
                    ci.a(b, "Picture could not be stored to device.", "storePicture");
                    return;
                } else
                {
                    MediaScannerConnection.scanFile(ci.b(b), new String[] {
                        dialoginterface
                    }, null, null);
                    return;
                }
            }

            
            {
                b = ci.this;
                a = bitmap;
                super();
            }
        });
        builder.setNegativeButton("No", ci1. new android.content.DialogInterface.OnClickListener() {

            final ci a;

            public final void onClick(DialogInterface dialoginterface, int i1)
            {
            }

            
            {
                a = ci.this;
                super();
            }
        });
        builder.show();
    }

    static void a(ci ci1, bi bi1, String s1)
    {
        int i1;
        int j1;
        boolean flag;
        if (s1 != null)
        {
            dw dw1 = ci1.g.a.a().a;
            if (dw1.e != null)
            {
                dw1.a(new WebView[] {
                    dw1.e
                });
            }
            dw1.e = dw1.d;
            Object obj;
            if (dw1.f == null)
            {
                obj = dw1.a(dw1.a.getContext());
                ((WebView) (obj)).setContentDescription("newWebView");
            } else
            {
                obj = dw1.f;
                dw1.f = dw1.a(dw1.a.getContext());
            }
            dw1.a(((WebView) (obj)), false);
            ci1.m = true;
        } else
        {
            ci1.m = false;
        }
        obj = ci1.g.a.v();
        if (s1 != null && obj != null)
        {
            i1 = ((do) (obj)).a;
        } else
        {
            i1 = bi1.a;
        }
        if (s1 != null && obj != null)
        {
            j1 = ((do) (obj)).b;
        } else
        {
            j1 = bi1.b;
        }
        ci1.a.b((new StringBuilder("Expanding Ad to ")).append(i1).append("x").append(j1).toString(), null);
        s1 = new do(aj.b(i1), aj.b(j1));
        ci1.u = (FrameLayout)((Activity)ci1.g.b()).findViewById(0x1020002);
        ci1.s = new RelativeLayout(ci1.g.b());
        ci1.s.setContentDescription("expansionView");
        obj = new View(ci1.g.b());
        ((View) (obj)).setBackgroundColor(0);
        ((View) (obj)).setContentDescription("dimmingView");
        ((View) (obj)).setOnTouchListener(ci1. new android.view.View.OnTouchListener() {

            final ci a;

            public final boolean onTouch(View view, MotionEvent motionevent)
            {
                return true;
            }

            
            {
                a = ci.this;
                super();
            }
        });
        ci1.s.addView(((View) (obj)), new android.widget.RelativeLayout.LayoutParams(-1, -1));
        ci1.t = new FrameLayout(ci1.g.b());
        ci1.t.setContentDescription("adContainerView");
        ci1.g.a(ci1.t, new android.widget.RelativeLayout.LayoutParams(-1, -1), true);
        s1 = new android.widget.RelativeLayout.LayoutParams(((do) (s1)).a, ((do) (s1)).b);
        s1.addRule(13);
        ci1.s.addView(ci1.t, s1);
        ci1.u.addView(ci1.s, new android.widget.RelativeLayout.LayoutParams(-1, -1));
        s1 = ci1.g;
        if (!bi1.c.booleanValue())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        s1.a(flag, null);
        ci1.u.getViewTreeObserver().addOnGlobalLayoutListener(ci1. new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

            final ci a;
            private boolean b;

            public final void onGlobalLayout()
            {
                if (!b)
                {
                    b = true;
                    ci.d(a).b("Expand ViewTreeObserver fired", null);
                    ci.a(a).a(new com.amazon.device.ads.l(l.a.a));
                    ci.a(a).a("mraidBridge.stateChange('expanded');");
                    a.f();
                    a.g();
                }
            }

            
            {
                a = ci.this;
                super();
                b = false;
            }
        });
    }

    static void a(ci ci1, db db1, do do1)
    {
        Object obj;
        int j2;
        int k2;
        int l2;
        int i3;
        if (ci1.v == null)
        {
            if (ci1.u == null)
            {
                ci1.u = (FrameLayout)((Activity)ci1.g.b()).findViewById(0x1020002);
            }
            ci1.v = new RelativeLayout(ci1.g.b());
            ci1.v.setContentDescription("resizedView");
        }
        k2 = aj.b(ci1.f.b + cd.a(db1.a, "offsetX", 0));
        j2 = aj.b(ci1.f.c + cd.a(db1.a, "offsetY", 0));
        obj = db1.a;
        db1.getClass();
        obj = da.a(cd.a(((JSONObject) (obj)), "customClosePosition", "top-right"));
        do do2 = ci1.g.a.v();
        i3 = aj.b(do2.a);
        l2 = aj.b(do2.b);
        if (Boolean.valueOf(cd.a(db1.a, "allowOffscreen", db1.b.booleanValue())).booleanValue()) goto _L2; else goto _L1
_L1:
        int k1;
        if (do1.a > i3)
        {
            do1.a = i3;
        }
        if (do1.b > l2)
        {
            do1.b = l2;
        }
        int i1;
        if (k2 < 0)
        {
            i1 = 0;
        } else
        {
            i1 = k2;
            if (do1.a + k2 > i3)
            {
                i1 = i3 - do1.a;
            }
        }
        if (j2 < 0)
        {
            k1 = 0;
            k2 = i1;
        } else
        {
            k1 = j2;
            k2 = i1;
            if (do1.b + j2 > l2)
            {
                k1 = l2 - do1.b;
                k2 = i1;
            }
        }
_L11:
        db1 = new android.widget.RelativeLayout.LayoutParams(do1.a, do1.b);
        ci1.g.a(ci1.v, db1, false);
        db1 = new android.widget.FrameLayout.LayoutParams(do1.a, do1.b);
        db1.gravity = 48;
        db1.leftMargin = k2;
        db1.topMargin = k1;
        static final class _cls5
        {

            static final int a[];
            static final int b[];

            static 
            {
                b = new int[bp.values().length];
                try
                {
                    b[bp.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    b[bp.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    b[bp.c.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                a = new int[da.values().length];
                try
                {
                    a[da.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    a[da.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[da.f.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[da.d.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[da.e.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[da.g.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[da.c.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        int j1;
        int l1;
        int i2;
        int j3;
        if (ci1.u.equals(ci1.v.getParent()))
        {
            ci1.v.setLayoutParams(db1);
        } else
        {
            ci1.u.addView(ci1.v, db1);
        }
        ci1.g.a(false, ((da) (obj)));
        ci1.u.getViewTreeObserver().addOnGlobalLayoutListener(ci1. new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

            final ci a;
            private boolean b;

            public final void onGlobalLayout()
            {
                if (!b)
                {
                    b = true;
                    int ai[] = new int[2];
                    ci.e(a).getLocationOnScreen(ai);
                    Rect rect = new Rect(ai[0], ai[1], ai[0] + ci.e(a).getWidth(), ai[1] + ci.e(a).getHeight());
                    com.amazon.device.ads.l l3 = new com.amazon.device.ads.l(l.a.d);
                    l3.b.a.put("positionOnScreen", rect);
                    ci.a(a).a(l3);
                    ci.a(a).a("mraidBridge.stateChange('resized');");
                    a.f();
                }
            }

            
            {
                a = ci.this;
                super();
                b = false;
            }
        });
        return;
_L2:
        j3 = aj.b(50);
        _cls5.a[((da) (obj)).ordinal()];
        JVM INSTR tableswitch 1 7: default 484
    //                   1 543
    //                   2 568
    //                   3 598
    //                   4 635
    //                   5 665
    //                   6 700
    //                   7 742;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L10:
        break MISSING_BLOCK_LABEL_742;
_L3:
        j1 = 0;
        k1 = 0;
        l1 = 0;
        i2 = 0;
_L12:
        if (i2 < 0 || k1 < 0 || l1 > l2 || j1 > i3)
        {
            j1 = 0;
        } else
        {
            j1 = 1;
        }
        k1 = j2;
        if (j1 == 0)
        {
            ci1.a("Resize failed because close event area must be entirely on screen.", "resize");
            return;
        }
          goto _L11
_L4:
        j1 = k2 + j3;
        l1 = j2 + j3;
        i2 = j2;
        k1 = k2;
          goto _L12
_L5:
        j1 = do1.a + k2;
        l1 = j2 + j3;
        k1 = j1 - j3;
        i2 = j2;
          goto _L12
_L6:
        k1 = (do1.a / 2 + k2) - j3 / 2;
        l1 = j2 + j3;
        j1 = k1 + j3;
        i2 = j2;
          goto _L12
_L7:
        l1 = j2 + do1.b;
        j1 = k2 + j3;
        i2 = l1 - j3;
        k1 = k2;
          goto _L12
_L8:
        l1 = j2 + do1.b;
        j1 = do1.a + k2;
        i2 = l1 - j3;
        k1 = j1 - j3;
          goto _L12
_L9:
        l1 = j2 + do1.b;
        k1 = (do1.a / 2 + k2) - j3 / 2;
        i2 = l1 - j3;
        j1 = k1 + j3;
          goto _L12
        i2 = (do1.b / 2 + j2) - j3 / 2;
        k1 = (do1.a / 2 + k2) - j3 / 2;
        l1 = i2 + j3;
        j1 = k1 + j3;
          goto _L12
    }

    static void a(ci ci1, com.amazon.device.ads.f f1)
    {
        ci1.u = (FrameLayout)((Activity)ci1.g.b()).findViewById(0x1020002);
        if (ci1.m)
        {
            ci1.a.b("Expanded With URL", null);
            dw dw1 = f1.a.a().a;
            if (dw1.e != null)
            {
                WebView webview = dw1.e;
                dw1.e = null;
                dw1.a(webview, true);
            }
        } else
        {
            ci1.a.b("Not Expanded with URL", null);
        }
        if (ci1.s == null)
        {
            Object obj = ci1.g.a;
            com.amazon.device.ads.h h1;
            ViewGroup viewgroup;
            if (((com.amazon.device.ads.h) (obj)).B != null && ((com.amazon.device.ads.h) (obj)).B != ((com.amazon.device.ads.h) (obj)).a().getParent())
            {
                obj = ((com.amazon.device.ads.h) (obj)).s();
            } else
            {
                obj = null;
            }
            if (obj != null && "adContainerView".equals(((ViewGroup) (obj)).getContentDescription()))
            {
                obj = (ViewGroup)((ViewGroup) (obj)).getParent();
                if (obj != null && "expansionView".equals(((ViewGroup) (obj)).getContentDescription()))
                {
                    ci1.s = ((ViewGroup) (obj));
                }
            }
        }
        obj = new android.widget.FrameLayout.LayoutParams(-1, -1, 17);
        h1 = f1.a;
        viewgroup = (ViewGroup)h1.a().getParent();
        if (viewgroup != null)
        {
            viewgroup.removeView(h1.a());
        }
        h1.i();
        if (h1.B != null)
        {
            h1.B.addView(h1.a(), ((android.view.ViewGroup.LayoutParams) (obj)));
        }
        h1.a().a(null);
        h1.b(false);
        f1.a();
        if (ci1.s != null)
        {
            ci1.u.removeView(ci1.s);
        }
        if (ci1.v != null)
        {
            ci1.u.removeView(ci1.v);
        }
        ci1.u.getViewTreeObserver().addOnGlobalLayoutListener(ci1. new android.view.ViewTreeObserver.OnGlobalLayoutListener(f1) {

            final com.amazon.device.ads.f a;
            final ci b;
            private boolean c;

            public final void onGlobalLayout()
            {
                if (!c)
                {
                    c = true;
                    a.a(new com.amazon.device.ads.l(l.a.b));
                    a.a("mraidBridge.stateChange('default');");
                    b.f();
                }
            }

            
            {
                b = ci.this;
                a = f1;
                super();
                c = false;
            }
        });
    }

    static void a(ci ci1, String s1)
    {
        dy dy1 = ci1.l.a();
        dy1.e();
        dy1.c(s1);
        try
        {
            s1 = dy1.c();
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            ci1.a("Server could not be contacted to download picture.", "storePicture");
            return;
        }
        if (s1 == null)
        {
            ci1.a("Server could not be contacted to download picture.", "storePicture");
            return;
        }
        s1 = (new bw(s1.a(), ci1.q)).a();
        if (s1 == null)
        {
            ci1.a("Picture could not be retrieved from server.", "storePicture");
            return;
        } else
        {
            ci1.i.a(ci1. new Runnable(s1) {

                final Bitmap a;
                final ci b;

                public final void run()
                {
                    ci.a(b, a);
                }

            
            {
                b = ci.this;
                a = bitmap;
                super();
            }
            }, ds.b.b, ds.c.a);
            return;
        }
    }

    static void a(ci ci1, String s1, String s2)
    {
        ci1.a(s1, s2);
    }

    static Context b(ci ci1)
    {
        return ci1.g.b();
    }

    static bs c(ci ci1)
    {
        return ci1.q;
    }

    static cn d(ci ci1)
    {
        return ci1.a;
    }

    static ViewGroup e(ci ci1)
    {
        return ci1.v;
    }

    public final ce.a a()
    {
        return o.a;
    }

    final void a(bi bi1, String s1)
    {
        i.a(new Runnable(bi1, s1) {

            final bi a;
            final String b;
            final ci c;

            public final void run()
            {
                ci.a(c, a, b);
            }

            
            {
                c = ci.this;
                a = bi1;
                b = s1;
                super();
            }
        }, ds.b.a, ds.c.a);
    }

    final void a(String s1, String s2)
    {
        g.a(String.format(Locale.US, "mraidBridge.error('%s', '%s');", new Object[] {
            s1, s2
        }));
    }

    public final void a(boolean flag)
    {
        Object obj;
label0:
        {
            d.c = Boolean.valueOf(flag);
            obj = g;
            boolean flag1;
            if (!flag)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            obj = ((com.amazon.device.ads.f) (obj)).a.a().b;
            if (((cq) (obj)).h && ((cq) (obj)).b != null)
            {
                if (!flag1)
                {
                    break label0;
                }
                ((cq) (obj)).a(true, null);
            }
            return;
        }
        ((cq) (obj)).a();
    }

    public final String b()
    {
        return "mraidObject";
    }

    public final String c()
    {
        return k;
    }

    public final de d()
    {
        if (n == null)
        {
            n = new cj(this);
        }
        return n;
    }

    public final JSONObject e()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("sms", g.b().getPackageManager().hasSystemFeature("android.hardware.telephony"));
            jsonobject.put("tel", g.b().getPackageManager().hasSystemFeature("android.hardware.telephony"));
            jsonobject.put("calendar", at.a(14));
            jsonobject.put("storePicture", cu.a(g.b(), "android.permission.WRITE_EXTERNAL_STORAGE"));
            jsonobject.put("inlineVideo", at.a(11));
        }
        catch (JSONException jsonexception)
        {
            return jsonobject;
        }
        return jsonobject;
    }

    final void f()
    {
        cv cv1 = g.a.t();
        if (cv1 != null)
        {
            g.a((new StringBuilder("mraidBridge.sizeChange(")).append(cv1.a.a).append(",").append(cv1.a.b).append(");").toString());
        }
    }

    final void g()
    {
        if (g.c() && g.d()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        cv cv1;
        Object obj;
        int i1;
        obj = (Activity)g.b();
        i1 = ((Activity) (obj)).getRequestedOrientation();
        cv1 = g.a.t();
        a.b((new StringBuilder("Current Orientation: ")).append(i1).toString(), null);
        if (ae.h.equals(g.a.x)) goto _L4; else goto _L3
_L3:
        _cls5.b[c.b.ordinal()];
        JVM INSTR tableswitch 1 2: default 128
    //                   1 282
    //                   2 290;
           goto _L4 _L5 _L6
_L4:
        int j1;
        if (ae.h.equals(g.a.x) || bp.c.equals(c.b))
        {
            if (c.a.booleanValue())
            {
                if (((Activity)g.b()).getRequestedOrientation() != -1)
                {
                    ((Activity)g.b()).setRequestedOrientation(-1);
                }
            } else
            if (g.d())
            {
                ((Activity) (obj)).setRequestedOrientation(bh.a(((Context) (obj))));
            }
        }
        j1 = ((Activity) (obj)).getRequestedOrientation();
        a.b((new StringBuilder("New Orientation: ")).append(j1).toString(), null);
        if (j1 != i1 && cv1 != null)
        {
            obj = g.a.t();
            if (cv1.a.a != ((cv) (obj)).a.a)
            {
                f();
                return;
            }
        }
        if (true) goto _L1; else goto _L5
_L5:
        ((Activity) (obj)).setRequestedOrientation(1);
          goto _L4
_L6:
        ((Activity) (obj)).setRequestedOrientation(0);
          goto _L4
    }


    // Unreferenced inner class com/amazon/device/ads/ci$10

/* anonymous class */
    final class _cls10
        implements Runnable
    {

        final com.amazon.device.ads.f a;
        final ci b;

        public final void run()
        {
            ci.a(b, a);
        }

            
            {
                b = ci.this;
                a = f1;
                super();
            }
    }

}

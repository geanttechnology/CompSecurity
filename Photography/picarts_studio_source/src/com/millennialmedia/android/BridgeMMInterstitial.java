// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.lang.ref.WeakReference;
import java.util.Map;

// Referenced classes of package com.millennialmedia.android:
//            MMJSObject, MMWebView, MMLayout, MMJSResponse, 
//            OverlaySettings, MMLog, AdViewOverlayActivity, AdViewOverlayView

class BridgeMMInterstitial extends MMJSObject
{

    private static final String a = com/millennialmedia/android/BridgeMMInterstitial.getName();

    BridgeMMInterstitial()
    {
    }

    final MMJSResponse a(String s, Map map)
    {
        MMJSResponse mmjsresponse = null;
        if ("close".equals(s))
        {
            mmjsresponse = close(map);
        } else
        {
            if ("expandToExternalBrowser".equals(s))
            {
                return expandToExternalBrowser(map);
            }
            if ("expandWithProperties".equals(s))
            {
                return expandWithProperties(map);
            }
            if ("open".equals(s))
            {
                return open(map);
            }
            if ("setOrientation".equals(s))
            {
                return setOrientation(map);
            }
            if ("useCustomClose".equals(s))
            {
                return useCustomClose(map);
            }
        }
        return mmjsresponse;
    }

    public MMJSResponse close(Map map)
    {
        map = (MMWebView)c.get();
        if (map != null)
        {
            map.g().a();
            return MMJSResponse.a();
        } else
        {
            return null;
        }
    }

    public MMJSResponse expandToExternalBrowser(Map map)
    {
        return open(map);
    }

    public MMJSResponse expandWithProperties(Map map)
    {
        Object obj = (String)map.get("PROPERTY_BANNER_TYPE");
        if (obj != null && !Boolean.parseBoolean(((String) (obj))))
        {
            return MMJSResponse.b("Cannot expand a non banner ad");
        }
        String s = (String)map.get("url");
        String s5 = (String)map.get("transparent");
        String s6 = (String)map.get("useCustomClose");
        String s7 = (String)map.get("transition");
        obj = (String)map.get("orientation");
        String s1 = (String)map.get("transitionDuration");
        String s2 = (String)map.get("height");
        String s3 = (String)map.get("width");
        String s4 = (String)map.get("modal");
        String s8 = (String)map.get("PROPERTY_EXPANDING");
        String s9 = (String)map.get("allowOrientationChange");
        Context context = (Context)b.get();
        if (context != null)
        {
            OverlaySettings overlaysettings = new OverlaySettings();
            if (s != null)
            {
                overlaysettings.g = s;
            }
            if (s8 != null)
            {
                overlaysettings.q = (int)Float.parseFloat(s8);
            }
            if (s5 != null)
            {
                overlaysettings.b = Boolean.parseBoolean(s5);
            }
            if (s6 != null)
            {
                overlaysettings.a = Boolean.parseBoolean(s6);
            }
            if (s7 != null)
            {
                overlaysettings.e = s7;
            }
            if (s9 != null)
            {
                overlaysettings.k = Boolean.parseBoolean(s9);
            }
            if (obj == null)
            {
                obj = (String)map.get("forceOrientation");
            }
            if (obj != null)
            {
                overlaysettings.f = ((String) (obj));
            }
            if (s2 != null)
            {
                overlaysettings.h = (int)Float.parseFloat(s2);
            }
            if (s3 != null)
            {
                overlaysettings.i = (int)Float.parseFloat(s3);
            }
            if (s4 != null)
            {
                overlaysettings.j = Boolean.parseBoolean(s4);
            }
            if (s1 != null)
            {
                try
                {
                    overlaysettings.c = Long.parseLong(s1) * 1000L;
                }
                catch (Exception exception)
                {
                    MMLog.a(a, "Problem converting transitionDuration", exception);
                }
            }
            obj = new Intent();
            if (s != null)
            {
                ((Intent) (obj)).setData(Uri.parse(s));
            }
            ((Intent) (obj)).putExtra("settings", overlaysettings);
            ((Intent) (obj)).putExtra("internalId", overlaysettings.q);
            Utils.IntentUtils.a(context, ((Intent) (obj)));
            MMSDK.Event.a(context, a((String)map.get("PROPERTY_EXPANDING")));
            return MMJSResponse.a();
        } else
        {
            return null;
        }
    }

    public MMJSResponse open(Map map)
    {
        Object obj = (String)map.get("url");
        Context context = (Context)b.get();
        if (obj != null && context != null)
        {
            obj = new Intent("android.intent.action.VIEW", Uri.parse(((String) (obj))));
            MMSDK.Event.a(context, "browser", a((String)map.get("PROPERTY_EXPANDING")));
            Utils.IntentUtils.c(context, ((Intent) (obj)));
            return MMJSResponse.a();
        } else
        {
            return null;
        }
    }

    public MMJSResponse setOrientation(Map map)
    {
        Object obj;
label0:
        {
            obj = (String)map.get("forceOrientation");
            Object obj1 = b();
            if (obj1 == null)
            {
                break label0;
            }
            if (!"none".equals(obj))
            {
                if ("portrait".equals(obj))
                {
                    ((AdViewOverlayActivity) (obj1)).a.f = "portrait";
                    ((AdViewOverlayActivity) (obj1)).a.k = false;
                    ((AdViewOverlayActivity) (obj1)).setRequestedOrientation(1);
                    obj = MMJSResponse.a("portrait");
                } else
                {
                    if (!"landscape".equals(obj))
                    {
                        break label0;
                    }
                    ((AdViewOverlayActivity) (obj1)).a.f = "landscape";
                    ((AdViewOverlayActivity) (obj1)).a.k = false;
                    ((AdViewOverlayActivity) (obj1)).setRequestedOrientation(0);
                    obj = MMJSResponse.a("landscape");
                }
            } else
            {
                if (!"none".equals(obj))
                {
                    break label0;
                }
                ((AdViewOverlayActivity) (obj1)).a(true);
                obj = MMJSResponse.a("none");
            }
        }
_L1:
        if (obj != null)
        {
            boolean flag;
            if (((MMJSResponse) (obj)).c == 1 && (((MMJSResponse) (obj)).d instanceof String))
            {
                obj1 = (String)((MMJSResponse) (obj)).d;
                if (((String) (obj1)).contains("portrait") || ((String) (obj1)).contains("landscape"))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            } else
            {
                flag = false;
            }
            if (flag)
            {
                break MISSING_BLOCK_LABEL_246;
            }
        }
        map = (String)map.get("allowOrientationChange");
        if (map != null)
        {
            obj = b();
            if (obj != null)
            {
                ((AdViewOverlayActivity) (obj)).a(Boolean.parseBoolean(map));
                return MMJSResponse.a();
            }
        }
        break MISSING_BLOCK_LABEL_244;
        obj = null;
          goto _L1
        return null;
        return ((MMJSResponse) (obj));
    }

    public MMJSResponse useCustomClose(Map map)
    {
        Object obj = (MMWebView)c.get();
        map = (String)map.get("useCustomClose");
        if (map != null && obj != null)
        {
            obj = ((MMWebView) (obj)).i();
            if (obj != null)
            {
                ((AdViewOverlayView) (obj)).a(Boolean.parseBoolean(map));
                return MMJSResponse.a();
            }
        }
        return null;
    }

}

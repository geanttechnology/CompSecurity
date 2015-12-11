// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.lang.ref.WeakReference;
import java.util.HashMap;

// Referenced classes of package com.millennialmedia.android:
//            MMJSObject, OverlaySettings, MMJSResponse, AdViewOverlayActivity, 
//            MMWebView, MMLayout, AdViewOverlayView

class BridgeMMInterstitial extends MMJSObject
{

    BridgeMMInterstitial()
    {
    }

    private Intent getExpandExtrasIntent(String s, OverlaySettings overlaysettings)
    {
        Intent intent = new Intent();
        if (s != null)
        {
            intent.setData(Uri.parse(s));
        }
        intent.putExtra("settings", overlaysettings);
        intent.putExtra("internalId", overlaysettings.creatorAdImplId);
        return intent;
    }

    private boolean isForcingOrientation(MMJSResponse mmjsresponse)
    {
        boolean flag;
label0:
        {
            boolean flag1 = false;
            flag = flag1;
            if (mmjsresponse.result != 1)
            {
                break label0;
            }
            flag = flag1;
            if (!(mmjsresponse.response instanceof String))
            {
                break label0;
            }
            mmjsresponse = (String)mmjsresponse.response;
            if (!mmjsresponse.contains("portrait"))
            {
                flag = flag1;
                if (!mmjsresponse.contains("landscape"))
                {
                    break label0;
                }
            }
            flag = true;
        }
        return flag;
    }

    private MMJSResponse setAllowOrientationChange(HashMap hashmap)
    {
        hashmap = (String)hashmap.get("allowOrientationChange");
        if (hashmap != null)
        {
            AdViewOverlayActivity adviewoverlayactivity = getBaseActivity();
            if (adviewoverlayactivity != null)
            {
                adviewoverlayactivity.setAllowOrientationChange(Boolean.parseBoolean(hashmap));
                return MMJSResponse.responseWithSuccess();
            }
        }
        return null;
    }

    private MMJSResponse setForceOrientation(HashMap hashmap)
    {
        hashmap = (String)hashmap.get("forceOrientation");
        if (!"none".equals(hashmap))
        {
            AdViewOverlayActivity adviewoverlayactivity = getBaseActivity();
            if (adviewoverlayactivity != null)
            {
                if ("portrait".equals(hashmap))
                {
                    adviewoverlayactivity.setRequestedOrientationPortrait();
                    return MMJSResponse.responseWithSuccess("portrait");
                }
                if ("landscape".equals(hashmap))
                {
                    adviewoverlayactivity.setRequestedOrientationLandscape();
                    return MMJSResponse.responseWithSuccess("landscape");
                }
            }
        }
        return null;
    }

    public MMJSResponse close(HashMap hashmap)
    {
        hashmap = (MMWebView)mmWebViewRef.get();
        if (hashmap != null)
        {
            hashmap.getMMLayout().closeAreaTouched();
            return MMJSResponse.responseWithSuccess();
        } else
        {
            return null;
        }
    }

    public MMJSResponse expandToExternalBrowser(HashMap hashmap)
    {
        return open(hashmap);
    }

    public MMJSResponse expandWithProperties(HashMap hashmap)
    {
        String s = (String)hashmap.get("PROPERTY_BANNER_TYPE");
        if (s != null && !Boolean.parseBoolean(s))
        {
            return MMJSResponse.responseWithError("Cannot expand a non banner ad");
        }
        String s2 = (String)hashmap.get("url");
        s = (String)hashmap.get("enableNativeAccelerometer");
        String s7 = (String)hashmap.get("transparent");
        String s8 = (String)hashmap.get("useCustomClose");
        String s9 = (String)hashmap.get("transition");
        String s1 = (String)hashmap.get("orientation");
        String s3 = (String)hashmap.get("transitionDuration");
        String s4 = (String)hashmap.get("height");
        String s5 = (String)hashmap.get("width");
        String s6 = (String)hashmap.get("modal");
        String s10 = (String)hashmap.get("PROPERTY_EXPANDING");
        String s11 = (String)hashmap.get("allowOrientationChange");
        Context context = (Context)contextRef.get();
        if (context != null)
        {
            OverlaySettings overlaysettings = new OverlaySettings();
            if (s2 != null)
            {
                overlaysettings.urlToLoad = s2;
            }
            if (s10 != null)
            {
                overlaysettings.creatorAdImplId = (int)Float.parseFloat(s10);
            }
            if (s != null)
            {
                overlaysettings.canAccelerate = Boolean.parseBoolean(s);
            }
            if (s7 != null)
            {
                overlaysettings.setIsTransparent(Boolean.parseBoolean(s7));
            }
            if (s8 != null)
            {
                overlaysettings.setUseCustomClose(Boolean.parseBoolean(s8));
            }
            if (s9 != null)
            {
                overlaysettings.setTransition(s9);
            }
            if (s11 != null)
            {
                overlaysettings.allowOrientationChange = Boolean.parseBoolean(s11);
            }
            s = s1;
            if (s1 == null)
            {
                s = (String)hashmap.get("forceOrientation");
            }
            if (s != null)
            {
                overlaysettings.orientation = s;
            }
            if (s4 != null)
            {
                overlaysettings.height = (int)Float.parseFloat(s4);
            }
            if (s5 != null)
            {
                overlaysettings.width = (int)Float.parseFloat(s5);
            }
            if (s6 != null)
            {
                overlaysettings.modal = Boolean.parseBoolean(s6);
            }
            if (s3 != null)
            {
                try
                {
                    overlaysettings.setTransitionDurationInMillis(Long.parseLong(s3) * 1000L);
                }
                catch (Exception exception) { }
            }
            Utils.IntentUtils.startAdViewOverlayActivity(context, getExpandExtrasIntent(s2, overlaysettings));
            MMSDK.Event.overlayOpenedBroadCast(context, getAdImplId((String)hashmap.get("PROPERTY_EXPANDING")));
            return MMJSResponse.responseWithSuccess();
        } else
        {
            return null;
        }
    }

    public MMJSResponse open(HashMap hashmap)
    {
        Object obj = (String)hashmap.get("url");
        Context context = (Context)contextRef.get();
        if (obj != null && context != null)
        {
            obj = new Intent("android.intent.action.VIEW", Uri.parse(((String) (obj))));
            MMSDK.Event.intentStarted(context, "browser", getAdImplId((String)hashmap.get("PROPERTY_EXPANDING")));
            Utils.IntentUtils.startActivity(context, ((Intent) (obj)));
            return MMJSResponse.responseWithSuccess();
        } else
        {
            return null;
        }
    }

    public MMJSResponse setOrientation(HashMap hashmap)
    {
        MMJSResponse mmjsresponse;
label0:
        {
            MMJSResponse mmjsresponse1 = setForceOrientation(hashmap);
            if (mmjsresponse1 != null)
            {
                mmjsresponse = mmjsresponse1;
                if (isForcingOrientation(mmjsresponse1))
                {
                    break label0;
                }
            }
            mmjsresponse = setAllowOrientationChange(hashmap);
        }
        return mmjsresponse;
    }

    public MMJSResponse show(HashMap hashmap)
    {
        hashmap = (String)hashmap.get("url");
        Context context = (Context)contextRef.get();
        if (hashmap != null && context != null)
        {
            Utils.IntentUtils.startAdViewOverlayActivityWithData(context, hashmap);
            return MMJSResponse.responseWithSuccess();
        } else
        {
            return null;
        }
    }

    public MMJSResponse useCustomClose(HashMap hashmap)
    {
        Object obj = (MMWebView)mmWebViewRef.get();
        hashmap = (String)hashmap.get("useCustomClose");
        if (hashmap != null && obj != null)
        {
            obj = ((MMWebView) (obj)).getAdViewOverlayView();
            if (obj != null)
            {
                ((AdViewOverlayView) (obj)).setUseCustomClose(Boolean.parseBoolean(hashmap));
                return MMJSResponse.responseWithSuccess();
            }
        }
        return null;
    }
}

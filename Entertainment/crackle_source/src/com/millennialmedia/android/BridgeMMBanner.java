// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import java.lang.ref.WeakReference;
import java.util.HashMap;

// Referenced classes of package com.millennialmedia.android:
//            MMJSObject, MMSDK, MMWebView, MMJSResponse, 
//            DTOResizeParameters

class BridgeMMBanner extends MMJSObject
{

    BridgeMMBanner()
    {
    }

    int getScreenHeight(Context context)
    {
        return Integer.parseInt(MMSDK.getDpiHeight(context));
    }

    int getScreenWidth(Context context)
    {
        return Integer.parseInt(MMSDK.getDpiWidth(context));
    }

    public MMJSResponse resize(HashMap hashmap)
    {
        MMWebView mmwebview = (MMWebView)mmWebViewRef.get();
        if (mmwebview != null)
        {
            if (mmwebview.isMraidResized())
            {
                return MMJSResponse.responseWithError("State is currently resized");
            }
            String s = (String)hashmap.get("width");
            Object obj = (String)hashmap.get("height");
            int i = 0;
            int j = 0;
            if (!TextUtils.isEmpty(s))
            {
                i = (int)Float.parseFloat(s);
            }
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                j = (int)Float.parseFloat(((String) (obj)));
            }
            s = (String)hashmap.get("customClosePosition");
            obj = (String)hashmap.get("offsetX");
            String s1 = (String)hashmap.get("offsetY");
            int k = 0;
            int l = 0;
            if (!TextUtils.isEmpty(s1))
            {
                k = (int)Float.parseFloat(s1);
            }
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                l = (int)Float.parseFloat(((String) (obj)));
            }
            boolean flag = Boolean.parseBoolean((String)hashmap.get("allowOffscreen"));
            hashmap = mmwebview.getContext();
            obj = MMSDK.getMetrics(hashmap);
            int i1 = getScreenWidth(hashmap);
            int j1 = getScreenHeight(hashmap);
            mmwebview.setMraidResize(new DTOResizeParameters(((DisplayMetrics) (obj)).density, i, j, s, l, k, flag, i1, j1));
            return MMJSResponse.responseWithSuccess();
        } else
        {
            return null;
        }
    }
}

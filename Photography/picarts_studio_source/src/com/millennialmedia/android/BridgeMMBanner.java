// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import java.lang.ref.WeakReference;
import java.util.Map;

// Referenced classes of package com.millennialmedia.android:
//            MMJSObject, MMWebView, MMJSResponse, MMSDK, 
//            DTOResizeParameters

class BridgeMMBanner extends MMJSObject
{

    BridgeMMBanner()
    {
    }

    final MMJSResponse a(String s, Map map)
    {
        MMJSResponse mmjsresponse = null;
        if ("resize".equals(s))
        {
            mmjsresponse = resize(map);
        }
        return mmjsresponse;
    }

    public MMJSResponse resize(Map map)
    {
        int l = 0;
        MMWebView mmwebview = (MMWebView)c.get();
        if (mmwebview != null)
        {
            if (mmwebview.p())
            {
                return MMJSResponse.b("State is currently resized");
            }
            String s = (String)map.get("width");
            Object obj = (String)map.get("height");
            String s1;
            int i;
            int j;
            int k;
            int i1;
            int j1;
            boolean flag;
            if (!TextUtils.isEmpty(s))
            {
                i = (int)Float.parseFloat(s);
            } else
            {
                i = 0;
            }
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                j = (int)Float.parseFloat(((String) (obj)));
            } else
            {
                j = 0;
            }
            s = (String)map.get("customClosePosition");
            obj = (String)map.get("offsetX");
            s1 = (String)map.get("offsetY");
            if (!TextUtils.isEmpty(s1))
            {
                k = (int)Float.parseFloat(s1);
            } else
            {
                k = 0;
            }
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                l = (int)Float.parseFloat(((String) (obj)));
            }
            flag = Boolean.parseBoolean((String)map.get("allowOffscreen"));
            map = mmwebview.getContext();
            obj = map.getResources().getDisplayMetrics();
            i1 = Integer.parseInt(MMSDK.f(map));
            j1 = Integer.parseInt(MMSDK.g(map));
            mmwebview.a(new DTOResizeParameters(((DisplayMetrics) (obj)).density, i, j, s, l, k, flag, i1, j1));
            return MMJSResponse.a();
        } else
        {
            return null;
        }
    }
}

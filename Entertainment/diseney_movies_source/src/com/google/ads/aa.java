// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads;

import android.text.TextUtils;
import android.webkit.WebView;
import com.google.ads.internal.ActivationOverlay;
import com.google.ads.internal.d;
import com.google.ads.util.b;
import java.util.HashMap;

// Referenced classes of package com.google.ads:
//            o

public class aa
    implements o
{

    public aa()
    {
    }

    public void a(d d1, HashMap hashmap, WebView webview)
    {
        int l = -1;
        if (!(webview instanceof ActivationOverlay)) goto _L2; else goto _L1
_L1:
        int i;
        if (TextUtils.isEmpty((CharSequence)hashmap.get("w")))
        {
            break MISSING_BLOCK_LABEL_247;
        }
        i = Integer.parseInt((String)hashmap.get("w"));
_L9:
        if (TextUtils.isEmpty((CharSequence)hashmap.get("h"))) goto _L4; else goto _L3
_L3:
        int j = Integer.parseInt((String)hashmap.get("h"));
_L8:
        if (TextUtils.isEmpty((CharSequence)hashmap.get("x"))) goto _L6; else goto _L5
_L5:
        int k = Integer.parseInt((String)hashmap.get("x"));
_L7:
        if (!TextUtils.isEmpty((CharSequence)hashmap.get("y")))
        {
            l = Integer.parseInt((String)hashmap.get("y"));
        }
        if (hashmap.get("a") != null && ((String)hashmap.get("a")).equals("1"))
        {
            d1.a(null, true, k, l, i, j);
            return;
        }
        break MISSING_BLOCK_LABEL_175;
        d1;
        b.d("Invalid number format in activation overlay response.", d1);
        return;
        if (hashmap.get("a") != null && ((String)hashmap.get("a")).equals("0"))
        {
            d1.a(null, false, k, l, i, j);
            return;
        } else
        {
            d1.a(k, l, i, j);
            return;
        }
_L2:
        b.b("Trying to activate an overlay when this is not an overlay.");
        return;
_L6:
        k = -1;
          goto _L7
_L4:
        j = -1;
          goto _L8
        i = -1;
          goto _L9
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia.a;

import com.tremorvideo.sdk.android.videoad.ad;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia.a:
//            h

public class a
    implements Runnable
{

    String a;
    final h b;

    public void run()
    {
        if (ad.q() < 19)
        {
            b.loadUrl((new StringBuilder()).append("javascript:").append(a).toString());
            return;
        } else
        {
            b.evaluateJavascript(a, null);
            return;
        }
    }

    public (h h1, String s)
    {
        b = h1;
        super();
        a = s;
    }
}

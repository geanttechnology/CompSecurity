// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.content.DialogInterface;
import android.webkit.JsResult;

// Referenced classes of package com.offerup.android.activities:
//            OfferUpWebViewActivity

final class ep
    implements android.content.DialogInterface.OnClickListener
{

    private JsResult a;

    ep(OfferUpWebViewActivity offerupwebviewactivity, JsResult jsresult)
    {
        a = jsresult;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        if (i == -1)
        {
            a.confirm();
        }
    }
}

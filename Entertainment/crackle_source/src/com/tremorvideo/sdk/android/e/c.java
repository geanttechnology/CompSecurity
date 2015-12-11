// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.e;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.URLUtil;
import com.tremorvideo.sdk.android.adapter.TremorAdapterCalls;

// Referenced classes of package com.tremorvideo.sdk.android.e:
//            b, p

class c extends b
{

    c(p p1)
    {
        super(p1);
    }

    protected void a(String s)
    {
        p p1 = a();
        if (p1.l() != null)
        {
            p1.l().a(p1);
        }
        if (URLUtil.isValidUrl(s))
        {
            a().getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(s)));
            TremorAdapterCalls.onLeaveApp();
            return;
        } else
        {
            p1.a("Attempting to open invalid url: ", s);
            return;
        }
    }
}

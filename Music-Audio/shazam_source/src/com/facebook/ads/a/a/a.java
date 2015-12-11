// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.a;

import android.content.Context;
import android.net.Uri;
import com.facebook.ads.a.f.g;
import com.facebook.ads.a.f.o;
import com.facebook.ads.a.f.s;

public abstract class a
{

    public a()
    {
    }

    protected static void a(Context context, Uri uri)
    {
        uri = uri.getQueryParameter("native_click_report_url");
        if (s.a(uri))
        {
            return;
        } else
        {
            (new o()).execute(new String[] {
                uri
            });
            g.a(context, "Click logged");
            return;
        }
    }

    public abstract com.facebook.ads.a.f.b.a a();

    public abstract void b();
}

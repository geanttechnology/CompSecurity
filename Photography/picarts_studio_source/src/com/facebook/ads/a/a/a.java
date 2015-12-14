// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.a;

import android.content.Context;
import android.net.Uri;
import com.facebook.ads.a.aa;
import com.facebook.ads.a.as;
import com.facebook.ads.a.aw;
import java.util.Map;

public abstract class a
{

    public a()
    {
    }

    public abstract com.facebook.ads.a.b.a a();

    protected void a(Context context, Uri uri)
    {
        uri = uri.getQueryParameter("native_click_report_url");
        if (aw.a(uri))
        {
            return;
        } else
        {
            (new as()).execute(new String[] {
                uri
            });
            aa.a(context, "Click logged");
            return;
        }
    }

    public abstract void a(Map map);
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.action;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.facebook.ads.internal.util.g;

// Referenced classes of package com.facebook.ads.internal.action:
//            a

public class d extends a
{

    private static final String a = com/facebook/ads/internal/action/d.getSimpleName();
    private final Context b;
    private final Uri c;

    public d(Context context, Uri uri)
    {
        b = context;
        c = uri;
    }

    public com.facebook.ads.internal.util.b.a a()
    {
        return com.facebook.ads.internal.util.b.a.b;
    }

    public void b()
    {
        a(b, c);
        try
        {
            g.a(b, Uri.parse(c.getQueryParameter("link")));
            return;
        }
        catch (Exception exception)
        {
            Log.d(a, (new StringBuilder()).append("Failed to open link url: ").append(c.toString()).toString(), exception);
        }
    }

}

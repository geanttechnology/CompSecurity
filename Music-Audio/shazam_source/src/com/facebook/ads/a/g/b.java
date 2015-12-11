// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.g;

import android.content.Context;
import android.webkit.WebView;

public class b extends WebView
{

    public boolean a;

    public b(Context context)
    {
        super(context);
    }

    public void destroy()
    {
        a = true;
        super.destroy();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.ViewGroup;
import com.google.android.gms.b.cj;

// Referenced classes of package com.google.android.gms.ads.internal.overlay:
//            c

public static class <init>
{

    public final int a;
    public final android.view.Group.LayoutParams b;
    public final ViewGroup c;
    public final Context d;

    public (cj cj1)
        throws 
    {
        b = cj1.getLayoutParams();
        android.view.ViewParent viewparent = cj1.getParent();
        d = cj1.d();
        if (viewparent != null && (viewparent instanceof ViewGroup))
        {
            c = (ViewGroup)viewparent;
            a = c.indexOfChild(cj1.getWebView());
            c.removeView(cj1.getWebView());
            cj1.a(true);
            return;
        } else
        {
            throw new <init>("Could not get the parent of the WebView for an overlay.");
        }
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.support.v7.ul;
import android.view.ViewGroup;

// Referenced classes of package com.google.android.gms.ads.internal.overlay:
//            zzd

public static class <init>
{

    public final Context context;
    public final int index;
    public final android.view.p.LayoutParams zzAM;
    public final ViewGroup zzAN;

    public _cls9(ul ul1)
        throws _cls9
    {
        zzAM = ul1.getLayoutParams();
        android.view.ViewParent viewparent = ul1.getParent();
        context = ul1.d();
        if (viewparent != null && (viewparent instanceof ViewGroup))
        {
            zzAN = (ViewGroup)viewparent;
            index = zzAN.indexOfChild(ul1.getWebView());
            zzAN.removeView(ul1.getWebView());
            ul1.a(true);
            return;
        } else
        {
            throw new <init>("Could not get the parent of the WebView for an overlay.");
        }
    }
}

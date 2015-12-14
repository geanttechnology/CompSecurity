// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.ViewGroup;
import com.google.android.gms.internal.zziz;

public class <init>
{

    public final Context context;
    public final int index;
    public final android.view.p.LayoutParams zzBw;
    public final ViewGroup zzBx;

    public _cls9(zziz zziz1)
    {
        zzBw = zziz1.getLayoutParams();
        android.view.ViewParent viewparent = zziz1.getParent();
        context = zziz1.zzha();
        if (viewparent != null && (viewparent instanceof ViewGroup))
        {
            zzBx = (ViewGroup)viewparent;
            index = zzBx.indexOfChild(zziz1.getView());
            zzBx.removeView(zziz1.getView());
            zziz1.zzC(true);
            return;
        } else
        {
            throw new <init>("Could not get the parent of the WebView for an overlay.");
        }
    }
}

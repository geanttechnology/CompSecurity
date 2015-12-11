// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.view.ViewGroup;

// Referenced classes of package com.google.android.gms.internal:
//            bk, cw

private static final class <init>
{

    public final android.view.roup.LayoutParams gE;
    public final ViewGroup gF;
    public final int index;

    public (cw cw1)
        throws 
    {
        gE = cw1.getLayoutParams();
        android.view.ViewParent viewparent = cw1.getParent();
        if (viewparent instanceof ViewGroup)
        {
            gF = (ViewGroup)viewparent;
            index = gF.indexOfChild(cw1);
            gF.removeView(cw1);
            cw1.l(true);
            return;
        } else
        {
            throw new <init>("Could not get the parent of the WebView for an overlay.");
        }
    }
}

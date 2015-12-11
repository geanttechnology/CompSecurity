// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.view.ViewGroup;

// Referenced classes of package com.google.android.gms.internal:
//            ew, cf

final class cg
{

    public final int a;
    public final android.view.ViewGroup.LayoutParams b;
    public final ViewGroup c;

    public cg(ew ew1)
    {
        b = ew1.getLayoutParams();
        android.view.ViewParent viewparent = ew1.getParent();
        if (viewparent instanceof ViewGroup)
        {
            c = (ViewGroup)viewparent;
            a = c.indexOfChild(ew1);
            c.removeView(ew1);
            ew1.a(true);
            return;
        } else
        {
            throw new cf("Could not get the parent of the WebView for an overlay.");
        }
    }
}

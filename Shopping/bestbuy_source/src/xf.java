// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.ViewGroup;
import com.google.android.gms.internal.gu;

final class xf
{

    public final int a;
    public final android.view.ViewGroup.LayoutParams b;
    public final ViewGroup c;

    public xf(gu gu1)
    {
        b = gu1.getLayoutParams();
        android.view.ViewParent viewparent = gu1.getParent();
        if (viewparent instanceof ViewGroup)
        {
            c = (ViewGroup)viewparent;
            a = c.indexOfChild(gu1);
            c.removeView(gu1);
            gu1.a(true);
            return;
        } else
        {
            throw new xd("Could not get the parent of the WebView for an overlay.");
        }
    }
}

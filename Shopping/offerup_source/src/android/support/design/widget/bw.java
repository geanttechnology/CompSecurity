// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package android.support.design.widget:
//            bv

final class bw
    implements bv
{

    private bw()
    {
    }

    bw(byte byte0)
    {
        this();
    }

    public final void a(ViewGroup viewgroup, View view, Rect rect)
    {
        viewgroup.offsetDescendantRectToMyCoords(view, rect);
    }
}

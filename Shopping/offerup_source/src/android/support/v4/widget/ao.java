// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.widget.PopupWindow;

// Referenced classes of package android.support.v4.widget:
//            an

final class ao extends an
{

    ao()
    {
    }

    public final void a(PopupWindow popupwindow, int i)
    {
        popupwindow.setWindowLayoutType(i);
    }

    public final void a(PopupWindow popupwindow, boolean flag)
    {
        popupwindow.setOverlapAnchor(flag);
    }
}

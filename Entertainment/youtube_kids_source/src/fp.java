// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.widget.PopupWindow;

final class fp extends fq
{

    fp()
    {
    }

    public final void a(PopupWindow popupwindow, View view, int i, int j, int k)
    {
        popupwindow.showAsDropDown(view, i, j, k);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.view.View;
import android.widget.PopupWindow;

public final class i
{
    static class a
        implements c
    {

        public void a(PopupWindow popupwindow, View view, int j, int k, int l)
        {
            popupwindow.showAsDropDown(view, j, k);
        }

        a()
        {
        }
    }

    static final class b extends a
    {

        public final void a(PopupWindow popupwindow, View view, int j, int k, int l)
        {
            popupwindow.showAsDropDown(view, j, k, l);
        }

        b()
        {
        }
    }

    static interface c
    {

        public abstract void a(PopupWindow popupwindow, View view, int j, int k, int l);
    }


    static final c a;

    public static void a(PopupWindow popupwindow, View view, int j, int k, int l)
    {
        a.a(popupwindow, view, j, k, l);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            a = new b();
        } else
        {
            a = new a();
        }
    }
}

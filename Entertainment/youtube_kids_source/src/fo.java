// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.widget.PopupWindow;

public final class fo
{

    private static fq a;

    public static void a(PopupWindow popupwindow, View view, int i, int j, int k)
    {
        a.a(popupwindow, view, i, j, k);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            a = new fp();
        } else
        {
            a = new fq();
        }
    }
}

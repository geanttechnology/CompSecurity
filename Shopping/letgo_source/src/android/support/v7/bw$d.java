// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.support.v7.internal.widget.g;
import android.view.Menu;
import android.view.View;

// Referenced classes of package android.support.v7:
//            cg, bw

private class back extends cg
{

    final bw a;

    public View onCreatePanelView(int i)
    {
        i;
        JVM INSTR tableswitch 0 0: default 20
    //                   0 26;
           goto _L1 _L2
_L1:
        Menu menu;
        return super.onCreatePanelView(i);
_L2:
        if (onPreparePanel(i, null, menu = bw.c(a).s()) && onMenuOpened(i, menu))
        {
            return bw.a(a, menu);
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public boolean onPreparePanel(int i, View view, Menu menu)
    {
        boolean flag = super.onPreparePanel(i, view, menu);
        if (flag && !bw.b(a))
        {
            bw.c(a).n();
            bw.a(a, true);
        }
        return flag;
    }

    public back(bw bw1, android.view.w.Callback callback)
    {
        a = bw1;
        super(callback);
    }
}

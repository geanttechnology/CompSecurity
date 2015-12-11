// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.internal.view.menu.ActionMenuItemView;
import android.widget.PopupWindow;

public final class gq extends lb
{

    private ActionMenuItemView a;

    public gq(ActionMenuItemView actionmenuitemview)
    {
        a = actionmenuitemview;
        super(actionmenuitemview);
    }

    public final kx a()
    {
        if (ActionMenuItemView.a(a) != null)
        {
            return ActionMenuItemView.a(a).a();
        } else
        {
            return null;
        }
    }

    protected final boolean b()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (ActionMenuItemView.b(a) != null)
        {
            flag = flag1;
            if (ActionMenuItemView.b(a).a(ActionMenuItemView.c(a)))
            {
                kx kx1 = a();
                flag = flag1;
                if (kx1 != null)
                {
                    flag = flag1;
                    if (kx1.a.isShowing())
                    {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    protected final boolean c()
    {
        kx kx1 = a();
        if (kx1 != null)
        {
            kx1.b();
            return true;
        } else
        {
            return false;
        }
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.internal.view.menu.ActionMenuItemView;
import android.support.v7.widget.ListPopupWindow;

public class y extends db
{

    final ActionMenuItemView a;

    public y(ActionMenuItemView actionmenuitemview)
    {
        a = actionmenuitemview;
        super(actionmenuitemview);
    }

    public ListPopupWindow a()
    {
        if (ActionMenuItemView.access$000(a) != null)
        {
            return ActionMenuItemView.access$000(a).a();
        } else
        {
            return null;
        }
    }

    protected boolean b()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (ActionMenuItemView.access$100(a) != null)
        {
            flag = flag1;
            if (ActionMenuItemView.access$100(a).invokeItem(ActionMenuItemView.access$200(a)))
            {
                ListPopupWindow listpopupwindow = a();
                flag = flag1;
                if (listpopupwindow != null)
                {
                    flag = flag1;
                    if (listpopupwindow.b())
                    {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    protected boolean c()
    {
        ListPopupWindow listpopupwindow = a();
        if (listpopupwindow != null)
        {
            listpopupwindow.a();
            return true;
        } else
        {
            return false;
        }
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view.menu;

import android.support.v7.widget.ListPopupWindow;

// Referenced classes of package android.support.v7.internal.view.menu:
//            ActionMenuItemView, c, k

final class b extends android.support.v7.widget.ListPopupWindow.ForwardingListener
{

    private ActionMenuItemView a;

    public b(ActionMenuItemView actionmenuitemview)
    {
        a = actionmenuitemview;
        super(actionmenuitemview);
    }

    public final ListPopupWindow getPopup()
    {
        if (ActionMenuItemView.a(a) != null)
        {
            return ActionMenuItemView.a(a).getPopup();
        } else
        {
            return null;
        }
    }

    protected final boolean onForwardingStarted()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (ActionMenuItemView.b(a) != null)
        {
            flag = flag1;
            if (ActionMenuItemView.b(a).invokeItem(ActionMenuItemView.c(a)))
            {
                ListPopupWindow listpopupwindow = getPopup();
                flag = flag1;
                if (listpopupwindow != null)
                {
                    flag = flag1;
                    if (listpopupwindow.isShowing())
                    {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.support.v7.internal.view.menu.SubMenuBuilder;
import android.support.v7.widget.ActionMenuPresenter;
import android.view.MenuItem;
import android.view.View;

public class ei extends bm
{

    final ActionMenuPresenter c;
    private SubMenuBuilder d;

    public ei(ActionMenuPresenter actionmenupresenter, Context context, SubMenuBuilder submenubuilder)
    {
        boolean flag1 = false;
        c = actionmenupresenter;
        super(context, submenubuilder, null, false, r.actionOverflowMenuStyle);
        d = submenubuilder;
        int i;
        if (!((MenuItemImpl)submenubuilder.getItem()).i())
        {
            int j;
            boolean flag;
            if (ActionMenuPresenter.d(actionmenupresenter) == null)
            {
                context = (View)ActionMenuPresenter.e(actionmenupresenter);
            } else
            {
                context = ActionMenuPresenter.d(actionmenupresenter);
            }
            a(context);
        }
        a(actionmenupresenter.g);
        j = submenubuilder.size();
        i = 0;
        do
        {
label0:
            {
                flag = flag1;
                if (i < j)
                {
                    actionmenupresenter = submenubuilder.getItem(i);
                    if (!actionmenupresenter.isVisible() || actionmenupresenter.getIcon() == null)
                    {
                        break label0;
                    }
                    flag = true;
                }
                b(flag);
                return;
            }
            i++;
        } while (true);
    }

    public void onDismiss()
    {
        super.onDismiss();
        ActionMenuPresenter.a(c, null);
        c.h = 0;
    }
}

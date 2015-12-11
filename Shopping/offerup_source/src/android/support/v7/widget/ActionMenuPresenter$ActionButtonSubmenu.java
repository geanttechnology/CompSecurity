// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.support.v7.internal.view.menu.ac;
import android.support.v7.internal.view.menu.m;
import android.support.v7.internal.view.menu.v;
import android.view.MenuItem;
import android.view.View;

// Referenced classes of package android.support.v7.widget:
//            ActionMenuPresenter

class setForceShowIcon extends v
{

    private ac mSubMenu;
    final ActionMenuPresenter this$0;

    public void onDismiss()
    {
        super.onDismiss();
        ActionMenuPresenter.access$702(ActionMenuPresenter.this, null);
        mOpenSubMenuId = 0;
    }

    public (Context context, ac ac1)
    {
        boolean flag1 = false;
        this$0 = ActionMenuPresenter.this;
        super(context, ac1, null, false, android.support.v7.appcompat.s._fld0);
        mSubMenu = ac1;
        int i;
        if (!((m)ac1.getItem()).i())
        {
            int j;
            boolean flag;
            if (ActionMenuPresenter.access$500(ActionMenuPresenter.this) == null)
            {
                context = (View)ActionMenuPresenter.access$600(ActionMenuPresenter.this);
            } else
            {
                context = ActionMenuPresenter.access$500(ActionMenuPresenter.this);
            }
            setAnchorView(context);
        }
        setCallback(mPopupPresenterCallback);
        j = ac1.size();
        i = 0;
        do
        {
label0:
            {
                flag = flag1;
                if (i < j)
                {
                    actionmenupresenter = ac1.getItem(i);
                    if (!isVisible() || getIcon() == null)
                    {
                        break label0;
                    }
                    flag = true;
                }
                setForceShowIcon(flag);
                return;
            }
            i++;
        } while (true);
    }
}

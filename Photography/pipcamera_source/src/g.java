// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarActivityDelegateBase;
import android.support.v7.internal.view.menu.MenuBuilder;

public final class g
    implements as
{

    final ActionBarActivityDelegateBase a;

    private g(ActionBarActivityDelegateBase actionbaractivitydelegatebase)
    {
        a = actionbaractivitydelegatebase;
        super();
    }

    public g(ActionBarActivityDelegateBase actionbaractivitydelegatebase, android.support.v7.app.ActionBarActivityDelegateBase._cls1 _pcls1)
    {
        this(actionbaractivitydelegatebase);
    }

    public void a(MenuBuilder menubuilder, boolean flag)
    {
label0:
        {
            MenuBuilder menubuilder1 = menubuilder.p();
            ActionBarActivityDelegateBase actionbaractivitydelegatebase;
            boolean flag1;
            if (menubuilder1 != menubuilder)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            actionbaractivitydelegatebase = a;
            if (flag1)
            {
                menubuilder = menubuilder1;
            }
            menubuilder = ActionBarActivityDelegateBase.a(actionbaractivitydelegatebase, menubuilder);
            if (menubuilder != null)
            {
                if (!flag1)
                {
                    break label0;
                }
                ActionBarActivityDelegateBase.a(a, ((android.support.v7.app.ActionBarActivityDelegateBase.PanelFeatureState) (menubuilder)).a, menubuilder, menubuilder1);
                ActionBarActivityDelegateBase.a(a, menubuilder, true);
            }
            return;
        }
        a.a.closeOptionsMenu();
        ActionBarActivityDelegateBase.a(a, menubuilder, flag);
    }

    public boolean a(MenuBuilder menubuilder)
    {
        if (menubuilder == null && a.b)
        {
            l l1 = a.m();
            if (l1 != null && !a.o())
            {
                l1.c(8, menubuilder);
            }
        }
        return true;
    }
}

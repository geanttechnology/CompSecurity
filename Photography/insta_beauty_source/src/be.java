// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuItemImpl;

public class be
    implements android.support.v4.view.ActionProvider.VisibilityListener
{

    final MenuItemImpl a;

    public be(MenuItemImpl menuitemimpl)
    {
        a = menuitemimpl;
        super();
    }

    public void onActionProviderVisibilityChanged(boolean flag)
    {
        MenuItemImpl.a(a).a(a);
    }
}

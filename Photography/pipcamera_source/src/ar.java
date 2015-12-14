// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.support.v7.internal.view.menu.SubMenuBuilder;

public interface ar
{

    public abstract void a(Context context, MenuBuilder menubuilder);

    public abstract void a(MenuBuilder menubuilder, boolean flag);

    public abstract void a(boolean flag);

    public abstract boolean a(MenuBuilder menubuilder, MenuItemImpl menuitemimpl);

    public abstract boolean a(SubMenuBuilder submenubuilder);

    public abstract boolean b();

    public abstract boolean b(MenuBuilder menubuilder, MenuItemImpl menuitemimpl);
}

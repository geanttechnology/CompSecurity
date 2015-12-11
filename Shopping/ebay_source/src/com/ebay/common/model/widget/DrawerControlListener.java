// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.widget;


public interface DrawerControlListener
{

    public abstract void closeDrawer(int i);

    public abstract int getOpenDrawer();

    public abstract void openDrawer(int i);
}

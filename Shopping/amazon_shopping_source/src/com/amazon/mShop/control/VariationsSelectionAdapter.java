// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control;


public interface VariationsSelectionAdapter
{

    public abstract void clearSelectedChild();

    public abstract com.amazon.mShop.control.item.Variations.Child getSelectedVariationChild();

    public abstract void setSelectedVariationChild(com.amazon.mShop.control.item.Variations.Child child);
}

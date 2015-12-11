// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.buttons;


public final class InlineActionsButtonType extends Enum
{

    private static final InlineActionsButtonType $VALUES[];
    public static final InlineActionsButtonType ADD_TO_CART;
    public static final InlineActionsButtonType QUANTITY_SWITCHER;
    public static final InlineActionsButtonType VIEW_OPTIONS;

    private InlineActionsButtonType(String s, int i)
    {
        super(s, i);
    }

    public static InlineActionsButtonType valueOf(String s)
    {
        return (InlineActionsButtonType)Enum.valueOf(com/amazon/retailsearch/android/ui/buttons/InlineActionsButtonType, s);
    }

    public static InlineActionsButtonType[] values()
    {
        return (InlineActionsButtonType[])$VALUES.clone();
    }

    static 
    {
        ADD_TO_CART = new InlineActionsButtonType("ADD_TO_CART", 0);
        VIEW_OPTIONS = new InlineActionsButtonType("VIEW_OPTIONS", 1);
        QUANTITY_SWITCHER = new InlineActionsButtonType("QUANTITY_SWITCHER", 2);
        $VALUES = (new InlineActionsButtonType[] {
            ADD_TO_CART, VIEW_OPTIONS, QUANTITY_SWITCHER
        });
    }
}

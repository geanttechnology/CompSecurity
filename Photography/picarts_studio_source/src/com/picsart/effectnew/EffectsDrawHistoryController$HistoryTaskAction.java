// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effectnew;


public final class  extends Enum
{

    private static final HistoryTaskActionClearAndAddMaskInvert $VALUES[];
    public static final HistoryTaskActionClearAndAddMaskInvert HistoryTaskActionAddMaskInvert;
    public static final HistoryTaskActionClearAndAddMaskInvert HistoryTaskActionClearAndAddMaskInvert;
    public static final HistoryTaskActionClearAndAddMaskInvert HistoryTaskActionNone;
    public static final HistoryTaskActionClearAndAddMaskInvert HistoryTaskActionRemoveLastItem;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/picsart/effectnew/EffectsDrawHistoryController$HistoryTaskAction, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        HistoryTaskActionNone = new <init>("HistoryTaskActionNone", 0);
        HistoryTaskActionRemoveLastItem = new <init>("HistoryTaskActionRemoveLastItem", 1);
        HistoryTaskActionAddMaskInvert = new <init>("HistoryTaskActionAddMaskInvert", 2);
        HistoryTaskActionClearAndAddMaskInvert = new <init>("HistoryTaskActionClearAndAddMaskInvert", 3);
        $VALUES = (new .VALUES[] {
            HistoryTaskActionNone, HistoryTaskActionRemoveLastItem, HistoryTaskActionAddMaskInvert, HistoryTaskActionClearAndAddMaskInvert
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

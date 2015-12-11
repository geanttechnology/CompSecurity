// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search.refine.types;

import android.content.Context;
import android.content.res.Resources;

public class ItemConditionHelper
{
    public class ItemCondition
    {

        public final String constraintValue;
        public final String displayValue;
        public final ItemConditionState state;
        final ItemConditionHelper this$0;

        protected ItemCondition(ItemConditionState itemconditionstate)
        {
            this$0 = ItemConditionHelper.this;
            super();
            state = itemconditionstate;
            int i = itemconditionstate.ordinal();
            constraintValue = conditionConstraintValues[i];
            displayValue = conditionDisplayValues[i];
        }

        public ItemCondition(String s)
        {
            this(getState(s));
        }
    }

    public static final class ItemConditionState extends Enum
    {

        private static final ItemConditionState $VALUES[];
        public static final ItemConditionState ANY;
        public static final ItemConditionState NEW;
        public static final ItemConditionState UNSPECIFIED;
        public static final ItemConditionState USED;

        public static ItemConditionState valueOf(String s)
        {
            return (ItemConditionState)Enum.valueOf(com/ebay/mobile/search/refine/types/ItemConditionHelper$ItemConditionState, s);
        }

        public static ItemConditionState[] values()
        {
            return (ItemConditionState[])$VALUES.clone();
        }

        static 
        {
            ANY = new ItemConditionState("ANY", 0);
            NEW = new ItemConditionState("NEW", 1);
            USED = new ItemConditionState("USED", 2);
            UNSPECIFIED = new ItemConditionState("UNSPECIFIED", 3);
            $VALUES = (new ItemConditionState[] {
                ANY, NEW, USED, UNSPECIFIED
            });
        }

        private ItemConditionState(String s, int i)
        {
            super(s, i);
        }
    }


    public final String conditionConstraintValues[];
    public final String conditionDisplayValues[];

    public ItemConditionHelper(Context context)
    {
        context = context.getResources();
        conditionDisplayValues = context.getStringArray(0x7f0e000c);
        conditionConstraintValues = context.getStringArray(0x7f0e000d);
    }

    private ItemConditionState getState(String s)
    {
        ItemConditionState itemconditionstate1 = ItemConditionState.ANY;
        int i = 0;
        do
        {
label0:
            {
                ItemConditionState itemconditionstate = itemconditionstate1;
                if (i < conditionDisplayValues.length)
                {
                    if (!conditionDisplayValues[i].equals(s))
                    {
                        break label0;
                    }
                    itemconditionstate = ItemConditionState.values()[i];
                }
                return itemconditionstate;
            }
            i++;
        } while (true);
    }

    public ItemCondition getCondition(String s)
    {
        return new ItemCondition(s);
    }

    public int getConditionConstraintIndex(String s)
    {
        for (int i = 0; i < conditionConstraintValues.length; i++)
        {
            if (conditionConstraintValues[i].equals(s))
            {
                return i;
            }
        }

        return 0;
    }

    public String getLocalizedCondition(String s)
    {
        return conditionDisplayValues[getConditionConstraintIndex(s)];
    }

}

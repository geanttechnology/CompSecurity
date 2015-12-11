// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.j.b;


public class i
{
    public static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a EXPERIMENT_PURCHASE_CTA_BUY;
        public static final a EXPERIMENT_PURCHASE_CTA_COMPLETE_ORDER;
        public static final a EXPERIMENT_PURCHASE_CTA_COMPLETE_PURCHASE;
        public static final a EXPERIMENT_PURCHASE_CTA_DEFAULT;
        public static final a EXPERIMENT_PURCHASE_CTA_SUBMIT_ORDER;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/ui/j/b/i$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            EXPERIMENT_PURCHASE_CTA_SUBMIT_ORDER = new a("EXPERIMENT_PURCHASE_CTA_SUBMIT_ORDER", 0);
            EXPERIMENT_PURCHASE_CTA_COMPLETE_ORDER = new a("EXPERIMENT_PURCHASE_CTA_COMPLETE_ORDER", 1);
            EXPERIMENT_PURCHASE_CTA_COMPLETE_PURCHASE = new a("EXPERIMENT_PURCHASE_CTA_COMPLETE_PURCHASE", 2);
            EXPERIMENT_PURCHASE_CTA_BUY = new a("EXPERIMENT_PURCHASE_CTA_BUY", 3);
            EXPERIMENT_PURCHASE_CTA_DEFAULT = new a("EXPERIMENT_PURCHASE_CTA_DEFAULT", 4);
            $VALUES = (new a[] {
                EXPERIMENT_PURCHASE_CTA_SUBMIT_ORDER, EXPERIMENT_PURCHASE_CTA_COMPLETE_ORDER, EXPERIMENT_PURCHASE_CTA_COMPLETE_PURCHASE, EXPERIMENT_PURCHASE_CTA_BUY, EXPERIMENT_PURCHASE_CTA_DEFAULT
            });
        }

        private a(String s, int j)
        {
            super(s, j);
        }
    }


    private a mPurchaseCTAExperiment;

    public i()
    {
        mPurchaseCTAExperiment = a.EXPERIMENT_PURCHASE_CTA_DEFAULT;
    }

    public a a()
    {
        return mPurchaseCTAExperiment;
    }

    public void a(a a1)
    {
        mPurchaseCTAExperiment = a1;
    }
}

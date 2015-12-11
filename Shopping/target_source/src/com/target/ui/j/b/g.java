// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.j.b;


public class g
{
    public static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a EXPERIMENT_DEFAULT;
        public static final a EXPERIMENT_SHOW_EXPRESS_CHECKOUT;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/ui/j/b/g$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            EXPERIMENT_SHOW_EXPRESS_CHECKOUT = new a("EXPERIMENT_SHOW_EXPRESS_CHECKOUT", 0);
            EXPERIMENT_DEFAULT = new a("EXPERIMENT_DEFAULT", 1);
            $VALUES = (new a[] {
                EXPERIMENT_SHOW_EXPRESS_CHECKOUT, EXPERIMENT_DEFAULT
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    private a mExpressCheckoutExperiment;

    g()
    {
        mExpressCheckoutExperiment = a.EXPERIMENT_DEFAULT;
    }

    public a a()
    {
        return mExpressCheckoutExperiment;
    }

    public void a(a a1)
    {
        mExpressCheckoutExperiment = a1;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.j.b;


public class f
{
    public static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a EXPERIMENT_DEFAULT;
        public static final a EXPERIMENT_WITH_PAYPAL;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/ui/j/b/f$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            EXPERIMENT_DEFAULT = new a("EXPERIMENT_DEFAULT", 0);
            EXPERIMENT_WITH_PAYPAL = new a("EXPERIMENT_WITH_PAYPAL", 1);
            $VALUES = (new a[] {
                EXPERIMENT_DEFAULT, EXPERIMENT_WITH_PAYPAL
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    a mExperiment;

    public f()
    {
        mExperiment = a.EXPERIMENT_DEFAULT;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.j.b;


public class c
{
    public static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a EXPERIMENT_DEFAULT;
        public static final a EXPERIMENT_NEW_TAB;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/ui/j/b/c$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            EXPERIMENT_DEFAULT = new a("EXPERIMENT_DEFAULT", 0);
            EXPERIMENT_NEW_TAB = new a("EXPERIMENT_NEW_TAB", 1);
            $VALUES = (new a[] {
                EXPERIMENT_DEFAULT, EXPERIMENT_NEW_TAB
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    private a mDealsTabExperiment;

    public c()
    {
        mDealsTabExperiment = a.EXPERIMENT_DEFAULT;
    }

    public a a()
    {
        return mDealsTabExperiment;
    }

    public void a(a a1)
    {
        mDealsTabExperiment = a1;
    }
}

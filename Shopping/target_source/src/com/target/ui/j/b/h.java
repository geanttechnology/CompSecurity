// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.j.b;


public class h
{
    public static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a EXPERIMENT_DEALS_TAG_AND_RATING;
        public static final a EXPERIMENT_DEALS_TAG_ONLY;
        public static final a EXPERIMENT_DEFAULT;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/ui/j/b/h$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            EXPERIMENT_DEFAULT = new a("EXPERIMENT_DEFAULT", 0);
            EXPERIMENT_DEALS_TAG_AND_RATING = new a("EXPERIMENT_DEALS_TAG_AND_RATING", 1);
            EXPERIMENT_DEALS_TAG_ONLY = new a("EXPERIMENT_DEALS_TAG_ONLY", 2);
            $VALUES = (new a[] {
                EXPERIMENT_DEFAULT, EXPERIMENT_DEALS_TAG_AND_RATING, EXPERIMENT_DEALS_TAG_ONLY
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    private a mExperiment;

    public h()
    {
        mExperiment = a.EXPERIMENT_DEFAULT;
    }

    public a a()
    {
        return mExperiment;
    }

    public void a(a a1)
    {
        mExperiment = a1;
    }
}

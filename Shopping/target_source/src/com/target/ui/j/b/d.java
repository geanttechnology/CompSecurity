// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.j.b;


public class d
{
    public static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a EXPERIMENT_DEFAULT;
        public static final a EXPERIMENT_SHOW_CARD_STREAM;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/ui/j/b/d$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            EXPERIMENT_SHOW_CARD_STREAM = new a("EXPERIMENT_SHOW_CARD_STREAM", 0);
            EXPERIMENT_DEFAULT = new a("EXPERIMENT_DEFAULT", 1);
            $VALUES = (new a[] {
                EXPERIMENT_SHOW_CARD_STREAM, EXPERIMENT_DEFAULT
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    private a mInStoreExperienceExperiment;

    d()
    {
        mInStoreExperienceExperiment = a.EXPERIMENT_DEFAULT;
    }

    public a a()
    {
        return mInStoreExperienceExperiment;
    }

    public void a(a a1)
    {
        mInStoreExperienceExperiment = a1;
    }
}

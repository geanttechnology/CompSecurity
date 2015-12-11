// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.j.b;


public class e
{
    public static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a EXPERIMENT_DEFAULT;
        public static final a EXPERIMENT_GRID_VIEW;
        public static final a EXPERIMENT_LIST_VIEW;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/ui/j/b/e$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            EXPERIMENT_LIST_VIEW = new a("EXPERIMENT_LIST_VIEW", 0);
            EXPERIMENT_GRID_VIEW = new a("EXPERIMENT_GRID_VIEW", 1);
            EXPERIMENT_DEFAULT = new a("EXPERIMENT_DEFAULT", 2);
            $VALUES = (new a[] {
                EXPERIMENT_LIST_VIEW, EXPERIMENT_GRID_VIEW, EXPERIMENT_DEFAULT
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    private a mListOrGridExperiment;

    e()
    {
        mListOrGridExperiment = a.EXPERIMENT_DEFAULT;
    }

    public a a()
    {
        return mListOrGridExperiment;
    }

    public void a(a a1)
    {
        mListOrGridExperiment = a1;
    }
}

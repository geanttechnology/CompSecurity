// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;

import java.util.Comparator;
import java.util.List;

public abstract class SortPolicy
{
    public static final class SortType extends Enum
    {

        private static final SortType $VALUES[];
        public static final SortType ALPHA;
        public static final SortType EXPIRING;
        public static final SortType NEW;
        public static final SortType NONE;
        public static final SortType POPULAR;
        public static final SortType RECENT;
        public static final SortType YEAR;

        public static SortType valueOf(String s)
        {
            return (SortType)Enum.valueOf(com/xfinity/playerlib/view/browseprograms/SortPolicy$SortType, s);
        }

        public static SortType[] values()
        {
            return (SortType[])$VALUES.clone();
        }

        static 
        {
            NONE = new SortType("NONE", 0);
            YEAR = new SortType("YEAR", 1);
            ALPHA = new SortType("ALPHA", 2);
            NEW = new SortType("NEW", 3);
            RECENT = new SortType("RECENT", 4);
            EXPIRING = new SortType("EXPIRING", 5);
            POPULAR = new SortType("POPULAR", 6);
            $VALUES = (new SortType[] {
                NONE, YEAR, ALPHA, NEW, RECENT, EXPIRING, POPULAR
            });
        }

        private SortType(String s, int i)
        {
            super(s, i);
        }
    }


    public SortPolicy()
    {
    }

    public abstract Comparator getComparator(SortType sorttype);

    public Comparator getCurrentSortComparator()
    {
        return getComparator(getCurrentSortType());
    }

    public abstract SortType getCurrentSortType();

    public abstract List getSortTypes();

    public abstract void setCurrentSortType(SortType sorttype);
}

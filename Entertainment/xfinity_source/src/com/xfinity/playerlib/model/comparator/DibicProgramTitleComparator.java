// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.comparator;

import com.xfinity.playerlib.model.dibic.DibicProgram;
import java.util.Comparator;

public class DibicProgramTitleComparator
    implements Comparator
{

    private final boolean isAscending;

    public DibicProgramTitleComparator(boolean flag)
    {
        isAscending = flag;
    }

    public int compare(DibicProgram dibicprogram, DibicProgram dibicprogram1)
    {
        int i = dibicprogram.getSortTitle().compareToIgnoreCase(dibicprogram1.getSortTitle());
        if (isAscending)
        {
            return i;
        } else
        {
            return -i;
        }
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((DibicProgram)obj, (DibicProgram)obj1);
    }
}

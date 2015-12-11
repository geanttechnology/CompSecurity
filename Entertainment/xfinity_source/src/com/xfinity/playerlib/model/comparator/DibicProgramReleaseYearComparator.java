// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.comparator;

import com.xfinity.playerlib.model.dibic.DibicProgram;
import java.util.Comparator;

// Referenced classes of package com.xfinity.playerlib.model.comparator:
//            DibicProgramTitleComparator

public class DibicProgramReleaseYearComparator
    implements Comparator
{

    private final DibicProgramTitleComparator titleComparator = new DibicProgramTitleComparator(true);

    public DibicProgramReleaseYearComparator()
    {
    }

    public int compare(DibicProgram dibicprogram, DibicProgram dibicprogram1)
    {
        int j = dibicprogram1.getReleaseYear() - dibicprogram.getReleaseYear();
        int i = j;
        if (j == 0)
        {
            i = titleComparator.compare(dibicprogram, dibicprogram1);
        }
        return i;
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((DibicProgram)obj, (DibicProgram)obj1);
    }
}

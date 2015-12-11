// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.comparator;

import com.xfinity.playerlib.model.dibic.DibicProgram;
import java.util.Comparator;

// Referenced classes of package com.xfinity.playerlib.model.comparator:
//            DibicProgramTitleComparator

public class DibicProgramNewProgramComparator
    implements Comparator
{

    private final DibicProgramTitleComparator titleComparator = new DibicProgramTitleComparator(true);

    public DibicProgramNewProgramComparator()
    {
    }

    public int compare(DibicProgram dibicprogram, DibicProgram dibicprogram1)
    {
        if (dibicprogram.isNew() && !dibicprogram1.isNew())
        {
            return -1;
        }
        if (!dibicprogram.isNew() && dibicprogram1.isNew())
        {
            return 1;
        } else
        {
            return titleComparator.compare(dibicprogram, dibicprogram1);
        }
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((DibicProgram)obj, (DibicProgram)obj1);
    }
}

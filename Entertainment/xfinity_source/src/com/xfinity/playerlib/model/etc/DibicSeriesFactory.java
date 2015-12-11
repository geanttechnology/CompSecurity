// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.etc;

import com.xfinity.playerlib.model.dibic.DibicProgram;
import com.xfinity.playerlib.model.dibic.DibicSeries;

// Referenced classes of package com.xfinity.playerlib.model.etc:
//            DibicProgramFactory

public class DibicSeriesFactory
    implements DibicProgramFactory
{

    public DibicSeriesFactory()
    {
    }

    public volatile DibicProgram create()
    {
        return create();
    }

    public DibicSeries create()
    {
        return new DibicSeries();
    }
}

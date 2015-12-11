// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.etc;

import com.xfinity.playerlib.model.dibic.DibicMovie;
import com.xfinity.playerlib.model.dibic.DibicProgram;

// Referenced classes of package com.xfinity.playerlib.model.etc:
//            DibicProgramFactory

public class DibicMovieFactory
    implements DibicProgramFactory
{

    public DibicMovieFactory()
    {
    }

    public DibicMovie create()
    {
        return new DibicMovie();
    }

    public volatile DibicProgram create()
    {
        return create();
    }
}

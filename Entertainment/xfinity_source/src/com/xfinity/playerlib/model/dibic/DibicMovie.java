// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.dibic;


// Referenced classes of package com.xfinity.playerlib.model.dibic:
//            DibicProgram

public class DibicMovie extends DibicProgram
{

    public DibicMovie()
    {
    }

    public com.xfinity.playerlib.model.MerlinId.Namespace getMerlinIdNamespace()
    {
        return com.xfinity.playerlib.model.MerlinId.Namespace.Movie;
    }

    public boolean isMovie()
    {
        return true;
    }
}

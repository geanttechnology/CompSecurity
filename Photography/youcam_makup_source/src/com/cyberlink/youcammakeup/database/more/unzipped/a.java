// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.unzipped;

import java.io.File;

// Referenced classes of package com.cyberlink.youcammakeup.database.more.unzipped:
//            c

public abstract class a extends c
{

    protected final int b;

    public a(File file, int i, int j)
    {
        super(file, i);
        b = j;
    }

    public int a()
    {
        return b;
    }
}

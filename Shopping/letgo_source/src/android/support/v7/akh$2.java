// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.IOException;

// Referenced classes of package android.support.v7:
//            ald, akh, alb

static final class eption extends ald
{

    public eption a(alb alb, int i)
        throws IOException
    {
        throw new IllegalStateException((new StringBuilder()).append("Unrecognized type of request: ").append(alb).toString());
    }

    public boolean a(alb alb)
    {
        return true;
    }

    eption()
    {
    }
}

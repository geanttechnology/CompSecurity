// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package android.support.v7:
//            ajj, ail, ais

private static class a
    implements ajj
{

    private final ajj a;

    public InputStream a(String s, Object obj)
        throws IOException
    {
        obj = a.a(s, obj);
        switch (a[a(s).ordinal()])
        {
        default:
            return ((InputStream) (obj));

        case 1: // '\001'
        case 2: // '\002'
            return new ais(((InputStream) (obj)));
        }
    }

    public (ajj ajj1)
    {
        a = ajj1;
    }
}

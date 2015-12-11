// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.InputStream;

public abstract class eml
{

    public eml()
    {
    }

    public abstract InputStream a();

    public byte[] b()
    {
        emq emq1 = emq.a();
        byte abyte0[] = emm.a((InputStream)emq1.a(a()));
        emq1.close();
        return abyte0;
        Object obj;
        obj;
        throw emq1.a(((Throwable) (obj)));
        obj;
        emq1.close();
        throw obj;
    }
}

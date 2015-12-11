// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class cxi
    implements crb
{

    private final bns a;
    private final bnq b = a.C();

    public cxi(bns bns1)
    {
        a = (bns)b.a(bns1);
    }

    private static void a(InputStream inputstream)
    {
        if (inputstream == null)
        {
            return;
        }
        try
        {
            inputstream.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            return;
        }
    }

    public final void a(Object obj, bhv bhv1)
    {
        cxu cxu1;
        cxu1 = (cxu)obj;
        b.b();
        b.a(cxu1);
        b.a(cxu1.f);
        obj = new File(cxu1.f);
        if (!((File) (obj)).exists()) goto _L2; else goto _L1
_L1:
        BufferedInputStream bufferedinputstream = new BufferedInputStream(new FileInputStream(((File) (obj))), 4096);
        obj = bufferedinputstream;
        bhv1.a(cxu1, ((cpu)a.a(bufferedinputstream, b)).b());
        a(((InputStream) (bufferedinputstream)));
        return;
        Exception exception;
        exception;
        bufferedinputstream = null;
_L6:
        obj = bufferedinputstream;
        bhv1.a(cxu1, exception);
        a(((InputStream) (bufferedinputstream)));
        return;
        bhv1;
        obj = null;
_L4:
        a(((InputStream) (obj)));
        throw bhv1;
_L2:
        bhv1.a(cxu1, new IOException());
        return;
        bhv1;
        if (true) goto _L4; else goto _L3
_L3:
        exception;
        if (true) goto _L6; else goto _L5
_L5:
    }
}

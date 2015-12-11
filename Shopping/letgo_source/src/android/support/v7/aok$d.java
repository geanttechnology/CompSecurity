// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.IOException;
import java.util.concurrent.Callable;

// Referenced classes of package android.support.v7:
//            aok

protected static abstract class able
    implements Callable
{

    protected abstract Object b()
        throws able, IOException;

    protected abstract void c()
        throws IOException;

    public Object call()
        throws able
    {
        boolean flag = true;
        Object obj = b();
        try
        {
            c();
        }
        catch (IOException ioexception)
        {
            throw new <init>(ioexception);
        }
        return obj;
        Object obj1;
        obj1;
        throw obj1;
        obj1;
_L4:
        c();
_L2:
        throw obj1;
        obj1;
        throw new <init>(((IOException) (obj1)));
        IOException ioexception1;
        ioexception1;
        if (flag) goto _L2; else goto _L1
_L1:
        throw new <init>(ioexception1);
        obj1;
        flag = false;
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected able()
    {
    }
}

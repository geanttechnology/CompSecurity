// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a.a.e;

import java.io.IOException;
import java.util.concurrent.Callable;

// Referenced classes of package c.a.a.a.a.e:
//            i

public abstract class j
    implements Callable
{

    protected j()
    {
    }

    protected abstract Object a();

    protected abstract void b();

    public Object call()
    {
        boolean flag = true;
        Object obj = a();
        try
        {
            b();
        }
        catch (IOException ioexception)
        {
            throw new i(ioexception);
        }
        return obj;
        Object obj1;
        obj1;
        throw obj1;
        obj1;
_L4:
        b();
_L2:
        throw obj1;
        obj1;
        throw new i(((IOException) (obj1)));
        IOException ioexception1;
        ioexception1;
        if (flag) goto _L2; else goto _L1
_L1:
        throw new i(ioexception1);
        obj1;
        flag = false;
        if (true) goto _L4; else goto _L3
_L3:
    }
}

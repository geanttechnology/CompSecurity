// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.IOException;
import java.util.concurrent.Callable;

public abstract class bwj
    implements Callable
{

    protected bwj()
    {
    }

    protected abstract Object b();

    protected abstract void c();

    public Object call()
    {
        boolean flag = true;
        Object obj = b();
        try
        {
            c();
        }
        catch (IOException ioexception)
        {
            throw new io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException(ioexception);
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
        throw new io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException(((IOException) (obj1)));
        IOException ioexception1;
        ioexception1;
        if (flag) goto _L2; else goto _L1
_L1:
        throw new io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException(ioexception1);
        obj1;
        flag = false;
        if (true) goto _L4; else goto _L3
_L3:
    }
}

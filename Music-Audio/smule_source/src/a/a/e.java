// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import java.net.SocketImpl;
import java.net.SocketImplFactory;

// Referenced classes of package a.a:
//            cz, d, eq, ds

public final class e
    implements SocketImplFactory
{

    private Class a;
    private SocketImplFactory b;
    private eq c;
    private ds d;

    public e(Class class1, eq eq, ds ds)
    {
        c = eq;
        d = ds;
        a = class1;
        class1 = a;
        if (class1 == null)
        {
            throw new cz("Class was null");
        }
        try
        {
            class1.newInstance();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new cz("Unable to create new instance", class1);
        }
    }

    public e(SocketImplFactory socketimplfactory, eq eq, ds ds)
    {
        c = eq;
        d = ds;
        b = socketimplfactory;
        socketimplfactory = b;
        if (socketimplfactory == null)
        {
            throw new cz("Factory was null");
        }
        try
        {
            if (socketimplfactory.createSocketImpl() == null)
            {
                throw new cz("Factory does not work");
            }
        }
        // Misplaced declaration of an exception variable
        catch (SocketImplFactory socketimplfactory)
        {
            throw new cz("Factory does not work", socketimplfactory);
        }
    }

    public final SocketImpl createSocketImpl()
    {
        SocketImpl socketimpl = null;
        if (b == null) goto _L2; else goto _L1
_L1:
        socketimpl = b.createSocketImpl();
_L3:
        Object obj;
        Object obj1;
        if (socketimpl != null)
        {
            return new d(c, d, socketimpl);
        } else
        {
            return socketimpl;
        }
_L2:
        obj = a;
        obj = (SocketImpl)a.newInstance();
        socketimpl = ((SocketImpl) (obj));
          goto _L3
        obj1;
        ((IllegalAccessException) (obj1)).printStackTrace();
          goto _L3
        obj1;
        ((InstantiationException) (obj1)).printStackTrace();
          goto _L3
    }
}

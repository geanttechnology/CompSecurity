// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.RemoteException;
import com.google.android.gms.internal.fh;
import com.google.android.gms.internal.fj;

public abstract class aag extends abn
{

    private final fh a;
    private final aaf b;

    public aag(fh fh, aaf aaf1)
    {
        a = fh;
        b = aaf1;
    }

    private static fj a(aan aan1, fh fh)
    {
        try
        {
            aan1 = aan1.a(fh);
        }
        // Misplaced declaration of an exception variable
        catch (aan aan1)
        {
            acb.d("Could not fetch ad response from ad request service.", aan1);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (aan aan1)
        {
            acb.d("Could not fetch ad response from ad request service due to an Exception.", aan1);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (aan aan1)
        {
            acb.d("Could not fetch ad response from ad request service due to an Exception.", aan1);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (aan aan1)
        {
            abi.a(aan1);
            return null;
        }
        return aan1;
    }

    public final void a()
    {
        Object obj = d();
        if (obj != null) goto _L2; else goto _L1
_L1:
        obj = new fj(0);
_L4:
        c();
        b.a(((fj) (obj)));
        return;
_L2:
        fj fj1 = a(((aan) (obj)), a);
        obj = fj1;
        if (fj1 != null) goto _L4; else goto _L3
_L3:
        obj = new fj(0);
          goto _L4
        Exception exception;
        exception;
        c();
        throw exception;
    }

    public final void b()
    {
        c();
    }

    public abstract void c();

    public abstract aan d();
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

public abstract class qj extends qh
    implements ra
{

    private final qf b;
    private final qm c;
    private qy d;

    protected qj(qf qf1, qm qm1)
    {
        super(qm1.a());
        b = (qf)ady.a(qf1);
        c = qm1;
    }

    private void a(RemoteException remoteexception)
    {
        b(new Status(8, remoteexception.getLocalizedMessage(), null));
    }

    public final void a(qd qd)
    {
        try
        {
            b(qd);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (qd qd)
        {
            a(((RemoteException) (qd)));
            throw qd;
        }
        // Misplaced declaration of an exception variable
        catch (qd qd)
        {
            a(((RemoteException) (qd)));
        }
    }

    public void a(qy qy1)
    {
        d = qy1;
    }

    public final void b(Status status)
    {
        boolean flag;
        if (!status.e())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ady.b(flag, "Failed result must not be success");
        a(a(status));
    }

    protected abstract void b(qd qd);

    protected void e()
    {
        super.e();
        if (d != null)
        {
            d.a(this);
            d = null;
        }
    }

    public final qf f()
    {
        return b;
    }

    public int g()
    {
        return 0;
    }
}

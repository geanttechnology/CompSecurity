// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

public abstract class awg extends awe
    implements awx
{

    private final awd a;
    private awv c;

    public awg(awd awd1)
    {
        a = (awd)a.d(awd1);
    }

    private void a(RemoteException remoteexception)
    {
        c(new Status(8, remoteexception.getLocalizedMessage(), null));
    }

    public abstract void a(awb awb1);

    public final void a(awv awv1)
    {
        c = awv1;
    }

    protected final void b()
    {
        super.b();
        if (c != null)
        {
            c.a(this);
            c = null;
        }
    }

    public final void b(awb awb1)
    {
        if (b == null)
        {
            super.b = new awf(awb1.d());
        }
        try
        {
            a(awb1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (awb awb1)
        {
            a(awb1);
            throw awb1;
        }
        // Misplaced declaration of an exception variable
        catch (awb awb1)
        {
            a(awb1);
        }
    }

    public final awd c()
    {
        return a;
    }

    public final void c(Status status)
    {
        boolean flag;
        if (!status.a())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a.b(flag, "Failed result must not be success");
        a(a(status));
    }
}

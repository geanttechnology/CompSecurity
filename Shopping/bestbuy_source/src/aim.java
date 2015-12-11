// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.RemoteException;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public final class aim
{

    private final ajo a;
    private ajh b;

    protected aim(ajo ajo1)
    {
        a = (ajo)ady.a(ajo1);
    }

    public final ank a(MarkerOptions markeroptions)
    {
        try
        {
            markeroptions = a.a(markeroptions);
        }
        // Misplaced declaration of an exception variable
        catch (MarkerOptions markeroptions)
        {
            throw new anl(markeroptions);
        }
        if (markeroptions == null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        markeroptions = new ank(markeroptions);
        return markeroptions;
        return null;
    }

    public final CameraPosition a()
    {
        CameraPosition cameraposition;
        try
        {
            cameraposition = a.a();
        }
        catch (RemoteException remoteexception)
        {
            throw new anl(remoteexception);
        }
        return cameraposition;
    }

    public final void a(aik aik1)
    {
        try
        {
            a.a(aik1.a());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (aik aik1)
        {
            throw new anl(aik1);
        }
    }

    public final void a(ain ain)
    {
        if (ain == null)
        {
            try
            {
                a.a(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ain ain)
            {
                throw new anl(ain);
            }
        }
        a.a(new ala(ain) {

            final ain a;
            final aim b;

            public ry a(aop aop)
            {
                return sb.a(a.a(new ank(aop)));
            }

            public ry b(aop aop)
            {
                return sb.a(a.b(new ank(aop)));
            }

            
            {
                b = aim.this;
                a = ain1;
                super();
            }
        });
        return;
    }

    public final void a(aio aio)
    {
        if (aio == null)
        {
            try
            {
                a.a(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (aio aio)
            {
                throw new anl(aio);
            }
        }
        a.a(new alm(aio) {

            final aio a;
            final aim b;

            public void a(aop aop)
            {
                a.b(new ank(aop));
            }

            
            {
                b = aim.this;
                a = aio1;
                super();
            }
        });
        return;
    }

    public final void a(aip aip)
    {
        if (aip == null)
        {
            try
            {
                a.a(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (aip aip)
            {
                throw new anl(aip);
            }
        }
        a.a(new als(aip) {

            final aip a;
            final aim b;

            public void a(LatLng latlng)
            {
                a.a(latlng);
            }

            
            {
                b = aim.this;
                a = aip1;
                super();
            }
        });
        return;
    }

    public final void a(aiq aiq)
    {
        if (aiq == null)
        {
            try
            {
                a.a(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (aiq aiq)
            {
                throw new anl(aiq);
            }
        }
        a.a(new ame(aiq) {

            final aiq a;
            final aim b;

            public boolean a(aop aop)
            {
                return a.a(new ank(aop));
            }

            
            {
                b = aim.this;
                a = aiq1;
                super();
            }
        });
        return;
    }

    public final void a(boolean flag)
    {
        try
        {
            a.c(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new anl(remoteexception);
        }
    }

    public final void b()
    {
        try
        {
            a.e();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new anl(remoteexception);
        }
    }

    public final ajh c()
    {
        ajh ajh1;
        try
        {
            if (b == null)
            {
                b = new ajh(a.k());
            }
            ajh1 = b;
        }
        catch (RemoteException remoteexception)
        {
            throw new anl(remoteexception);
        }
        return ajh1;
    }
}

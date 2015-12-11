// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationRequest;

public class aeq
    implements ahr
{

    public aeq()
    {
    }

    public qq a(qm qm1, ahx ahx)
    {
        return qm1.b(new aer(qm1, ahx) {

            final ahx b;
            final aeq c;

            protected void a(afd afd1)
            {
                afd1.a(b);
                a(((qt) (Status.a)));
            }

            protected void b(qd qd)
            {
                a((afd)qd);
            }

            
            {
                c = aeq.this;
                b = ahx;
                super(qm1);
            }
        });
    }

    public qq a(qm qm1, LocationRequest locationrequest, ahx ahx)
    {
        return qm1.b(new aer(qm1, locationrequest, ahx) {

            final LocationRequest b;
            final ahx c;
            final aeq d;

            protected void a(afd afd1)
            {
                afd1.a(b, c, null);
                a(((qt) (Status.a)));
            }

            protected void b(qd qd)
            {
                a((afd)qd);
            }

            
            {
                d = aeq.this;
                b = locationrequest;
                c = ahx;
                super(qm1);
            }
        });
    }
}

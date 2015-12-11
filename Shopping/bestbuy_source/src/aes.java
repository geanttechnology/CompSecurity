// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.PendingIntent;
import android.util.Log;
import com.google.android.gms.location.GeofencingRequest;
import java.util.List;

public class aes
    implements ahu
{

    public aes()
    {
    }

    public qq a(qm qm1, PendingIntent pendingintent)
    {
        return qm1.b(new aet(qm1, pendingintent) {

            final PendingIntent b;
            final aes c;

            protected void a(afd afd1)
            {
                aih aih = new aih(this) {

                    final _cls2 a;

                    public void a(int i, PendingIntent pendingintent)
                    {
                        a.a(aia.b(i));
                    }

                    public void a(int i, String as[])
                    {
                        Log.wtf("GeofencingImpl", "Request ID callback shouldn't have been called");
                    }

            
            {
                a = _pcls2;
                super();
            }
                };
                afd1.a(b, aih);
            }

            protected void b(qd qd)
            {
                a((afd)qd);
            }

            
            {
                c = aes.this;
                b = pendingintent;
                super(qm1);
            }
        });
    }

    public qq a(qm qm1, GeofencingRequest geofencingrequest, PendingIntent pendingintent)
    {
        return qm1.b(new aet(qm1, geofencingrequest, pendingintent) {

            final GeofencingRequest b;
            final PendingIntent c;
            final aes d;

            protected void a(afd afd1)
            {
                aig aig = new aig(this) {

                    final _cls1 a;

                    public void a(int i, String as[])
                    {
                        a.a(aia.b(i));
                    }

            
            {
                a = _pcls1;
                super();
            }
                };
                afd1.a(b, c, aig);
            }

            protected void b(qd qd)
            {
                a((afd)qd);
            }

            
            {
                d = aes.this;
                b = geofencingrequest;
                c = pendingintent;
                super(qm1);
            }
        });
    }

    public qq a(qm qm1, List list)
    {
        return qm1.b(new aet(qm1, list) {

            final List b;
            final aes c;

            protected void a(afd afd1)
            {
                aih aih = new aih(this) {

                    final _cls3 a;

                    public void a(int i, PendingIntent pendingintent)
                    {
                        Log.wtf("GeofencingImpl", "PendingIntent callback shouldn't have been called");
                    }

                    public void a(int i, String as[])
                    {
                        a.a(aia.b(i));
                    }

            
            {
                a = _pcls3;
                super();
            }
                };
                afd1.a(b, aih);
            }

            protected void b(qd qd)
            {
                a((afd)qd);
            }

            
            {
                c = aes.this;
                b = list;
                super(qm1);
            }
        });
    }

    public qq a(qm qm1, List list, PendingIntent pendingintent)
    {
        ahw ahw1 = new ahw();
        ahw1.a(list);
        ahw1.a(5);
        return a(qm1, ahw1.a(), pendingintent);
    }
}

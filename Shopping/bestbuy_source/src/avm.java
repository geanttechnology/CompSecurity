// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.common.api.Status;

public final class avm
    implements auf
{

    public avm()
    {
    }

    public qq a(qm qm1)
    {
        return qm1.a(new awf(qm1) {

            final avm b;

            protected qt a(Status status)
            {
                return c(status);
            }

            protected void a(awc awc1)
            {
                awc1.a(this);
            }

            protected void b(qd qd)
            {
                a((awc)qd);
            }

            protected aug c(Status status)
            {
                return new avn(status, null);
            }

            
            {
                b = avm.this;
                super(qm1);
            }
        });
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.g;
import com.google.android.gms.plus.a;
import com.google.android.gms.plus.d;

public final class jo
    implements com.google.android.gms.plus.a
{
    private static abstract class a extends com.google.android.gms.plus.d.b
    {

        public final g a(Status status)
        {
            return status;
        }

        private a(c c1)
        {
            super(c1);
        }

        a(c c1, byte byte0)
        {
            this(c1);
        }
    }


    public jo()
    {
    }

    public final e a(c c1)
    {
        return c1.b(new a(c1) {

            final jo c;

            protected final void a(com.google.android.gms.common.api.a.b b1)
            {
                com.google.android.gms.plus.internal.d d1 = (com.google.android.gms.plus.internal.d)b1;
                d1.l();
                d1.p();
                b1 = new com.google.android.gms.plus.internal.d.a(this);
                try
                {
                    ((com.google.android.gms.plus.internal.c)d1.m()).b(b1);
                    return;
                }
                catch (RemoteException remoteexception)
                {
                    b1.a(8, null);
                }
            }

            
            {
                c = jo.this;
                super(c1, (byte)0);
            }
        });
    }

    public final void b(c c1)
    {
        c1 = d.a(c1, false);
        if (c1 != null)
        {
            c1.p();
        }
    }

    public final String c(c c1)
    {
        return d.a(c1, true).c();
    }
}

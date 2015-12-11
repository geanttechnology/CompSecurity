// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.g;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;

// Referenced classes of package com.google.android.gms.location.internal:
//            j

public class o
    implements com.google.android.gms.location.o
{

    public o()
    {
    }

    public e a(c c1, LocationSettingsRequest locationsettingsrequest)
    {
        return a(c1, locationsettingsrequest, null);
    }

    public e a(c c1, LocationSettingsRequest locationsettingsrequest, String s)
    {
        return c1.a(new com.google.android.gms.location.m.a(c1, locationsettingsrequest, s) {

            final LocationSettingsRequest b;
            final String c;
            final o d;

            public LocationSettingsResult a(Status status)
            {
                return new LocationSettingsResult(status);
            }

            protected volatile void a(com.google.android.gms.common.api.a.c c2)
                throws RemoteException
            {
                a((j)c2);
            }

            protected void a(j j1)
                throws RemoteException
            {
                j1.a(b, this, c);
            }

            public g b(Status status)
            {
                return a(status);
            }

            
            {
                d = o.this;
                b = locationsettingsrequest;
                c = s;
                super(c1);
            }
        });
    }
}

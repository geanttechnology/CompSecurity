// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.internal:
//            dw, ec, hl

public class hm extends dw
{
    final class a extends dw.b
        implements com.google.android.gms.panorama.Panorama.a
    {

        public final Status Dl;
        public final Intent Dm;
        final hm Dn;
        public final int type;

        protected void aL()
        {
        }

        protected void b(Object obj)
        {
            c((com.google.android.gms.common.api.a.c)obj);
        }

        protected void c(com.google.android.gms.common.api.a.c c1)
        {
            c1.a(this);
        }

        public Status getStatus()
        {
            return Dl;
        }

        public Intent getViewerIntent()
        {
            return Dm;
        }

        public a(com.google.android.gms.common.api.a.c c1, Status status, int i, Intent intent)
        {
            Dn = hm.this;
            super(hm.this, c1);
            Dl = status;
            type = i;
            Dm = intent;
        }
    }

    final class b extends hk.a
    {

        final hm Dn;
        private final com.google.android.gms.common.api.a.c Do;
        private final com.google.android.gms.common.api.a.c Dp;
        private final Uri Dq;

        public void a(int i, Bundle bundle, int j, Intent intent)
        {
            if (Dq != null)
            {
                Dn.getContext().revokeUriPermission(Dq, 1);
            }
            if (bundle != null)
            {
                bundle = (PendingIntent)bundle.getParcelable("pendingIntent");
            } else
            {
                bundle = null;
            }
            bundle = new Status(i, null, bundle);
            if (Dp != null)
            {
                Dn.a(Dn. new c(Dp, bundle, intent));
            } else
            if (Do != null)
            {
                Dn.a(Dn. new a(Do, bundle, j, intent));
                return;
            }
        }

        public b(com.google.android.gms.common.api.a.c c1, com.google.android.gms.common.api.a.c c2, Uri uri)
        {
            Dn = hm.this;
            super();
            Do = c1;
            Dp = c2;
            Dq = uri;
        }
    }

    final class c extends dw.b
        implements com.google.android.gms.panorama.Panorama.PanoramaResult
    {

        private final Status Dl;
        private final Intent Dm;
        final hm Dn;

        protected void aL()
        {
        }

        protected void b(Object obj)
        {
            c((com.google.android.gms.common.api.a.c)obj);
        }

        protected void c(com.google.android.gms.common.api.a.c c1)
        {
            c1.a(this);
        }

        public Status getStatus()
        {
            return Dl;
        }

        public Intent getViewerIntent()
        {
            return Dm;
        }

        public c(com.google.android.gms.common.api.a.c c1, Status status, Intent intent)
        {
            Dn = hm.this;
            super(hm.this, c1);
            Dl = status;
            Dm = intent;
        }
    }


    public hm(Context context, com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        this(context, ((com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks) (new dw.c(connectioncallbacks))), ((com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener) (new dw.g(onconnectionfailedlistener))));
    }

    public hm(Context context, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        super(context, connectioncallbacks, onconnectionfailedlistener, (String[])null);
    }

    public void a(com.google.android.gms.common.api.a.c c1, Uri uri, boolean flag)
    {
        Uri uri1;
        if (flag)
        {
            uri1 = uri;
        } else
        {
            uri1 = null;
        }
        a(new b(null, c1, uri1), uri, null, flag);
    }

    protected void a(ec ec1, dw.e e)
        throws RemoteException
    {
        Bundle bundle = new Bundle();
        ec1.a(e, 0x40ba50, getContext().getPackageName(), bundle);
    }

    public void a(b b1, Uri uri, Bundle bundle, boolean flag)
    {
        bP();
        if (flag)
        {
            getContext().grantUriPermission("com.google.android.gms", uri, 1);
        }
        try
        {
            ((hl)bQ()).a(b1, uri, bundle, flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            b1.a(8, null, 0, null);
        }
    }

    protected String am()
    {
        return "com.google.android.gms.panorama.service.START";
    }

    protected String an()
    {
        return "com.google.android.gms.panorama.internal.IPanoramaService";
    }

    public hl at(IBinder ibinder)
    {
        return hl.a.as(ibinder);
    }

    public IInterface p(IBinder ibinder)
    {
        return at(ibinder);
    }
}

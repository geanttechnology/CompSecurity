// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            dw, hu, ig, hr, 
//            ec, id, ey, hn

public class hs extends dw
    implements GooglePlayServicesClient
{
    final class a extends hn
    {

        final hs DM;
        private final com.google.android.gms.common.api.a.c Dp;

        public void a(DataHolder dataholder, String s, String s1)
        {
            Object obj;
            if (dataholder.getMetadata() != null)
            {
                obj = (PendingIntent)dataholder.getMetadata().getParcelable("pendingIntent");
            } else
            {
                obj = null;
            }
            obj = new Status(dataholder.getStatusCode(), null, ((PendingIntent) (obj)));
            if (!((Status) (obj)).isSuccess() && dataholder != null)
            {
                if (!dataholder.isClosed())
                {
                    dataholder.close();
                }
                dataholder = null;
            }
            DM.a(DM. new b(Dp, ((Status) (obj)), dataholder, s, s1));
        }

        public a(com.google.android.gms.common.api.a.c c1)
        {
            DM = hs.this;
            super();
            Dp = c1;
        }
    }

    final class b extends dw.d
        implements com.google.android.gms.plus.Moments.LoadMomentsResult
    {

        final hs DM;
        private final String DN;
        private MomentBuffer DO;
        private final Status jY;
        private final String qT;

        protected void a(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            if (dataholder != null)
            {
                dataholder = new MomentBuffer(dataholder);
            } else
            {
                dataholder = null;
            }
            DO = dataholder;
            c1.a(this);
        }

        protected volatile void a(Object obj, DataHolder dataholder)
        {
            a((com.google.android.gms.common.api.a.c)obj, dataholder);
        }

        public MomentBuffer getMomentBuffer()
        {
            return DO;
        }

        public String getNextPageToken()
        {
            return qT;
        }

        public Status getStatus()
        {
            return jY;
        }

        public String getUpdated()
        {
            return DN;
        }

        public void release()
        {
            if (DO != null)
            {
                DO.close();
            }
        }

        public b(com.google.android.gms.common.api.a.c c1, Status status, DataHolder dataholder, String s, String s1)
        {
            DM = hs.this;
            super(hs.this, c1, dataholder);
            jY = status;
            qT = s;
            DN = s1;
        }
    }

    final class c extends hn
    {

        final hs DM;
        private final com.google.android.gms.common.api.a.c Dp;

        public void a(DataHolder dataholder, String s)
        {
            Object obj;
            if (dataholder.getMetadata() != null)
            {
                obj = (PendingIntent)dataholder.getMetadata().getParcelable("pendingIntent");
            } else
            {
                obj = null;
            }
            obj = new Status(dataholder.getStatusCode(), null, ((PendingIntent) (obj)));
            if (!((Status) (obj)).isSuccess() && dataholder != null)
            {
                if (!dataholder.isClosed())
                {
                    dataholder.close();
                }
                dataholder = null;
            }
            DM.a(DM. new d(Dp, ((Status) (obj)), dataholder, s));
        }

        public c(com.google.android.gms.common.api.a.c c1)
        {
            DM = hs.this;
            super();
            Dp = c1;
        }
    }

    final class d extends dw.d
        implements com.google.android.gms.plus.People.LoadPeopleResult
    {

        final hs DM;
        private PersonBuffer DP;
        private final Status jY;
        private final String qT;

        protected void a(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            if (dataholder != null)
            {
                dataholder = new PersonBuffer(dataholder);
            } else
            {
                dataholder = null;
            }
            DP = dataholder;
            c1.a(this);
        }

        protected volatile void a(Object obj, DataHolder dataholder)
        {
            a((com.google.android.gms.common.api.a.c)obj, dataholder);
        }

        public String getNextPageToken()
        {
            return qT;
        }

        public PersonBuffer getPersonBuffer()
        {
            return DP;
        }

        public Status getStatus()
        {
            return jY;
        }

        public void release()
        {
            if (DP != null)
            {
                DP.close();
            }
        }

        public d(com.google.android.gms.common.api.a.c c1, Status status, DataHolder dataholder, String s)
        {
            DM = hs.this;
            super(hs.this, c1, dataholder);
            jY = status;
            qT = s;
        }
    }

    final class e extends hn
    {

        final hs DM;
        private final com.google.android.gms.common.api.a.c Dp;

        public void b(int i1, Bundle bundle)
        {
            if (bundle != null)
            {
                bundle = (PendingIntent)bundle.getParcelable("pendingIntent");
            } else
            {
                bundle = null;
            }
            bundle = new Status(i1, null, bundle);
            DM.a(DM. new f(Dp, bundle));
        }

        public e(com.google.android.gms.common.api.a.c c1)
        {
            DM = hs.this;
            super();
            Dp = c1;
        }
    }

    final class f extends dw.b
    {

        final hs DM;
        private final Status jY;

        protected void aL()
        {
        }

        protected void b(Object obj)
        {
            c((com.google.android.gms.common.api.a.c)obj);
        }

        protected void c(com.google.android.gms.common.api.a.c c1)
        {
            DM.disconnect();
            if (c1 != null)
            {
                c1.a(jY);
            }
        }

        public f(com.google.android.gms.common.api.a.c c1, Status status)
        {
            DM = hs.this;
            super(hs.this, c1);
            jY = status;
        }
    }


    private Person DK;
    private hu DL;

    public hs(Context context, com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener, hu hu1)
    {
        this(context, ((com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks) (new dw.c(connectioncallbacks))), ((com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener) (new dw.g(onconnectionfailedlistener))), hu1);
    }

    public hs(Context context, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener, hu hu1)
    {
        super(context, connectioncallbacks, onconnectionfailedlistener, hu1.eR());
        DL = hu1;
    }

    protected void a(int i1, IBinder ibinder, Bundle bundle)
    {
        if (i1 == 0 && bundle != null && bundle.containsKey("loaded_person"))
        {
            DK = ig.g(bundle.getByteArray("loaded_person"));
        }
        super.a(i1, ibinder, bundle);
    }

    public void a(com.google.android.gms.common.api.a.c c1, int i1, String s)
    {
        bP();
        c1 = new c(c1);
        try
        {
            ((hr)bQ()).a(c1, 1, i1, -1, s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            c1.a(DataHolder.empty(8), null);
        }
    }

    public void a(com.google.android.gms.common.api.a.c c1, int i1, String s, Uri uri, String s1, String s2)
    {
        bP();
        if (c1 != null)
        {
            c1 = new a(c1);
        } else
        {
            c1 = null;
        }
        try
        {
            ((hr)bQ()).a(c1, i1, s, uri, s1, s2);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            c1.a(DataHolder.empty(8), null, null);
        }
    }

    public void a(com.google.android.gms.common.api.a.c c1, Collection collection)
    {
        bP();
        c1 = new c(c1);
        try
        {
            ((hr)bQ()).a(c1, new ArrayList(collection));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Collection collection)
        {
            c1.a(DataHolder.empty(8), null);
        }
    }

    public void a(com.google.android.gms.common.api.a.c c1, String as[])
    {
        a(c1, ((Collection) (Arrays.asList(as))));
    }

    protected void a(ec ec1, dw.e e1)
        throws RemoteException
    {
        Bundle bundle = new Bundle();
        bundle.putStringArray("request_visible_actions", DL.eS());
        ec1.a(e1, 0x40ba50, DL.eV(), DL.eU(), bO(), DL.getAccountName(), bundle);
    }

    protected String am()
    {
        return "com.google.android.gms.plus.service.START";
    }

    protected String an()
    {
        return "com.google.android.gms.plus.internal.IPlusService";
    }

    protected hr ay(IBinder ibinder)
    {
        return hr.a.ax(ibinder);
    }

    public boolean az(String s)
    {
        return Arrays.asList(bO()).contains(s);
    }

    public void clearDefaultAccount()
    {
        bP();
        try
        {
            DK = null;
            ((hr)bQ()).clearDefaultAccount();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new IllegalStateException(remoteexception);
        }
    }

    public String getAccountName()
    {
        bP();
        String s;
        try
        {
            s = ((hr)bQ()).getAccountName();
        }
        catch (RemoteException remoteexception)
        {
            throw new IllegalStateException(remoteexception);
        }
        return s;
    }

    public Person getCurrentPerson()
    {
        bP();
        return DK;
    }

    public void i(com.google.android.gms.common.api.a.c c1, String s)
    {
        a(c1, 0, s);
    }

    public void j(com.google.android.gms.common.api.a.c c1)
    {
        a(c1, 20, null, null, null, "me");
    }

    public void k(com.google.android.gms.common.api.a.c c1)
    {
        bP();
        c1 = new c(c1);
        try
        {
            ((hr)bQ()).a(c1, 2, 1, -1, null);
            return;
        }
        catch (RemoteException remoteexception)
        {
            c1.a(DataHolder.empty(8), null);
        }
    }

    public void l(com.google.android.gms.common.api.a.c c1)
    {
        bP();
        clearDefaultAccount();
        c1 = new e(c1);
        try
        {
            ((hr)bQ()).b(c1);
            return;
        }
        catch (RemoteException remoteexception)
        {
            c1.b(8, null);
        }
    }

    protected IInterface p(IBinder ibinder)
    {
        return ay(ibinder);
    }

    public void removeMoment(String s)
    {
        bP();
        try
        {
            ((hr)bQ()).removeMoment(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new IllegalStateException(s);
        }
    }

    public void writeMoment(Moment moment)
    {
        bP();
        try
        {
            moment = ey.a((id)moment);
            ((hr)bQ()).a(moment);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Moment moment)
        {
            throw new IllegalStateException(moment);
        }
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.server.response.SafeParcelResponse;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.internal.model.moments.MomentEntity;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

// Referenced classes of package com.google.android.gms.plus.internal:
//            PlusSession, zzd, zza

public class com.google.android.gms.plus.internal.zze extends zzj
{
    static final class zza
        implements com.google.android.gms.plus.Moments.LoadMomentsResult
    {

        private final Status zzQA;
        private final String zzaLq;
        private final String zzaLr;
        private final MomentBuffer zzaLs;

        public MomentBuffer getMomentBuffer()
        {
            return zzaLs;
        }

        public String getNextPageToken()
        {
            return zzaLq;
        }

        public Status getStatus()
        {
            return zzQA;
        }

        public String getUpdated()
        {
            return zzaLr;
        }

        public void release()
        {
            if (zzaLs != null)
            {
                zzaLs.release();
            }
        }

        public zza(Status status, DataHolder dataholder, String s, String s1)
        {
            zzQA = status;
            zzaLq = s;
            zzaLr = s1;
            if (dataholder != null)
            {
                status = new MomentBuffer(dataholder);
            } else
            {
                status = null;
            }
            zzaLs = status;
        }
    }

    static final class zzb
        implements com.google.android.gms.plus.People.LoadPeopleResult
    {

        private final Status zzQA;
        private final String zzaLq;
        private final PersonBuffer zzaLt;

        public String getNextPageToken()
        {
            return zzaLq;
        }

        public PersonBuffer getPersonBuffer()
        {
            return zzaLt;
        }

        public Status getStatus()
        {
            return zzQA;
        }

        public void release()
        {
            if (zzaLt != null)
            {
                zzaLt.release();
            }
        }

        public zzb(Status status, DataHolder dataholder, String s)
        {
            zzQA = status;
            zzaLq = s;
            if (dataholder != null)
            {
                status = new PersonBuffer(dataholder);
            } else
            {
                status = null;
            }
            zzaLt = status;
        }
    }

    static final class zzc extends com.google.android.gms.plus.internal.zza
    {

        private final com.google.android.gms.common.api.zzc.zzb zzaCS;

        public void zzaX(Status status)
        {
            zzaCS.zzn(status);
        }

        public zzc(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzaCS = zzb1;
        }
    }

    static final class zzd extends com.google.android.gms.plus.internal.zza
    {

        private final com.google.android.gms.common.api.zzc.zzb zzaCS;

        public void zza(DataHolder dataholder, String s, String s1)
        {
            Object obj;
            Status status;
            if (dataholder.zznP() != null)
            {
                obj = (PendingIntent)dataholder.zznP().getParcelable("pendingIntent");
            } else
            {
                obj = null;
            }
            status = new Status(dataholder.getStatusCode(), null, ((PendingIntent) (obj)));
            obj = dataholder;
            if (!status.isSuccess())
            {
                obj = dataholder;
                if (dataholder != null)
                {
                    if (!dataholder.isClosed())
                    {
                        dataholder.close();
                    }
                    obj = null;
                }
            }
            zzaCS.zzn(new zza(status, ((DataHolder) (obj)), s, s1));
        }

        public zzd(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzaCS = zzb1;
        }
    }

    static final class zze extends com.google.android.gms.plus.internal.zza
    {

        private final com.google.android.gms.common.api.zzc.zzb zzaCS;

        public void zza(DataHolder dataholder, String s)
        {
            Object obj;
            Status status;
            if (dataholder.zznP() != null)
            {
                obj = (PendingIntent)dataholder.zznP().getParcelable("pendingIntent");
            } else
            {
                obj = null;
            }
            status = new Status(dataholder.getStatusCode(), null, ((PendingIntent) (obj)));
            obj = dataholder;
            if (!status.isSuccess())
            {
                obj = dataholder;
                if (dataholder != null)
                {
                    if (!dataholder.isClosed())
                    {
                        dataholder.close();
                    }
                    obj = null;
                }
            }
            zzaCS.zzn(new zzb(status, ((DataHolder) (obj)), s));
        }

        public zze(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzaCS = zzb1;
        }
    }

    static final class zzf extends com.google.android.gms.plus.internal.zza
    {

        private final com.google.android.gms.common.api.zzc.zzb zzaCS;

        public void zzi(int i, Bundle bundle)
        {
            if (bundle != null)
            {
                bundle = (PendingIntent)bundle.getParcelable("pendingIntent");
            } else
            {
                bundle = null;
            }
            bundle = new Status(i, null, bundle);
            zzaCS.zzn(bundle);
        }

        public zzf(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzaCS = zzb1;
        }
    }


    private Person zzaLo;
    private final PlusSession zzaLp;

    public com.google.android.gms.plus.internal.zze(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzf1, PlusSession plussession, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        super(context, looper, 2, zzf1, connectioncallbacks, onconnectionfailedlistener);
        zzaLp = plussession;
    }

    public static boolean zzd(Set set)
    {
        while (set == null || set.isEmpty() || set.size() == 1 && set.contains(new Scope("plus_one_placeholder_scope"))) 
        {
            return false;
        }
        return true;
    }

    private Bundle zzlj()
    {
        Bundle bundle = zzaLp.zzyS();
        bundle.putStringArray("request_visible_actions", zzaLp.zzyM());
        bundle.putString("auth_package", zzaLp.zzyO());
        return bundle;
    }

    public String getAccountName()
    {
        zzoz();
        String s;
        try
        {
            s = ((com.google.android.gms.plus.internal.zzd)zzoA()).getAccountName();
        }
        catch (RemoteException remoteexception)
        {
            throw new IllegalStateException(remoteexception);
        }
        return s;
    }

    protected IInterface zzV(IBinder ibinder)
    {
        return zzdy(ibinder);
    }

    public zzq zza(com.google.android.gms.common.api.zzc.zzb zzb1, int i, String s)
    {
        zzoz();
        zzb1 = new zze(zzb1);
        try
        {
            s = ((com.google.android.gms.plus.internal.zzd)zzoA()).zza(zzb1, 1, i, -1, s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            zzb1.zza(DataHolder.zzbp(8), null);
            return null;
        }
        return s;
    }

    protected void zza(int i, IBinder ibinder, Bundle bundle, int j)
    {
        if (i == 0 && bundle != null && bundle.containsKey("loaded_person"))
        {
            zzaLo = PersonEntity.zzp(bundle.getByteArray("loaded_person"));
        }
        super.zza(i, ibinder, bundle, j);
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb zzb1, int i, String s, Uri uri, String s1, String s2)
    {
        zzoz();
        if (zzb1 != null)
        {
            zzb1 = new zzd(zzb1);
        } else
        {
            zzb1 = null;
        }
        try
        {
            ((com.google.android.gms.plus.internal.zzd)zzoA()).zza(zzb1, i, s, uri, s1, s2);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            zzb1.zza(DataHolder.zzbp(8), null, null);
        }
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb zzb1, Moment moment)
    {
        zzoz();
        if (zzb1 != null)
        {
            zzb1 = new zzc(zzb1);
        } else
        {
            zzb1 = null;
        }
        try
        {
            moment = SafeParcelResponse.zza((MomentEntity)moment);
            ((com.google.android.gms.plus.internal.zzd)zzoA()).zza(zzb1, moment);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Moment moment) { }
        if (zzb1 == null)
        {
            throw new IllegalStateException(moment);
        } else
        {
            zzb1.zzaX(new Status(8, null, null));
            return;
        }
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb zzb1, Collection collection)
    {
        zzoz();
        zzb1 = new zze(zzb1);
        try
        {
            ((com.google.android.gms.plus.internal.zzd)zzoA()).zza(zzb1, new ArrayList(collection));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Collection collection)
        {
            zzb1.zza(DataHolder.zzbp(8), null);
        }
    }

    public void zzd(com.google.android.gms.common.api.zzc.zzb zzb1, String as[])
    {
        zza(zzb1, Arrays.asList(as));
    }

    protected com.google.android.gms.plus.internal.zzd zzdy(IBinder ibinder)
    {
        return com.google.android.gms.plus.internal.zzd.zza.zzdx(ibinder);
    }

    public void zzej(String s)
    {
        zzoz();
        try
        {
            ((com.google.android.gms.plus.internal.zzd)zzoA()).zzej(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new IllegalStateException(s);
        }
    }

    protected String zzfA()
    {
        return "com.google.android.gms.plus.service.START";
    }

    protected String zzfB()
    {
        return "com.google.android.gms.plus.internal.IPlusService";
    }

    public void zzk(com.google.android.gms.common.api.zzc.zzb zzb1)
    {
        zza(zzb1, 20, null, null, null, "me");
    }

    public void zzl(com.google.android.gms.common.api.zzc.zzb zzb1)
    {
        zzoz();
        zzb1 = new zze(zzb1);
        try
        {
            ((com.google.android.gms.plus.internal.zzd)zzoA()).zza(zzb1, 2, 1, -1, null);
            return;
        }
        catch (RemoteException remoteexception)
        {
            zzb1.zza(DataHolder.zzbp(8), null);
        }
    }

    protected Bundle zzli()
    {
        return zzlj();
    }

    public boolean zzlm()
    {
        return zzd(zzoy().zzb(Plus.API));
    }

    public void zzm(com.google.android.gms.common.api.zzc.zzb zzb1)
    {
        zzoz();
        zzyG();
        zzb1 = new zzf(zzb1);
        try
        {
            ((com.google.android.gms.plus.internal.zzd)zzoA()).zzb(zzb1);
            return;
        }
        catch (RemoteException remoteexception)
        {
            zzb1.zzi(8, null);
        }
    }

    protected Bundle zzoB()
    {
        return zzlj();
    }

    public zzq zzq(com.google.android.gms.common.api.zzc.zzb zzb1, String s)
    {
        return zza(zzb1, 0, s);
    }

    public void zzyG()
    {
        zzoz();
        try
        {
            zzaLo = null;
            ((com.google.android.gms.plus.internal.zzd)zzoA()).zzyG();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new IllegalStateException(remoteexception);
        }
    }

    public Person zzyI()
    {
        zzoz();
        return zzaLo;
    }
}

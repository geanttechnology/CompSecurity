// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.appdatasearch.UsageInfo;
import com.google.android.gms.appdatasearch.zzk;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzjg, zzjf, zzjc, zzje

public final class zzjh
    implements zzk, AppIndexApi
{
    private static final class zza
        implements com.google.android.gms.appindexing.AppIndexApi.ActionResult
    {

        private zzjh zzQa;
        private PendingResult zzQb;
        private Action zzQc;

        public PendingResult end(GoogleApiClient googleapiclient)
        {
            Object obj = googleapiclient.getContext().getPackageName();
            long l = System.currentTimeMillis();
            obj = zzjg.zza(zzQc, l, ((String) (obj)), 2);
            return zzQa.zza(googleapiclient, new UsageInfo[] {
                obj
            });
        }

        public PendingResult getPendingResult()
        {
            return zzQb;
        }

        zza(zzjh zzjh1, PendingResult pendingresult, Action action1)
        {
            zzQa = zzjh1;
            zzQb = pendingresult;
            zzQc = action1;
        }
    }

    private static abstract class zzb extends com.google.android.gms.common.api.zzc.zza
    {

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
            throws RemoteException
        {
            zza((zzjf)zzb1);
        }

        protected abstract void zza(zzjc zzjc)
            throws RemoteException;

        protected final void zza(zzjf zzjf1)
            throws RemoteException
        {
            zza(zzjf1.zzlg());
        }

        public zzb(GoogleApiClient googleapiclient)
        {
            super(com.google.android.gms.appdatasearch.zza.zzOO, googleapiclient);
        }
    }

    private static abstract class zzc extends zzb
    {

        protected Result zzb(Status status)
        {
            return zzd(status);
        }

        protected Status zzd(Status status)
        {
            return status;
        }

        zzc(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }
    }

    private static final class zzd extends zzje
    {

        public void zzc(Status status)
        {
            zzPW.zzn(status);
        }

        public zzd(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            super(zzb1);
        }
    }


    public zzjh()
    {
    }

    public static Intent zza(String s, Uri uri)
    {
        zzb(s, uri);
        s = uri.getPathSegments();
        String s1 = (String)s.get(0);
        android.net.Uri.Builder builder = new android.net.Uri.Builder();
        builder.scheme(s1);
        if (s.size() > 1)
        {
            builder.authority((String)s.get(1));
            for (int i = 2; i < s.size(); i++)
            {
                builder.appendPath((String)s.get(i));
            }

        }
        builder.encodedQuery(uri.getEncodedQuery());
        builder.encodedFragment(uri.getEncodedFragment());
        return new Intent("android.intent.action.VIEW", builder.build());
    }

    private PendingResult zza(GoogleApiClient googleapiclient, Action action1, int i)
    {
        String s = googleapiclient.getContext().getPackageName();
        return zza(googleapiclient, new UsageInfo[] {
            zzjg.zza(action1, System.currentTimeMillis(), s, i)
        });
    }

    private static void zzb(String s, Uri uri)
    {
        if (!"android-app".equals(uri.getScheme()))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("AppIndex: The URI scheme must be 'android-app' and follow the format (android-app://<package_name>/<scheme>/[host_path]). Provided URI: ").append(uri).toString());
        }
        String s1 = uri.getHost();
        if (s != null && !s.equals(s1))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("AppIndex: The URI host must match the package name and follow the format (android-app://<package_name>/<scheme>/[host_path]). Provided URI: ").append(uri).toString());
        }
        s = uri.getPathSegments();
        if (s.isEmpty() || ((String)s.get(0)).isEmpty())
        {
            throw new IllegalArgumentException((new StringBuilder()).append("AppIndex: The app URI scheme must exist and follow the format android-app://<package_name>/<scheme>/[host_path]). Provided URI: ").append(uri).toString());
        } else
        {
            return;
        }
    }

    public static void zzi(List list)
    {
        if (list != null)
        {
            list = list.iterator();
            while (list.hasNext()) 
            {
                zzb(null, ((com.google.android.gms.appindexing.AppIndexApi.AppIndexingLink)list.next()).appIndexingUrl);
            }
        }
    }

    public com.google.android.gms.appindexing.AppIndexApi.ActionResult action(GoogleApiClient googleapiclient, Action action1)
    {
        return new zza(this, zza(googleapiclient, action1, 1), action1);
    }

    public PendingResult end(GoogleApiClient googleapiclient, Action action1)
    {
        return zza(googleapiclient, action1, 2);
    }

    public PendingResult start(GoogleApiClient googleapiclient, Action action1)
    {
        return zza(googleapiclient, action1, 1);
    }

    public PendingResult view(GoogleApiClient googleapiclient, Activity activity, Intent intent, String s, Uri uri, List list)
    {
        activity = googleapiclient.getContext().getPackageName();
        zzi(list);
        return zza(googleapiclient, new UsageInfo[] {
            new UsageInfo(activity, intent, s, uri, null, list, 1)
        });
    }

    public PendingResult view(GoogleApiClient googleapiclient, Activity activity, Uri uri, String s, Uri uri1, List list)
    {
        String s1 = googleapiclient.getContext().getPackageName();
        zzb(s1, uri);
        return view(googleapiclient, activity, zza(s1, uri), s, uri1, list);
    }

    public PendingResult viewEnd(GoogleApiClient googleapiclient, Activity activity, Intent intent)
    {
        activity = googleapiclient.getContext().getPackageName();
        return zza(googleapiclient, new UsageInfo[] {
            (new com.google.android.gms.appdatasearch.UsageInfo.zza()).zza(UsageInfo.zza(activity, intent)).zzw(System.currentTimeMillis()).zzam(0).zzan(2).zzlf()
        });
    }

    public PendingResult viewEnd(GoogleApiClient googleapiclient, Activity activity, Uri uri)
    {
        return viewEnd(googleapiclient, activity, zza(googleapiclient.getContext().getPackageName(), uri));
    }

    public PendingResult zza(GoogleApiClient googleapiclient, com.google.android.gms.appdatasearch.GetRecentContextCall.Request request)
    {
        return googleapiclient.zza(new com.google.android.gms.appdatasearch.GetRecentContextCall.zza(request, googleapiclient));
    }

    public transient PendingResult zza(GoogleApiClient googleapiclient, UsageInfo ausageinfo[])
    {
        return googleapiclient.zza(new zzc(googleapiclient, googleapiclient.getContext().getPackageName(), ausageinfo) {

            final String zzPX;
            final UsageInfo zzPY[];
            final zzjh zzPZ;

            protected void zza(zzjc zzjc1)
                throws RemoteException
            {
                zzjc1.zza(new zzd(this), zzPX, zzPY);
            }

            
            {
                zzPZ = zzjh.this;
                zzPX = s;
                zzPY = ausageinfo;
                super(googleapiclient);
            }
        });
    }
}

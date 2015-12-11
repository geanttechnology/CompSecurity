// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.appdatasearch.UsageInfo;
import com.google.android.gms.appdatasearch.zzk;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzjt

public final class zzju
    implements zzk, AppIndexApi
{

    public zzju()
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
            zzjt.zza(action1, System.currentTimeMillis(), s, i)
        });
    }

    private static void zzb(String s, Uri uri)
    {
        if (!"android-app".equals(uri.getScheme()))
        {
            throw new IllegalArgumentException((new StringBuilder("AppIndex: The URI scheme must be 'android-app' and follow the format (android-app://<package_name>/<scheme>/[host_path]). Provided URI: ")).append(uri).toString());
        }
        String s1 = uri.getHost();
        if (s != null && !s.equals(s1))
        {
            throw new IllegalArgumentException((new StringBuilder("AppIndex: The URI host must match the package name and follow the format (android-app://<package_name>/<scheme>/[host_path]). Provided URI: ")).append(uri).toString());
        }
        s = uri.getPathSegments();
        if (s.isEmpty() || ((String)s.get(0)).isEmpty())
        {
            throw new IllegalArgumentException((new StringBuilder("AppIndex: The app URI scheme must exist and follow the format android-app://<package_name>/<scheme>/[host_path]). Provided URI: ")).append(uri).toString());
        } else
        {
            return;
        }
    }

    public static void zzp(List list)
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

    public final com.google.android.gms.appindexing.AppIndexApi.ActionResult action(GoogleApiClient googleapiclient, Action action1)
    {
        return new zza(zza(googleapiclient, action1, 1), action1);
    }

    public final PendingResult end(GoogleApiClient googleapiclient, Action action1)
    {
        return zza(googleapiclient, action1, 2);
    }

    public final PendingResult start(GoogleApiClient googleapiclient, Action action1)
    {
        return zza(googleapiclient, action1, 1);
    }

    public final PendingResult view(GoogleApiClient googleapiclient, Activity activity, Intent intent, String s, Uri uri, List list)
    {
        activity = googleapiclient.getContext().getPackageName();
        zzp(list);
        return zza(googleapiclient, new UsageInfo[] {
            new UsageInfo(activity, intent, s, uri, null, list, 1)
        });
    }

    public final PendingResult view(GoogleApiClient googleapiclient, Activity activity, Uri uri, String s, Uri uri1, List list)
    {
        String s1 = googleapiclient.getContext().getPackageName();
        zzb(s1, uri);
        return view(googleapiclient, activity, zza(s1, uri), s, uri1, list);
    }

    public final PendingResult viewEnd(GoogleApiClient googleapiclient, Activity activity, Intent intent)
    {
        activity = googleapiclient.getContext().getPackageName();
        return zza(googleapiclient, new UsageInfo[] {
            (new com.google.android.gms.appdatasearch.UsageInfo.zza()).zza(UsageInfo.zza(activity, intent)).zzw(System.currentTimeMillis()).zzan(0).zzao(2).zzlv()
        });
    }

    public final PendingResult viewEnd(GoogleApiClient googleapiclient, Activity activity, Uri uri)
    {
        return viewEnd(googleapiclient, activity, zza(googleapiclient.getContext().getPackageName(), uri));
    }

    public final PendingResult zza(GoogleApiClient googleapiclient, com.google.android.gms.appdatasearch.GetRecentContextCall.Request request)
    {
        return googleapiclient.zza(new com.google.android.gms.appdatasearch.GetRecentContextCall.zza(request, googleapiclient));
    }

    public final transient PendingResult zza(GoogleApiClient googleapiclient, UsageInfo ausageinfo[])
    {
        return googleapiclient.zza(new _cls1(googleapiclient, googleapiclient.getContext().getPackageName(), ausageinfo));
    }

    private class zza
        implements com.google.android.gms.appindexing.AppIndexApi.ActionResult
    {

        private zzju zzRf;
        private PendingResult zzRg;
        private Action zzRh;

        public final PendingResult end(GoogleApiClient googleapiclient)
        {
            Object obj = googleapiclient.getContext().getPackageName();
            long l = System.currentTimeMillis();
            obj = zzjt.zza(zzRh, l, ((String) (obj)), 2);
            return zzRf.zza(googleapiclient, new UsageInfo[] {
                obj
            });
        }

        public final PendingResult getPendingResult()
        {
            return zzRg;
        }

        zza(PendingResult pendingresult, Action action1)
        {
            zzRf = zzju.this;
            zzRg = pendingresult;
            zzRh = action1;
        }
    }


    private class _cls1 extends zzc
    {
        private class zzc extends zzb
        {
            private class zzb extends zzlb.zza
            {

                protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                {
                    zza((zzjs)zzb1);
                }

                protected abstract void zza(zzjp zzjp1);

                protected final void zza(zzjs zzjs1)
                {
                    zza(zzjs1.zzlw());
                }

                public zzb(GoogleApiClient googleapiclient)
                {
                    super(com.google.android.gms.appdatasearch.zza.zzPT, googleapiclient);
                }
            }


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


        final String zzRc;
        final UsageInfo zzRd[];
        final zzju zzRe;

        protected void zza(zzjp zzjp1)
        {
            zzjp1.zza(new zzd(this), zzRc, zzRd);
        }

        _cls1(GoogleApiClient googleapiclient, String s, UsageInfo ausageinfo[])
        {
            zzRe = zzju.this;
            zzRc = s;
            zzRd = ausageinfo;
            super(googleapiclient);
        }

        private class zzd extends zzjr
        {

            public final void zzc(Status status)
            {
                zzRb.zzp(status);
            }

            public zzd(zzlb.zzb zzb1)
            {
                super(zzb1);
            }
        }

    }

}

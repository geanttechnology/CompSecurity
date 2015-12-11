// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;

public interface SessionsApi
{
    public static class ViewIntentBuilder
    {

        private final Context mContext;
        private String zzapO;
        private Session zzapP;
        private boolean zzapQ;

        private Intent zzj(Intent intent)
        {
            if (zzapO != null)
            {
                Intent intent1 = (new Intent(intent)).setPackage(zzapO);
                ResolveInfo resolveinfo = mContext.getPackageManager().resolveActivity(intent1, 0);
                if (resolveinfo != null)
                {
                    intent = resolveinfo.activityInfo.name;
                    intent1.setComponent(new ComponentName(zzapO, intent));
                    return intent1;
                }
            }
            return intent;
        }

        public Intent build()
        {
            Intent intent;
            boolean flag;
            if (zzapP != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zza(flag, "Session must be set");
            intent = new Intent("vnd.google.fitness.VIEW");
            intent.setType(Session.getMimeType(zzapP.getActivity()));
            zzc.zza(zzapP, intent, "vnd.google.fitness.session");
            if (!zzapQ)
            {
                zzapO = zzapP.getAppPackageName();
            }
            return zzj(intent);
        }

        public ViewIntentBuilder setPreferredApplication(String s)
        {
            zzapO = s;
            zzapQ = true;
            return this;
        }

        public ViewIntentBuilder setSession(Session session)
        {
            zzapP = session;
            return this;
        }

        public ViewIntentBuilder(Context context)
        {
            zzapQ = false;
            mContext = context;
        }
    }


    public abstract PendingResult insertSession(GoogleApiClient googleapiclient, SessionInsertRequest sessioninsertrequest);

    public abstract PendingResult readSession(GoogleApiClient googleapiclient, SessionReadRequest sessionreadrequest);

    public abstract PendingResult registerForSessions(GoogleApiClient googleapiclient, PendingIntent pendingintent);

    public abstract PendingResult startSession(GoogleApiClient googleapiclient, Session session);

    public abstract PendingResult stopSession(GoogleApiClient googleapiclient, String s);

    public abstract PendingResult unregisterForSessions(GoogleApiClient googleapiclient, PendingIntent pendingintent);
}

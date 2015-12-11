// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.panorama;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.dt;
import com.google.android.gms.internal.hm;

public final class Panorama
{
    public static interface PanoramaResult
        extends Result
    {

        public abstract Intent getViewerIntent();
    }

    public static interface a
        extends PanoramaResult
    {
    }

    private static abstract class b extends com.google.android.gms.common.api.a.a
    {

        public PanoramaResult J(Status status)
        {
            return new PanoramaResult(this, status) {

                final b Dh;
                final Status jP;

                public Status getStatus()
                {
                    return jP;
                }

                public Intent getViewerIntent()
                {
                    return null;
                }

            
            {
                Dh = b1;
                jP = status;
                super();
            }
            };
        }

        public Result e(Status status)
        {
            return J(status);
        }

        public b()
        {
            super(Panorama.jO);
        }
    }


    public static final Api API;
    static final com.google.android.gms.common.api.Api.b jO;

    private Panorama()
    {
    }

    public static PendingResult loadPanoramaInfo(GoogleApiClient googleapiclient, Uri uri)
    {
        return googleapiclient.a(new b(uri) {

            final Uri Dg;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((hm)a1);
            }

            protected void a(hm hm1)
            {
                hm1.a(this, Dg, false);
            }

            
            {
                Dg = uri;
                super();
            }
        });
    }

    public static PendingResult loadPanoramaInfoAndGrantAccess(GoogleApiClient googleapiclient, Uri uri)
    {
        return googleapiclient.a(new b(uri) {

            final Uri Dg;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((hm)a1);
            }

            protected void a(hm hm1)
            {
                hm1.a(this, Dg, true);
            }

            
            {
                Dg = uri;
                super();
            }
        });
    }

    static 
    {
        jO = new com.google.android.gms.common.api.Api.b() {

            public com.google.android.gms.common.api.Api.a b(Context context, dt dt, com.google.android.gms.common.api.GoogleApiClient.ApiOptions apioptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                return f(context, dt, apioptions, connectioncallbacks, onconnectionfailedlistener);
            }

            public hm f(Context context, dt dt, com.google.android.gms.common.api.GoogleApiClient.ApiOptions apioptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                return new hm(context, connectioncallbacks, onconnectionfailedlistener);
            }

            public int getPriority()
            {
                return 0x7fffffff;
            }

        };
        API = new Api(jO, new Scope[0]);
    }
}

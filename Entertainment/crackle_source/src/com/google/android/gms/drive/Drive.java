// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.drive.internal.h;
import com.google.android.gms.drive.internal.j;
import com.google.android.gms.internal.dt;
import java.util.List;

// Referenced classes of package com.google.android.gms.drive:
//            DriveApi

public final class Drive
{

    public static final Api API;
    public static final DriveApi DriveApi = new h();
    public static final Scope SCOPE_FILE = new Scope("https://www.googleapis.com/auth/drive.file");
    public static final com.google.android.gms.common.api.Api.b jO;

    private Drive()
    {
    }

    static 
    {
        jO = new com.google.android.gms.common.api.Api.b() {

            public com.google.android.gms.common.api.Api.a b(Context context, dt dt1, com.google.android.gms.common.api.GoogleApiClient.ApiOptions apioptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                return d(context, dt1, apioptions, connectioncallbacks, onconnectionfailedlistener);
            }

            public j d(Context context, dt dt1, com.google.android.gms.common.api.GoogleApiClient.ApiOptions apioptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                apioptions = dt1.bH();
                return new j(context, dt1, connectioncallbacks, onconnectionfailedlistener, (String[])apioptions.toArray(new String[apioptions.size()]));
            }

            public int getPriority()
            {
                return 0x7fffffff;
            }

        };
        API = new Api(jO, new Scope[0]);
    }
}

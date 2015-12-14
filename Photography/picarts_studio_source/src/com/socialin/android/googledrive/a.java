// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.googledrive;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Drive;
import com.socialin.android.d;
import java.util.concurrent.CountDownLatch;

public abstract class a extends AsyncTask
{

    private static final String a = com/socialin/android/googledrive/a.getSimpleName();
    private GoogleApiClient b;

    public a(String s, Context context)
    {
        b = (new com.google.android.gms.common.api.GoogleApiClient.Builder(context)).addApi(Drive.API).addScope(Drive.SCOPE_FILE).setAccountName(s).build();
    }

    protected transient abstract Object a(Object aobj[]);

    protected final transient Object doInBackground(Object aobj[])
    {
        d.b(a, new Object[] {
            "in background"
        });
        CountDownLatch countdownlatch = new CountDownLatch(1);
        b.registerConnectionCallbacks(new com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks(countdownlatch) {

            private CountDownLatch a;

            public final void onConnected(Bundle bundle)
            {
                a.countDown();
            }

            public final void onConnectionSuspended(int i)
            {
            }

            
            {
                a = countdownlatch;
                super();
            }
        });
        b.registerConnectionFailedListener(new com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener(countdownlatch) {

            private CountDownLatch a;

            public final void onConnectionFailed(ConnectionResult connectionresult)
            {
                a.countDown();
            }

            
            {
                a = countdownlatch;
                super();
            }
        });
        b.connect();
        try
        {
            countdownlatch.await();
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            d.b(a, "interruped", ((Throwable) (aobj)));
            return null;
        }
        if (!b.isConnected())
        {
            return null;
        }
        aobj = ((Object []) (a(aobj)));
        b.disconnect();
        return ((Object) (aobj));
        aobj;
        b.disconnect();
        throw aobj;
    }

}

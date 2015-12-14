// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.internal.gh;
import java.io.IOException;

// Referenced classes of package com.google.android.gms.cast:
//            Cast, ApplicationMetadata, LaunchOptions

public final class sult
    implements sult
{

    public ApplicationMetadata getApplicationMetadata(GoogleApiClient googleapiclient)
    {
        return ((gh)googleapiclient.a(Cast.yH)).getApplicationMetadata();
    }

    public String getApplicationStatus(GoogleApiClient googleapiclient)
    {
        return ((gh)googleapiclient.a(Cast.yH)).getApplicationStatus();
    }

    public double getVolume(GoogleApiClient googleapiclient)
    {
        return ((gh)googleapiclient.a(Cast.yH)).eh();
    }

    public boolean isMute(GoogleApiClient googleapiclient)
    {
        return ((gh)googleapiclient.a(Cast.yH)).isMute();
    }

    public PendingResult joinApplication(GoogleApiClient googleapiclient)
    {
    /* block-local class not found */
    class _cls6 {}

        return googleapiclient.b(new _cls6());
    }

    public PendingResult joinApplication(GoogleApiClient googleapiclient, String s)
    {
    /* block-local class not found */
    class _cls5 {}

        return googleapiclient.b(new _cls5(s));
    }

    public PendingResult joinApplication(GoogleApiClient googleapiclient, String s, String s1)
    {
    /* block-local class not found */
    class _cls4 {}

        return googleapiclient.b(new _cls4(s, s1));
    }

    public PendingResult launchApplication(GoogleApiClient googleapiclient, String s)
    {
    /* block-local class not found */
    class _cls2 {}

        return googleapiclient.b(new _cls2(s));
    }

    public PendingResult launchApplication(GoogleApiClient googleapiclient, String s, LaunchOptions launchoptions)
    {
    /* block-local class not found */
    class _cls3 {}

        return googleapiclient.b(new _cls3(s, launchoptions));
    }

    public PendingResult launchApplication(GoogleApiClient googleapiclient, String s, boolean flag)
    {
        return launchApplication(googleapiclient, s, (new uilder()).setRelaunchIfRunning(flag).build());
    }

    public PendingResult leaveApplication(GoogleApiClient googleapiclient)
    {
    /* block-local class not found */
    class _cls7 {}

        return googleapiclient.b(new _cls7());
    }

    public void removeMessageReceivedCallbacks(GoogleApiClient googleapiclient, String s)
    {
        try
        {
            ((gh)googleapiclient.a(Cast.yH)).aj(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (GoogleApiClient googleapiclient)
        {
            throw new IOException("service error");
        }
    }

    public void requestStatus(GoogleApiClient googleapiclient)
    {
        try
        {
            ((gh)googleapiclient.a(Cast.yH)).eg();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (GoogleApiClient googleapiclient)
        {
            throw new IOException("service error");
        }
    }

    public PendingResult sendMessage(GoogleApiClient googleapiclient, String s, String s1)
    {
    /* block-local class not found */
    class _cls1 {}

        return googleapiclient.b(new _cls1(s, s1));
    }

    public void setMessageReceivedCallbacks(GoogleApiClient googleapiclient, String s, eivedCallback eivedcallback)
    {
        try
        {
            ((gh)googleapiclient.a(Cast.yH)).a(s, eivedcallback);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (GoogleApiClient googleapiclient)
        {
            throw new IOException("service error");
        }
    }

    public void setMute(GoogleApiClient googleapiclient, boolean flag)
    {
        try
        {
            ((gh)googleapiclient.a(Cast.yH)).y(flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (GoogleApiClient googleapiclient)
        {
            throw new IOException("service error");
        }
    }

    public void setVolume(GoogleApiClient googleapiclient, double d)
    {
        try
        {
            ((gh)googleapiclient.a(Cast.yH)).a(d);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (GoogleApiClient googleapiclient)
        {
            throw new IOException("service error");
        }
    }

    public PendingResult stopApplication(GoogleApiClient googleapiclient)
    {
    /* block-local class not found */
    class _cls8 {}

        return googleapiclient.b(new _cls8());
    }

    public PendingResult stopApplication(GoogleApiClient googleapiclient, String s)
    {
    /* block-local class not found */
    class _cls9 {}

        return googleapiclient.b(new _cls9(s));
    }

    public sult()
    {
    }
}

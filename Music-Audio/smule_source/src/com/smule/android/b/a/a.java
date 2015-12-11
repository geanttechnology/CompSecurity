// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.b.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.auth.GooglePlayServicesAvailabilityException;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Account;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.model.people.Person;
import com.smule.android.c.aa;
import com.smule.android.network.core.o;
import com.smule.android.network.managers.UserManager;
import com.smule.android.network.managers.aw;

public class a
    implements com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
{

    private static final String a = com/smule/android/b/a/a.getName();
    private GoogleApiClient b;
    private ConnectionResult c;
    private Activity d;
    private Runnable e;
    private String f;
    private boolean g;
    private boolean h;
    private boolean i;

    public a()
    {
        f = null;
        g = false;
        h = false;
        i = true;
    }

    static GoogleApiClient a(a a1)
    {
        return a1.b;
    }

    static boolean b(a a1)
    {
        return a1.g();
    }

    static void c(a a1)
    {
        a1.i();
    }

    static String f()
    {
        return a;
    }

    private boolean g()
    {
        aa.c(a, "getAuthTokenBlocking called");
        if (!b.isConnected())
        {
            aa.c(a, "Plus Client is not connected.");
            return false;
        }
        String s = Plus.AccountApi.getAccountName(b);
        try
        {
            f = GoogleAuthUtil.getToken(d, s, "oauth2:https://www.googleapis.com/auth/plus.login profile");
            aa.c(a, (new StringBuilder()).append("Token = ").append(f).toString());
        }
        catch (GooglePlayServicesAvailabilityException googleplayservicesavailabilityexception)
        {
            aa.c(a, "GooglePlayServicesAvailabilityException caught", googleplayservicesavailabilityexception);
            GooglePlayServicesUtil.getErrorDialog(googleplayservicesavailabilityexception.getConnectionStatusCode(), d, 11113).show();
            return false;
        }
        catch (UserRecoverableAuthException userrecoverableauthexception)
        {
            aa.c(a, "UserRecoverableAuthException caught", userrecoverableauthexception);
            i = false;
            d.startActivityForResult(userrecoverableauthexception.getIntent(), 11114);
            return false;
        }
        catch (Exception exception)
        {
            aa.b(a, "getUserLoginInfo - error getting token", exception);
            return false;
        }
        return true;
    }

    private void h()
    {
        aa.c(a, "getAuthTokenAsync called");
        (new AsyncTask() {

            final a a;

            protected Boolean a(Object aobj[])
            {
                return Boolean.valueOf(a.b(a));
            }

            protected void a(Boolean boolean1)
            {
                if (boolean1.booleanValue())
                {
                    a.c(a);
                }
            }

            protected Object doInBackground(Object aobj[])
            {
                return a(aobj);
            }

            protected void onPostExecute(Object obj)
            {
                a((Boolean)obj);
            }

            
            {
                a = a.this;
                super();
            }
        }).execute(new Object[] {
            (Void)null
        });
    }

    private void i()
    {
        if (e != null && b.isConnected())
        {
            e.run();
        }
    }

    public aw a(boolean flag)
    {
        aw aw1;
        Object obj1;
        aw1 = null;
        aa.a(a, (new StringBuilder()).append("getUserLoginInfo - begin. Token: ").append(f).toString());
        obj1 = Plus.PeopleApi.getCurrentPerson(b);
        if (obj1 != null) goto _L2; else goto _L1
_L1:
        aa.b(a, "getUserLoginInfo - getCurrentPerson() returned null");
_L4:
        return aw1;
_L2:
        String s = ((Person) (obj1)).getId();
        String s1 = Plus.AccountApi.getAccountName(b);
        Object obj;
        String s2;
        String s3;
        if (((Person) (obj1)).getGender() == 0)
        {
            obj = "male";
        } else
        {
            obj = "female";
        }
        s2 = ((Person) (obj1)).getBirthday();
        s3 = ((Person) (obj1)).getName().getGivenName();
        obj1 = ((Person) (obj1)).getName().getFamilyName();
        if (f == null && !g()) goto _L4; else goto _L3
_L3:
        obj = UserManager.n().a(s, f, s1, ((String) (obj)), s2, s3, ((String) (obj1)), UserManager.o(), flag);
        if (obj == null)
        {
            break; /* Loop/switch isn't completed */
        }
        aw1 = ((aw) (obj));
        if (((aw) (obj)).a.a()) goto _L4; else goto _L5
_L5:
        aa.b(a, "getUserLoginInfo - failed to login to SNP after Google Plus authentication");
        return ((aw) (obj));
    }

    public void a()
    {
        aa.a(a, "onStop");
        if (i)
        {
            b.disconnect();
        }
    }

    public void a(Activity activity)
    {
        d = activity;
        b = (new com.google.android.gms.common.api.GoogleApiClient.Builder(activity)).addApi(Plus.API).addConnectionCallbacks(this).addOnConnectionFailedListener(this).addScope(Plus.SCOPE_PLUS_LOGIN).build();
    }

    public void a(Runnable runnable)
    {
        aa.a(a, "onStart");
        e = runnable;
        if (!h)
        {
            b.connect();
        }
    }

    public boolean a(int j, int k, Intent intent)
    {
        aa.c(a, (new StringBuilder()).append("onActivityResult called : ").append(j).append(" / ").append(k).toString());
        i = true;
        if (j != 11111 && j != 11112) goto _L2; else goto _L1
_L1:
        aa.c(a, (new StringBuilder()).append("onActivityResult called 2 : ").append(b.isConnected()).append(" / ").append(b.isConnecting()).toString());
        if (k == -1 && !b.isConnected() && !b.isConnecting())
        {
            g = true;
            b.connect();
        }
_L4:
        return true;
_L2:
        if (j != 11113)
        {
            break; /* Loop/switch isn't completed */
        }
        aa.c(a, (new StringBuilder()).append("onActivityResult called 3 : ").append(b.isConnected()).toString());
        if (b.isConnected() && e != null)
        {
            i();
            return true;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (j == 11114)
        {
            aa.c(a, (new StringBuilder()).append("onActivityResult called 4 : ").append(b.isConnected()).toString());
            if (k == -1)
            {
                h();
                return true;
            }
        } else
        {
            return false;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public boolean b()
    {
        return b.isConnected();
    }

    public String c()
    {
        return Plus.AccountApi.getAccountName(b);
    }

    public boolean d()
    {
        h = true;
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(d) == 0) goto _L2; else goto _L1
_L1:
        aa.b(a, "login - GooglePlayServicesUtil - services are NOT available");
        d.showDialog(1);
_L4:
        return false;
_L2:
        if (b.isConnected())
        {
            break MISSING_BLOCK_LABEL_150;
        }
        aa.b(a, "login - Google Plus client is not connected");
        g = true;
        if (c == null)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        aa.b(a, "login - mConnectionResult is non-null");
        c.startResolutionForResult(d, 11111);
        android.content.IntentSender.SendIntentException sendintentexception;
        return false;
        aa.b(a, "login - mConnectionResult is null");
        if (b.isConnecting()) goto _L4; else goto _L3
_L3:
        aa.b(a, "login - Google Plus client is not connecting");
        b.connect();
        return false;
        if (f == null)
        {
            break MISSING_BLOCK_LABEL_173;
        }
        aa.b(a, "login - calling run");
        i();
        return false;
        try
        {
            h();
        }
        // Misplaced declaration of an exception variable
        catch (android.content.IntentSender.SendIntentException sendintentexception)
        {
            b.connect();
            return false;
        }
        return false;
    }

    public boolean e()
    {
        aa.a(a, "disconnect - begin");
        aa.a(a, "disconnect - default account cleared");
        Plus.AccountApi.clearDefaultAccount(b);
        Plus.AccountApi.revokeAccessAndDisconnect(b).setResultCallback(new ResultCallback() {

            final a a;

            public void a(Status status)
            {
                aa.b(a.f(), "User access revoked!");
                if (!status.isSuccess())
                {
                    a.a(a).disconnect();
                }
                a.a(a).connect();
            }

            public void onResult(Result result)
            {
                a((Status)result);
            }

            
            {
                a = a.this;
                super();
            }
        });
        aa.a(a, "disconnect - access revoked");
        UserManager.n().r();
        b.disconnect();
        b.connect();
        return true;
    }

    public void onConnected(Bundle bundle)
    {
        aa.a(a, (new StringBuilder()).append("onConnected - called with bundle: ").append(bundle).append(" / ").append(f).toString());
        g = false;
        if (e != null && f != null)
        {
            i();
            return;
        } else
        {
            h();
            return;
        }
    }

    public void onConnectionFailed(ConnectionResult connectionresult)
    {
        aa.a(a, (new StringBuilder()).append("onConnectionFailed - called - ").append(connectionresult).toString());
        if (connectionresult != null && connectionresult.hasResolution())
        {
            c = connectionresult;
            if (g)
            {
                d();
            }
        }
    }

    public void onConnectionSuspended(int j)
    {
        aa.a(a, "onConnectionSuspended - called");
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.googleplus;

import android.app.Dialog;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import com.firegnom.rat.util.DialogUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Account;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import com.socialin.android.d;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.googleplus:
//            b

public class GooglePlusSignInActivity extends AppCompatActivity
    implements com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener, ResultCallback
{

    public static final String a = com/socialin/android/googleplus/GooglePlusSignInActivity.getSimpleName();
    public static final String b[] = {
        "profile", "https://www.googleapis.com/auth/plus.login", "https://www.googleapis.com/auth/plus.profile.emails.read"
    };
    public static final String c[] = {
        "http://schemas.google.com/AddActivity", "http://schemas.google.com/CommentActivity", "http://schemas.google.com/CreateActivity"
    };
    private String d;
    private GoogleApiClient e;
    private ProgressDialog f;
    private int g;

    public GooglePlusSignInActivity()
    {
        d = "getUser";
        f = null;
    }

    static int a(GooglePlusSignInActivity googleplussigninactivity)
    {
        googleplussigninactivity.g = 0;
        return 0;
    }

    private void a()
    {
        g = 1;
        e.connect();
    }

    private static void a(com.google.android.gms.plus.People.LoadPeopleResult loadpeopleresult)
    {
        int i;
        i = 0;
        if (loadpeopleresult.getStatus().getStatusCode() != 0)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        loadpeopleresult = loadpeopleresult.getPersonBuffer();
        int j = loadpeopleresult.getCount();
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        com.socialin.android.d.b("onUserResult", new Object[] {
            (new StringBuilder("Display name: ")).append(loadpeopleresult.get(i).getDisplayName()).toString()
        });
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        loadpeopleresult.close();
        return;
        Exception exception;
        exception;
        loadpeopleresult.close();
        throw exception;
        com.socialin.android.d.c(new Object[] {
            a, "onUserResult", (new StringBuilder("Error requesting visible circles: ")).append(loadpeopleresult.getStatus()).toString()
        });
        return;
    }

    private void a(Person person)
    {
        if (person == null)
        {
            try
            {
                person = Plus.PeopleApi.getCurrentPerson(e);
            }
            // Misplaced declaration of an exception variable
            catch (Person person)
            {
                com.socialin.android.d.b(a, "getGooglePlusUser", person);
                person = null;
            }
        }
        if (person == null)
        {
            com.socialin.android.d.b(a, new Object[] {
                "getGooglePlusUser", "currentPerson is NULL !"
            });
            e.clearDefaultAccountAndReconnect();
            e.disconnect();
            getSharedPreferences((new StringBuilder("sinPref_")).append(getString(m.e(this, "app_name_short"))).toString(), 0).edit().putString("googleplus_account_name", null).commit();
            setResult(0);
            finish();
            return;
        } else
        {
            (new b(this, person)).a(new Void[0]);
            return;
        }
    }

    static void a(GooglePlusSignInActivity googleplussigninactivity, Person person, String s)
    {
        DialogUtils.dismissDialog(googleplussigninactivity, googleplussigninactivity.f);
        Intent intent = new Intent();
        intent.putExtra("googleplus_id", person.getId());
        intent.putExtra("googleplus_name", person.getDisplayName());
        intent.putExtra("googleplus_profile_url", person.getUrl());
        String s1 = person.getImage().getUrl();
        intent.putExtra("googleplus_profile_image_url", (new StringBuilder()).append(s1.substring(0, s1.length() - 2)).append(400).toString());
        intent.putExtra("googleplus_token", s);
        if (person.hasNickname())
        {
            intent.putExtra("googleplus_nikName", person.getNickname());
        }
        if (googleplussigninactivity.e.isConnected())
        {
            person = Plus.AccountApi.getAccountName(googleplussigninactivity.e);
            googleplussigninactivity.getSharedPreferences((new StringBuilder("sinPref_")).append(googleplussigninactivity.getString(m.e(googleplussigninactivity, "app_name_short"))).toString(), 0).edit().putString("googleplus_account_name", person).commit();
            intent.putExtra("googleplus_email", person);
            googleplussigninactivity.setResult(-1, intent);
            googleplussigninactivity.finish();
            return;
        } else
        {
            googleplussigninactivity.a();
            return;
        }
    }

    static GoogleApiClient b(GooglePlusSignInActivity googleplussigninactivity)
    {
        return googleplussigninactivity.e;
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        i;
        JVM INSTR tableswitch 935 935: default 20
    //                   935 51;
           goto _L1 _L2
_L1:
        if (j == 0)
        {
            com.socialin.android.d.b(a, new Object[] {
                "user has canceled google SIGN IN dialog."
            });
            setResult(1);
            finish();
        }
        return;
_L2:
        if (j == -1)
        {
            g = 1;
        } else
        {
            g = 0;
        }
        if (!e.isConnecting())
        {
            e.connect();
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onConnected(Bundle bundle)
    {
        if ("connect".equals(d))
        {
            setResult(-1);
            finish();
        } else
        {
            Plus.PeopleApi.loadVisible(e, null).setResultCallback(this);
            if (Plus.PeopleApi.getCurrentPerson(e) != null)
            {
                a(((Person) (null)));
                return;
            }
        }
    }

    public void onConnectionFailed(ConnectionResult connectionresult)
    {
        com.socialin.android.d.a(a, (new StringBuilder("onConnectionFailed: ConnectionResult.getErrorCode() = ")).append(connectionresult.getErrorCode()).toString());
        if (connectionresult.getErrorCode() == 16)
        {
            com.socialin.android.d.b(a, "API Unavailable.");
        } else
        if (g != 2)
        {
            int i = connectionresult.getErrorCode();
            com.socialin.android.d.a(a, (new StringBuilder("ErrorCode = ")).append(i).toString());
            if (g == 1)
            {
                connectionresult = connectionresult.getResolution();
                if (connectionresult != null)
                {
                    com.socialin.android.d.a(a, "The user has already clicked 'sign-in' so we attempt to resolve all errors until the user is signed in, or they cancel.");
                    try
                    {
                        g = 2;
                        startIntentSenderForResult(connectionresult.getIntentSender(), 935, null, 0, 0, 0);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (ConnectionResult connectionresult)
                    {
                        com.socialin.android.d.a(a, (new StringBuilder("Sign in intent could not be sent: ")).append(connectionresult.getLocalizedMessage()).toString());
                    }
                    a();
                    return;
                }
                if (GooglePlayServicesUtil.isUserRecoverableError(i))
                {
                    connectionresult = GooglePlayServicesUtil.getErrorDialog(i, this, 935, new android.content.DialogInterface.OnCancelListener() {

                        private GooglePlusSignInActivity a;

                        public final void onCancel(DialogInterface dialoginterface)
                        {
                            com.socialin.android.d.c(new Object[] {
                                GooglePlusSignInActivity.a, "Google Play services resolution cancelled"
                            });
                            GooglePlusSignInActivity.a(a);
                        }

            
            {
                a = GooglePlusSignInActivity.this;
                super();
            }
                    });
                } else
                {
                    connectionresult = (new android.app.AlertDialog.Builder(this)).setMessage("Google Play services is not available.").setPositiveButton(0x7f0802a4, new android.content.DialogInterface.OnClickListener(i) {

                        private int a;
                        private GooglePlusSignInActivity b;

                        public final void onClick(DialogInterface dialoginterface, int j)
                        {
                            com.socialin.android.d.c(new Object[] {
                                GooglePlusSignInActivity.a, (new StringBuilder("Google Play services error could not be resolved: ")).append(a).toString()
                            });
                            GooglePlusSignInActivity.a(b);
                        }

            
            {
                b = GooglePlusSignInActivity.this;
                a = i;
                super();
            }
                    }).create();
                }
                connectionresult.show();
                return;
            }
        }
    }

    public void onConnectionSuspended(int i)
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent.hasExtra("method"))
        {
            d = intent.getStringExtra("method");
        }
        if (bundle != null)
        {
            g = bundle.getInt("sign_in_progress", 0);
        }
        f = new ProgressDialog(this);
        f.setMessage(getString(0x7f08043d));
        f.setCancelable(true);
        f.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            private GooglePlusSignInActivity a;

            public final void onCancel(DialogInterface dialoginterface)
            {
                a.finish();
            }

            
            {
                a = GooglePlusSignInActivity.this;
                super();
            }
        });
        e = (new com.google.android.gms.common.api.GoogleApiClient.Builder(this)).addConnectionCallbacks(this).addOnConnectionFailedListener(this).addApi(Plus.API, com.google.android.gms.plus.Plus.PlusOptions.builder().build()).addScope(Plus.SCOPE_PLUS_LOGIN).addScope(Plus.SCOPE_PLUS_PROFILE).addScope(new Scope("https://www.googleapis.com/auth/plus.profile.emails.read")).build();
    }

    public void onResult(Result result)
    {
        result = (com.google.android.gms.plus.People.LoadPeopleResult)result;
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder("loadPeopleResult= ")).append(result).toString()
        });
        a(result);
        a(((Person) (null)));
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putInt("sign_in_progress", g);
    }

    protected void onStart()
    {
        super.onStart();
        if (!e.isConnecting())
        {
            DialogUtils.showDialog(this, f);
            a();
            return;
        }
        if ("connect".equals(d))
        {
            setResult(-1);
            finish();
            return;
        }
        DialogUtils.showDialog(this, f);
        Object obj = null;
        Person person;
        try
        {
            person = Plus.PeopleApi.getCurrentPerson(e);
        }
        catch (IllegalStateException illegalstateexception)
        {
            com.socialin.android.d.b(a, "tryGetGooglePlusUser", illegalstateexception);
            String s = illegalstateexception.getMessage();
            illegalstateexception = obj;
            if (!TextUtils.isEmpty(s))
            {
                illegalstateexception = obj;
                if (s.trim().toLowerCase().equals("GoogleApiClient must be connected".trim().toLowerCase()))
                {
                    a();
                    return;
                }
            }
        }
        a(person);
    }

    protected void onStop()
    {
        super.onStop();
        if (e != null && e.isConnected())
        {
            e.disconnect();
        }
    }

}

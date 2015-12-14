// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dropbox.client2.android;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.dropbox.client2.RESTUtility;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.dropbox.client2.android:
//            b

public class AuthActivity extends Activity
{

    public static Intent a = null;
    private static final String b = com/dropbox/client2/android/AuthActivity.getName();
    private static b c = new b();
    private static final Object d = new Object();
    private static String e;
    private static String f;
    private static String g = "www.dropbox.com";
    private static String h;
    private static String i;
    private static String j[];
    private static final String s[] = {
        "308202223082018b02044bd207bd300d06092a864886f70d01010405003058310b3009060355040613025553310b3009060355040813024341311630140603550407130d53616e204672616e636973636f3110300e060355040a130744726f70626f783112301006035504031309546f6d204d65796572301e170d3130303432333230343930315a170d3430303431353230343930315a3058310b3009060355040613025553310b3009060355040813024341311630140603550407130d53616e204672616e636973636f3110300e060355040a130744726f70626f783112301006035504031309546f6d204d6579657230819f300d06092a864886f70d010101050003818d0030818902818100ac1595d0ab278a9577f0ca5a14144f96eccde75f5616f36172c562fab0e98c48ad7d64f1091c6cc11ce084a4313d522f899378d312e112a748827545146a779defa7c31d8c00c2ed73135802f6952f59798579859e0214d4e9c0554b53b26032a4d2dfc2f62540d776df2ea70e2a6152945fb53fef5bac5344251595b729d4810203010001300d06092a864886f70d01010405000381810055c425d94d036153203dc0bbeb3516f94563b102fff39c3d4ed91278db24fc4424a244c2e59f03bbfea59404512b8bf74662f2a32e37eafa2ac904c31f99cfc21c9ff375c977c432d3b6ec22776f28767d0f292144884538c3d5669b568e4254e4ed75d9054f75229ac9d4ccd0b7c3c74a34f07b7657083b2aa76225c0c56ffc", "308201e53082014ea00302010202044e17e115300d06092a864886f70d01010505003037310b30090603550406130255533110300e060355040a1307416e64726f6964311630140603550403130d416e64726f6964204465627567301e170d3131303730393035303331375a170d3431303730313035303331375a3037310b30090603550406130255533110300e060355040a1307416e64726f6964311630140603550403130d416e64726f696420446562756730819f300d06092a864886f70d010101050003818d003081890281810096759fe5abea6a0757039b92adc68d672efa84732c3f959408e12efa264545c61f23141026a6d01eceeeaa13ec7087087e5894a3363da8bf5c69ed93657a6890738a80998e4ca22dc94848f30e2d0e1890000ae2cddf543b20c0c3828deca6c7944b5ecd21a9d18c988b2b3e54517dafbc34b48e801bb1321e0fa49e4d575d7f0203010001300d06092a864886f70d0101050500038181002b6d4b65bcfa6ec7bac97ae6d878064d47b3f9f8da654995b8ef4c385bc4fbfbb7a987f60783ef0348760c0708acd4b7e63f0235c35a4fbcd5ec41b3b4cb295feaa7d5c27fa562a02562b7e1f4776b85147be3e295714986c4a9a07183f48ea09ae4d3ea31b88d0016c65b93526b9c45f2967c3d28dee1aff5a5b29b9c2c8639"
    };
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p[];
    private String q;
    private boolean r;

    public AuthActivity()
    {
        q = null;
        r = false;
    }

    static String a()
    {
        return b;
    }

    private void a(Intent intent)
    {
        a = intent;
        q = null;
        finish();
    }

    static void a(AuthActivity authactivity, String s1)
    {
        Object obj = Locale.getDefault();
        String s2;
        String s3;
        String s4;
        String s5;
        if (authactivity.p.length > 0)
        {
            s2 = authactivity.p[0];
        } else
        {
            s2 = "0";
        }
        obj = (new StringBuilder()).append(((Locale) (obj)).getLanguage()).append("_").append(((Locale) (obj)).getCountry()).toString();
        s3 = authactivity.k;
        s4 = authactivity.c();
        s5 = authactivity.n;
        authactivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(RESTUtility.a(authactivity.m, "/connect", new String[] {
            "locale", obj, "k", s3, "n", s2, "s", s4, "api", s5, 
            "state", s1
        }))));
    }

    public static void a(String s1, String s2, String as[])
    {
        e = s1;
        f = null;
        i = null;
        j = new String[0];
        g = "www.dropbox.com";
        h = null;
    }

    public static boolean a(Context context, String s1)
    {
        Object obj = new Intent("android.intent.action.VIEW");
        s1 = (new StringBuilder("db-")).append(s1).toString();
        ((Intent) (obj)).setData(Uri.parse((new StringBuilder()).append(s1).append("://1/connect").toString()));
        obj = context.getPackageManager().queryIntentActivities(((Intent) (obj)), 0);
        if (obj == null || ((List) (obj)).size() == 0)
        {
            throw new IllegalStateException((new StringBuilder("URI scheme in your app's manifest is not set up correctly. You should have a ")).append(com/dropbox/client2/android/AuthActivity.getName()).append(" with the scheme: ").append(s1).toString());
        }
        if (((List) (obj)).size() > 1)
        {
            context = new android.app.AlertDialog.Builder(context);
            context.setTitle("Security alert");
            context.setMessage("Another app on your phone may be trying to pose as the app you are currently using. The malicious app can't access your account, but linking to Dropbox has been disabled as a precaution. Please contact support@dropbox.com.");
            context.setPositiveButton("OK", new android.content.DialogInterface.OnClickListener() {

                public final void onClick(DialogInterface dialoginterface, int i1)
                {
                    dialoginterface.dismiss();
                }

            });
            context.show();
            return false;
        }
        obj = (ResolveInfo)((List) (obj)).get(0);
        if (obj == null || ((ResolveInfo) (obj)).activityInfo == null || !context.getPackageName().equals(((ResolveInfo) (obj)).activityInfo.packageName))
        {
            throw new IllegalStateException((new StringBuilder("There must be a ")).append(com/dropbox/client2/android/AuthActivity.getName()).append(" within your app's package registered for your URI scheme (").append(s1).append("). However, it appears that an activity in a different package is registered for that scheme instead. If you have multiple apps that all want to use the same access").append("token pair, designate one of them to do authentication and have the other apps launch it and then retrieve the token pair from it.").toString());
        } else
        {
            return true;
        }
    }

    static boolean a(AuthActivity authactivity, Intent intent)
    {
        return authactivity.b(intent);
    }

    private static b b()
    {
        b b1;
        synchronized (d)
        {
            b1 = c;
        }
        return b1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static String b(AuthActivity authactivity, String s1)
    {
        authactivity.q = s1;
        return s1;
    }

    private boolean b(Intent intent)
    {
        PackageManager packagemanager;
        List list;
        packagemanager = getPackageManager();
        list = packagemanager.queryIntentActivities(intent, 0);
        if (list != null && 1 == list.size()) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if ((intent = packagemanager.resolveActivity(intent, 0)) != null)
        {
            int i1;
            int k1;
            try
            {
                intent = packagemanager.getPackageInfo(((ResolveInfo) (intent)).activityInfo.packageName, 64);
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                return false;
            }
            intent = ((PackageInfo) (intent)).signatures;
            k1 = intent.length;
            i1 = 0;
            while (i1 < k1) 
            {
                Signature signature = intent[i1];
                String as[] = s;
                for (int j1 = 0; j1 < 2; j1++)
                {
                    if (as[j1].equals(signature.toCharsString()))
                    {
                        return true;
                    }
                }

                i1++;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    private String c()
    {
        if (l == null)
        {
            return "";
        }
        MessageDigest messagedigest;
        try
        {
            messagedigest = MessageDigest.getInstance("SHA-1");
        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            throw new RuntimeException(nosuchalgorithmexception);
        }
        messagedigest.update(l.getBytes(), 0, l.length());
        return String.format("%1$040X", new Object[] {
            new BigInteger(1, messagedigest.digest())
        }).substring(32);
    }

    protected void onCreate(Bundle bundle)
    {
        if (bundle == null)
        {
            a = null;
            q = null;
            k = e;
            l = null;
            m = g;
            n = null;
            o = i;
            p = j;
        } else
        {
            q = bundle.getString("SIS_KEY_AUTH_STATE_NONCE");
        }
        a(null, null, null);
        setTheme(0x1030010);
        super.onCreate(bundle);
    }

    protected void onNewIntent(Intent intent)
    {
        Object obj4;
        obj4 = null;
        if (q == null)
        {
            a(null);
            return;
        }
        if (!intent.hasExtra("ACCESS_TOKEN")) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        Object obj2;
        obj2 = intent.getStringExtra("ACCESS_TOKEN");
        obj1 = intent.getStringExtra("ACCESS_SECRET");
        obj = intent.getStringExtra("UID");
        intent = intent.getStringExtra("AUTH_STATE");
_L12:
        Object obj3 = obj4;
        if (obj2 == null) goto _L4; else goto _L3
_L3:
        obj3 = obj4;
        if (((String) (obj2)).equals("")) goto _L4; else goto _L5
_L5:
        if (obj1 == null) goto _L7; else goto _L6
_L6:
        obj3 = obj4;
        if (((String) (obj1)).equals("")) goto _L4; else goto _L7
_L7:
        obj3 = obj4;
        if (obj != null)
        {
            obj3 = obj4;
            if (!((String) (obj)).equals(""))
            {
                obj3 = obj4;
                if (intent != null)
                {
                    obj3 = obj4;
                    if (!intent.equals(""))
                    {
                        if (!q.equals(intent))
                        {
                            a(null);
                            return;
                        }
                        obj3 = new Intent();
                        ((Intent) (obj3)).putExtra("ACCESS_TOKEN", ((String) (obj2)));
                        ((Intent) (obj3)).putExtra("ACCESS_SECRET", ((String) (obj1)));
                        ((Intent) (obj3)).putExtra("UID", ((String) (obj)));
                    }
                }
            }
        }
          goto _L4
_L2:
        obj2 = intent.getData();
        if (obj2 == null || !"/connect".equals(((Uri) (obj2)).getPath())) goto _L9; else goto _L8
_L8:
        obj1 = ((Uri) (obj2)).getQueryParameter("oauth_token");
        try
        {
            obj = ((Uri) (obj2)).getQueryParameter("oauth_token_secret");
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            intent = null;
            obj = null;
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            intent = ((Uri) (obj2)).getQueryParameter("uid");
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            intent = null;
            continue; /* Loop/switch isn't completed */
        }
        obj3 = ((Uri) (obj2)).getQueryParameter("state");
        obj2 = obj1;
        obj1 = obj;
        obj = intent;
        intent = ((Intent) (obj3));
        continue; /* Loop/switch isn't completed */
        intent;
        intent = null;
        obj = null;
        obj1 = null;
_L10:
        obj2 = obj1;
        obj1 = obj;
        obj = intent;
        intent = null;
        continue; /* Loop/switch isn't completed */
_L4:
        a(((Intent) (obj3)));
        return;
        obj2;
        if (true) goto _L10; else goto _L9
_L9:
        intent = null;
        obj = null;
        obj1 = null;
        obj2 = null;
        if (true) goto _L12; else goto _L11
_L11:
    }

    protected void onResume()
    {
        super.onResume();
        if (isFinishing())
        {
            return;
        }
        if (q != null || k == null)
        {
            a(null);
            return;
        }
        a = null;
        if (r)
        {
            Log.w(b, "onResume called again before Handler run");
            return;
        }
        byte abyte0[] = new byte[16];
        Object obj;
        if (b() != null)
        {
            obj = new SecureRandom();
        } else
        {
            obj = new SecureRandom();
        }
        ((SecureRandom) (obj)).nextBytes(abyte0);
        obj = new StringBuilder();
        if (l == null)
        {
            ((StringBuilder) (obj)).append("oauth2:");
        }
        for (int i1 = 0; i1 < 16; i1++)
        {
            ((StringBuilder) (obj)).append(String.format("%02x", new Object[] {
                Integer.valueOf(abyte0[i1] & 0xff)
            }));
        }

        obj = ((StringBuilder) (obj)).toString();
        Intent intent = new Intent("com.dropbox.android.AUTHENTICATE_V2");
        intent.setPackage("com.dropbox.android");
        intent.putExtra("CONSUMER_KEY", k);
        intent.putExtra("CONSUMER_SIG", c());
        intent.putExtra("DESIRED_UID", o);
        intent.putExtra("ALREADY_AUTHED_UIDS", p);
        intent.putExtra("CALLING_PACKAGE", getPackageName());
        intent.putExtra("CALLING_CLASS", getClass().getName());
        intent.putExtra("AUTH_STATE", ((String) (obj)));
        (new Handler(Looper.getMainLooper())).post(new Runnable(intent, ((String) (obj))) {

            private Intent a;
            private String b;
            private AuthActivity c;

            public final void run()
            {
                AuthActivity.a();
                if (!AuthActivity.a(c, a)) goto _L2; else goto _L1
_L1:
                c.startActivity(a);
_L4:
                AuthActivity.b(c, b);
                return;
_L2:
                try
                {
                    AuthActivity.a(c, b);
                }
                catch (ActivityNotFoundException activitynotfoundexception)
                {
                    Log.e(AuthActivity.a(), "Could not launch intent. User may have restricted profile", activitynotfoundexception);
                    c.finish();
                    return;
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                c = AuthActivity.this;
                a = intent;
                b = s1;
                super();
            }
        });
        r = true;
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("SIS_KEY_AUTH_STATE_NONCE", q);
    }

}

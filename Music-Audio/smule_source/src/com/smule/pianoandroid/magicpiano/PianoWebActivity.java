// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;
import com.smule.android.c.ab;
import com.smule.android.e.a;
import com.smule.pianoandroid.utils.n;
import com.smule.pianoandroid.utils.o;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            MagicApplication, ab

public class PianoWebActivity extends a
    implements ab
{

    static final String d = com/smule/pianoandroid/magicpiano/PianoWebActivity.getName();
    public static final String e = String.format("http://%s/magicpiano/android_help", new Object[] {
        MagicApplication.getContext().getString(0x7f0c02dc)
    });
    public static final String f = String.format("http://%s/privacy/embed", new Object[] {
        MagicApplication.getContext().getString(0x7f0c02dc)
    });
    public static final String g = String.format("http://%s/termsofservice/embed", new Object[] {
        MagicApplication.getContext().getString(0x7f0c02dc)
    });
    public static final String h = String.format("http://%s/apps/embed-android", new Object[] {
        MagicApplication.getContext().getString(0x7f0c02dc)
    });
    public static String i = null;
    protected com.smule.pianoandroid.magicpiano.ab j;

    public PianoWebActivity()
    {
    }

    public static void a(Activity activity, String s)
    {
        i = s;
        Intent intent = new Intent(activity, com/smule/pianoandroid/magicpiano/PianoWebActivity);
        intent.putExtra("SUPPORT_LINK", s);
        intent.putExtra("NO_EMAIL_CLIENT_RESOURCE", 0x7f0c01ad);
        intent.putExtra("CANT_CONNECT_RESOURCE", 0x7f0c0045);
        try
        {
            activity.startActivity(intent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.i(d, "Problem starting activity", s);
        }
        Toast.makeText(activity, activity.getResources().getString(0x7f0c01b4), 1).show();
    }

    public boolean a()
    {
        return true;
    }

    public String b()
    {
        if (f().booleanValue())
        {
            return "SmuleAppsWebView";
        } else
        {
            return "HelpWebView";
        }
    }

    protected String d()
    {
        String s = (new StringBuilder()).append("").append("Revision: ").append(getString(0x7f0c022d)).append("\n").toString();
        s = (new StringBuilder()).append(s).append("Build time: ").append(getString(0x7f0c0039)).append("\n").toString();
        return (new StringBuilder()).append(s).append("Android Key Hash: ").append(n.b(this)).append("\n").toString();
    }

    public Boolean e()
    {
        boolean flag;
        if (i != null && i.contains("help"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return Boolean.valueOf(flag);
    }

    public Boolean f()
    {
        boolean flag;
        if (i != null && i.contains("apps"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return Boolean.valueOf(flag);
    }

    public void onBackPressed()
    {
        o.e(this);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        j = (com.smule.pianoandroid.magicpiano.ab)findViewById(0x7f0a009b);
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (j != null)
        {
            j.e();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (j != null && j.a(menuitem))
        {
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    protected void onPostResume()
    {
        super.onPostResume();
        if (j != null)
        {
            j.a();
        }
    }

    public void onResume()
    {
        super.onResume();
        if (j != null)
        {
            j.f();
            if (f().booleanValue())
            {
                j.setTitle(getString(0x7f0c0260));
            } else
            if (e().booleanValue())
            {
                j.setTitle(getString(0x7f0c013c));
                return;
            }
        }
    }

}

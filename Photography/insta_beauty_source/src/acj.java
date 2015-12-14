// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.Toast;
import com.fotoable.fotobeauty.ShareEditActivity;
import com.wantu.weibo.other.sina.WeiboException;
import java.io.File;

public class acj extends AsyncTask
{

    final ShareEditActivity a;
    private final ProgressDialog b;

    public acj(ShareEditActivity shareeditactivity, Activity activity)
    {
        a = shareeditactivity;
        super();
        b = new ProgressDialog(activity);
        b.requestWindowFeature(1);
        b.setMessage(ShareEditActivity.b(shareeditactivity));
        b.show();
    }

    protected transient String a(String as[])
    {
        Object obj;
        brt brt1;
        SharedPreferences sharedpreferences;
        sharedpreferences = a.getSharedPreferences("com.wantu.android.WantuSetting", 0);
        as = new bri(sharedpreferences.getString("com.wantu.android.weibo.sina_token", null), sharedpreferences.getString("com.wantu.android.weibo.sina_secret", ""));
        brt1 = brt.a();
        brt1.a("1970943938", "96b30ffeffd7c387e7744a2608dfb524");
        brt1.a(as);
        obj = sharedpreferences.getString("com.wantu.android.weibo.sina_lastPenddingChar", null);
        if (obj != null) goto _L2; else goto _L1
_L1:
        as = ".";
_L4:
        obj = sharedpreferences.edit();
        ((android.content.SharedPreferences.Editor) (obj)).putString("com.wantu.android.weibo.sina_lastPenddingChar", as);
        ((android.content.SharedPreferences.Editor) (obj)).commit();
        obj = bka.a();
        if (!(new File(((bka) (obj)).c())).exists())
        {
            return String.valueOf(-1);
        }
        break; /* Loop/switch isn't completed */
_L2:
        if (((String) (obj)).equals("."))
        {
            as = "\u3002";
        } else
        {
            as = ((String []) (obj));
            if (((String) (obj)).equals("\u3002"))
            {
                as = ".";
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        brt1.a(a, (new StringBuilder()).append(ShareEditActivity.c(a).getText().toString()).append(as).toString(), ((bka) (obj)).c());
        int i = 0;
_L6:
        return String.valueOf(i);
        as;
        i = as.getStatusCode();
        continue; /* Loop/switch isn't completed */
        as;
        i = -1;
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected void a(String s)
    {
        b.dismiss();
        int i = Integer.valueOf(s).intValue();
        if (i == 0)
        {
            Toast.makeText(a, ShareEditActivity.f(a), 1).show();
        } else
        if (i == -1)
        {
            Toast.makeText(a, ShareEditActivity.g(a), 1).show();
        } else
        {
            s = bro.a(i);
            Toast.makeText(a, s, 1).show();
        }
        a.finish();
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((String[])aobj);
    }

    protected void onCancelled()
    {
        b.dismiss();
        super.onCancelled();
    }

    protected void onPostExecute(Object obj)
    {
        a((String)obj);
    }
}

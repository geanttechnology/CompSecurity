// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import com.fotoable.fotobeauty.ShareEditActivity;

public class ach extends AsyncTask
{

    final ShareEditActivity a;

    public ach(ShareEditActivity shareeditactivity, Activity activity)
    {
        a = shareeditactivity;
        super();
    }

    protected transient String a(String as[])
    {
        String s = "-1";
        String s1;
        try
        {
            as = new brf("116913278412853");
            Object obj = a.getSharedPreferences("com.wantu.android.WantuSetting", 0);
            s1 = ((SharedPreferences) (obj)).getString("com.wantu.android.facebook.accesstoken.key", null);
            obj = ((SharedPreferences) (obj)).getString("com.wantu.android.facebook.accesstoken.expire.key", null);
            as.a(s1);
            as.b(((String) (obj)));
            byte abyte0[] = boz.a(bka.a().c());
            obj = new Bundle();
            ((Bundle) (obj)).putByteArray("photo", abyte0);
            ((Bundle) (obj)).putString("caption", ShareEditActivity.c(a).getText().toString());
            abyte0 = as.a("me/photos", ((Bundle) (obj)), "POST");
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            return "-1";
        }
        as = s;
        if (abyte0 == null)
        {
            break MISSING_BLOCK_LABEL_137;
        }
        as = s;
        if (abyte0.indexOf("id") >= 0)
        {
            as = "1";
        }
        return as;
    }

    protected void a(String s)
    {
        int i;
        ShareEditActivity.h(a);
        i = Integer.valueOf(s).intValue();
        if (i != 1) goto _L2; else goto _L1
_L1:
        Toast.makeText(a, ShareEditActivity.j(a).getString(0x7f060233), 1).show();
_L4:
        a.finish();
        return;
_L2:
        if (i == -1)
        {
            Toast.makeText(a, ShareEditActivity.j(a).getString(0x7f060232), 1).show();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((String[])aobj);
    }

    protected void onCancelled()
    {
        ShareEditActivity.h(a);
        super.onCancelled();
    }

    protected void onPostExecute(Object obj)
    {
        a((String)obj);
    }

    protected void onPreExecute()
    {
        ShareEditActivity.i(a);
    }
}

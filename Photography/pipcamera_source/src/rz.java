// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import com.crashlytics.android.Crashlytics;
import com.fotoable.comlib.util.AsyncTask;
import com.pipcamera.activity.ShareEditActivity;

public class rz extends AsyncTask
{

    final ShareEditActivity a;
    private final ProgressDialog b;

    public rz(ShareEditActivity shareeditactivity, Activity activity)
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
        try
        {
            as = new zb("382743411764062");
            Object obj = a.getSharedPreferences("com.wantu.android.WantuSetting", 0);
            String s = ((SharedPreferences) (obj)).getString("com.wantu.android.facebook.accesstoken.key", null);
            obj = ((SharedPreferences) (obj)).getString("com.wantu.android.facebook.accesstoken.expire.key", null);
            as.a(s);
            as.b(((String) (obj)));
            byte abyte0[] = ym.a(uz.a().d());
            obj = new Bundle();
            ((Bundle) (obj)).putByteArray("photo", abyte0);
            ((Bundle) (obj)).putString("caption", ShareEditActivity.c(a).getText().toString());
            Log.v("lb", as.a("me/photos", ((Bundle) (obj)), "POST"));
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            Crashlytics.logException(as);
            return null;
        }
        return null;
    }

    protected void a(String s)
    {
        b.dismiss();
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

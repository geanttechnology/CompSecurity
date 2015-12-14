// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.app.ProgressDialog;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;
import com.crashlytics.android.Crashlytics;
import com.fotoable.comlib.util.AsyncTask;
import com.pipcamera.activity.ShareEditActivity;
import java.io.File;

public class sa extends AsyncTask
{

    final ShareEditActivity a;
    private final Activity b;
    private final ProgressDialog c;

    public sa(ShareEditActivity shareeditactivity, Activity activity)
    {
        a = shareeditactivity;
        super();
        b = activity;
        c = new ProgressDialog(activity);
        c.requestWindowFeature(1);
        c.setMessage(ShareEditActivity.b(shareeditactivity));
        c.show();
    }

    protected transient String a(String as[])
    {
        Object obj;
        obj = yz.b(b);
        as = new zj();
        as.a("801279637");
        as.b("6d65c5d279ab5ab38e7a78b2a6b51ac6");
        as.c(((za) (obj)).a());
        as.d(((za) (obj)).b());
        obj = new zg();
        byte abyte0[] = uz.a();
        if (!abyte0.e()) goto _L2; else goto _L1
_L1:
        abyte0 = abyte0.c();
        if (abyte0 != null)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        return String.valueOf(-1);
        as = ((zg) (obj)).a(as, "json", ShareEditActivity.c(a).getText().toString(), "127.0.0.1", null, null, abyte0);
_L3:
        Log.d("lb", as);
        int i = 0;
_L4:
        return String.valueOf(i);
_L2:
        if (!(new File(abyte0.d())).exists())
        {
            return String.valueOf(-1);
        }
        as = ((zg) (obj)).a(as, "json", ShareEditActivity.c(a).getText().toString(), "127.0.0.1", abyte0.d());
          goto _L3
        as;
        as.printStackTrace();
        Crashlytics.logException(as);
        i = -1;
          goto _L4
    }

    protected void a(String s)
    {
        int i;
        c.dismiss();
        i = Integer.valueOf(s).intValue();
        if (i != 0) goto _L2; else goto _L1
_L1:
        Toast.makeText(a, ShareEditActivity.d(a), 1).show();
_L4:
        a.finish();
        return;
_L2:
        if (i == -1)
        {
            Toast.makeText(a, ShareEditActivity.e(a), 1).show();
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
        c.dismiss();
        super.onCancelled();
    }

    protected void onPostExecute(Object obj)
    {
        a((String)obj);
    }
}

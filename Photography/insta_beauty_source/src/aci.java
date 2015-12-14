// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;
import com.fotoable.fotobeauty.ShareEditActivity;
import java.io.File;

public class aci extends AsyncTask
{

    final ShareEditActivity a;
    private final Activity b;
    private final ProgressDialog c;

    public aci(ShareEditActivity shareeditactivity, Activity activity)
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
        obj = brd.a(b);
        as = new brz();
        as.a("d02185e9c6cb443d9a6791959b8241a3");
        as.b("b77f03ed0a43373ec01e92dedc21ae42");
        as.c(((bre) (obj)).a());
        as.d(((bre) (obj)).b());
        obj = new brw();
        byte abyte0[] = bka.a();
        if (!abyte0.d()) goto _L2; else goto _L1
_L1:
        abyte0 = abyte0.b();
        if (abyte0 != null)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        return String.valueOf(-1);
        as = ((brw) (obj)).a(as, "json", ShareEditActivity.c(a).getText().toString(), "127.0.0.1", null, null, abyte0);
_L3:
        Log.d("lb", as);
        int i = 0;
_L4:
        return String.valueOf(i);
_L2:
        if (!(new File(abyte0.c())).exists())
        {
            return String.valueOf(-1);
        }
        as = ((brw) (obj)).a(as, "json", ShareEditActivity.c(a).getText().toString(), "127.0.0.1", abyte0.c());
          goto _L3
        as;
        as.printStackTrace();
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

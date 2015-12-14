// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import com.crashlytics.android.Crashlytics;
import com.fotoable.comlib.util.AsyncTask;
import com.google.gson.Gson;
import java.util.List;
import java.util.concurrent.Semaphore;

class op extends AsyncTask
{

    final oo a;
    private List b;

    public op(oo oo1, List list)
    {
        a = oo1;
        super();
        b = null;
        b = list;
    }

    protected transient Void a(Void avoid[])
    {
        if (b == null || b.size() <= 0) goto _L2; else goto _L1
_L1:
        Log.v(oo.a, (new StringBuilder()).append(oo.a).append(" AsyncArChiveTask archive begin size:").append(b.size()).toString());
        avoid = (new Gson()).toJson(b);
        oo.h().acquire();
        oo.a(a).a(oo.b, avoid, new ahq());
_L3:
        oo.h().release();
_L2:
        Log.v(oo.a, (new StringBuilder()).append(oo.a).append("AsyncArChiveTask  archive end").toString());
        return null;
        avoid;
        Crashlytics.logException(avoid);
          goto _L3
        avoid;
          goto _L2
    }

    protected void a(Void void1)
    {
        super.onPostExecute(void1);
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Void)obj);
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
    }
}

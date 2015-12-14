// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import com.crashlytics.android.Crashlytics;
import com.fotoable.comlib.util.AsyncTask;
import com.google.gson.Gson;
import java.util.List;
import java.util.concurrent.Semaphore;

class awi extends AsyncTask
{

    final awg a;
    private List b;

    public awi(awg awg1, List list)
    {
        a = awg1;
        super();
        b = null;
        b = list;
    }

    protected transient Void a(Void avoid[])
    {
        if (b == null || b.size() <= 0) goto _L2; else goto _L1
_L1:
        Log.v(awg.a, (new StringBuilder()).append(awg.a).append(" AsyncArChiveTask archive begin size:").append(b.size()).toString());
        avoid = (new Gson()).toJson(b);
        awg.h().acquire();
        awg.a(a).a(awg.b, avoid, new cer());
_L3:
        awg.h().release();
_L2:
        Log.v(awg.a, (new StringBuilder()).append(awg.a).append("AsyncArChiveTask  archive end").toString());
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

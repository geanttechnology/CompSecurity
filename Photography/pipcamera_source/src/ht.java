// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import com.fotoable.comlib.util.AsyncTask;
import com.google.gson.Gson;
import java.util.List;

class ht extends AsyncTask
{

    final hs a;
    private List b;

    public ht(hs hs1, List list)
    {
        a = hs1;
        super();
        b = null;
        b = list;
    }

    protected transient Void a(Void avoid[])
    {
        if (b != null && b.size() > 0)
        {
            Log.v(hs.a(a), (new StringBuilder()).append(hs.a(a)).append(" AsyncArChiveTask archive begin size:").append(b.size()).toString());
            String s = (new Gson()).toJson(b);
            synchronized (hs.b(a))
            {
                hs.b(a).a(hs.c(a), s, new ahq());
            }
        }
        Log.v(hs.a(a), (new StringBuilder()).append(hs.a(a)).append("AsyncArChiveTask  archive end").toString());
        return null;
        exception;
        avoid;
        JVM INSTR monitorexit ;
        throw exception;
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

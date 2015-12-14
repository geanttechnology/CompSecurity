// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import com.crashlytics.android.Crashlytics;
import com.fotoable.comlib.util.AsyncTask;

class zc extends AsyncTask
{

    final zb a;
    private final String b;
    private final Context c;

    public zc(zb zb1, String s, Context context)
    {
        a = zb1;
        super();
        b = s;
        c = context.getApplicationContext();
    }

    protected transient Void a(Void avoid[])
    {
        try
        {
            zb.a(a, b, c);
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            ze.a("Facebook-publish", avoid.getMessage());
            Crashlytics.logException(avoid);
        }
        return null;
    }

    protected void a(Void void1)
    {
        synchronized (a)
        {
            zb.a(a, null);
        }
        return;
        exception;
        void1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Void)obj);
    }
}

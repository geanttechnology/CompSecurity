// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.AsyncTask;

class brg extends AsyncTask
{

    final brf a;
    private final String b;
    private final Context c;

    protected transient Void a(Void avoid[])
    {
        try
        {
            brf.a(a, b, c);
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            brh.a("Facebook-publish", avoid.getMessage());
        }
        return null;
    }

    protected void a(Void void1)
    {
        synchronized (a)
        {
            brf.a(a, null);
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

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.os.AsyncTask;

public class gi extends AsyncTask
{

    Bitmap a;
    gj b;

    protected transient Boolean a(String as[])
    {
        return Boolean.valueOf(gm.c().a(a));
    }

    protected void a(Boolean boolean1)
    {
        if (b != null)
        {
            b.a(boolean1.booleanValue());
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((String[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Boolean)obj);
    }
}

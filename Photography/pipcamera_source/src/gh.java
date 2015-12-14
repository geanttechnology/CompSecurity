// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.comlib.util.AsyncTask;
import java.util.List;

public class gh extends AsyncTask
{

    List a;
    gj b;

    public gh()
    {
    }

    protected transient Boolean a(String as[])
    {
        return Boolean.valueOf(gm.c().a(a));
    }

    public void a(gj gj1)
    {
        b = gj1;
    }

    protected void a(Boolean boolean1)
    {
        if (b != null)
        {
            b.a(boolean1.booleanValue());
        }
    }

    public void a(List list)
    {
        a = list;
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

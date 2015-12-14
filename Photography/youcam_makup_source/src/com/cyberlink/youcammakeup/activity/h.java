// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.os.AsyncTask;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            EditViewActivity

class h extends AsyncTask
{

    final EditViewActivity a;

    private h(EditViewActivity editviewactivity)
    {
        a = editviewactivity;
        super();
    }

    h(EditViewActivity editviewactivity, EditViewActivity._cls1 _pcls1)
    {
        this(editviewactivity);
    }

    protected transient Boolean a(Void avoid[])
    {
        boolean flag = false;
        long l = System.currentTimeMillis();
        do
        {
            if (System.currentTimeMillis() - l >= 5000L)
            {
                if (!EditViewActivity.c(a))
                {
                    flag = true;
                }
                return Boolean.valueOf(flag);
            }
            try
            {
                Thread.sleep(500L);
                publishProgress(new Void[0]);
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.getLocalizedMessage();
            }
        } while (true);
    }

    protected void a(Boolean boolean1)
    {
        if (boolean1.booleanValue())
        {
            a.k();
        }
    }

    protected transient void b(Void avoid[])
    {
        if (EditViewActivity.c(a) && EditViewActivity.d(a) != null)
        {
            EditViewActivity.d(a).cancel(true);
            EditViewActivity.a(a, null);
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Boolean)obj);
    }

    protected void onProgressUpdate(Object aobj[])
    {
        b((Void[])aobj);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.perfectcorp.utility;

import android.os.AsyncTask;

// Referenced classes of package com.perfectcorp.utility:
//            j, e, o

class a extends AsyncTask
{

    final j a;

    protected transient Object doInBackground(Object aobj[])
    {
        a.u = new o() {

            final j._cls3 a;

            
            {
                a = j._cls3.this;
                super();
            }
        };
        aobj = ((Object []) (a.a(aobj[0])));
        return ((Object) (aobj));
        aobj;
        e.e(new Object[] {
            aobj
        });
        ((Exception) (aobj)).printStackTrace();
        a.b(0x80000001);
_L2:
        return null;
        aobj;
        e.e(new Object[] {
            aobj
        });
        ((OutOfMemoryError) (aobj)).printStackTrace();
        a.b(0x80000006);
        System.gc();
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected void onCancelled()
    {
        if (a.t == null)
        {
            a.a();
            return;
        }
        if (j.b(a) != null)
        {
            a.t.a(j.b(a).intValue());
        } else
        {
            a.t.a();
        }
        a.b();
    }

    protected void onPostExecute(Object obj)
    {
        a.a_(obj);
    }

    protected transient void onProgressUpdate(Object aobj[])
    {
        a.c(aobj[0]);
    }

    _cls1.a(j j1)
    {
        a = j1;
        super();
    }
}

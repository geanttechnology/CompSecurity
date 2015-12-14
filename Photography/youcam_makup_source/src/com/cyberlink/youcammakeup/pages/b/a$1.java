// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.b;

import android.os.AsyncTask;
import android.util.Pair;
import com.cyberlink.beautycircle.a;
import com.cyberlink.youcammakeup.Globals;

// Referenced classes of package com.cyberlink.youcammakeup.pages.b:
//            a

class a extends AsyncTask
{

    final com.cyberlink.youcammakeup.pages.b.a a;

    protected transient Pair a(Void avoid[])
    {
        return com.cyberlink.beautycircle.a.a(Globals.d());
    }

    protected void a(Pair pair)
    {
        com.cyberlink.youcammakeup.pages.b.a.a(a, pair);
        com.cyberlink.youcammakeup.pages.b.a.a(a, false);
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Pair)obj);
    }

    (com.cyberlink.youcammakeup.pages.b.a a1)
    {
        a = a1;
        super();
    }
}

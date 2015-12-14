// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker.photopage;

import android.os.AsyncTask;
import com.cyberlink.youcammakeup.c;
import com.cyberlink.youcammakeup.database.a;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.youcammakeup.pages.librarypicker.photopage:
//            c, a, PhotoView

class b extends AsyncTask
{

    final long a;
    final int b;
    final com.cyberlink.youcammakeup.pages.librarypicker.photopage.c c;

    protected transient ArrayList a(Void avoid[])
    {
        avoid = new ArrayList();
        long al[] = com.cyberlink.youcammakeup.c.c().b(a);
        int j = al.length;
        for (int i = 0; i < j; i++)
        {
            avoid.add(new com.cyberlink.youcammakeup.pages.librarypicker.photopage.a(-1L, al[i]));
        }

        return avoid;
    }

    protected void a(ArrayList arraylist)
    {
        com.cyberlink.youcammakeup.pages.librarypicker.photopage.c.a(c, Long.valueOf(a));
        com.cyberlink.youcammakeup.pages.librarypicker.photopage.c.a(c).clear();
        com.cyberlink.youcammakeup.pages.librarypicker.photopage.c.a(c).addAll(arraylist);
        c.notifyDataSetChanged();
        com.cyberlink.youcammakeup.pages.librarypicker.photopage.c.b(c).setSelection(b);
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((ArrayList)obj);
    }

    oView(com.cyberlink.youcammakeup.pages.librarypicker.photopage.c c1, long l, int i)
    {
        c = c1;
        a = l;
        b = i;
        super();
    }
}

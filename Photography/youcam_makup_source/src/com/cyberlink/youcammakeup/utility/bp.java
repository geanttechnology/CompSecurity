// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import android.os.AsyncTask;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.utility:
//            bs, br, bt, bo, 
//            bu

public class bp extends AsyncTask
{

    private final bu a;
    private final List b;

    public bp(List list, bu bu1)
    {
        b = list;
        a = bu1;
    }

    protected transient List a(Void avoid[])
    {
        int j = b.size();
        avoid = new ArrayList();
        for (int i = 0; i < j; i++)
        {
            bs bs1 = (bs)b.get(i);
            if (!bs1.c.equals(""))
            {
                br br1 = new br();
                (new bt(bs1, br1)).a();
                avoid.add(br1);
                if (br1.c == null)
                {
                    bo.a(br1);
                }
            }
            publishProgress(new Integer[] {
                Integer.valueOf((int)(((float)i / (float)j) * 100F))
            });
        }

        return avoid;
    }

    protected void a(List list)
    {
        if (a != null)
        {
            a.a(list);
        }
    }

    protected transient void a(Integer ainteger[])
    {
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((List)obj);
    }

    protected void onProgressUpdate(Object aobj[])
    {
        a((Integer[])aobj);
    }
}

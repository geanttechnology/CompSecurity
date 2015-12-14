// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.editview.savemylook.a;

import android.os.AsyncTask;
import android.os.Handler;
import com.cyberlink.youcammakeup.kernelctrl.collageComposer.v;
import com.cyberlink.youcammakeup.widgetpool.collageBasicView.a;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.pages.editview.savemylook.a:
//            a, b

class a extends AsyncTask
{

    final Handler a;
    final com.cyberlink.youcammakeup.pages.editview.savemylook.a.a b;

    protected transient Void a(Void avoid[])
    {
        int j = com.cyberlink.youcammakeup.pages.editview.savemylook.a.a.a(b).size();
        avoid = new ArrayList();
        int i = 0;
        while (i < j) 
        {
            b b1 = (b)com.cyberlink.youcammakeup.pages.editview.savemylook.a.a.a(b).get(i);
            if (b1.c == null)
            {
                Object obj = b1.a;
                obj = com.cyberlink.youcammakeup.pages.editview.savemylook.a.a.g(b).a(((a) (obj)).a, ((a) (obj)).b);
                if (obj != null)
                {
                    b1.b = ((com.cyberlink.youcammakeup.kernelctrl.collageComposer.o) (obj));
                    avoid.add(b1);
                }
            }
            i++;
        }
        com.cyberlink.youcammakeup.pages.editview.savemylook.a.a.a(b, avoid);
        return null;
    }

    protected void a(Void void1)
    {
        if (com.cyberlink.youcammakeup.pages.editview.savemylook.a.a.a(b).size() > 0)
        {
            a.post(new <init>(b, a));
            return;
        } else
        {
            b.notifyDataSetChanged();
            return;
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Void)obj);
    }

    (com.cyberlink.youcammakeup.pages.editview.savemylook.a.a a1, Handler handler)
    {
        b = a1;
        a = handler;
        super();
    }
}

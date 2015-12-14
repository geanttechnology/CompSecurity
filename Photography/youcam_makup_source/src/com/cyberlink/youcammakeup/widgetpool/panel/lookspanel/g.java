// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.lookspanel;

import android.os.AsyncTask;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.bo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.lookspanel:
//            LooksImageAdapter

class g extends AsyncTask
{

    final LooksImageAdapter a;

    private g(LooksImageAdapter looksimageadapter)
    {
        a = looksimageadapter;
        super();
    }

    g(LooksImageAdapter looksimageadapter, LooksImageAdapter._cls1 _pcls1)
    {
        this(looksimageadapter);
    }

    protected transient List a(Void avoid[])
    {
        avoid = new ArrayList();
        for (Iterator iterator = PanelDataCenter.a().a(com.cyberlink.youcammakeup.utility.PanelDataCenter.LookType.a(a.b), new com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType[] {
    com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a
}).iterator(); iterator.hasNext(); avoid.add(bo.z((String)iterator.next()))) { }
        a.b();
        LooksImageAdapter.a(a);
        return avoid;
    }

    protected void a(List list)
    {
        a.e.addAll(list);
        a.notifyDataSetChanged();
        Globals.d(new Runnable() {

            final g a;

            public void run()
            {
                StatusManager.j().x();
            }

            
            {
                a = g.this;
                super();
            }
        });
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((List)obj);
    }
}

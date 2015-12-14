// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.net.Uri;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import com.cyberlink.youcammakeup.pages.shareview.ShareItemAdapter;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            ai, ae, ag

class b extends AsyncTask
{

    final View a;
    final int b;
    final c c;

    protected transient ArrayList a(Void avoid[])
    {
        avoid = new ArrayList(1);
        try
        {
            avoid.add(ai.d(c.c).take());
        }
        catch (InterruptedException interruptedexception)
        {
            interruptedexception.printStackTrace();
            return avoid;
        }
        return avoid;
    }

    protected void a(ArrayList arraylist)
    {
        ai.e(c.c).a(b, arraylist);
        ai.a(c.c, true);
        ai.b(c.c);
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((ArrayList)obj);
    }

    protected void onPreExecute()
    {
        a.setPressed(true);
        ai.a(c.c, false);
    }

    a(a a1, View view, int i)
    {
        c = a1;
        a = view;
        b = i;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/dialogs/ai$5

/* anonymous class */
    class ai._cls5
        implements android.widget.AdapterView.OnItemClickListener
    {

        final ai a;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            adapterview = new ai._cls5._cls1(this, view, i);
            if (ai.c(a) != null)
            {
                ai.c(a).a(new ai._cls5._cls2(adapterview));
                return;
            } else
            {
                adapterview.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                return;
            }
        }

            
            {
                a = ai1;
                super();
            }

        // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/dialogs/ai$5$2

/* anonymous class */
        class ai._cls5._cls2
            implements ag
        {

            final AsyncTask a;
            final ai._cls5 b;

            public void a(Uri uri)
            {
                b.a.a(uri);
                a.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            }

                    
                    {
                        b = ai._cls5.this;
                        a = asynctask;
                        super();
                    }
        }

    }

}

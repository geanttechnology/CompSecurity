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

class a
    implements android.widget.erView.OnItemClickListener
{

    final ai a;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = new AsyncTask(view, i) {

            final View a;
            final int b;
            final ai._cls5 c;

            protected transient ArrayList a(Void avoid[])
            {
                avoid = new ArrayList(1);
                try
                {
                    avoid.add(ai.d(c.a).take());
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
                ai.e(c.a).a(b, arraylist);
                ai.a(c.a, true);
                ai.b(c.a);
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
                ai.a(c.a, false);
            }

            
            {
                c = ai._cls5.this;
                a = view;
                b = i;
                super();
            }
        };
        if (ai.c(a) != null)
        {
            ai.c(a).a(new ag(adapterview) {

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
            });
            return;
        } else
        {
            adapterview.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        }
    }

    _cls2.a(ai ai1)
    {
        a = ai1;
        super();
    }
}

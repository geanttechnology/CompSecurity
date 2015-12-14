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
//            ag, ai, ae

class a
    implements ag
{

    final AsyncTask a;
    final a b;

    public void a(Uri uri)
    {
        b.b.a(uri);
        a.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    b(b b1, AsyncTask asynctask)
    {
        b = b1;
        a = asynctask;
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
            adapterview = new ai._cls5._cls1(view, i);
            if (ai.c(a) != null)
            {
                ai.c(a).a(new ai._cls5._cls2(this, adapterview));
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

        // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/dialogs/ai$5$1

/* anonymous class */
        class ai._cls5._cls1 extends AsyncTask
        {

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
        }

    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.app.Activity;
import android.util.Log;
import android.widget.ListView;
import com.cyberlink.you.chat.b;
import com.cyberlink.you.chat.l;
import com.cyberlink.you.database.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.you.activity:
//            ChatDialogActivity, e

class a
    implements Runnable
{

    final List a;
    final b b;

    public void run()
    {
        synchronized (ChatDialogActivity.p(b.b))
        {
            if (ChatDialogActivity.a(b.b) != null)
            {
                Log.d("ChatDialogActivity", "Sort archive message");
                b(b);
                ChatDialogActivity.a(b.b).a(a, true);
                e.a(ChatDialogActivity.a(b.b), new g());
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    ( , List list)
    {
        b = ;
        a = list;
        super();
    }

    // Unreferenced inner class com/cyberlink/you/activity/ChatDialogActivity$13

/* anonymous class */
    class ChatDialogActivity._cls13
        implements l
    {

        final ChatDialogActivity a;

        static void a(ChatDialogActivity._cls13 _pcls13)
        {
            _pcls13.c();
        }

        private void c()
        {
            int i = (ChatDialogActivity.a(a).getCount() - 1) + ChatDialogActivity.c(a).getHeaderViewsCount();
            if (i > ChatDialogActivity.e(a) - 1 && i == ChatDialogActivity.c(a).getLastVisiblePosition())
            {
                com.cyberlink.you.activity.ChatDialogActivity.b(a, false);
            }
        }

        public void a()
        {
            ArrayList arraylist = new ArrayList();
            Iterator iterator = ChatDialogActivity.x(a).iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Object obj = (b)iterator.next();
                obj = ChatDialogActivity.d(a, ((b) (obj)));
                if (obj != null)
                {
                    arraylist.add(obj);
                }
            } while (true);
            if (!arraylist.isEmpty())
            {
                com.cyberlink.you.activity.ChatDialogActivity.g(a).runOnUiThread(new ChatDialogActivity._cls13._cls1(this, arraylist));
            }
            a.b(false);
        }

        public void b()
        {
            a.b(true);
        }

            
            {
                a = chatdialogactivity;
                super();
            }
    }

}

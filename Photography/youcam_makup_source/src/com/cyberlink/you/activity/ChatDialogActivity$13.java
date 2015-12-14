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
    implements l
{

    final ChatDialogActivity a;

    static void a(a a1)
    {
        a1.c();
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
            com.cyberlink.you.activity.ChatDialogActivity.g(a).runOnUiThread(new Runnable(arraylist) {

                final List a;
                final ChatDialogActivity._cls13 b;

                public void run()
                {
                    synchronized (ChatDialogActivity.p(b.a))
                    {
                        if (ChatDialogActivity.a(b.a) != null)
                        {
                            Log.d("ChatDialogActivity", "Sort archive message");
                            ChatDialogActivity._cls13.a(b);
                            ChatDialogActivity.a(b.a).a(a, true);
                            e.a(ChatDialogActivity.a(b.a), new g());
                        }
                    }
                    return;
                    exception;
                    obj1;
                    JVM INSTR monitorexit ;
                    throw exception;
                }

            
            {
                b = ChatDialogActivity._cls13.this;
                a = list;
                super();
            }
            });
        }
        a.b(false);
    }

    public void b()
    {
        a.b(true);
    }

    _cls1.a(ChatDialogActivity chatdialogactivity)
    {
        a = chatdialogactivity;
        super();
    }
}

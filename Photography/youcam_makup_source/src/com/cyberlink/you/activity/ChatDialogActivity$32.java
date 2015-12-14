// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.app.Activity;
import com.cyberlink.you.chat.ad;
import com.cyberlink.you.database.Group;
import com.cyberlink.you.database.MessageObj;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.cyberlink.you.activity:
//            ChatDialogActivity, e

class a
    implements ad
{

    final ChatDialogActivity a;

    public boolean a(boolean flag, MessageObj messageobj)
    {
        if (!String.valueOf(ChatDialogActivity.b(a).b).equals(messageobj.c()))
        {
            return false;
        } else
        {
            ChatDialogActivity.g(a).runOnUiThread(new Runnable(flag, messageobj) {

                final boolean a;
                final MessageObj b;
                final ChatDialogActivity._cls32 c;

                public void run()
                {
                    Object obj = ChatDialogActivity.p(c.a);
                    obj;
                    JVM INSTR monitorenter ;
                    Object obj1;
                    if (a)
                    {
                        break MISSING_BLOCK_LABEL_182;
                    }
                    if (!ChatDialogActivity.w(c.a).containsKey(b.b()))
                    {
                        break MISSING_BLOCK_LABEL_81;
                    }
                    obj1 = (MessageObj)ChatDialogActivity.w(c.a).get(b.b());
                    if (obj1 == null)
                    {
                        break MISSING_BLOCK_LABEL_81;
                    }
                    ((MessageObj) (obj1)).c("3");
                    if (ChatDialogActivity.a(c.a) == null || e.a(ChatDialogActivity.a(c.a)) == null)
                    {
                        break MISSING_BLOCK_LABEL_182;
                    }
                    obj1 = e.a(ChatDialogActivity.a(c.a)).iterator();
_L2:
                    MessageObj messageobj1;
                    do
                    {
                        if (!((Iterator) (obj1)).hasNext())
                        {
                            break MISSING_BLOCK_LABEL_182;
                        }
                        messageobj1 = (MessageObj)((Iterator) (obj1)).next();
                    } while (messageobj1 == null);
                    if (messageobj1.b() == null || !messageobj1.b().equals(b.b())) goto _L2; else goto _L1
_L1:
                    messageobj1.c("3");
                    if (ChatDialogActivity.a(c.a) != null)
                    {
                        ChatDialogActivity.a(c.a).notifyDataSetChanged();
                    }
                    obj;
                    JVM INSTR monitorexit ;
                    return;
                    Exception exception;
                    exception;
                    obj;
                    JVM INSTR monitorexit ;
                    throw exception;
                }

            
            {
                c = ChatDialogActivity._cls32.this;
                a = flag;
                b = messageobj;
                super();
            }
            });
            return true;
        }
    }

    _cls1.b(ChatDialogActivity chatdialogactivity)
    {
        a = chatdialogactivity;
        super();
    }
}

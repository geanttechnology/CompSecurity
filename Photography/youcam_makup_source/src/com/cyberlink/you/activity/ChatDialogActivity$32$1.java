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

class b
    implements Runnable
{

    final boolean a;
    final MessageObj b;
    final c c;

    public void run()
    {
        Object obj = ChatDialogActivity.p(c.c);
        obj;
        JVM INSTR monitorenter ;
        Object obj1;
        if (a)
        {
            break MISSING_BLOCK_LABEL_182;
        }
        if (!ChatDialogActivity.w(c.c).containsKey(b.b()))
        {
            break MISSING_BLOCK_LABEL_81;
        }
        obj1 = (MessageObj)ChatDialogActivity.w(c.c).get(b.b());
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        ((MessageObj) (obj1)).c("3");
        if (ChatDialogActivity.a(c.c) == null || e.a(ChatDialogActivity.a(c.c)) == null)
        {
            break MISSING_BLOCK_LABEL_182;
        }
        obj1 = e.a(ChatDialogActivity.a(c.c)).iterator();
_L2:
        MessageObj messageobj;
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break MISSING_BLOCK_LABEL_182;
            }
            messageobj = (MessageObj)((Iterator) (obj1)).next();
        } while (messageobj == null);
        if (messageobj.b() == null || !messageobj.b().equals(b.b())) goto _L2; else goto _L1
_L1:
        messageobj.c("3");
        if (ChatDialogActivity.a(c.c) != null)
        {
            ChatDialogActivity.a(c.c).notifyDataSetChanged();
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

    ( , boolean flag, MessageObj messageobj)
    {
        c = ;
        a = flag;
        b = messageobj;
        super();
    }

    // Unreferenced inner class com/cyberlink/you/activity/ChatDialogActivity$32

/* anonymous class */
    class ChatDialogActivity._cls32
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
                ChatDialogActivity.g(a).runOnUiThread(new ChatDialogActivity._cls32._cls1(this, flag, messageobj));
                return true;
            }
        }

            
            {
                a = chatdialogactivity;
                super();
            }
    }

}

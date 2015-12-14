// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import com.cyberlink.you.database.MessageObj;
import com.cyberlink.you.database.f;
import com.cyberlink.you.database.g;
import com.cyberlink.you.e;
import com.cyberlink.you.utility.ULogUtility;
import java.util.Map;

// Referenced classes of package com.cyberlink.you.activity:
//            ChatDialogActivity, e

class a
    implements Runnable
{

    final String a;
    final ChatDialogActivity b;

    public void run()
    {
        Object obj = ChatDialogActivity.p(b);
        obj;
        JVM INSTR monitorenter ;
        Object obj1 = e.d().a(a);
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        obj1 = new StringBuffer();
        ((StringBuffer) (obj1)).append("[").append("ChatDialogActivity").append("]");
        ((StringBuffer) (obj1)).append(" onHandleReceiveDeliveryReceipt: messageId=").append(a);
        ((StringBuffer) (obj1)).append(", messageObj is null");
        ULogUtility.a(((StringBuffer) (obj1)).toString(), "Receive");
        obj;
        JVM INSTR monitorexit ;
        return;
        MessageObj messageobj = (MessageObj)ChatDialogActivity.w(b).get(((MessageObj) (obj1)).b());
        if (messageobj != null)
        {
            break MISSING_BLOCK_LABEL_156;
        }
        obj1 = new StringBuffer();
        ((StringBuffer) (obj1)).append("[").append("ChatDialogActivity").append("]");
        ((StringBuffer) (obj1)).append(" onHandleReceiveDeliveryReceipt: readMessageObj is null");
        ULogUtility.a(((StringBuffer) (obj1)).toString(), "Receive");
        obj;
        JVM INSTR monitorexit ;
        return;
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        messageobj.a(((MessageObj) (obj1)).h());
        if (messageobj.j() == "3" || messageobj.j() == "2")
        {
            messageobj.c("0");
        }
        if (ChatDialogActivity.a(b) != null && ChatDialogActivity.a(b).b(messageobj))
        {
            e.a(ChatDialogActivity.a(b), new g());
        }
        obj;
        JVM INSTR monitorexit ;
        if (ChatDialogActivity.a(b) != null)
        {
            ChatDialogActivity.a(b).notifyDataSetChanged();
        }
        return;
    }

    (ChatDialogActivity chatdialogactivity, String s)
    {
        b = chatdialogactivity;
        a = s;
        super();
    }
}

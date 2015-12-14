// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.app.Activity;
import android.util.Log;
import com.cyberlink.you.chat.aa;
import com.cyberlink.you.database.MessageObj;
import java.util.Map;
import org.jivesoftware.smack.packet.StreamMgmt;

// Referenced classes of package com.cyberlink.you.activity:
//            ChatDialogActivity, e

class a
    implements aa
{

    final ChatDialogActivity a;

    public boolean a(StreamMgmt streammgmt)
    {
        String s;
        if (streammgmt != null)
        {
            if ((s = streammgmt.q()) != null)
            {
                Log.d("ChatDialogActivity", (new StringBuilder()).append("StreamMgmt: ").append(s).toString());
                String s1 = streammgmt.d();
                ChatDialogActivity.g(a).runOnUiThread(new Runnable(s, streammgmt, s1) {

                    final String a;
                    final StreamMgmt b;
                    final String c;
                    final ChatDialogActivity._cls11 d;

                    public void run()
                    {
                        Object obj = ChatDialogActivity.p(d.a);
                        obj;
                        JVM INSTR monitorenter ;
                        MessageObj messageobj;
                        Log.d("ChatDialogActivity", (new StringBuilder()).append("update StreamMgmt: ").append(a).toString());
                        messageobj = (MessageObj)ChatDialogActivity.w(d.a).get(a);
                        if (messageobj != null)
                        {
                            break MISSING_BLOCK_LABEL_71;
                        }
                        obj;
                        JVM INSTR monitorexit ;
                        return;
                        if (b.c() != null)
                        {
                            messageobj.a(b.c());
                        }
                        if (c == null || !c.equals("nack"))
                        {
                            break MISSING_BLOCK_LABEL_174;
                        }
                        messageobj.c("3");
                        Log.d("ChatDialogActivity", (new StringBuilder()).append("update StreamMgmt: STATUS_SEND_FAIL ").append(a).toString());
_L1:
                        obj;
                        JVM INSTR monitorexit ;
                        Exception exception;
                        if (ChatDialogActivity.a(d.a) != null)
                        {
                            ChatDialogActivity.a(d.a).notifyDataSetChanged();
                            return;
                        } else
                        {
                            Log.d("ChatDialogActivity", "mMessageAdapter != null");
                            return;
                        }
                        messageobj.c("0");
                        Log.d("ChatDialogActivity", (new StringBuilder()).append("update StreamMgmt: STATUS_NORMAL ").append(a).toString());
                        if (ChatDialogActivity.a(d.a) != null)
                        {
                            ChatDialogActivity.a(d.a).b(messageobj);
                        }
                        if (ChatDialogActivity.a(d.a) != null)
                        {
                            ChatDialogActivity.m(d.a);
                        }
                          goto _L1
                        exception;
                        obj;
                        JVM INSTR monitorexit ;
                        throw exception;
                    }

            
            {
                d = ChatDialogActivity._cls11.this;
                a = s;
                b = streammgmt;
                c = s1;
                super();
            }
                });
                return true;
            }
        }
        return false;
    }

    _cls1.c(ChatDialogActivity chatdialogactivity)
    {
        a = chatdialogactivity;
        super();
    }
}

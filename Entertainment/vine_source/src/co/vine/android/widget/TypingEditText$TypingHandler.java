// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package co.vine.android.widget:
//            TypingEditText

private class this._cls0 extends Handler
{

    public static final int TYPING = 1;
    final TypingEditText this$0;

    public void handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 1 1: default 24
    //                   1 25;
           goto _L1 _L2
_L1:
        return;
_L2:
        if (TypingEditText.access$300(TypingEditText.this) != null)
        {
            TypingEditText.access$300(TypingEditText.this).onTypingTimeout(TypingEditText.this);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public ()
    {
        this$0 = TypingEditText.this;
        super();
    }
}

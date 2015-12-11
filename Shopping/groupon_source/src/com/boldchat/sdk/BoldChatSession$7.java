// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk;

import android.content.DialogInterface;
import android.util.Log;

// Referenced classes of package com.boldchat.sdk:
//            BoldChatSession

class val.error
    implements Runnable
{

    final BoldChatSession this$0;
    final String val$error;

    public void run()
    {
        android.app.r r = new android.app.r(BoldChatSession.access$300(BoldChatSession.this));
        r.setMessage(val$error);
        r.setPositiveButton(ic_ok, new android.content.DialogInterface.OnClickListener() {

            final BoldChatSession._cls7 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                endChat(false);
                closeChat();
            }

            
            {
                this$1 = BoldChatSession._cls7.this;
                super();
            }
        });
        try
        {
            r.show();
            return;
        }
        catch (Exception exception)
        {
            Log.e("BOlD", (new StringBuilder()).append("Failed to show error: ").append(val$error).toString(), exception);
            try
            {
                closeChat();
                return;
            }
            catch (Exception exception1)
            {
                Log.e("BOlD", (new StringBuilder()).append("Failed to close the chat after error: ").append(val$error).toString(), exception);
            }
            return;
        }
    }

    _cls1.this._cls1()
    {
        this$0 = final_boldchatsession;
        val$error = String.this;
        super();
    }
}

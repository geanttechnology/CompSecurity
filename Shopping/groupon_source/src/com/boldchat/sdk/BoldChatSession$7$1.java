// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk;

import android.content.DialogInterface;
import android.util.Log;

// Referenced classes of package com.boldchat.sdk:
//            BoldChatSession

class this._cls1
    implements android.content.ickListener
{

    final eChat this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        endChat(false);
        closeChat();
    }

    l.error()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/boldchat/sdk/BoldChatSession$7

/* anonymous class */
    class BoldChatSession._cls7
        implements Runnable
    {

        final BoldChatSession this$0;
        final String val$error;

        public void run()
        {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(BoldChatSession.access$300(BoldChatSession.this));
            builder.setMessage(error);
            builder.setPositiveButton(R.string.api_generic_ok, new BoldChatSession._cls7._cls1());
            try
            {
                builder.show();
                return;
            }
            catch (Exception exception)
            {
                Log.e("BOlD", (new StringBuilder()).append("Failed to show error: ").append(error).toString(), exception);
                try
                {
                    closeChat();
                    return;
                }
                catch (Exception exception1)
                {
                    Log.e("BOlD", (new StringBuilder()).append("Failed to close the chat after error: ").append(error).toString(), exception);
                }
                return;
            }
        }

            
            {
                this$0 = final_boldchatsession;
                error = String.this;
                super();
            }
    }

}

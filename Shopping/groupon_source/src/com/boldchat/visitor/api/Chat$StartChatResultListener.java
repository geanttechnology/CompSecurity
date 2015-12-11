// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.visitor.api;

import com.boldchat.visitor.api.internal.ResultListener;
import com.boldchat.visitor.api.json.JSONObject;
import java.io.IOException;

// Referenced classes of package com.boldchat.visitor.api:
//            Chat, ChatStartListener, UnavailableReason, UnavailableForm

private class listener
    implements ResultListener
{

    private final ChatStartListener listener;
    final Chat this$0;

    public void failure(int i, String s, JSONObject jsonobject)
    {
        if (listener != null)
        {
            listener.onChatStartFailed(i, s);
        }
    }

    public void failure(IOException ioexception)
    {
        ioexception.printStackTrace();
        if (listener != null)
        {
            ChatStartListener chatstartlistener = listener;
            if (ioexception.getLocalizedMessage() != null)
            {
                ioexception = ioexception.getLocalizedMessage();
            } else
            {
                ioexception = ioexception.getMessage();
            }
            chatstartlistener.onChatStartFailed(-100, ioexception);
        }
    }

    public void success(JSONObject jsonobject)
    {
        Chat.access$1100(Chat.this, jsonobject);
        if (jsonobject.optString("UnavailableReason", null) != null)
        {
            if (listener != null)
            {
                UnavailableReason unavailablereason = UnavailableReason.getUnavailableReason(jsonobject.optString("UnavailableReason"));
                jsonobject = new UnavailableForm(jsonobject.optJSONObject("UnavailableForm"));
                listener.onChatUnavailable(unavailablereason, jsonobject);
            }
        } else
        {
            Chat.access$000(Chat.this);
            if (listener != null)
            {
                listener.onChatStarted();
                return;
            }
        }
    }

    public (ChatStartListener chatstartlistener)
    {
        this$0 = Chat.this;
        super();
        listener = chatstartlistener;
    }
}

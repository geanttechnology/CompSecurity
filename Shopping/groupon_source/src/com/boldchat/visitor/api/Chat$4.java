// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.visitor.api;

import com.boldchat.visitor.api.internal.ResultListener;
import com.boldchat.visitor.api.json.JSONObject;
import java.io.IOException;
import java.io.PrintStream;

// Referenced classes of package com.boldchat.visitor.api:
//            Chat, ChatFinishedListener, PostChat

class ishedListener
    implements ResultListener
{

    final Chat this$0;
    final ChatFinishedListener val$listener;

    public void failure(int i, String s, JSONObject jsonobject)
    {
        Chat.access$402(Chat.this, null);
        System.err.println((new StringBuilder()).append("Failed to finish chat: ").append(i).append(": ").append(s).toString());
        val$listener.onChatFinished(null);
    }

    public void failure(IOException ioexception)
    {
        Chat.access$402(Chat.this, null);
        ioexception.printStackTrace();
        val$listener.onChatFinished(null);
    }

    public void success(JSONObject jsonobject)
    {
        Object obj = null;
        Chat.access$402(Chat.this, null);
        jsonobject = jsonobject.optJSONObject("PostChat");
        if (jsonobject == null)
        {
            jsonobject = obj;
        } else
        {
            jsonobject = new PostChat(Chat.access$500(Chat.this), Chat.this, jsonobject);
        }
        val$listener.onChatFinished(jsonobject);
    }

    ishedListener()
    {
        this$0 = final_chat;
        val$listener = ChatFinishedListener.this;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import java.util.HashMap;

// Referenced classes of package co.vine.android:
//            VineWebSocketClient

private static class Builder extends HashMap
{
    public static class Builder
    {

        private boolean connected;
        private long lastMessageId;
        private boolean typing;

        public VineWebSocketClient.Conversation build()
        {
            return new VineWebSocketClient.Conversation(this, null);
        }

        public Builder setConnected()
        {
            connected = true;
            return this;
        }

        public Builder setLastMessageId(long l)
        {
            lastMessageId = l;
            return this;
        }

        public Builder setTyping(boolean flag)
        {
            typing = flag;
            return this;
        }




        public Builder()
        {
            connected = false;
            typing = false;
            lastMessageId = 0L;
        }
    }


    private Builder(Builder builder)
    {
        put("connected", Boolean.valueOf(builder.connected));
        put("typing", Boolean.valueOf(builder.typing));
        if (builder.lastMessageId > 0L)
        {
            put("last_message_id", Long.valueOf(builder.lastMessageId));
        }
    }

    Builder(Builder builder, Builder builder1)
    {
        this(builder);
    }
}

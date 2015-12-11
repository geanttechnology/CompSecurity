// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dcp.messaging;

import android.content.Intent;
import java.util.Arrays;

public class Message
{

    private final String mId;
    private final byte mPayload[];
    private final String mTopic;

    public Message(String s, String s1, byte abyte0[])
    {
        if (s == null || s.isEmpty())
        {
            throw new IllegalArgumentException("Id cannot be null or empty");
        }
        if (s1 == null || s1.isEmpty())
        {
            throw new IllegalArgumentException("Topic cannot be null or empty");
        }
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("Payload cannot be null");
        } else
        {
            mId = s;
            mTopic = s1;
            mPayload = Arrays.copyOf(abyte0, abyte0.length);
            return;
        }
    }

    public static Message constructMessageFromIntent(Intent intent)
    {
        String s = getIdFromIntent(intent);
        byte abyte0[] = getPayloadFromIntent(intent);
        intent = getTopicFromIntent(intent);
        if (s == null || abyte0 == null || intent == null)
        {
            return null;
        } else
        {
            return new Message(s, intent, abyte0);
        }
    }

    private static String getIdFromIntent(Intent intent)
    {
        return intent.getStringExtra("com.amazon.dcp.messaging.MESSAGE_ID");
    }

    private static byte[] getPayloadFromIntent(Intent intent)
    {
        return intent.getByteArrayExtra("com.amazon.dcp.messaging.MESSAGE_PAYLOAD");
    }

    private static String getTopicFromIntent(Intent intent)
    {
        intent = intent.getAction();
        if (intent == null || !intent.startsWith("com.amazon.dcp.messaging.topic."))
        {
            return null;
        } else
        {
            return intent.substring("com.amazon.dcp.messaging.topic.".length());
        }
    }

    public String getId()
    {
        return mId;
    }

    public byte[] getPayload()
    {
        return Arrays.copyOf(mPayload, mPayload.length);
    }

    public String getTopic()
    {
        return mTopic;
    }
}

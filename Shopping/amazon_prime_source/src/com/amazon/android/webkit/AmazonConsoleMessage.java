// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit;


public class AmazonConsoleMessage
{
    public static final class MessageLevel extends Enum
    {

        private static final MessageLevel $VALUES[];
        public static final MessageLevel DEBUG;
        public static final MessageLevel ERROR;
        public static final MessageLevel LOG;
        public static final MessageLevel TIP;
        public static final MessageLevel WARNING;

        public static MessageLevel valueOf(String s)
        {
            return (MessageLevel)Enum.valueOf(com/amazon/android/webkit/AmazonConsoleMessage$MessageLevel, s);
        }

        public static MessageLevel[] values()
        {
            return (MessageLevel[])$VALUES.clone();
        }

        static 
        {
            ERROR = new MessageLevel("ERROR", 0);
            DEBUG = new MessageLevel("DEBUG", 1);
            LOG = new MessageLevel("LOG", 2);
            TIP = new MessageLevel("TIP", 3);
            WARNING = new MessageLevel("WARNING", 4);
            $VALUES = (new MessageLevel[] {
                ERROR, DEBUG, LOG, TIP, WARNING
            });
        }

        private MessageLevel(String s, int i)
        {
            super(s, i);
        }
    }


    private final MessageLevel level;
    private final int lineNumber;
    private final String message;
    private final String sourceId;

    public AmazonConsoleMessage(String s, String s1, int i, MessageLevel messagelevel)
    {
        message = s;
        sourceId = s1;
        lineNumber = i;
        level = messagelevel;
    }

    public int lineNumber()
    {
        return lineNumber;
    }

    public String message()
    {
        return message;
    }

    public MessageLevel messageLevel()
    {
        return level;
    }

    public String sourceId()
    {
        return sourceId;
    }
}

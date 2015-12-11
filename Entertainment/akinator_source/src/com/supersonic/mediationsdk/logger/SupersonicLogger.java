// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonic.mediationsdk.logger;


public abstract class SupersonicLogger
{
    public class SupersonicLogLevel
    {

        public static final int ERROR = 3;
        public static final int INFO = 1;
        public static final int VERBOSE = 0;
        public static final int WARNING = 2;
        final SupersonicLogger this$0;

        public SupersonicLogLevel()
        {
            this$0 = SupersonicLogger.this;
            super();
        }
    }

    public static final class SupersonicTag extends Enum
    {

        private static final SupersonicTag $VALUES[];
        public static final SupersonicTag ADAPTER_API;
        public static final SupersonicTag ADAPTER_CALLBACK;
        public static final SupersonicTag API;
        public static final SupersonicTag CALLBACK;
        public static final SupersonicTag INTERNAL;
        public static final SupersonicTag NATIVE;
        public static final SupersonicTag NETWORK;

        public static SupersonicTag valueOf(String s)
        {
            return (SupersonicTag)Enum.valueOf(com/supersonic/mediationsdk/logger/SupersonicLogger$SupersonicTag, s);
        }

        public static SupersonicTag[] values()
        {
            return (SupersonicTag[])$VALUES.clone();
        }

        static 
        {
            API = new SupersonicTag("API", 0);
            ADAPTER_API = new SupersonicTag("ADAPTER_API", 1);
            CALLBACK = new SupersonicTag("CALLBACK", 2);
            ADAPTER_CALLBACK = new SupersonicTag("ADAPTER_CALLBACK", 3);
            NETWORK = new SupersonicTag("NETWORK", 4);
            INTERNAL = new SupersonicTag("INTERNAL", 5);
            NATIVE = new SupersonicTag("NATIVE", 6);
            $VALUES = (new SupersonicTag[] {
                API, ADAPTER_API, CALLBACK, ADAPTER_CALLBACK, NETWORK, INTERNAL, NATIVE
            });
        }

        private SupersonicTag(String s, int i)
        {
            super(s, i);
        }
    }


    protected int mDebugLevel;
    protected String mLoggerName;

    public SupersonicLogger(String s)
    {
        mLoggerName = s;
        mDebugLevel = 0;
    }

    public SupersonicLogger(String s, int i)
    {
        mLoggerName = s;
        mDebugLevel = i;
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj != null)
        {
            flag = flag1;
            if (obj instanceof SupersonicLogger)
            {
                obj = (SupersonicLogger)obj;
                flag = flag1;
                if (mLoggerName != null)
                {
                    flag = mLoggerName.equals(((SupersonicLogger) (obj)).mLoggerName);
                }
            }
        }
        return flag;
    }

    public int getDebugLevel()
    {
        return mDebugLevel;
    }

    public String getLoggerName()
    {
        return mLoggerName;
    }

    public abstract void log(SupersonicTag supersonictag, String s, int i);

    public abstract void logException(SupersonicTag supersonictag, String s, Throwable throwable);

    public void setDebugLevel(int i)
    {
        mDebugLevel = i;
    }
}

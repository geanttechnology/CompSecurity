// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.data;

import com.gotv.crackle.Application;

public abstract class DataRequest
{
    public static interface DataRequestListener
    {

        public abstract void onDataFailed(String s, String s1);

        public abstract void onDataSuccess(String s);
    }

    public static final class RequestState extends Enum
    {

        private static final RequestState $VALUES[];
        public static final RequestState COMPLETE;
        public static final RequestState FAILED;
        public static final RequestState IDLE;
        public static final RequestState RUNNING;

        public static RequestState valueOf(String s)
        {
            return (RequestState)Enum.valueOf(com/gotv/crackle/data/DataRequest$RequestState, s);
        }

        public static RequestState[] values()
        {
            return (RequestState[])$VALUES.clone();
        }

        static 
        {
            IDLE = new RequestState("IDLE", 0);
            RUNNING = new RequestState("RUNNING", 1);
            COMPLETE = new RequestState("COMPLETE", 2);
            FAILED = new RequestState("FAILED", 3);
            $VALUES = (new RequestState[] {
                IDLE, RUNNING, COMPLETE, FAILED
            });
        }

        private RequestState(String s, int i)
        {
            super(s, i);
        }
    }


    protected DataRequestListener mDataRequestListener;
    protected RequestState mState;

    public DataRequest()
    {
    }

    protected static String getNetworkErrorString(int i)
    {
        String s = Application.getInstance().getString(0x7f0b013e);
        return (new StringBuilder()).append(s).append("\n").append(i + 2).toString();
    }

    protected static String getParseErrorString(int i)
    {
        String s = Application.getInstance().getString(0x7f0b013d);
        return (new StringBuilder()).append(s).append("\n").append(i + 1).toString();
    }

    protected static String getURIExceptionString(int i)
    {
        String s = Application.getInstance().getString(0x7f0b013f);
        return (new StringBuilder()).append(s).append("\n").append(i + 3).toString();
    }

    public RequestState getRequestState()
    {
        return mState;
    }
}

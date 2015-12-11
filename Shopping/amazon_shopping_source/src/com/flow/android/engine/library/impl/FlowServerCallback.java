// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flow.android.engine.library.impl;

import android.util.Log;
import com.a9.vs.mobile.library.impl.jni.MapOfStringToString;
import com.a9.vs.mobile.library.impl.jni.ServerDelegate;
import com.a9.vs.mobile.library.impl.jni.ServerRequest;
import com.a9.vs.mobile.library.impl.jni.ServerResponse;
import com.a9.vs.mobile.library.impl.jni.VectorOfString;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.flow.android.engine.library.impl:
//            FlowStateEngineImpl

public class FlowServerCallback extends ServerDelegate
{
    private static final class FlowServerState extends Enum
    {

        private static final FlowServerState $VALUES[];
        public static final FlowServerState FLOW_ENGINE_SHUTDOWN;
        public static final FlowServerState FLOW_SERVER_IDLE;
        public static final FlowServerState FLOW_SERVER_RESPONSE_RECEIVED;
        public static final FlowServerState FLOW_SERVER_WAITING_RESPONSE;

        public static FlowServerState valueOf(String s)
        {
            return (FlowServerState)Enum.valueOf(com/flow/android/engine/library/impl/FlowServerCallback$FlowServerState, s);
        }

        public static FlowServerState[] values()
        {
            return (FlowServerState[])$VALUES.clone();
        }

        static 
        {
            FLOW_SERVER_IDLE = new FlowServerState("FLOW_SERVER_IDLE", 0);
            FLOW_SERVER_WAITING_RESPONSE = new FlowServerState("FLOW_SERVER_WAITING_RESPONSE", 1);
            FLOW_SERVER_RESPONSE_RECEIVED = new FlowServerState("FLOW_SERVER_RESPONSE_RECEIVED", 2);
            FLOW_ENGINE_SHUTDOWN = new FlowServerState("FLOW_ENGINE_SHUTDOWN", 3);
            $VALUES = (new FlowServerState[] {
                FLOW_SERVER_IDLE, FLOW_SERVER_WAITING_RESPONSE, FLOW_SERVER_RESPONSE_RECEIVED, FLOW_ENGINE_SHUTDOWN
            });
        }

        private FlowServerState(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class Mode extends Enum
    {

        private static final Mode $VALUES[];
        public static final Mode IMAGEMATCH;
        public static final Mode TEXT;

        public static Mode valueOf(String s)
        {
            return (Mode)Enum.valueOf(com/flow/android/engine/library/impl/FlowServerCallback$Mode, s);
        }

        public static Mode[] values()
        {
            return (Mode[])$VALUES.clone();
        }

        static 
        {
            IMAGEMATCH = new Mode("IMAGEMATCH", 0);
            TEXT = new Mode("TEXT", 1);
            $VALUES = (new Mode[] {
                IMAGEMATCH, TEXT
            });
        }

        private Mode(String s, int i)
        {
            super(s, i);
        }
    }


    private FlowStateEngineImpl mImpl;
    private Mode mMode;
    private String mServerResponse;
    private com.a9.vs.mobile.library.impl.jni.ServerResponse.Type mServerResponseType;
    private FlowServerState mServerState;

    public FlowServerCallback(FlowStateEngineImpl flowstateengineimpl, Mode mode)
    {
        mImpl = null;
        mImpl = flowstateengineimpl;
        mMode = mode;
        resetServerState();
    }

    public void gotServerResponse(String s, com.a9.vs.mobile.library.impl.jni.ServerResponse.Type type, double d)
    {
        this;
        JVM INSTR monitorenter ;
        if (mServerState == FlowServerState.FLOW_SERVER_WAITING_RESPONSE)
        {
            mServerResponse = s;
            mServerResponseType = type;
            s = new ServerResponse();
            s.setResponseStr(mServerResponse);
            s.setResponseType(mServerResponseType);
            s.setRoundtripTime(d);
            pushServerResponse(s);
            resetServerState();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void resetServerState()
    {
        this;
        JVM INSTR monitorenter ;
        mServerState = FlowServerState.FLOW_SERVER_IDLE;
        mServerResponse = null;
        mServerResponseType = null;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected boolean sendServerRequestImpl(ServerRequest serverrequest)
    {
        if (mServerState != FlowServerState.FLOW_SERVER_IDLE) goto _L2; else goto _L1
_L1:
        HashMap hashmap;
        HashMap hashmap1;
        boolean flag;
        mServerState = FlowServerState.FLOW_SERVER_WAITING_RESPONSE;
        flag = false;
        hashmap = new HashMap();
        hashmap1 = new HashMap();
        static class _cls1
        {

            static final int $SwitchMap$com$flow$android$engine$library$impl$FlowServerCallback$Mode[];

            static 
            {
                $SwitchMap$com$flow$android$engine$library$impl$FlowServerCallback$Mode = new int[Mode.values().length];
                try
                {
                    $SwitchMap$com$flow$android$engine$library$impl$FlowServerCallback$Mode[Mode.IMAGEMATCH.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$flow$android$engine$library$impl$FlowServerCallback$Mode[Mode.TEXT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.flow.android.engine.library.impl.FlowServerCallback.Mode[mMode.ordinal()];
        JVM INSTR tableswitch 1 2: default 68
    //                   1 88
    //                   2 228;
           goto _L3 _L4 _L5
_L3:
        Log.e("FlowServerCallback", "Error : Unsupported mode found.");
_L6:
        if (!flag)
        {
            resetServerState();
        }
        return flag;
_L4:
        VectorOfString vectorofstring = MapOfStringToString.getKeys(serverrequest.getParams());
        for (int i = 0; (long)i < vectorofstring.size(); i++)
        {
            hashmap.put(vectorofstring.get(i), serverrequest.getParams().get(vectorofstring.get(i)));
        }

        vectorofstring = MapOfStringToString.getKeys(serverrequest.getMetadata());
        for (int j = 0; (long)j < vectorofstring.size(); j++)
        {
            hashmap1.put(vectorofstring.get(j), serverrequest.getMetadata().get(vectorofstring.get(j)));
        }

        flag = mImpl.doImageMatch(serverrequest.getData(), hashmap, hashmap1);
        continue; /* Loop/switch isn't completed */
_L5:
        VectorOfString vectorofstring1 = MapOfStringToString.getKeys(serverrequest.getParams());
        for (int k = 0; (long)k < vectorofstring1.size(); k++)
        {
            hashmap.put(vectorofstring1.get(k), serverrequest.getParams().get(vectorofstring1.get(k)));
        }

        vectorofstring1 = MapOfStringToString.getKeys(serverrequest.getMetadata());
        for (int l = 0; (long)l < vectorofstring1.size(); l++)
        {
            hashmap1.put(vectorofstring1.get(l), serverrequest.getMetadata().get(vectorofstring1.get(l)));
        }

        flag = mImpl.doTextMatch(serverrequest.getData(), hashmap, hashmap1);
        if (true) goto _L6; else goto _L2
_L2:
        return false;
    }

    public void shutdownServerState()
    {
        this;
        JVM INSTR monitorenter ;
        mServerState = FlowServerState.FLOW_ENGINE_SHUTDOWN;
        mServerResponse = null;
        mServerResponseType = null;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }
}

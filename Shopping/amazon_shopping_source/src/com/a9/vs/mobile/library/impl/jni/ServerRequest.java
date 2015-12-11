// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            A9VSMobileJNI, ByteArray, MapOfStringToString, ServerResponseHandler

public class ServerRequest
{

    protected boolean swigCMemOwn;
    private long swigCPtr;

    public ServerRequest()
    {
        this(A9VSMobileJNI.new_ServerRequest__SWIG_0(), true);
    }

    protected ServerRequest(long l, boolean flag)
    {
        swigCMemOwn = flag;
        swigCPtr = l;
    }

    public ServerRequest(ByteArray bytearray, String s)
    {
        this(A9VSMobileJNI.new_ServerRequest__SWIG_3(ByteArray.getCPtr(bytearray), bytearray, s), true);
    }

    public ServerRequest(ByteArray bytearray, String s, MapOfStringToString mapofstringtostring)
    {
        this(A9VSMobileJNI.new_ServerRequest__SWIG_2(ByteArray.getCPtr(bytearray), bytearray, s, MapOfStringToString.getCPtr(mapofstringtostring), mapofstringtostring), true);
    }

    public ServerRequest(ByteArray bytearray, String s, MapOfStringToString mapofstringtostring, MapOfStringToString mapofstringtostring1)
    {
        this(A9VSMobileJNI.new_ServerRequest__SWIG_1(ByteArray.getCPtr(bytearray), bytearray, s, MapOfStringToString.getCPtr(mapofstringtostring), mapofstringtostring, MapOfStringToString.getCPtr(mapofstringtostring1), mapofstringtostring1), true);
    }

    protected static long getCPtr(ServerRequest serverrequest)
    {
        if (serverrequest == null)
        {
            return 0L;
        } else
        {
            return serverrequest.swigCPtr;
        }
    }

    public void clear()
    {
        A9VSMobileJNI.ServerRequest_clear(swigCPtr, this);
    }

    public void delete()
    {
        this;
        JVM INSTR monitorenter ;
        if (swigCPtr != 0L)
        {
            if (swigCMemOwn)
            {
                swigCMemOwn = false;
                A9VSMobileJNI.delete_ServerRequest(swigCPtr);
            }
            swigCPtr = 0L;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected void finalize()
    {
        delete();
    }

    public ByteArray getData()
    {
        long l = A9VSMobileJNI.ServerRequest_data_get(swigCPtr, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new ByteArray(l, false);
        }
    }

    public String getId()
    {
        return A9VSMobileJNI.ServerRequest_id_get(swigCPtr, this);
    }

    public MapOfStringToString getMetadata()
    {
        long l = A9VSMobileJNI.ServerRequest_metadata_get(swigCPtr, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new MapOfStringToString(l, false);
        }
    }

    public MapOfStringToString getParams()
    {
        long l = A9VSMobileJNI.ServerRequest_params_get(swigCPtr, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new MapOfStringToString(l, false);
        }
    }

    public ServerResponseHandler getResponseHandler()
    {
        long l = A9VSMobileJNI.ServerRequest_responseHandler_get(swigCPtr, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new ServerResponseHandler(l, false);
        }
    }

    public void setData(ByteArray bytearray)
    {
        A9VSMobileJNI.ServerRequest_data_set(swigCPtr, this, ByteArray.getCPtr(bytearray), bytearray);
    }

    public void setId(String s)
    {
        A9VSMobileJNI.ServerRequest_id_set(swigCPtr, this, s);
    }

    public void setMetadata(MapOfStringToString mapofstringtostring)
    {
        A9VSMobileJNI.ServerRequest_metadata_set(swigCPtr, this, MapOfStringToString.getCPtr(mapofstringtostring), mapofstringtostring);
    }

    public void setParams(MapOfStringToString mapofstringtostring)
    {
        A9VSMobileJNI.ServerRequest_params_set(swigCPtr, this, MapOfStringToString.getCPtr(mapofstringtostring), mapofstringtostring);
    }

    public void setResponseHandler(ServerResponseHandler serverresponsehandler)
    {
        A9VSMobileJNI.ServerRequest_responseHandler_set(swigCPtr, this, ServerResponseHandler.getCPtr(serverresponsehandler), serverresponsehandler);
    }
}

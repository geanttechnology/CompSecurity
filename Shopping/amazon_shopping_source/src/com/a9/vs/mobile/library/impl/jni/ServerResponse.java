// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            A9VSMobileJNI

public class ServerResponse
{
    public static final class Type extends Enum
    {

        private static final Type $VALUES[];
        public static final Type JSON_IMGMATCH;
        public static final Type JSON_LOGO;
        public static final Type JSON_TERS;
        public static final Type JSON_TERS_TR;
        public static final Type JSON_TR;
        public static final Type JSON_VSEARCH;
        private final int swigValue;

        public static Type swigToEnum(int i)
        {
            Type atype[] = (Type[])com/a9/vs/mobile/library/impl/jni/ServerResponse$Type.getEnumConstants();
            if (i >= atype.length || i < 0 || atype[i].swigValue != i) goto _L2; else goto _L1
_L1:
            Type type = atype[i];
_L4:
            return type;
_L2:
            int k = atype.length;
            int j = 0;
label0:
            do
            {
label1:
                {
                    if (j >= k)
                    {
                        break label1;
                    }
                    Type type1 = atype[j];
                    type = type1;
                    if (type1.swigValue == i)
                    {
                        break label0;
                    }
                    j++;
                }
            } while (true);
            if (true) goto _L4; else goto _L3
_L3:
            throw new IllegalArgumentException((new StringBuilder()).append("No enum ").append(com/a9/vs/mobile/library/impl/jni/ServerResponse$Type).append(" with value ").append(i).toString());
        }

        public static Type valueOf(String s)
        {
            return (Type)Enum.valueOf(com/a9/vs/mobile/library/impl/jni/ServerResponse$Type, s);
        }

        public static Type[] values()
        {
            return (Type[])$VALUES.clone();
        }

        public final int swigValue()
        {
            return swigValue;
        }

        static 
        {
            JSON_TERS = new Type("JSON_TERS", 0);
            JSON_TR = new Type("JSON_TR", 1);
            JSON_TERS_TR = new Type("JSON_TERS_TR", 2);
            JSON_IMGMATCH = new Type("JSON_IMGMATCH", 3);
            JSON_LOGO = new Type("JSON_LOGO", 4);
            JSON_VSEARCH = new Type("JSON_VSEARCH", 5);
            $VALUES = (new Type[] {
                JSON_TERS, JSON_TR, JSON_TERS_TR, JSON_IMGMATCH, JSON_LOGO, JSON_VSEARCH
            });
        }

        private Type(String s, int i)
        {
            super(s, i);
            swigValue = int i = 
// JavaClassFileOutputException: get_constant: invalid tag

        private Type(String s, int i, int j)
        {
            Enum(s, i);
            swigValue = j;
            SwigNext.next = j + 1;
        }

        private Type(String s, int i, Type type)
        {
            Enum(s, i);
            swigValue = type.swigValue;
            SwigNext.next = swigValue + 1;
        }
    }

    private static class Type.SwigNext
    {

        private static int next = 0;



/*
        static int access$002(int i)
        {
            next = i;
            return i;
        }

*/


/*
        static int access$008()
        {
            int i = next;
            next = i + 1;
            return i;
        }

*/

        private Type.SwigNext()
        {
        }
    }


    protected boolean swigCMemOwn;
    private long swigCPtr;

    public ServerResponse()
    {
        ServerResponse(A9VSMobileJNI.new_ServerResponse(), true);
    }

    protected ServerResponse(long l, boolean flag)
    {
        swigCMemOwn = flag;
        swigCPtr = l;
    }

    protected static long getCPtr(ServerResponse serverresponse)
    {
        if (serverresponse == null)
        {
            return 0L;
        } else
        {
            return serverresponse.swigCPtr;
        }
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
                A9VSMobileJNI.delete_ServerResponse(swigCPtr);
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

    public boolean getCompressed()
    {
        return A9VSMobileJNI.ServerResponse_compressed_get(swigCPtr, this);
    }

    public String getId()
    {
        return A9VSMobileJNI.ServerResponse_id_get(swigCPtr, this);
    }

    public String getResponseStr()
    {
        return A9VSMobileJNI.ServerResponse_responseStr_get(swigCPtr, this);
    }

    public Type getResponseType()
    {
        return Type.swigToEnum(A9VSMobileJNI.ServerResponse_responseType_get(swigCPtr, this));
    }

    public double getRoundtripTime()
    {
        return A9VSMobileJNI.ServerResponse_roundtripTime_get(swigCPtr, this);
    }

    public void setCompressed(boolean flag)
    {
        A9VSMobileJNI.ServerResponse_compressed_set(swigCPtr, this, flag);
    }

    public void setId(String s)
    {
        A9VSMobileJNI.ServerResponse_id_set(swigCPtr, this, s);
    }

    public void setResponseStr(String s)
    {
        A9VSMobileJNI.ServerResponse_responseStr_set(swigCPtr, this, s);
    }

    public void setResponseType(Type type)
    {
        A9VSMobileJNI.ServerResponse_responseType_set(swigCPtr, this, type.swigValue());
    }

    public void setRoundtripTime(double d)
    {
        A9VSMobileJNI.ServerResponse_roundtripTime_set(swigCPtr, this, d);
    }
}

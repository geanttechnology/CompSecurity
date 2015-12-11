// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager.protobuf;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Referenced classes of package com.google.tagmanager.protobuf:
//            GeneratedMessageLite, MessageLite, InvalidProtocolBufferException

static final class asBytes
    implements Serializable
{

    private static final long serialVersionUID = 0L;
    private byte asBytes[];
    private String messageClassName;

    protected Object readResolve()
        throws ObjectStreamException
    {
        Object obj;
        try
        {
            obj = (asBytes)Class.forName(messageClassName).getMethod("newBuilder", new Class[0]).invoke(null, new Object[0]);
            ((messageClassName) (obj)).messageClassName(asBytes);
            obj = ((asBytes) (obj)).asBytes();
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            throw new RuntimeException("Unable to find proto buffer class", classnotfoundexception);
        }
        catch (NoSuchMethodException nosuchmethodexception)
        {
            throw new RuntimeException("Unable to find newBuilder method", nosuchmethodexception);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            throw new RuntimeException("Unable to call newBuilder method", illegalaccessexception);
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            throw new RuntimeException("Error calling newBuilder", invocationtargetexception.getCause());
        }
        catch (InvalidProtocolBufferException invalidprotocolbufferexception)
        {
            throw new RuntimeException("Unable to understand proto buffer", invalidprotocolbufferexception);
        }
        return obj;
    }

    (MessageLite messagelite)
    {
        messageClassName = messagelite.getClass().getName();
        asBytes = messagelite.toByteArray();
    }
}

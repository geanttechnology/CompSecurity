// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager.protobuf;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Referenced classes of package com.google.tagmanager.protobuf:
//            GeneratedMutableMessageLite, MutableMessageLite, CodedInputStream

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
            obj = (MutableMessageLite)Class.forName(messageClassName).getMethod("newMessage", new Class[0]).invoke(null, new Object[0]);
            if (!((MutableMessageLite) (obj)).mergeFrom(CodedInputStream.newInstance(asBytes)))
            {
                throw new RuntimeException("Unable to understand proto buffer");
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeException("Unable to find proto buffer class", ((Throwable) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeException("Unable to find newMessage method", ((Throwable) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeException("Unable to call newMessage method", ((Throwable) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeException("Error calling newMessage", ((InvocationTargetException) (obj)).getCause());
        }
        return obj;
    }

    (MutableMessageLite mutablemessagelite)
    {
        messageClassName = mutablemessagelite.getClass().getName();
        asBytes = mutablemessagelite.toByteArray();
    }
}

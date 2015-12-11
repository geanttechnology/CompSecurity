// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.msgpack.object;

import java.io.IOException;
import java.util.Arrays;
import org.msgpack.MessagePackObject;
import org.msgpack.Packer;

public class ArrayType extends MessagePackObject
{

    private MessagePackObject array[];

    ArrayType(MessagePackObject amessagepackobject[])
    {
        array = amessagepackobject;
    }

    public static ArrayType create(MessagePackObject amessagepackobject[])
    {
        return new ArrayType(amessagepackobject);
    }

    public Object clone()
    {
        MessagePackObject amessagepackobject[] = new MessagePackObject[array.length];
        for (int i = 0; i < array.length; i++)
        {
            amessagepackobject[i] = (MessagePackObject)array[i].clone();
        }

        return amessagepackobject;
    }

    public boolean equals(Object obj)
    {
        if (obj.getClass() != getClass())
        {
            return false;
        } else
        {
            return Arrays.equals(((ArrayType)obj).array, array);
        }
    }

    public int hashCode()
    {
        return array.hashCode();
    }

    public void messagePack(Packer packer)
        throws IOException
    {
        packer.packArray(array.length);
        for (int i = 0; i < array.length; i++)
        {
            array[i].messagePack(packer);
        }

    }
}

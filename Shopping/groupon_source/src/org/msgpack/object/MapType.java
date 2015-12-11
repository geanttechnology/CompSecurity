// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.msgpack.object;

import java.io.IOException;
import java.util.Arrays;
import org.msgpack.MessagePackObject;
import org.msgpack.Packer;

public class MapType extends MessagePackObject
{

    private MessagePackObject map[];

    MapType(MessagePackObject amessagepackobject[])
    {
        map = amessagepackobject;
    }

    public static MapType create(MessagePackObject amessagepackobject[])
    {
        return new MapType(amessagepackobject);
    }

    public Object clone()
    {
        MessagePackObject amessagepackobject[] = new MessagePackObject[map.length];
        for (int i = 0; i < map.length; i++)
        {
            amessagepackobject[i] = (MessagePackObject)map[i].clone();
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
            return Arrays.equals(((MapType)obj).map, map);
        }
    }

    public int hashCode()
    {
        return map.hashCode();
    }

    public void messagePack(Packer packer)
        throws IOException
    {
        packer.packMap(map.length / 2);
        for (int i = 0; i < map.length; i++)
        {
            map[i].messagePack(packer);
        }

    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.events;

import com.groupon.tracking.mobile.Util;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import org.msgpack.Packer;

public class MobileEvent
{

    public long eventTime;
    public String eventType;
    public Map extras;

    public MobileEvent()
    {
        eventType = "";
        eventTime = Util.timestampForNow();
        extras = Collections.emptyMap();
    }

    public MobileEvent(String s)
    {
        eventType = "";
        eventTime = Util.timestampForNow();
        extras = Collections.emptyMap();
        eventType = s;
    }

    public void addToExtras(String s, String s1)
    {
        if (extras == Collections.EMPTY_MAP)
        {
            extras = new TreeMap();
        }
        extras.put(s, s1);
    }

    public Map getExtras()
    {
        return extras;
    }

    public void pack(int i, Packer packer)
        throws IOException
    {
        packer.packArray(i);
        packer.pack(eventType);
        packer.pack(eventTime);
        packer.pack(extras);
    }

    public final void pack(Packer packer)
        throws IOException
    {
        pack(-1, packer);
    }

    public final byte[] pack()
        throws IOException
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        pack(new Packer(bytearrayoutputstream));
        return bytearrayoutputstream.toByteArray();
    }

    public void reset()
    {
        eventType = "";
        eventTime = Util.timestampForNow();
        if (extras != Collections.EMPTY_MAP)
        {
            extras.clear();
        }
    }
}

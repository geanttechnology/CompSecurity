// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.explore;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// Referenced classes of package com.shazam.server.response.explore:
//            Level

public class Location
    implements Serializable
{

    public long id;
    public double lat;
    public Level level;
    public double lon;
    public String name;
    public long population;

    private Location(long l, Level level1, String s, long l1, double d, double d1)
    {
        id = l;
        level = level1;
        name = s;
        population = l1;
        lon = d;
        lat = d1;
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        id = objectinputstream.readLong();
        level = (Level)objectinputstream.readObject();
        char ac[] = new char[objectinputstream.readInt()];
        for (int i = 0; i < ac.length; i++)
        {
            ac[i] = objectinputstream.readChar();
        }

        name = new String(ac);
        population = objectinputstream.readLong();
        lon = objectinputstream.readDouble();
        lat = objectinputstream.readDouble();
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
    {
        objectoutputstream.writeLong(id);
        objectoutputstream.writeObject(level);
        objectoutputstream.writeInt(name.length());
        char ac[] = name.toCharArray();
        int j = ac.length;
        for (int i = 0; i < j; i++)
        {
            objectoutputstream.writeChar(ac[i]);
        }

        objectoutputstream.writeLong(population);
        objectoutputstream.writeDouble(lon);
        objectoutputstream.writeDouble(lat);
    }
}

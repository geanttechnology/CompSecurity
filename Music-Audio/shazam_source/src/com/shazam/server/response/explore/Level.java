// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.explore;

import com.google.b.j;
import com.google.b.k;
import com.google.b.l;
import com.google.b.r;
import com.google.b.s;
import com.google.b.t;
import java.lang.reflect.Type;
import java.util.Locale;

public final class Level extends Enum
{
    public static class Deserializer
        implements k
    {

        public Level deserialize(l l1, Type type, j j)
        {
            return Level.fromString(l1.h().b());
        }

        public volatile Object deserialize(l l1, Type type, j j)
        {
            return deserialize(l1, type, j);
        }

        public Deserializer()
        {
        }
    }

    public static class Serializer
        implements t
    {

        public l serialize(Level level, Type type, s s)
        {
            return new r(level.getLevel());
        }

        public volatile l serialize(Object obj, Type type, s s)
        {
            return serialize((Level)obj, type, s);
        }

        public Serializer()
        {
        }
    }


    private static final Level $VALUES[];
    public static final Level CITY;
    public static final Level CONTINENT;
    public static final Level COUNTRY;

    private Level(String s, int i)
    {
        super(s, i);
    }

    public static Level fromString(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        Level level = null;
_L4:
        return level;
_L2:
        Level alevel[] = values();
        int j = alevel.length;
        int i = 0;
label0:
        do
        {
label1:
            {
                if (i >= j)
                {
                    break label1;
                }
                Level level1 = alevel[i];
                level = level1;
                if (s.equalsIgnoreCase(level1.name()))
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        throw new IllegalArgumentException((new StringBuilder("Could not mach string '")).append(s).append("' to any Level").toString());
    }

    public static Level valueOf(String s)
    {
        return (Level)Enum.valueOf(com/shazam/server/response/explore/Level, s);
    }

    public static Level[] values()
    {
        return (Level[])$VALUES.clone();
    }

    public final String getLevel()
    {
        return name().toLowerCase(Locale.US);
    }

    public final String toString()
    {
        return name().toLowerCase(Locale.US);
    }

    static 
    {
        CITY = new Level("CITY", 0);
        COUNTRY = new Level("COUNTRY", 1);
        CONTINENT = new Level("CONTINENT", 2);
        $VALUES = (new Level[] {
            CITY, COUNTRY, CONTINENT
        });
    }
}

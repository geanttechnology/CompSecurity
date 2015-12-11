// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

// Referenced classes of package org.apache.log4j:
//            Priority

public class Level extends Priority
    implements Serializable
{

    public static final Level ALL = new Level(0x80000000, "ALL", 7);
    public static final Level DEBUG = new Level(10000, "DEBUG", 7);
    public static final Level ERROR = new Level(40000, "ERROR", 3);
    public static final Level FATAL = new Level(50000, "FATAL", 0);
    public static final Level INFO = new Level(20000, "INFO", 6);
    public static final Level OFF = new Level(0x7fffffff, "OFF", 0);
    public static final Level TRACE = new Level(5000, "TRACE", 7);
    public static final Level WARN = new Level(30000, "WARN", 4);
    static Class class$org$apache$log4j$Level;

    protected Level(int i, String s, int j)
    {
        super(i, s, j);
    }

    static Class _mthclass$(String s)
    {
        try
        {
            s = Class.forName(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new NoClassDefFoundError(s.getMessage());
        }
        return s;
    }

    private void readObject(ObjectInputStream objectinputstream)
        throws IOException, ClassNotFoundException
    {
        objectinputstream.defaultReadObject();
        super.level = objectinputstream.readInt();
        super.syslogEquivalent = objectinputstream.readInt();
        super.levelStr = objectinputstream.readUTF();
        if (super.levelStr == null)
        {
            super.levelStr = "";
        }
    }

    private Object readResolve()
        throws ObjectStreamException
    {
        Class class2 = getClass();
        Class class1;
        Level level;
        if (class$org$apache$log4j$Level == null)
        {
            class1 = _mthclass$("org.apache.log4j.Level");
            class$org$apache$log4j$Level = class1;
        } else
        {
            class1 = class$org$apache$log4j$Level;
        }
        level = this;
        if (class2 == class1)
        {
            level = toLevel(super.level);
        }
        return level;
    }

    public static Level toLevel(int i)
    {
        return toLevel(i, DEBUG);
    }

    public static Level toLevel(int i, Level level)
    {
        switch (i)
        {
        default:
            return level;

        case -2147483648: 
            return ALL;

        case 10000: 
            return DEBUG;

        case 20000: 
            return INFO;

        case 30000: 
            return WARN;

        case 40000: 
            return ERROR;

        case 50000: 
            return FATAL;

        case 2147483647: 
            return OFF;

        case 5000: 
            return TRACE;
        }
    }

    public static Level toLevel(String s, Level level)
    {
        if (s != null)
        {
            s = s.toUpperCase();
            if (s.equals("ALL"))
            {
                return ALL;
            }
            if (s.equals("DEBUG"))
            {
                return DEBUG;
            }
            if (s.equals("INFO"))
            {
                return INFO;
            }
            if (s.equals("WARN"))
            {
                return WARN;
            }
            if (s.equals("ERROR"))
            {
                return ERROR;
            }
            if (s.equals("FATAL"))
            {
                return FATAL;
            }
            if (s.equals("OFF"))
            {
                return OFF;
            }
            if (s.equals("TRACE"))
            {
                return TRACE;
            }
            if (s.equals("\u0130NFO"))
            {
                return INFO;
            }
        }
        return level;
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
        throws IOException
    {
        objectoutputstream.defaultWriteObject();
        objectoutputstream.writeInt(super.level);
        objectoutputstream.writeInt(super.syslogEquivalent);
        objectoutputstream.writeUTF(super.levelStr);
    }

}

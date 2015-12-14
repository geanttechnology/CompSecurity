// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.model;

import java.io.Serializable;

public class ObjectID
    implements Serializable, Comparable
{

    private static final ObjectID ALL_PHOTOS_OBJECT_ID = new ObjectID(-4L, -4L);
    private static final ObjectID CAMERA_ROLL_TAG_ID = new ObjectID(-2L, -2L);
    private static final ObjectID FAILED_TO_UPLOAD_ID = new ObjectID(-3L, -3L);
    private static final ObjectID MISSING_OBJECT = new ObjectID(-1L, -1L);
    private static final ObjectID ROOT_OBJECT = new ObjectID(0L, 0L);
    private String asString;
    private final long leastSignificantBits;
    private final long mostSignificantBits;

    public ObjectID(long l, long l1)
    {
        asString = null;
        mostSignificantBits = l;
        leastSignificantBits = l1;
    }

    public static ObjectID getCameraRollTagId()
    {
        return CAMERA_ROLL_TAG_ID;
    }

    public static ObjectID getRoot()
    {
        return ROOT_OBJECT;
    }

    public static boolean objectIdEqual(ObjectID objectid, ObjectID objectid1)
    {
        return objectid == objectid1 || objectid != null && objectid.equals(objectid1);
    }

    public static ObjectID parseString(String s)
    {
        if (s == null || s.isEmpty())
        {
            throw new RuntimeException((new StringBuilder()).append("Failed to parse ObjectID ").append(s).toString());
        } else
        {
            return new ObjectID(Long.parseLong(s.substring(0, 8), 16) << 32 | Long.parseLong(s.substring(9, 13), 16) << 16 | Long.parseLong(s.substring(14, 18), 16), Long.parseLong(s.substring(19, 23), 16) << 48 | Long.parseLong(s.substring(24, 36), 16));
        }
    }

    public static String toString(long l, long l1)
    {
        StringBuilder stringbuilder = new StringBuilder(36);
        String s = Long.toHexString(l);
        if (s.length() < 16)
        {
            int k = s.length();
            for (int i = 0; i < 16 - k; i++)
            {
                stringbuilder.append('0');
            }

        }
        stringbuilder.append(s);
        stringbuilder.insert(8, '-');
        stringbuilder.insert(13, '-');
        stringbuilder.append('-');
        s = Long.toHexString(l1);
        if (s.length() < 16)
        {
            int i1 = s.length();
            for (int j = 0; j < 16 - i1; j++)
            {
                stringbuilder.append('0');
            }

        }
        stringbuilder.append(s);
        stringbuilder.insert(23, '-');
        return stringbuilder.toString();
    }

    public int compareTo(ObjectID objectid)
    {
        long l;
        long l1;
label0:
        {
            l = mostSignificantBits;
            l1 = objectid.mostSignificantBits;
            byte byte0;
            byte byte1;
            if (l < l1)
            {
                byte0 = -1;
            } else
            if (l == l1)
            {
                byte0 = 0;
            } else
            {
                byte0 = 1;
            }
            byte1 = byte0;
            if (byte0 == 0)
            {
                l = leastSignificantBits;
                l1 = objectid.leastSignificantBits;
                if (l >= l1)
                {
                    break label0;
                }
                byte1 = -1;
            }
            return byte1;
        }
        return l != l1 ? 1 : 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((ObjectID)obj);
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null)
            {
                return false;
            }
            if (getClass() != obj.getClass())
            {
                return false;
            }
            obj = (ObjectID)obj;
            if (leastSignificantBits != ((ObjectID) (obj)).leastSignificantBits)
            {
                return false;
            }
            if (mostSignificantBits != ((ObjectID) (obj)).mostSignificantBits)
            {
                return false;
            }
        }
        return true;
    }

    public long getLeastSignificantBits()
    {
        return leastSignificantBits;
    }

    public long getMostSignificantBits()
    {
        return mostSignificantBits;
    }

    public int hashCode()
    {
        return ((int)(leastSignificantBits ^ leastSignificantBits >>> 32) + 31) * 31 + (int)(mostSignificantBits ^ mostSignificantBits >>> 32);
    }

    public String toString()
    {
        if (asString == null)
        {
            asString = toString(mostSignificantBits, leastSignificantBits);
        }
        return asString;
    }

}

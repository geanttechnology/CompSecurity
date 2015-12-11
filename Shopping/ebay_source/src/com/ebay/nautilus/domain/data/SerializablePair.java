// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.util.Pair;

public class SerializablePair
{

    public Object key;
    public Object value;

    public SerializablePair()
    {
    }

    public SerializablePair(Pair pair)
    {
        this(pair.first, pair.second);
    }

    public SerializablePair(SerializablePair serializablepair)
    {
        this(serializablepair.key, serializablepair.value);
    }

    public SerializablePair(Object obj, Object obj1)
    {
        key = obj;
        value = obj1;
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        obj = (SerializablePair)obj;
        if (key == null)
        {
            if (((SerializablePair) (obj)).key != null)
            {
                return false;
            }
        } else
        if (!key.equals(((SerializablePair) (obj)).key))
        {
            return false;
        }
        if (value != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((SerializablePair) (obj)).value == null) goto _L1; else goto _L3
_L3:
        return false;
        if (value.equals(((SerializablePair) (obj)).value)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        if (key == null)
        {
            i = 0;
        } else
        {
            i = key.hashCode();
        }
        if (value != null)
        {
            j = value.hashCode();
        }
        return (i + 31) * 31 + j;
    }

    public Pair toPair()
    {
        return new Pair(key, value);
    }
}

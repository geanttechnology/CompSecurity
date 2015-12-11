// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mcc.nps;


public class Topic
{

    private final String identifier;

    public Topic(String s)
    {
        validateIdentifier(s);
        identifier = s;
    }

    public static Topic of(String s)
    {
        return new Topic(s);
    }

    private void validateIdentifier(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Topic identifier must not be null.");
        }
        if (s.trim().length() == 0)
        {
            throw new IllegalArgumentException("Topic identifier must not be empty or blank.");
        } else
        {
            return;
        }
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
        obj = (Topic)obj;
        if (identifier != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((Topic) (obj)).identifier == null) goto _L1; else goto _L3
_L3:
        return false;
        if (identifier.equals(((Topic) (obj)).identifier)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public String getIdentifier()
    {
        return identifier;
    }

    public int hashCode()
    {
        int i;
        if (identifier == null)
        {
            i = 0;
        } else
        {
            i = identifier.hashCode();
        }
        return i + 31;
    }
}

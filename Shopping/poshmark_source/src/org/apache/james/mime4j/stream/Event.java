// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.stream;


public final class Event
{

    public static final Event HEADERS_PREMATURE_END = new Event("Unexpected end of headers detected. Higher level boundary detected or EOF reached.");
    public static final Event INVALID_HEADER = new Event("Invalid header encountered");
    public static final Event MIME_BODY_PREMATURE_END = new Event("Body part ended prematurely. Boundary detected in header or EOF reached.");
    public static final Event OBSOLETE_HEADER = new Event("Obsolete header encountered");
    private final String code;

    public Event(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Code may not be null");
        } else
        {
            code = s;
            return;
        }
    }

    public boolean equals(Object obj)
    {
        if (obj != null)
        {
            if (this == obj)
            {
                return true;
            }
            if (obj instanceof Event)
            {
                obj = (Event)obj;
                return code.equals(((Event) (obj)).code);
            }
        }
        return false;
    }

    public int hashCode()
    {
        return code.hashCode();
    }

    public String toString()
    {
        return code;
    }

}

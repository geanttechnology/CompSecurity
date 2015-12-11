// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import java.io.Serializable;
import java.util.Date;

public class BookableSegments
    implements Serializable, Comparable
{

    public Date endsAt;
    public Boolean exactMatch;
    public Date startsAt;
    public String uuid;

    public BookableSegments()
    {
        uuid = "";
    }

    public void afterJsonDeserializationPostProcessor()
    {
    }

    public int compareTo(Object obj)
    {
        Date date = startsAt;
        obj = ((BookableSegments)obj).startsAt;
        if (date.before(((Date) (obj))))
        {
            return -1;
        }
        return !date.after(((Date) (obj))) ? 0 : 1;
    }
}

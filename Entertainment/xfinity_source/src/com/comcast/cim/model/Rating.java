// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.model;

import com.google.common.collect.Sets;
import java.io.Serializable;
import java.util.Collections;
import java.util.Locale;
import java.util.Set;
import org.apache.commons.lang3.Validate;

public class Rating
    implements Serializable
{

    private static final Set MATURE_RATINGS;
    private final String rating;

    public Rating(String s)
    {
        Validate.notNull(s);
        Validate.notEmpty(s);
        rating = s;
    }

    private String normalizeRating(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return s.replace(" ", "").replace("-", "").toLowerCase(Locale.US);
        }
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        Object obj1;
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        obj1 = (Rating)obj;
        obj = normalizeRating(rating);
        obj1 = normalizeRating(((Rating) (obj1)).rating);
        if (obj == null) goto _L4; else goto _L3
_L3:
        if (((String) (obj)).equals(obj1)) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (obj1 == null)
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public String getRating()
    {
        return rating;
    }

    public int hashCode()
    {
        String s = normalizeRating(rating);
        if (s != null)
        {
            return s.hashCode();
        } else
        {
            return 0;
        }
    }

    public boolean isMature()
    {
        return MATURE_RATINGS.contains(this);
    }

    public String toString()
    {
        return getRating();
    }

    static 
    {
        java.util.HashSet hashset = Sets.newHashSet();
        hashset.add(new Rating("R"));
        hashset.add(new Rating("X"));
        hashset.add(new Rating("TV-MA"));
        hashset.add(new Rating("NC-17"));
        hashset.add(new Rating("NSFW"));
        MATURE_RATINGS = Collections.unmodifiableSet(hashset);
    }
}

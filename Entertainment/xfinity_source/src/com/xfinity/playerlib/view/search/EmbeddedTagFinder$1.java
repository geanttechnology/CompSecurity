// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.search;

import java.util.Comparator;

// Referenced classes of package com.xfinity.playerlib.view.search:
//            EmbeddedTagFinder

static final class 
    implements Comparator
{

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((String)obj, (String)obj1);
    }

    public int compare(String s, String s1)
    {
        if (s.length() > s1.length())
        {
            return -1;
        }
        if (s1.length() > s.length())
        {
            return 1;
        } else
        {
            return s.compareTo(s1);
        }
    }

    ()
    {
    }
}

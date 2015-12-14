// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.friends;

import java.util.Comparator;

// Referenced classes of package com.cyberlink.you.friends:
//            Friend

public class b
    implements Comparator
{

    public b()
    {
    }

    public int a(Friend friend, Friend friend1)
    {
        if (friend.a < friend1.a)
        {
            return 1;
        }
        return friend.a <= friend1.a ? 0 : -1;
    }

    public int compare(Object obj, Object obj1)
    {
        return a((Friend)obj, (Friend)obj1);
    }
}

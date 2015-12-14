// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.friends;

import java.text.Collator;
import java.util.Comparator;

// Referenced classes of package com.cyberlink.you.friends:
//            Friend

public class a
    implements Comparator
{

    private final Collator a = Collator.getInstance();

    public a()
    {
    }

    public int a(Friend friend, Friend friend1)
    {
        return a.compare(friend.b(), friend1.b());
    }

    public int compare(Object obj, Object obj1)
    {
        return a((Friend)obj, (Friend)obj1);
    }
}

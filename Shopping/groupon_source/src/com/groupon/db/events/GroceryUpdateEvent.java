// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.events;


// Referenced classes of package com.groupon.db.events:
//            UniversalUpdateEvent

public class GroceryUpdateEvent extends UniversalUpdateEvent
{

    private String groceryId;

    public GroceryUpdateEvent(String s, String s1)
    {
        super(s);
        groceryId = s1;
    }

    public String getGroceryId()
    {
        return groceryId;
    }
}

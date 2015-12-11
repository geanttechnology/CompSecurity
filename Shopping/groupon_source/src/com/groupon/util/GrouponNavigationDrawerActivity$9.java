// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;


// Referenced classes of package com.groupon.util:
//            GrouponNavigationDrawerActivity

class val.itemId
    implements Runnable
{

    final GrouponNavigationDrawerActivity this$0;
    final int val$itemId;

    public void run()
    {
        goToNavDrawerItem(val$itemId);
    }

    ()
    {
        this$0 = final_grouponnavigationdraweractivity;
        val$itemId = I.this;
        super();
    }
}

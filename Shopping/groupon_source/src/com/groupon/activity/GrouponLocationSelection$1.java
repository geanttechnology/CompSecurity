// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.db.dao.DaoMyGrouponItem;
import java.util.concurrent.Callable;

// Referenced classes of package com.groupon.activity:
//            GrouponLocationSelection

class val.grouponNumber
    implements Callable
{

    final GrouponLocationSelection this$0;
    final String val$grouponNumber;

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public Void call()
        throws Exception
    {
        GrouponLocationSelection.access$000(GrouponLocationSelection.this).updateGrouponNumberAndLocatedById(grouponId, val$grouponNumber, true);
        return null;
    }

    ()
    {
        this$0 = final_grouponlocationselection;
        val$grouponNumber = String.this;
        super();
    }
}

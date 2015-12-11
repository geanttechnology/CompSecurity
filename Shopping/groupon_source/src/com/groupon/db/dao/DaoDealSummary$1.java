// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.dao;

import com.groupon.db.GrouponOrmLiteHelper;
import com.j256.ormlite.table.TableUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

// Referenced classes of package com.groupon.db.dao:
//            DaoDealSummary

class this._cls0
    implements Callable
{

    final DaoDealSummary this$0;

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public Void call()
        throws Exception
    {
        Class class1;
        for (Iterator iterator = GrouponOrmLiteHelper.dealTables.iterator(); iterator.hasNext(); TableUtils.clearTable(getConnectionSource(), class1))
        {
            class1 = (Class)iterator.next();
        }

        return null;
    }

    ()
    {
        this$0 = DaoDealSummary.this;
        super();
    }
}

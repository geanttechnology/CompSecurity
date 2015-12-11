// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.dao;

import com.groupon.db.models.InAppMessage;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.Where;
import java.util.concurrent.Callable;

// Referenced classes of package com.groupon.db.dao:
//            DaoInAppMessage

class val.inAppMessage
    implements Callable
{

    final DaoInAppMessage this$0;
    final InAppMessage val$inAppMessage;

    public Object call()
        throws Exception
    {
        DeleteBuilder deletebuilder = deleteBuilder();
        deletebuilder.setWhere(deletebuilder.where().eq("remoteId", val$inAppMessage.remoteId));
        delete(deletebuilder.prepare());
        create(val$inAppMessage);
        return null;
    }

    ()
    {
        this$0 = final_daoinappmessage;
        val$inAppMessage = InAppMessage.this;
        super();
    }
}

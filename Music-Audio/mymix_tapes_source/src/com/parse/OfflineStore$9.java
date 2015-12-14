// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.database.Cursor;
import bolts.Capture;
import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            OfflineStore

class val.uuid
    implements Continuation
{

    final OfflineStore this$0;
    final Capture val$uuid;

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    public String then(Task task)
        throws Exception
    {
        task = (Cursor)task.getResult();
        task.moveToFirst();
        if (task.isAfterLast())
        {
            throw new IllegalStateException((new StringBuilder()).append("Attempted to find non-existent uuid ").append((String)val$uuid.get()).toString());
        } else
        {
            return task.getString(0);
        }
    }

    eption()
    {
        this$0 = final_offlinestore;
        val$uuid = Capture.this;
        super();
    }
}

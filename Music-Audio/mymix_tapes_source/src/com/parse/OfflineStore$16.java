// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.ContentValues;
import bolts.Capture;
import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            OfflineStore, ParseObject, ParseSQLiteDatabase

class ase
    implements Continuation
{

    final OfflineStore this$0;
    final ParseSQLiteDatabase val$db;
    final Capture val$encoded;
    final ParseObject val$object;
    final Capture val$uuid;

    public Task then(Task task)
        throws Exception
    {
        String s = val$object.getClassName();
        String s1 = val$object.getObjectId();
        String s2 = val$encoded.get().toString();
        task = new ContentValues();
        task.put("className", s);
        task.put("json", s2);
        if (s1 != null)
        {
            task.put("objectId", s1);
        }
        s = (String)val$uuid.get();
        return val$db.updateAsync("ParseObjects", task, "uuid = ?", new String[] {
            s
        }).makeVoid();
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    ase()
    {
        this$0 = final_offlinestore;
        val$object = parseobject;
        val$encoded = capture;
        val$uuid = capture1;
        val$db = ParseSQLiteDatabase.this;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import android.content.ContentValues;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            OfflineStore, ParseObject, ParseSQLiteDatabase

class ase
    implements i
{

    final OfflineStore this$0;
    final ParseSQLiteDatabase val$db;
    final JSONObject val$json;
    final ParseObject val$object;
    final String val$uuid;

    public j then(j j1)
        throws Exception
    {
        j1 = val$object.getClassName();
        String s = val$object.getObjectId();
        int k = val$json.getInt("__isDeletingEventually");
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("className", j1);
        j1 = val$json;
        if (!(j1 instanceof JSONObject))
        {
            j1 = j1.toString();
        } else
        {
            j1 = JSONObjectInstrumentation.toString((JSONObject)j1);
        }
        contentvalues.put("json", j1);
        if (s != null)
        {
            contentvalues.put("objectId", s);
        }
        contentvalues.put("isDeletingEventually", Integer.valueOf(k));
        j1 = val$uuid;
        return val$db.updateAsync("ParseObjects", contentvalues, "uuid = ?", new String[] {
            j1
        }).j();
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    ase()
    {
        this$0 = final_offlinestore;
        val$object = parseobject;
        val$json = jsonobject;
        val$uuid = s;
        val$db = ParseSQLiteDatabase.this;
        super();
    }
}

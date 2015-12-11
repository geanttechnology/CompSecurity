// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.ContentValues;
import android.support.v7.ct;
import android.support.v7.cu;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            OfflineStore, ParseObject, ParseSQLiteDatabase

class ase
    implements ct
{

    final OfflineStore this$0;
    final ParseSQLiteDatabase val$db;
    final JSONObject val$json;
    final ParseObject val$object;
    final String val$uuid;

    public cu then(cu cu1)
        throws Exception
    {
        cu1 = val$object.getClassName();
        String s = val$object.getObjectId();
        int i = val$json.getInt("__isDeletingEventually");
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("className", cu1);
        cu1 = val$json;
        if (!(cu1 instanceof JSONObject))
        {
            cu1 = cu1.toString();
        } else
        {
            cu1 = JSONObjectInstrumentation.toString((JSONObject)cu1);
        }
        contentvalues.put("json", cu1);
        if (s != null)
        {
            contentvalues.put("objectId", s);
        }
        contentvalues.put("isDeletingEventually", Integer.valueOf(i));
        cu1 = val$uuid;
        return val$db.updateAsync("ParseObjects", contentvalues, "uuid = ?", new String[] {
            cu1
        }).j();
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
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

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseACL

private static class writePermission
{

    private static final String READ_PERMISSION = "read";
    private static final String WRITE_PERMISSION = "write";
    private final boolean readPermission;
    private final boolean writePermission;

    static writePermission createPermissionsFromJSONObject(JSONObject jsonobject)
    {
        return new <init>(jsonobject.optBoolean("read", false), jsonobject.optBoolean("write", false));
    }

    boolean getReadPermission()
    {
        return readPermission;
    }

    boolean getWritePermission()
    {
        return writePermission;
    }

    JSONObject toJSONObject()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            if (readPermission)
            {
                jsonobject.put("read", true);
            }
            if (writePermission)
            {
                jsonobject.put("write", true);
            }
        }
        catch (JSONException jsonexception)
        {
            throw new RuntimeException(jsonexception);
        }
        return jsonobject;
    }

    ( )
    {
        readPermission = .readPermission;
        writePermission = .writePermission;
    }

    writePermission(boolean flag, boolean flag1)
    {
        readPermission = flag;
        writePermission = flag1;
    }
}

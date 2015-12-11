// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.flurry.android:
//            AppCloudResponse, AppCloudUser, AppCloudObject

final class dn extends AppCloudResponse
{

    private ArrayList fl;
    private ArrayList fm;
    private Boolean fn;

    public dn(AppCloudResponse appcloudresponse, Boolean boolean1)
    {
        super(appcloudresponse.bY);
        fl = new ArrayList();
        fm = new ArrayList();
        fn = Boolean.valueOf(false);
        fn = boolean1;
        if (isSuccessful())
        {
            aF();
        }
    }

    private void aF()
    {
        if (bY == null) goto _L2; else goto _L1
_L1:
        JSONArray jsonarray = bY.getJSONArray("set");
        if (jsonarray == null) goto _L2; else goto _L3
_L3:
        int i = 0;
_L9:
        if (i >= jsonarray.length()) goto _L2; else goto _L4
_L4:
        JSONObject jsonobject = jsonarray.getJSONObject(i);
        if (!fn.booleanValue()) goto _L6; else goto _L5
_L5:
        fm.add(new AppCloudUser(jsonobject));
          goto _L7
_L6:
        fl.add(new AppCloudObject(jsonobject));
          goto _L7
        JSONException jsonexception;
        jsonexception;
        jsonexception.printStackTrace();
_L2:
        return;
_L7:
        i++;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public final ArrayList getObjects()
    {
        return fl;
    }

    public final ArrayList getUsers()
    {
        return fm;
    }
}

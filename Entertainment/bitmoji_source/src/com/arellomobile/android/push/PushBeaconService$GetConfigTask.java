// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push;

import android.os.AsyncTask;
import com.radiusnetworks.ibeacon.Region;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.arellomobile.android.push:
//            PushBeaconService, DeviceFeature2_5

private class <init> extends AsyncTask
{

    final PushBeaconService this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient JSONObject doInBackground(Void avoid[])
    {
        try
        {
            avoid = DeviceFeature2_5.getBeacons(PushBeaconService.this);
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            return new JSONObject();
        }
        return avoid;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((JSONObject)obj);
    }

    protected void onPostExecute(JSONObject jsonobject)
    {
        boolean flag = false;
        PushBeaconService.access$302(PushBeaconService.this, new ArrayList());
        PushBeaconService.access$402(PushBeaconService.this, jsonobject);
        JSONArray jsonarray = PushBeaconService.access$400(PushBeaconService.this).optJSONArray("beacons");
        String s = PushBeaconService.access$400(PushBeaconService.this).optString("uuid", null);
        PushBeaconService.access$502(PushBeaconService.this, Integer.valueOf(PushBeaconService.access$400(PushBeaconService.this).optInt("indoor_offset", 0)));
        if (s == null)
        {
            return;
        }
        jsonobject = jsonarray;
        int i = ((flag) ? 1 : 0);
        if (jsonarray == null)
        {
            jsonobject = new JSONArray();
            i = ((flag) ? 1 : 0);
        }
        for (; i < jsonobject.length(); i++)
        {
            Object obj = jsonobject.optJSONObject(i);
            if (obj != null && ((JSONObject) (obj)).has("major_number"))
            {
                int j = ((JSONObject) (obj)).optInt("major_number");
                obj = new Region((new StringBuilder()).append(getPackageName()).append(s).append(j).toString(), s, Integer.valueOf(j), null);
                PushBeaconService.access$300(PushBeaconService.this).add(obj);
            }
        }

        PushBeaconService.access$600(PushBeaconService.this);
    }

    private ()
    {
        this$0 = PushBeaconService.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}

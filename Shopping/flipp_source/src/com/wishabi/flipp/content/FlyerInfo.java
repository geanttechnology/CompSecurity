// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.wishabi.flipp.content:
//            k, bb

public class FlyerInfo
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new k();
    public final ArrayList a = new ArrayList();
    public final ArrayList b = new ArrayList();
    public String c;
    private String d;

    public FlyerInfo()
    {
    }

    public static FlyerInfo a(JSONObject jsonobject)
    {
        int i;
        boolean flag = false;
        Object obj;
        FlyerInfo flyerinfo;
        bb bb1;
        try
        {
            flyerinfo = new FlyerInfo();
            obj = jsonobject.optJSONArray("select_stores");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            jsonobject.toString();
            return null;
        }
        if (obj == null) goto _L2; else goto _L1
_L1:
        i = 0;
_L12:
        if (i >= ((JSONArray) (obj)).length()) goto _L2; else goto _L3
_L3:
        bb1 = bb.a(((JSONArray) (obj)).getJSONObject(i));
        if (bb1 == null) goto _L5; else goto _L4
_L4:
        flyerinfo.a.add(bb1);
          goto _L5
_L2:
        obj = jsonobject.optJSONArray("nearby_stores");
        if (obj == null) goto _L7; else goto _L6
_L6:
        i = ((flag) ? 1 : 0);
_L13:
        if (i >= ((JSONArray) (obj)).length()) goto _L7; else goto _L8
_L8:
        bb1 = bb.a(((JSONArray) (obj)).getJSONObject(i));
        if (bb1 == null)
        {
            break MISSING_BLOCK_LABEL_163;
        }
        flyerinfo.b.add(bb1);
        break MISSING_BLOCK_LABEL_163;
_L7:
        if (!jsonobject.isNull("corrections_url")) goto _L10; else goto _L9
_L9:
        obj = null;
_L11:
        flyerinfo.c = ((String) (obj));
        flyerinfo.d = jsonobject.toString();
        return flyerinfo;
_L10:
        obj = jsonobject.getString("corrections_url");
        if (true) goto _L11; else goto _L5
_L5:
        i++;
          goto _L12
        i++;
          goto _L13
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (d != null)
        {
            parcel.writeString(d);
        }
    }

}

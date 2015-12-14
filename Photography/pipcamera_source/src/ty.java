// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.wantu.model.res.EResType;
import com.wantu.model.res.TResInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ty
{

    public static TResInfo a(JSONObject jsonobject)
    {
        Object obj = null;
        if (jsonobject != null)
        {
            TResInfo tresinfo = new TResInfo();
            tresinfo.setResType(EResType.NETWORK);
            tresinfo.resId = kv.e(jsonobject, "id");
            tresinfo.name = kv.a(jsonobject, "name");
            tresinfo.icon = kv.a(jsonobject, "iconUrl");
            if (jsonobject.has("price"))
            {
                tresinfo.price = kv.e(jsonobject, "price");
            }
            if (jsonobject.has("previewUrl"))
            {
                tresinfo.previewUrl = kv.a(jsonobject, "previewUrl");
            }
            if (jsonobject.has("zipUrl"))
            {
                tresinfo.zipUrl = kv.a(jsonobject, "zipUrl");
            }
            if (jsonobject.has("needReviewing"))
            {
                tresinfo.needReviewing = kv.d(jsonobject, "needReviewing");
            }
            if (jsonobject.has("otherAppStoreId"))
            {
                tresinfo.otherAppStoreId = kv.a(jsonobject, "otherAppStoreId");
            }
            if (!jsonobject.isNull("WXMomentsShareInfo"))
            {
                obj = kv.c(jsonobject, "WXMomentsShareInfo");
                if (obj != null)
                {
                    tresinfo.needSharing = true;
                    tresinfo.wxdlShareInfo = new uu();
                    if (((JSONObject) (obj)).has("title"))
                    {
                        tresinfo.wxdlShareInfo.a = kv.a(((JSONObject) (obj)), "title");
                    }
                    if (((JSONObject) (obj)).has("thumbUrl"))
                    {
                        tresinfo.wxdlShareInfo.c = kv.a(((JSONObject) (obj)), "thumbUrl");
                    }
                    if (((JSONObject) (obj)).has("description"))
                    {
                        tresinfo.wxdlShareInfo.b = kv.a(((JSONObject) (obj)), "description");
                    }
                    if (((JSONObject) (obj)).has("webpageUrl"))
                    {
                        tresinfo.wxdlShareInfo.d = kv.a(((JSONObject) (obj)), "webpageUrl");
                    }
                    if (((JSONObject) (obj)).has("message"))
                    {
                        tresinfo.wxdlShareInfo.f = kv.a(((JSONObject) (obj)), "message");
                    }
                }
            }
            obj = tresinfo;
            if (!jsonobject.isNull("SinaDLShareInfo"))
            {
                jsonobject = kv.c(jsonobject, "SinaDLShareInfo");
                obj = tresinfo;
                if (jsonobject != null)
                {
                    tresinfo.needSharing = true;
                    tresinfo.sinadlShareInfo = new uq();
                    if (jsonobject.has("imageUrl"))
                    {
                        tresinfo.sinadlShareInfo.a = kv.a(jsonobject, "imageUrl");
                    }
                    obj = tresinfo;
                    if (jsonobject.has("message"))
                    {
                        tresinfo.sinadlShareInfo.b = kv.a(jsonobject, "message");
                        obj = tresinfo;
                    }
                }
            }
        }
        return ((TResInfo) (obj));
    }

    public static ArrayList a(JSONObject jsonobject, ArrayList arraylist)
    {
        ArrayList arraylist1 = new ArrayList(0);
        if (jsonobject != null) goto _L2; else goto _L1
_L1:
        jsonobject = null;
_L4:
        return jsonobject;
_L2:
        int j;
        int k;
        JSONArray jsonarray;
        Object obj;
        ArrayList arraylist2;
        uj uj1;
        Object obj1;
        Object obj2;
        int i;
        try
        {
            jsonarray = kv.b(jsonobject, "data");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            jsonobject.printStackTrace();
            return arraylist1;
        }
        i = 0;
        jsonobject = arraylist1;
        if (i >= jsonarray.length()) goto _L4; else goto _L3
_L3:
        obj = jsonarray.getJSONObject(i);
        jsonobject = new uk();
        jsonobject.a = kv.a(((JSONObject) (obj)), "name");
        jsonobject.b = kv.a(((JSONObject) (obj)), "displayName");
        obj = kv.b(((JSONObject) (obj)), "category");
        arraylist2 = new ArrayList(2);
        j = 0;
_L10:
        if (j >= ((JSONArray) (obj)).length()) goto _L6; else goto _L5
_L5:
        obj1 = ((JSONArray) (obj)).getJSONObject(j);
        uj1 = new uj();
        obj2 = ((JSONArray) (obj)).getJSONObject(j);
        uj1.c = kv.a(((JSONObject) (obj2)), "coverImageUrl");
        uj1.b = kv.a(((JSONObject) (obj2)), "displayName");
        uj1.d = tu.getResTypeByString(kv.a(((JSONObject) (obj2)), "type"));
        obj1 = kv.b(((JSONObject) (obj1)), "magsArray");
        uj1.g = new ArrayList();
        k = 0;
_L8:
        if (k >= ((JSONArray) (obj1)).length())
        {
            break MISSING_BLOCK_LABEL_261;
        }
        obj2 = a(((JSONArray) (obj1)).getJSONObject(k));
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_341;
        }
        if (!kf.c().d().a(((TResInfo) (obj2)).resId, uj1.d))
        {
            uj1.g.add(obj2);
        }
        break MISSING_BLOCK_LABEL_341;
        uj1.e = uj1.g.size();
        if (arraylist.contains(uj1.d) && uj1.e > 0)
        {
            arraylist2.add(uj1);
        }
        break MISSING_BLOCK_LABEL_350;
_L6:
        jsonobject.c = arraylist2;
        if (arraylist2.size() > 0)
        {
            arraylist1.add(jsonobject);
        }
        i++;
        break MISSING_BLOCK_LABEL_27;
        k++;
        if (true) goto _L8; else goto _L7
_L7:
        j++;
        if (true) goto _L10; else goto _L9
_L9:
    }
}

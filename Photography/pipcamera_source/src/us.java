// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import com.crashlytics.android.Crashlytics;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import com.wantu.model.res.EResType;
import java.io.InputStream;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class us extends to
{

    private String d;

    public us()
    {
        d = "TPhotoMagComposeNetwork";
    }

    protected String a(Object obj)
    {
        obj = (TPhotoComposeInfo)obj;
        String s = uc.a();
        return String.format("%s&ID=%s&%s", new Object[] {
            uc.q, Integer.valueOf(((TPhotoComposeInfo) (obj)).resId), s
        });
    }

    protected String a(ArrayList arraylist)
    {
        arraylist = uc.a();
        arraylist = String.format("%s&%s", new Object[] {
            uc.p, arraylist
        });
        Log.v("TPhotoMagComposeNetwork", (new StringBuilder()).append("TPhotoMagComposeNetworkrequestURL: ").append(arraylist).toString());
        return arraylist;
    }

    protected ArrayList a(InputStream inputstream)
    {
        return null;
    }

    protected tp a()
    {
        return new ut();
    }

    protected int b(InputStream inputstream)
    {
        return 0;
    }

    protected void b(String s)
    {
        Log.v("Update_REQUSEST", "Update_REQUSEST");
        if (s != null)
        {
            try
            {
                s = e(s);
                Log.v("updateDidFinished", String.format("%d", new Object[] {
                    Integer.valueOf(s.size())
                }));
                if (b != null)
                {
                    b.filterUpdateFinished(s);
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                Crashlytics.logException(s);
                return;
            }
        }
    }

    protected ArrayList e(String s)
    {
        ArrayList arraylist = new ArrayList();
        if (s != null && !s.equalsIgnoreCase("null")) goto _L2; else goto _L1
_L1:
        return arraylist;
_L2:
        s = new JSONObject(s);
        Object obj;
        obj = s;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        Log.d(d, (new StringBuilder()).append(d).append(" save json string to Local:").toString());
        obj = s;
_L6:
        ((JSONObject) (obj)).toJSONArray(((JSONObject) (obj)).names());
        if (!kv.a(((JSONObject) (obj)), "status").toString().equalsIgnoreCase("1")) goto _L1; else goto _L3
_L3:
        s = kv.b(((JSONObject) (obj)), "data");
        int i = 0;
_L5:
        if (i >= s.length()) goto _L1; else goto _L4
_L4:
        obj = s.getJSONObject(i);
        JSONException jsonexception;
        if (obj != null)
        {
            try
            {
                TPhotoComposeInfo tphotocomposeinfo = new TPhotoComposeInfo();
                tphotocomposeinfo.resId = kv.e(((JSONObject) (obj)), "rid");
                tphotocomposeinfo.version = kv.a(((JSONObject) (obj)), "version");
                tphotocomposeinfo.name = kv.a(((JSONObject) (obj)), "name");
                tphotocomposeinfo.icon = kv.a(((JSONObject) (obj)), "icon");
                tphotocomposeinfo.previewUrl = kv.a(((JSONObject) (obj)), "previewUrl");
                tphotocomposeinfo.price = kv.e(((JSONObject) (obj)), "price");
                tphotocomposeinfo.imageCount = kv.e(((JSONObject) (obj)), "imageCount");
                tphotocomposeinfo.width = kv.f(((JSONObject) (obj)), "width");
                tphotocomposeinfo.height = kv.f(((JSONObject) (obj)), "height");
                tphotocomposeinfo.isOnline = true;
                tphotocomposeinfo.setResType(EResType.NETWORK);
                tphotocomposeinfo.isUpdate = kv.d(((JSONObject) (obj)), "isUpdate");
                tphotocomposeinfo.otherAppStoreId = kv.a(((JSONObject) (obj)), "otherAppStoreId");
                if (((JSONObject) (obj)).has("WXMomentsShareInfo"))
                {
                    JSONObject jsonobject = kv.c(((JSONObject) (obj)), "WXMomentsShareInfo");
                    tphotocomposeinfo.needSharing = true;
                    tphotocomposeinfo.wxdlShareInfo = new uu();
                    if (jsonobject.has("title"))
                    {
                        tphotocomposeinfo.wxdlShareInfo.a = jsonobject.getString("title");
                    }
                    if (jsonobject.has("thumbUrl"))
                    {
                        tphotocomposeinfo.wxdlShareInfo.c = jsonobject.getString("thumbUrl");
                    }
                    if (jsonobject.has("description"))
                    {
                        tphotocomposeinfo.wxdlShareInfo.b = jsonobject.getString("description");
                    }
                    if (jsonobject.has("webpageUrl"))
                    {
                        tphotocomposeinfo.wxdlShareInfo.d = jsonobject.getString("webpageUrl");
                    }
                    if (jsonobject.has("message"))
                    {
                        tphotocomposeinfo.wxdlShareInfo.f = jsonobject.getString("message");
                    }
                }
                if (((JSONObject) (obj)).has("SinaDLShareInfo"))
                {
                    JSONObject jsonobject1 = kv.c(((JSONObject) (obj)), "SinaDLShareInfo");
                    tphotocomposeinfo.needSharing = true;
                    tphotocomposeinfo.sinadlShareInfo = new uq();
                    if (jsonobject1.has("imageUrl"))
                    {
                        tphotocomposeinfo.sinadlShareInfo.a = jsonobject1.getString("imageUrl");
                    }
                    if (jsonobject1.has("message"))
                    {
                        tphotocomposeinfo.sinadlShareInfo.b = jsonobject1.getString("message");
                    }
                }
                if (((JSONObject) (obj)).has("needReviewing"))
                {
                    tphotocomposeinfo.needReviewing = kv.d(((JSONObject) (obj)), "needReviewing");
                }
                if (((JSONObject) (obj)).has("isCartoon"))
                {
                    tphotocomposeinfo.isCartoon = kv.d(((JSONObject) (obj)), "isCartoon");
                }
                arraylist.add(tphotocomposeinfo);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                Crashlytics.logException(s);
                return arraylist;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                Crashlytics.logException(s);
                return arraylist;
            }
        }
        i++;
          goto _L5
          goto _L1
        jsonexception;
        s = null;
_L7:
        jsonexception.printStackTrace();
        Crashlytics.logException(jsonexception);
        jsonexception = s;
          goto _L6
        jsonexception;
          goto _L7
    }
}

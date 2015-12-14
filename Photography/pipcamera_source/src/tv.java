// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import com.crashlytics.android.Crashlytics;
import com.fotoable.adbuttonlib.TadvertiseUtil;
import com.pipcamera.application.PIPCameraApplication;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.ResourceOnlineLibrary.TOnlineConfigItem;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class tv
{

    private String a;
    private ul b;
    private String c;
    private String d;
    private JSONArray e;
    private JSONArray f;
    private tw g;
    private HashMap h;

    public tv()
    {
        a = "TOnlineResUpdateChecker";
        c = "status";
        d = "data";
        h = new HashMap(0);
    }

    public static Boolean a(EOnlineResType eonlinerestype, HashMap hashmap)
    {
        if (hashmap == null)
        {
            return Boolean.valueOf(false);
        }
        eonlinerestype = ((EOnlineResType) (hashmap.get(tu.getStringByResType(eonlinerestype))));
        if (eonlinerestype != null && (eonlinerestype instanceof String) && ((String)eonlinerestype).toUpperCase().equalsIgnoreCase("YES"))
        {
            return Boolean.valueOf(true);
        } else
        {
            return Boolean.valueOf(false);
        }
    }

    private void a(String s)
    {
        boolean flag = false;
        if (s != null) goto _L2; else goto _L1
_L1:
        if (g != null)
        {
            g.a(null);
        }
_L4:
        return;
_L2:
        if (h != null)
        {
            h.clear();
        }
        if (s == null) goto _L4; else goto _L3
_L3:
        kv.a(null, 3, (new StringBuilder()).append("Response => ").append(s).toString());
        s = new JSONObject(s);
        e = s.names();
        f = s.toJSONArray(e);
        int i = 0;
_L6:
        if (i >= e.length())
        {
            break; /* Loop/switch isn't completed */
        }
        kv.a(null, 3, (new StringBuilder()).append("Key => ").append(e.getString(i)).append(" Value => ").append(f.getString(i)).toString());
        i++;
        if (true) goto _L6; else goto _L5
_L5:
        if (!TadvertiseUtil.getJSONValue(s, c).toString().equalsIgnoreCase("1"))
        {
            break MISSING_BLOCK_LABEL_279;
        }
        s = kv.b(s, d);
        i = ((flag) ? 1 : 0);
_L7:
        String s1;
        Object obj;
        if (i >= s.length())
        {
            break MISSING_BLOCK_LABEL_279;
        }
        obj = s.getJSONObject(i);
        s1 = kv.a(((JSONObject) (obj)), "type");
        if (s1 == null || s1 == "")
        {
            break MISSING_BLOCK_LABEL_261;
        }
        obj = kv.a(((JSONObject) (obj)), "hasNew");
        if (obj == null || obj == "")
        {
            break MISSING_BLOCK_LABEL_261;
        }
        h.put(s1, obj);
        i++;
          goto _L7
        s;
        try
        {
            s.printStackTrace();
            Crashlytics.logException(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            Crashlytics.logException(s);
        }
        if (g != null && h != null)
        {
            g.a(h);
            return;
        } else
        {
            g.a(null);
            return;
        }
    }

    static void a(tv tv1, String s)
    {
        tv1.a(s);
    }

    private String b(List list)
    {
        JSONObject jsonobject = new JSONObject();
        JSONArray jsonarray = new JSONArray();
        int i = 0;
        do
        {
            if (i >= list.size())
            {
                break;
            }
            String s = (String)list.get(i);
            Object obj = tu.getResTypeByString(s);
            JSONArray jsonarray1 = new JSONArray();
            obj = (new TOnlineConfigItem()).getUpdateDateDictByType(((EOnlineResType) (obj)));
            if (obj != null)
            {
                Iterator iterator = ((Map) (obj)).keySet().iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    String s1 = (String)iterator.next();
                    JSONObject jsonobject1 = new JSONObject();
                    Long long1 = (Long)((Map) (obj)).get(s1);
                    s1 = TOnlineConfigItem.getChildNameByKey(s1);
                    try
                    {
                        jsonobject1.put("lastupdatetime", long1.toString());
                        jsonobject1.put("name", s1);
                    }
                    catch (JSONException jsonexception1)
                    {
                        jsonexception1.printStackTrace();
                        Crashlytics.logException(jsonexception1);
                    }
                    jsonarray1.put(jsonobject1);
                } while (true);
            }
            obj = new JSONObject();
            try
            {
                ((JSONObject) (obj)).put("type", s);
                ((JSONObject) (obj)).put("updatetimes", jsonarray1);
            }
            catch (JSONException jsonexception)
            {
                jsonexception.printStackTrace();
                Crashlytics.logException(jsonexception);
            }
            jsonarray.put(obj);
            i++;
        } while (true);
        try
        {
            jsonobject.put("data", jsonarray);
            list = jsonobject.toString();
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            list.printStackTrace();
            Crashlytics.logException(list);
            return "";
        }
        return list;
    }

    public void a(List list)
    {
        if (list != null && list.size() > 0)
        {
            list = b(list);
            String s = uc.a();
            Log.v("userInfor", s);
            s = String.format("%s&%s&timestamp=%d", new Object[] {
                uc.n, s, Integer.valueOf(0)
            });
            Log.v("RequestURl %@", s);
            if (b != null && !b.isCancelled())
            {
                b.cancel(true);
                b = null;
            }
            b = new ul(PIPCameraApplication.a, s);
            Log.v(a, (new StringBuilder()).append(a).append("RequestURl jsonString :").append(list).toString());
            b.a("UpdateTimes", list);
            b.a(new ue() {

                final tv a;

                public void a(String s1)
                {
                    if (s1 != null && s1.length() > 0)
                    {
                        tv.a(a, s1);
                    }
                }

            
            {
                a = tv.this;
                super();
            }
            });
            b.execute(new String[0]);
        }
    }

    public void a(tw tw1)
    {
        g = tw1;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package bo.app;

import com.appboy.Constants;
import java.util.ArrayList;
import java.util.List;
import myobfuscated.g.a;
import myobfuscated.g.b;
import myobfuscated.g.c;
import myobfuscated.g.d;
import myobfuscated.g.e;
import myobfuscated.g.f;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package bo.app:
//            ek, br, ec

public final class cl
{

    private static final String a;

    public cl()
    {
    }

    public static List a(JSONArray jsonarray, Class class1, br br, ec ec)
    {
        ArrayList arraylist;
        int i;
        arraylist = new ArrayList();
        i = 0;
_L8:
        if (i >= jsonarray.length())
        {
            break MISSING_BLOCK_LABEL_312;
        }
        Object obj = jsonarray.optString(i);
        if (!class1.equals(java/lang/String)) goto _L2; else goto _L1
_L1:
        obj = bo.app.ek.a(obj, class1);
_L5:
        String s;
        if (obj != null)
        {
            try
            {
                arraylist.add(obj);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                String.format("Unable to cast JSON to [%s] in array. Ignoring.", new Object[] {
                    class1.getName()
                });
            }
        }
        break MISSING_BLOCK_LABEL_315;
_L2:
        if (!class1.equals(myobfuscated/g/c))
        {
            break MISSING_BLOCK_LABEL_283;
        }
        obj = new JSONObject(((String) (obj)));
        s = ((JSONObject) (obj)).getString("type");
        if (!"banner_image".equals(s)) goto _L4; else goto _L3
_L3:
        obj = new a(((JSONObject) (obj)), br, ec);
_L6:
        obj = bo.app.ek.a(obj, class1);
          goto _L5
_L4:
label0:
        {
            if (!"captioned_image".equals(s))
            {
                break label0;
            }
            obj = new b(((JSONObject) (obj)), br, ec);
        }
          goto _L6
label1:
        {
            if (!"cross_promotion_small".equals(s))
            {
                break label1;
            }
            obj = new d(((JSONObject) (obj)), br, ec);
        }
          goto _L6
label2:
        {
            if (!"short_news".equals(s))
            {
                break label2;
            }
            obj = new e(((JSONObject) (obj)), br, ec);
        }
          goto _L6
label3:
        {
            if (!"text_announcement".equals(s))
            {
                break label3;
            }
            obj = new f(((JSONObject) (obj)), br, ec);
        }
          goto _L6
        throw new JSONException(String.format("Failed to construct java object of type %s from JSON [%s]", new Object[] {
            s, ((JSONObject) (obj)).toString()
        }));
        throw new JSONException(String.format("Failed to construct java object %s, target class %s isn'tString nor Card. Please update the createObject in ModelFactory to handle extra class type.", new Object[] {
            obj, class1.toString()
        }));
        return arraylist;
        i++;
        if (true) goto _L8; else goto _L7
_L7:
    }

    static 
    {
        a = String.format("%s.%s", new Object[] {
            Constants.APPBOY_LOG_TAG_PREFIX, bo/app/cl.getName()
        });
    }
}

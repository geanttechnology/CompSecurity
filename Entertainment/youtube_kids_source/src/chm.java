// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class chm
{

    private static final String a = chm.getCanonicalName();
    private final JSONObject b;

    public chm(JSONObject jsonobject)
    {
        b = jsonobject;
    }

    public final cgc a()
    {
        Object obj;
        String s;
        if (b == null)
        {
            return null;
        }
        Object obj1;
        try
        {
            obj = b.optString("accessType", null);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.e(a, "Error parsing screen ", ((Throwable) (obj)));
            return null;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_341;
        }
        obj1 = cge.a(((String) (obj)));
        s = b.optString("name", null);
        obj = b.getString("loungeToken");
        if (obj1 != cge.a) goto _L2; else goto _L1
_L1:
        if (b.has("screenId")) goto _L4; else goto _L3
_L3:
        obj = a;
        obj1 = String.valueOf(b);
        Log.e(((String) (obj)), (new StringBuilder(String.valueOf(obj1).length() + 47)).append("We got a permanent screen without a screen id. ").append(((String) (obj1))).toString());
        return null;
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        s = a;
        obj = String.valueOf(obj);
        if (((String) (obj)).length() == 0)
        {
            break MISSING_BLOCK_LABEL_163;
        }
        obj = "Unknown access type ".concat(((String) (obj)));
_L5:
        Log.e(s, ((String) (obj)), illegalargumentexception);
        return null;
        obj = new String("Unknown access type ");
          goto _L5
_L4:
        cgr cgr1;
        cgr1 = new cgr(b.getString("screenId"));
        if (!b.has("loungeToken"))
        {
            break MISSING_BLOCK_LABEL_336;
        }
        obj = new cgj(((String) (obj)));
_L11:
        Object obj2 = b.optString("clientName", null);
        if (obj2 == null) goto _L7; else goto _L6
_L6:
        obj2 = new cgb(((String) (obj2)));
_L10:
        return new cgc(cgr1, s, ((cgb) (obj2)), ((cgj) (obj)));
_L2:
        if (b.has("loungeToken")) goto _L9; else goto _L8
_L8:
        obj = a;
        obj2 = String.valueOf(b);
        Log.e(((String) (obj)), (new StringBuilder(String.valueOf(obj2).length() + 49)).append("We got a temporary screen without a loungeToken. ").append(((String) (obj2))).toString());
        return null;
_L9:
        obj = new cgc(new cgv(((String) (obj))), s);
        return ((cgc) (obj));
_L7:
        obj2 = null;
          goto _L10
        obj = null;
          goto _L11
        return null;
    }

}

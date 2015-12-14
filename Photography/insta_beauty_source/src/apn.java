// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import com.instabeauty.application.InstaBeautyApplication;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoMagComposeManager;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class apn
{

    private static apn b = null;
    private String a;
    private app c;
    private ArrayList d;
    private apc e;

    private apn()
    {
        a = "TAdOnlineCheckManager";
        c = null;
        d = new ArrayList();
        e = apc.a(InstaBeautyApplication.a);
    }

    public static apn a()
    {
        if (b != null) goto _L2; else goto _L1
_L1:
        apn;
        JVM INSTR monitorenter ;
        if (b == null)
        {
            b = new apn();
        }
        apn;
        JVM INSTR monitorexit ;
_L2:
        return b;
        Exception exception;
        exception;
        apn;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static String a(apn apn1)
    {
        return apn1.a;
    }

    static boolean a(apn apn1, JSONObject jsonobject)
    {
        return apn1.a(jsonobject);
    }

    private boolean a(JSONObject jsonobject)
    {
        boolean flag1 = true;
        if (jsonobject != null && jsonobject.length() != 0) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (!aqn.a(jsonobject, "status").toString().equalsIgnoreCase("1")) goto _L4; else goto _L3
_L3:
        jsonobject = aqn.b(jsonobject, "data");
        if (jsonobject.length() > 0)
        {
            d.clear();
        }
        break MISSING_BLOCK_LABEL_134;
_L6:
        flag = flag1;
        int i;
        if (i >= jsonobject.length()) goto _L4; else goto _L5
_L5:
        Object obj = jsonobject.getJSONObject(i);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        try
        {
            obj = bcy.a(((JSONObject) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return false;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        if (!apq.c().d().getDeleteAndHideInfoIds().contains(((TPhotoComposeInfo) (obj)).getDeleteTag()))
        {
            d.add(obj);
        }
        i++;
          goto _L6
        i = 0;
          goto _L6
    }

    static apc b(apn apn1)
    {
        return apn1.e;
    }

    static ArrayList c(apn apn1)
    {
        return apn1.d;
    }

    public List b()
    {
        return d;
    }

    public void c()
    {
        if (axw.k(InstaBeautyApplication.a)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        boolean flag;
        JSONObject jsonobject;
        try
        {
            jsonobject = e.b("json_magrecommend_library");
        }
        catch (Exception exception)
        {
            exception = null;
        }
        if (jsonobject == null || jsonobject.length() <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        Log.v(a, (new StringBuilder()).append(a).append("get data from Cache").toString());
        if (!a(jsonobject))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = false;
_L4:
        if (flag)
        {
            if (c != null)
            {
                if (c.getStatus() == com.fotoable.comlib.util.AsyncTask.Status.RUNNING)
                {
                    c.cancel(true);
                }
                c = null;
            }
            c = new app(this, null);
            c.execute(new Void[0]);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        flag = true;
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.sketch.activity.TTieZhiActivity;
import com.fotoable.sketch.info.TTieZhiInfo;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ave
    implements Runnable
{

    final JSONObject a;
    final boolean b;
    final TTieZhiActivity c;

    public ave(TTieZhiActivity ttiezhiactivity, JSONObject jsonobject, boolean flag)
    {
        c = ttiezhiactivity;
        a = jsonobject;
        b = flag;
        super();
    }

    public void run()
    {
        boolean flag = false;
        c.t = true;
        c.G = true;
        if (!(a instanceof JSONObject) || a.length() <= 0) goto _L2; else goto _L1
_L1:
        JSONArray jsonarray = aqn.b(a, "data");
        if (jsonarray == null) goto _L4; else goto _L3
_L3:
        if (jsonarray.length() <= 0) goto _L4; else goto _L5
_L5:
        boolean flag1;
        TTieZhiActivity.i(c).clear();
        flag1 = b;
        Object obj;
        int i;
        if (!flag1)
        {
            try
            {
                TTieZhiActivity.j(c).c("json_tiezhiLibrary");
                TTieZhiActivity.j(c).a("json_tiezhiLibrary", a, 300);
            }
            catch (Error error) { }
            catch (Exception exception)
            {
                c.runOnUiThread(new avh(this));
                return;
            }
        }
        if (jsonarray == null) goto _L7; else goto _L6
_L6:
        if (jsonarray.length() <= 0) goto _L7; else goto _L8
_L8:
        i = 0;
_L17:
        if (i >= jsonarray.length()) goto _L7; else goto _L9
_L9:
        obj = aqn.a(jsonarray, i);
        if (obj == null) goto _L11; else goto _L10
_L10:
        if (!(obj instanceof JSONObject)) goto _L11; else goto _L12
_L12:
        obj = awb.a(((JSONObject) (obj)));
        if (obj == null) goto _L11; else goto _L13
_L13:
        if (((awk) (obj)).a != TTieZhiInfo.kTZRecommendTypeID);
        TTieZhiActivity.i(c).add(obj);
          goto _L11
_L7:
        TTieZhiActivity.k(c);
        TTieZhiActivity.i(c).add(awg.a().f());
        c.runOnUiThread(new avf(this));
        i = ((flag) ? 1 : 0);
_L15:
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_252;
        }
        c.runOnUiThread(new avg(this));
        return;
_L4:
        i = 1;
        continue; /* Loop/switch isn't completed */
_L2:
        i = 1;
        if (true) goto _L15; else goto _L14
_L14:
_L11:
        i++;
        if (true) goto _L17; else goto _L16
_L16:
    }
}

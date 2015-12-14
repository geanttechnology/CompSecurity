// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.sketch.activity;

import android.util.Log;
import com.fotoable.sketch.info.TTieZhiInfo;
import com.fotoable.sketch.view.TTieZhiMainLibraryView;
import java.util.List;
import jw;
import kv;
import ok;
import oo;
import or;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.fotoable.sketch.activity:
//            TTieZhiActivity

class a
    implements Runnable
{

    final umpToIndex a;

    public void run()
    {
        a.a.F = false;
        if (a.a)
        {
            a.a.c();
            return;
        } else
        {
            a.a.o.setIsFinishLoad(a.a.t);
            a.a.o.jumpToIndex(4);
            return;
        }
    }

    a(a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/fotoable/sketch/activity/TTieZhiActivity$8

/* anonymous class */
    class TTieZhiActivity._cls8
        implements Runnable
    {

        final JSONObject a;
        final boolean b;
        final TTieZhiActivity c;

        public void run()
        {
            boolean flag = false;
            c.t = true;
            c.F = true;
            if (!(a instanceof JSONObject) || a.length() <= 0) goto _L2; else goto _L1
_L1:
            JSONArray jsonarray = kv.b(a, "data");
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
                    c.runOnUiThread(new TTieZhiActivity._cls8._cls3(this));
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
            Log.e("TTieZhiActivity", (new StringBuilder()).append("dataArray.length::::").append(jsonarray.length()).toString());
            obj = kv.a(jsonarray, i);
            if (obj == null) goto _L11; else goto _L10
_L10:
            if (!(obj instanceof JSONObject)) goto _L11; else goto _L12
_L12:
            obj = ok.a(((JSONObject) (obj)));
            if (obj == null) goto _L11; else goto _L13
_L13:
            if (((or) (obj)).a != TTieZhiInfo.kTZRecommendTypeID);
            TTieZhiActivity.i(c).add(obj);
              goto _L11
_L7:
            TTieZhiActivity.k(c);
            TTieZhiActivity.i(c).add(oo.a().f());
            c.runOnUiThread(new TTieZhiActivity._cls8._cls1());
            i = ((flag) ? 1 : 0);
_L15:
            if (i == 0)
            {
                break MISSING_BLOCK_LABEL_280;
            }
            c.runOnUiThread(new TTieZhiActivity._cls8._cls2());
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

            
            {
                c = ttiezhiactivity;
                a = jsonobject;
                b = flag;
                super();
            }

        // Unreferenced inner class com/fotoable/sketch/activity/TTieZhiActivity$8$1

/* anonymous class */
        class TTieZhiActivity._cls8._cls1
            implements Runnable
        {

            final TTieZhiActivity._cls8 a;

            public void run()
            {
                a.c.F = false;
                if (a.c.o.getVisibility() == 0 && TTieZhiActivity.i(a.c).size() > 0)
                {
                    Log.e("TTieZhiActivity", "mainLibrary handleData");
                    a.c.o.setIsFinishLoad(a.c.t);
                    a.c.o.handleData(TTieZhiActivity.i(a.c));
                }
            }

                    
                    {
                        a = TTieZhiActivity._cls8.this;
                        super();
                    }
        }


        // Unreferenced inner class com/fotoable/sketch/activity/TTieZhiActivity$8$2

/* anonymous class */
        class TTieZhiActivity._cls8._cls2
            implements Runnable
        {

            final TTieZhiActivity._cls8 a;

            public void run()
            {
                a.c.F = false;
                if (a.b)
                {
                    a.c.c();
                    return;
                } else
                {
                    a.c.o.setIsFinishLoad(a.c.t);
                    a.c.o.jumpToIndex(4);
                    return;
                }
            }

                    
                    {
                        a = TTieZhiActivity._cls8.this;
                        super();
                    }
        }

    }

}

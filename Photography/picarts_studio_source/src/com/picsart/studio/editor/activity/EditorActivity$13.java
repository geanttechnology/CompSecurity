// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.activity;

import com.picsart.studio.EditingData;
import com.picsart.studio.editor.e;
import com.picsart.studio.utils.TimeCalculator;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.brushlib.util.b;
import com.socialin.android.facebook.util.FacebookUtils;
import com.socialin.android.util.ModernAsyncTask;
import myobfuscated.cv.c;
import myobfuscated.f.m;
import org.json.JSONObject;

// Referenced classes of package com.picsart.studio.editor.activity:
//            EditorActivity

final class b extends ModernAsyncTask
{

    private String a;
    private String b;
    private EditorActivity c;

    protected final Object doInBackground(Object aobj[])
    {
        com.socialin.android.brushlib.util.b.b(e.a().b, a);
        EditorActivity.d(c).b();
        aobj = e.a().e;
        aobj.i = (int)((long)((EditingData) (aobj)).i + EditorActivity.d(c).d());
        EditorActivity.d(c).a();
        String s = a;
        if (SocialinV3.getInstance().isRegistered())
        {
            aobj = String.valueOf(SocialinV3.getInstance().getUser().id);
        } else
        {
            aobj = null;
        }
        m.a(s, ((String) (aobj)), e.a().e.c().toString());
        return null;
    }

    protected final void onPostExecute(Object obj)
    {
        byte byte0;
        super.onPostExecute((Void)obj);
        obj = b;
        byte0 = -1;
        ((String) (obj)).hashCode();
        JVM INSTR lookupswitch 4: default 60
    //                   -1727082830: 151
    //                   1111669925: 109
    //                   1293361956: 137
    //                   1318040329: 123;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        byte0;
        JVM INSTR tableswitch 0 3: default 92
    //                   0 165
    //                   1 180
    //                   2 194
    //                   3 208;
           goto _L6 _L7 _L8 _L9 _L10
_L6:
        EditorActivity.a(c, true);
        c.e();
        return;
_L3:
        if (((String) (obj)).equals("button_postInstagram"))
        {
            byte0 = 0;
        }
          goto _L1
_L5:
        if (((String) (obj)).equals("button_postFB"))
        {
            byte0 = 1;
        }
          goto _L1
_L4:
        if (((String) (obj)).equals("button_tweet"))
        {
            byte0 = 2;
        }
          goto _L1
_L2:
        if (((String) (obj)).equals("button_uploadToPicsinId"))
        {
            byte0 = 3;
        }
          goto _L1
_L7:
        myobfuscated.cv.c.a(c, a);
          goto _L6
_L8:
        FacebookUtils.startAdapterActivity(c, a);
          goto _L6
_L9:
        myobfuscated.cv.c.a(a, c);
          goto _L6
_L10:
        myobfuscated.cv.c.a(c, a);
          goto _L6
    }

    protected final void onPreExecute()
    {
        super.onPreExecute();
        c.d();
    }

    (EditorActivity editoractivity, String s, String s1)
    {
        c = editoractivity;
        a = s;
        b = s1;
        super();
    }
}

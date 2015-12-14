// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.ResourceOnlineLibrary.Types;

import android.widget.Toast;
import com.pipcamera.application.PIPCameraApplication;
import com.wantu.ResourceOnlineLibrary.activity.MainResourceActivity;
import ew;
import java.util.ArrayList;
import jw;
import org.json.JSONException;
import org.json.JSONObject;
import ty;
import ue;

// Referenced classes of package com.wantu.ResourceOnlineLibrary.Types:
//            MaterialTypeFragement, SectionListAdapter

class a
    implements ue
{

    final MaterialTypeFragement a;

    public void a(String s)
    {
        if (MaterialTypeFragement.a(a) != null)
        {
            MaterialTypeFragement.a(a).e();
        }
        if (s == null || s.length() <= 0)
        {
            break MISSING_BLOCK_LABEL_159;
        }
        MaterialTypeFragement.a(a, Boolean.valueOf(true));
        if (s != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        try
        {
            s = new JSONObject(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            s = null;
        }
        MaterialTypeFragement.a(a, ty.a(s, MaterialTypeFragement.b(a)));
        if (MaterialTypeFragement.c(a) == null || MaterialTypeFragement.c(a).size() <= 0) goto _L1; else goto _L3
_L3:
        MaterialTypeFragement.e(a).c(MaterialTypeFragement.d(a));
        MaterialTypeFragement.e(a).a(MaterialTypeFragement.d(a), s, 300);
        MaterialTypeFragement.f(a).notifyDataSetChanged();
        return;
        s = "\u6570\u636E\u8BF7\u6C42\u5931\u8D25\uFF01";
        if (!ew.a())
        {
            s = "Request failed!";
        }
        Toast.makeText(PIPCameraApplication.a, s, 0).show();
        return;
    }

    (MaterialTypeFragement materialtypefragement)
    {
        a = materialtypefragement;
        super();
    }
}

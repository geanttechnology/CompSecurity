// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.obf;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.autoupdatesdk.AppUpdateInfo;
import com.baidu.autoupdatesdk.AppUpdateInfoForInstall;
import com.baidu.autoupdatesdk.CPCheckUpdateCallback;
import com.baidu.autoupdatesdk.ICallback;

// Referenced classes of package com.baidu.autoupdatesdk.obf:
//            j, e, af, i, 
//            an, ad

class a
    implements ICallback
{

    final Context a;
    final j b;

    public void a(int k, String s, AppUpdateInfo appupdateinfo)
    {
        s = null;
        if (k != 0 || appupdateinfo == null) goto _L2; else goto _L1
_L1:
        String s1 = e.a().a(a, appupdateinfo.getAppVersionCode() - 1, -1);
        if (!TextUtils.isEmpty(s1)) goto _L4; else goto _L3
_L3:
        if (appupdateinfo.getAppVersionCode() <= af.b(a)) goto _L2; else goto _L5
_L5:
        j.a(b).onCheckUpdateCallback(appupdateinfo, s);
        return;
_L4:
        if (!i.a())
        {
            s = an.b(a);
            if (s != null)
            {
                s.setInstallPath(ad.c(a, s1));
            }
            appupdateinfo = null;
            continue; /* Loop/switch isn't completed */
        }
_L2:
        appupdateinfo = null;
        if (true) goto _L5; else goto _L6
_L6:
    }

    public void onCallback(int k, String s, Object obj)
    {
        a(k, s, (AppUpdateInfo)obj);
    }

    eInfo(j j1, Context context)
    {
        b = j1;
        a = context;
        super();
    }
}

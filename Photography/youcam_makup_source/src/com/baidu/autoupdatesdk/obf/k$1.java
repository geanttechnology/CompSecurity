// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.obf;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.autoupdatesdk.AppUpdateInfo;
import com.baidu.autoupdatesdk.ICallback;

// Referenced classes of package com.baidu.autoupdatesdk.obf:
//            k, aj, e, af

class b
    implements ICallback
{

    final int a;
    final Context b;
    final k c;

    public void a(int i, String s, AppUpdateInfo appupdateinfo)
    {
label0:
        {
            if (i == 0 && appupdateinfo != null)
            {
                aj.a("BDAutoUpdateSDK", (new StringBuilder()).append("ignoreVersionCode: ").append(a).append(", newVersionCode: ").append(appupdateinfo.getAppVersionCode()).toString());
                s = e.a().a(b, appupdateinfo.getAppVersionCode() - 1, a);
                if (!TextUtils.isEmpty(s))
                {
                    break label0;
                }
                if (appupdateinfo.getAppVersionCode() > af.b(b) && appupdateinfo.getAppVersionCode() != a)
                {
                    k.a(c, b, appupdateinfo);
                }
            }
            return;
        }
        k.a(c, b, null, s);
    }

    public void onCallback(int i, String s, Object obj)
    {
        a(i, s, (AppUpdateInfo)obj);
    }

    eInfo(k k1, int i, Context context)
    {
        c = k1;
        a = i;
        b = context;
        super();
    }
}

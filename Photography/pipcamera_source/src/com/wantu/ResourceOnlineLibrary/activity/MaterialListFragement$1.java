// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.ResourceOnlineLibrary.activity;

import android.content.res.Resources;
import android.widget.Toast;
import com.wantu.ResourceOnlineLibrary.Model.OnlineResImageAdapter;
import com.wantu.model.res.TResInfo;
import com.wantu.model.res.pip.TDFSceneInfo;
import kf;
import ua;
import yf;

// Referenced classes of package com.wantu.ResourceOnlineLibrary.activity:
//            MaterialListFragement, MainResourceActivity, BaseOnlineFragement

class a
    implements ua
{

    final MaterialListFragement a;

    public void a(TResInfo tresinfo)
    {
        if (a.d != null)
        {
            a.d.a(a.d.getResources().getString(0x7f0600da), BaseOnlineFragement.e);
        }
    }

    public void a(TResInfo tresinfo, float f)
    {
    }

    public void a(TDFSceneInfo tdfsceneinfo)
    {
        if (a.d != null)
        {
            a.d.e();
            Toast.makeText(a.d, a.d.getResources().getString(0x7f0600d6), 0).show();
        }
        a.b.removeItem(tdfsceneinfo);
        a.a(tdfsceneinfo);
        tdfsceneinfo.setMode(MaterialListFragement.a(a));
        kf.c().d().a(tdfsceneinfo);
    }

    public void b(TResInfo tresinfo)
    {
        if (a.d != null)
        {
            a.d.e();
            Toast.makeText(a.d, a.d.getResources().getString(0x7f0600d7), 0).show();
        }
    }

    (MaterialListFragement materiallistfragement)
    {
        a = materiallistfragement;
        super();
    }
}

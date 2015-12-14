// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import android.app.Dialog;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.view.View;
import android.widget.AdapterView;
import com.cyberlink.beautycircle.BaseFbActivity;
import com.cyberlink.beautycircle.controller.adapter.ShareAdapter;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            ShareOutUtils

final class d
    implements android.widget.emClickListener
{

    final Dialog a;
    final ShareAdapter b;
    final BaseFbActivity c;
    final areInfo d;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        a.dismiss();
        adapterview = ((ResolveInfo)b.getItem(i)).activityInfo.packageName;
        ShareOutUtils.a(c, d, adapterview);
    }

    areInfo(Dialog dialog, ShareAdapter shareadapter, BaseFbActivity basefbactivity, areInfo areinfo)
    {
        a = dialog;
        b = shareadapter;
        c = basefbactivity;
        d = areinfo;
        super();
    }
}

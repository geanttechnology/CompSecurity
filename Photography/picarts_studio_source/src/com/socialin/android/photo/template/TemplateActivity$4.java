// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.template;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.socialin.android.activity.BaseActivity;
import java.util.List;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.photo.template:
//            TemplateActivity, TemplateView

final class a extends Thread
{

    private List a;
    private TemplateActivity b;

    public final void run()
    {
        String s = TemplateActivity.b(b).a(android.graphics.at.JPEG);
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.STREAM", Uri.parse((new StringBuilder("file://")).append(s).toString()));
        intent.setType("image/*");
        intent.putExtra("android.intent.extra.TEXT", "#PicsArt");
        intent.putExtra("subject", b.getString(0x7f08040b));
        intent.setClassName(((ResolveInfo)a.get(0)).activityInfo.packageName, ((ResolveInfo)a.get(0)).activityInfo.name);
        TemplateActivity.d(b).startActivity(intent);
        m.b(b, b.a);
    }

    (TemplateActivity templateactivity, List list)
    {
        b = templateactivity;
        a = list;
        super();
    }
}

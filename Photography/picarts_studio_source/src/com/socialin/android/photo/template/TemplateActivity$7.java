// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.template;

import com.socialin.android.facebook.util.FacebookUtils;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.photo.template:
//            TemplateActivity, TemplateView

final class a extends Thread
{

    private TemplateActivity a;

    public final void run()
    {
        TemplateActivity.a(com.facebook.tory.create());
        String s = TemplateActivity.b(a).a(android.graphics.at.JPEG);
        FacebookUtils.startAdapterActivity(a, s);
        m.b(a, a.a);
    }

    (TemplateActivity templateactivity)
    {
        a = templateactivity;
        super();
    }
}

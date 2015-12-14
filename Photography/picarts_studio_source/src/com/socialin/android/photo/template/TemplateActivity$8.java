// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.template;

import myobfuscated.cv.c;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.photo.template:
//            TemplateActivity, TemplateView

final class a extends Thread
{

    private TemplateActivity a;

    public final void run()
    {
        c.a(TemplateActivity.b(a).a(android.graphics.at.JPEG), a);
        m.b(a, a.a);
    }

    (TemplateActivity templateactivity)
    {
        a = templateactivity;
        super();
    }
}

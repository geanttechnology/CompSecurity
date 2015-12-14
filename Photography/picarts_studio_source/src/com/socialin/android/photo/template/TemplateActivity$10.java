// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.template;

import android.content.Intent;
import com.socialin.android.util.x;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.photo.template:
//            TemplateActivity, TemplateView

final class a extends Thread
{

    private TemplateActivity a;

    public final void run()
    {
        String s = TemplateActivity.b(a).a(android.graphics.t.PNG);
        if (s == null)
        {
            return;
        } else
        {
            x.a();
            s = x.a(s);
            Intent intent = new Intent();
            intent.putExtra("raw.data", s);
            a.setResult(-1, intent);
            a.finish();
            m.b(a, a.a);
            return;
        }
    }

    (TemplateActivity templateactivity)
    {
        a = templateactivity;
        super();
    }
}

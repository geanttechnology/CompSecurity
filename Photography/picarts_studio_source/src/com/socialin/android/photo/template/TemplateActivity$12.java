// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.template;

import com.socialin.android.colorpicker.c;

// Referenced classes of package com.socialin.android.photo.template:
//            TemplateActivity, TemplateView

final class a
    implements c
{

    private TemplateActivity a;

    public final void a(int i)
    {
        TemplateActivity.b(a).setBorderColor(i);
        com.socialin.android.photo.template.TemplateActivity.c(a);
    }

    (TemplateActivity templateactivity)
    {
        a = templateactivity;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio;

import myobfuscated.f.m;

// Referenced classes of package com.picsart.studio:
//            ImagePickerActivity

final class a
    implements Runnable
{

    private ImagePickerActivity a;

    public final void run()
    {
        m.a(a, ImagePickerActivity.f(a), true);
    }

    (ImagePickerActivity imagepickeractivity)
    {
        a = imagepickeractivity;
        super();
    }
}

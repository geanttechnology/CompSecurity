// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio;

import com.socialin.android.util.x;

// Referenced classes of package com.picsart.studio:
//            ImagePickerActivity

final class a extends Thread
{

    private ImagePickerActivity a;

    public final void run()
    {
label0:
        {
            if (ImagePickerActivity.i(a) != null)
            {
                ImagePickerActivity.a(a, ImagePickerActivity.i(a), ImagePickerActivity.j(a), null, null);
                if (!ImagePickerActivity.g(a))
                {
                    break label0;
                }
                x.a();
                String s = ImagePickerActivity.i(a);
                ImagePickerActivity.k(a);
                s = x.a(s, true);
                ImagePickerActivity.a(a, s, 0, 2, null, x.a("Google Drive", ImagePickerActivity.i(a)), "Google Drive");
            }
            return;
        }
        ImagePickerActivity.a(a, ImagePickerActivity.i(a), 0, 2, null, x.c("Google Drive"), "Google Drive");
    }

    (ImagePickerActivity imagepickeractivity)
    {
        a = imagepickeractivity;
        super();
    }
}

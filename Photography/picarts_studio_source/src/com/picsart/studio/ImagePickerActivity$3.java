// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio;

import android.widget.Toast;

// Referenced classes of package com.picsart.studio:
//            ImagePickerActivity

final class a
    implements Runnable
{

    private ImagePickerActivity a;

    public final void run()
    {
        Toast.makeText(a, 0x7f08023f, 1).show();
    }

    (ImagePickerActivity imagepickeractivity)
    {
        a = imagepickeractivity;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio;

import com.socialin.android.b;
import com.socialin.android.d;
import com.socialin.android.util.FileUtils;
import com.socialin.android.util.ae;
import com.socialin.android.util.s;
import com.socialin.android.util.x;
import java.io.File;
import java.io.IOException;
import myobfuscated.f.m;

// Referenced classes of package com.picsart.studio:
//            ImagePickerActivity

final class a extends Thread
{

    private String a;
    private ImagePickerActivity b;

    public final void run()
    {
        Object obj;
        obj = s.b(ImagePickerActivity.i(b));
        if (!ImagePickerActivity.g(b))
        {
            break MISSING_BLOCK_LABEL_110;
        }
        x.a();
        ImagePickerActivity.k(b);
        ImagePickerActivity.i(b);
        obj = x.a(((java.io.InputStream) (obj)));
        Object obj1;
        Object obj2;
        String s2;
        if (obj != null)
        {
            try
            {
                ImagePickerActivity imagepickeractivity = b;
                com.socialin.android.apiv3.model.ImageItem imageitem = ImagePickerActivity.j(b);
                String s1 = ImagePickerActivity.k(b);
                ImagePickerActivity.i(b);
                ImagePickerActivity.a(imagepickeractivity, ((String) (obj)), imageitem, x.c(s1), a);
                m.b(b, ImagePickerActivity.f(b));
                return;
            }
            catch (IOException ioexception)
            {
                d.b(ImagePickerActivity.a(), new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(ioexception.getMessage()).toString()
                });
            }
        }
        break MISSING_BLOCK_LABEL_274;
        obj1 = (new StringBuilder()).append(b.getString(0x7f0808fb)).append("/").append(b.getString(0x7f08096a)).toString();
        obj2 = b.a;
        obj = FileUtils.a(((String) (obj1)), ae.a(ImagePickerActivity.i(b)), ((java.io.InputStream) (obj)));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_274;
        }
        obj = ((File) (obj)).getPath();
        obj1 = b;
        obj2 = ImagePickerActivity.j(b);
        s2 = ImagePickerActivity.k(b);
        ImagePickerActivity.i(b);
        ImagePickerActivity.a(((ImagePickerActivity) (obj1)), ((String) (obj)), ((com.socialin.android.apiv3.model.ImageItem) (obj2)), x.a(s2, ((String) (obj))), a);
        m.b(b, ImagePickerActivity.f(b));
        return;
    }

    (ImagePickerActivity imagepickeractivity, String s1)
    {
        b = imagepickeractivity;
        a = s1;
        super();
    }
}

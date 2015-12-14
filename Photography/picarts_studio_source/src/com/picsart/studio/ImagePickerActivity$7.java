// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio;

import android.content.Intent;
import android.widget.Toast;
import com.socialin.android.b;
import com.socialin.android.d;
import com.socialin.android.util.FileUtils;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.ae;
import com.socialin.android.util.s;
import com.socialin.android.util.w;
import com.socialin.android.util.x;
import java.io.File;
import java.io.IOException;
import myobfuscated.f.m;

// Referenced classes of package com.picsart.studio:
//            ImagePickerActivity

final class  extends ModernAsyncTask
{

    final ImagePickerActivity a;
    private Intent b;

    private transient Void a()
    {
        Object obj;
        obj = w.a(a, b);
        if (obj == null || !((String) (obj)).startsWith("http"))
        {
            break MISSING_BLOCK_LABEL_200;
        }
        Object obj1;
        obj1 = s.b(((String) (obj)));
        if (!ImagePickerActivity.g(a))
        {
            break MISSING_BLOCK_LABEL_73;
        }
        x.a();
        obj1 = x.a(((java.io.InputStream) (obj1)));
        String s2;
        ae ae1;
        if (obj1 != null)
        {
            try
            {
                a.runOnUiThread(new Runnable(((String) (obj1)), ((String) (obj))) {

                    private String a;
                    private String b;
                    private ImagePickerActivity._cls7 c;

                    public final void run()
                    {
                        m.b(c.a, ImagePickerActivity.f(c.a));
                        ImagePickerActivity.h(c.a);
                        ImagePickerActivity.a(c.a, a, 0, 3, null, x.a("Remote album", b), "Remote album");
                    }

            
            {
                c = ImagePickerActivity._cls7.this;
                a = s1;
                b = s2;
                super();
            }
                });
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                d.b(ImagePickerActivity.a(), new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(((IOException) (obj)).getMessage()).toString()
                });
            }
        }
        break MISSING_BLOCK_LABEL_335;
        s2 = (new StringBuilder()).append(a.getString(0x7f0808fb)).append("/").append(a.getString(0x7f08096a)).toString();
        ae1 = b.a;
        obj = FileUtils.a(s2, ae.a(((String) (obj))), ((java.io.InputStream) (obj1)));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_335;
        }
        obj = ((File) (obj)).getPath();
        if (w.e(((String) (obj))))
        {
            a.runOnUiThread(new Runnable(((String) (obj))) {

                private String a;
                private ImagePickerActivity._cls7 b;

                public final void run()
                {
                    m.b(b.a, ImagePickerActivity.f(b.a));
                    ImagePickerActivity.h(b.a);
                    ImagePickerActivity.a(b.a, a, 0, 3, null, x.c("Remote album"), "Remote album");
                }

            
            {
                b = ImagePickerActivity._cls7.this;
                a = s1;
                super();
            }
            });
        }
        break MISSING_BLOCK_LABEL_335;
        if (w.e(((String) (obj))))
        {
            if (ImagePickerActivity.g(a))
            {
                int i = w.a(a, b, ((String) (obj)));
                x.a();
                String s1 = x.a(((String) (obj)), true);
                a.runOnUiThread(new Runnable(s1, i, ((String) (obj))) {

                    private String a;
                    private int b;
                    private String c;
                    private ImagePickerActivity._cls7 d;

                    public final void run()
                    {
                        m.b(d.a, ImagePickerActivity.f(d.a));
                        ImagePickerActivity.h(d.a);
                        ImagePickerActivity.a(d.a, a, b, 2, null, x.a("gallery", c), "gallery");
                    }

            
            {
                d = ImagePickerActivity._cls7.this;
                a = s1;
                b = i;
                c = s2;
                super();
            }
                });
            } else
            {
                int j = w.a(a, b, ((String) (obj)));
                a.runOnUiThread(new Runnable(((String) (obj)), j) {

                    private String a;
                    private int b;
                    private ImagePickerActivity._cls7 c;

                    public final void run()
                    {
                        m.b(c.a, ImagePickerActivity.f(c.a));
                        ImagePickerActivity.h(c.a);
                        ImagePickerActivity.a(c.a, a, b, 2, null, x.a("gallery", a), "gallery");
                    }

            
            {
                c = ImagePickerActivity._cls7.this;
                a = s1;
                b = i;
                super();
            }
                });
            }
        } else
        {
            m.b(a, ImagePickerActivity.f(a));
            ImagePickerActivity.h(a);
            a.runOnUiThread(new Runnable() {

                private ImagePickerActivity._cls7 a;

                public final void run()
                {
                    Toast.makeText(a.a, 0x7f08039c, 0).show();
                }

            
            {
                a = ImagePickerActivity._cls7.this;
                super();
            }
            });
        }
        return null;
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a();
    }

    _cls5.a(ImagePickerActivity imagepickeractivity, Intent intent)
    {
        a = imagepickeractivity;
        b = intent;
        super();
    }
}

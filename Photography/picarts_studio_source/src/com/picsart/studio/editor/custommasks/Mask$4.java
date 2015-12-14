// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.custommasks;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.b;
import com.bumptech.glide.j;
import com.bumptech.glide.k;
import com.bumptech.glide.load.engine.GlideException;
import com.socialin.android.util.FileUtils;
import java.io.File;
import myobfuscated.ag.f;
import myobfuscated.ah.e;

// Referenced classes of package com.picsart.studio.editor.custommasks:
//            Mask, c

final class a
    implements Runnable
{

    final c a;
    final Mask b;
    private Activity c;
    private String d;

    public final void run()
    {
        com.bumptech.glide.b.a(c).j().a(d).a(new f() {

            private Mask._cls4 a;

            public final void a(Object obj, e e)
            {
                obj = (File)obj;
                if (Mask.a(a.b) != null)
                {
                    FileUtils.b(((File) (obj)), Mask.a(a.b));
                }
                Mask.a(a.b, BitmapFactory.decodeFile(((File) (obj)).getAbsolutePath()));
                if (a.a != null)
                {
                    a.a.a(a.b);
                }
            }

            public final void c(Drawable drawable)
            {
                super.c(drawable);
                if (a.a != null)
                {
                    a.a.a(new GlideException("Error"));
                }
            }

            
            {
                a = Mask._cls4.this;
                super();
            }
        });
    }

    _cls1.a(Mask mask, Activity activity, String s, c c1)
    {
        b = mask;
        c = activity;
        d = s;
        a = c1;
        super();
    }
}

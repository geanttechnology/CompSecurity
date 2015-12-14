// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.morph;

import android.graphics.Bitmap;
import android.os.Handler;
import com.socialin.android.util.Utils;

// Referenced classes of package com.photo.morph:
//            StretchActivity

final class a
    implements Runnable
{

    final Bitmap a;
    final b b;

    public final void run()
    {
        if (a == null || a.isRecycled())
        {
            b.b.d();
            Utils.b(b.b, 0x7f080429);
            b.b.finish();
            return;
        } else
        {
            (new Handler()).post(new Runnable() {

                private StretchActivity._cls1._cls1 a;

                public final void run()
                {
                    StretchActivity.b(a.b.a);
                    StretchActivity.a(a.b.a, a.a);
                    StretchActivity.c(a.b.a);
                    StretchActivity.d(a.b.a);
                }

            
            {
                a = StretchActivity._cls1._cls1.this;
                super();
            }
            });
            return;
        }
    }

    _cls1.a(_cls1.a a1, Bitmap bitmap)
    {
        b = a1;
        a = bitmap;
        super();
    }

    // Unreferenced inner class com/photo/morph/StretchActivity$1

/* anonymous class */
    final class StretchActivity._cls1
        implements Runnable
    {

        final StretchActivity a;

        public final void run()
        {
            Bitmap bitmap = StretchActivity.a(a);
            a.runOnUiThread(new StretchActivity._cls1._cls1(this, bitmap));
        }

            
            {
                a = stretchactivity;
                super();
            }
    }

}

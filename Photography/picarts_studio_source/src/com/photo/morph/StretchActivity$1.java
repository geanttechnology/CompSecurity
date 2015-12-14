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

    final StretchActivity a;

    public final void run()
    {
        Bitmap bitmap = StretchActivity.a(a);
        a.runOnUiThread(new Runnable(bitmap) {

            final Bitmap a;
            final StretchActivity._cls1 b;

            public final void run()
            {
                if (a == null || a.isRecycled())
                {
                    b.a.d();
                    Utils.b(b.a, 0x7f080429);
                    b.a.finish();
                    return;
                } else
                {
                    (new Handler()).post(new Runnable(this) {

                        private _cls1 a;

                        public final void run()
                        {
                            StretchActivity.b(a.b.a);
                            StretchActivity.a(a.b.a, a.a);
                            StretchActivity.c(a.b.a);
                            StretchActivity.d(a.b.a);
                        }

            
            {
                a = _pcls1;
                super();
            }
                    });
                    return;
                }
            }

            
            {
                b = StretchActivity._cls1.this;
                a = bitmap;
                super();
            }
        });
    }

    _cls1.a(StretchActivity stretchactivity)
    {
        a = stretchactivity;
        super();
    }
}

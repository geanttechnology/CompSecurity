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

    private a a;

    public final void run()
    {
        StretchActivity.b(a.a.a);
        StretchActivity.a(a.a.a, a.a);
        StretchActivity.c(a.a.a);
        StretchActivity.d(a.a.a);
    }

    ( )
    {
        a = ;
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


    // Unreferenced inner class com/photo/morph/StretchActivity$1$1

/* anonymous class */
    final class StretchActivity._cls1._cls1
        implements Runnable
    {

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
                (new Handler()).post(new StretchActivity._cls1._cls1._cls1(this));
                return;
            }
        }

            
            {
                b = _pcls1;
                a = bitmap;
                super();
            }
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.morph;

import android.os.Handler;

// Referenced classes of package com.photo.morph:
//            StretchActivity

final class a
    implements Runnable
{

    final StretchActivity a;

    public final void run()
    {
        (new Handler()).post(new Runnable() {

            private StretchActivity._cls7 a;

            public final void run()
            {
                StretchActivity.A(a.a);
            }

            
            {
                a = StretchActivity._cls7.this;
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

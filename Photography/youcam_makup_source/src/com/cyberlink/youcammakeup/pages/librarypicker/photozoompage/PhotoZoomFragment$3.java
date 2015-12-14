// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage;

import android.app.Activity;
import android.view.View;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.clflurry.YMKLivePhotoEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.dialogs.w;

// Referenced classes of package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage:
//            PhotoZoomFragment

class a
    implements android.view.
{

    final PhotoZoomFragment a;

    public void onClick(View view)
    {
        b.a(new YMKLivePhotoEvent(com.cyberlink.youcammakeup.clflurry.eration.d));
        view = a.getActivity();
        o o1 = Globals.d().i();
        o1.c(view);
        o1.d(view);
        o1.a(new w(o1, view) {

            final o a;
            final Activity b;
            final PhotoZoomFragment._cls3 c;

            public void a(boolean flag)
            {
                a.i(b);
                com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.PhotoZoomFragment.b(c.a);
            }

            public void b(boolean flag)
            {
                a.i(b);
            }

            
            {
                c = PhotoZoomFragment._cls3.this;
                a = o1;
                b = activity;
                super();
            }
        });
    }

    _cls1.b(PhotoZoomFragment photozoomfragment)
    {
        a = photozoomfragment;
        super();
    }
}

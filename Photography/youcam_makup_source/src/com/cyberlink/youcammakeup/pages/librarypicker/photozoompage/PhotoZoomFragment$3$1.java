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

class b
    implements w
{

    final o a;
    final Activity b;
    final b c;

    public void a(boolean flag)
    {
        a.i(b);
        com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.PhotoZoomFragment.b(c.c);
    }

    public void b(boolean flag)
    {
        a.i(b);
    }

    ( , o o1, Activity activity)
    {
        c = ;
        a = o1;
        b = activity;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/pages/librarypicker/photozoompage/PhotoZoomFragment$3

/* anonymous class */
    class PhotoZoomFragment._cls3
        implements android.view.View.OnClickListener
    {

        final PhotoZoomFragment a;

        public void onClick(View view)
        {
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKLivePhotoEvent(com.cyberlink.youcammakeup.clflurry.YMKLivePhotoEvent.Operation.d));
            view = a.getActivity();
            o o1 = Globals.d().i();
            o1.c(view);
            o1.d(view);
            o1.a(new PhotoZoomFragment._cls3._cls1(this, o1, view));
        }

            
            {
                a = photozoomfragment;
                super();
            }
    }

}

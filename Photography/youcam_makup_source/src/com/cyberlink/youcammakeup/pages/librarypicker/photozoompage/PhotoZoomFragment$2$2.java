// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.c;
import com.cyberlink.youcammakeup.clflurry.YMKLivePhotoEvent;
import com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.database.o;
import com.cyberlink.youcammakeup.database.p;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.m;
import java.io.File;
import java.util.UUID;

// Referenced classes of package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage:
//            PhotoZoomFragment

class a extends j
{

    final a a;

    protected Boolean a(Void void1)
    {
        void1 = c.f();
        if (void1.d(a.a.a()) == null)
        {
            return Boolean.valueOf(false);
        }
        if (!(new File(void1.b(a.a.a()).b())).exists())
        {
            return Boolean.valueOf(false);
        } else
        {
            return Boolean.valueOf(true);
        }
    }

    protected volatile Object a(Object obj)
    {
        return a((Void)obj);
    }

    a(a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/pages/librarypicker/photozoompage/PhotoZoomFragment$2

/* anonymous class */
    class PhotoZoomFragment._cls2
        implements android.view.View.OnClickListener
    {

        final PhotoZoomFragment a;

        public void onClick(View view)
        {
            b.a(new YMKLivePhotoEvent(com.cyberlink.youcammakeup.clflurry.YMKLivePhotoEvent.Operation.b));
            YMKSavingPageEvent.b(com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.Source.b.a());
            (new PhotoZoomFragment._cls2._cls2(this)).d(null).a(new PhotoZoomFragment._cls2._cls1());
        }

            
            {
                a = photozoomfragment;
                super();
            }

        // Unreferenced inner class com/cyberlink/youcammakeup/pages/librarypicker/photozoompage/PhotoZoomFragment$2$1

/* anonymous class */
        class PhotoZoomFragment._cls2._cls1 extends m
        {

            final PhotoZoomFragment._cls2 a;

            protected void a(Boolean boolean1)
            {
                if (boolean1.booleanValue())
                {
                    boolean1 = a.a.getActivity();
                    if (boolean1 != null)
                    {
                        StatusManager.j().b(PhotoZoomFragment.a(a.a));
                        StatusManager.j().a(a.a.a(), UUID.randomUUID());
                        Intent intent = (new Intent(a.a.getActivity(), com/cyberlink/youcammakeup/activity/EditViewActivity)).setFlags(0x4000000);
                        intent.putExtra("ShowZooView", true);
                        boolean1.startActivity(intent);
                        boolean1.finish();
                    }
                    return;
                } else
                {
                    boolean1 = a.a.getString(0x7f070060);
                    Toast.makeText(a.a.getActivity(), boolean1, 1).show();
                    return;
                }
            }

            protected void b(Object obj)
            {
                a((Boolean)obj);
            }

                    
                    {
                        a = PhotoZoomFragment._cls2.this;
                        super();
                    }
        }

    }

}

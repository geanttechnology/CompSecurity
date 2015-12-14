// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photoselector.activity;

import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import com.fotoable.photoselector.ui.PhotoColletionListFragment;

// Referenced classes of package com.fotoable.photoselector.activity:
//            PhotoSelectorActivity

class a
    implements Runnable
{

    final boolean a;
    final Loss b;

    public void run()
    {
        PhotoSelectorActivity.c(b.b);
        if (a && !b.b.isFinishing())
        {
            PhotoColletionListFragment photocolletionlistfragment = PhotoColletionListFragment.a("collection");
            FragmentTransaction fragmenttransaction = b.b.getSupportFragmentManager().beginTransaction();
            fragmenttransaction.add(com.fotoable.fotophotoselector.t, photocolletionlistfragment, "collection");
            PhotoSelectorActivity.a(b.b, ragment.folder);
            fragmenttransaction.commitAllowingStateLoss();
            return;
        } else
        {
            Log.e("PhotoSelectorActivity", "Load media data failed");
            return;
        }
    }

    ragment(ragment ragment, boolean flag)
    {
        b = ragment;
        a = flag;
        super();
    }

    // Unreferenced inner class com/fotoable/photoselector/activity/PhotoSelectorActivity$2

/* anonymous class */
    class PhotoSelectorActivity._cls2
        implements Runnable
    {

        final boolean a;
        final PhotoSelectorActivity b;

        public void run()
        {
            boolean flag = a;
            (new Handler()).post(new PhotoSelectorActivity._cls2._cls1(this, flag));
        }

            
            {
                b = photoselectoractivity;
                a = flag;
                super();
            }
    }

}

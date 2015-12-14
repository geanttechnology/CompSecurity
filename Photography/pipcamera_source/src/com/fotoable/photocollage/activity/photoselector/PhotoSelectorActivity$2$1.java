// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photocollage.activity.photoselector;

import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import com.crashlytics.android.Crashlytics;
import com.fotoable.photoselector.ui.PhotoColletionListFragment;
import com.pipcamera.activity.photoselector.CurFragment;

// Referenced classes of package com.fotoable.photocollage.activity.photoselector:
//            PhotoSelectorActivity

class a
    implements Runnable
{

    final boolean a;
    final b b;

    public void run()
    {
        PhotoSelectorActivity.c(b.b);
        if (a)
        {
            PhotoColletionListFragment photocolletionlistfragment = PhotoColletionListFragment.a("collection");
            FragmentTransaction fragmenttransaction = b.b.getSupportFragmentManager().beginTransaction();
            fragmenttransaction.add(0x7f0c0084, photocolletionlistfragment, "collection");
            PhotoSelectorActivity.a(b.b, CurFragment.folder);
            try
            {
                fragmenttransaction.commitAllowingStateLoss();
                return;
            }
            catch (Exception exception)
            {
                Crashlytics.logException(exception);
            }
            return;
        } else
        {
            Log.e("PhotoSelectorActivity", "Load media data failed");
            return;
        }
    }

    ( , boolean flag)
    {
        b = ;
        a = flag;
        super();
    }

    // Unreferenced inner class com/fotoable/photocollage/activity/photoselector/PhotoSelectorActivity$2

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

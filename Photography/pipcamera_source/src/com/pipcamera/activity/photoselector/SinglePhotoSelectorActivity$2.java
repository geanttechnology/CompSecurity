// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.photoselector;

import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import com.crashlytics.android.Crashlytics;
import com.fotoable.photoselector.ui.PhotoColletionListFragment;

// Referenced classes of package com.pipcamera.activity.photoselector:
//            SinglePhotoSelectorActivity, CurFragment

class a
    implements Runnable
{

    final boolean a;
    final SinglePhotoSelectorActivity b;

    public void run()
    {
        boolean flag = a;
        (new Handler()).post(new Runnable(flag) {

            final boolean a;
            final SinglePhotoSelectorActivity._cls2 b;

            public void run()
            {
                SinglePhotoSelectorActivity.c(b.b);
                if (a && !SinglePhotoSelectorActivity.d(b.b))
                {
                    PhotoColletionListFragment photocolletionlistfragment = PhotoColletionListFragment.a("collection");
                    FragmentTransaction fragmenttransaction = b.b.getSupportFragmentManager().beginTransaction();
                    fragmenttransaction.add(0x7f0c0084, photocolletionlistfragment, "collection");
                    SinglePhotoSelectorActivity.a(b.b, CurFragment.folder);
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

            
            {
                b = SinglePhotoSelectorActivity._cls2.this;
                a = flag;
                super();
            }
        });
    }

    _cls1.a(SinglePhotoSelectorActivity singlephotoselectoractivity, boolean flag)
    {
        b = singlephotoselectoractivity;
        a = flag;
        super();
    }
}

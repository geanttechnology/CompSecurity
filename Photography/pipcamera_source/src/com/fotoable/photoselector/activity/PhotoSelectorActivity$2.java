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
    final PhotoSelectorActivity b;

    public void run()
    {
        boolean flag = a;
        (new Handler()).post(new Runnable(flag) {

            final boolean a;
            final PhotoSelectorActivity._cls2 b;

            public void run()
            {
                PhotoSelectorActivity.c(b.b);
                if (a && !b.b.isFinishing())
                {
                    PhotoColletionListFragment photocolletionlistfragment = PhotoColletionListFragment.a("collection");
                    FragmentTransaction fragmenttransaction = b.b.getSupportFragmentManager().beginTransaction();
                    fragmenttransaction.add(com.fotoable.fotophotoselector.R.id.encryptActivityContent, photocolletionlistfragment, "collection");
                    PhotoSelectorActivity.a(b.b, PhotoSelectorActivity.CurFragment.folder);
                    fragmenttransaction.commitAllowingStateLoss();
                    return;
                } else
                {
                    Log.e("PhotoSelectorActivity", "Load media data failed");
                    return;
                }
            }

            
            {
                b = PhotoSelectorActivity._cls2.this;
                a = flag;
                super();
            }
        });
    }

    _cls1.a(PhotoSelectorActivity photoselectoractivity, boolean flag)
    {
        b = photoselectoractivity;
        a = flag;
        super();
    }
}

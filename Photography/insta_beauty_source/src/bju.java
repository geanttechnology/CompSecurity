// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import com.fotoable.photoselector.ui.PhotoColletionListFragment;
import com.wantu.activity.photoselector.SinglePhotoSelectorActivity;

class bju
    implements Runnable
{

    final boolean a;
    final bjt b;

    bju(bjt bjt1, boolean flag)
    {
        b = bjt1;
        a = flag;
        super();
    }

    public void run()
    {
        SinglePhotoSelectorActivity.c(b.b);
        if (a)
        {
            PhotoColletionListFragment photocolletionlistfragment = PhotoColletionListFragment.a("collection");
            FragmentTransaction fragmenttransaction = b.b.getSupportFragmentManager().beginTransaction();
            fragmenttransaction.add(0x7f0d010d, photocolletionlistfragment, "collection");
            SinglePhotoSelectorActivity.a(b.b, com.wantu.activity.photoselector.SinglePhotoSelectorActivity.CurFragment.folder);
            fragmenttransaction.commitAllowingStateLoss();
            return;
        }
        try
        {
            Log.e("SinglePhotoSelectorActivity", "Load media data failed");
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return;
    }
}

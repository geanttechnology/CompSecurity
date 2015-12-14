// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import com.fotoable.photoselector.activity.PhotoSelectorActivity;
import com.fotoable.photoselector.ui.PhotoColletionListFragment;

class asc
    implements Runnable
{

    final boolean a;
    final asb b;

    asc(asb asb1, boolean flag)
    {
        b = asb1;
        a = flag;
        super();
    }

    public void run()
    {
        PhotoSelectorActivity.c(b.b);
        if (a && !b.b.isFinishing())
        {
            PhotoColletionListFragment photocolletionlistfragment = PhotoColletionListFragment.a("collection");
            FragmentTransaction fragmenttransaction = b.b.getSupportFragmentManager().beginTransaction();
            fragmenttransaction.add(aeh.encryptActivityContent, photocolletionlistfragment, "collection");
            PhotoSelectorActivity.a(b.b, com.fotoable.photoselector.activity.PhotoSelectorActivity.CurFragment.folder);
            fragmenttransaction.commitAllowingStateLoss();
            return;
        } else
        {
            Log.e("PhotoSelectorActivity", "Load media data failed");
            return;
        }
    }
}

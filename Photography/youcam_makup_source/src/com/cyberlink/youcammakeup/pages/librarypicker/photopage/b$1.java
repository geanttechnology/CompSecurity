// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker.photopage;

import android.app.FragmentManager;
import android.view.View;
import com.cyberlink.youcammakeup.activity.LibraryPickerActivity;
import com.cyberlink.youcammakeup.c;
import com.cyberlink.youcammakeup.database.n;
import com.cyberlink.youcammakeup.pages.librarypicker.LibraryViewFragment;
import com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.PhotoZoomFragment;

// Referenced classes of package com.cyberlink.youcammakeup.pages.librarypicker.photopage:
//            b, a

class a
    implements android.view..OnClickListener
{

    final b a;

    public void onClick(View view)
    {
        view = (LibraryPickerActivity)b.a(a);
        ((PhotoZoomFragment)view.getFragmentManager().findFragmentById(0x7f0c05b7)).a(c.e().a(a.e.a()).longValue(), a.e.b());
        ((LibraryViewFragment)view.getFragmentManager().findFragmentById(0x7f0c0158)).a(c.e().a(a.e.a()).longValue(), a.e.b());
    }

    gment(b b1)
    {
        a = b1;
        super();
    }
}

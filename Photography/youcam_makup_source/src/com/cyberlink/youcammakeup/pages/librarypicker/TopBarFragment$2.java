// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker;

import android.app.FragmentManager;
import android.view.View;
import com.cyberlink.youcammakeup.activity.LibraryPickerActivity;
import com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.PhotoZoomFragment;

// Referenced classes of package com.cyberlink.youcammakeup.pages.librarypicker:
//            TopBarFragment, PickedFragment

class a
    implements android.view.ner
{

    final TopBarFragment a;

    public void onClick(View view)
    {
        view = (LibraryPickerActivity)a.getActivity();
        if (view != null && view.j().d() && !view.o())
        {
            view = (PhotoZoomFragment)view.getFragmentManager().findFragmentById(0x7f0c05b7);
            PickedFragment pickedfragment = (PickedFragment)a.getFragmentManager().findFragmentById(0x7f0c0157);
            if (view != null && pickedfragment != null)
            {
                pickedfragment.b(view.a());
            }
        }
    }

    toZoomFragment(TopBarFragment topbarfragment)
    {
        a = topbarfragment;
        super();
    }
}

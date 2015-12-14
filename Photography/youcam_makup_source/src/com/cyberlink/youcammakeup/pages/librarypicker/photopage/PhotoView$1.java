// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker.photopage;

import android.app.FragmentManager;
import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import com.cyberlink.youcammakeup.activity.LibraryPickerActivity;
import com.cyberlink.youcammakeup.database.r;
import com.cyberlink.youcammakeup.database.s;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.pages.librarypicker.LibraryViewFragment;
import com.cyberlink.youcammakeup.pages.librarypicker.PickedFragment;

// Referenced classes of package com.cyberlink.youcammakeup.pages.librarypicker.photopage:
//            PhotoView, b, a

class a
    implements android.widget.OnItemClickListener
{

    final Context a;
    final PhotoView b;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (LibraryPickerActivity)a;
        view = (b)view;
        l = view.getItem().b();
        if (!b.b) goto _L2; else goto _L1
_L1:
        if (adapterview != null)
        {
            ((LibraryViewFragment)adapterview.getFragmentManager().findFragmentById(0x7f0c0158)).a(StatusManager.j().p(), l);
        }
_L4:
        return;
_L2:
        if (!s.a(a, l))
        {
            continue; /* Loop/switch isn't completed */
        }
        StatusManager.j().F();
        StatusManager.j().a(b.getFirstVisiblePosition());
        if (!adapterview.j().d())
        {
            break; /* Loop/switch isn't completed */
        }
        if (adapterview.b(1))
        {
            ((PickedFragment)adapterview.getFragmentManager().findFragmentById(0x7f0c0157)).a(view);
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        view = s.a(l);
        if (view != null)
        {
            adapterview.b(view.w());
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    (PhotoView photoview, Context context)
    {
        b = photoview;
        a = context;
        super();
    }
}

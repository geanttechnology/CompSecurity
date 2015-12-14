// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.ResourceOnlineLibrary.Manage;

import android.content.res.Resources;
import android.view.ViewTreeObserver;
import android.widget.ListView;

// Referenced classes of package com.wantu.ResourceOnlineLibrary.Manage:
//            ManageOnlineFragement, SectionGridViewAdapter

class a
    implements android.view.lLayoutListener
{

    final ManageOnlineFragement a;

    public void onGlobalLayout()
    {
        ManageOnlineFragement.a(a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
        ManageOnlineFragement.a(a).getWidth();
        ManageOnlineFragement.a(a, ManageOnlineFragement.b(a));
        ManageOnlineFragement.b(a, a.getResources().getDimensionPixelSize(0x7f08004a));
        ManageOnlineFragement.c(a, a.getResources().getDimensionPixelSize(0x7f080047));
        ManageOnlineFragement.a(a, new SectionGridViewAdapter(a.getActivity(), ManageOnlineFragement.c(a), ManageOnlineFragement.a(a).getWidth(), ManageOnlineFragement.a(a).getHeight(), ManageOnlineFragement.d(a), ManageOnlineFragement.e(a)));
        ManageOnlineFragement.f(a).setItemListener(a);
        ManageOnlineFragement.a(a).setAdapter(ManageOnlineFragement.f(a));
        ManageOnlineFragement.a(a).setDividerHeight(ManageOnlineFragement.f(a).gapBetweenChildrenInRow());
    }

    (ManageOnlineFragement manageonlinefragement)
    {
        a = manageonlinefragement;
        super();
    }
}

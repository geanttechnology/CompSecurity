// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.Resources;
import android.view.ViewTreeObserver;
import android.widget.ListView;
import com.wantu.ResourceOnlineLibrary.Manage.ManageOnlineFragement;
import com.wantu.ResourceOnlineLibrary.Manage.SectionGridViewAdapter;

public class bfv
    implements android.view.ViewTreeObserver.OnGlobalLayoutListener
{

    final ManageOnlineFragement a;

    public bfv(ManageOnlineFragement manageonlinefragement)
    {
        a = manageonlinefragement;
        super();
    }

    public void onGlobalLayout()
    {
        ManageOnlineFragement.a(a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
        ManageOnlineFragement.a(a).getWidth();
        ManageOnlineFragement.a(a, ManageOnlineFragement.b(a));
        ManageOnlineFragement.b(a, a.getResources().getDimensionPixelSize(0x7f080058));
        ManageOnlineFragement.c(a, a.getResources().getDimensionPixelSize(0x7f080056));
        ManageOnlineFragement.a(a, new SectionGridViewAdapter(a.getActivity(), ManageOnlineFragement.c(a), ManageOnlineFragement.a(a).getWidth(), ManageOnlineFragement.a(a).getHeight(), ManageOnlineFragement.d(a), ManageOnlineFragement.e(a)));
        ManageOnlineFragement.f(a).setItemListener(a);
        ManageOnlineFragement.a(a).setAdapter(ManageOnlineFragement.f(a));
        ManageOnlineFragement.a(a).setDividerHeight(ManageOnlineFragement.f(a).gapBetweenChildrenInRow());
    }
}

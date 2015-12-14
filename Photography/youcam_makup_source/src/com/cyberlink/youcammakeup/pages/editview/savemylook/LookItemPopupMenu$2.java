// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.editview.savemylook;

import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.pages.editview.savemylook:
//            LookItemPopupMenu, a

class a
    implements android.view.
{

    final LookItemPopupMenu a;

    public void onClick(View view)
    {
        if (LookItemPopupMenu.c(a) == null)
        {
            LookItemPopupMenu.d(a);
            return;
        }
        if (view != LookItemPopupMenu.e(a)) goto _L2; else goto _L1
_L1:
        LookItemPopupMenu.c(a).a(LookItemPopupMenu.b(a), tion.a);
_L4:
        LookItemPopupMenu.d(a);
        return;
_L2:
        if (view == LookItemPopupMenu.f(a))
        {
            LookItemPopupMenu.c(a).a(LookItemPopupMenu.b(a), tion.b);
        } else
        if (view == LookItemPopupMenu.g(a))
        {
            LookItemPopupMenu.c(a).a(LookItemPopupMenu.b(a), tion.c);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    tion(LookItemPopupMenu lookitempopupmenu)
    {
        a = lookitempopupmenu;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.editview.savemylook;

import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.pages.editview.savemylook:
//            LookItemPopupMenu

class a
    implements android.view.istener
{

    final LookItemPopupMenu a;

    public void onLayoutChange(View view, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1)
    {
        LookItemPopupMenu.a(a).removeOnLayoutChangeListener(this);
        LookItemPopupMenu.a(a).setX(LookItemPopupMenu.b(a).getX() - (float)((LookItemPopupMenu.a(a).getWidth() - LookItemPopupMenu.b(a).getWidth()) / 2));
    }

    (LookItemPopupMenu lookitempopupmenu)
    {
        a = lookitempopupmenu;
        super();
    }
}

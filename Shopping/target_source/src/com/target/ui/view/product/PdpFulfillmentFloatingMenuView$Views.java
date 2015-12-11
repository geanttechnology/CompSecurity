// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.view.View;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.target.ui.view.a;

// Referenced classes of package com.target.ui.view.product:
//            PdpFulfillmentFloatingMenuView, ProductFulfillmentFloatingActionButton

static class rootView extends a
{

    ProductFulfillmentFloatingActionButton addToListBtn;
    ProductFulfillmentFloatingActionButton emailBtn;
    ProductFulfillmentFloatingActionButton fiatsBtn;
    ProductFulfillmentFloatingActionButton mailBtn;
    ProductFulfillmentFloatingActionButton pickUpBtn;
    FloatingActionsMenu rootMenu;
    final View rootView;
    ProductFulfillmentFloatingActionButton shipMeBtn;
    ProductFulfillmentFloatingActionButton smsBtn;

    public n(View view)
    {
        super(view);
        rootView = view;
    }
}

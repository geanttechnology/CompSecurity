// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.departments;

import android.widget.ImageView;

// Referenced classes of package com.ebay.mobile.home.departments:
//            DepartmentNameViewHolder

class this._cls0
    implements Runnable
{

    final DepartmentNameViewHolder this$0;

    public void run()
    {
        arrowView.setTranslationX(-arrowView.getWidth());
        arrowView.setAlpha(0.0F);
        arrowView.setVisibility(0);
    }

    A()
    {
        this$0 = DepartmentNameViewHolder.this;
        super();
    }
}

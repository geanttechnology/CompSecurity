// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.common;

import android.view.View;

// Referenced classes of package com.target.ui.fragment.product.common:
//            BaseProductReviewFragment

private class errorContainer
{

    final View content;
    final View errorContainer;
    final View loader;
    final BaseProductReviewFragment this$0;

    (View view)
    {
        this$0 = BaseProductReviewFragment.this;
        super();
        content = view.findViewById(r());
        loader = view.findViewById(s());
        errorContainer = view.findViewById(t());
    }
}

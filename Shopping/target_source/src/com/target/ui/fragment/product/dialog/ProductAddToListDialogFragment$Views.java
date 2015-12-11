// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.dialog;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import com.target.ui.view.a;
import com.target.ui.view.product.ProductAddToListFooter;

// Referenced classes of package com.target.ui.fragment.product.dialog:
//            ProductAddToListDialogFragment

static class footer extends a
{

    Button cancelBtn;
    Button doneBtn;
    ProductAddToListFooter footer;
    ListView listView;

    public (Context context, View view)
    {
        super(view);
        footer = new ProductAddToListFooter(context);
    }
}

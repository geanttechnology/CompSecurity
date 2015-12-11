// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.j;

import android.view.View;
import com.target.ui.view.BitmapImageView;

// Referenced classes of package com.target.ui.adapter.j:
//            a

class geView
    implements android.view..OnClickListener
{

    final a this$0;
    final BitmapImageView val$image;
    final int val$position;

    public void onClick(View view)
    {
        if (a.a(a.this) != null)
        {
            a.a(a.this).a(getItem(val$position), val$image, DEFAULT);
        }
    }

    geView()
    {
        this$0 = final_a1;
        val$position = i;
        val$image = BitmapImageView.this;
        super();
    }
}

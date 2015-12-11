// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.b;

import android.view.View;
import com.target.ui.view.ScalableImageView;

// Referenced classes of package com.target.ui.adapter.b:
//            b

class val.position
    implements android.view..OnClickListener
{

    final b this$0;
    final ScalableImageView val$imageView;
    final int val$position;

    public void onClick(View view)
    {
        if (val$imageView.b())
        {
            val$imageView.a(true);
        }
        if (b.a(b.this) != null)
        {
            b.a(b.this).a(val$position);
        }
    }

    mageView()
    {
        this$0 = final_b1;
        val$imageView = scalableimageview;
        val$position = I.this;
        super();
    }
}

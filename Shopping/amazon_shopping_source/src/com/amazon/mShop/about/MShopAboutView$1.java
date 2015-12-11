// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.about;

import android.content.Context;
import android.view.View;
import android.widget.Toast;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.Util;

// Referenced classes of package com.amazon.mShop.about:
//            MShopAboutView

class this._cls0
    implements android.view.ner
{

    final MShopAboutView this$0;

    public void onClick(View view)
    {
        view = (Context)com.amazon.mShop.platform.getInstance().getApplicationContext();
        int _tmp = MShopAboutView.access$008(MShopAboutView.this);
        if (MShopAboutView.access$000(MShopAboutView.this) == 5)
        {
            MShopAboutView.access$002(MShopAboutView.this, 0);
            String s = com.amazon.mShop.platform.getInstance().getApplicationId();
            if (!Util.isEmpty(s))
            {
                Toast.makeText(view, s.replace(";", "\n"), 1).show();
            }
        }
    }

    ry()
    {
        this$0 = MShopAboutView.this;
        super();
    }
}

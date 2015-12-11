// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.View;
import com.groupon.activity.IntentFactory;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.fragment:
//            Goods

private class this._cls0
    implements android.view.istener
{

    final Goods this$0;

    public void onClick(View view)
    {
        startActivityForResult(((IntentFactory)intentFactory.get()).newGoodsCategoriesIntent(0, 0), 10101);
    }

    private _cls9()
    {
        this$0 = Goods.this;
        super();
    }
}

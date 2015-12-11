// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.cvsd;

import android.content.DialogInterface;
import com.amazon.mShop.platform.Platform;
import com.amazon.rio.j2me.client.persistence.DataStore;

// Referenced classes of package com.amazon.mShop.cvsd:
//            CVSDMapActivity

class this._cls0
    implements android.content.ClickListener
{

    final CVSDMapActivity this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (i == -2)
        {
            CVSDMapActivity.access$000(CVSDMapActivity.this);
        } else
        if (i == -1)
        {
            com.amazon.mShop.platform.etInstance().getDataStore().putBoolean("allowUseUserCurrentlocation", true);
            CVSDMapActivity.access$400(CVSDMapActivity.this);
            return;
        }
    }

    ataStore()
    {
        this$0 = CVSDMapActivity.this;
        super();
    }
}

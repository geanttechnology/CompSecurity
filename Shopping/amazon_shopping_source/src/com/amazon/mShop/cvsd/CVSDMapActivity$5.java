// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.cvsd;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import java.util.List;

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
            dialoginterface = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
            List list = getPackageManager().queryIntentActivities(dialoginterface, 0x10000);
            if (list != null && list.size() > 0)
            {
                startActivityForResult(dialoginterface, 9);
                return;
            } else
            {
                CVSDMapActivity.access$500(CVSDMapActivity.this);
                return;
            }
        }
    }

    istener()
    {
        this$0 = CVSDMapActivity.this;
        super();
    }
}

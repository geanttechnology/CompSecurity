// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.cvsd;

import android.content.DialogInterface;
import android.view.View;
import com.amazon.mShop.AmazonAlertDialog;
import com.amazon.mShop.platform.Platform;
import com.amazon.rio.j2me.client.persistence.DataStore;

// Referenced classes of package com.amazon.mShop.cvsd:
//            CVSDMapActivity

class this._cls0
    implements android.view.er
{

    final CVSDMapActivity this$0;

    public void onClick(View view)
    {
        if (com.amazon.mShop.platform.etInstance().getDataStore().getBoolean("allowUseUserCurrentlocation"))
        {
            CVSDMapActivity.access$100(CVSDMapActivity.this);
            return;
        } else
        {
            view = (new com.amazon.mShop.Builder(CVSDMapActivity.this)).setMessage(com.amazon.mShop.android.lib.use_current_location_confirm);
            android.content.ClickListener clicklistener = new android.content.DialogInterface.OnClickListener() {

                final CVSDMapActivity._cls2 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    if (i == -1)
                    {
                        com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().putBoolean("allowUseUserCurrentlocation", true);
                        CVSDMapActivity.access$100(this$0);
                    } else
                    if (i == -2)
                    {
                        return;
                    }
                }

            
            {
                this$1 = CVSDMapActivity._cls2.this;
                super();
            }
            };
            view.setPositiveButton(com.amazon.mShop.android.lib.button, clicklistener);
            view.setNegativeButton(com.amazon.mShop.android.lib.cel_button, clicklistener);
            view.create().show();
            return;
        }
    }

    _cls1.this._cls1()
    {
        this$0 = CVSDMapActivity.this;
        super();
    }
}

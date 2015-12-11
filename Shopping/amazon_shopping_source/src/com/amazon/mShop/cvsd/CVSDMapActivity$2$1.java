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

class this._cls1
    implements android.content.ickListener
{

    final is._cls0 this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (i == -1)
        {
            com.amazon.mShop.platform.Instance().getDataStore().putBoolean("allowUseUserCurrentlocation", true);
            CVSDMapActivity.access$100(_fld0);
        } else
        if (i == -2)
        {
            return;
        }
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/mShop/cvsd/CVSDMapActivity$2

/* anonymous class */
    class CVSDMapActivity._cls2
        implements android.view.View.OnClickListener
    {

        final CVSDMapActivity this$0;

        public void onClick(View view)
        {
            if (com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getBoolean("allowUseUserCurrentlocation"))
            {
                CVSDMapActivity.access$100(CVSDMapActivity.this);
                return;
            } else
            {
                view = (new com.amazon.mShop.AmazonAlertDialog.Builder(CVSDMapActivity.this)).setMessage(com.amazon.mShop.android.lib.R.string.opl_cvsd_use_current_location_confirm);
                CVSDMapActivity._cls2._cls1 _lcls1 = new CVSDMapActivity._cls2._cls1();
                view.setPositiveButton(com.amazon.mShop.android.lib.R.string.alert_ok_button, _lcls1);
                view.setNegativeButton(com.amazon.mShop.android.lib.R.string.alert_cancel_button, _lcls1);
                view.create().show();
                return;
            }
        }

            
            {
                this$0 = CVSDMapActivity.this;
                super();
            }
    }

}

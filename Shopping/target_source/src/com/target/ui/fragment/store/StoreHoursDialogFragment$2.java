// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.store;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.target.mothership.model.common.PhoneNumber;

// Referenced classes of package com.target.ui.fragment.store:
//            StoreHoursDialogFragment

class val.phoneNumber
    implements android.view.ialogFragment._cls2
{

    final StoreHoursDialogFragment this$0;
    final PhoneNumber val$phoneNumber;

    public void onClick(View view)
    {
        view = new Intent("android.intent.action.DIAL");
        view.setData(Uri.parse((new StringBuilder()).append("tel:").append(val$phoneNumber.a()).toString()));
        startActivity(view);
    }

    ()
    {
        this$0 = final_storehoursdialogfragment;
        val$phoneNumber = PhoneNumber.this;
        super();
    }
}

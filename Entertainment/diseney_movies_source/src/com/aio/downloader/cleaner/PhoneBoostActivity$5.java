// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.cleaner;

import android.view.View;
import android.widget.AdapterView;
import com.wjj.adapter.base.BoostPhoneAdapter;
import com.wjj.eneity.RuningApp;
import java.util.List;

// Referenced classes of package com.aio.downloader.cleaner:
//            PhoneBoostActivity

class this._cls0
    implements android.widget.ckListener
{

    final PhoneBoostActivity this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (((RuningApp)PhoneBoostActivity.access$1(PhoneBoostActivity.this).get(i)).ischecked)
        {
            ((RuningApp)PhoneBoostActivity.access$1(PhoneBoostActivity.this).get(i)).ischecked = false;
            PhoneBoostActivity.access$2(PhoneBoostActivity.this).notifyDataSetChanged();
            return;
        } else
        {
            ((RuningApp)PhoneBoostActivity.access$1(PhoneBoostActivity.this).get(i)).ischecked = true;
            PhoneBoostActivity.access$2(PhoneBoostActivity.this).notifyDataSetChanged();
            return;
        }
    }

    ()
    {
        this$0 = PhoneBoostActivity.this;
        super();
    }
}

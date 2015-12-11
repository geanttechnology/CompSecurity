// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.text.ClipboardManager;
import android.view.View;
import android.widget.Toast;
import com.ebay.mobile.Item;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ItemViewBaseActivity

class this._cls0
    implements android.view.r
{

    final ItemViewBaseActivity this$0;

    public boolean onLongClick(View view)
    {
        ((ClipboardManager)getSystemService("clipboard")).setText(item.title.SourceContent());
        Toast.makeText(ItemViewBaseActivity.this, getString(0x7f070269), 0).show();
        return true;
    }

    t()
    {
        this$0 = ItemViewBaseActivity.this;
        super();
    }
}

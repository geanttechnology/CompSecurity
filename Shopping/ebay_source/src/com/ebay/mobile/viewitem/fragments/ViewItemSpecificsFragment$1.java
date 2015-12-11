// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;

import android.app.Activity;
import android.text.ClipboardManager;
import android.view.View;
import android.widget.Toast;
import com.ebay.mobile.Item;
import com.ebay.mobile.ui_stuff.Util;

// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ViewItemSpecificsFragment

class val.activity
    implements android.view.emSpecificsFragment._cls1
{

    final ViewItemSpecificsFragment this$0;
    final Activity val$activity;

    public void onClick(View view)
    {
        ((ClipboardManager)val$activity.getSystemService("clipboard")).setText(String.valueOf(item.id));
        Toast.makeText(val$activity, getString(0x7f070269), 0).show();
        Util.vibratePhone(getActivity());
    }

    ()
    {
        this$0 = final_viewitemspecificsfragment;
        val$activity = Activity.this;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.Context;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

// Referenced classes of package com.groupon.fragment:
//            SecretAbTestFragment

class this._cls1 extends DialogPreference
{

    final this._cls1 this$1;

    protected View onCreateDialogView()
    {
        ListView listview = new ListView(getActivity());
        listview.setAdapter(new ArrayAdapter(getActivity(), 0x7f030200, 0x7f100524, cess._mth900(this._cls1.this)));
        return listview;
    }

    protected void onPrepareDialogBuilder(android.app.tsTask._cls2 _pcls2)
    {
        _pcls2._mth2("", null);
        _pcls2._mth2("Close", new this._cls1(null));
        super.onPrepareDialogBuilder(_pcls2);
    }

    (Context context, AttributeSet attributeset)
    {
        this$1 = this._cls1.this;
        super(context, attributeset);
    }
}

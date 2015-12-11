// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

// Referenced classes of package com.groupon.util:
//            GrouponAlertDialog

class this._cls0
    implements android.widget._cls2
{

    final this._cls0 this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (cess._mth100(this._cls0.this).isMultiChoice)
        {
            cess._mth100(this._cls0.this).multiChoiceItemsListener.onClick(cess._mth400(this._cls0.this), i, cess._mth100(this._cls0.this).listViewContent.isItemChecked(i));
            return;
        }
        if (cess._mth100(this._cls0.this).isSingleChoice)
        {
            cess._mth100(this._cls0.this).singleChoiceItemsListener.ck(cess._mth400(this._cls0.this), i);
            return;
        } else
        {
            cess._mth100(this._cls0.this).singleChoiceItemsListener.ck(cess._mth400(this._cls0.this), i);
            cess._mth400(this._cls0.this).dismiss();
            return;
        }
    }

    ener()
    {
        this$0 = this._cls0.this;
        super();
    }
}

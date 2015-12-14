// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.widget.ImageView;
import android.widget.TextView;
import com.aviary.android.feather.sdk.utils.CdsUIUtils;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            IAPDialogList, IAPBuyButton

class itemsCount
{

    IAPBuyButton buttonContainer;
    ImageView icon;
    String identifier;
    int itemsCount;
    com.aviary.android.feather.cds.Holder.text packType;
    long packid;
    TextView text;
    final text this$1;
    TextView title;

    public void setItemCount(int i, com.aviary.android.feather.cds.Holder holder)
    {
        packType = holder;
        itemsCount = i;
        updateText();
    }

    public void updateText()
    {
        StringBuilder stringbuilder = new StringBuilder();
        String s = CdsUIUtils.getPackTypeString(getContext(), packType);
        if (itemsCount > 0)
        {
            stringbuilder.append((new StringBuilder()).append(itemsCount).append(" ").append(s).toString());
        } else
        {
            stringbuilder.append("");
        }
        text.setText(stringbuilder.toString());
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
        itemsCount = 0;
    }
}

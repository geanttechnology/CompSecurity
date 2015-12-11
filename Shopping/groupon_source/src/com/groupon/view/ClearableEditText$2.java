// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.view:
//            ClearableEditText

class this._cls0
    implements TextWatcher
{

    final ClearableEditText this$0;

    public void afterTextChanged(Editable editable)
    {
        ImageView imageview = ClearableEditText.access$100(ClearableEditText.this);
        byte byte0;
        if (Strings.isEmpty(editable))
        {
            byte0 = 4;
        } else
        {
            byte0 = 0;
        }
        imageview.setVisibility(byte0);
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        ImageView imageview = ClearableEditText.access$100(ClearableEditText.this);
        if (Strings.notEmpty(charsequence))
        {
            i = 0;
        } else
        {
            i = 4;
        }
        imageview.setVisibility(i);
    }

    ()
    {
        this$0 = ClearableEditText.this;
        super();
    }
}

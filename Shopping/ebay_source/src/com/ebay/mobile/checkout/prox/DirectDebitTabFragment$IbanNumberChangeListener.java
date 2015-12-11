// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout.prox;

import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import com.ebay.nautilus.domain.data.DirectDebit;
import java.util.Locale;

// Referenced classes of package com.ebay.mobile.checkout.prox:
//            DirectDebitTabFragment

public final class this._cls0 extends this._cls0
{

    final DirectDebitTabFragment this$0;

    public void afterTextChanged(Editable editable)
    {
label0:
        {
            if (watchedView != null && editable == watchedView.getText())
            {
                editable = editable.toString();
                if (!TextUtils.isEmpty(editable))
                {
                    break label0;
                }
            }
            return;
        }
        if (editable.length() >= 2)
        {
            DirectDebitTabFragment.access$400(DirectDebitTabFragment.this).setInputType(2);
        } else
        {
            DirectDebitTabFragment.access$400(DirectDebitTabFragment.this).setInputType(1);
        }
        safeSetTextAfterTextChanged(editable.toUpperCase(Locale.getDefault()));
        if (editable.length() == 22 && DirectDebit.validateMod97Checksum(editable))
        {
            watchedView.setTextColor(baseColor);
            DirectDebitTabFragment.access$300(DirectDebitTabFragment.this, DirectDebitTabFragment.access$500(DirectDebitTabFragment.this));
            return;
        } else
        {
            watchedView.setTextColor(errorColor);
            return;
        }
    }

    public (EditText edittext)
    {
        this$0 = DirectDebitTabFragment.this;
        super(edittext);
    }
}

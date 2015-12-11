// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintreepayments.cardform.view;

import android.content.Context;
import android.text.InputFilter;
import android.util.AttributeSet;

// Referenced classes of package com.braintreepayments.cardform.view:
//            c

public class PostalCodeEditText extends c
{

    public PostalCodeEditText(Context context)
    {
        super(context);
        d();
    }

    public PostalCodeEditText(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        d();
    }

    public PostalCodeEditText(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        d();
    }

    private void d()
    {
        setInputType(112);
        setFilters(new InputFilter[] {
            new android.text.InputFilter.LengthFilter(16)
        });
    }

    public final boolean a()
    {
        return getText().toString().length() > 0;
    }
}

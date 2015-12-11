// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

// Referenced classes of package com.ebay.nautilus.domain.net:
//            EbayDateUtils

class this._cls0 extends ThreadLocal
{

    final this._cls0 this$0;

    protected volatile Object initialValue()
    {
        return initialValue();
    }

    protected DateFormat initialValue()
    {
        String s;
        if (android.os.TimeParseHelper < 18)
        {
            s = "Z";
        } else
        {
            s = "ZZZZZ";
        }
        return new SimpleDateFormat((new StringBuilder()).append(cess._mth000(this._cls0.this)).append(s).toString(), Locale.US);
    }

    ()
    {
        this$0 = this._cls0.this;
        super();
    }
}

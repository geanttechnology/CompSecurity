// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.client.android.encode;

import android.telephony.PhoneNumberUtils;

// Referenced classes of package com.google.zxing.client.android.encode:
//            Formatter, VCardContactEncoder

class this._cls0
    implements Formatter
{

    final VCardContactEncoder this$0;

    public String format(String s)
    {
        return PhoneNumberUtils.formatNumber(s);
    }

    ()
    {
        this$0 = VCardContactEncoder.this;
        super();
    }
}

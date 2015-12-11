// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.tracking.mobile.EncodedNSTField;

// Referenced classes of package com.groupon.activity:
//            HotelDetails

class TField extends EncodedNSTField
{

    final HotelDetails this$0;

    public String toEncodedString()
    {
        return "Click_Check_RaO_Button";
    }

    TField()
    {
        this$0 = HotelDetails.this;
        super();
    }
}

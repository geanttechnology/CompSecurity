// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import com.groupon.tracking.mobile.EncodedNSTField;

// Referenced classes of package com.groupon.util:
//            LoggingUtils

class dedNSTField extends EncodedNSTField
{

    final LoggingUtils this$0;
    final String val$widgetName;

    public String toEncodedString()
    {
        return val$widgetName;
    }

    dedNSTField()
    {
        this$0 = final_loggingutils;
        val$widgetName = String.this;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.reporting;

import com.rdio.android.core.RdioApiResponse;
import com.rdio.android.core.util.Logging;

// Referenced classes of package com.rdio.android.core.reporting:
//            AdEventReporter

class val.adKey
    implements com.rdio.android.core.sponseListener
{

    final AdEventReporter this$0;
    final String val$adKey;

    public void onResponse(RdioApiResponse rdioapiresponse)
    {
        if (rdioapiresponse.isSuccess())
        {
            AdEventReporter.access$000(AdEventReporter.this).log(4, "AdEventReporter", (new StringBuilder("Reporting ad play & finish for ")).append(val$adKey).toString());
            return;
        } else
        {
            AdEventReporter.access$000(AdEventReporter.this).log(6, "AdEventReporter", (new StringBuilder("There was an error reporting the ad finish event ")).append(rdioapiresponse.getErrorMessage()).toString());
            return;
        }
    }

    ener()
    {
        this$0 = final_adeventreporter;
        val$adKey = String.this;
        super();
    }
}

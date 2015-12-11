// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.adms.measurement;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.util.HashMap;

// Referenced classes of package com.adobe.adms.measurement:
//            ADMS_Measurement

public final class ADMS_ReferrerHandler
{

    static final String REFERRER_FIELDS[] = {
        "utm_source", "utm_medium", "utm_term", "utm_content", "utm_campaign"
    };

    public ADMS_ReferrerHandler()
    {
    }

    public void processIntent(Context context, Intent intent)
    {
        ADMS_Measurement.sharedInstance(context);
        if (intent.getAction().equals("com.android.vending.INSTALL_REFERRER")) goto _L2; else goto _L1
_L1:
        return;
_L2:
        String as[];
        int i;
        int k;
        try
        {
            context = intent.getExtras();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        context.containsKey(null);
        intent = intent.getStringExtra("referrer");
        if (intent != null && intent.length() != 0)
        {
            context = new HashMap();
            intent = intent.split("&");
            k = intent.length;
            for (i = 0; i < k; i++)
            {
                as = intent[i].split("=");
                if (as.length == 2)
                {
                    context.put(as[0], as[1]);
                }
            }

            intent = REFERRER_FIELDS;
            int l = intent.length;
            for (int j = 0; j < l; j++)
            {
                String s = intent[j];
                if (context.containsKey(s) && context.get(s) != null)
                {
                    ADMS_Measurement.editor.putString(s, (String)context.get(s));
                }
            }

            ADMS_Measurement.editor.commit();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

}

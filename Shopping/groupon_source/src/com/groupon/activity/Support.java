// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import com.groupon.models.support.SupportInfo;
import com.groupon.service.core.SupportInfoService;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GrouponActivity

public class Support extends GrouponActivity
{

    private String callCharges;
    TextView details;
    private String email;
    WebView faq;
    View layout;
    private String operationHours;
    private String phoneNumber;
    private SupportInfoService supportInfoService;

    public Support()
    {
        phoneNumber = null;
        operationHours = null;
        callCharges = null;
        email = null;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03020f);
        faq.setBackgroundColor(0);
        faq.setBackground(null);
        faq.setLayerType(1, null);
        layout.setVisibility(0);
        bundle = supportInfoService.getSupportInfo();
        String s3 = ((SupportInfo) (bundle)).contents.faq;
        phoneNumber = ((SupportInfo) (bundle)).contents.customerSupport.phoneNumber;
        operationHours = ((SupportInfo) (bundle)).contents.customerSupport.operatingHours;
        callCharges = ((SupportInfo) (bundle)).contents.customerSupport.callCharges;
        email = ((SupportInfo) (bundle)).contents.customerSupport.email;
        TextView textview = details;
        String s;
        String s1;
        String s2;
        if (Strings.isEmpty(phoneNumber))
        {
            bundle = "";
        } else
        {
            bundle = phoneNumber;
        }
        if (Strings.isEmpty(operationHours))
        {
            s = "";
        } else
        {
            s = operationHours;
        }
        if (Strings.isEmpty(callCharges))
        {
            s1 = "";
        } else
        {
            s1 = (new StringBuilder()).append(callCharges).append("\n\n").toString();
        }
        if (Strings.isEmpty(email))
        {
            s2 = "";
        } else
        {
            s2 = email;
        }
        textview.setText(String.format("%s\n%s\n%s%s", new Object[] {
            bundle, s, s1, s2
        }));
        faq.loadDataWithBaseURL(null, s3, "text/html", "utf-8", null);
        details.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void onDestroy()
    {
        super.onDestroy();
        faq.destroy();
    }

    protected void onResume()
    {
        super.onResume();
        TextView textview = details;
        String s;
        String s1;
        String s2;
        String s3;
        if (Strings.isEmpty(phoneNumber))
        {
            s = "";
        } else
        {
            s = phoneNumber;
        }
        if (Strings.isEmpty(operationHours))
        {
            s1 = "";
        } else
        {
            s1 = operationHours;
        }
        if (Strings.isEmpty(callCharges))
        {
            s2 = "";
        } else
        {
            s2 = (new StringBuilder()).append(callCharges).append("\n\n").toString();
        }
        if (Strings.isEmpty(email))
        {
            s3 = "";
        } else
        {
            s3 = email;
        }
        textview.setText(String.format("%s\n%s\n%s%s", new Object[] {
            s, s1, s2, s3
        }));
    }
}

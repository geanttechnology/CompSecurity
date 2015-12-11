// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.view.viewholder;

import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.groupon.mvc.model.FinePrint;
import com.groupon.view.NonLeakingNonFlickerWebView;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.mvc.view.viewholder:
//            RecyclerItemViewHolder

public class FinePrintViewHolder extends RecyclerItemViewHolder
{

    TextView expirationView;
    NonLeakingNonFlickerWebView finePrintWebView;
    TextView legalDisclosureView;
    TextView universalRulesView;

    public FinePrintViewHolder(View view)
    {
        super(view);
    }

    public void populateViews()
    {
        boolean flag = false;
        expirationView.setText(((FinePrint)model).expiration);
        TextView textview = expirationView;
        int i;
        if (((FinePrint)model).shouldShowExpirationView && Strings.notEmpty(((FinePrint)model).expiration))
        {
            i = 0;
        } else
        {
            i = 8;
        }
        textview.setVisibility(i);
        finePrintWebView.loadDataWithBaseURL(null, (new StringBuilder()).append(((FinePrint)model).webViewCSSStyling).append(((FinePrint)model).finePrint).toString(), "text/html", "UTF-8", null);
        legalDisclosureView.setText(((FinePrint)model).legalDisclosure);
        textview = legalDisclosureView;
        if (Strings.notEmpty(((FinePrint)model).legalDisclosure))
        {
            i = 0;
        } else
        {
            i = 8;
        }
        textview.setVisibility(i);
        universalRulesView.setMovementMethod(LinkMovementMethod.getInstance());
        textview = universalRulesView;
        if (((FinePrint)model).shouldShowUniversalRules)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 8;
        }
        textview.setVisibility(i);
    }
}

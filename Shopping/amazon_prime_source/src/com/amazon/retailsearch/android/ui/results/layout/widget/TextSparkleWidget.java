// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.retailsearch.android.ui.StyledSpannableString;
import com.amazon.retailsearch.android.ui.listadapter.ModelView;
import com.amazon.retailsearch.android.ui.results.layout.model.TextSparkleModel;
import com.amazon.searchapp.retailsearch.model.StyledText;
import com.amazon.searchapp.retailsearch.model.TextSparkle;
import java.util.Iterator;
import java.util.List;

public class TextSparkleWidget extends LinearLayout
    implements ModelView
{

    private TextView text;

    public TextSparkleWidget(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        inflate(context, com.amazon.retailsearch.R.layout.rs_widget_text_sparkle, this);
        text = (TextView)findViewById(com.amazon.retailsearch.R.id.rs_widget_text_sparkle_text);
    }

    public void build(TextSparkleModel textsparklemodel)
    {
        if (textsparklemodel == null || textsparklemodel.getTextSparkle() == null || textsparklemodel.getTextSparkle().getText() == null)
        {
            setVisibility(8);
            return;
        }
        StyledSpannableString styledspannablestring = new StyledSpannableString(getContext());
        for (textsparklemodel = textsparklemodel.getTextSparkle().getText().iterator(); textsparklemodel.hasNext(); styledspannablestring.append(((StyledText)textsparklemodel.next()).getText())) { }
        text.setText(styledspannablestring);
        setVisibility(0);
    }

    public volatile void build(Object obj)
    {
        build((TextSparkleModel)obj);
    }
}

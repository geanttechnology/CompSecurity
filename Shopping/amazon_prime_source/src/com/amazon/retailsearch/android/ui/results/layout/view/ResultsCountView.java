// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.amazon.retailsearch.android.ui.listadapter.ModelView;
import com.amazon.searchapp.retailsearch.model.ResultsMetadata;

public class ResultsCountView extends FrameLayout
    implements ModelView
{

    private TextView textView;

    public ResultsCountView(Context context)
    {
        super(context);
        init();
    }

    public ResultsCountView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init();
    }

    public ResultsCountView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        init();
    }

    private void init()
    {
        inflate(getContext(), com.amazon.retailsearch.R.layout.rs_results_count_text, this);
        textView = (TextView)findViewById(com.amazon.retailsearch.R.id.rs_results_count_text);
        textView.setSingleLine(true);
        textView.setEllipsize(android.text.TextUtils.TruncateAt.END);
        setVisibility(8);
    }

    public static boolean isValidMetaData(ResultsMetadata resultsmetadata)
    {
        return resultsmetadata != null && resultsmetadata.getTotalResults() > 0L && !TextUtils.isEmpty(resultsmetadata.getResultsLabel());
    }

    public void build(ResultsMetadata resultsmetadata)
    {
        if (!isValidMetaData(resultsmetadata))
        {
            setVisibility(8);
            return;
        } else
        {
            textView.setText(resultsmetadata.getResultsLabel());
            setVisibility(0);
            return;
        }
    }

    public volatile void build(Object obj)
    {
        build((ResultsMetadata)obj);
    }

    public void setVisibility(int i)
    {
        super.setVisibility(i);
        textView.setVisibility(i);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.retailsearch.android.ui.listadapter.ModelView;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.interaction.UserInteractionListener;
import java.net.SocketException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;
import org.apache.http.NoHttpResponseException;

public class ErrorView extends LinearLayout
    implements ModelView
{

    private TextView errorText;
    private Button retryBtn;
    UserInteractionListener userInteractionListener;

    public ErrorView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        RetailSearchDaggerGraphController.inject(this);
        inflate(context, com.amazon.retailsearch.R.layout.rs_request_error, this);
        errorText = (TextView)findViewById(com.amazon.retailsearch.R.id.rs_request_error_text);
        retryBtn = (Button)findViewById(com.amazon.retailsearch.R.id.rs_request_error_retry);
        retryBtn.setOnClickListener(new android.view.View.OnClickListener() {

            final ErrorView this$0;

            public void onClick(View view)
            {
                userInteractionListener.retrySearch();
            }

            
            {
                this$0 = ErrorView.this;
                super();
            }
        });
    }

    public void build(Exception exception)
    {
        if ((exception instanceof UnknownHostException) || (exception instanceof SocketException) || (exception instanceof SSLException) || (exception instanceof NoHttpResponseException))
        {
            errorText.setText(com.amazon.retailsearch.R.string.rs_results_error_connectivity);
            return;
        } else
        {
            errorText.setText(com.amazon.retailsearch.R.string.rs_results_error_generic);
            return;
        }
    }

    public volatile void build(Object obj)
    {
        build((Exception)obj);
    }
}

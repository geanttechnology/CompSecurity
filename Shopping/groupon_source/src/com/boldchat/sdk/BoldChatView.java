// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;

public class BoldChatView extends LinearLayout
{

    boolean isWebViewHistoryEnabled;
    String mApiKey;

    public BoldChatView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mApiKey = null;
        isWebViewHistoryEnabled = false;
        initView(context, attributeset);
    }

    public BoldChatView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mApiKey = null;
        isWebViewHistoryEnabled = false;
        initView(context, attributeset);
    }

    public BoldChatView(Context context, String s)
    {
        super(context);
        mApiKey = null;
        isWebViewHistoryEnabled = false;
        mApiKey = s;
        initView(context);
    }

    private void initView(Context context)
    {
        LayoutInflater.from(context).inflate(R.layout.bc_chat, this);
        if (!isInEditMode())
        {
            context = (ViewStub)findViewById(R.id.bc_history_stub_import);
            if (isWebViewHistoryEnabled)
            {
                context.setLayoutResource(R.layout.bc_web_history);
            }
            context.inflate();
            context = findViewById(R.id.bc_chat_main);
            View view = findViewById(R.id.bc_busy_view);
            context.setVisibility(8);
            view.setVisibility(0);
        }
    }

    private void initView(Context context, AttributeSet attributeset)
    {
        attributeset = context.obtainStyledAttributes(attributeset, R.styleable.BoldChatView);
        int j = attributeset.getIndexCount();
        int i = 0;
        while (i < j) 
        {
            int k = attributeset.getIndex(i);
            if (k == R.styleable.BoldChatView_apiKey)
            {
                mApiKey = attributeset.getString(k);
            } else
            if (k == R.styleable.BoldChatView_useWebViewHistory)
            {
                isWebViewHistoryEnabled = attributeset.getBoolean(k, false);
            }
            i++;
        }
        attributeset.recycle();
        initView(context);
    }

    protected String getApiKey()
    {
        return mApiKey;
    }

    protected ViewGroup getBusyView()
    {
        return (ViewGroup)findViewById(R.id.bc_busy_view);
    }

    protected ViewGroup getFormView()
    {
        return (ViewGroup)findViewById(R.id.bc_form_container);
    }

    protected ViewGroup getMainChatView()
    {
        return (ViewGroup)findViewById(R.id.bc_chat_main);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoback;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import com.flurry.android.FlurryAgent;
import gg;

public class FotoHomeBackView extends FrameLayout
{

    private Button btnBack;
    private Button btnCancel;
    private Button btnLoadHelpr;
    private Context mContext;
    private gg mListener;

    public FotoHomeBackView(Context context)
    {
        super(context);
        mContext = context;
        init();
    }

    public FotoHomeBackView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mContext = context;
        init();
    }

    private void init()
    {
        FlurryAgent.logEvent("event_exitViewShow");
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(com.fotoable.fotoadpackage.R.layout.view_foto_back, this, true);
        btnBack = (Button)findViewById(com.fotoable.fotoadpackage.R.id.btn_back);
        btnCancel = (Button)findViewById(com.fotoable.fotoadpackage.R.id.btn_cancel);
        btnLoadHelpr = (Button)findViewById(com.fotoable.fotoadpackage.R.id.btn_load_helpr);
        btnBack.setOnClickListener(new android.view.View.OnClickListener() {

            final FotoHomeBackView a;

            public void onClick(View view)
            {
                if (a.mListener != null)
                {
                    a.mListener.a();
                    FlurryAgent.logEvent("event_exitApp");
                }
            }

            
            {
                a = FotoHomeBackView.this;
                super();
            }
        });
        btnCancel.setOnClickListener(new android.view.View.OnClickListener() {

            final FotoHomeBackView a;

            public void onClick(View view)
            {
                if (a.mListener != null)
                {
                    a.mListener.b();
                    FlurryAgent.logEvent("event_cancelClicked");
                }
            }

            
            {
                a = FotoHomeBackView.this;
                super();
            }
        });
        btnLoadHelpr.setOnClickListener(new android.view.View.OnClickListener() {

            final FotoHomeBackView a;

            public void onClick(View view)
            {
                if (a.mListener != null)
                {
                    a.mListener.c();
                    FlurryAgent.logEvent("event_downloadApp");
                }
            }

            
            {
                a = FotoHomeBackView.this;
                super();
            }
        });
    }

    public void setListener(gg gg)
    {
        mListener = gg;
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoback;

import aar;
import aas;
import aav;
import aaw;
import aax;
import aay;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.FrameLayout;
import com.flurry.android.FlurryAgent;

public class FotoHomeBackView extends FrameLayout
{

    private Button btnBack;
    private Button btnCancel;
    private Button btnLoadHelpr;
    private Context mContext;
    private aay mListener;

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
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(aas.view_foto_back, this, true);
        btnBack = (Button)findViewById(aar.btn_back);
        btnCancel = (Button)findViewById(aar.btn_cancel);
        btnLoadHelpr = (Button)findViewById(aar.btn_load_helpr);
        btnBack.setOnClickListener(new aav(this));
        btnCancel.setOnClickListener(new aaw(this));
        btnLoadHelpr.setOnClickListener(new aax(this));
    }

    public void setListener(aay aay)
    {
        mListener = aay;
    }

}

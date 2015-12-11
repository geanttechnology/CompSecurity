// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.twister;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.twister:
//            TwisterListView, TwisterModel

public class TwisterDialog extends Dialog
{

    private ImageView mClose;
    private TextView mHeaderTitle;
    private TwisterListView mTwisterList;

    public TwisterDialog(Context context)
    {
        super(context, com.amazon.retailsearch.R.style.Rs_Twister_Dialog);
        setContentView(com.amazon.retailsearch.R.layout.rs_twister_menu);
        mHeaderTitle = (TextView)findViewById(com.amazon.retailsearch.R.id.rs_twister_menu_header_title);
        mClose = (ImageView)findViewById(com.amazon.retailsearch.R.id.rs_twister_menu_close);
        mTwisterList = (TwisterListView)findViewById(com.amazon.retailsearch.R.id.rs_twister_menu_list);
    }

    public void init(TwisterModel twistermodel)
    {
        getWindow().setBackgroundDrawableResource(0x106000d);
        mHeaderTitle.setText(twistermodel.getProductTitle());
        mTwisterList.setEditions(twistermodel.getEditions());
        mTwisterList.setTwisterDialog(this);
        mClose.setOnClickListener(new android.view.View.OnClickListener() {

            final TwisterDialog this$0;

            public void onClick(View view)
            {
                dismiss();
            }

            
            {
                this$0 = TwisterDialog.this;
                super();
            }
        });
    }
}

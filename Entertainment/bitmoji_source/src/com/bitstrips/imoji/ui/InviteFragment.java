// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.os.Bundle;
import android.view.View;
import com.bitstrips.imoji.ui.views.ImojiView;
import com.crashlytics.android.Crashlytics;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

// Referenced classes of package com.bitstrips.imoji.ui:
//            AbstractFragment

public class InviteFragment extends AbstractFragment
{

    private static final String TAG = "InviteFragment";
    private ImojiView cardImage;
    private String imojiUrl;
    Picasso picasso;

    public InviteFragment()
    {
    }

    protected int getLayout()
    {
        return 0x7f030040;
    }

    protected void initArgs(Bundle bundle)
    {
        imojiUrl = bundle.getString("url");
    }

    protected void initSubViews(View view)
    {
        cardImage = (ImojiView)view.findViewById(0x7f0b00ca);
    }

    protected void populateContentView()
    {
        picasso.load(imojiUrl).priority(com.squareup.picasso.Picasso.Priority.HIGH).placeholder(0x7f0200a9).into(cardImage, new Callback() {

            final InviteFragment this$0;

            public void onError()
            {
                Crashlytics.log(String.format("%s - Failure to load template: %s", new Object[] {
                    "InviteFragment", imojiUrl
                }));
            }

            public void onSuccess()
            {
                cardImage.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
            }

            
            {
                this$0 = InviteFragment.this;
                super();
            }
        });
    }


}

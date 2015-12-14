// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.activity.link.view;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import bis;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;

// Referenced classes of package com.wantu.activity.link.view:
//            LinkBaseView, CityLabel, UILabel

public class LinkHeader2 extends LinkBaseView
{

    private String TAG;
    private CityLabel cityLabel;
    private UILabel dateLabel;

    public LinkHeader2(Context context)
    {
        super(context);
        TAG = "LinkHeader4";
        View.inflate(getContext(), 0x7f030094, this);
        cityLabel = (CityLabel)findViewById(0x7f0d0034);
        dateLabel = (UILabel)findViewById(0x7f0d028e);
        cityLabel.setOnClickListener(new bis(this, this));
        dateLabel.setOnClickListener(new bis(this, this));
        dateLabel.setTextColor(Color.rgb(204, 153, 102));
        cityLabel.setTextColor(Color.rgb(204, 153, 102));
        ((ImageView)findViewById(0x7f0d00f1)).setImageBitmap(getBitmapByAssetPath("MRes/link2/im_strip_top_1.png"));
        resizeChildRecursive(this, TPhotoComposeInfo.scale, TPhotoComposeInfo.scale);
    }

    public int getOriHeight()
    {
        return 75;
    }

    public int getOriWith()
    {
        return 320;
    }

    public CityLabel subCityLabel()
    {
        return cityLabel;
    }

    public UILabel subMonthAndDayLabel()
    {
        return dateLabel;
    }
}

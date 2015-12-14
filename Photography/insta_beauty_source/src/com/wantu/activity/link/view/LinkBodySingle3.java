// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.activity.link.view;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import axw;
import bis;
import com.instabeauty.application.InstaBeautyApplication;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;

// Referenced classes of package com.wantu.activity.link.view:
//            LinkBaseView, LinkImageView, CaptionLabel, UILabel

public class LinkBodySingle3 extends LinkBaseView
{

    private String TAG;
    private CaptionLabel dateLabel;
    private LinkImageView image1;

    public LinkBodySingle3(Context context)
    {
        super(context);
        TAG = "LinkBodySingle4";
        View.inflate(getContext(), 0x7f030089, this);
        image1 = (LinkImageView)findViewById(0x7f0d00f1);
        dateLabel = (CaptionLabel)findViewById(0x7f0d0034);
        dateLabel.setOnClickListener(new bis(this, this));
        Log.v(TAG, (new StringBuilder()).append(TAG).append(" lp width:").append(image1.getLayoutParams().width).toString());
        Log.v(TAG, (new StringBuilder()).append(TAG).append(" lp height:").append(image1.getLayoutParams().height).toString());
        ((FrameLayout)findViewById(0x7f0d0288)).setBackgroundColor(Color.rgb(51, 51, 51));
        ((ImageView)findViewById(0x7f0d028a)).setImageBitmap(getBitmapByAssetPath("MRes/link3/im_strip_3_dot.png"));
        resizeChildRecursive(this, TPhotoComposeInfo.scale, TPhotoComposeInfo.scale);
    }

    public int getOriHeight()
    {
        return 288;
    }

    public int getOriWith()
    {
        return 320;
    }

    public UILabel subDateTimeLabel()
    {
        return dateLabel;
    }

    public LinkImageView subImage1()
    {
        return image1;
    }

    public float subOffsetY()
    {
        return (float)axw.a(InstaBeautyApplication.a().b(), 20F) * TPhotoComposeInfo.scale;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.activity.link.view;

import android.content.Context;
import android.util.Log;
import android.view.View;
import axw;
import bis;
import com.instabeauty.application.InstaBeautyApplication;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;

// Referenced classes of package com.wantu.activity.link.view:
//            LinkBaseView, LinkImageView, UILabel

public class LinkBodyDouble1 extends LinkBaseView
{

    private String TAG;
    private UILabel dateLabel1;
    private UILabel dateLabel2;
    private LinkImageView image1;
    private LinkImageView image2;

    public LinkBodyDouble1(Context context)
    {
        super(context);
        TAG = "LinkBodyDouble2";
        View.inflate(getContext(), 0x7f030084, this);
        image1 = (LinkImageView)findViewById(0x7f0d00f1);
        image2 = (LinkImageView)findViewById(0x7f0d018d);
        dateLabel1 = (UILabel)findViewById(0x7f0d0286);
        dateLabel2 = (UILabel)findViewById(0x7f0d0287);
        dateLabel1.setOnClickListener(new bis(this, this));
        dateLabel2.setOnClickListener(new bis(this, this));
        Log.v(TAG, (new StringBuilder()).append(TAG).append(" lp width:").append(image1.getLayoutParams().width).toString());
        Log.v(TAG, (new StringBuilder()).append(TAG).append(" lp height:").append(image1.getLayoutParams().height).toString());
        resizeChildRecursive(this, TPhotoComposeInfo.scale, TPhotoComposeInfo.scale);
    }

    public int getOriHeight()
    {
        return 209;
    }

    public int getOriWith()
    {
        return 320;
    }

    public UILabel subDateLabel()
    {
        return dateLabel1;
    }

    public UILabel subDateLabel2()
    {
        return dateLabel2;
    }

    public LinkImageView subImage1()
    {
        return image1;
    }

    public LinkImageView subImage2()
    {
        return image2;
    }

    public float subOffsetY()
    {
        return (float)axw.a(InstaBeautyApplication.a().getApplicationContext(), 4F) * TPhotoComposeInfo.scale;
    }
}

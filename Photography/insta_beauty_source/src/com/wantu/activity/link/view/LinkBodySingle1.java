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
//            LinkBaseView, LinkImageView, CityLabel

public class LinkBodySingle1 extends LinkBaseView
{

    private String TAG;
    private CityLabel cityLabel;
    private LinkImageView image1;

    public LinkBodySingle1(Context context)
    {
        super(context);
        TAG = "LinkBodySingle4";
        View.inflate(getContext(), 0x7f030087, this);
        image1 = (LinkImageView)findViewById(0x7f0d00f1);
        cityLabel = (CityLabel)findViewById(0x7f0d0034);
        Log.v(TAG, (new StringBuilder()).append(TAG).append(" lp width:").append(image1.getLayoutParams().width).toString());
        Log.v(TAG, (new StringBuilder()).append(TAG).append(" lp height:").append(image1.getLayoutParams().height).toString());
        resizeChildRecursive(this, TPhotoComposeInfo.scale, TPhotoComposeInfo.scale);
        cityLabel.setOnClickListener(new bis(this, this));
    }

    public int getOriHeight()
    {
        return 316;
    }

    public int getOriWith()
    {
        return 320;
    }

    public CityLabel subCityLabel()
    {
        return cityLabel;
    }

    public LinkImageView subImage1()
    {
        return image1;
    }

    public float subOffsetY()
    {
        return (float)axw.a(InstaBeautyApplication.a().b(), 4F) * TPhotoComposeInfo.scale;
    }
}

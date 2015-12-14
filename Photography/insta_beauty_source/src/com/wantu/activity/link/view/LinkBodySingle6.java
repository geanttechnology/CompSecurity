// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.activity.link.view;

import android.content.Context;
import android.view.View;
import axw;
import bis;
import com.instabeauty.application.InstaBeautyApplication;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;

// Referenced classes of package com.wantu.activity.link.view:
//            LinkBaseView, LinkImageView, CaptionLabel, UILabel

public class LinkBodySingle6 extends LinkBaseView
{

    private String TAG;
    private CaptionLabel captionLabel;
    private LinkImageView image1;

    public LinkBodySingle6(Context context)
    {
        super(context);
        TAG = "LinkBodySingle6";
        View.inflate(getContext(), 0x7f03008c, this);
        image1 = (LinkImageView)findViewById(0x7f0d00f1);
        captionLabel = (CaptionLabel)findViewById(0x7f0d0034);
        captionLabel.setOnClickListener(new bis(this, this));
        ((LinkImageView)findViewById(0x7f0d028c)).setImageBitmap(getBitmapByAssetPath("MRes/link6/f0.png"));
        resizeChildRecursive(this, TPhotoComposeInfo.scale, TPhotoComposeInfo.scale);
    }

    public int getOriHeight()
    {
        return 300;
    }

    public int getOriWith()
    {
        return 320;
    }

    public UILabel subCountLabel()
    {
        return captionLabel;
    }

    public LinkImageView subImage1()
    {
        return image1;
    }

    public float subOffsetY()
    {
        return (float)axw.a(InstaBeautyApplication.a().b(), 32F) * TPhotoComposeInfo.scale;
    }

    public UILabel subTimeLabel()
    {
        return null;
    }
}

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
//            LinkBaseView, CaptionLabel, UILabel

public class LinkHeader6 extends LinkBaseView
{

    private String TAG;
    private CaptionLabel captionLabel;
    private UILabel dateLabel;

    public LinkHeader6(Context context)
    {
        super(context);
        TAG = "LinkHeader6";
        View.inflate(getContext(), 0x7f030098, this);
        captionLabel = (CaptionLabel)findViewById(0x7f0d0034);
        captionLabel.setTextColor(Color.rgb(204, 102, 0));
        captionLabel.setOnClickListener(new bis(this, this));
        ((ImageView)findViewById(0x7f0d00f1)).setImageBitmap(getBitmapByAssetPath("MRes/link6/d0.png"));
        resizeChildRecursive(this, TPhotoComposeInfo.scale, TPhotoComposeInfo.scale);
    }

    public int getOriHeight()
    {
        return 97;
    }

    public int getOriWith()
    {
        return 320;
    }

    public CaptionLabel subCaptionLabel()
    {
        return captionLabel;
    }
}

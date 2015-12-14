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
//            LinkBaseView, CaptionLabel

public class LinkHeader1 extends LinkBaseView
{

    private String TAG;
    private CaptionLabel captionLabel;

    public LinkHeader1(Context context)
    {
        super(context);
        TAG = "LinkHeader4";
        View.inflate(getContext(), 0x7f030093, this);
        captionLabel = (CaptionLabel)findViewById(0x7f0d0034);
        captionLabel.setTextColor(Color.rgb(255, 204, 204));
        ((ImageView)findViewById(0x7f0d028d)).setImageBitmap(getBitmapByAssetPath("MRes/link1/d01.png"));
        resizeChildRecursive(this, TPhotoComposeInfo.scale, TPhotoComposeInfo.scale);
        captionLabel.setOnClickListener(new bis(this, this));
    }

    public int getOriHeight()
    {
        return 78;
    }

    public int getOriWith()
    {
        return 320;
    }
}

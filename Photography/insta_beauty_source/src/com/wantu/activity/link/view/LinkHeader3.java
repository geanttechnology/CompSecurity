// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.activity.link.view;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.FrameLayout;
import bis;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;

// Referenced classes of package com.wantu.activity.link.view:
//            LinkBaseView, CaptionLabel

public class LinkHeader3 extends LinkBaseView
{

    private String TAG;
    private CaptionLabel captionLabel;

    public LinkHeader3(Context context)
    {
        super(context);
        TAG = "LinkHeader4";
        View.inflate(getContext(), 0x7f030095, this);
        captionLabel = (CaptionLabel)findViewById(0x7f0d0034);
        captionLabel.setOnClickListener(new bis(this, this));
        ((FrameLayout)findViewById(0x7f0d0288)).setBackgroundColor(Color.rgb(51, 51, 51));
        resizeChildRecursive(this, TPhotoComposeInfo.scale, TPhotoComposeInfo.scale);
    }

    public int getOriHeight()
    {
        return 65;
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

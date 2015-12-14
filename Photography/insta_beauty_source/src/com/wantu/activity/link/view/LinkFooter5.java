// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.activity.link.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;

// Referenced classes of package com.wantu.activity.link.view:
//            LinkBaseView

public class LinkFooter5 extends LinkBaseView
{

    public LinkFooter5(Context context)
    {
        super(context);
        View.inflate(getContext(), 0x7f030091, this);
        ((ImageView)findViewById(0x7f0d00f1)).setImageBitmap(getBitmapByAssetPath("MRes/link5/d1.png"));
        resizeChildRecursive(this, TPhotoComposeInfo.scale, TPhotoComposeInfo.scale);
    }

    public int getOriHeight()
    {
        return 57;
    }

    public int getOriWith()
    {
        return 320;
    }
}

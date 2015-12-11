// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Callback;

// Referenced classes of package com.groupon.view:
//            MapSliceRedesign

class this._cls0
    implements Callback
{

    final MapSliceRedesign this$0;

    public void onError(ImageView imageview)
    {
    }

    public void onSuccess(ImageView imageview)
    {
        if (((BitmapDrawable)imageview.getDrawable()).getBitmap() == null)
        {
            MapSliceRedesign.access$000(MapSliceRedesign.this).setVisibility(0);
        }
    }

    able()
    {
        this$0 = MapSliceRedesign.this;
        super();
    }
}

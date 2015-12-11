// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import com.groupon.util.BitmapUtil;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.Function1;

// Referenced classes of package com.groupon.activity:
//            Redeem

class this._cls0
    implements Function1
{

    final Redeem this$0;

    public void execute(Bitmap bitmap)
        throws RuntimeException
    {
        int i = Redeem.access$1300(Redeem.this).getDisplayMetrics().widthPixels;
        int j = Redeem.access$1300(Redeem.this).getDisplayMetrics().heightPixels;
        if (Redeem.access$1400(Redeem.this))
        {
            i = getResources().getDimensionPixelSize(0x7f0b01e3);
        }
        i = (int)((float)i * 0.8F);
        j = (int)((float)j * 0.5F);
        bitmap = Redeem.access$1500(Redeem.this).createScaledBitmap(bitmap, i, j);
        barcodeImageView.setImageBitmap(bitmap);
        barcodeView.setVisibility(0);
    }

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((Bitmap)obj);
    }

    l()
    {
        this$0 = Redeem.this;
        super();
    }
}

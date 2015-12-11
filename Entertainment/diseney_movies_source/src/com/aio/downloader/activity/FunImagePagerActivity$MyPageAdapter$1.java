// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.aio.downloader.views.LImageButton;

// Referenced classes of package com.aio.downloader.activity:
//            FunImagePagerActivity

class this._cls1
    implements android.view.yPageAdapter._cls1
{

    final this._cls1 this$1;

    public void onClick(View view)
    {
        if (FunImagePagerActivity.access$6(cess._mth0(this._cls1.this)).getVisibility() == 0)
        {
            FunImagePagerActivity.access$6(cess._mth0(this._cls1.this)).setVisibility(8);
            FunImagePagerActivity.access$7(cess._mth0(this._cls1.this)).setVisibility(8);
            FunImagePagerActivity.access$8(cess._mth0(this._cls1.this)).setVisibility(8);
            FunImagePagerActivity.access$9(cess._mth0(this._cls1.this)).setVisibility(8);
            FunImagePagerActivity.access$5(cess._mth0(this._cls1.this)).setVisibility(8);
            return;
        } else
        {
            FunImagePagerActivity.access$6(cess._mth0(this._cls1.this)).setVisibility(0);
            FunImagePagerActivity.access$7(cess._mth0(this._cls1.this)).setVisibility(0);
            FunImagePagerActivity.access$8(cess._mth0(this._cls1.this)).setVisibility(0);
            FunImagePagerActivity.access$9(cess._mth0(this._cls1.this)).setVisibility(0);
            FunImagePagerActivity.access$5(cess._mth0(this._cls1.this)).setVisibility(0);
            return;
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}

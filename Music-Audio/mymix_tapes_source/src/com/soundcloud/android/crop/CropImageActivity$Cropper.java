// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.soundcloud.android.crop;

import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import java.util.ArrayList;

// Referenced classes of package com.soundcloud.android.crop:
//            CropImageActivity, HighlightView, RotateBitmap, CropImageView

private class <init>
{

    final CropImageActivity this$0;

    private void makeDefault()
    {
        boolean flag1 = false;
        if (CropImageActivity.access$400(CropImageActivity.this) == null)
        {
            return;
        }
        HighlightView highlightview = new HighlightView(CropImageActivity.access$100(CropImageActivity.this));
        int j1 = CropImageActivity.access$400(CropImageActivity.this).getWidth();
        int i1 = CropImageActivity.access$400(CropImageActivity.this).getHeight();
        Rect rect = new Rect(0, 0, j1, i1);
        int k = (Math.min(j1, i1) * 4) / 5;
        int l = k;
        int i = l;
        int j = k;
        if (CropImageActivity.access$500(CropImageActivity.this) != 0)
        {
            i = l;
            j = k;
            RectF rectf;
            android.graphics.Matrix matrix;
            boolean flag;
            if (CropImageActivity.access$600(CropImageActivity.this) != 0)
            {
                if (CropImageActivity.access$500(CropImageActivity.this) > CropImageActivity.access$600(CropImageActivity.this))
                {
                    i = (CropImageActivity.access$600(CropImageActivity.this) * k) / CropImageActivity.access$500(CropImageActivity.this);
                    j = k;
                } else
                {
                    j = (CropImageActivity.access$500(CropImageActivity.this) * l) / CropImageActivity.access$600(CropImageActivity.this);
                    i = l;
                }
            }
        }
        k = (j1 - j) / 2;
        l = (i1 - i) / 2;
        rectf = new RectF(k, l, k + j, l + i);
        matrix = CropImageActivity.access$100(CropImageActivity.this).getUnrotatedMatrix();
        flag = flag1;
        if (CropImageActivity.access$500(CropImageActivity.this) != 0)
        {
            flag = flag1;
            if (CropImageActivity.access$600(CropImageActivity.this) != 0)
            {
                flag = true;
            }
        }
        highlightview.setup(matrix, rect, rectf, flag);
        CropImageActivity.access$100(CropImageActivity.this).add(highlightview);
    }

    public void crop()
    {
        CropImageActivity.access$200(CropImageActivity.this).post(new Runnable() {

            final CropImageActivity.Cropper this$1;

            public void run()
            {
                makeDefault();
                CropImageActivity.access$100(this$0).invalidate();
                if (CropImageActivity.access$100(this$0).highlightViews.size() == 1)
                {
                    CropImageActivity.access$802(this$0, (HighlightView)CropImageActivity.access$100(this$0).highlightViews.get(0));
                    CropImageActivity.access$800(this$0).setFocus(true);
                }
            }

            
            {
                this$1 = CropImageActivity.Cropper.this;
                super();
            }
        });
    }


    private _cls1.this._cls1()
    {
        this$0 = CropImageActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}

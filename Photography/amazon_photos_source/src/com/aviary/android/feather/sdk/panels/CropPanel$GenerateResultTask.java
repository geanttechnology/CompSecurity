// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import android.graphics.Bitmap;
import com.aviary.android.feather.common.utils.os.AviaryAsyncTask;
import com.aviary.android.feather.headless.filters.impl.CropFilter;
import com.aviary.android.feather.headless.moa.MoaActionList;
import com.aviary.android.feather.headless.moa.MoaPointParameter;
import com.aviary.android.feather.library.graphics.RectD;
import com.aviary.android.feather.library.vo.EditToolResultVO;
import com.aviary.android.feather.library.vo.ToolActionVO;
import com.aviary.android.feather.sdk.widget.CropImageView;
import org.json.JSONException;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            CropPanel

class mCropRect extends AviaryAsyncTask
{

    MoaActionList mActionList;
    RectD mCropRect;
    final CropPanel this$0;

    protected transient Bitmap doInBackground(Bitmap abitmap[])
    {
        Object obj = abitmap[0];
        double d = ((Bitmap) (obj)).getWidth();
        double d1 = ((Bitmap) (obj)).getHeight();
        obj = new MoaPointParameter();
        ((MoaPointParameter) (obj)).setValue((int)mCropRect.left, (int)mCropRect.top);
        MoaPointParameter moapointparameter = new MoaPointParameter();
        moapointparameter.setValue((int)mCropRect.width(), (int)mCropRect.height());
        MoaPointParameter moapointparameter1 = new MoaPointParameter(d, d1);
        ((CropFilter)mFilter).setTopLeft(((MoaPointParameter) (obj)));
        ((CropFilter)mFilter).setSize(moapointparameter);
        ((CropFilter)mFilter).setPreviewSize(moapointparameter1);
        mActionList = (MoaActionList)((CropFilter)mFilter).getActions().clone();
        try
        {
            obj = ((CropFilter)mFilter).execute(abitmap[0], null, 1, 1);
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
            return abitmap[0];
        }
        return ((Bitmap) (obj));
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Bitmap[])aobj);
    }

    protected void doPostExecute(Bitmap bitmap)
    {
        onProgressEnd();
        ((CropImageView)mImageView).setImageBitmap(bitmap, ((CropImageView)mImageView).getAspectRatio(), ((CropImageView)mImageView).getAspectRatioIsFixed());
        ((CropImageView)mImageView).setHighlightView(null);
        mEditResult.setActionList(mActionList);
        mEditResult.setToolAction(new ToolActionVO());
        onComplete(bitmap);
    }

    protected volatile void doPostExecute(Object obj)
    {
        doPostExecute((Bitmap)obj);
    }

    protected void doPreExecute()
    {
        onProgressStart();
    }

    public (RectD rectd)
    {
        this$0 = CropPanel.this;
        super();
        mCropRect = rectd;
    }
}

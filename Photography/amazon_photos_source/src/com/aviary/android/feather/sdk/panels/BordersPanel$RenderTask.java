// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import com.aviary.android.feather.common.tracking.AviaryTracker;
import com.aviary.android.feather.common.utils.os.AviaryAsyncTask;
import com.aviary.android.feather.headless.filters.IntensityNativeFilter;
import com.aviary.android.feather.headless.moa.MoaResult;
import com.aviary.android.feather.library.filters.BorderFilter;
import com.aviary.android.feather.library.services.IAviaryController;
import com.aviary.android.feather.library.services.PreferenceService;
import com.aviary.android.feather.library.utils.BitmapUtils;
import com.aviary.android.feather.library.vo.EditToolResultVO;
import com.aviary.android.feather.library.vo.ToolActionVO;
import com.aviary.android.feather.sdk.widget.ImageViewWithIntensity;
import it.sephiroth.android.library.imagezoom.ImageViewTouch;
import it.sephiroth.android.library.tooltip.TooltipManager;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONException;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            BordersPanel

protected class intensity extends AviaryAsyncTask
    implements android.content.Listener
{

    com.aviary.android.feather.cds.apper currentEffect;
    IntensityNativeFilter filter;
    float intensity;
    String mError;
    MoaResult mMoaMainExecutor;
    int mPosition;
    final BordersPanel this$0;

    private IntensityNativeFilter initFilter(com.aviary.android.feather.cds.apper apper, int i, float f)
    {
        try
        {
            apper = (IntensityNativeFilter)loadNativeFilter(apper, i, true, f);
        }
        // Misplaced declaration of an exception variable
        catch (com.aviary.android.feather.cds.apper apper)
        {
            apper.printStackTrace();
            return null;
        }
        if (apper == null)
        {
            return null;
        }
        if (apper instanceof BorderFilter)
        {
            ((BorderFilter)apper).setHiRes(false);
        }
        try
        {
            mMoaMainExecutor = apper.prepare(mBitmap, mPreview, 1, 1);
        }
        // Misplaced declaration of an exception variable
        catch (com.aviary.android.feather.cds.apper apper)
        {
            apper.printStackTrace();
            mMoaMainExecutor = null;
            return null;
        }
        return apper;
    }

    public transient Bitmap doInBackground(com.aviary.android.feather.cds.apper aapper[])
    {
        if (!isCancelled())
        {
            aapper = aapper[0];
            currentEffect = aapper;
            filter = initFilter(aapper, mPosition, intensity);
            if (filter == null)
            {
                currentEffect = null;
                return null;
            }
            mIsRendering = Boolean.valueOf(true);
            if (!isCancelled())
            {
                try
                {
                    mMoaMainExecutor.execute();
                }
                // Misplaced declaration of an exception variable
                catch (com.aviary.android.feather.cds.apper aapper[])
                {
                    mError = aapper.getMessage();
                    aapper.printStackTrace();
                    return null;
                }
                if (!isCancelled())
                {
                    return mMoaMainExecutor.outputBitmap;
                }
            }
        }
        return null;
    }

    public volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((com.aviary.android.feather.cds.apper[])aobj);
    }

    public void doPostExecute(Bitmap bitmap)
    {
        mFilter = filter;
        BordersPanel.access$502(BordersPanel.this, false);
        if (!isActive())
        {
            return;
        }
        mPreview = bitmap;
        mRenderedEffect = currentEffect;
        if (bitmap == null || mMoaMainExecutor == null || mMoaMainExecutor.active == 0)
        {
            onRestoreOriginalBitmap();
            if (mError != null)
            {
                onGenericError(mError, 0x104000a, null);
            }
            setIsChanged(false);
        } else
        {
            onApplyNewBitmap(bitmap);
            if (mRenderedEffect != null)
            {
                bitmap = new HashMap();
                bitmap.put("pack", mRenderedEffect.getPackageName());
                bitmap.put("item", mRenderedEffect.getIdentifier());
                bitmap.put("intensity_adjusted", String.valueOf(mFilter.getIntensity()));
                getContext().getTracker().tagEventAttributes((new StringBuilder()).append(getName().name().toLowerCase(Locale.US)).append(": item_previewed").toString(), bitmap);
                bitmap = new ToolActionVO();
                bitmap.setPackIdentifier(mRenderedEffect.getPackageName());
                bitmap.setContentIdentifier(mRenderedEffect.getIdentifier());
                mEditResult.setActionList(mFilter.getActions());
                mEditResult.setToolAction(bitmap);
                mTrackingAttributes.put("item", mRenderedEffect.getIdentifier());
                mTrackingAttributes.put("pack", mRenderedEffect.getPackageName());
            } else
            {
                mEditResult.setToolAction(null);
                mEditResult.setActionList(null);
                mTrackingAttributes.remove("item");
                mTrackingAttributes.remove("pack");
            }
        }
        if (BordersPanel.access$200(BordersPanel.this) != com.aviary.android.feather.cds.)
        {
            onProgressEnd();
        }
        mIsRendering = Boolean.valueOf(false);
        BordersPanel.access$602(BordersPanel.this, null);
    }

    public volatile void doPostExecute(Object obj)
    {
        doPostExecute((Bitmap)obj);
    }

    protected void doPreExecute()
    {
        boolean flag = true;
        if (BordersPanel.access$200(BordersPanel.this) != com.aviary.android.feather.cds.)
        {
            onProgressStart();
        }
        BordersPanel.access$502(BordersPanel.this, true);
        ImageViewWithIntensity imageviewwithintensity = (ImageViewWithIntensity)mImageView;
        if (!getIntensityIsManaged() || !getIntensitySliderEnabled())
        {
            flag = false;
        }
        imageviewwithintensity.setSwipeGestureEnabled(flag);
    }

    protected void onApplyNewBitmap(Bitmap bitmap)
    {
        int i;
        boolean flag;
        if (getIntensityIsManaged() || !getIntensitySliderEnabled())
        {
            mImageView.postInvalidate();
        } else
        {
            ((ImageViewWithIntensity)mImageView).setPreviewBitmap(bitmap, 255F);
        }
        ((ImageViewWithIntensity)mImageView).setSwipeGestureEnabled(getIntensitySliderEnabled());
        bitmap = BordersPanel.this;
        if (mRenderedEffect != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        bitmap.setIsChanged(flag);
        bitmap = BordersPanel.this;
        i = ((BordersPanel) (bitmap)).mSliderIntensityTooltip;
        bitmap.mSliderIntensityTooltip = i + 1;
        if (i == 0 && getIntensitySliderEnabled())
        {
            bitmap = (ImageViewWithIntensity)mImageView;
            PointF pointf = bitmap.playDemo();
            mTooltipManager.create(0).ctionBarSize(((com.aviary.android.feather.sdk.therContext)getContext().getBaseContext()).getActionBarSize()).nchor(new Point((int)((double)pointf.x - (double)bitmap.getTooltipSize() * 1.8500000000000001D), (int)pointf.y + bitmap.getTooltipSize() / 2), it.sephiroth.android.library.tooltip.EFT).ext(getContext().getBaseContext().getResources(), com.aviary.android.feather.sdk.intensity_tooltip).losePolicy(it.sephiroth.android.library.tooltip.cy.None, 2500L).axWidth((int)((double)bitmap.getWidth() / 2.5D)).howDelay(100L).ithStyleId(com.aviary.android.feather.sdk.tip).oggleArrow(false).ithCustomView(com.aviary.android.feather.sdk.ntensity_tooltip, false).how();
            if (mPreferenceService != null)
            {
                mPreferenceService.containsSingleTimeKey(getClass(), "intensity.slider.tooltip", true);
            }
        }
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        cancel(true);
    }

    public void onCancelled()
    {
        super.onCancelled();
        if (mMoaMainExecutor != null)
        {
            mMoaMainExecutor.cancel();
        }
        mIsRendering = Boolean.valueOf(false);
    }

    protected void onRestoreOriginalBitmap()
    {
        mLogger.o("onRestoreOriginalBitmap");
        mPreview = BitmapUtils.copy(mBitmap, android.graphics.dersPanel.mBitmap);
        if (getIntensitySliderEnabled())
        {
            if (getIntensityIsManaged())
            {
                mImageView.setImageBitmap(mPreview, null, 1.0F, 1.0F);
            } else
            {
                ((ImageViewWithIntensity)mImageView).setPreviewBitmap(mPreview, 255F);
            }
            ((ImageViewWithIntensity)mImageView).setIntensity(255F);
            ((ImageViewWithIntensity)mImageView).setSwipeGestureEnabled(false);
        } else
        {
            mImageView.setImageBitmap(mPreview, null, 1.0F, 1.0F);
        }
        setIsChanged(false);
    }

    public ter(int i, float f)
    {
        this$0 = BordersPanel.this;
        super();
        mPosition = i;
        intensity = f;
    }
}

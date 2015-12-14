// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.aviary.android.feather.headless.filters.NativeVignetteToolFilter;
import com.aviary.android.feather.library.content.ToolEntry;
import com.aviary.android.feather.library.services.IAviaryController;
import com.aviary.android.feather.library.utils.BitmapUtils;
import com.aviary.android.feather.library.vo.EditToolResultVO;
import com.aviary.android.feather.library.vo.ToolActionVO;
import com.aviary.android.feather.sdk.widget.ImageViewVignette;
import it.sephiroth.android.library.imagezoom.ImageViewTouch;
import it.sephiroth.android.library.imagezoom.graphics.FastBitmapDrawable;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            AbstractSliderContentPanel

public class VignettePanel extends AbstractSliderContentPanel
    implements com.aviary.android.feather.sdk.widget.ImageViewVignette.OnVignetteChangeListener
{

    public VignettePanel(IAviaryController iaviarycontroller, ToolEntry toolentry)
    {
        super(iaviarycontroller, toolentry);
    }

    protected View generateContentView(LayoutInflater layoutinflater)
    {
        return layoutinflater.inflate(com.aviary.android.feather.sdk.R.layout.aviary_content_vignette, null);
    }

    protected ViewGroup generateOptionView(LayoutInflater layoutinflater, ViewGroup viewgroup)
    {
        return (ViewGroup)layoutinflater.inflate(com.aviary.android.feather.sdk.R.layout.aviary_panel_wheel, viewgroup, false);
    }

    public boolean isRendering()
    {
        return false;
    }

    public void onActivate()
    {
        super.onActivate();
        Bitmap bitmap = ((NativeVignetteToolFilter)mFilter).getBitmap();
        ((ImageViewVignette)mImageView).setImageBitmap(mBitmap, bitmap, null, -1F, 8F);
        ((ImageViewVignette)mImageView).setOnVignetteChangeListener(this);
        contentReady();
    }

    public void onCreate(Bitmap bitmap, Bundle bundle)
    {
        super.onCreate(bitmap, bundle);
        mImageView = (ImageViewTouch)getContentView().findViewById(com.aviary.android.feather.sdk.R.id.aviary_image);
        mImageView.setDisplayType(it.sephiroth.android.library.imagezoom.ImageViewTouchBase.DisplayType.FIT_IF_BIGGER);
        setValue((((ImageViewVignette)mImageView).getVignetteIntensity() + 100) / 2);
        ((NativeVignetteToolFilter)mFilter).createBitmap(mBitmap.getWidth(), mBitmap.getHeight(), 3);
    }

    public void onDeactivate()
    {
        ((ImageViewVignette)mImageView).setOnVignetteChangeListener(null);
        super.onDeactivate();
    }

    protected void onDispose()
    {
        ((NativeVignetteToolFilter)mFilter).clearBitmap();
        ((NativeVignetteToolFilter)mFilter).dispose();
        super.onDispose();
    }

    protected void onGenerateResult(EditToolResultVO edittoolresultvo)
    {
        mPreview = BitmapUtils.copy(mBitmap, mBitmap.getConfig());
        ((ImageViewVignette)mImageView).generateBitmap(mPreview);
        android.graphics.drawable.Drawable drawable = mImageView.getDrawable();
        if (drawable instanceof FastBitmapDrawable)
        {
            ((FastBitmapDrawable)drawable).setBitmap(mPreview);
            ((NativeVignetteToolFilter)mFilter).clearBitmap();
            mImageView.invalidate();
        }
        mEditResult.setActionList(((NativeVignetteToolFilter)mFilter).getActions());
        mEditResult.setToolAction(new ToolActionVO(Integer.valueOf(0)));
        onComplete(mPreview, edittoolresultvo);
    }

    protected void onSliderChanged(int i, boolean flag)
    {
        if (flag)
        {
            ((ImageViewVignette)mImageView).setVignetteIntensity(i * 2 - 100);
        }
    }

    protected void onSliderEnd(int i)
    {
    }

    protected void onSliderStart(int i)
    {
    }

    public void onVignetteChange(ImageViewVignette imageviewvignette, Bitmap bitmap, RectF rectf, int i, float f)
    {
        if (((NativeVignetteToolFilter)mFilter).renderPreview(rectf, i, f))
        {
            setIsChanged(true);
            mImageView.invalidate();
        }
    }
}

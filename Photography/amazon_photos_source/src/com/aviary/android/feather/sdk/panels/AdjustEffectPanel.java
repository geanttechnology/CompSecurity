// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.aviary.android.feather.library.content.ToolEntry;
import com.aviary.android.feather.library.filters.AdjustFilter;
import com.aviary.android.feather.library.filters.ToolLoaderFactory;
import com.aviary.android.feather.library.services.IAviaryController;
import com.aviary.android.feather.library.vo.EditToolResultVO;
import com.aviary.android.feather.library.vo.ToolActionVO;
import com.aviary.android.feather.sdk.FeatherActivity;
import com.aviary.android.feather.sdk.utils.Maturity;
import com.aviary.android.feather.sdk.widget.AdjustImageView;
import com.aviary.android.feather.sdk.widget.AviaryHighlightImageButton;
import org.json.JSONException;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            AbstractContentPanel

public class AdjustEffectPanel extends AbstractContentPanel
    implements android.view.View.OnClickListener, com.aviary.android.feather.sdk.widget.AdjustImageView.OnResetListener
{

    boolean isClosing;
    private AdjustImageView mAdjustImageView;
    private ImageView mButton1;
    private ImageView mButton2;
    private ImageView mButton3;
    private ImageView mButton4;

    public AdjustEffectPanel(IAviaryController iaviarycontroller, ToolEntry toolentry, com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools tools)
    {
        super(iaviarycontroller, toolentry);
        mFilter = ToolLoaderFactory.get(tools);
    }

    protected View generateContentView(LayoutInflater layoutinflater)
    {
        return layoutinflater.inflate(com.aviary.android.feather.sdk.R.layout.aviary_content_adjust, null);
    }

    protected ViewGroup generateOptionView(LayoutInflater layoutinflater, ViewGroup viewgroup)
    {
        int i;
        if (FeatherActivity.MATURITY.isKidsFriendly())
        {
            i = com.aviary.android.feather.sdk.R.layout.aviary_panel_adjust_freetime;
        } else
        {
            i = com.aviary.android.feather.sdk.R.layout.aviary_panel_adjust;
        }
        return (ViewGroup)layoutinflater.inflate(i, viewgroup, false);
    }

    public boolean getIsChanged()
    {
        boolean flag = mAdjustImageView.getStraightenStarted();
        int i = (int)mAdjustImageView.getCurrentRotation();
        int j = mAdjustImageView.getFlipType();
        return i != 0 || j != com.aviary.android.feather.sdk.widget.AdjustImageView.FlipType.FLIP_NONE.nativeInt || flag;
    }

    public volatile boolean isRendering()
    {
        return super.isRendering();
    }

    public void onActivate()
    {
        super.onActivate();
        mAdjustImageView.setImageBitmap(mBitmap);
        mAdjustImageView.setOnResetListener(this);
        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);
        mButton4.setOnClickListener(this);
        contentReady();
    }

    public void onBitmapReplaced(Bitmap bitmap)
    {
        super.onBitmapReplaced(bitmap);
        if (isActive())
        {
            mAdjustImageView.setImageBitmap(mBitmap);
            mAdjustImageView.resetToOriginal();
        }
    }

    public boolean onCancel()
    {
        if (isClosing)
        {
            return true;
        }
        isClosing = true;
        setEnabled(false);
        int i = (int)mAdjustImageView.getCurrentRotation();
        boolean flag = mAdjustImageView.getHorizontalFlip();
        boolean flag1 = mAdjustImageView.getVerticalFlip();
        boolean flag2 = mAdjustImageView.getStraightenStarted();
        double d = mAdjustImageView.getStraightenAngle();
        if (i != 0 || flag || flag1 || flag2 && d != 0.0D)
        {
            mAdjustImageView.reset();
            return true;
        } else
        {
            return false;
        }
    }

    public void onClick(View view)
    {
        if (isActive() && isEnabled())
        {
            int i = view.getId();
            if (i == com.aviary.android.feather.sdk.R.id.aviary_button1)
            {
                mAdjustImageView.rotate90(false);
                return;
            }
            if (i == com.aviary.android.feather.sdk.R.id.aviary_button2)
            {
                mAdjustImageView.rotate90(true);
                return;
            }
            if (i == com.aviary.android.feather.sdk.R.id.aviary_button3)
            {
                mAdjustImageView.flip(true);
                return;
            }
            if (i == com.aviary.android.feather.sdk.R.id.aviary_button4)
            {
                mAdjustImageView.flip(false);
                return;
            }
        }
    }

    public void onCreate(Bitmap bitmap, Bundle bundle)
    {
        super.onCreate(bitmap, bundle);
        mAdjustImageView = (AdjustImageView)getContentView().findViewById(com.aviary.android.feather.sdk.R.id.aviary_overlay);
        bitmap = getOptionView();
        if (FeatherActivity.MATURITY.isKidsFriendly())
        {
            mButton1 = (ImageView)bitmap.findViewById(com.aviary.android.feather.sdk.R.id.aviary_button1);
            mButton2 = (ImageView)bitmap.findViewById(com.aviary.android.feather.sdk.R.id.aviary_button2);
            mButton3 = (ImageView)bitmap.findViewById(com.aviary.android.feather.sdk.R.id.aviary_button3);
            mButton4 = (ImageView)bitmap.findViewById(com.aviary.android.feather.sdk.R.id.aviary_button4);
            return;
        } else
        {
            mButton1 = (AviaryHighlightImageButton)bitmap.findViewById(com.aviary.android.feather.sdk.R.id.aviary_button1);
            mButton2 = (AviaryHighlightImageButton)bitmap.findViewById(com.aviary.android.feather.sdk.R.id.aviary_button2);
            mButton3 = (AviaryHighlightImageButton)bitmap.findViewById(com.aviary.android.feather.sdk.R.id.aviary_button3);
            mButton4 = (AviaryHighlightImageButton)bitmap.findViewById(com.aviary.android.feather.sdk.R.id.aviary_button4);
            return;
        }
    }

    public void onDeactivate()
    {
        mAdjustImageView.setOnResetListener(null);
        mButton1.setOnClickListener(null);
        mButton2.setOnClickListener(null);
        mButton3.setOnClickListener(null);
        mButton4.setOnClickListener(null);
        super.onDeactivate();
    }

    public void onDestroy()
    {
        mAdjustImageView.setImageBitmap(null);
        super.onDestroy();
    }

    protected void onGenerateResult()
    {
        int i = (int)mAdjustImageView.getCurrentRotation();
        double d = mAdjustImageView.getStraightenAngle();
        boolean flag = mAdjustImageView.getHorizontalFlip();
        boolean flag1 = mAdjustImageView.getVerticalFlip();
        double d1 = 1.0D / mAdjustImageView.getGrowthFactor();
        AdjustFilter adjustfilter = (AdjustFilter)mFilter;
        adjustfilter.setFlip(flag, flag1);
        adjustfilter.setFixedRotation(i);
        adjustfilter.setStraighten(d, d1, d1);
        Bitmap bitmap;
        try
        {
            bitmap = adjustfilter.execute(mBitmap, null, 1, 1);
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
            onGenericError(jsonexception);
            return;
        }
        mAdjustImageView.setImageBitmap(bitmap);
        mEditResult.setActionList(adjustfilter.getActions());
        mEditResult.setToolAction(new ToolActionVO(Integer.valueOf(0)));
        onComplete(bitmap);
    }

    public void onResetComplete()
    {
        getContext().cancel();
    }

    public volatile void setEnabled(boolean flag)
    {
        super.setEnabled(flag);
    }
}

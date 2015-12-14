// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.aviary.android.feather.library.content.ToolEntry;
import com.aviary.android.feather.library.services.BadgeService;
import com.aviary.android.feather.sdk.AviaryMainController;
import com.aviary.android.feather.sdk.FeatherActivity;

public class AviaryBadgeToolLayout extends LinearLayout
    implements com.aviary.android.feather.library.services.BadgeService.OnToolBadgesUpdateListener
{
    public static interface OnAttachStatusListener
    {

        public abstract void onAttachedtoWindow(View view);

        public abstract void onDetachedFromWindow(View view);

        public abstract void onFinishTemporaryDetach(View view);
    }


    static final String LOG_TAG = "AviaryBadgeToolLayout";
    BadgeService mBadgeService;
    View mBadgeView;
    ImageView mImageView;
    OnAttachStatusListener mOnAttachStatusListener;
    TextView mTextView;

    public AviaryBadgeToolLayout(Context context)
    {
        this(context, null);
    }

    public AviaryBadgeToolLayout(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public AviaryBadgeToolLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset);
    }

    protected void finalize()
        throws Throwable
    {
        removeFromService();
        super.finalize();
    }

    protected void hideBadge()
    {
        if (mBadgeView != null)
        {
            mBadgeView.setVisibility(8);
        }
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if (mBadgeService != null)
        {
            onToolBadgesUpdate(mBadgeService);
        }
        if (mOnAttachStatusListener != null)
        {
            mOnAttachStatusListener.onAttachedtoWindow(this);
        }
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (mOnAttachStatusListener != null)
        {
            mOnAttachStatusListener.onDetachedFromWindow(this);
        }
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        mBadgeView = findViewById(com.aviary.android.feather.sdk.R.id.aviary_badge);
        mTextView = (TextView)findViewById(com.aviary.android.feather.sdk.R.id.aviary_text);
        mImageView = (ImageView)findViewById(com.aviary.android.feather.sdk.R.id.aviary_image);
        registerToService();
    }

    public void onFinishTemporaryDetach()
    {
        super.onFinishTemporaryDetach();
        if (mOnAttachStatusListener != null)
        {
            mOnAttachStatusListener.onFinishTemporaryDetach(this);
        }
    }

    protected void onTagChanged(Object obj)
    {
        if (obj != null)
        {
            obj = (ToolEntry)obj;
            mImageView.setImageResource(((ToolEntry) (obj)).iconResourceId);
            mTextView.setText(((ToolEntry) (obj)).labelResourceId);
            if (getContext() != null)
            {
                setContentDescription(getContext().getString(((ToolEntry) (obj)).labelResourceId));
            }
            if (mBadgeService != null)
            {
                onToolBadgesUpdate(mBadgeService);
            }
            postInvalidate();
        }
    }

    public void onToolBadgeSingleUpdate(BadgeService badgeservice, com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools tools)
    {
label0:
        {
            ToolEntry toolentry = (ToolEntry)getTag();
            if (toolentry != null && toolentry.name == tools)
            {
                Log.i("AviaryBadgeToolLayout", (new StringBuilder()).append("onToolBadgeSingleUpdate: ").append(tools).toString());
                if (!badgeservice.getIsActive(toolentry.name))
                {
                    break label0;
                }
                showBadge();
            }
            return;
        }
        hideBadge();
    }

    public void onToolBadgesUpdate(BadgeService badgeservice)
    {
label0:
        {
            ToolEntry toolentry = (ToolEntry)getTag();
            if (toolentry != null)
            {
                if (!badgeservice.getIsActive(toolentry.name))
                {
                    break label0;
                }
                showBadge();
            }
            return;
        }
        hideBadge();
    }

    protected void registerToService()
    {
        Object obj = (FeatherActivity)getContext();
        if (obj != null)
        {
            obj = ((FeatherActivity) (obj)).getMainController();
            if (obj != null)
            {
                mBadgeService = (BadgeService)((AviaryMainController) (obj)).getService(com/aviary/android/feather/library/services/BadgeService);
                mBadgeService.registerOnToolBadgesUpdateListener(this);
            }
        }
    }

    protected void removeFromService()
    {
        if (mBadgeService != null)
        {
            mBadgeService.removeOnToolBadgesUpdateListener(this);
        }
    }

    public void setOnAttachStatusListener(OnAttachStatusListener onattachstatuslistener)
    {
        mOnAttachStatusListener = onattachstatuslistener;
    }

    public void setTag(Object obj)
    {
        super.setTag(obj);
        onTagChanged(obj);
    }

    protected void showBadge()
    {
    }
}

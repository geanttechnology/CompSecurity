// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import co.vine.android.drawable.RecyclableBitmapDrawable;

public class ImagePreference extends Preference
{
    public static interface OnImagePreferenceBoundListener
    {

        public abstract void onImagePeferenceBound(ImagePreference imagepreference);
    }


    private ImageView mBorder;
    private Context mContext;
    private ImageView mImage;
    private OnImagePreferenceBoundListener mListener;

    public ImagePreference(Context context)
    {
        this(context, null);
    }

    public ImagePreference(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public ImagePreference(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        setLayoutResource(0x7f03004a);
        setSelectable(false);
        mContext = context;
    }

    protected void onBindView(View view)
    {
        super.onBindView(view);
        mImage = (ImageView)view.findViewById(0x7f0a0063);
        mBorder = (ImageView)view.findViewById(0x7f0a022a);
        mListener.onImagePeferenceBound(this);
    }

    protected View onCreateView(ViewGroup viewgroup)
    {
        viewgroup = super.onCreateView(viewgroup);
        android.view.ViewGroup.LayoutParams layoutparams = viewgroup.getLayoutParams();
        layoutparams.height = (int)mContext.getResources().getDimension(0x7f0b0055);
        viewgroup.setLayoutParams(layoutparams);
        return viewgroup;
    }

    public void setBitmap(Bitmap bitmap)
    {
        if (mImage != null)
        {
            mImage.setImageDrawable(new RecyclableBitmapDrawable(mContext.getResources(), bitmap));
        }
    }

    public void setBorderDrawable(Drawable drawable)
    {
        if (mBorder != null)
        {
            mBorder.setImageDrawable(drawable);
        }
    }

    public void setDrawable(Drawable drawable)
    {
        if (mImage != null)
        {
            mImage.setImageDrawable(drawable);
        }
    }

    public void setImageClickListener(android.view.View.OnClickListener onclicklistener)
    {
        if (mImage != null)
        {
            mImage.setOnClickListener(onclicklistener);
        }
    }

    public void setPreferenceBoundListener(OnImagePreferenceBoundListener onimagepreferenceboundlistener)
    {
        mListener = onimagepreferenceboundlistener;
    }
}

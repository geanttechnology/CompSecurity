// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photoselector.uicomp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import fr;
import nl;
import no;
import nw;

// Referenced classes of package com.fotoable.photoselector.uicomp:
//            RecycleableImageView

public class EncryptItemView extends RelativeLayout
    implements no
{

    private static final String TAG = "EncryptItemView";
    private CheckBox mCheckBox;
    private FrameLayout mCheckView;
    private nl mData;
    private RecycleableImageView mImage;
    private fr mImageWorker;
    private TextView mNumberMask;

    public EncryptItemView(Context context, fr fr1)
    {
        super(context);
        if (fr1 == null)
        {
            Log.e("EncryptItemView", "Set empty worker!");
        }
        mImageWorker = fr1;
        ContructView();
    }

    private void ContructView()
    {
        ViewGroup viewgroup = (ViewGroup)View.inflate(getContext(), com.fotoable.fotophotoselector.R.layout.view_encryptitem, this);
        mImage = new RecycleableImageView(getContext());
        android.widget.FrameLayout.LayoutParams layoutparams1 = new android.widget.FrameLayout.LayoutParams(-1, -1);
        viewgroup.addView(mImage, layoutparams1);
        mCheckBox = (CheckBox)viewgroup.findViewById(com.fotoable.fotophotoselector.R.id.checkBox1);
        mImage.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
        mCheckBox.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final EncryptItemView a;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                if (a.mData != null)
                {
                    a.mData.c(flag);
                }
            }

            
            {
                a = EncryptItemView.this;
                super();
            }
        });
        if (mNumberMask == null)
        {
            mNumberMask = new TextView(getContext());
            android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-1, -1);
            layoutparams.gravity = 17;
            mNumberMask.setGravity(17);
            mNumberMask.setTextAppearance(getContext(), com.fotoable.fotophotoselector.R.style.MaskNumberAppearance);
            mNumberMask.setLayoutParams(layoutparams);
            addView(mNumberMask);
        }
        if (mCheckView == null)
        {
            mCheckView = new FrameLayout(getContext());
            Object obj = new android.widget.FrameLayout.LayoutParams(-1, -1);
            obj.gravity = 17;
            mCheckView.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            obj = new ImageView(getContext());
            android.widget.FrameLayout.LayoutParams layoutparams2 = new android.widget.FrameLayout.LayoutParams(dip2px(getContext(), 20F), dip2px(getContext(), 20F));
            layoutparams2.gravity = 85;
            ((ImageView) (obj)).setBackgroundResource(com.fotoable.fotophotoselector.R.drawable.photo_checked);
            ((ImageView) (obj)).setLayoutParams(layoutparams2);
            mCheckView.addView(((View) (obj)));
            addView(mCheckView);
        }
    }

    private static int dip2px(Context context, float f)
    {
        return (int)(context.getResources().getDisplayMetrics().density * f + 0.5F);
    }

    private void refreshView()
    {
label0:
        {
            mImageWorker.a(mData, mImage);
            if (mData.g())
            {
                mCheckBox.setVisibility(0);
            } else
            {
                mCheckBox.setVisibility(4);
            }
            mCheckBox.setChecked(mData.h());
            if (mNumberMask != null)
            {
                if (mData.d())
                {
                    mNumberMask.setText(String.format("%d", new Object[] {
                        Integer.valueOf(mData.e())
                    }));
                    mNumberMask.setVisibility(0);
                } else
                {
                    mNumberMask.setVisibility(4);
                }
            }
            if (mCheckView != null)
            {
                if (!mData.c())
                {
                    break label0;
                }
                mCheckView.setVisibility(0);
            }
            return;
        }
        mCheckView.setVisibility(4);
    }

    public void SetDataItem(nl nl1)
    {
        if (nl1 == null)
        {
            Log.e("EncryptItemView", "Set empty data!");
            return;
        }
        if (mData != null)
        {
            mData.b(this);
        }
        mData = nl1;
        nl1.a(this);
        refreshView();
    }

    public void cancelImageLoad()
    {
        fr.a(mImage);
    }

    public Bitmap getImageBitmap()
    {
        return mImage.getDrawingCache();
    }

    public Bitmap getImageDefaultBitmap()
    {
        return mImageWorker.f();
    }

    public void onStatusChange(int i, Object obj)
    {
        if (i == 1)
        {
            if (mData.g())
            {
                mCheckBox.setVisibility(0);
            } else
            {
                mCheckBox.setVisibility(4);
            }
            mCheckBox.setChecked(mData.h());
        } else
        {
            if (i == 2)
            {
                if (mData.d())
                {
                    mNumberMask.setText(String.format("%d", new Object[] {
                        Integer.valueOf(mData.e())
                    }));
                    mNumberMask.setVisibility(0);
                    return;
                } else
                {
                    mNumberMask.setVisibility(4);
                    return;
                }
            }
            if (i == 3)
            {
                if (mData.c())
                {
                    mCheckView.setVisibility(0);
                    return;
                } else
                {
                    mCheckView.setVisibility(4);
                    return;
                }
            }
        }
    }

    public void recycleImage()
    {
        while (nw.a(getContext()) || mImageWorker.g() != null || mImage == null || mImage.getImageBitmap() == mImageWorker.f()) 
        {
            return;
        }
        mImage.recycleImage();
    }

    public void setImageToDefaultBitmp()
    {
        if (mImage == null)
        {
            return;
        } else
        {
            Bitmap bitmap = mImageWorker.f();
            mImage.setImageBitmap(bitmap);
            return;
        }
    }

}

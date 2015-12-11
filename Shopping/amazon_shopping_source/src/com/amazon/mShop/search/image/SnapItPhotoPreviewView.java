// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.image;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.BitmapUtil;
import com.amazon.mShop.util.JpegUtils;
import java.io.ByteArrayOutputStream;

// Referenced classes of package com.amazon.mShop.search.image:
//            SnapItPhotoPreviewActivity, SnapItActivity

public class SnapItPhotoPreviewView extends LinearLayout
{

    private final SnapItPhotoPreviewActivity mActivity;
    private ImageView mPhotoCapturePreview;
    private ImageButton mRetakeButton;
    private ImageButton mUseButton;

    public SnapItPhotoPreviewView(SnapItPhotoPreviewActivity snapitphotopreviewactivity)
    {
        super(snapitphotopreviewactivity);
        mActivity = snapitphotopreviewactivity;
        LayoutInflater.from(snapitphotopreviewactivity).inflate(com.amazon.mShop.android.lib.R.layout.snapit_photo_preview, this, true);
        mUseButton = (ImageButton)findViewById(com.amazon.mShop.android.lib.R.id.photo_preview_use);
        mUseButton.setOnClickListener(new android.view.View.OnClickListener() {

            final SnapItPhotoPreviewView this$0;

            public void onClick(View view)
            {
                if (!view.isInTouchMode())
                {
                    doUsePhoto();
                }
            }

            
            {
                this$0 = SnapItPhotoPreviewView.this;
                super();
            }
        });
        mUseButton.setOnTouchListener(new android.view.View.OnTouchListener() {

            final SnapItPhotoPreviewView this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (motionevent.getAction() == 1)
                {
                    doUsePhoto();
                }
                return false;
            }

            
            {
                this$0 = SnapItPhotoPreviewView.this;
                super();
            }
        });
        mRetakeButton = (ImageButton)findViewById(com.amazon.mShop.android.lib.R.id.photo_preview_retake);
        mRetakeButton.setOnClickListener(new android.view.View.OnClickListener() {

            final SnapItPhotoPreviewView this$0;

            public void onClick(View view)
            {
                if (!view.isInTouchMode())
                {
                    doRetakePhoto();
                }
            }

            
            {
                this$0 = SnapItPhotoPreviewView.this;
                super();
            }
        });
        mRetakeButton.setOnTouchListener(new android.view.View.OnTouchListener() {

            final SnapItPhotoPreviewView this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (motionevent.getAction() == 1)
                {
                    doRetakePhoto();
                }
                return false;
            }

            
            {
                this$0 = SnapItPhotoPreviewView.this;
                super();
            }
        });
        mUseButton.requestFocus();
        mPhotoCapturePreview = (ImageView)findViewById(com.amazon.mShop.android.lib.R.id.photo_preview);
        BitmapUtil.tryInCaseOfOutOfMemory(new Runnable() {

            final SnapItPhotoPreviewView this$0;

            public void run()
            {
                Bitmap bitmap = JpegUtils.jpegToBitmap(mActivity.getLastCapturedPhoto());
                com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(bitmap. new Runnable() {

                    final _cls5 this$1;
                    final Bitmap val$bmp;

                    public void run()
                    {
                        mPhotoCapturePreview.setImageBitmap(bmp);
                    }

            
            {
                this$1 = final__pcls5;
                bmp = Bitmap.this;
                super();
            }
                });
            }

            
            {
                this$0 = SnapItPhotoPreviewView.this;
                super();
            }
        });
    }

    private void doRetakePhoto()
    {
        mActivity.retakePhoto();
    }

    private void doUsePhoto()
    {
        Object obj = (BitmapDrawable)mPhotoCapturePreview.getDrawable();
        if (obj != null)
        {
            obj = ((BitmapDrawable) (obj)).getBitmap();
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            ((Bitmap) (obj)).compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, bytearrayoutputstream);
            SnapItActivity.setLastPhotoCaptured(bytearrayoutputstream.toByteArray());
            mActivity.usePhoto();
        }
    }




}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import co.vine.android.client.AppController;
import co.vine.android.client.AppSessionListener;
import co.vine.android.drawable.RecyclableBitmapDrawable;
import co.vine.android.network.HttpResult;
import co.vine.android.util.Util;
import co.vine.android.util.image.ImageKey;
import co.vine.android.util.image.UrlImage;
import java.util.HashMap;

// Referenced classes of package co.vine.android:
//            BaseControllerFragment

public class ImageFragment extends BaseControllerFragment
    implements android.view.View.OnTouchListener
{
    private class ImageSessionListener extends AppSessionListener
    {

        final ImageFragment this$0;

        private void finishFailed()
        {
            mHandler.post(new Runnable() {

                final ImageSessionListener this$1;

                public void run()
                {
                    Util.showCenteredToast(getActivity(), 0x7f0e0119);
                    getActivity().finish();
                }

            
            {
                this$1 = ImageSessionListener.this;
                super();
            }
            });
        }

        public void onPhotoImageError(ImageKey imagekey, HttpResult httpresult)
        {
            if (imagekey.equals(mImageKey))
            {
                finishFailed();
            }
        }

        public void onPhotoImageLoaded(HashMap hashmap)
        {
            hashmap = (UrlImage)hashmap.get(mImageKey);
            if (hashmap != null && hashmap.isValid())
            {
                mProgress.setVisibility(8);
                mImageView.setImageDrawable(new RecyclableBitmapDrawable(mImageView.getResources(), ((UrlImage) (hashmap)).bitmap));
            }
        }

        private ImageSessionListener()
        {
            this$0 = ImageFragment.this;
            super();
        }

    }


    public static final String ARG_IMAGE_URL = "image_url";
    public static final String STATE_IMAGE_BITMAP = "state_image_bitmap";
    private long mFirstTouch;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private Bitmap mImageBitmap;
    private ImageKey mImageKey;
    private ImageView mImageView;
    private ProgressBar mProgress;

    public ImageFragment()
    {
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (bundle == null)
        {
            bundle = getArguments().getString("image_url");
            if (!TextUtils.isEmpty(bundle))
            {
                mImageKey = new ImageKey(bundle);
                bundle = mAppController.getPhotoBitmap(mImageKey);
                if (bundle != null)
                {
                    mImageBitmap = bundle;
                } else
                {
                    mProgress.setVisibility(0);
                }
            }
            mImageView.setOnTouchListener(this);
            return;
        } else
        {
            mImageBitmap = (Bitmap)bundle.getParcelable("state_image_bitmap");
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mAppSessionListener = new ImageSessionListener();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030049, viewgroup, false);
        mImageView = (ImageView)layoutinflater.findViewById(0x7f0a0046);
        mProgress = (ProgressBar)layoutinflater.findViewById(0x7f0a0030);
        return layoutinflater;
    }

    public void onResume()
    {
        super.onResume();
        Bitmap bitmap = mImageBitmap;
        if (bitmap != null)
        {
            mImageView.setImageDrawable(new RecyclableBitmapDrawable(getResources(), bitmap));
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (mImageBitmap != null)
        {
            bundle.putParcelable("state_image_bitmap", mImageBitmap);
        }
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (motionevent.getAction() != 1)
        {
            return false;
        }
        long l = System.currentTimeMillis();
        if (l - mFirstTouch < 400L)
        {
            getActivity().finish();
            return true;
        } else
        {
            mFirstTouch = l;
            return true;
        }
    }




}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import android.widget.ProgressBar;
import co.vine.android.client.AppSessionListener;
import co.vine.android.drawable.RecyclableBitmapDrawable;
import co.vine.android.network.HttpResult;
import co.vine.android.util.Util;
import co.vine.android.util.image.ImageKey;
import co.vine.android.util.image.UrlImage;
import java.util.HashMap;

// Referenced classes of package co.vine.android:
//            ImageFragment

private class <init> extends AppSessionListener
{

    final ImageFragment this$0;

    private void finishFailed()
    {
        ImageFragment.access$400(ImageFragment.this).post(new Runnable() {

            final ImageFragment.ImageSessionListener this$1;

            public void run()
            {
                Util.showCenteredToast(getActivity(), 0x7f0e0119);
                getActivity().finish();
            }

            
            {
                this$1 = ImageFragment.ImageSessionListener.this;
                super();
            }
        });
    }

    public void onPhotoImageError(ImageKey imagekey, HttpResult httpresult)
    {
        if (imagekey.equals(ImageFragment.access$100(ImageFragment.this)))
        {
            finishFailed();
        }
    }

    public void onPhotoImageLoaded(HashMap hashmap)
    {
        hashmap = (UrlImage)hashmap.get(ImageFragment.access$100(ImageFragment.this));
        if (hashmap != null && hashmap.isValid())
        {
            ImageFragment.access$200(ImageFragment.this).setVisibility(8);
            ImageFragment.access$300(ImageFragment.this).setImageDrawable(new RecyclableBitmapDrawable(ImageFragment.access$300(ImageFragment.this).getResources(), ((UrlImage) (hashmap)).bitmap));
        }
    }

    private _cls1.this._cls1()
    {
        this$0 = ImageFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}

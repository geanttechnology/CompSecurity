// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.DisplayMetrics;
import co.vine.android.util.image.ImageUtils;
import java.lang.ref.WeakReference;

public class SetThumbnailTask extends AsyncTask
{
    public static interface SetThumbnailListener
    {

        public abstract void setThumbnailImage(Bitmap bitmap);
    }


    private final WeakReference mFragmentRef;
    private final WeakReference mSupportFragmentRef;

    public SetThumbnailTask(Fragment fragment)
    {
        mFragmentRef = new WeakReference(fragment);
        mSupportFragmentRef = null;
    }

    public SetThumbnailTask(android.support.v4.app.Fragment fragment)
    {
        mSupportFragmentRef = new WeakReference(fragment);
        mFragmentRef = null;
    }

    protected transient Bitmap doInBackground(Uri auri[])
    {
        Activity activity = null;
        if (mSupportFragmentRef == null) goto _L2; else goto _L1
_L1:
        activity = getSupportFragmentActivity();
_L7:
        if (activity != null) goto _L4; else goto _L3
_L3:
        return null;
_L2:
        if (mFragmentRef != null)
        {
            activity = getFragmentActivity();
        }
        continue; /* Loop/switch isn't completed */
_L4:
        Uri uri;
        uri = auri[0];
        auri = activity.getResources();
        float f = (float)auri.getDimensionPixelSize(0x7f0b0087) * auri.getDisplayMetrics().density;
        Bitmap bitmap = ImageUtils.resizeBitmap(activity, uri, f, f, 0);
        auri = bitmap;
        if (bitmap != null)
        {
            auri = ImageUtils.getCroppedBitmap(bitmap, (int)f);
        }
        if (auri == null) goto _L3; else goto _L5
_L5:
        return ImageUtils.adjustRotation(activity, uri, auri);
        if (true) goto _L7; else goto _L6
_L6:
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Uri[])aobj);
    }

    protected Activity getFragmentActivity()
    {
        Fragment fragment = (Fragment)mFragmentRef.get();
        if (fragment == null)
        {
            return null;
        } else
        {
            return fragment.getActivity();
        }
    }

    protected Activity getSupportFragmentActivity()
    {
        android.support.v4.app.Fragment fragment = (android.support.v4.app.Fragment)mSupportFragmentRef.get();
        if (fragment == null)
        {
            return null;
        } else
        {
            return fragment.getActivity();
        }
    }

    protected void onPostExecute(Bitmap bitmap)
    {
        Object obj = null;
        if (mSupportFragmentRef == null) goto _L2; else goto _L1
_L1:
        obj = mSupportFragmentRef.get();
_L4:
        if (obj != null)
        {
            ((SetThumbnailListener)obj).setThumbnailImage(bitmap);
        }
        return;
_L2:
        if (mFragmentRef != null)
        {
            obj = mFragmentRef.get();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Bitmap)obj);
    }
}

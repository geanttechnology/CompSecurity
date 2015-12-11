// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.Toast;
import co.vine.android.util.Util;
import co.vine.android.util.image.ImageUtils;
import com.edisonwang.android.slog.SLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class ImagePicker
{
    public static interface Listener
    {

        public abstract void setAvatarUrl(Uri uri);
    }


    private long mActiveUserId;
    private Activity mActivity;
    private Listener mListener;
    private Uri mSavedImageUri;

    public ImagePicker(Activity activity, Listener listener, long l)
    {
        mActivity = activity;
        mActiveUserId = l;
        mListener = listener;
    }

    public void captureImage(int i)
    {
        Object obj = ImageUtils.getTempPic(mActivity, false, mActiveUserId);
        if (obj == null || !ImageUtils.hasEnoughExternalStorageForNewPhoto(mActivity))
        {
            Toast.makeText(mActivity, 0x7f0e0055, 0).show();
            return;
        }
        Object obj1 = mActivity.getString(0x7f0e019d);
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("title", ((String) (obj1)));
        contentvalues.put("description", ((String) (obj1)));
        obj = Uri.fromFile(((File) (obj)));
        mListener.setAvatarUrl(((Uri) (obj)));
        obj1 = (new Intent("android.media.action.IMAGE_CAPTURE")).putExtra("output", ((android.os.Parcelable) (obj)));
        try
        {
            mActivity.startActivityForResult(((Intent) (obj1)), i);
            return;
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            Util.showCenteredToast(mActivity, 0x7f0e0256);
        }
        ImageUtils.deleteTempPic(((Uri) (obj)));
        mListener.setAvatarUrl(null);
    }

    public void chooseImage(int i)
    {
        Intent intent = new Intent("android.intent.action.PICK", android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        try
        {
            mActivity.startActivityForResult(intent, i);
            return;
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            Util.showCenteredToast(mActivity, 0x7f0e0256);
        }
    }

    public Uri getSavedImageUri()
    {
        return mSavedImageUri;
    }

    public void saveProfileImage(Bitmap bitmap)
    {
        File file = new File(Util.getExternalCacheDir(mActivity), "twitter_profile.jpg");
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, bytearrayoutputstream);
        bitmap = bytearrayoutputstream.toByteArray();
        try
        {
            FileOutputStream fileoutputstream = new FileOutputStream(file);
            fileoutputstream.write(bitmap);
            fileoutputstream.close();
            mSavedImageUri = Uri.fromFile(file);
            SLog.d("Pending Uri for profile photo is {}.", mSavedImageUri);
            mListener.setAvatarUrl(mSavedImageUri);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap) { }
        if (mActivity != null)
        {
            mActivity.runOnUiThread(new Runnable() {

                final ImagePicker this$0;

                public void run()
                {
                    Toast.makeText(mActivity, 0x7f0e0190, 0).show();
                }

            
            {
                this$0 = ImagePicker.this;
                super();
            }
            });
        }
        mListener.setAvatarUrl(null);
    }

}

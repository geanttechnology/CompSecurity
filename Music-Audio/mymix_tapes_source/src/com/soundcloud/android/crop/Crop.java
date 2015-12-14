// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.soundcloud.android.crop;

import android.app.Activity;
import android.app.Fragment;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

// Referenced classes of package com.soundcloud.android.crop:
//            CropImageActivity

public class Crop
{
    static interface Extra
    {

        public static final String ASPECT_X = "aspect_x";
        public static final String ASPECT_Y = "aspect_y";
        public static final String ERROR = "error";
        public static final String MAX_X = "max_x";
        public static final String MAX_Y = "max_y";
    }


    public static final int REQUEST_CROP = 6709;
    public static final int REQUEST_PICK = 9162;
    public static final int RESULT_ERROR = 404;
    private Intent cropIntent;

    public Crop(Uri uri)
    {
        cropIntent = new Intent();
        cropIntent.setData(uri);
    }

    public static Throwable getError(Intent intent)
    {
        return (Throwable)intent.getSerializableExtra("error");
    }

    public static Uri getOutput(Intent intent)
    {
        return (Uri)intent.getParcelableExtra("output");
    }

    public static void pickImage(Activity activity)
    {
        Intent intent = (new Intent("android.intent.action.GET_CONTENT")).setType("image/*");
        try
        {
            activity.startActivityForResult(intent, 9162);
            return;
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            Toast.makeText(activity, R.string.crop__pick_error, 0).show();
        }
    }

    public Crop asSquare()
    {
        cropIntent.putExtra("aspect_x", 1);
        cropIntent.putExtra("aspect_y", 1);
        return this;
    }

    Intent getIntent(Context context)
    {
        cropIntent.setClass(context, com/soundcloud/android/crop/CropImageActivity);
        return cropIntent;
    }

    public Crop output(Uri uri)
    {
        cropIntent.putExtra("output", uri);
        return this;
    }

    public void start(Activity activity)
    {
        activity.startActivityForResult(getIntent(activity), 6709);
    }

    public void start(Context context, Fragment fragment)
    {
        fragment.startActivityForResult(getIntent(context), 6709);
    }

    public Crop withAspect(int i, int j)
    {
        cropIntent.putExtra("aspect_x", i);
        cropIntent.putExtra("aspect_y", j);
        return this;
    }

    public Crop withMaxSize(int i, int j)
    {
        cropIntent.putExtra("max_x", i);
        cropIntent.putExtra("max_y", j);
        return this;
    }
}

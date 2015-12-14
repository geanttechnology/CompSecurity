// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.aviary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.amazon.gallery.framework.gallery.actions.LaunchAviary;
import com.amazon.gallery.thor.app.FreeTimeCommon;
import com.aviary.android.feather.headless.utils.MegaPixels;
import com.aviary.android.feather.sdk.FeatherActivity;
import java.io.File;

public class ThorLaunchAviary
    implements LaunchAviary
{

    private final com.amazon.gallery.thor.app.FreeTimeCommon.ProfileState userTheme;

    public ThorLaunchAviary(Context context)
    {
        userTheme = FreeTimeCommon.getUserTheme(context);
    }

    public void launch(Activity activity, Uri uri, File file, int i)
    {
        Intent intent = new Intent(activity, com/aviary/android/feather/sdk/FeatherActivity);
        intent.setData(uri);
        intent.putExtra("extra-api-key-secret", "oeriumv75k11lb1h");
        intent.putExtra("output", Uri.parse((new StringBuilder()).append("file://").append(file.getAbsolutePath()).toString()));
        intent.putExtra("output-format", android.graphics.Bitmap.CompressFormat.JPEG.name());
        intent.putExtra("output-quality", 85);
        intent.putExtra("output-hires-megapixels", MegaPixels.Mp30.ordinal());
        setOptionalExtras(intent);
        intent.putExtra("maturity", userTheme.getMaturity());
        intent.putExtra("save-on-no-changes", false);
        activity.startActivityForResult(intent, i);
    }

    protected void setOptionalExtras(Intent intent)
    {
    }
}

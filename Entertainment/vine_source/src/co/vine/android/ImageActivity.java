// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

// Referenced classes of package co.vine.android:
//            BaseControllerActionBarActivity, ImageFragment, BaseCursorListFragment

public class ImageActivity extends BaseControllerActionBarActivity
{

    public static final String EXTRA_IMAGE_URL = "image_url";
    public static final String FRAGMENT_TAG = "image_fragment";

    public ImageActivity()
    {
    }

    public static void start(Context context, String s, int i)
    {
        Intent intent = new Intent(context, co/vine/android/ImageActivity);
        intent.putExtra("image_url", s);
        intent.putExtra("title", i);
        context.startActivity(intent);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle, 0x7f030046, true);
        setRequestedOrientation(1);
        Intent intent = getIntent();
        int i = intent.getIntExtra("title", 0);
        if (i == 0)
        {
            throw new IllegalArgumentException("An ActionBar title resourceId must be provided when starting this Activity.");
        }
        setupActionBar(Boolean.valueOf(true), Boolean.valueOf(true), i, Boolean.valueOf(true));
        if (bundle == null)
        {
            bundle = new ImageFragment();
            intent.putExtra("take_focus", true);
            bundle.setArguments(BaseCursorListFragment.prepareArguments(intent, false));
            getSupportFragmentManager().beginTransaction().add(0x7f0a0102, bundle, "image_fragment").commit();
        }
    }
}

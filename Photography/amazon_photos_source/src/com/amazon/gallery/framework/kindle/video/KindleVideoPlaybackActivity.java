// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.video;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.amazon.gallery.thor.app.activity.ThorNativeGalleryActivity;

public class KindleVideoPlaybackActivity extends Activity
{

    public KindleVideoPlaybackActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = new Intent(getIntent());
        bundle.setClass(this, com/amazon/gallery/thor/app/activity/ThorNativeGalleryActivity);
        startActivity(bundle);
    }
}

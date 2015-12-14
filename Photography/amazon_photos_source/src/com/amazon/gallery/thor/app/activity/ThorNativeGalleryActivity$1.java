// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.os.AsyncTask;
import com.amazon.gallery.framework.gallery.demo.PhotosDemoManager;
import com.amazon.gallery.thor.app.FeatureChecker;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.di.AppKeys;
import com.amazon.gallery.whisperplay.WhisperPlayConnectionManager;
import com.amazon.identity.auth.device.api.MAPAccountManager;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            ThorNativeGalleryActivity

class this._cls0 extends AsyncTask
{

    final ThorNativeGalleryActivity this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        if (ThorNativeGalleryActivity.access$000(ThorNativeGalleryActivity.this).isInDemoMode() || !(new MAPAccountManager(ThorNativeGalleryActivity.this)).isDeviceRegistered())
        {
            ((ThorGalleryApplication)getApplication()).onFirstSyncCompleted();
        }
        if (ThorNativeGalleryActivity.access$100(ThorNativeGalleryActivity.this).hasWhisperplay())
        {
            ((WhisperPlayConnectionManager)getApplicationBean(AppKeys.WHISPER_PLAY_CONNECTION_MANAGER)).initWithActivity(ThorNativeGalleryActivity.this, false);
        }
        return null;
    }

    ()
    {
        this$0 = ThorNativeGalleryActivity.this;
        super();
    }
}

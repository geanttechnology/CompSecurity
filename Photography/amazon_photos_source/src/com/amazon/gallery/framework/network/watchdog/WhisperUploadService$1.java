// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.watchdog;

import android.content.SharedPreferences;
import com.amazon.gallery.framework.network.multiqueueuploader.MultiQueueUploader;
import com.amazon.gallery.framework.network.multiqueueuploader.QueueType;

// Referenced classes of package com.amazon.gallery.framework.network.watchdog:
//            WhisperUploadService

class this._cls0
    implements android.content.redPreferenceChangeListener
{

    final WhisperUploadService this$0;

    public void onSharedPreferenceChanged(SharedPreferences sharedpreferences, String s)
    {
        if (sharedpreferences != null)
        {
            boolean flag = WhisperUploadService.access$000(WhisperUploadService.this);
            boolean flag1 = WhisperUploadService.access$100(WhisperUploadService.this);
            WhisperUploadService.access$002(WhisperUploadService.this, WhisperUploadService.access$200(getApplicationContext(), sharedpreferences));
            WhisperUploadService.access$102(WhisperUploadService.this, sharedpreferences.getBoolean("wan_allowed_key", false));
            WhisperUploadService.access$302(WhisperUploadService.this, sharedpreferences.getBoolean("auto_upload_only_when_charging_key", false));
            if (!flag && WhisperUploadService.access$000(WhisperUploadService.this) || !flag1 && WhisperUploadService.access$100(WhisperUploadService.this))
            {
                WhisperUploadService.access$400(WhisperUploadService.this, false);
            }
            multiQueueUploader.allowUpload(QueueType.AUTO_SAVE, WhisperUploadService.access$000(WhisperUploadService.this));
            if (!WhisperUploadService.access$000(WhisperUploadService.this))
            {
                cancelUpload(QueueType.AUTO_SAVE);
                return;
            }
        }
    }

    oader()
    {
        this$0 = WhisperUploadService.this;
        super();
    }
}

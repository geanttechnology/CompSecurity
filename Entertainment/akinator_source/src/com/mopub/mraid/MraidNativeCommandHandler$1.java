// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mraid;

import android.content.Context;
import android.widget.Toast;
import com.mopub.common.logging.MoPubLog;

// Referenced classes of package com.mopub.mraid:
//            MraidNativeCommandHandler, MraidCommandException

class aidCommandFailureListener
    implements wnloadImageAsyncTask.DownloadImageAsyncTaskListener
{

    final MraidNativeCommandHandler this$0;
    final Context val$context;
    final aidCommandFailureListener val$failureListener;

    public void onFailure()
    {
        Toast.makeText(val$context, "Image failed to download.", 0).show();
        MoPubLog.d("Error downloading and saving image file.");
        val$failureListener.onFailure(new MraidCommandException("Error downloading and saving image file."));
    }

    public void onSuccess()
    {
        MoPubLog.d("Image successfully saved.");
    }

    aidCommandFailureListener()
    {
        this$0 = final_mraidnativecommandhandler;
        val$context = context1;
        val$failureListener = aidCommandFailureListener.this;
        super();
    }
}

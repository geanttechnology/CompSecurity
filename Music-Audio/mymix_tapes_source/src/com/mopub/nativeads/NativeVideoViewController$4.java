// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.view.TextureView;
import android.view.View;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;

// Referenced classes of package com.mopub.nativeads:
//            NativeVideoViewController, NativeVideoController, NativeFullScreenVideoView

class this._cls0
    implements android.view.ller._cls4
{

    final NativeVideoViewController this$0;

    public void onClick(View view)
    {
        NativeVideoViewController.access$200(NativeVideoViewController.this).setPlayWhenReady(false);
        NativeVideoViewController.access$402(NativeVideoViewController.this, NativeVideoViewController.access$100(NativeVideoViewController.this).getTextureView().getBitmap());
        (new com.mopub.common..getTextureView()).rtedUrlActions(UrlAction.OPEN_IN_APP_BROWSER, new UrlAction[0]).R().handleUrl(NativeVideoViewController.access$600(NativeVideoViewController.this), "https://www.mopub.com/optout/");
    }

    ()
    {
        this$0 = NativeVideoViewController.this;
        super();
    }
}

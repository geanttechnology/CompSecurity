// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.graphics.SurfaceTexture;

// Referenced classes of package com.mopub.nativeads:
//            MoPubCustomEventVideoNative, NativeVideoController, MediaLayout

class this._cls0
    implements android.view.veAd._cls3
{

    final deoState.PAUSED this$0;

    public void onSurfaceTextureAvailable(SurfaceTexture surfacetexture, int i, int j)
    {
        cess._mth500(this._cls0.this).setListener(this._cls0.this);
        cess._mth500(this._cls0.this).setOnAudioFocusChangeListener(this._cls0.this);
        cess._mth500(this._cls0.this).setProgressListener(this._cls0.this);
        cess._mth500(this._cls0.this).setTextureView(cess._mth600(this._cls0.this).getTextureView());
        cess._mth600(this._cls0.this).resetProgress();
        long l = cess._mth500(this._cls0.this).getDuration();
        long l1 = cess._mth500(this._cls0.this).getCurrentPosition();
        if (cess._mth700(this._cls0.this) == 5 || l > 0L && l - l1 < 750L)
        {
            cess._mth802(this._cls0.this, true);
        }
        if (cess._mth900(this._cls0.this))
        {
            cess._mth902(this._cls0.this, false);
            cess._mth500(this._cls0.this).prepare(this._cls0.this);
        }
        cess._mth1002(this._cls0.this, true);
        cess._mth100(this._cls0.this);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfacetexture)
    {
        cess._mth902(this._cls0.this, true);
        cess._mth500(this._cls0.this).release(this._cls0.this);
        plyState(deoState.PAUSED);
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfacetexture, int i, int j)
    {
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfacetexture)
    {
    }

    deoState()
    {
        this$0 = this._cls0.this;
        super();
    }
}

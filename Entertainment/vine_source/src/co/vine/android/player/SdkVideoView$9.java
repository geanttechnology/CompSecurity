// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.player;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.widget.MediaController;
import com.google.android.exoplayer.ExoPlayer;
import com.google.android.exoplayer.MediaCodecVideoTrackRenderer;

// Referenced classes of package co.vine.android.player:
//            SdkVideoView

class this._cls0
    implements android.view.faceTextureListener
{

    final SdkVideoView this$0;

    public void onSurfaceTextureAvailable(SurfaceTexture surfacetexture, int i, int j)
    {
        SdkVideoView.access$602(SdkVideoView.this, new Surface(surfacetexture));
        if (SdkVideoView.access$2300(SdkVideoView.this) == null)
        {
            SdkVideoView.access$2400(SdkVideoView.this);
            return;
        } else
        {
            SdkVideoView.access$2300(SdkVideoView.this).onSurfaceTextureAvailable(SdkVideoView.this);
            return;
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfacetexture)
    {
        SdkVideoView.access$602(SdkVideoView.this, null);
        if (SdkVideoView.access$3000(SdkVideoView.this) != null)
        {
            SdkVideoView.access$3000(SdkVideoView.this).hide();
        }
        if (SdkVideoView.access$1300(SdkVideoView.this) != null && SdkVideoView.access$1200(SdkVideoView.this) != null)
        {
            SdkVideoView.access$1300(SdkVideoView.this).blockingSendMessage(SdkVideoView.access$1200(SdkVideoView.this), MediaCodecVideoTrackRenderer.MSG_SET_SURFACE, null);
        }
        SdkVideoView.access$900(SdkVideoView.this, true);
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfacetexture, int i, int j)
    {
        SdkVideoView.access$2502(SdkVideoView.this, i);
        SdkVideoView.access$2602(SdkVideoView.this, j);
        boolean flag;
        if (SdkVideoView.access$2700(SdkVideoView.this) == 6)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (mVideoWidth == i && mVideoHeight == j)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (SdkVideoView.access$2800(SdkVideoView.this) && flag && i != 0)
        {
            if (SdkVideoView.access$2900(SdkVideoView.this) != 0)
            {
                seekTo(SdkVideoView.access$2900(SdkVideoView.this));
            }
            start();
        }
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfacetexture)
    {
        SdkVideoView.access$602(SdkVideoView.this, new Surface(surfacetexture));
        if (SdkVideoView.access$2800(SdkVideoView.this) && SdkVideoView.access$2700(SdkVideoView.this) == 6)
        {
            if (SdkVideoView.access$2900(SdkVideoView.this) != 0)
            {
                seekTo(SdkVideoView.access$2900(SdkVideoView.this));
            }
            start();
        }
    }

    ()
    {
        this$0 = SdkVideoView.this;
        super();
    }
}

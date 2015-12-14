// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.view.Surface;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zzmn;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.android.gms.ads.internal.overlay:
//            zzi, zzp, zzh

public class zzc extends zzi
    implements android.media.AudioManager.OnAudioFocusChangeListener, android.media.MediaPlayer.OnBufferingUpdateListener, android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnErrorListener, android.media.MediaPlayer.OnInfoListener, android.media.MediaPlayer.OnPreparedListener, android.media.MediaPlayer.OnVideoSizeChangedListener, android.view.TextureView.SurfaceTextureListener
{

    private static final Map zzAO;
    private final com.google.android.gms.ads.internal.overlay.zzp zzAP;
    private int zzAQ;
    private int zzAR;
    private MediaPlayer zzAS;
    private Uri zzAT;
    private int zzAU;
    private int zzAV;
    private int zzAW;
    private int zzAX;
    private int zzAY;
    private float zzAZ;
    private boolean zzBa;
    private boolean zzBb;
    private int zzBc;
    private zzh zzBd;

    public zzc(Context context, com.google.android.gms.ads.internal.overlay.zzp zzp1)
    {
        super(context);
        zzAQ = 0;
        zzAR = 0;
        zzAZ = 1.0F;
        setSurfaceTextureListener(this);
        zzAP = zzp1;
        zzAP.zza(this);
    }

    static zzh zza(zzc zzc1)
    {
        return zzc1.zzBd;
    }

    private void zzb(float f)
    {
        if (zzAS != null)
        {
            try
            {
                zzAS.setVolume(f, f);
                return;
            }
            catch (IllegalStateException illegalstateexception)
            {
                return;
            }
        } else
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
            return;
        }
    }

    private void zzeA()
    {
        com.google.android.gms.ads.internal.util.client.zzb.v("AdMediaPlayerView audio focus lost");
        zzBb = false;
        zzeB();
    }

    private void zzeB()
    {
        if (!zzBa && zzBb)
        {
            zzb(zzAZ);
            return;
        } else
        {
            zzb(0.0F);
            return;
        }
    }

    private AudioManager zzeC()
    {
        return (AudioManager)getContext().getSystemService("audio");
    }

    private void zzes()
    {
        SurfaceTexture surfacetexture;
        com.google.android.gms.ads.internal.util.client.zzb.v("AdMediaPlayerView init MediaPlayer");
        surfacetexture = getSurfaceTexture();
        if (zzAT == null || surfacetexture == null)
        {
            return;
        }
        zzt(false);
        zzAS = new MediaPlayer();
        zzAS.setOnBufferingUpdateListener(this);
        zzAS.setOnCompletionListener(this);
        zzAS.setOnErrorListener(this);
        zzAS.setOnInfoListener(this);
        zzAS.setOnPreparedListener(this);
        zzAS.setOnVideoSizeChangedListener(this);
        zzAW = 0;
        zzAS.setDataSource(getContext(), zzAT);
        zzAS.setSurface(new Surface(surfacetexture));
        zzAS.setAudioStreamType(3);
        zzAS.setScreenOnWhilePlaying(true);
        zzAS.prepareAsync();
        zzt(1);
        return;
        Object obj;
        obj;
_L2:
        com.google.android.gms.ads.internal.util.client.zzb.zzd((new StringBuilder("Failed to initialize MediaPlayer at ")).append(zzAT).toString(), ((Throwable) (obj)));
        onError(zzAS, 1, 0);
        return;
        obj;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void zzet()
    {
        if (zzew() && zzAS.getCurrentPosition() > 0 && zzAR != 3)
        {
            com.google.android.gms.ads.internal.util.client.zzb.v("AdMediaPlayerView nudging MediaPlayer");
            zzb(0.0F);
            zzAS.start();
            int i = zzAS.getCurrentPosition();
            for (long l = zzp.zzbz().currentTimeMillis(); zzew() && zzAS.getCurrentPosition() == i && zzp.zzbz().currentTimeMillis() - l <= 250L;) { }
            zzAS.pause();
            zzeB();
        }
    }

    private void zzeu()
    {
label0:
        {
            AudioManager audiomanager = zzeC();
            if (audiomanager != null && !zzBb)
            {
                if (audiomanager.requestAudioFocus(this, 3, 2) != 1)
                {
                    break label0;
                }
                zzez();
            }
            return;
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("AdMediaPlayerView audio focus request failed");
    }

    private void zzev()
    {
label0:
        {
            com.google.android.gms.ads.internal.util.client.zzb.v("AdMediaPlayerView abandon audio focus");
            AudioManager audiomanager = zzeC();
            if (audiomanager != null && zzBb)
            {
                if (audiomanager.abandonAudioFocus(this) != 1)
                {
                    break label0;
                }
                zzBb = false;
            }
            return;
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("AdMediaPlayerView abandon audio focus failed");
    }

    private boolean zzew()
    {
        return zzAS != null && zzAQ != -1 && zzAQ != 0 && zzAQ != 1;
    }

    private void zzez()
    {
        com.google.android.gms.ads.internal.util.client.zzb.v("AdMediaPlayerView audio focus gained");
        zzBb = true;
        zzeB();
    }

    private void zzt(int i)
    {
        if (i != 3) goto _L2; else goto _L1
_L1:
        zzAP.zzfe();
_L4:
        zzAQ = i;
        return;
_L2:
        if (zzAQ == 3 && i != 3)
        {
            zzAP.zzff();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void zzt(boolean flag)
    {
        com.google.android.gms.ads.internal.util.client.zzb.v("AdMediaPlayerView release");
        if (zzAS != null)
        {
            zzAS.reset();
            zzAS.release();
            zzAS = null;
            zzt(0);
            if (flag)
            {
                zzAR = 0;
                zzu(0);
            }
            zzev();
        }
    }

    private void zzu(int i)
    {
        zzAR = i;
    }

    public int getCurrentPosition()
    {
        if (zzew())
        {
            return zzAS.getCurrentPosition();
        } else
        {
            return 0;
        }
    }

    public int getDuration()
    {
        if (zzew())
        {
            return zzAS.getDuration();
        } else
        {
            return -1;
        }
    }

    public int getVideoHeight()
    {
        if (zzAS != null)
        {
            return zzAS.getVideoHeight();
        } else
        {
            return 0;
        }
    }

    public int getVideoWidth()
    {
        if (zzAS != null)
        {
            return zzAS.getVideoWidth();
        } else
        {
            return 0;
        }
    }

    public void onAudioFocusChange(int i)
    {
        if (i > 0)
        {
            zzez();
        } else
        if (i < 0)
        {
            zzeA();
            return;
        }
    }

    public void onBufferingUpdate(MediaPlayer mediaplayer, int i)
    {
        zzAW = i;
    }

    public void onCompletion(MediaPlayer mediaplayer)
    {
        com.google.android.gms.ads.internal.util.client.zzb.v("AdMediaPlayerView completion");
        zzt(5);
        zzu(5);
        zzid.zzIE.post(new Runnable() {

            final zzc zzBe;

            public void run()
            {
                if (zzc.zza(zzBe) != null)
                {
                    zzc.zza(zzBe).zzeT();
                }
            }

            
            {
                zzBe = zzc.this;
                super();
            }
        });
    }

    public boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        mediaplayer = (String)zzAO.get(Integer.valueOf(i));
        String s = (String)zzAO.get(Integer.valueOf(j));
        com.google.android.gms.ads.internal.util.client.zzb.zzaH((new StringBuilder("AdMediaPlayerView MediaPlayer error: ")).append(mediaplayer).append(":").append(s).toString());
        zzt(-1);
        zzu(-1);
        zzid.zzIE.post(new Runnable(mediaplayer, s) {

            final zzc zzBe;
            final String zzBf;
            final String zzBg;

            public void run()
            {
                if (zzc.zza(zzBe) != null)
                {
                    zzc.zza(zzBe).zzh(zzBf, zzBg);
                }
            }

            
            {
                zzBe = zzc.this;
                zzBf = s;
                zzBg = s1;
                super();
            }
        });
        return true;
    }

    public boolean onInfo(MediaPlayer mediaplayer, int i, int j)
    {
        mediaplayer = (String)zzAO.get(Integer.valueOf(i));
        String s = (String)zzAO.get(Integer.valueOf(j));
        com.google.android.gms.ads.internal.util.client.zzb.v((new StringBuilder("AdMediaPlayerView MediaPlayer info: ")).append(mediaplayer).append(":").append(s).toString());
        return true;
    }

    protected void onMeasure(int i, int j)
    {
        int k;
        int l;
        int i1;
        int k1;
        i1 = getDefaultSize(zzAU, i);
        k1 = getDefaultSize(zzAV, j);
        l = k1;
        k = i1;
        if (zzAU <= 0) goto _L2; else goto _L1
_L1:
        l = k1;
        k = i1;
        if (zzAV <= 0) goto _L2; else goto _L3
_L3:
        int l1;
        k1 = android.view.View.MeasureSpec.getMode(i);
        i = android.view.View.MeasureSpec.getSize(i);
        l1 = android.view.View.MeasureSpec.getMode(j);
        j = android.view.View.MeasureSpec.getSize(j);
        if (k1 != 0x40000000 || l1 != 0x40000000) goto _L5; else goto _L4
_L4:
        if (zzAU * j < zzAV * i)
        {
            k = (zzAU * j) / zzAV;
            l = j;
        } else
        if (zzAU * j > zzAV * i)
        {
            l = (zzAV * i) / zzAU;
            k = i;
        } else
        {
            l = j;
            k = i;
        }
_L2:
        setMeasuredDimension(k, l);
        if (android.os.Build.VERSION.SDK_INT == 16)
        {
            if (zzAX > 0 && zzAX != k || zzAY > 0 && zzAY != l)
            {
                zzet();
            }
            zzAX = k;
            zzAY = l;
        }
        return;
_L5:
        if (k1 == 0x40000000)
        {
            l = (zzAV * i) / zzAU;
            int j1;
            if (l1 == 0x80000000 && l > j)
            {
                l = j;
                k = i;
            } else
            {
                k = i;
            }
        } else
        if (l1 == 0x40000000)
        {
            j1 = (zzAU * j) / zzAV;
            l = j;
            k = j1;
            if (k1 == 0x80000000)
            {
                l = j;
                k = j1;
                if (j1 > i)
                {
                    l = j;
                    k = i;
                }
            }
        } else
        {
            j1 = zzAU;
            k = zzAV;
            if (l1 == 0x80000000 && k > j)
            {
                j1 = (zzAU * j) / zzAV;
            } else
            {
                j = k;
            }
            l = j;
            k = j1;
            if (k1 == 0x80000000)
            {
                l = j;
                k = j1;
                if (j1 > i)
                {
                    l = (zzAV * i) / zzAU;
                    k = i;
                }
            }
        }
        if (true) goto _L2; else goto _L6
_L6:
    }

    public void onPrepared(MediaPlayer mediaplayer)
    {
        com.google.android.gms.ads.internal.util.client.zzb.v("AdMediaPlayerView prepared");
        zzt(2);
        zzAP.zzeR();
        zzid.zzIE.post(new Runnable() {

            final zzc zzBe;

            public void run()
            {
                if (zzc.zza(zzBe) != null)
                {
                    zzc.zza(zzBe).zzeR();
                }
            }

            
            {
                zzBe = zzc.this;
                super();
            }
        });
        zzAU = mediaplayer.getVideoWidth();
        zzAV = mediaplayer.getVideoHeight();
        if (zzBc != 0)
        {
            seekTo(zzBc);
        }
        zzet();
        com.google.android.gms.ads.internal.util.client.zzb.zzaG((new StringBuilder("AdMediaPlayerView stream dimensions: ")).append(zzAU).append(" x ").append(zzAV).toString());
        if (zzAR == 3)
        {
            play();
        }
        zzeu();
        zzeB();
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfacetexture, int i, int j)
    {
        com.google.android.gms.ads.internal.util.client.zzb.v("AdMediaPlayerView surface created");
        zzes();
        zzid.zzIE.post(new Runnable() {

            final zzc zzBe;

            public void run()
            {
                if (zzc.zza(zzBe) != null)
                {
                    zzc.zza(zzBe).zzeQ();
                }
            }

            
            {
                zzBe = zzc.this;
                super();
            }
        });
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfacetexture)
    {
        com.google.android.gms.ads.internal.util.client.zzb.v("AdMediaPlayerView surface destroyed");
        if (zzAS != null && zzBc == 0)
        {
            zzBc = zzAS.getCurrentPosition();
        }
        zzid.zzIE.post(new Runnable() {

            final zzc zzBe;

            public void run()
            {
                if (zzc.zza(zzBe) != null)
                {
                    zzc.zza(zzBe).onPaused();
                    zzc.zza(zzBe).zzeU();
                }
            }

            
            {
                zzBe = zzc.this;
                super();
            }
        });
        zzt(true);
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfacetexture, int i, int j)
    {
        boolean flag1 = true;
        com.google.android.gms.ads.internal.util.client.zzb.v("AdMediaPlayerView surface changed");
        boolean flag;
        if (zzAR == 3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (zzAU == i && zzAV == j)
        {
            i = ((flag1) ? 1 : 0);
        } else
        {
            i = 0;
        }
        if (zzAS != null && flag && i != 0)
        {
            if (zzBc != 0)
            {
                seekTo(zzBc);
            }
            play();
        }
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfacetexture)
    {
        zzAP.zzb(this);
    }

    public void onVideoSizeChanged(MediaPlayer mediaplayer, int i, int j)
    {
        com.google.android.gms.ads.internal.util.client.zzb.v((new StringBuilder("AdMediaPlayerView size changed: ")).append(i).append(" x ").append(j).toString());
        zzAU = mediaplayer.getVideoWidth();
        zzAV = mediaplayer.getVideoHeight();
        if (zzAU != 0 && zzAV != 0)
        {
            requestLayout();
        }
    }

    public void pause()
    {
        com.google.android.gms.ads.internal.util.client.zzb.v("AdMediaPlayerView pause");
        if (zzew() && zzAS.isPlaying())
        {
            zzAS.pause();
            zzt(4);
            zzid.zzIE.post(new Runnable() {

                final zzc zzBe;

                public void run()
                {
                    if (zzc.zza(zzBe) != null)
                    {
                        zzc.zza(zzBe).onPaused();
                    }
                }

            
            {
                zzBe = zzc.this;
                super();
            }
            });
        }
        zzu(4);
    }

    public void play()
    {
        com.google.android.gms.ads.internal.util.client.zzb.v("AdMediaPlayerView play");
        if (zzew())
        {
            zzAS.start();
            zzt(3);
            zzid.zzIE.post(new Runnable() {

                final zzc zzBe;

                public void run()
                {
                    if (zzc.zza(zzBe) != null)
                    {
                        zzc.zza(zzBe).zzeS();
                    }
                }

            
            {
                zzBe = zzc.this;
                super();
            }
            });
        }
        zzu(3);
    }

    public void seekTo(int i)
    {
        com.google.android.gms.ads.internal.util.client.zzb.v((new StringBuilder("AdMediaPlayerView seek ")).append(i).toString());
        if (zzew())
        {
            zzAS.seekTo(i);
            zzBc = 0;
            return;
        } else
        {
            zzBc = i;
            return;
        }
    }

    public void setMimeType(String s)
    {
    }

    public void setVideoPath(String s)
    {
        setVideoURI(Uri.parse(s));
    }

    public void setVideoURI(Uri uri)
    {
        zzAT = uri;
        zzBc = 0;
        zzes();
        requestLayout();
        invalidate();
    }

    public void stop()
    {
        com.google.android.gms.ads.internal.util.client.zzb.v("AdMediaPlayerView stop");
        if (zzAS != null)
        {
            zzAS.stop();
            zzAS.release();
            zzAS = null;
            zzt(0);
            zzu(0);
            zzev();
        }
        zzAP.onStop();
    }

    public String toString()
    {
        return (new StringBuilder()).append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).toString();
    }

    public void zza(float f)
    {
        zzAZ = f;
        zzeB();
    }

    public void zza(zzh zzh)
    {
        zzBd = zzh;
    }

    public String zzer()
    {
        return "MediaPlayer";
    }

    public void zzex()
    {
        zzBa = true;
        zzeB();
    }

    public void zzey()
    {
        zzBa = false;
        zzeB();
    }

    static 
    {
        HashMap hashmap = new HashMap();
        zzAO = hashmap;
        hashmap.put(Integer.valueOf(-1004), "MEDIA_ERROR_IO");
        zzAO.put(Integer.valueOf(-1007), "MEDIA_ERROR_MALFORMED");
        zzAO.put(Integer.valueOf(-1010), "MEDIA_ERROR_UNSUPPORTED");
        zzAO.put(Integer.valueOf(-110), "MEDIA_ERROR_TIMED_OUT");
        zzAO.put(Integer.valueOf(100), "MEDIA_ERROR_SERVER_DIED");
        zzAO.put(Integer.valueOf(1), "MEDIA_ERROR_UNKNOWN");
        zzAO.put(Integer.valueOf(1), "MEDIA_INFO_UNKNOWN");
        zzAO.put(Integer.valueOf(700), "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        zzAO.put(Integer.valueOf(3), "MEDIA_INFO_VIDEO_RENDERING_START");
        zzAO.put(Integer.valueOf(701), "MEDIA_INFO_BUFFERING_START");
        zzAO.put(Integer.valueOf(702), "MEDIA_INFO_BUFFERING_END");
        zzAO.put(Integer.valueOf(800), "MEDIA_INFO_BAD_INTERLEAVING");
        zzAO.put(Integer.valueOf(801), "MEDIA_INFO_NOT_SEEKABLE");
        zzAO.put(Integer.valueOf(802), "MEDIA_INFO_METADATA_UPDATE");
        zzAO.put(Integer.valueOf(901), "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
        zzAO.put(Integer.valueOf(902), "MEDIA_INFO_SUBTITLE_TIMED_OUT");
    }
}

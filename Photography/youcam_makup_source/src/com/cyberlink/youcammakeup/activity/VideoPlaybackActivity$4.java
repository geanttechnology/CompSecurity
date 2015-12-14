// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.l;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            VideoPlaybackActivity

class a
    implements l
{

    final VideoPlaybackActivity a;
    final VideoPlaybackActivity b;

    public void a(a a1)
    {
    }

    public void a(bn bn1)
    {
        if (bn1 == null);
    }

    public volatile void a(Object obj)
    {
        a((String)obj);
    }

    public void a(String s)
    {
        if (a != null)
        {
            a.runOnUiThread(new Runnable(s) {

                final String a;
                final VideoPlaybackActivity._cls4 b;

                public void run()
                {
label0:
                    {
                        if (VideoPlaybackActivity.d(b.b) != null)
                        {
                            android.graphics.Bitmap bitmap = BitmapFactory.decodeFile(a);
                            if (bitmap == null)
                            {
                                break label0;
                            }
                            VideoPlaybackActivity.d(b.b).setImageBitmap(bitmap);
                        }
                        return;
                    }
                    VideoPlaybackActivity.d(b.b).setImageResource(0x7f0208a2);
                }

            
            {
                b = VideoPlaybackActivity._cls4.this;
                a = s;
                super();
            }
            });
        }
    }

    public void a(Void void1)
    {
    }

    public void b(Object obj)
    {
        a((bn)obj);
    }

    public void c(Object obj)
    {
        a((Void)obj);
    }

    public void d(Object obj)
    {
        a((a)obj);
    }

    _cls1.a(VideoPlaybackActivity videoplaybackactivity, VideoPlaybackActivity videoplaybackactivity1)
    {
        b = videoplaybackactivity;
        a = videoplaybackactivity1;
        super();
    }
}

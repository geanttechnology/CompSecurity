// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.utility;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import java.io.IOException;

// Referenced classes of package com.cyberlink.you.utility:
//            p

public class o
{

    int a;
    MediaPlayer b;
    private int c;
    private android.media.MediaPlayer.OnCompletionListener d;
    private android.media.MediaPlayer.OnErrorListener e;
    private p f;

    public o()
    {
        a = 0;
        c = -1;
        b = null;
        d = new android.media.MediaPlayer.OnCompletionListener() {

            final o a;

            public void onCompletion(MediaPlayer mediaplayer)
            {
                a.a();
                o.a(a);
            }

            
            {
                a = o.this;
                super();
            }
        };
        e = new android.media.MediaPlayer.OnErrorListener() {

            final o a;

            public boolean onError(MediaPlayer mediaplayer, int i, int j)
            {
                a.a();
                o.a(a, 2);
                return true;
            }

            
            {
                a = o.this;
                super();
            }
        };
        f = null;
    }

    static void a(o o1)
    {
        o1.b();
    }

    static void a(o o1, int i)
    {
        o1.b(i);
    }

    private void b()
    {
        if (f != null)
        {
            f.a();
        }
    }

    private void b(int i)
    {
        if (f != null)
        {
            f.b(i);
        }
    }

    private void c(int i)
    {
        if (i == a)
        {
            return;
        } else
        {
            a = i;
            d(a);
            return;
        }
    }

    private void d(int i)
    {
        if (f != null)
        {
            f.a(i);
        }
    }

    public void a()
    {
        if (b == null)
        {
            return;
        } else
        {
            b.stop();
            b.release();
            b = null;
            c(0);
            return;
        }
    }

    public void a(int i)
    {
        c = i;
    }

    public boolean a(AssetFileDescriptor assetfiledescriptor, boolean flag)
    {
label0:
        {
            if (b != null && a == 1)
            {
                if (!flag)
                {
                    break label0;
                }
                a();
            }
            b = new MediaPlayer();
            try
            {
                b.setDataSource(assetfiledescriptor.getFileDescriptor(), assetfiledescriptor.getStartOffset(), assetfiledescriptor.getLength());
                b.setOnCompletionListener(d);
                b.setOnErrorListener(e);
                if (c != -1)
                {
                    b.setAudioStreamType(c);
                }
                b.prepare();
                b.start();
            }
            // Misplaced declaration of an exception variable
            catch (AssetFileDescriptor assetfiledescriptor)
            {
                b(1);
                b = null;
                return false;
            }
            // Misplaced declaration of an exception variable
            catch (AssetFileDescriptor assetfiledescriptor)
            {
                b(2);
                b = null;
                return false;
            }
            c(1);
            return true;
        }
        return false;
    }
}

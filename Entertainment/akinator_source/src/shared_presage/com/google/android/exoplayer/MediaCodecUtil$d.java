// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;

// Referenced classes of package shared_presage.com.google.android.exoplayer:
//            MediaCodecUtil

private static final class a
    implements a
{

    private final int a;
    private MediaCodecInfo b[];

    private void c()
    {
        if (b == null)
        {
            b = (new MediaCodecList(a)).getCodecInfos();
        }
    }

    public final int a()
    {
        c();
        return b.length;
    }

    public final MediaCodecInfo a(int i)
    {
        c();
        return b[i];
    }

    public final boolean a(String s, android.media.decCapabilities deccapabilities)
    {
        return deccapabilities.isFeatureSupported("secure-playback");
    }

    public final boolean b()
    {
        return true;
    }

    public (boolean flag)
    {
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        a = i;
    }
}

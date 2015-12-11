// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk.video;


// Referenced classes of package com.rhythmnewmedia.sdk.video:
//            RhythmVideoView

public interface VideoDataSource
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        private static final a e[];
        public final int d;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/rhythmnewmedia/sdk/video/VideoDataSource$a, s);
        }

        public static a[] values()
        {
            return (a[])e.clone();
        }

        static 
        {
            a = new a("unknown", 0, 0);
            b = new a("file", 1, 1);
            c = new a("stream", 2, 2);
            e = (new a[] {
                a, b, c
            });
        }

        private a(String s, int i, int j)
        {
            super(s, i);
            d = j;
        }
    }


    public abstract int getNumberOfChannels(RhythmVideoView rhythmvideoview);

    public abstract int getNumberOfVideosInChannel(RhythmVideoView rhythmvideoview, int i);

    public abstract String getVideoTitle(RhythmVideoView rhythmvideoview, int i, int j);

    public abstract String getVideoUrl(RhythmVideoView rhythmvideoview, int i, int j);
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.lyrics;

import java.io.Serializable;
import java.util.List;

// Referenced classes of package com.shazam.model.lyrics:
//            SynchInfo

public class LyricPlay
    implements Serializable
{
    public static class Builder
    {

        public List payload;
        public String provider;
        public SynchInfo synchInfo;
        public long tagTime;

        public static Builder a()
        {
            return new Builder();
        }

        static String a(Builder builder)
        {
            return builder.provider;
        }

        static SynchInfo b(Builder builder)
        {
            return builder.synchInfo;
        }

        static List c(Builder builder)
        {
            return builder.payload;
        }

        static long d(Builder builder)
        {
            return builder.tagTime;
        }

        public Builder()
        {
        }
    }


    public List payload;
    private String provider;
    public SynchInfo synchInfo;
    public long tagTime;

    private LyricPlay()
    {
    }

    private LyricPlay(Builder builder)
    {
        provider = Builder.a(builder);
        synchInfo = Builder.b(builder);
        payload = Builder.c(builder);
        tagTime = Builder.d(builder);
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer.extractors;


public class MediaTypeUtil
{
    public static final class MediaType extends Enum
    {

        private static final MediaType $VALUES[];
        public static final MediaType AAC;
        public static final MediaType MP3;
        public static final MediaType Unknown;

        public static MediaType valueOf(String s)
        {
            return (MediaType)Enum.valueOf(com/rdio/android/audioplayer/extractors/MediaTypeUtil$MediaType, s);
        }

        public static MediaType[] values()
        {
            return (MediaType[])$VALUES.clone();
        }

        static 
        {
            Unknown = new MediaType("Unknown", 0);
            MP3 = new MediaType("MP3", 1);
            AAC = new MediaType("AAC", 2);
            $VALUES = (new MediaType[] {
                Unknown, MP3, AAC
            });
        }

        private MediaType(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String MEDIA_TYPE_AAC = "mp4";
    private static final String MEDIA_TYPE_MP3 = "mp3";

    public MediaTypeUtil()
    {
    }

    public static MediaType fromServerString(String s)
    {
        if (s.equals("mp4"))
        {
            return MediaType.AAC;
        } else
        {
            return MediaType.MP3;
        }
    }

    public static String toServerString(MediaType mediatype)
    {
        if (mediatype == MediaType.AAC)
        {
            return "mp4";
        } else
        {
            return "mp3";
        }
    }
}

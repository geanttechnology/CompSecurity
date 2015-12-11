// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer.interfaces;


public interface AudioInfo
{
    public static final class AudioInfoDetail extends Enum
    {

        private static final AudioInfoDetail $VALUES[];
        public static final AudioInfoDetail AudioStart;
        public static final AudioInfoDetail BufferingEnd;
        public static final AudioInfoDetail BufferingStart;
        public static final AudioInfoDetail None;

        public static AudioInfoDetail valueOf(String s)
        {
            return (AudioInfoDetail)Enum.valueOf(com/rdio/android/audioplayer/interfaces/AudioInfo$AudioInfoDetail, s);
        }

        public static AudioInfoDetail[] values()
        {
            return (AudioInfoDetail[])$VALUES.clone();
        }

        static 
        {
            None = new AudioInfoDetail("None", 0);
            BufferingStart = new AudioInfoDetail("BufferingStart", 1);
            BufferingEnd = new AudioInfoDetail("BufferingEnd", 2);
            AudioStart = new AudioInfoDetail("AudioStart", 3);
            $VALUES = (new AudioInfoDetail[] {
                None, BufferingStart, BufferingEnd, AudioStart
            });
        }

        private AudioInfoDetail(String s, int i)
        {
            super(s, i);
        }
    }


    public abstract String getDescription();

    public abstract AudioInfoDetail getDetail();
}

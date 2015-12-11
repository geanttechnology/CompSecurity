// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer.interfaces;


// Referenced classes of package com.rdio.android.audioplayer.interfaces:
//            AudioError

public static final class  extends Enum
{

    private static final PlaybackInfoParseError $VALUES[];
    public static final PlaybackInfoParseError AudioError;
    public static final PlaybackInfoParseError DecoderError;
    public static final PlaybackInfoParseError ExtractorError;
    public static final PlaybackInfoParseError HighAdDebt;
    public static final PlaybackInfoParseError InvalidStream;
    public static final PlaybackInfoParseError LoadStreamError;
    public static final PlaybackInfoParseError NativeError;
    public static final PlaybackInfoParseError Network;
    public static final PlaybackInfoParseError NetworkStreamReadTimeout;
    public static final PlaybackInfoParseError NotAllowed;
    public static final PlaybackInfoParseError NotFound;
    public static final PlaybackInfoParseError PlaybackInfoParseError;
    public static final PlaybackInfoParseError StreamProgressTimedOut;
    public static final PlaybackInfoParseError Success;
    public static final PlaybackInfoParseError Unknown;
    public static final PlaybackInfoParseError UriDecryptionFailure;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/rdio/android/audioplayer/interfaces/AudioError$ErrorType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Unknown = new <init>("Unknown", 0);
        Success = new <init>("Success", 1);
        Network = new <init>("Network", 2);
        NetworkStreamReadTimeout = new <init>("NetworkStreamReadTimeout", 3);
        NotAllowed = new <init>("NotAllowed", 4);
        NotFound = new <init>("NotFound", 5);
        InvalidStream = new <init>("InvalidStream", 6);
        UriDecryptionFailure = new <init>("UriDecryptionFailure", 7);
        NativeError = new <init>("NativeError", 8);
        AudioError = new <init>("AudioError", 9);
        ExtractorError = new <init>("ExtractorError", 10);
        DecoderError = new <init>("DecoderError", 11);
        LoadStreamError = new <init>("LoadStreamError", 12);
        StreamProgressTimedOut = new <init>("StreamProgressTimedOut", 13);
        HighAdDebt = new <init>("HighAdDebt", 14);
        PlaybackInfoParseError = new <init>("PlaybackInfoParseError", 15);
        $VALUES = (new .VALUES[] {
            Unknown, Success, Network, NetworkStreamReadTimeout, NotAllowed, NotFound, InvalidStream, UriDecryptionFailure, NativeError, AudioError, 
            ExtractorError, DecoderError, LoadStreamError, StreamProgressTimedOut, HighAdDebt, PlaybackInfoParseError
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

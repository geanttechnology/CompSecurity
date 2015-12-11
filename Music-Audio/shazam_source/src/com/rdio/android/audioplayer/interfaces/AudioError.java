// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer.interfaces;


public interface AudioError
{
    public static final class ErrorType extends Enum
    {

        private static final ErrorType $VALUES[];
        public static final ErrorType AudioError;
        public static final ErrorType DecoderError;
        public static final ErrorType ExtractorError;
        public static final ErrorType HighAdDebt;
        public static final ErrorType InvalidStream;
        public static final ErrorType LoadStreamError;
        public static final ErrorType NativeError;
        public static final ErrorType Network;
        public static final ErrorType NetworkStreamReadTimeout;
        public static final ErrorType NotAllowed;
        public static final ErrorType NotFound;
        public static final ErrorType PlaybackInfoParseError;
        public static final ErrorType StreamProgressTimedOut;
        public static final ErrorType Success;
        public static final ErrorType Unknown;
        public static final ErrorType UriDecryptionFailure;

        public static ErrorType valueOf(String s)
        {
            return (ErrorType)Enum.valueOf(com/rdio/android/audioplayer/interfaces/AudioError$ErrorType, s);
        }

        public static ErrorType[] values()
        {
            return (ErrorType[])$VALUES.clone();
        }

        static 
        {
            Unknown = new ErrorType("Unknown", 0);
            Success = new ErrorType("Success", 1);
            Network = new ErrorType("Network", 2);
            NetworkStreamReadTimeout = new ErrorType("NetworkStreamReadTimeout", 3);
            NotAllowed = new ErrorType("NotAllowed", 4);
            NotFound = new ErrorType("NotFound", 5);
            InvalidStream = new ErrorType("InvalidStream", 6);
            UriDecryptionFailure = new ErrorType("UriDecryptionFailure", 7);
            NativeError = new ErrorType("NativeError", 8);
            AudioError = new ErrorType("AudioError", 9);
            ExtractorError = new ErrorType("ExtractorError", 10);
            DecoderError = new ErrorType("DecoderError", 11);
            LoadStreamError = new ErrorType("LoadStreamError", 12);
            StreamProgressTimedOut = new ErrorType("StreamProgressTimedOut", 13);
            HighAdDebt = new ErrorType("HighAdDebt", 14);
            PlaybackInfoParseError = new ErrorType("PlaybackInfoParseError", 15);
            $VALUES = (new ErrorType[] {
                Unknown, Success, Network, NetworkStreamReadTimeout, NotAllowed, NotFound, InvalidStream, UriDecryptionFailure, NativeError, AudioError, 
                ExtractorError, DecoderError, LoadStreamError, StreamProgressTimedOut, HighAdDebt, PlaybackInfoParseError
            });
        }

        private ErrorType(String s, int i)
        {
            super(s, i);
        }
    }


    public abstract String getDescription();

    public abstract ErrorType getType();

    public abstract boolean shouldStopPlayback();
}

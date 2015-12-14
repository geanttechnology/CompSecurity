// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;


public final class RecognizerConstants
{
    public static class EndOfSpeechDetection
    {

        public static final int Long = 2;
        public static final int None = 0;
        public static final int Short = 1;

        public EndOfSpeechDetection()
        {
        }
    }

    public static class PromptType
    {

        public static final int ERROR = 3;
        public static final int RECORDING_START = 0;
        public static final int RECORDING_STOP = 1;
        public static final int RESULT = 2;

        public PromptType()
        {
        }
    }

    public static class RecognizerType
    {

        public static final String Dictation = "dictation";
        public static final String Search = "websearch";
        public static final String Tv = "DTV";

        public RecognizerType()
        {
        }
    }


    public RecognizerConstants()
    {
    }
}

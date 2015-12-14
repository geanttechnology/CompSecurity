// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;


public interface SpeechError
{
    public static final class Codes
    {

        public static final int CanceledError = 5;
        public static final int RecognizerError = 3;
        public static final int ServerConnectionError = 1;
        public static final int ServerRetryError = 2;
        public static final int UnknownError = 0;
        public static final int VocalizerError = 4;

        public Codes()
        {
        }
    }


    public abstract int getErrorCode();

    public abstract String getErrorDetail();

    public abstract String getSuggestion();
}

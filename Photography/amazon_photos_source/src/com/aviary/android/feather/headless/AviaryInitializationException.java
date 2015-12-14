// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.headless;


public abstract class AviaryInitializationException extends Exception
{
    public static final class AviaryInvalidApiKeyException extends AviaryInitializationException
    {

        public AviaryInvalidApiKeyException()
        {
            super("Invalid API-KEY");
        }
    }

    public static final class AviaryInvalidContextException extends AviaryInitializationException
    {

        public AviaryInvalidContextException()
        {
            super("Invalid Context");
        }
    }


    public static final int CODE_INVALID_API_KEY_ERROR = 2;
    public static final int CODE_INVALID_CONTEXT_ERROR = 1;
    public static final int CODE_NO_ERROR = 0;

    AviaryInitializationException(String s)
    {
        super(s);
    }

    public static AviaryInitializationException fromInt(int i)
    {
        switch (i)
        {
        case 0: // '\0'
        default:
            return null;

        case 1: // '\001'
            return new AviaryInvalidContextException();

        case 2: // '\002'
            return new AviaryInvalidApiKeyException();
        }
    }
}

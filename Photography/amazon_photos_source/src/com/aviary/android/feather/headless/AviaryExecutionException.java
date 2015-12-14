// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.headless;


public class AviaryExecutionException extends Exception
{

    public static final int DECODER_NOT_FOUND_ERROR = 6;
    public static final int DECODE_ERROR = 8;
    public static final int ENCODER_NOT_FOUND_ERROR = 7;
    public static final int ENCODE_ERROR = 9;
    public static final int FILE_ALREADY_LOADED_ERROR = 5;
    public static final int FILE_EXCEED_MAX_SIZE_ERROR = 2;
    public static final int FILE_NOT_FOUND_ERROR = 1;
    public static final int FILE_NOT_LOADED_ERROR = 3;
    public static final int INSTANCE_NULL_ERROR = 10;
    public static final int INVALID_CONTEXT_ERROR = 4;
    public static final int NO_ERROR = 0;
    public static final int UNKNOWN_ERROR = 11;
    private int code;

    public AviaryExecutionException(String s, int i)
    {
        super(s);
        code = i;
    }

    public static AviaryExecutionException fromInt(int i)
    {
        switch (i)
        {
        default:
            return new AviaryExecutionException("Unknown error", 11);

        case 0: // '\0'
            return null;

        case 1: // '\001'
            return new AviaryExecutionException("File not found", 1);

        case 2: // '\002'
            return new AviaryExecutionException("File too large", 2);

        case 3: // '\003'
            return new AviaryExecutionException("File not loaded", 3);

        case 4: // '\004'
            return new AviaryExecutionException("Invalid Context", 4);

        case 5: // '\005'
            return new AviaryExecutionException("File already loaded", 5);

        case 6: // '\006'
            return new AviaryExecutionException("Decoder not found for the specified file", 6);

        case 7: // '\007'
            return new AviaryExecutionException("Encoder not found for the specified file", 7);

        case 8: // '\b'
            return new AviaryExecutionException("Decode error", 8);

        case 9: // '\t'
            return new AviaryExecutionException("Encode error", 9);
        }
    }

    public int getCode()
    {
        return code;
    }
}

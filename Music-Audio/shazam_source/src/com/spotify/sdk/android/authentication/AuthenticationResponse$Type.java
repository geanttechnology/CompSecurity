// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.spotify.sdk.android.authentication;


// Referenced classes of package com.spotify.sdk.android.authentication:
//            AuthenticationResponse

public static final class mType extends Enum
{

    private static final UNKNOWN $VALUES[];
    public static final UNKNOWN CODE;
    public static final UNKNOWN EMPTY;
    public static final UNKNOWN ERROR;
    public static final UNKNOWN TOKEN;
    public static final UNKNOWN UNKNOWN;
    private final String mType;

    public static mType valueOf(String s)
    {
        return (mType)Enum.valueOf(com/spotify/sdk/android/authentication/AuthenticationResponse$Type, s);
    }

    public static mType[] values()
    {
        return (mType[])$VALUES.clone();
    }

    public final String toString()
    {
        return mType;
    }

    static 
    {
        CODE = new <init>("CODE", 0, "code");
        TOKEN = new <init>("TOKEN", 1, "token");
        ERROR = new <init>("ERROR", 2, "error");
        EMPTY = new <init>("EMPTY", 3, "empty");
        UNKNOWN = new <init>("UNKNOWN", 4, "unknown");
        $VALUES = (new .VALUES[] {
            CODE, TOKEN, ERROR, EMPTY, UNKNOWN
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        mType = s1;
    }
}

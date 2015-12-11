// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.moodstocks.android;

import com.moodstocks.android.core.Loader;

public class MoodstocksError extends Throwable
{
    public static final class Code
    {

        public static final int EABORT = 15;
        public static final int EAPIKEY = 18;
        public static final int EAPISECRET = 22;
        public static final int EAUTH = 8;
        public static final int EBUNDLE = 21;
        public static final int EBUSY = 5;
        public static final int ECORRUPT = 6;
        public static final int ECREDMISMATCH = 12;
        public static final int EEMPTY = 7;
        public static final int EIMG = 17;
        public static final int EMISUSE = 2;
        public static final int ENETWORFAIL = 19;
        public static final int ENOCONN = 9;
        public static final int ENOFILE = 4;
        public static final int ENOIMPL = 23;
        public static final int ENOPERM = 3;
        public static final int ENOREC = 14;
        public static final int ENOTOPEN = 20;
        public static final int ERROR = 1;
        public static final int ESLOWCONN = 13;
        public static final int ETHREAD = 11;
        public static final int ETIMEOUT = 10;
        public static final int EUNAVAIL = 16;
        public static final int SUCCESS = 0;

        public Code()
        {
        }
    }


    private static final long serialVersionUID = 1L;
    private int errorCode;

    protected MoodstocksError(String s, int i)
    {
        super(s);
        errorCode = 0;
        errorCode = i;
    }

    public int getErrorCode()
    {
        return errorCode;
    }

    static 
    {
        Loader.load();
    }
}

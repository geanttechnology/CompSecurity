// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.os.Bundle;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            Callback, MAPFuture

public interface ADPCorpusSigningAuthenticationMethod
{
    public static final class SignCorpusError
    {

        public static final int INVALID_ARGUMENT = 3;
        public static final int IPC_ERROR = 1;
        public static final int NO_CREDENTIALS = 2;
        public static final int UNRECOGNIZED = 5;

        private SignCorpusError()
        {
        }
    }

    public static final class SignCorpusOption
    {

        public static final String USE_FALL_BACK_CREDENTIALS = "UseFallBackCredentials";

        private SignCorpusOption()
        {
        }
    }


    public static final String KEY_ADP_AUTH_SIGNATURE = "adp_signature";
    public static final String KEY_ADP_AUTH_TOKEN = "adp_token";
    public static final String KEY_ERROR_CODE = "error_code_key";
    public static final String KEY_ERROR_MESSAGE = "error_message_key";

    public abstract MAPFuture signCorpus(byte abyte0[], Bundle bundle, Callback callback);
}

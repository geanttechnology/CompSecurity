// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.sdk;

import android.content.Context;
import com.rdio.android.sdk.internal.RdioInternal;
import java.util.List;

// Referenced classes of package com.rdio.android.sdk:
//            OAuth2Credential, RdioListener, RdioApiCallback, PlayerManager

public class Rdio
{
    public static class InvalidKeyException extends RuntimeException
    {

        private static final long serialVersionUID = 1L;
        public final String message;

        public InvalidKeyException(String s)
        {
            message = s;
        }
    }

    public static final class RdioError extends Enum
    {

        private static final RdioError $VALUES[];
        public static final RdioError AUTHORIZATION;
        public static final RdioError CANNOT_STREAM;
        public static final RdioError INITIALIZATION;
        public static final RdioError PLAYBACK_TOKEN;
        public static final RdioError TRACK_LOOKUP;

        public static RdioError valueOf(String s)
        {
            return (RdioError)Enum.valueOf(com/rdio/android/sdk/Rdio$RdioError, s);
        }

        public static RdioError[] values()
        {
            return (RdioError[])$VALUES.clone();
        }

        static 
        {
            AUTHORIZATION = new RdioError("AUTHORIZATION", 0);
            INITIALIZATION = new RdioError("INITIALIZATION", 1);
            TRACK_LOOKUP = new RdioError("TRACK_LOOKUP", 2);
            CANNOT_STREAM = new RdioError("CANNOT_STREAM", 3);
            PLAYBACK_TOKEN = new RdioError("PLAYBACK_TOKEN", 4);
            $VALUES = (new RdioError[] {
                AUTHORIZATION, INITIALIZATION, TRACK_LOOKUP, CANNOT_STREAM, PLAYBACK_TOKEN
            });
        }

        private RdioError(String s, int i)
        {
            super(s, i);
        }
    }


    public static final String DEFAULT_V = "0";
    public static int LIBRARY_VERSION = 2;
    private RdioInternal internal;

    public Rdio(String s, String s1, OAuth2Credential oauth2credential, Context context, RdioListener rdiolistener)
    {
        internal = new RdioInternal(s, s1, oauth2credential, context, rdiolistener);
    }

    public void apiCall(String s, List list, RdioApiCallback rdioapicallback)
    {
        internal.apiCall(s, list, rdioapicallback);
    }

    public void cleanup()
    {
        internal.cleanup();
    }

    public String getAuthUrl(String s)
    {
        return internal.getAuthUrl(s);
    }

    public PlayerManager getPlayerManager()
    {
        return internal.getPlayerManager();
    }

    public boolean isReady()
    {
        return internal.isReady();
    }

    public void playTrack(String s, String s1, boolean flag)
    {
        internal.playTrack(s, s1, flag);
    }

    public void prepareForPlayback()
    {
        internal.prepareForPlayback();
    }

    public void requestApiService()
    {
        internal.requestApiService("0");
    }

    public void requestApiService(String s)
    {
        internal.requestApiService(s);
    }

}

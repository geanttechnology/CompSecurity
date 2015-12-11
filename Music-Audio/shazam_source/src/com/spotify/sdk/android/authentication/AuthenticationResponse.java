// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.spotify.sdk.android.authentication;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class AuthenticationResponse
    implements Parcelable
{
    public static final class Type extends Enum
    {

        private static final Type $VALUES[];
        public static final Type CODE;
        public static final Type EMPTY;
        public static final Type ERROR;
        public static final Type TOKEN;
        public static final Type UNKNOWN;
        private final String mType;

        public static Type valueOf(String s)
        {
            return (Type)Enum.valueOf(com/spotify/sdk/android/authentication/AuthenticationResponse$Type, s);
        }

        public static Type[] values()
        {
            return (Type[])$VALUES.clone();
        }

        public final String toString()
        {
            return mType;
        }

        static 
        {
            CODE = new Type("CODE", 0, "code");
            TOKEN = new Type("TOKEN", 1, "token");
            ERROR = new Type("ERROR", 2, "error");
            EMPTY = new Type("EMPTY", 3, "empty");
            UNKNOWN = new Type("UNKNOWN", 4, "unknown");
            $VALUES = (new Type[] {
                CODE, TOKEN, ERROR, EMPTY, UNKNOWN
            });
        }

        private Type(String s, int i, String s1)
        {
            super(s, i);
            mType = s1;
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    private final String mAccessToken;
    private final String mCode;
    private final String mError;
    private final int mExpiresIn;
    private final String mState;
    private final Type mType;

    public AuthenticationResponse(Parcel parcel)
    {
        mExpiresIn = parcel.readInt();
        mError = parcel.readString();
        mState = parcel.readString();
        mAccessToken = parcel.readString();
        mCode = parcel.readString();
        mType = Type.values()[parcel.readInt()];
    }

    private AuthenticationResponse(Type type, String s, String s1, String s2, String s3, int i)
    {
        mType = type;
        mCode = s;
        mAccessToken = s1;
        mState = s2;
        mError = s3;
        mExpiresIn = i;
    }

    AuthenticationResponse(Type type, String s, String s1, String s2, String s3, int i, _cls1 _pcls1)
    {
        this(type, s, s1, s2, s3, i);
    }

    public static AuthenticationResponse fromUri(Uri uri)
    {
        String s2 = null;
    /* block-local class not found */
    class Builder {}

        Builder builder = new Builder();
        if (uri == null)
        {
            builder.setType(Type.EMPTY);
            return builder.build();
        }
        String s = uri.getQueryParameter("error");
        if (s != null)
        {
            uri = uri.getQueryParameter("state");
            builder.setError(s);
            builder.setState(uri);
            builder.setType(Type.ERROR);
            return builder.build();
        }
        s = uri.getQueryParameter("code");
        if (s != null)
        {
            uri = uri.getQueryParameter("state");
            builder.setCode(s);
            builder.setState(uri);
            builder.setType(Type.CODE);
            return builder.build();
        }
        uri = uri.getEncodedFragment();
        if (uri != null && uri.length() > 0)
        {
            String as[] = uri.split("&");
            int j = as.length;
            int i = 0;
            uri = null;
            String s1;
            String s3;
            for (s1 = null; i < j; s1 = s3)
            {
                String as1[] = as[i].split("=");
                String s4 = s2;
                Uri uri1 = uri;
                s3 = s1;
                if (as1.length == 2)
                {
                    if (as1[0].startsWith("access_token"))
                    {
                        s1 = Uri.decode(as1[1]);
                    }
                    if (as1[0].startsWith("state"))
                    {
                        uri = Uri.decode(as1[1]);
                    }
                    s4 = s2;
                    uri1 = uri;
                    s3 = s1;
                    if (as1[0].startsWith("expires_in"))
                    {
                        s4 = Uri.decode(as1[1]);
                        s3 = s1;
                        uri1 = uri;
                    }
                }
                i++;
                s2 = s4;
                uri = uri1;
            }

            builder.setAccessToken(s1);
            builder.setState(uri);
            if (s2 != null)
            {
                try
                {
                    builder.setExpiresIn(Integer.parseInt(s2));
                }
                // Misplaced declaration of an exception variable
                catch (Uri uri) { }
            }
            builder.setType(Type.TOKEN);
            return builder.build();
        } else
        {
            builder.setType(Type.UNKNOWN);
            return builder.build();
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public String getAccessToken()
    {
        return mAccessToken;
    }

    public String getCode()
    {
        return mCode;
    }

    public String getError()
    {
        return mError;
    }

    public int getExpiresIn()
    {
        return mExpiresIn;
    }

    public String getState()
    {
        return mState;
    }

    public Type getType()
    {
        return mType;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(mExpiresIn);
        parcel.writeString(mError);
        parcel.writeString(mState);
        parcel.writeString(mAccessToken);
        parcel.writeString(mCode);
        parcel.writeInt(mType.ordinal());
    }


    // Unreferenced inner class com/spotify/sdk/android/authentication/AuthenticationResponse$QueryParams
    /* block-local class not found */
    class QueryParams {}


    /* member class not found */
    class _cls1 {}

}

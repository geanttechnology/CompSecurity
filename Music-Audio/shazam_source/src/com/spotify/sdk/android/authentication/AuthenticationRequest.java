// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.spotify.sdk.android.authentication;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class AuthenticationRequest
    implements Parcelable
{
    public static class Builder
    {

        private final String mClientId;
        private Map mCustomParams;
        private final String mRedirectUri;
        private final AuthenticationResponse.Type mResponseType;
        private String mScopes[];
        private boolean mShowDialog;
        private String mState;

        public AuthenticationRequest build()
        {
            return new AuthenticationRequest(mClientId, mResponseType, mRedirectUri, mState, mScopes, mShowDialog, mCustomParams, null);
        }

        public Builder setCustomParam(String s, String s1)
        {
            if (s == null || s.isEmpty())
            {
                throw new IllegalArgumentException("Custom parameter key can't be null or empty");
            }
            if (s1 == null || s1.isEmpty())
            {
                throw new IllegalArgumentException("Custom parameter value can't be null or empty");
            } else
            {
                mCustomParams.put(s, s1);
                return this;
            }
        }

        public Builder setScopes(String as[])
        {
            mScopes = as;
            return this;
        }

        public Builder setShowDialog(boolean flag)
        {
            mShowDialog = flag;
            return this;
        }

        public Builder setState(String s)
        {
            mState = s;
            return this;
        }

        public Builder(String s, AuthenticationResponse.Type type, String s1)
        {
            mCustomParams = new HashMap();
            if (s == null)
            {
                throw new IllegalArgumentException("Client ID can't be null");
            }
            if (type == null)
            {
                throw new IllegalArgumentException("Response type can't be null");
            }
            if (s1 == null || s1.length() == 0)
            {
                throw new IllegalArgumentException("Redirect URI can't be null or empty");
            } else
            {
                mClientId = s;
                mResponseType = type;
                mRedirectUri = s1;
                return;
            }
        }
    }


    static final String ACCOUNTS_AUTHORITY = "accounts.spotify.com";
    static final String ACCOUNTS_PATH = "authorize";
    static final String ACCOUNTS_SCHEME = "https";
    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    private final String mClientId;
    private final Map mCustomParams;
    private final String mRedirectUri;
    private final String mResponseType;
    private final String mScopes[];
    private final boolean mShowDialog;
    private final String mState;

    public AuthenticationRequest(Parcel parcel)
    {
        mClientId = parcel.readString();
        mResponseType = parcel.readString();
        mRedirectUri = parcel.readString();
        mState = parcel.readString();
        mScopes = parcel.createStringArray();
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mShowDialog = flag;
        mCustomParams = new HashMap();
        parcel = parcel.readBundle();
        String s;
        for (Iterator iterator = parcel.keySet().iterator(); iterator.hasNext(); mCustomParams.put(s, parcel.getString(s)))
        {
            s = (String)iterator.next();
        }

    }

    private AuthenticationRequest(String s, AuthenticationResponse.Type type, String s1, String s2, String as[], boolean flag, Map map)
    {
        mClientId = s;
        mResponseType = type.toString();
        mRedirectUri = s1;
        mState = s2;
        mScopes = as;
        mShowDialog = flag;
        mCustomParams = map;
    }

    AuthenticationRequest(String s, AuthenticationResponse.Type type, String s1, String s2, String as[], boolean flag, Map map, 
            _cls1 _pcls1)
    {
        this(s, type, s1, s2, as, flag, map);
    }

    public int describeContents()
    {
        return 0;
    }

    public String getClientId()
    {
        return mClientId;
    }

    public String getCustomParam(String s)
    {
        return (String)mCustomParams.get(s);
    }

    public String getRedirectUri()
    {
        return mRedirectUri;
    }

    public String getResponseType()
    {
        return mResponseType;
    }

    public String[] getScopes()
    {
        return mScopes;
    }

    public boolean getShowDialog()
    {
        return mShowDialog;
    }

    public String getState()
    {
        return mState;
    }

    public Uri toUri()
    {
        android.net.Uri.Builder builder = new android.net.Uri.Builder();
        builder.scheme("https").authority("accounts.spotify.com").appendPath("authorize").appendQueryParameter("client_id", mClientId).appendQueryParameter("response_type", mResponseType).appendQueryParameter("redirect_uri", mRedirectUri);
        if (mScopes != null && mScopes.length > 0)
        {
            StringBuilder stringbuilder = new StringBuilder();
            String as[] = mScopes;
            int j = as.length;
            for (int i = 0; i < j; i++)
            {
                stringbuilder.append(as[i]);
                stringbuilder.append(" ");
            }

            builder.appendQueryParameter("scope", stringbuilder.toString().trim());
        }
        if (mState != null)
        {
            builder.appendQueryParameter("state", mState);
        }
        if (mShowDialog)
        {
            builder.appendQueryParameter("show_dialog", "true");
        }
        if (mCustomParams.size() > 0)
        {
            java.util.Map.Entry entry;
            for (Iterator iterator = mCustomParams.entrySet().iterator(); iterator.hasNext(); builder.appendQueryParameter((String)entry.getKey(), (String)entry.getValue()))
            {
                entry = (java.util.Map.Entry)iterator.next();
            }

        }
        return builder.build();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mClientId);
        parcel.writeString(mResponseType);
        parcel.writeString(mRedirectUri);
        parcel.writeString(mState);
        parcel.writeStringArray(mScopes);
        Bundle bundle;
        if (mShowDialog)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        bundle = new Bundle();
        java.util.Map.Entry entry;
        for (Iterator iterator = mCustomParams.entrySet().iterator(); iterator.hasNext(); bundle.putString((String)entry.getKey(), (String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        parcel.writeBundle(bundle);
    }


    // Unreferenced inner class com/spotify/sdk/android/authentication/AuthenticationRequest$QueryParams
    /* block-local class not found */
    class QueryParams {}


    /* member class not found */
    class _cls1 {}

}

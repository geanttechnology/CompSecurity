// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.blueshift.bluefront.android.request;

import android.net.Uri;
import com.amazon.blueshift.bluefront.android.common.RequestTimeouts;
import com.amazon.blueshift.bluefront.android.http.Part;
import com.google.common.base.Preconditions;
import com.google.common.net.MediaType;
import java.io.OutputStream;

public class SpeechRequest extends Part
{

    private static final String CONTENT_TYPE = "application/json";
    private static final String PART_NAME = "parameters";
    private final String mLocale;
    private final Class mOutputType;
    private final String mProfile;
    private final String mRequestParametersJson;
    private final Uri mRequestUri;
    private final RequestTimeouts mTimeouts;

    SpeechRequest(String s, String s1, String s2, Uri uri, RequestTimeouts requesttimeouts, Class class1)
    {
label0:
        {
            boolean flag1 = false;
            super("parameters", MediaType.parse("application/json"));
            boolean flag;
            if (s2 == null || s2.length() != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkArgument(flag, "Profile cannot be empty");
            if (s1 != null)
            {
                flag = flag1;
                if (s1.length() == 0)
                {
                    break label0;
                }
            }
            flag = true;
        }
        Preconditions.checkArgument(flag, "locale cannot be empty");
        Preconditions.checkNotNull(s, "parametersJson cannot be null");
        Preconditions.checkNotNull(uri, "request endpoint cannot be null");
        Preconditions.checkNotNull(requesttimeouts, "timeouts cannot be null");
        Preconditions.checkNotNull(class1, "outputType cannot be null");
        mRequestParametersJson = s;
        mRequestUri = uri;
        mProfile = s2;
        mLocale = s1;
        mTimeouts = requesttimeouts;
        mOutputType = class1;
    }

    public static SpeechRequestBuilder.SpeechToIntentRequestBuilder speechToIntentRequestBuilder()
    {
        return new SpeechRequestBuilder.SpeechToIntentRequestBuilder();
    }

    public static SpeechRequestBuilder.SpeechToStorageIdRequestBuilder speechToStorageIdRequestBuilder()
    {
        return new SpeechRequestBuilder.SpeechToStorageIdRequestBuilder();
    }

    public static SpeechRequestBuilder.SpeechToTextRequestBuilder speechToTextRequestBuilder()
    {
        return new SpeechRequestBuilder.SpeechToTextRequestBuilder();
    }

    public String getLocale()
    {
        return mLocale;
    }

    public Class getOutputType()
    {
        return mOutputType;
    }

    public String getProfile()
    {
        return mProfile;
    }

    public Uri getRequestUri()
    {
        return mRequestUri;
    }

    public RequestTimeouts getTimeouts()
    {
        return mTimeouts;
    }

    protected void writeBody(OutputStream outputstream)
        throws Exception
    {
        outputstream.write(mRequestParametersJson.getBytes());
    }
}

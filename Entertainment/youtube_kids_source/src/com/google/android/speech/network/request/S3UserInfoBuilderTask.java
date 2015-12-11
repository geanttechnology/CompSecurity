// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.network.request;

import a;
import android.location.Location;
import android.util.Log;
import com.google.android.speech.SpeechSettings;
import com.google.android.speech.helper.AuthTokenHelper;
import com.google.android.speech.helper.SpeechLocationHelper;
import euf;
import ewy;
import ewz;
import exh;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;

// Referenced classes of package com.google.android.speech.network.request:
//            BaseRequestBuilderTask

public class S3UserInfoBuilderTask extends BaseRequestBuilderTask
{

    private static final boolean DBG = false;
    private static final String OAUTH_PREFIX = "oauth2:";
    private static final String TAG = "VS.S3UserInfoBuilderTask";
    private final AuthTokenHelper mAuthTokenHelper;
    private final SpeechLocationHelper mLocationHelper;
    private final Location mLocationOverride;
    private final exh mS3UserInfo;
    private final SpeechSettings mSpeechSettings;
    private final String mSpokenLocale;

    S3UserInfoBuilderTask(AuthTokenHelper authtokenhelper, SpeechSettings speechsettings, SpeechLocationHelper speechlocationhelper, String s, Location location, exh exh1)
    {
        super("S3UserInfoBuilderTask");
        mAuthTokenHelper = authtokenhelper;
        mSpeechSettings = speechsettings;
        mLocationHelper = speechlocationhelper;
        mSpokenLocale = s;
        mLocationOverride = location;
        mS3UserInfo = exh1;
    }

    private void addAuthTokens(String s, exh exh1)
    {
        Object obj = mAuthTokenHelper.blockingGetAllTokens(s, 1000L);
        if (obj != null)
        {
            String s1;
            for (obj = ((Collection) (obj)).iterator(); ((Iterator) (obj)).hasNext(); exh1.a((new ewy()).a(maybeStripOAuthPrefix(s)).b(s1)))
            {
                s1 = (String)((Iterator) (obj)).next();
            }

        } else
        {
            Log.w("VS.S3UserInfoBuilderTask", "Failed fetching auth.");
        }
    }

    private exh buildNewS3UserInfo()
    {
        exh exh1 = (new exh()).a(mSpeechSettings.getInstallId()).b((new ewz()).a(Locale.getDefault().toString()).a(2));
        addAuthTokens(mSpeechSettings.getVoiceSearchTokenType(), exh1);
        if (mLocationHelper.shouldSendLocation())
        {
            String s = mLocationHelper.getXGeoLocation();
            if (mLocationOverride != null)
            {
                exh1.b(a.a(mLocationOverride, null));
            } else
            if (s != null)
            {
                exh1.b(s);
            } else
            {
                exh1.b("w ");
            }
        } else
        {
            exh1.a(false);
        }
        exh1.a((new ewz()).a(mSpokenLocale).a(1));
        return exh1;
    }

    public static Callable getAuthTokenRefreshingBuilder(AuthTokenHelper authtokenhelper, exh exh1, SpeechSettings speechsettings)
    {
        return new S3UserInfoBuilderTask(authtokenhelper, speechsettings, null, null, null, exh1);
    }

    public static Callable getBuilder(AuthTokenHelper authtokenhelper, SpeechSettings speechsettings, SpeechLocationHelper speechlocationhelper, String s, Location location)
    {
        return new S3UserInfoBuilderTask(authtokenhelper, speechsettings, speechlocationhelper, s, location, null);
    }

    private static String maybeStripOAuthPrefix(String s)
    {
        String s1 = s;
        if (s.startsWith("oauth2:"))
        {
            s1 = s.substring(7);
        }
        return s1;
    }

    private exh refreshS3UserInfo()
    {
        ewy ewy1;
        for (Iterator iterator = mS3UserInfo.a.iterator(); iterator.hasNext(); mAuthTokenHelper.invalidateToken(ewy1.a))
        {
            ewy1 = (ewy)iterator.next();
        }

        exh exh1 = new exh();
        try
        {
            exh1.a(mS3UserInfo.c());
        }
        catch (euf euf1)
        {
            Log.e("VS.S3UserInfoBuilderTask", (new StringBuilder("Invalid s3UserInfo: ")).append(euf1.getMessage()).toString());
            exh1.b((new ewz()).a(Locale.getDefault().toString()).a(2));
            exh1.a(false);
        }
        exh1.a = Collections.emptyList();
        addAuthTokens(mSpeechSettings.getVoiceSearchTokenType(), exh1);
        return exh1;
    }

    protected exh build()
    {
        if (mS3UserInfo == null)
        {
            return buildNewS3UserInfo();
        } else
        {
            return refreshS3UserInfo();
        }
    }

    protected volatile Object build()
    {
        return build();
    }
}

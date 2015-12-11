// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.Context;
import com.groupon.http.Http;
import com.groupon.models.signup.json.Converter;
import com.groupon.models.signup.json.SignupResponse;
import com.groupon.util.GoogleNowAuthAlarmUtil;
import com.squareup.okhttp.RequestBody;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

public class SignUpService extends Http
{

    private Converter converter;
    private GoogleNowAuthAlarmUtil googleNowAuthAlarmUtil;

    public SignUpService(Context context, String s, RequestBody requestbody)
    {
        super(context, com/groupon/models/signup/json/SignupResponse, s, requestbody);
        converter = new Converter();
        RoboGuice.getInjector(context).injectMembers(this);
    }

    public transient SignUpService(Context context, String s, Object aobj[])
    {
        super(context, com/groupon/models/signup/json/SignupResponse, s, aobj);
        converter = new Converter();
        RoboGuice.getInjector(context).injectMembers(this);
    }

    public com.groupon.models.signup.SignupResponse callAndConvert()
        throws Exception
    {
        return converter.fromJson((SignupResponse)super.call());
    }

    protected void onSuccess(com.groupon.models.signup.SignupResponse signupresponse)
        throws Exception
    {
    }

    protected final void onSuccess(SignupResponse signupresponse)
        throws Exception
    {
        super.onSuccess(signupresponse);
        onSuccess(converter.fromJson(signupresponse));
        googleNowAuthAlarmUtil.setUpAlarmIfNotSet();
    }

    protected volatile void onSuccess(Object obj)
        throws Exception
    {
        onSuccess((SignupResponse)obj);
    }
}

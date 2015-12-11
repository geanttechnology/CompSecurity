// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership;

import android.content.Context;
import com.google.a.a.f;
import com.target.mothership.services.j;
import com.target.mothership.services.p;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class com.target.mothership.a
{
    public static class a
    {

        public String mApigeeApiKey;
        public String mApigeeSecureKey;
        public com.target.mothership.services.f.b.a mBaseHostProvider;
        public String mCodeBrokerAppId;
        public String mCodeBrokerKey;
        public Context mContext;
        public com.target.a.a.b.e mDefaultLogger;
        public boolean mEnableStoreUpdates;
        public j mInterceptor;
        public c.a mMode;
        public String mRedskyApiKey;
        public p mRequestSender;
        public boolean mUseFullHttpLogging;

        private void b()
        {
            java.util.Map.Entry entry;
            for (Iterator iterator = (new android.support.v4.f.a() {

        final a this$0;

            
            {
                this$0 = a.this;
                super();
                put("mContext", mContext);
                put("mRedSkyApiKey", mRedskyApiKey);
                put("mApigeeApiKey", mApigeeApiKey);
                put("mApigeeSecureKey", mApigeeSecureKey);
                put("mCodeBrokerKey", mCodeBrokerKey);
                put("mCodeBrokerAppId", mCodeBrokerAppId);
                put("mDefaultLogger", mDefaultLogger);
                put("mBaseHostProvider", mBaseHostProvider);
            }
    }).entrySet().iterator(); iterator.hasNext(); com.google.a.a.f.a(entry.getValue(), (new StringBuilder()).append((String)entry.getKey()).append(" cannot be null!").toString()))
            {
                entry = (java.util.Map.Entry)iterator.next();
            }

            boolean flag;
            if (mMode != c.a.Debug || mRequestSender == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            com.google.a.a.f.b(flag, "Cannot set a RequestSender when using LibraryMode.Debug!");
        }

        public a a(Context context)
        {
            mContext = context;
            return this;
        }

        public a a(com.target.a.a.b.e e1)
        {
            mDefaultLogger = e1;
            return this;
        }

        public a a(c.a a1)
        {
            mMode = a1;
            return this;
        }

        public a a(com.target.mothership.services.f.b.a a1)
        {
            mBaseHostProvider = a1;
            return this;
        }

        public a a(p p)
        {
            mRequestSender = p;
            return this;
        }

        public a a(String s)
        {
            mRedskyApiKey = s;
            return this;
        }

        public com.target.mothership.a a()
        {
            b();
            return new com.target.mothership.a(mContext, mRedskyApiKey, mApigeeApiKey, mApigeeSecureKey, mCodeBrokerKey, mCodeBrokerAppId, mBaseHostProvider, mDefaultLogger, mMode, mUseFullHttpLogging, mEnableStoreUpdates, mInterceptor, mRequestSender);
        }

        public a b(String s)
        {
            mApigeeApiKey = s;
            return this;
        }

        public a c(String s)
        {
            mApigeeSecureKey = s;
            return this;
        }

        public a d(String s)
        {
            mCodeBrokerKey = s;
            return this;
        }

        public a e(String s)
        {
            mCodeBrokerAppId = s;
            return this;
        }

        public a()
        {
            mBaseHostProvider = com.target.mothership.services.f.b.a.a(1);
            mEnableStoreUpdates = true;
        }
    }


    private final String mApigeeApiKey;
    private final String mApigeeSecureKey;
    private final Context mApplicationContext;
    private final com.target.mothership.services.f.b.a mBaseHostProvider;
    private final String mCodeBrokerAppId;
    private final String mCodeBrokerKey;
    private final com.target.a.a.b.e mDefaultLogger;
    private final boolean mEnableStoreUpdates;
    private final j mInterceptor;
    private final c.a mMode;
    private final String mRedskyApiKey;
    private final p mRequestSender;
    private final boolean mUseFullHttpLogging;

    private com.target.mothership.a(Context context, String s, String s1, String s2, String s3, String s4, com.target.mothership.services.f.b.a a1, 
            com.target.a.a.b.e e1, c.a a2, boolean flag, boolean flag1, j j1, p p)
    {
        mApplicationContext = context.getApplicationContext();
        mRedskyApiKey = s;
        mApigeeApiKey = s1;
        mApigeeSecureKey = s2;
        mCodeBrokerKey = s3;
        mCodeBrokerAppId = s4;
        mBaseHostProvider = a1;
        mMode = a2;
        mDefaultLogger = e1;
        mUseFullHttpLogging = flag;
        mEnableStoreUpdates = flag1;
        mInterceptor = j1;
        mRequestSender = p;
    }


    public static a a()
    {
        return new a();
    }

    public Context b()
    {
        return mApplicationContext;
    }

    public String c()
    {
        return mRedskyApiKey;
    }

    public String d()
    {
        return mApigeeApiKey;
    }

    public String e()
    {
        return mApigeeSecureKey;
    }

    public String f()
    {
        return mCodeBrokerKey;
    }

    public String g()
    {
        return mCodeBrokerAppId;
    }

    public com.target.mothership.services.f.b.a h()
    {
        return mBaseHostProvider;
    }

    public c.a i()
    {
        return mMode;
    }

    public com.target.a.a.b.e j()
    {
        return mDefaultLogger;
    }

    public boolean k()
    {
        return mUseFullHttpLogging;
    }

    public boolean l()
    {
        return mEnableStoreUpdates;
    }

    public p m()
    {
        return mRequestSender;
    }

    public j n()
    {
        return mInterceptor;
    }
}

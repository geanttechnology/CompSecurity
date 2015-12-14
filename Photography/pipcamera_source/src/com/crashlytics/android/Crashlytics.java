// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android;

import aad;
import aae;
import aag;
import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.beta.Beta;
import com.crashlytics.android.core.CrashlyticsCore;
import com.crashlytics.android.core.CrashlyticsListener;
import com.crashlytics.android.core.PinningInfoProvider;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import zw;

public class Crashlytics extends aad
    implements aae
{

    public static final String TAG = "Crashlytics";
    public final Answers answers;
    public final Beta beta;
    public final CrashlyticsCore core;
    public final Collection kits;

    public Crashlytics()
    {
        this(new Answers(), new Beta(), new CrashlyticsCore());
    }

    Crashlytics(Answers answers1, Beta beta1, CrashlyticsCore crashlyticscore)
    {
        answers = answers1;
        beta = beta1;
        core = crashlyticscore;
        kits = Collections.unmodifiableCollection(Arrays.asList(new aad[] {
            answers1, beta1, crashlyticscore
        }));
    }

    private static void checkInitialized()
    {
        if (getInstance() == null)
        {
            throw new IllegalStateException("Crashlytics must be initialized by calling Fabric.with(Context) prior to calling Crashlytics.getInstance()");
        } else
        {
            return;
        }
    }

    public static Crashlytics getInstance()
    {
        return (Crashlytics)zw.a(com/crashlytics/android/Crashlytics);
    }

    public static PinningInfoProvider getPinningInfoProvider()
    {
        checkInitialized();
        return getInstance().core.getPinningInfoProvider();
    }

    public static void log(int i, String s, String s1)
    {
        checkInitialized();
        getInstance().core.log(i, s, s1);
    }

    public static void log(String s)
    {
        checkInitialized();
        getInstance().core.log(s);
    }

    public static void logException(Throwable throwable)
    {
        checkInitialized();
        getInstance().core.logException(throwable);
    }

    public static void setBool(String s, boolean flag)
    {
        checkInitialized();
        getInstance().core.setBool(s, flag);
    }

    public static void setDouble(String s, double d)
    {
        checkInitialized();
        getInstance().core.setDouble(s, d);
    }

    public static void setFloat(String s, float f)
    {
        checkInitialized();
        getInstance().core.setFloat(s, f);
    }

    public static void setInt(String s, int i)
    {
        checkInitialized();
        getInstance().core.setInt(s, i);
    }

    public static void setLong(String s, long l)
    {
        checkInitialized();
        getInstance().core.setLong(s, l);
    }

    public static void setPinningInfoProvider(PinningInfoProvider pinninginfoprovider)
    {
        zw.h().d("Crashlytics", "Use of Crashlytics.setPinningInfoProvider is deprecated");
    }

    public static void setString(String s, String s1)
    {
        checkInitialized();
        getInstance().core.setString(s, s1);
    }

    public static void setUserEmail(String s)
    {
        checkInitialized();
        getInstance().core.setUserEmail(s);
    }

    public static void setUserIdentifier(String s)
    {
        checkInitialized();
        getInstance().core.setUserIdentifier(s);
    }

    public static void setUserName(String s)
    {
        checkInitialized();
        getInstance().core.setUserName(s);
    }

    public void crash()
    {
        core.crash();
    }

    protected volatile Object doInBackground()
    {
        return doInBackground();
    }

    protected Void doInBackground()
    {
        return null;
    }

    public boolean getDebugMode()
    {
        zw.h().d("Crashlytics", "Use of Crashlytics.getDebugMode is deprecated.");
        getFabric();
        return zw.i();
    }

    public String getIdentifier()
    {
        return "com.crashlytics.sdk.android:crashlytics";
    }

    public Collection getKits()
    {
        return kits;
    }

    public String getVersion()
    {
        return "2.5.2.79";
    }

    public void setDebugMode(boolean flag)
    {
        zw.h().d("Crashlytics", "Use of Crashlytics.setDebugMode is deprecated.");
    }

    public void setListener(CrashlyticsListener crashlyticslistener)
    {
        this;
        JVM INSTR monitorenter ;
        core.setListener(crashlyticslistener);
        this;
        JVM INSTR monitorexit ;
        return;
        crashlyticslistener;
        throw crashlyticslistener;
    }

    public boolean verifyPinning(URL url)
    {
        return core.verifyPinning(url);
    }
}

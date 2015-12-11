// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android;

import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.beta.Beta;
import com.crashlytics.android.core.CrashlyticsCore;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.KitGroup;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Crashlytics extends Kit
    implements KitGroup
{

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
        kits = Collections.unmodifiableCollection(Arrays.asList(new Kit[] {
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
        return (Crashlytics)Fabric.getKit(com/crashlytics/android/Crashlytics);
    }

    public static void log(String s)
    {
        checkInitialized();
        getInstance().core.log(s);
    }

    public static void setInt(String s, int i)
    {
        checkInitialized();
        getInstance().core.setInt(s, i);
    }

    public static void setString(String s, String s1)
    {
        checkInitialized();
        getInstance().core.setString(s, s1);
    }

    public static void setUserIdentifier(String s)
    {
        checkInitialized();
        getInstance().core.setUserIdentifier(s);
    }

    protected volatile Object doInBackground()
    {
        return doInBackground();
    }

    protected Void doInBackground()
    {
        return null;
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
        return "2.4.0.61";
    }
}

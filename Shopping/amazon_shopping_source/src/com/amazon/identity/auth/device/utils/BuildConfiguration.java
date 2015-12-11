// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import com.amazon.identity.auth.device.framework.InvalidEnumValueException;
import java.util.Locale;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            KeyType

public final class BuildConfiguration extends Enum
{

    private static final BuildConfiguration $VALUES[];
    public static final BuildConfiguration Eng;
    public static final BuildConfiguration ReleaseDebug;
    public static final BuildConfiguration User;
    public static final BuildConfiguration UserDebug;
    private final KeyType mSignedWith;

    private BuildConfiguration(String s, int i, KeyType keytype)
    {
        super(s, i);
        mSignedWith = keytype;
    }

    public static BuildConfiguration fromString(String s)
        throws InvalidEnumValueException
    {
        if (s == null)
        {
            throw new InvalidEnumValueException("Null is not a valid BuildType");
        }
        BuildConfiguration abuildconfiguration[] = values();
        int j = abuildconfiguration.length;
        for (int i = 0; i < j; i++)
        {
            BuildConfiguration buildconfiguration = abuildconfiguration[i];
            if (buildconfiguration.toString().toLowerCase(Locale.US).equals(s.toLowerCase(Locale.US)))
            {
                return buildconfiguration;
            }
        }

        throw new InvalidEnumValueException((new StringBuilder("Unknown build type: ")).append(s).toString());
    }

    public static BuildConfiguration valueOf(String s)
    {
        return (BuildConfiguration)Enum.valueOf(com/amazon/identity/auth/device/utils/BuildConfiguration, s);
    }

    public static BuildConfiguration[] values()
    {
        return (BuildConfiguration[])$VALUES.clone();
    }

    public boolean isSignedWith(KeyType keytype)
    {
        return mSignedWith == keytype;
    }

    static 
    {
        Eng = new BuildConfiguration("Eng", 0, KeyType.Debug);
        UserDebug = new BuildConfiguration("UserDebug", 1, KeyType.Release);
        User = new BuildConfiguration("User", 2, KeyType.Release);
        ReleaseDebug = new BuildConfiguration("ReleaseDebug", 3, KeyType.ReleaseDebug);
        $VALUES = (new BuildConfiguration[] {
            Eng, UserDebug, User, ReleaseDebug
        });
    }
}

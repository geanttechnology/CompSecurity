// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.Versioned;
import com.fasterxml.jackson.core.util.VersionUtil;

public final class PackageVersion
    implements Versioned
{

    public static final Version VERSION = VersionUtil.parseVersion("2.3.4", "com.fasterxml.jackson.core", "jackson-core");

    public PackageVersion()
    {
    }

    public Version version()
    {
        return VERSION;
    }

}

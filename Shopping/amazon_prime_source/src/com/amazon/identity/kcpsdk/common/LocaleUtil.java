// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.common;

import java.util.Locale;

public final class LocaleUtil
{

    public static String getLocaleAsLanguageTag(Locale locale)
    {
        return locale.toString().replace("_", "-");
    }
}

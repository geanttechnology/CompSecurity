// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.configuration;

import com.shazam.b.b;
import java.net.URL;

public interface SearchConfiguration
{

    public static final SearchConfiguration NO_OP = (SearchConfiguration)b.a(com/shazam/model/configuration/SearchConfiguration);

    public abstract URL a(String s);

    public abstract boolean a();

}

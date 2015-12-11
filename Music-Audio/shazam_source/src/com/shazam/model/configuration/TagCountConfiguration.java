// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.configuration;

import com.shazam.b.b;
import java.net.URL;

public interface TagCountConfiguration
{

    public static final TagCountConfiguration NO_OP = (TagCountConfiguration)b.a(com/shazam/model/configuration/TagCountConfiguration);

    public abstract URL a(String s);

}

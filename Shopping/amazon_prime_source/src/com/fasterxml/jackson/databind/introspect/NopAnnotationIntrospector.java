// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.cfg.DatabindVersion;
import java.io.Serializable;

public abstract class NopAnnotationIntrospector extends AnnotationIntrospector
    implements Serializable
{

    public static final NopAnnotationIntrospector instance = new NopAnnotationIntrospector() {

        private static final long serialVersionUID = 1L;

        public Version version()
        {
            return DatabindVersion.instance.version();
        }

    };
    private static final long serialVersionUID = 1L;

    public NopAnnotationIntrospector()
    {
    }

    public Version version()
    {
        return Version.unknownVersion();
    }

}

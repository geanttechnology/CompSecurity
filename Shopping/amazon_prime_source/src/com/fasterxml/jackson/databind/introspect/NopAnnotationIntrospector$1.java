// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.cfg.DatabindVersion;

// Referenced classes of package com.fasterxml.jackson.databind.introspect:
//            NopAnnotationIntrospector

static final class  extends NopAnnotationIntrospector
{

    private static final long serialVersionUID = 1L;

    public Version version()
    {
        return DatabindVersion.instance.version();
    }

    ()
    {
    }
}

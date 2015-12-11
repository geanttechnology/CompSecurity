// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import com.google.inject.TypeLiteral;
import com.google.inject.matcher.AbstractMatcher;

// Referenced classes of package com.google.inject.internal:
//            TypeConverterBindingProcessor

static final class  extends AbstractMatcher
{

    public boolean matches(TypeLiteral typeliteral)
    {
        return typeliteral.getRawType() == java/lang/Class;
    }

    public volatile boolean matches(Object obj)
    {
        return matches((TypeLiteral)obj);
    }

    public String toString()
    {
        return "Class<?>";
    }

    ()
    {
    }
}

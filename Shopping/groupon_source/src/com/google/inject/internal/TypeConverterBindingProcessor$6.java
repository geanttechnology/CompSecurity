// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import com.google.inject.TypeLiteral;
import com.google.inject.matcher.AbstractMatcher;
import com.google.inject.matcher.Matcher;

// Referenced classes of package com.google.inject.internal:
//            TypeConverterBindingProcessor

static final class val.typeMatcher extends AbstractMatcher
{

    final Matcher val$typeMatcher;

    public boolean matches(TypeLiteral typeliteral)
    {
        typeliteral = typeliteral.getType();
        if (!(typeliteral instanceof Class))
        {
            return false;
        } else
        {
            typeliteral = (Class)typeliteral;
            return val$typeMatcher.matches(typeliteral);
        }
    }

    public volatile boolean matches(Object obj)
    {
        return matches((TypeLiteral)obj);
    }

    public String toString()
    {
        return val$typeMatcher.toString();
    }

    (Matcher matcher)
    {
        val$typeMatcher = matcher;
        super();
    }
}

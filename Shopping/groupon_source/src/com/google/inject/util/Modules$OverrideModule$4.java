// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.util;

import com.google.inject.Scope;
import com.google.inject.spi.DefaultBindingScopingVisitor;

// Referenced classes of package com.google.inject.util:
//            Modules

class or extends DefaultBindingScopingVisitor
{

    final visitScope this$0;

    public Scope visitScope(Scope scope)
    {
        return scope;
    }

    public volatile Object visitScope(Scope scope)
    {
        return visitScope(scope);
    }

    or()
    {
        this$0 = this._cls0.this;
        super();
    }
}

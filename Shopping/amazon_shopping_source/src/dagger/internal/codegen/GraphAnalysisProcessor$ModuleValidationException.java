// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package dagger.internal.codegen;

import javax.lang.model.element.Element;

// Referenced classes of package dagger.internal.codegen:
//            GraphAnalysisProcessor

static class source extends IllegalStateException
{

    final Element source;

    public (String s, Element element)
    {
        super(s);
        source = element;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.spi;


// Referenced classes of package com.google.inject.spi:
//            BindingTargetVisitor, ProvidesMethodBinding

public interface ProvidesMethodTargetVisitor
    extends BindingTargetVisitor
{

    public abstract Object visit(ProvidesMethodBinding providesmethodbinding);
}

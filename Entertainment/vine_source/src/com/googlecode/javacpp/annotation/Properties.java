// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacpp.annotation;

import java.lang.annotation.Annotation;

// Referenced classes of package com.googlecode.javacpp.annotation:
//            Platform

public interface Properties
    extends Annotation
{

    public abstract Class[] inherit();

    public abstract String target();

    public abstract Platform[] value();
}

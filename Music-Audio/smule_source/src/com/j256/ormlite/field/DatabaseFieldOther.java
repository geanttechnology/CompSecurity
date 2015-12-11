// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.field;

import java.lang.annotation.Annotation;

// Referenced classes of package com.j256.ormlite.field:
//            DataType

public interface DatabaseFieldOther
    extends Annotation
{

    public abstract String columnDefinition();

    public abstract DataType dataType();

    public abstract String format();

    public abstract Class persisterClass();

    public abstract boolean throwIfNull();

    public abstract String unknownEnumName();

    public abstract boolean useGetSet();

    public abstract boolean version();
}

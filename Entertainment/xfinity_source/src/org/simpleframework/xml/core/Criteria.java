// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;


// Referenced classes of package org.simpleframework.xml.core:
//            Variable, Label

interface Criteria
    extends Iterable
{

    public abstract void commit(Object obj)
        throws Exception;

    public abstract Variable get(Object obj)
        throws Exception;

    public abstract Variable get(Label label)
        throws Exception;

    public abstract Variable remove(Object obj)
        throws Exception;

    public abstract Variable resolve(String s)
        throws Exception;

    public abstract void set(Label label, Object obj)
        throws Exception;
}

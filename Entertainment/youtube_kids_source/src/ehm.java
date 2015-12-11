// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

abstract class ehm extends eic
{

    ehm()
    {
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        throw new InvalidObjectException("Use SerializedForm");
    }

    final boolean a()
    {
        return e().a();
    }

    public boolean contains(Object obj)
    {
        return e().contains(obj);
    }

    abstract ehr e();

    public boolean isEmpty()
    {
        return e().isEmpty();
    }

    public int size()
    {
        return e().size();
    }

    Object writeReplace()
    {
        return new ehn(e());
    }
}

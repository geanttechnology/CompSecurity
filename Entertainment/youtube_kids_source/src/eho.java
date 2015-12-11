// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Collection;

public abstract class eho extends eij
    implements ehb
{

    eho()
    {
    }

    static eho a(Collection collection)
    {
        switch (collection.size())
        {
        default:
            return new ekd(collection);

        case 0: // '\0'
            return ehe.a;

        case 1: // '\001'
            collection = (java.util.Map.Entry)a.b(collection);
            break;
        }
        return new ekx(collection.getKey(), collection.getValue());
    }

    public final ehr f()
    {
        return l_().d();
    }

    public abstract eho l_();

    public Collection values()
    {
        return l_().d();
    }

    Object writeReplace()
    {
        return new ehq(this);
    }
}

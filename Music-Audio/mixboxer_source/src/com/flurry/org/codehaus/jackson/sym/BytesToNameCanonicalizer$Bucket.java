// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.sym;


// Referenced classes of package com.flurry.org.codehaus.jackson.sym:
//            BytesToNameCanonicalizer, Name

static final class _next
{

    protected final Name _name;
    protected final _next _next;

    public Name find(int i, int j, int k)
    {
        if (_name.hashCode() != i || !_name.equals(j, k)) goto _L2; else goto _L1
_L1:
        Name name = _name;
_L6:
        return name;
_L2:
        _next _lnext = _next;
_L7:
        if (_lnext == null) goto _L4; else goto _L3
_L3:
        Name name1;
        name1 = _lnext._name;
        if (name1.hashCode() != i)
        {
            continue; /* Loop/switch isn't completed */
        }
        name = name1;
        if (name1.equals(j, k)) goto _L6; else goto _L5
_L5:
        _lnext = _lnext._next;
          goto _L7
_L4:
        return null;
    }

    public Name find(int i, int ai[], int j)
    {
        if (_name.hashCode() != i || !_name.equals(ai, j)) goto _L2; else goto _L1
_L1:
        Name name = _name;
_L6:
        return name;
_L2:
        _next _lnext = _next;
_L7:
        if (_lnext == null) goto _L4; else goto _L3
_L3:
        Name name1;
        name1 = _lnext._name;
        if (name1.hashCode() != i)
        {
            continue; /* Loop/switch isn't completed */
        }
        name = name1;
        if (name1.equals(ai, j)) goto _L6; else goto _L5
_L5:
        _lnext = _lnext._next;
          goto _L7
_L4:
        return null;
    }

    public int length()
    {
        int i = 1;
        for (_next _lnext = _next; _lnext != null; _lnext = _lnext._next)
        {
            i++;
        }

        return i;
    }

    I(Name name, I i)
    {
        _name = name;
        _next = i;
    }
}

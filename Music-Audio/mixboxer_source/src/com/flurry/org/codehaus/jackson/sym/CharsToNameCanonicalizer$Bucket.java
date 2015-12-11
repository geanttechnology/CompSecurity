// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.sym;


// Referenced classes of package com.flurry.org.codehaus.jackson.sym:
//            CharsToNameCanonicalizer

static final class mNext
{

    private final String _symbol;
    private final _symbol mNext;

    public String find(char ac[], int i, int j)
    {
        mNext mnext;
        String s;
        s = _symbol;
        mnext = mNext;
_L7:
        int k;
        if (s.length() != j)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        k = 0;
_L5:
        if (s.charAt(k) == ac[i + k]) goto _L2; else goto _L1
_L1:
        if (k == j)
        {
            return s;
        }
        break MISSING_BLOCK_LABEL_72;
_L2:
        int l = k + 1;
        k = l;
        if (l < j)
        {
            break; /* Loop/switch isn't completed */
        }
        k = l;
        if (true) goto _L1; else goto _L3
_L3:
        if (true) goto _L5; else goto _L4
_L4:
        if (mnext == null)
        {
            return null;
        }
        s = mnext.getSymbol();
        mnext = mnext.getNext();
        if (true) goto _L7; else goto _L6
_L6:
    }

    public getNext getNext()
    {
        return mNext;
    }

    public String getSymbol()
    {
        return _symbol;
    }

    public I(String s, I i)
    {
        _symbol = s;
        mNext = i;
    }
}

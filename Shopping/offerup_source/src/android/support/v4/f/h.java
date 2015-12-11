// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.f;


// Referenced classes of package android.support.v4.f:
//            l

public abstract class h
{

    private final l a;

    public h(l l1)
    {
        a = l1;
    }

    protected abstract boolean a();

    public boolean a(CharSequence charsequence, int i, int j)
    {
        boolean flag;
        flag = false;
        if (charsequence == null || j < 0 || charsequence.length() - j < 0)
        {
            throw new IllegalArgumentException();
        }
        if (a != null) goto _L2; else goto _L1
_L1:
        flag = a();
_L4:
        return flag;
_L2:
        switch (a.a(charsequence, 0, j))
        {
        default:
            return a();

        case 0: // '\0'
            return true;

        case 1: // '\001'
            break;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}

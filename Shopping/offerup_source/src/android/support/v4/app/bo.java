// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import java.util.ArrayList;

// Referenced classes of package android.support.v4.app:
//            bx, bl

public final class bo extends bx
{

    ArrayList a;

    public bo()
    {
        a = new ArrayList();
    }

    public final bo a(CharSequence charsequence)
    {
        c = bl.e(charsequence);
        return this;
    }

    public final bo b(CharSequence charsequence)
    {
        d = bl.e(charsequence);
        e = true;
        return this;
    }

    public final bo c(CharSequence charsequence)
    {
        a.add(bl.e(charsequence));
        return this;
    }
}

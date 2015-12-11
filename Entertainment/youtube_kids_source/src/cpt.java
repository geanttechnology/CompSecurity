// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class cpt
    implements cpu
{

    public final List a = new ArrayList();

    public cpt()
    {
    }

    public final Object b()
    {
        return new ArrayList(a);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.ab;


public abstract class ABTest
{

    private CharSequence name;

    public ABTest()
    {
    }

    public abstract void A();

    public abstract void B();

    public final CharSequence getName()
    {
        return name;
    }

    protected final void run(CharSequence charsequence, AB.Group group)
    {
        name = charsequence;
        if (group == AB.Group.GroupA)
        {
            A();
            return;
        } else
        {
            B();
            return;
        }
    }
}

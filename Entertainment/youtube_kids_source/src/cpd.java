// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.InputStream;

public abstract class cpd extends coo
{

    public final bns a;

    public cpd(bns bns1)
    {
        a = (bns)b.a(bns1);
    }

    public abstract bnq a();

    protected final Object a(InputStream inputstream)
    {
        inputstream = (cpu)a.a(inputstream, a());
        try
        {
            inputstream = ((InputStream) (inputstream.b()));
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new bnn(inputstream);
        }
        return inputstream;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.io.InputStream;

// Referenced classes of package com.tapjoy.internal:
//            dz, dr, dx, dl, 
//            ec, du, dp

public abstract class dm
    implements dz
{

    private static final dr a = dr.a();

    public dm()
    {
    }

    private static dx a(dx dx1)
    {
        if (dx1 != null && !dx1.d())
        {
            ec ec1;
            if (dx1 instanceof dl)
            {
                ec1 = new ec();
            } else
            {
                ec1 = new ec();
            }
            throw ec1.a().a(dx1);
        } else
        {
            return dx1;
        }
    }

    private dx a(InputStream inputstream, dr dr1)
    {
        inputstream = new dp(inputstream);
        dr1 = (dx)a(((dp) (inputstream)), dr1);
        try
        {
            inputstream.a(0);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw inputstream.a(dr1);
        }
        return dr1;
    }

    private dx a(byte abyte0[], int i, dr dr1)
    {
        try
        {
            abyte0 = dp.a(abyte0, i);
            dr1 = (dx)a(((dp) (abyte0)), dr1);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw abyte0;
        }
        abyte0.a(0);
        return dr1;
        abyte0;
        throw abyte0.a(dr1);
    }

    public final volatile Object a(InputStream inputstream)
    {
        return a(a(inputstream, a));
    }

    public final volatile Object a(byte abyte0[])
    {
        dr dr1 = a;
        return a(a(abyte0, abyte0.length, dr1));
    }

}

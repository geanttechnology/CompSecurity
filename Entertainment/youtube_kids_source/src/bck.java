// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;

public class bck
{

    public bck()
    {
    }

    public void a(Context context)
    {
        try
        {
            bcc.a(context);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new bci(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new bcj(context);
        }
    }
}

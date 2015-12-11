// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.IBinder;
import android.view.View;

public final class adz extends sd
{

    private static final adz a = new adz();

    private adz()
    {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View a(Context context, int i, int j)
    {
        return a.b(context, i, j);
    }

    private View b(Context context, int i, int j)
    {
        try
        {
            ry ry = sb.a(context);
            context = (View)sb.a(((ads)a(context)).a(ry, i, j));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new se((new StringBuilder()).append("Could not get button with size ").append(i).append(" and color ").append(j).toString(), context);
        }
        return context;
    }

    public Object a(IBinder ibinder)
    {
        return b(ibinder);
    }

    public ads b(IBinder ibinder)
    {
        return adt.a(ibinder);
    }

}

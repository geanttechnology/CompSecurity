// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.plus.PlusOneDummyView;

public final class aqc extends sd
{

    private static final aqc a = new aqc();

    private aqc()
    {
        super("com.google.android.gms.plus.plusone.PlusOneButtonCreatorImpl");
    }

    public static View a(Context context, int i, int j, String s, int k)
    {
        if (s == null)
        {
            try
            {
                throw new NullPointerException();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return new PlusOneDummyView(context, i);
            }
        }
        s = (View)sb.a(((apz)a.a(context)).a(sb.a(context), i, j, s, k));
        return s;
    }

    protected Object a(IBinder ibinder)
    {
        return b(ibinder);
    }

    protected apz b(IBinder ibinder)
    {
        return aqa.a(ibinder);
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Messenger;
import java.util.List;

public abstract class r
{

    public r()
    {
    }

    public static boolean a(Messenger messenger)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (messenger != null)
        {
            try
            {
                messenger = messenger.getBinder();
            }
            // Misplaced declaration of an exception variable
            catch (Messenger messenger)
            {
                return false;
            }
            flag = flag1;
            if (messenger != null)
            {
                flag = true;
            }
        }
        return flag;
    }

    public abstract ac a();

    public abstract j a(String s);

    public abstract void a(int i, int j);

    public abstract boolean b();

    public abstract List c();
}

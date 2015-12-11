// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.RemoteException;
import android.util.Log;
import java.util.Map;

public final class baj
    implements ayg
{

    private ban a;
    private baf b;

    baj(ban ban1, baf baf1)
    {
        a = ban1;
        b = baf1;
    }

    public final String a(Map map)
    {
        boolean flag;
        if (a != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a.a(flag, "Handle is closed.");
        try
        {
            map = baf.a(a.a(map));
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            return baf.b(map.toString());
        }
        return map;
    }

    public final void a()
    {
        boolean flag;
        if (a != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a.a(flag, "Handle is closed.");
        try
        {
            a.a();
            a = null;
            b.b();
            b = null;
            return;
        }
        catch (RemoteException remoteexception)
        {
            Log.e("DGHandleImpl", "Error", remoteexception);
        }
    }
}

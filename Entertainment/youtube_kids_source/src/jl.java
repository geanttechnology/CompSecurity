// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;

final class jl
    implements android.os.IBinder.DeathRecipient
{

    final Messenger a;
    final jq b = new jq(this);
    int c;
    int d;
    int e;
    int f;
    final SparseArray g = new SparseArray();
    final jk h;
    private final Messenger i;

    public jl(jk jk1, Messenger messenger)
    {
        h = jk1;
        super();
        c = 1;
        d = 1;
        a = messenger;
        i = new Messenger(b);
    }

    static void a(jl jl1)
    {
        for (int j = 0; j < jl1.g.size(); j++)
        {
            jl1.g.valueAt(j);
        }

        jl1.g.clear();
    }

    public final void a(int j)
    {
        int k = c;
        c = k + 1;
        a(5, k, j, null, null);
    }

    public final void a(int j, int k)
    {
        Bundle bundle = new Bundle();
        bundle.putInt("volume", k);
        k = c;
        c = k + 1;
        a(7, k, j, null, bundle);
    }

    public final void a(ih ih1)
    {
        int j = c;
        c = j + 1;
        if (ih1 != null)
        {
            ih1 = ih1.a;
        } else
        {
            ih1 = null;
        }
        a(10, j, 0, ih1, null);
    }

    public final boolean a()
    {
        int j = c;
        c = j + 1;
        f = j;
        if (!a(1, f, 1, null, null))
        {
            return false;
        }
        try
        {
            a.getBinder().linkToDeath(this, 0);
        }
        catch (RemoteException remoteexception)
        {
            binderDied();
            return false;
        }
        return true;
    }

    boolean a(int j, int k, int l, Object obj, Bundle bundle)
    {
        Message message;
        message = Message.obtain();
        message.what = j;
        message.arg1 = k;
        message.arg2 = l;
        message.obj = obj;
        message.setData(bundle);
        message.replyTo = i;
        a.send(message);
        return true;
        obj;
        if (j != 2)
        {
            Log.e("MediaRouteProviderProxy", "Could not send message to service.", ((Throwable) (obj)));
        }
_L2:
        return false;
        obj;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final void b(int j, int k)
    {
        Bundle bundle = new Bundle();
        bundle.putInt("volume", k);
        k = c;
        c = k + 1;
        a(8, k, j, null, bundle);
    }

    public final void binderDied()
    {
        jk.a(h).post(new jn(this));
    }
}

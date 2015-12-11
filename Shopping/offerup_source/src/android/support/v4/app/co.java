// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package android.support.v4.app:
//            cp, ch, cq, cn, 
//            av

final class co
    implements ServiceConnection, android.os.Handler.Callback
{

    private final Context a;
    private final HandlerThread b = new HandlerThread("NotificationManagerCompat");
    private final Handler c;
    private final Map d = new HashMap();
    private Set e;

    public co(Context context)
    {
        e = new HashSet();
        a = context;
        b.start();
        c = new Handler(b.getLooper(), this);
    }

    private void a(cp cp1)
    {
        if (cp1.b)
        {
            a.unbindService(this);
            cp1.b = false;
        }
        cp1.c = null;
    }

    private void b(cp cp1)
    {
        if (c.hasMessages(3, cp1.a))
        {
            return;
        }
        cp1.e = cp1.e + 1;
        if (cp1.e > 6)
        {
            Log.w("NotifManCompat", (new StringBuilder("Giving up on delivering ")).append(cp1.d.size()).append(" tasks to ").append(cp1.a).append(" after ").append(cp1.e).append(" retries").toString());
            cp1.d.clear();
            return;
        }
        int i = (1 << cp1.e - 1) * 1000;
        if (Log.isLoggable("NotifManCompat", 3))
        {
            Log.d("NotifManCompat", (new StringBuilder("Scheduling retry for ")).append(i).append(" ms").toString());
        }
        cp1 = c.obtainMessage(3, cp1.a);
        c.sendMessageDelayed(cp1, i);
    }

    private void c(cp cp1)
    {
        if (Log.isLoggable("NotifManCompat", 3))
        {
            Log.d("NotifManCompat", (new StringBuilder("Processing component ")).append(cp1.a).append(", ").append(cp1.d.size()).append(" queued tasks").toString());
        }
        if (!cp1.d.isEmpty()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        boolean flag;
        if (cp1.b)
        {
            flag = true;
        } else
        {
            Intent intent = (new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL")).setComponent(cp1.a);
            cp1.b = a.bindService(intent, this, ch.a());
            if (cp1.b)
            {
                cp1.e = 0;
            } else
            {
                Log.w("NotifManCompat", (new StringBuilder("Unable to bind to listener ")).append(cp1.a).toString());
                a.unbindService(this);
            }
            flag = cp1.b;
        }
        if (!flag || cp1.c == null)
        {
            b(cp1);
            return;
        }
_L4:
        cq cq1;
        cq1 = (cq)cp1.d.peek();
        if (cq1 == null)
        {
            break MISSING_BLOCK_LABEL_282;
        }
        if (Log.isLoggable("NotifManCompat", 3))
        {
            Log.d("NotifManCompat", (new StringBuilder("Sending task ")).append(cq1).toString());
        }
        cq1.a(cp1.c);
        cp1.d.remove();
        if (true) goto _L4; else goto _L3
_L3:
        Object obj;
        obj;
        if (Log.isLoggable("NotifManCompat", 3))
        {
            Log.d("NotifManCompat", (new StringBuilder("Remote service has died: ")).append(cp1.a).toString());
        }
_L5:
        if (!cp1.d.isEmpty())
        {
            b(cp1);
            return;
        }
          goto _L1
        obj;
        Log.w("NotifManCompat", (new StringBuilder("RemoteException communicating with ")).append(cp1.a).toString(), ((Throwable) (obj)));
          goto _L5
    }

    public final void a(cq cq1)
    {
        c.obtainMessage(0, cq1).sendToTarget();
    }

    public final boolean handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return false;

        case 0: // '\0'
            message = (cq)message.obj;
            Object obj1 = ch.b(a);
            if (!((Set) (obj1)).equals(e))
            {
                e = ((Set) (obj1));
                Object obj2 = a.getPackageManager().queryIntentServices((new Intent()).setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 4);
                HashSet hashset = new HashSet();
                obj2 = ((List) (obj2)).iterator();
                do
                {
                    if (!((Iterator) (obj2)).hasNext())
                    {
                        break;
                    }
                    ResolveInfo resolveinfo = (ResolveInfo)((Iterator) (obj2)).next();
                    if (((Set) (obj1)).contains(resolveinfo.serviceInfo.packageName))
                    {
                        ComponentName componentname1 = new ComponentName(resolveinfo.serviceInfo.packageName, resolveinfo.serviceInfo.name);
                        if (resolveinfo.serviceInfo.permission != null)
                        {
                            Log.w("NotifManCompat", (new StringBuilder("Permission present on component ")).append(componentname1).append(", not adding listener record.").toString());
                        } else
                        {
                            hashset.add(componentname1);
                        }
                    }
                } while (true);
                obj1 = hashset.iterator();
                do
                {
                    if (!((Iterator) (obj1)).hasNext())
                    {
                        break;
                    }
                    ComponentName componentname = (ComponentName)((Iterator) (obj1)).next();
                    if (!d.containsKey(componentname))
                    {
                        if (Log.isLoggable("NotifManCompat", 3))
                        {
                            Log.d("NotifManCompat", (new StringBuilder("Adding listener record for ")).append(componentname).toString());
                        }
                        d.put(componentname, new cp(componentname));
                    }
                } while (true);
                obj1 = d.entrySet().iterator();
                do
                {
                    if (!((Iterator) (obj1)).hasNext())
                    {
                        break;
                    }
                    java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj1)).next();
                    if (!hashset.contains(entry.getKey()))
                    {
                        if (Log.isLoggable("NotifManCompat", 3))
                        {
                            Log.d("NotifManCompat", (new StringBuilder("Removing listener record for ")).append(entry.getKey()).toString());
                        }
                        a((cp)entry.getValue());
                        ((Iterator) (obj1)).remove();
                    }
                } while (true);
            }
            cp cp1;
            for (Iterator iterator = d.values().iterator(); iterator.hasNext(); c(cp1))
            {
                cp1 = (cp)iterator.next();
                cp1.d.add(message);
            }

            return true;

        case 1: // '\001'
            Object obj = (cn)message.obj;
            message = ((cn) (obj)).a;
            obj = ((cn) (obj)).b;
            message = (cp)d.get(message);
            if (message != null)
            {
                message.c = av.a(((IBinder) (obj)));
                message.e = 0;
                c(message);
            }
            return true;

        case 2: // '\002'
            message = (ComponentName)message.obj;
            message = (cp)d.get(message);
            if (message != null)
            {
                a(message);
            }
            return true;

        case 3: // '\003'
            message = (ComponentName)message.obj;
            message = (cp)d.get(message);
            break;
        }
        if (message != null)
        {
            c(message);
        }
        return true;
    }

    public final void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        if (Log.isLoggable("NotifManCompat", 3))
        {
            Log.d("NotifManCompat", (new StringBuilder("Connected to service ")).append(componentname).toString());
        }
        c.obtainMessage(1, new cn(componentname, ibinder)).sendToTarget();
    }

    public final void onServiceDisconnected(ComponentName componentname)
    {
        if (Log.isLoggable("NotifManCompat", 3))
        {
            Log.d("NotifManCompat", (new StringBuilder("Disconnected from service ")).append(componentname).toString());
        }
        c.obtainMessage(2, componentname).sendToTarget();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.i;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package android.support.v4.app:
//            q

public class ak
    implements Iterable
{
    public static interface a
    {

        public abstract Intent a();
    }

    static interface b
    {
    }

    static class c
        implements b
    {

        c()
        {
        }
    }

    static class d
        implements b
    {

        d()
        {
        }
    }


    private static final b a;
    private final ArrayList b = new ArrayList();
    private final Context c;

    private ak(Context context)
    {
        c = context;
    }

    public static ak a(Context context)
    {
        return new ak(context);
    }

    public ak a(Activity activity)
    {
        Object obj = null;
        if (activity instanceof a)
        {
            obj = ((a)activity).a();
        }
        if (obj == null)
        {
            activity = q.a(activity);
        } else
        {
            activity = ((Activity) (obj));
        }
        if (activity != null)
        {
            ComponentName componentname = activity.getComponent();
            obj = componentname;
            if (componentname == null)
            {
                obj = activity.resolveActivity(c.getPackageManager());
            }
            a(((ComponentName) (obj)));
            a(((Intent) (activity)));
        }
        return this;
    }

    public ak a(ComponentName componentname)
    {
        int j = b.size();
        try
        {
            componentname = q.a(c, componentname);
        }
        // Misplaced declaration of an exception variable
        catch (ComponentName componentname)
        {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(componentname);
        }
        if (componentname == null)
        {
            break; /* Loop/switch isn't completed */
        }
        b.add(j, componentname);
        componentname = q.a(c, componentname.getComponent());
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_17;
_L1:
        return this;
    }

    public ak a(Intent intent)
    {
        b.add(intent);
        return this;
    }

    public void a()
    {
        a(((Bundle) (null)));
    }

    public void a(Bundle bundle)
    {
        if (b.isEmpty())
        {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent aintent[] = (Intent[])b.toArray(new Intent[b.size()]);
        aintent[0] = (new Intent(aintent[0])).addFlags(0x1000c000);
        if (!i.a(c, aintent, bundle))
        {
            bundle = new Intent(aintent[aintent.length - 1]);
            bundle.addFlags(0x10000000);
            c.startActivity(bundle);
        }
    }

    public Iterator iterator()
    {
        return b.iterator();
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            a = new d();
        } else
        {
            a = new c();
        }
    }
}

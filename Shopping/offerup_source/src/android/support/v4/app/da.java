// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.b.a;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package android.support.v4.app:
//            dd, dc, ba, db

public final class da
    implements Iterable
{

    private final ArrayList a = new ArrayList();
    private final Context b;

    private da(Context context)
    {
        b = context;
    }

    private da a(ComponentName componentname)
    {
        int i = a.size();
        try
        {
            componentname = android.support.v4.app.ba.a(b, componentname);
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
        a.add(i, componentname);
        componentname = android.support.v4.app.ba.a(b, componentname.getComponent());
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_17;
_L1:
        return this;
    }

    public static da a(Context context)
    {
        return new da(context);
    }

    public final da a(Activity activity)
    {
        Object obj = null;
        if (activity instanceof db)
        {
            obj = ((db)activity).getSupportParentActivityIntent();
        }
        if (obj == null)
        {
            activity = android.support.v4.app.ba.a(activity);
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
                obj = activity.resolveActivity(b.getPackageManager());
            }
            a(((ComponentName) (obj)));
            a.add(activity);
        }
        return this;
    }

    public final void a()
    {
        if (a.isEmpty())
        {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent aintent[] = (Intent[])a.toArray(new Intent[a.size()]);
        aintent[0] = (new Intent(aintent[0])).addFlags(0x1000c000);
        if (!android.support.v4.b.a.a(b, aintent, null))
        {
            Intent intent = new Intent(aintent[aintent.length - 1]);
            intent.addFlags(0x10000000);
            b.startActivity(intent);
        }
    }

    public final Iterator iterator()
    {
        return a.iterator();
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            new dd();
        } else
        {
            new dc();
        }
    }
}

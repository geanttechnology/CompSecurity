// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package android.support.v4.app:
//            q

public final class ai
    implements Iterable
{
    public static interface a
    {

        public abstract Intent getSupportParentActivityIntent();
    }

    static interface b
    {
    }

    static final class c
        implements b
    {

        c()
        {
        }
    }

    static final class d
        implements b
    {

        d()
        {
        }
    }


    private static final b c;
    public final ArrayList a = new ArrayList();
    public final Context b;

    private ai(Context context)
    {
        b = context;
    }

    public static ai a(Context context)
    {
        return new ai(context);
    }

    public final ai a(ComponentName componentname)
    {
        int i = a.size();
        try
        {
            componentname = q.a(b, componentname);
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
        componentname = q.a(b, componentname.getComponent());
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_17;
_L1:
        return this;
    }

    public final Iterator iterator()
    {
        return a.iterator();
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            c = new d();
        } else
        {
            c = new c();
        }
    }
}

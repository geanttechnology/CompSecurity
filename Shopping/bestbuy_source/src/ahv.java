// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Intent;
import android.location.Location;
import com.google.android.gms.internal.nn;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ahv
{

    private final int a;
    private final int b;
    private final List c;
    private final Location d;

    private ahv(int i, int j, List list, Location location)
    {
        a = i;
        b = j;
        c = list;
        d = location;
    }

    public static ahv a(Intent intent)
    {
        if (intent == null)
        {
            return null;
        } else
        {
            return new ahv(intent.getIntExtra("gms_error_code", -1), b(intent), c(intent), (Location)intent.getParcelableExtra("com.google.android.location.intent.extra.triggering_location"));
        }
    }

    private static int b(Intent intent)
    {
        int i;
        for (i = intent.getIntExtra("com.google.android.location.intent.extra.transition", -1); i == -1 || i != 1 && i != 2 && i != 4;)
        {
            return -1;
        }

        return i;
    }

    private static List c(Intent intent)
    {
        Object obj = (ArrayList)intent.getSerializableExtra("com.google.android.location.intent.extra.geofence_list");
        if (obj == null)
        {
            return null;
        }
        intent = new ArrayList(((ArrayList) (obj)).size());
        for (obj = ((ArrayList) (obj)).iterator(); ((Iterator) (obj)).hasNext(); intent.add(nn.a((byte[])((Iterator) (obj)).next()))) { }
        return intent;
    }

    public boolean a()
    {
        return a != -1;
    }

    public int b()
    {
        return a;
    }

    public int c()
    {
        return b;
    }

    public List d()
    {
        return c;
    }
}

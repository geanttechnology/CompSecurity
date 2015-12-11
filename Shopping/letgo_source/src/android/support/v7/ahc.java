// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.DetectedActivity;
import com.kahuna.sdk.m;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package android.support.v7:
//            ahh, ahb, aha

public class ahc
{

    private static final List a = Arrays.asList(new Integer[] {
        Integer.valueOf(2), Integer.valueOf(8), Integer.valueOf(7), Integer.valueOf(5)
    });
    private static int b = -1;
    private static final ahc i = new ahc();
    private boolean c;
    private Context d;
    private ahb e;
    private aha f;
    private boolean g;
    private int h;

    private ahc()
    {
        c = false;
        g = false;
        h = 15000;
    }

    protected static void a(int j)
    {
        if (i != null)
        {
            i.h = j;
            if (i.h < 0)
            {
                i.h = 15000;
            }
        }
    }

    public static void a(Context context, Intent intent)
    {
        int k;
label0:
        {
            context = ActivityRecognitionResult.b(intent).a();
            int j = context.b();
            k = context.a();
            if (j >= 65 && b != k)
            {
                b = k;
                if (!a.contains(Integer.valueOf(k)))
                {
                    break label0;
                }
                if (m.s())
                {
                    Log.d("Kahuna", (new StringBuilder()).append("Got supported Activity type: ").append(b(k)).toString());
                }
                ahh.b();
            }
            return;
        }
        if (m.s())
        {
            Log.d("Kahuna", (new StringBuilder()).append("Got unsupported Activity type: ").append(b(k)).toString());
        }
        ahh.c();
    }

    public static void a(m m1)
    {
        if (m1 != null && (m1 instanceof m)) goto _L2; else goto _L1
_L1:
        Log.e("Kahuna", "You cannot use Activity Recognition Manager externally from the Kahuna SDK. Aborting!");
_L4:
        return;
_L2:
        if (i.g)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!m.s()) goto _L4; else goto _L3
_L3:
        Log.w("Kahuna", "App doens't have required permissions for Activity Monitoring. Aborting request for updates!");
        return;
        if (i.c) goto _L4; else goto _L5
_L5:
        i.d();
        i.e.b();
_L7:
        i.c = true;
        return;
        m1;
        if (m.s())
        {
            Log.w("Kahuna", "Caught error when attempting to request for ActivityMonitoring Updates.");
            Log.w("Kahuna", m1);
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static boolean a()
    {
        return i.g;
    }

    protected static int b()
    {
        if (i != null)
        {
            return i.h;
        } else
        {
            return -1;
        }
    }

    private static String b(int j)
    {
        switch (j)
        {
        case 3: // '\003'
        case 4: // '\004'
        case 6: // '\006'
        default:
            return "unknown";

        case 8: // '\b'
            return "running";

        case 7: // '\007'
            return "walking";

        case 2: // '\002'
            return "on foot";

        case 5: // '\005'
            return "standing";
        }
    }

    public static void b(m m1)
    {
        if (m1 != null && (m1 instanceof m)) goto _L2; else goto _L1
_L1:
        Log.e("Kahuna", "You cannot use Activity Recognition Manager externally from the Kahuna SDK. Aborting!");
_L4:
        return;
_L2:
        if (i.g)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!m.s()) goto _L4; else goto _L3
_L3:
        Log.w("Kahuna", "App doens't have required permissions for Activity Monitoring. Aborting request for removal of updates!");
        return;
        if (!i.c) goto _L4; else goto _L5
_L5:
        ahh.c();
        i.d();
        if (i.e.a() != null)
        {
            i.f.a(i.e.a());
            i.e.a().cancel();
        }
        i.e = null;
        i.f = null;
_L7:
        i.c = false;
        return;
        m1;
        if (m.s())
        {
            Log.w("Kahuna", "Caught error when attempting to remove ActivityMonitoring Updates.");
            Log.w("Kahuna", m1);
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    protected static void c()
    {
        if (i.e != null && ahh.a())
        {
            i.e.b();
        }
    }

    private void d()
    {
        if (e == null)
        {
            e = new ahb(d);
        }
        if (f == null)
        {
            f = new aha(d);
        }
    }

}

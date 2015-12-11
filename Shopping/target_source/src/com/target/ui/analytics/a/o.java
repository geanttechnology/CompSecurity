// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;

import android.support.v4.f.a;
import java.util.Collections;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.target.ui.analytics.a:
//            c, i, s, q

public class o extends c
{
    public static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a EnteredGeofence;
        public static final a ExitedGeofence;

        public static a valueOf(String s1)
        {
            return (a)Enum.valueOf(com/target/ui/analytics/a/o$a, s1);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            EnteredGeofence = new a("EnteredGeofence", 0);
            ExitedGeofence = new a("ExitedGeofence", 1);
            $VALUES = (new a[] {
                EnteredGeofence, ExitedGeofence
            });
        }

        private a(String s1, int j)
        {
            super(s1, j);
        }
    }


    private a mType;

    private o(a a1)
    {
        mType = a1;
    }

    public static o a(a a1)
    {
        return new o(a1);
    }

    private String b(a a1)
    {
        if (a1 == null)
        {
            return "";
        }
        static class _cls1
        {

            static final int $SwitchMap$com$target$ui$analytics$brighttag$NotificationGeofenceEvent$GeofenceChangeType[];

            static 
            {
                $SwitchMap$com$target$ui$analytics$brighttag$NotificationGeofenceEvent$GeofenceChangeType = new int[a.values().length];
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$NotificationGeofenceEvent$GeofenceChangeType[a.EnteredGeofence.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$NotificationGeofenceEvent$GeofenceChangeType[a.ExitedGeofence.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.target.ui.analytics.brighttag.NotificationGeofenceEvent.GeofenceChangeType[a1.ordinal()])
        {
        default:
            return "";

        case 1: // '\001'
            return "geofenceEntry";

        case 2: // '\002'
            return "geofenceExit";
        }
    }

    protected Map b()
    {
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        com.target.ui.analytics.a.i.a(a1, "events", b(mType));
        return a1;
    }

    protected s c()
    {
        return s.Unknown;
    }

    protected List d()
    {
        return Collections.emptyList();
    }

    protected q i()
    {
        return q.GeofenceChange;
    }
}

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

public class ao extends c
{
    public static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a WidgetInstantiated;
        public static final a WidgetRemoved;

        public static a valueOf(String s1)
        {
            return (a)Enum.valueOf(com/target/ui/analytics/a/ao$a, s1);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            WidgetInstantiated = new a("WidgetInstantiated", 0);
            WidgetRemoved = new a("WidgetRemoved", 1);
            $VALUES = (new a[] {
                WidgetInstantiated, WidgetRemoved
            });
        }

        private a(String s1, int j)
        {
            super(s1, j);
        }
    }


    private a mType;

    private ao(a a1)
    {
        mType = a1;
    }

    public static ao a(a a1)
    {
        return new ao(a1);
    }

    private String b(a a1)
    {
        if (a1 == null)
        {
            return "";
        }
        static class _cls1
        {

            static final int $SwitchMap$com$target$ui$analytics$brighttag$TargetWidgetEvent$TargetWidgetInstanceType[];

            static 
            {
                $SwitchMap$com$target$ui$analytics$brighttag$TargetWidgetEvent$TargetWidgetInstanceType = new int[a.values().length];
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TargetWidgetEvent$TargetWidgetInstanceType[a.WidgetInstantiated.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TargetWidgetEvent$TargetWidgetInstanceType[a.WidgetRemoved.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.target.ui.analytics.brighttag.TargetWidgetEvent.TargetWidgetInstanceType[a1.ordinal()])
        {
        default:
            return "";

        case 1: // '\001'
            return "widgetAdded";

        case 2: // '\002'
            return "widgetRemoved";
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
        return q.TargetWidget;
    }
}

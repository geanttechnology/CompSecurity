// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;

import com.target.mothership.util.o;
import java.util.Collections;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.target.ui.analytics.a:
//            e, i, s, y

class ae extends e
{
    static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a Add;
        public static final a Remove;

        public static a valueOf(String s1)
        {
            return (a)Enum.valueOf(com/target/ui/analytics/a/ae$a, s1);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            Add = new a("Add", 0);
            Remove = new a("Remove", 1);
            $VALUES = (new a[] {
                Add, Remove
            });
        }

        private a(String s1, int j)
        {
            super(s1, j);
        }
    }


    private final String mItemName;
    private final int mNumItems;
    private final a mType;

    private ae(a a1, String s1, int j)
    {
        mType = a1;
        mItemName = s1;
        mNumItems = j;
    }

    static ae a(a a1, String s1, int j)
    {
        return new ae(a1, s1, j);
    }

    private static String a(a a1)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$target$ui$analytics$brighttag$TapListEvent$ListEventType[];

            static 
            {
                $SwitchMap$com$target$ui$analytics$brighttag$TapListEvent$ListEventType = new int[a.values().length];
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapListEvent$ListEventType[a.Add.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapListEvent$ListEventType[a.Remove.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.target.ui.analytics.brighttag.TapListEvent.ListEventType[a1.ordinal()])
        {
        default:
            return "";

        case 1: // '\001'
            return "addProductToList";

        case 2: // '\002'
            return "removeProductFromList";
        }
    }

    private static String a(String s1)
    {
        if (o.e(s1))
        {
            return "";
        } else
        {
            return s1.toLowerCase();
        }
    }

    protected Map b()
    {
        Map map = super.b();
        com.target.ui.analytics.a.i.a(map, "events", a(mType));
        com.target.ui.analytics.a.i.a(map, "shoppingListItemAdded", a(mItemName));
        com.target.ui.analytics.a.i.a(map, "numberOfItemsInLists", String.valueOf(mNumItems));
        return map;
    }

    protected s c()
    {
        return com.target.ui.analytics.a.s.List;
    }

    protected List d()
    {
        return Collections.emptyList();
    }

    protected y i()
    {
        return y.ListInteraction;
    }
}

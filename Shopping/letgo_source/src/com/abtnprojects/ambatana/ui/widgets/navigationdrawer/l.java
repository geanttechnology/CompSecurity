// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.widgets.navigationdrawer;

import android.support.v7.aqo;
import android.view.View;

// Referenced classes of package com.abtnprojects.ambatana.ui.widgets.navigationdrawer:
//            j, h, i, a, 
//            k

public class l
{

    public static k a(int k, View view)
    {
        aqo.a("createViewHolder type : %s", new Object[] {
            a(k)
        });
        switch (k)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("Unaccepted view type : ").append(k).toString());

        case 0: // '\0'
            return new j(view);

        case 1: // '\001'
            return new h(view);

        case 2: // '\002'
            return new i(view);

        case 3: // '\003'
            return new a(view);
        }
    }

    private static String a(int k)
    {
        switch (k)
        {
        default:
            return null;

        case 0: // '\0'
            return "MENU_ITEM_TYPE_USER_INFO";

        case 1: // '\001'
            return "MENU_ITEM_TYPE_SIMPLE_ROW";

        case 2: // '\002'
            return "MENU_ITEM_TYPE_USER_GENERAL";

        case 3: // '\003'
            return "MENU_ITEM_TYPE_CONVERSATIONS";
        }
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util;

import android.content.Context;
import android.content.res.Resources;
import com.target.mothership.model.list.interfaces.ListSummary;
import com.target.ui.f.c;
import com.target.ui.fragment.list.ListDetailFragment;
import com.target.ui.model.list.ListCollectionItem;
import com.target.ui.view.common.h;

public class ad
{

    private static final int DEFAULT_ADD_TO_LIST_MSG = 0x7f09046d;

    public static void a(Context context, h h1, com.target.ui.view.common.h.b b)
    {
        a(context, context.getString(0x7f09046d), h1, b);
    }

    public static void a(Context context, String s, h h1, ListSummary listsummary, c c)
    {
        a(context, s, h1, new com.target.ui.view.common.h.b(listsummary, context, c) {

            final Context val$context;
            final ListSummary val$listSummary;
            final c val$navigationFragmentManager;

            public void a()
            {
                ListDetailFragment listdetailfragment = ListDetailFragment.a(new ListCollectionItem(listSummary, context));
                navigationFragmentManager.d(listdetailfragment);
            }

            public void b()
            {
            }

            
            {
                listSummary = listsummary;
                context = context1;
                navigationFragmentManager = c1;
                super();
            }
        });
    }

    public static void a(Context context, String s, h h1, com.target.ui.view.common.h.b b)
    {
        int i = context.getResources().getColor(0x7f0f00ec);
        h1.a(s, context.getString(0x7f090468), i, b);
    }
}

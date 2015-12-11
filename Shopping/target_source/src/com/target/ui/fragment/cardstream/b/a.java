// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cardstream.b;

import com.target.ui.fragment.cardstream.f.e;

public class a
{

    static final e sHideActionsList = e.a(0x7f100007).a(8).e(0x7f1000b7).a(8).a();
    private static final e sShowActionsListBase;
    static final e sShowActionsListBothActions;
    static final e sShowActionsListFirstActionOnly;
    static final e sShowImageHeaderHideTextHeader = e.a(0x7f100008).a(0).e(0x7f100009).a(8).a();
    static final e sShowTextHeaderHideImageHeader = e.a(0x7f100009).a(0).e(0x7f100008).a(8).a();

    static e a(int i)
    {
        return sShowImageHeaderHideTextHeader.b().b(0x7f100008).b(i).a();
    }

    static e a(int i, int j)
    {
        return sShowTextHeaderHideImageHeader.b().b(0x7f10000b).c(j).e(0x7f10000a).b(i).a();
    }

    static 
    {
        sShowActionsListBase = e.a(0x7f100007).a(0).e(0x7f1000b7).a(0).a();
        sShowActionsListFirstActionOnly = sShowActionsListBase.b().b(0x7f100004).a(0).e(0x7f100005).a(8).a();
        sShowActionsListBothActions = sShowActionsListBase.b().b(0x7f100004).a(0).e(0x7f100005).a(0).a();
    }
}

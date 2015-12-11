// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.g;

import android.content.Context;
import com.target.ui.j.b.e;

public class a
{

    public static boolean a(Context context)
    {
        return true;
    }

    public static boolean a(boolean flag)
    {
        com.target.ui.j.b.e.a a1 = com.target.ui.j.b.a.a().d().a();
        static class _cls1
        {

            static final int $SwitchMap$com$target$ui$taplytics$options$ListOrGridTestingOptions$ListOrGridExperiment[];

            static 
            {
                $SwitchMap$com$target$ui$taplytics$options$ListOrGridTestingOptions$ListOrGridExperiment = new int[com.target.ui.j.b.e.a.values().length];
                try
                {
                    $SwitchMap$com$target$ui$taplytics$options$ListOrGridTestingOptions$ListOrGridExperiment[com.target.ui.j.b.e.a.EXPERIMENT_GRID_VIEW.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$ui$taplytics$options$ListOrGridTestingOptions$ListOrGridExperiment[com.target.ui.j.b.e.a.EXPERIMENT_LIST_VIEW.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$ui$taplytics$options$ListOrGridTestingOptions$ListOrGridExperiment[com.target.ui.j.b.e.a.EXPERIMENT_DEFAULT.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.target.ui.taplytics.options.ListOrGridTestingOptions.ListOrGridExperiment[a1.ordinal()])
        {
        default:
            return flag;

        case 1: // '\001'
            return true;

        case 2: // '\002'
            return false;
        }
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.widget;


class us
{

    static final int $SwitchMap$com$urbanairship$actions$ActionResult$Status[];

    static 
    {
        $SwitchMap$com$urbanairship$actions$ActionResult$Status = new int[com.urbanairship.actions.s.values().length];
        try
        {
            $SwitchMap$com$urbanairship$actions$ActionResult$Status[com.urbanairship.actions.s.ACTION_NOT_FOUND.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$urbanairship$actions$ActionResult$Status[com.urbanairship.actions.s.REJECTED_ARGUMENTS.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$urbanairship$actions$ActionResult$Status[com.urbanairship.actions.s.EXECUTION_ERROR.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}

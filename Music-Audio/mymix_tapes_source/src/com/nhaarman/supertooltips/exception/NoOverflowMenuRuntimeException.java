// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nhaarman.supertooltips.exception;


public class NoOverflowMenuRuntimeException extends RuntimeException
{

    public NoOverflowMenuRuntimeException()
    {
        super("No overflow menu found. Are you sure the overflow menu button is visible? Check the docs for showToolTipForActionBarOverflowMenu(Activity, ToolTip) again!");
    }
}

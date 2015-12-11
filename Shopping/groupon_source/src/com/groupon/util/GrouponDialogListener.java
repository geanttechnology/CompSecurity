// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.DialogInterface;

public interface GrouponDialogListener
{

    public abstract void onDialogCancel(String s, DialogInterface dialoginterface);

    public abstract void onDialogItemClick(String s, DialogInterface dialoginterface, int i);

    public abstract void onDialogMultiChoiceItemClick(String s, DialogInterface dialoginterface, int i, boolean flag);

    public abstract void onDialogNegativeButtonClick(String s, DialogInterface dialoginterface);

    public abstract void onDialogPositiveButtonClick(String s, DialogInterface dialoginterface);

    public abstract void onDialogShown(String s, DialogInterface dialoginterface);
}

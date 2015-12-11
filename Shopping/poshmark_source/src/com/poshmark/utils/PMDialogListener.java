// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.content.DialogInterface;

public interface PMDialogListener
{

    public abstract void onClick(DialogInterface dialoginterface, int i);

    public abstract void onDismiss(DialogInterface dialoginterface);
}

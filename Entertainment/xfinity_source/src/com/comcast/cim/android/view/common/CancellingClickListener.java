// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.common;

import android.content.DialogInterface;

public class CancellingClickListener
    implements android.content.DialogInterface.OnClickListener
{

    public CancellingClickListener()
    {
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.cancel();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.actions;

import android.content.Intent;

public class resultCode
{

    private Intent intent;
    private int resultCode;

    private void setResult(int i, Intent intent1)
    {
        resultCode = i;
        intent = intent1;
    }

    public Intent getIntent()
    {
        return intent;
    }

    public int getResultCode()
    {
        return resultCode;
    }


    public ()
    {
        resultCode = 0;
    }
}

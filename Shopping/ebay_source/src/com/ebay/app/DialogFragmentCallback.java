// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.app;

import android.app.DialogFragment;

public interface DialogFragmentCallback
{

    public static final int RESULT_CANCELLED = 3;
    public static final int RESULT_NEGATIVE = 2;
    public static final int RESULT_POSITIVE = 1;

    public abstract void onDialogFragmentResult(DialogFragment dialogfragment, int i, int j);
}

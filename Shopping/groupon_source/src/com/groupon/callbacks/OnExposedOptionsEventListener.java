// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.callbacks;

import android.view.View;

public interface OnExposedOptionsEventListener
{

    public abstract void onAllOptionsButtonClick(View view);

    public abstract void onOptionSelectionChange(String s);
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.ui.controller.androidviewcontroller;

import android.view.View;

public interface AndroidViewController
{

    public abstract boolean onClick(View view, int i);

    public abstract boolean onLongClick(View view, int i);
}

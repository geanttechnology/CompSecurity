// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.boombox.widget.controller;

import com.amazon.boombox.widget.LenticularView;

public interface LenticularViewController
{

    public abstract void setView(LenticularView lenticularview);

    public abstract void start();

    public abstract void stop();
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.triggers;


public class TriggerThresholds
{

    public int initial_threshold;
    public int repeat_clicked_threshold;
    public int repeat_dismissed_threshold;
    public int repeat_ignored_threshold;

    public TriggerThresholds()
    {
        initial_threshold = 0x7fffffff;
        repeat_ignored_threshold = 0x7fffffff;
        repeat_clicked_threshold = 0x7fffffff;
        repeat_dismissed_threshold = 0x7fffffff;
    }
}

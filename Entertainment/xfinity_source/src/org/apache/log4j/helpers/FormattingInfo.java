// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j.helpers;


public class FormattingInfo
{

    boolean leftAlign;
    int max;
    int min;

    public FormattingInfo()
    {
        min = -1;
        max = 0x7fffffff;
        leftAlign = false;
    }

    void reset()
    {
        min = -1;
        max = 0x7fffffff;
        leftAlign = false;
    }
}

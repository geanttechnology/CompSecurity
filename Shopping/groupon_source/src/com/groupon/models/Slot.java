// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models;

import java.util.Collection;
import java.util.Collections;

public class Slot
{

    public String id;
    public Collection widgets;

    public Slot()
    {
        id = "";
        widgets = Collections.emptyList();
    }
}

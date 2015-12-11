// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.vast.model;

import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.ad.interfaces.ISlot;

public interface IVastValidation
{

    public abstract boolean isValid(ISlot islot, IConstants iconstants);
}

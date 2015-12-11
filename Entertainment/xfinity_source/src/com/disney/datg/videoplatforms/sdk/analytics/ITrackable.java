// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.analytics;

import java.util.List;
import java.util.Map;

public interface ITrackable
{

    public abstract void addContext(String s, Object obj);

    public abstract void addEvar(int i, String s);

    public abstract void addEvent(String s);

    public abstract void addProp(int i, String s);

    public abstract Map getContextData();

    public abstract List getEvars();

    public abstract List getEvents();

    public abstract String getName();

    public abstract List getProps();
}

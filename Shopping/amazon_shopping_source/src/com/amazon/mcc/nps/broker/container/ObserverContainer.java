// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mcc.nps.broker.container;

import com.amazon.mcc.nps.Observer;
import com.amazon.mcc.nps.ObserverProperties;
import com.amazon.mcc.nps.Topic;
import java.util.List;

public interface ObserverContainer
{

    public abstract boolean addObserverForTopic(Topic topic, Observer observer, ObserverProperties observerproperties);

    public abstract List getObserversForTopic(Topic topic);

    public abstract boolean removeObserverForTopic(Topic topic, Observer observer);
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.ad.interfaces;

import android.view.ViewGroup;
import java.util.ArrayList;

public interface ISlot
{

    public abstract ArrayList getAdInstances();

    public abstract ViewGroup getBase();

    public abstract String getCustomId();

    public abstract double getEmbeddedAdsDuration();

    public abstract double getEndTimePosition();

    public abstract int getHeight();

    public abstract double getPlayheadTime();

    public abstract double getTimePosition();

    public abstract int getTimePositionClass();

    public abstract double getTotalDuration();

    public abstract int getType();

    public abstract int getWidth();

    public abstract void pause();

    public abstract void play();

    public abstract void preload();

    public abstract void resume();

    public abstract void setParameter(String s, Object obj);

    public abstract void stop();
}

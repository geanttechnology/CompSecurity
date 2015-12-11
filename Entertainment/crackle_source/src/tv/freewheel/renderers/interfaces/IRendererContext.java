// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.interfaces;

import android.app.Activity;
import android.location.Location;
import java.util.ArrayList;
import java.util.HashMap;
import tv.freewheel.ad.interfaces.IAdInstance;
import tv.freewheel.ad.interfaces.IConstants;

// Referenced classes of package tv.freewheel.renderers.interfaces:
//            IActivityCallbackListener

public interface IRendererContext
{

    public abstract void addOnActivityCallbackListener(IActivityCallbackListener iactivitycallbacklistener);

    public abstract void dispatchEvent(String s);

    public abstract void dispatchEvent(String s, HashMap hashmap);

    public abstract Activity getActivity();

    public abstract IAdInstance getAdInstance();

    public abstract ArrayList getCompanionSlots();

    public abstract IConstants getConstants();

    public abstract Location getLocation();

    public abstract Object getParameter(String s);

    public abstract int getVersion();

    public abstract ArrayList scheduleAdInstances(ArrayList arraylist);

    public abstract void setRendererCapability(String s, int i);
}

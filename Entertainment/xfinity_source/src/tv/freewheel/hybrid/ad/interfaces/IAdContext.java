// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.ad.interfaces;

import android.app.Activity;
import android.widget.FrameLayout;
import java.util.ArrayList;

// Referenced classes of package tv.freewheel.hybrid.ad.interfaces:
//            IEventListener, IEvent, IConstants, ISlot

public interface IAdContext
{

    public abstract void addEventListener(String s, IEventListener ieventlistener);

    public abstract void dispatchEvent(IEvent ievent);

    public abstract void dispose();

    public abstract Activity getActivity();

    public abstract IConstants getConstants();

    public abstract Object getParameter(String s);

    public abstract ArrayList getSiteSectionNonTemporalSlots();

    public abstract ISlot getSlotByCustomId(String s);

    public abstract ArrayList getSlotsByTimePositionClass(int i);

    public abstract ArrayList getTemporalSlots();

    public abstract ArrayList getVideoPlayerNonTemporalSlots();

    public abstract void registerVideoDisplayBase(FrameLayout framelayout);

    public abstract void removeEventListener(String s, IEventListener ieventlistener);

    public abstract void setActivity(Activity activity);

    public abstract void setParameter(String s, Object obj, int i);

    public abstract void submitRequest(double d);
}

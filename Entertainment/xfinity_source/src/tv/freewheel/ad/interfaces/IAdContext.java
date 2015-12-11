// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.ad.interfaces;

import android.app.Activity;
import java.util.ArrayList;

// Referenced classes of package tv.freewheel.ad.interfaces:
//            IEventListener, IEvent, IConstants, ISlot

public interface IAdContext
{

    public abstract void addEventListener(String s, IEventListener ieventlistener);

    public abstract void dispatchEvent(IEvent ievent);

    public abstract Activity getActivity();

    public abstract IConstants getConstants();

    public abstract Object getParameter(String s);

    public abstract ArrayList getSiteSectionNonTemporalSlots();

    public abstract ISlot getSlotByCustomId(String s);

    public abstract ArrayList getSlotsByTimePositionClass(int i);

    public abstract ArrayList getTemporalSlots();

    public abstract ArrayList getVideoPlayerNonTemporalSlots();

    public abstract void setActivity(Activity activity);

    public abstract void setParameter(String s, Object obj, int i);

    public abstract void setProfile(String s, String s1, String s2, String s3);

    public abstract void setSiteSection(String s, int i, int j, int k, int l);

    public abstract void setVideoAsset(String s, double d, String s1, int i, int j, int k, 
            int l, int i1, int j1);

    public abstract void submitRequest(double d);
}

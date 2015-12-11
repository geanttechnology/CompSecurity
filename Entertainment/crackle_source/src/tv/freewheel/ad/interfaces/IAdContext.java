// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.ad.interfaces;

import android.app.Activity;
import android.view.SurfaceView;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package tv.freewheel.ad.interfaces:
//            IEventListener, IEvent, IAdManager, IConstants, 
//            ISlot

public interface IAdContext
{

    public abstract void addEventListener(String s, IEventListener ieventlistener);

    public abstract void addKeyValue(String s, String s1);

    public abstract void addRenderer(String s, String s1, String s2, String s3, String s4, String s5, HashMap hashmap);

    public abstract void addRenderer(String s, String s1, String s2, String s3, String s4, HashMap hashmap);

    public abstract void addSiteSectionNonTemporalSlot(String s, String s1, int i, int j, String s2, boolean flag, String s3, 
            String s4);

    public abstract void addSiteSectionNonTemporalSlot(String s, String s1, int i, int j, String s2, boolean flag, String s3, 
            String s4, int k, String s5);

    public abstract void addTemporalSlot(String s, String s1, double d, String s2, int i, double d1, String s3, String s4, double d2);

    public abstract void addVideoPlayerNonTemporalSlot(String s, String s1, int i, int j, String s2, boolean flag, String s3, 
            String s4);

    public abstract void addVideoPlayerNonTemporalSlot(String s, String s1, int i, int j, String s2, boolean flag, String s3, 
            String s4, int k, String s5);

    public abstract void dispatchEvent(IEvent ievent);

    public abstract void dispose();

    public abstract Activity getActivity();

    public abstract IAdManager getAdManager();

    public abstract IConstants getConstants();

    public abstract Object getParameter(String s);

    public abstract int getRequestMode();

    public abstract ArrayList getSiteSectionNonTemporalSlots();

    public abstract ISlot getSlotByCustomId(String s);

    public abstract ArrayList getSlotsByTimePositionClass(int i);

    public abstract ArrayList getTemporalSlots();

    public abstract String getVideoLocation();

    public abstract ArrayList getVideoPlayerNonTemporalSlots();

    public abstract void loadExtension(String s);

    public abstract void notifyUserAction(int i);

    public abstract void registerVideoDisplay(SurfaceView surfaceview);

    public abstract void registerVideoDisplayBase(FrameLayout framelayout);

    public abstract void removeEventListener(String s, IEventListener ieventlistener);

    public abstract void resetExclusivity();

    public abstract void setActivity(Activity activity);

    public abstract void setActivityState(int i);

    public abstract void setCapability(String s, int i);

    public abstract void setParameter(String s, Object obj, int i);

    public abstract void setProfile(String s, String s1, String s2, String s3);

    public abstract void setRequestDuration(double d);

    public abstract void setRequestMode(int i);

    public abstract void setSiteSection(String s, int i, int j, int k, int l);

    public abstract void setVideoAsset(String s, double d, String s1, int i, int j, int k, 
            int l, int i1, int j1);

    public abstract void setVideoAsset(String s, double d, String s1, boolean flag, int i, int j, 
            int k, int l);

    public abstract void setVideoAssetCurrentTimePosition(double d);

    public abstract void setVideoPlayer(int i);

    public abstract void setVideoState(int i);

    public abstract void setVisitor(String s, String s1, int i, String s2);

    public abstract void setVisitorHttpHeader(String s, String s1);

    public abstract void startSubsession(int i);

    public abstract void submitRequest(double d);
}

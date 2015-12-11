// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import android.graphics.PointF;
import android.os.Handler;
import android.util.Log;
import com.pointinside.internal.utils.LogUtils;
import com.pointinside.maps.model.CameraPosition;
import com.pointinside.model.Zone;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.pointinside.maps:
//            PIMap, PIMGLEventData, MarkerController, MapView, 
//            EventTypeHandler, SetRouteEventTypeHandler, PIMGLCameraAttrs, PIMGL, 
//            Projection

class this._cls0
    implements erface.PIMGLEventHandlerFunc
{

    final PIMap this$0;

    public void apply(PIMGLEventData pimgleventdata)
    {
        Object obj;
        obj = pimgleventdata.mUserdata;
        if (obj == null)
        {
            obj = entHandlerActions.UNKNOWN;
        } else
        {
            obj = entHandlerActions.fromId(((Pointer) (obj)).getInt(0L));
        }
        pimgleventdata.mType;
        JVM INSTR tableswitch 0 15: default 96
    //                   0 96
    //                   1 625
    //                   2 734
    //                   3 809
    //                   4 96
    //                   5 922
    //                   6 883
    //                   7 876
    //                   8 109
    //                   9 590
    //                   10 340
    //                   11 96
    //                   12 466
    //                   13 533
    //                   14 96
    //                   15 385;
           goto _L1 _L1 _L2 _L3 _L4 _L1 _L5 _L6 _L7 _L8 _L9 _L10 _L1 _L11 _L12 _L1 _L13
_L1:
        return;
_L8:
        pimgleventdata = PIMap.access$000(PIMap.this, pimgleventdata.mZone).getUUID();
        PIMap.access$100(PIMap.this).addAnyPendingMarker(pimgleventdata);
        if (PIMap.access$200(PIMap.this) != null)
        {
            PIMap.access$200(PIMap.this).postZoneLoad(pimgleventdata, PIMap.access$300(PIMap.this).addAndGet(1), PIMap.access$400(PIMap.this));
        }
        .SwitchMap.com.pointinside.maps.PIMap.EventHandlerActions[((entHandlerActions) (obj)).ordinal()];
        JVM INSTR tableswitch 1 2: default 208
    //                   1 219
    //                   2 250;
           goto _L14 _L15 _L16
_L14:
        PIMap.access$800(PIMap.this).startTryingToRefreshAccessibility();
        return;
_L15:
        pimgleventdata = (IntByReference)mZoneUUIDToZoneRefMap.get(pimgleventdata);
        PIMap.access$500(PIMap.this).execute(pimgleventdata);
        continue; /* Loop/switch isn't completed */
_L16:
        if (PIMap.access$600(PIMap.this) != null)
        {
            PIMap.access$600(PIMap.this).countDown();
        }
        int i = PIMap.access$700(PIMap.this).size();
        if (PIMap.access$500(PIMap.this) instanceof SetRouteEventTypeHandler)
        {
            PIMap.access$500(PIMap.this).execute();
        } else
        if (mZoneUUIDToZoneRefMap.size() == i)
        {
            PIMap.access$500(PIMap.this).execute();
        }
        if (true) goto _L14; else goto _L10
_L10:
        PIMap.access$900(PIMap.this).set(true);
        switch (.SwitchMap.com.pointinside.maps.PIMap.EventHandlerActions[((entHandlerActions) (obj)).ordinal()])
        {
        default:
            return;

        case 3: // '\003'
            PIMap.access$1000(PIMap.this);
            break;
        }
        return;
_L13:
        PIMap.access$900(PIMap.this).set(false);
        PIMap.access$1100(PIMap.this).set(false);
        switch (.SwitchMap.com.pointinside.maps.PIMap.EventHandlerActions[((entHandlerActions) (obj)).ordinal()])
        {
        default:
            return;

        case 4: // '\004'
            break;
        }
        if (PIMap.access$1200(PIMap.this) != null)
        {
            PIMap.access$1300(PIMap.this).postDelayed(new Runnable() {

                final PIMap._cls1 this$1;

                public void run()
                {
                    PIMap.access$1200(this$0).onCameraSet();
                    PIMap.access$800(this$0).startTryingToRefreshAccessibility();
                }

            
            {
                this$1 = PIMap._cls1.this;
                super();
            }
            }, 240L);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L11:
        float f;
        Object obj1;
        if (pimgleventdata.mZone != null)
        {
            pimgleventdata = PIMap.access$000(PIMap.this, pimgleventdata.mZone);
        } else
        {
            pimgleventdata = null;
        }
        obj = PIMap.access$1400();
        obj1 = (new StringBuilder()).append("ZonePickerSelectionChanged ");
        if (pimgleventdata == null)
        {
            pimgleventdata = "No Zone";
        } else
        {
            pimgleventdata = pimgleventdata.getName();
        }
        Log.i(((String) (obj)), ((StringBuilder) (obj1)).append(pimgleventdata).toString());
        return;
_L12:
        Log.i(PIMap.access$1400(), "ZonePickerSelectionChangedProgramatically");
        if (!PIMap.access$1100(PIMap.this).get())
        {
            pimgleventdata = PIMap.access$000(PIMap.this, pimgleventdata.mZone);
            PIMap.access$1502(PIMap.this, CameraPosition.createWith(pimgleventdata).build());
            PIMap.access$1600(PIMap.this);
            return;
        }
        if (true) goto _L1; else goto _L9
_L9:
        pimgleventdata = PIMap.access$000(PIMap.this, pimgleventdata.mZone);
        PIMap.access$1502(PIMap.this, CameraPosition.createWith(pimgleventdata).build());
        PIMap.access$1600(PIMap.this);
        return;
_L2:
        switch (.SwitchMap.com.pointinside.maps.PIMap.EventHandlerActions[((entHandlerActions) (obj)).ordinal()])
        {
        default:
            return;

        case 4: // '\004'
            if (PIMap.access$1200(PIMap.this) != null)
            {
                PIMap.access$1200(PIMap.this).onCameraSet();
            }
            if (PIMap.access$1700(PIMap.this))
            {
                if (PIMap.access$1800(PIMap.this) != null)
                {
                    PIMap.access$1800(PIMap.this).onZoneChange(PIMap.this);
                }
                PIMap.access$1702(PIMap.this, false);
                return;
            }
            break;

        case 5: // '\005'
            hideZoneSelector(true);
            return;
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L3:
        if (PIMap.access$1900(PIMap.this) != null)
        {
            pimgleventdata = new PIMGLCameraAttrs();
            PIMGL.camera_getAttrs(PIMap.access$2000(PIMap.this), pimgleventdata);
            f = PIMap.access$1500(PIMap.this).zone.getImageSizeInMapUnits().x / ((PIMGLCameraAttrs) (pimgleventdata)).scope;
            PIMap.access$1900(PIMap.this).onCameraZoomChange(f);
        }
        PIMap.access$800(PIMap.this).refreshAccessibility();
        return;
_L4:
        if (PIMap.access$1900(PIMap.this) != null)
        {
            pimgleventdata = new PIMGLCameraAttrs();
            PIMGL.camera_getAttrs(PIMap.access$2000(PIMap.this), pimgleventdata);
            PIMap.access$1900(PIMap.this).onCameraPositionChange(new PointF(((PIMGLCameraAttrs) (pimgleventdata)).x, ((PIMGLCameraAttrs) (pimgleventdata)).y));
        }
        PIMap.access$800(PIMap.this).refreshAccessibility();
        return;
_L7:
        if (obj == entHandlerActions.ROUTE_WITH_ANIMATION)
        {
            continue; /* Loop/switch isn't completed */
        }
_L6:
        if (PIMap.access$2100(PIMap.this) != null)
        {
            PIMap.access$2100(PIMap.this).onPostRouteDraw(PIMap.access$2200(PIMap.this));
            PIMap.access$2102(PIMap.this, null);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (pimgleventdata.mTapCount == 1 && PIMap.access$2300(PIMap.this) != null)
        {
            obj = new PointF(pimgleventdata.mTapX, pimgleventdata.mTapY);
            obj1 = PIMap.access$2400(PIMap.this).viewToPointInZone(pimgleventdata.mTapX, pimgleventdata.mTapY);
            LogUtils.logD(PIMap.access$1400(), (new StringBuilder()).append("Event InputTap pointInZone: ").append(pimgleventdata.mTapX).append(" ,").append(pimgleventdata.mTapY).append("; pointInView: ").append(((PointF) (obj1)).toString()).toString());
            if (PIMap.access$2500(PIMap.this) != null)
            {
                pimgleventdata = new PointerByReference();
                if (PIMGL.annotation_pick(PIMap.access$2000(PIMap.this), ((PointF) (obj)).x, ((PointF) (obj)).y, pimgleventdata))
                {
                    pimgleventdata = pimgleventdata.getValue();
                    if (pimgleventdata != null)
                    {
                        pimgleventdata = PIMap.access$100(PIMap.this).getMarker(pimgleventdata);
                        if (pimgleventdata != null)
                        {
                            PIMap.access$2500(PIMap.this).onMarkerClick(pimgleventdata, ((PointF) (obj1)), ((PointF) (obj)));
                            return;
                        }
                    }
                }
            }
            if (PIMap.access$2600(PIMap.this) != null)
            {
                PIMap.access$2600(PIMap.this).onSingleTapEvent(((PointF) (obj1)), ((PointF) (obj)));
                return;
            }
        }
        if (true) goto _L1; else goto _L17
_L17:
    }

    _cls1.this._cls1()
    {
        this$0 = PIMap.this;
        super();
    }
}

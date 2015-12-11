// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            A9VSMobileJNI, ObjectInfo, VectorOfString, VectorOfPoint2f, 
//            ObjectID, StatusID, CameraStabilityIssue, JudgeVerdictOnModule, 
//            ActionID, ServerFailure, TextCanvasInfo

public class EventDelegateBase
{

    protected boolean swigCMemOwn;
    private long swigCPtr;

    public EventDelegateBase()
    {
        this(A9VSMobileJNI.new_EventDelegateBase(), true);
        A9VSMobileJNI.EventDelegateBase_director_connect(this, swigCPtr, swigCMemOwn, true);
    }

    protected EventDelegateBase(long l, boolean flag)
    {
        swigCMemOwn = flag;
        swigCPtr = l;
    }

    protected static long getCPtr(EventDelegateBase eventdelegatebase)
    {
        if (eventdelegatebase == null)
        {
            return 0L;
        } else
        {
            return eventdelegatebase.swigCPtr;
        }
    }

    public void delete()
    {
        this;
        JVM INSTR monitorenter ;
        if (swigCPtr != 0L)
        {
            if (swigCMemOwn)
            {
                swigCMemOwn = false;
                A9VSMobileJNI.delete_EventDelegateBase(swigCPtr);
            }
            swigCPtr = 0L;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void didDecode(ObjectInfo objectinfo)
    {
        if (getClass() == com/a9/vs/mobile/library/impl/jni/EventDelegateBase)
        {
            A9VSMobileJNI.EventDelegateBase_didDecode(swigCPtr, this, ObjectInfo.getCPtr(objectinfo), objectinfo);
            return;
        } else
        {
            A9VSMobileJNI.EventDelegateBase_didDecodeSwigExplicitEventDelegateBase(swigCPtr, this, ObjectInfo.getCPtr(objectinfo), objectinfo);
            return;
        }
    }

    public void didDecodeFreeText(VectorOfString vectorofstring, VectorOfString vectorofstring1, String s)
    {
        if (getClass() == com/a9/vs/mobile/library/impl/jni/EventDelegateBase)
        {
            A9VSMobileJNI.EventDelegateBase_didDecodeFreeText(swigCPtr, this, VectorOfString.getCPtr(vectorofstring), vectorofstring, VectorOfString.getCPtr(vectorofstring1), vectorofstring1, s);
            return;
        } else
        {
            A9VSMobileJNI.EventDelegateBase_didDecodeFreeTextSwigExplicitEventDelegateBase(swigCPtr, this, VectorOfString.getCPtr(vectorofstring), vectorofstring, VectorOfString.getCPtr(vectorofstring1), vectorofstring1, s);
            return;
        }
    }

    public void didDecodeTextCanvas(int i, String s)
    {
        if (getClass() == com/a9/vs/mobile/library/impl/jni/EventDelegateBase)
        {
            A9VSMobileJNI.EventDelegateBase_didDecodeTextCanvas(swigCPtr, this, i, s);
            return;
        } else
        {
            A9VSMobileJNI.EventDelegateBase_didDecodeTextCanvasSwigExplicitEventDelegateBase(swigCPtr, this, i, s);
            return;
        }
    }

    public void didDetect(ObjectInfo objectinfo)
    {
        if (getClass() == com/a9/vs/mobile/library/impl/jni/EventDelegateBase)
        {
            A9VSMobileJNI.EventDelegateBase_didDetect(swigCPtr, this, ObjectInfo.getCPtr(objectinfo), objectinfo);
            return;
        } else
        {
            A9VSMobileJNI.EventDelegateBase_didDetectSwigExplicitEventDelegateBase(swigCPtr, this, ObjectInfo.getCPtr(objectinfo), objectinfo);
            return;
        }
    }

    public void didDetectInterestPoints(VectorOfPoint2f vectorofpoint2f)
    {
        if (getClass() == com/a9/vs/mobile/library/impl/jni/EventDelegateBase)
        {
            A9VSMobileJNI.EventDelegateBase_didDetectInterestPoints(swigCPtr, this, VectorOfPoint2f.getCPtr(vectorofpoint2f), vectorofpoint2f);
            return;
        } else
        {
            A9VSMobileJNI.EventDelegateBase_didDetectInterestPointsSwigExplicitEventDelegateBase(swigCPtr, this, VectorOfPoint2f.getCPtr(vectorofpoint2f), vectorofpoint2f);
            return;
        }
    }

    public void didProcessFrame(ObjectID objectid, StatusID statusid, int i, int j)
    {
        if (getClass() == com/a9/vs/mobile/library/impl/jni/EventDelegateBase)
        {
            A9VSMobileJNI.EventDelegateBase_didProcessFrame(swigCPtr, this, objectid.swigValue(), statusid.swigValue(), i, j);
            return;
        } else
        {
            A9VSMobileJNI.EventDelegateBase_didProcessFrameSwigExplicitEventDelegateBase(swigCPtr, this, objectid.swigValue(), statusid.swigValue(), i, j);
            return;
        }
    }

    public void didProcessFrameDecision(CameraStabilityIssue camerastabilityissue, double d)
    {
        if (getClass() == com/a9/vs/mobile/library/impl/jni/EventDelegateBase)
        {
            A9VSMobileJNI.EventDelegateBase_didProcessFrameDecision(swigCPtr, this, camerastabilityissue.swigValue(), d);
            return;
        } else
        {
            A9VSMobileJNI.EventDelegateBase_didProcessFrameDecisionSwigExplicitEventDelegateBase(swigCPtr, this, camerastabilityissue.swigValue(), d);
            return;
        }
    }

    public void didProcessModuleDecision(ObjectID objectid, JudgeVerdictOnModule judgeverdictonmodule)
    {
        if (getClass() == com/a9/vs/mobile/library/impl/jni/EventDelegateBase)
        {
            A9VSMobileJNI.EventDelegateBase_didProcessModuleDecision(swigCPtr, this, objectid.swigValue(), judgeverdictonmodule.swigValue());
            return;
        } else
        {
            A9VSMobileJNI.EventDelegateBase_didProcessModuleDecisionSwigExplicitEventDelegateBase(swigCPtr, this, objectid.swigValue(), judgeverdictonmodule.swigValue());
            return;
        }
    }

    public void didReceieveBadTextCanvasDecode()
    {
        if (getClass() == com/a9/vs/mobile/library/impl/jni/EventDelegateBase)
        {
            A9VSMobileJNI.EventDelegateBase_didReceieveBadTextCanvasDecode(swigCPtr, this);
            return;
        } else
        {
            A9VSMobileJNI.EventDelegateBase_didReceieveBadTextCanvasDecodeSwigExplicitEventDelegateBase(swigCPtr, this);
            return;
        }
    }

    public void didReceiveEvent(ObjectID objectid, ActionID actionid, StatusID statusid)
    {
        if (getClass() == com/a9/vs/mobile/library/impl/jni/EventDelegateBase)
        {
            A9VSMobileJNI.EventDelegateBase_didReceiveEvent(swigCPtr, this, objectid.swigValue(), actionid.swigValue(), statusid.swigValue());
            return;
        } else
        {
            A9VSMobileJNI.EventDelegateBase_didReceiveEventSwigExplicitEventDelegateBase(swigCPtr, this, objectid.swigValue(), actionid.swigValue(), statusid.swigValue());
            return;
        }
    }

    public void didReceiveServerError(ObjectID objectid, ServerFailure serverfailure)
    {
        if (getClass() == com/a9/vs/mobile/library/impl/jni/EventDelegateBase)
        {
            A9VSMobileJNI.EventDelegateBase_didReceiveServerError(swigCPtr, this, objectid.swigValue(), serverfailure.swigValue());
            return;
        } else
        {
            A9VSMobileJNI.EventDelegateBase_didReceiveServerErrorSwigExplicitEventDelegateBase(swigCPtr, this, objectid.swigValue(), serverfailure.swigValue());
            return;
        }
    }

    public void didStopTrackingTextCanvas(TextCanvasInfo textcanvasinfo)
    {
        if (getClass() == com/a9/vs/mobile/library/impl/jni/EventDelegateBase)
        {
            A9VSMobileJNI.EventDelegateBase_didStopTrackingTextCanvas(swigCPtr, this, TextCanvasInfo.getCPtr(textcanvasinfo), textcanvasinfo);
            return;
        } else
        {
            A9VSMobileJNI.EventDelegateBase_didStopTrackingTextCanvasSwigExplicitEventDelegateBase(swigCPtr, this, TextCanvasInfo.getCPtr(textcanvasinfo), textcanvasinfo);
            return;
        }
    }

    public void didTrack(int i, VectorOfPoint2f vectorofpoint2f)
    {
        if (getClass() == com/a9/vs/mobile/library/impl/jni/EventDelegateBase)
        {
            A9VSMobileJNI.EventDelegateBase_didTrack(swigCPtr, this, i, VectorOfPoint2f.getCPtr(vectorofpoint2f), vectorofpoint2f);
            return;
        } else
        {
            A9VSMobileJNI.EventDelegateBase_didTrackSwigExplicitEventDelegateBase(swigCPtr, this, i, VectorOfPoint2f.getCPtr(vectorofpoint2f), vectorofpoint2f);
            return;
        }
    }

    public void didTrackFail(int i)
    {
        if (getClass() == com/a9/vs/mobile/library/impl/jni/EventDelegateBase)
        {
            A9VSMobileJNI.EventDelegateBase_didTrackFail(swigCPtr, this, i);
            return;
        } else
        {
            A9VSMobileJNI.EventDelegateBase_didTrackFailSwigExplicitEventDelegateBase(swigCPtr, this, i);
            return;
        }
    }

    public void didTrackTextCanvas(TextCanvasInfo textcanvasinfo)
    {
        if (getClass() == com/a9/vs/mobile/library/impl/jni/EventDelegateBase)
        {
            A9VSMobileJNI.EventDelegateBase_didTrackTextCanvas(swigCPtr, this, TextCanvasInfo.getCPtr(textcanvasinfo), textcanvasinfo);
            return;
        } else
        {
            A9VSMobileJNI.EventDelegateBase_didTrackTextCanvasSwigExplicitEventDelegateBase(swigCPtr, this, TextCanvasInfo.getCPtr(textcanvasinfo), textcanvasinfo);
            return;
        }
    }

    public void didUpdateTextCanvas(TextCanvasInfo textcanvasinfo)
    {
        if (getClass() == com/a9/vs/mobile/library/impl/jni/EventDelegateBase)
        {
            A9VSMobileJNI.EventDelegateBase_didUpdateTextCanvas(swigCPtr, this, TextCanvasInfo.getCPtr(textcanvasinfo), textcanvasinfo);
            return;
        } else
        {
            A9VSMobileJNI.EventDelegateBase_didUpdateTextCanvasSwigExplicitEventDelegateBase(swigCPtr, this, TextCanvasInfo.getCPtr(textcanvasinfo), textcanvasinfo);
            return;
        }
    }

    public void didVerify(int i)
    {
        if (getClass() == com/a9/vs/mobile/library/impl/jni/EventDelegateBase)
        {
            A9VSMobileJNI.EventDelegateBase_didVerify(swigCPtr, this, i);
            return;
        } else
        {
            A9VSMobileJNI.EventDelegateBase_didVerifySwigExplicitEventDelegateBase(swigCPtr, this, i);
            return;
        }
    }

    protected void finalize()
    {
        delete();
    }

    public void showMessage(String s)
    {
        if (getClass() == com/a9/vs/mobile/library/impl/jni/EventDelegateBase)
        {
            A9VSMobileJNI.EventDelegateBase_showMessage(swigCPtr, this, s);
            return;
        } else
        {
            A9VSMobileJNI.EventDelegateBase_showMessageSwigExplicitEventDelegateBase(swigCPtr, this, s);
            return;
        }
    }

    public void suggestBoringEvent()
    {
        if (getClass() == com/a9/vs/mobile/library/impl/jni/EventDelegateBase)
        {
            A9VSMobileJNI.EventDelegateBase_suggestBoringEvent(swigCPtr, this);
            return;
        } else
        {
            A9VSMobileJNI.EventDelegateBase_suggestBoringEventSwigExplicitEventDelegateBase(swigCPtr, this);
            return;
        }
    }

    public void suggestStuckEvent()
    {
        if (getClass() == com/a9/vs/mobile/library/impl/jni/EventDelegateBase)
        {
            A9VSMobileJNI.EventDelegateBase_suggestStuckEvent(swigCPtr, this);
            return;
        } else
        {
            A9VSMobileJNI.EventDelegateBase_suggestStuckEventSwigExplicitEventDelegateBase(swigCPtr, this);
            return;
        }
    }

    protected void swigDirectorDisconnect()
    {
        swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership()
    {
        swigCMemOwn = false;
        A9VSMobileJNI.EventDelegateBase_change_ownership(this, swigCPtr, false);
    }

    public void swigTakeOwnership()
    {
        swigCMemOwn = true;
        A9VSMobileJNI.EventDelegateBase_change_ownership(this, swigCPtr, true);
    }
}

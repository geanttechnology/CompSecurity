// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flow.android.engine.library.impl;

import com.a9.vs.mobile.library.impl.jni.EventDelegateBase;
import com.a9.vs.mobile.library.impl.jni.ObjectID;
import com.a9.vs.mobile.library.impl.jni.ObjectInfo;
import com.a9.vs.mobile.library.impl.jni.ServerFailure;
import com.a9.vs.mobile.library.impl.jni.StatusID;
import com.a9.vs.mobile.library.impl.jni.TextCanvasInfo;
import com.a9.vs.mobile.library.impl.jni.VectorOfPoint2f;
import com.a9.vs.mobile.library.impl.jni.VectorOfString;
import com.flow.android.engine.library.FlowStateEngineInterface;
import com.flow.android.engine.library.objectinfo.FlowBarcodeObjectInfo;
import com.flow.android.engine.library.objectinfo.FlowDataMatrixObjectInfo;
import com.flow.android.engine.library.objectinfo.FlowImageMatchObjectInfo;
import com.flow.android.engine.library.objectinfo.FlowLogoMatchObjectInfo;
import com.flow.android.engine.library.objectinfo.FlowObjectInfo;
import com.flow.android.engine.library.objectinfo.FlowQrCodeObjectInfo;
import com.flow.android.engine.library.objectinfo.FlowTextCanvasInfo;
import com.flow.android.engine.library.objectinfo.FlowTextObjectInfo;
import java.util.ArrayList;

public class FlowEventCallback extends EventDelegateBase
{

    private FlowStateEngineInterface m_delegate;
    private boolean m_networkErrorMode;

    public FlowEventCallback(FlowStateEngineInterface flowstateengineinterface)
    {
        m_delegate = null;
        m_networkErrorMode = false;
        m_delegate = flowstateengineinterface;
        m_networkErrorMode = false;
    }

    public void didDecode(ObjectInfo objectinfo)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$a9$vs$mobile$library$impl$jni$ObjectID[];
            static final int $SwitchMap$com$a9$vs$mobile$library$impl$jni$ServerFailure[];

            static 
            {
                $SwitchMap$com$a9$vs$mobile$library$impl$jni$ServerFailure = new int[ServerFailure.values().length];
                try
                {
                    $SwitchMap$com$a9$vs$mobile$library$impl$jni$ServerFailure[ServerFailure.NO_NETWORK.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$a9$vs$mobile$library$impl$jni$ServerFailure[ServerFailure.SERVER_ERROR.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$a9$vs$mobile$library$impl$jni$ServerFailure[ServerFailure.UNAUTHORIZED_ACCESS.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$a9$vs$mobile$library$impl$jni$ServerFailure[ServerFailure.UNKNOWN_ERROR.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                $SwitchMap$com$a9$vs$mobile$library$impl$jni$ObjectID = new int[ObjectID.values().length];
                try
                {
                    $SwitchMap$com$a9$vs$mobile$library$impl$jni$ObjectID[ObjectID.IMGMATCHOBJ.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$a9$vs$mobile$library$impl$jni$ObjectID[ObjectID.BARCODE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$a9$vs$mobile$library$impl$jni$ObjectID[ObjectID.TWOD_BARCODE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$a9$vs$mobile$library$impl$jni$ObjectID[ObjectID.TEXT.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$a9$vs$mobile$library$impl$jni$ObjectID[ObjectID.LOGO.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.a9.vs.mobile.library.impl.jni.ObjectID[objectinfo.getObjType().ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            objectinfo = new FlowImageMatchObjectInfo(objectinfo);
            m_delegate.didReceiveImageMatchSuccess(objectinfo);
            return;

        case 2: // '\002'
            objectinfo = new FlowBarcodeObjectInfo(objectinfo);
            m_delegate.didReceiveBarcodeDecodeSuccess(objectinfo);
            return;

        case 3: // '\003'
            if (!objectinfo.getEntityType().equalsIgnoreCase("DATA-MATRIX"))
            {
                objectinfo = new FlowQrCodeObjectInfo(objectinfo);
                m_delegate.didReceiveQRCodeDecodeSuccess(objectinfo);
                return;
            } else
            {
                objectinfo = new FlowDataMatrixObjectInfo(objectinfo);
                m_delegate.didReceiveDataMatrixDecodeSuccess(objectinfo);
                return;
            }

        case 4: // '\004'
            objectinfo = new FlowTextObjectInfo(objectinfo);
            m_delegate.didReceiveTextSuccess(objectinfo);
            return;

        case 5: // '\005'
            objectinfo = new FlowLogoMatchObjectInfo(objectinfo);
            m_delegate.didReceiveLogoResponse(objectinfo);
            return;
        }
    }

    public void didDecodeFreeText(VectorOfString vectorofstring, VectorOfString vectorofstring1, String s)
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; (long)i < vectorofstring.size(); i++)
        {
            arraylist.add(vectorofstring.get(i));
        }

        vectorofstring = new ArrayList();
        for (int j = 0; (long)j < vectorofstring1.size(); j++)
        {
            vectorofstring.add(vectorofstring1.get(j));
        }

        m_delegate.didReceiveFreeText(arraylist, vectorofstring, s);
    }

    public void didDecodeTextCanvas(int i, String s)
    {
        s = new FlowTextCanvasInfo(i, s);
        m_delegate.didDecodeTextCanvas(s);
    }

    public void didDetectInterestPoints(VectorOfPoint2f vectorofpoint2f)
    {
        m_delegate.didReceiveInterestPoints(FlowObjectInfo.getPoints(vectorofpoint2f));
    }

    public void didProcessFrame(ObjectID objectid, StatusID statusid, int i, int j)
    {
        m_delegate.didProcessFrame(objectid, i, j);
    }

    public void didReceieveBadTextCanvasDecode()
    {
        m_delegate.didReceieveBadTextCanvasDecode();
    }

    public void didReceiveServerError(ObjectID objectid, ServerFailure serverfailure)
    {
        switch (_cls1..SwitchMap.com.a9.vs.mobile.library.impl.jni.ServerFailure[serverfailure.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            m_delegate.didReceiveServerFailure(com.flow.android.engine.library.FlowStateEngineInterface.CallbackServerFailure.NO_NETWORK);
            return;

        case 2: // '\002'
            m_delegate.didReceiveServerFailure(com.flow.android.engine.library.FlowStateEngineInterface.CallbackServerFailure.SERVER_ERROR);
            return;

        case 3: // '\003'
            m_delegate.didReceiveServerFailure(com.flow.android.engine.library.FlowStateEngineInterface.CallbackServerFailure.UNAUTHORIZED_ACCESS);
            return;

        case 4: // '\004'
            m_delegate.didReceiveServerFailure(com.flow.android.engine.library.FlowStateEngineInterface.CallbackServerFailure.UNKNOWN);
            break;
        }
    }

    public void didStopTrackingTextCanvas(TextCanvasInfo textcanvasinfo)
    {
        m_delegate.didStopTrackingTextCanvas(new FlowTextCanvasInfo(textcanvasinfo));
    }

    public void didTrack(int i, VectorOfPoint2f vectorofpoint2f)
    {
        vectorofpoint2f = FlowObjectInfo.getPointsAndCentroid(vectorofpoint2f);
        m_delegate.didReceiveTrack(i, ((com.flow.android.engine.library.objectinfo.FlowObjectInfo.PointsAndCentroid) (vectorofpoint2f)).m_points, ((com.flow.android.engine.library.objectinfo.FlowObjectInfo.PointsAndCentroid) (vectorofpoint2f)).m_centroid);
    }

    public void didTrackFail(int i)
    {
        m_delegate.didReceiveTrackFail(i);
    }

    public void didTrackTextCanvas(TextCanvasInfo textcanvasinfo)
    {
        textcanvasinfo = new FlowTextCanvasInfo(textcanvasinfo);
        m_delegate.didTrackTextCanvas(textcanvasinfo);
    }

    public void didUpdateTextCanvas(TextCanvasInfo textcanvasinfo)
    {
        textcanvasinfo = new FlowTextCanvasInfo(textcanvasinfo);
        m_delegate.didUpdateTextCanvas(textcanvasinfo);
    }

    public void setInterface(FlowStateEngineInterface flowstateengineinterface)
    {
        m_delegate = flowstateengineinterface;
    }

    public void setNetworkErrorMode(boolean flag)
    {
        m_networkErrorMode = flag;
    }

    public void showMessage(String s)
    {
        m_delegate.showMessage(s);
    }

    public void suggestBoringEvent()
    {
        m_delegate.didReceieveScannerBoring();
    }

    public void suggestStuckEvent()
    {
        if (!m_networkErrorMode)
        {
            m_delegate.didReceiveScannerStuck();
        }
    }
}

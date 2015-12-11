// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flow.android.engine.library;

import android.graphics.PointF;
import com.a9.vs.mobile.library.impl.jni.ObjectID;
import com.flow.android.engine.library.objectinfo.FlowBarcodeObjectInfo;
import com.flow.android.engine.library.objectinfo.FlowDataMatrixObjectInfo;
import com.flow.android.engine.library.objectinfo.FlowImageMatchObjectInfo;
import com.flow.android.engine.library.objectinfo.FlowLogoMatchObjectInfo;
import com.flow.android.engine.library.objectinfo.FlowQrCodeObjectInfo;
import com.flow.android.engine.library.objectinfo.FlowTextCanvasInfo;
import com.flow.android.engine.library.objectinfo.FlowTextObjectInfo;
import java.util.ArrayList;

public interface FlowStateEngineInterface
{
    public static final class CallbackServerFailure extends Enum
    {

        private static final CallbackServerFailure $VALUES[];
        public static final CallbackServerFailure NO_NETWORK;
        public static final CallbackServerFailure SERVER_ERROR;
        public static final CallbackServerFailure UNAUTHORIZED_ACCESS;
        public static final CallbackServerFailure UNKNOWN;

        public static CallbackServerFailure valueOf(String s)
        {
            return (CallbackServerFailure)Enum.valueOf(com/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure, s);
        }

        public static CallbackServerFailure[] values()
        {
            return (CallbackServerFailure[])$VALUES.clone();
        }

        static 
        {
            NO_NETWORK = new CallbackServerFailure("NO_NETWORK", 0);
            UNAUTHORIZED_ACCESS = new CallbackServerFailure("UNAUTHORIZED_ACCESS", 1);
            SERVER_ERROR = new CallbackServerFailure("SERVER_ERROR", 2);
            UNKNOWN = new CallbackServerFailure("UNKNOWN", 3);
            $VALUES = (new CallbackServerFailure[] {
                NO_NETWORK, UNAUTHORIZED_ACCESS, SERVER_ERROR, UNKNOWN
            });
        }

        private CallbackServerFailure(String s, int i)
        {
            super(s, i);
        }
    }


    public abstract void didDecodeTextCanvas(FlowTextCanvasInfo flowtextcanvasinfo);

    public abstract void didProcessFrame(ObjectID objectid, int i, int j);

    public abstract void didReceieveBadTextCanvasDecode();

    public abstract void didReceieveScannerBoring();

    public abstract void didReceiveBarcodeDecodeSuccess(FlowBarcodeObjectInfo flowbarcodeobjectinfo);

    public abstract void didReceiveDataMatrixDecodeSuccess(FlowDataMatrixObjectInfo flowdatamatrixobjectinfo);

    public abstract void didReceiveFreeText(ArrayList arraylist, ArrayList arraylist1, String s);

    public abstract void didReceiveImageMatchSuccess(FlowImageMatchObjectInfo flowimagematchobjectinfo);

    public abstract void didReceiveInterestPoints(ArrayList arraylist);

    public abstract void didReceiveLogoResponse(FlowLogoMatchObjectInfo flowlogomatchobjectinfo);

    public abstract void didReceiveQRCodeDecodeSuccess(FlowQrCodeObjectInfo flowqrcodeobjectinfo);

    public abstract void didReceiveScannerStuck();

    public abstract void didReceiveServerFailure(CallbackServerFailure callbackserverfailure);

    public abstract void didReceiveTextSuccess(FlowTextObjectInfo flowtextobjectinfo);

    public abstract void didReceiveTrack(int i, ArrayList arraylist, PointF pointf);

    public abstract void didReceiveTrackFail(int i);

    public abstract void didStopTrackingTextCanvas(FlowTextCanvasInfo flowtextcanvasinfo);

    public abstract void didTrackTextCanvas(FlowTextCanvasInfo flowtextcanvasinfo);

    public abstract void didUpdateTextCanvas(FlowTextCanvasInfo flowtextcanvasinfo);

    public abstract void showMessage(String s);
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.a9.cameralibrary.CameraErrorReason;
import com.a9.vs.mobile.library.impl.jni.ObjectID;
import com.amazon.mShop.feature.Features;
import com.amazon.mShop.gno.GNODrawer;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.platform.AndroidPlatform;
import com.amazon.mShop.platform.AppLocale;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.UIUtils;
import com.amazon.mShop.util.Util;
import com.amazon.mShop.util.WebUtils;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.MShopService;
import com.amazon.rio.j2me.client.services.mShop.RecognizeAuthenticityCodeRequest;
import com.amazon.rio.j2me.client.services.mShop.RecognizeAuthenticityCodeResponse;
import com.amazon.rio.j2me.client.services.mShop.RecognizeAuthenticityCodeResponseListener;
import com.flow.android.engine.library.objectinfo.FlowBarcodeObjectInfo;
import com.flow.android.engine.library.objectinfo.FlowDataMatrixObjectInfo;
import com.flow.android.engine.library.objectinfo.FlowImageMatchObjectInfo;
import com.flow.android.engine.library.objectinfo.FlowLogoMatchObjectInfo;
import com.flow.android.engine.library.objectinfo.FlowQrCodeObjectInfo;
import com.flow.android.engine.library.objectinfo.FlowTextCanvasInfo;
import com.flow.android.engine.library.objectinfo.FlowTextObjectInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            FSECameraActivity, ViewItMetricHelper, ViewItPhotoCaptureView, ViewItDialogHelper, 
//            FSEGraphic, BoxGraphic, CameraBgHelper, ViewItUtil, 
//            ViewItSlidingDrawerView, ViewItSlidingDrawerBrowser, ViewItAllMatchedResultsView, NullGraphic, 
//            TrackingDotsGraphic

public class ViewItActivity extends FSECameraActivity
{

    private List mBarcodes;
    private List mDataMatrixCodes;
    private Map mGraphicsMap;
    private List mImageAsins;
    private boolean mIsDrawingDisabled;
    private boolean mIsFreshStart;
    private boolean mIsLoadingDisabled;
    private List mLastScannedOutput;
    private long mLastScannedTimeMillis;
    private ViewItPhotoCaptureView mPhotoCaptureView;
    private ViewItMetricHelper mViewItMetricHelper;
    private boolean privateAuthCodeScanned;
    private boolean publicAuthCodeScanned;

    public ViewItActivity()
    {
        mIsLoadingDisabled = false;
        mIsDrawingDisabled = false;
        mIsFreshStart = true;
        mBarcodes = null;
        mImageAsins = null;
        mDataMatrixCodes = null;
        publicAuthCodeScanned = false;
        privateAuthCodeScanned = false;
        mGraphicsMap = new ConcurrentHashMap();
        mLastScannedTimeMillis = 0L;
    }

    private void clearLastScanned()
    {
        mLastScannedOutput = null;
        mLastScannedTimeMillis = 0L;
    }

    private void clearSceenAndData()
    {
        mBarcodes = null;
        mImageAsins = null;
        mDataMatrixCodes = null;
        if (mGraphicsMap.size() != 0)
        {
            mGraphicsMap.clear();
            com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

                final ViewItActivity this$0;

                public void run()
                {
                    getCameraBgHelper().drawScanningGraphic(null);
                }

            
            {
                this$0 = ViewItActivity.this;
                super();
            }
            });
        }
    }

    private void handleDataMatrixCode(String s)
    {
        RecognizeAuthenticityCodeRequest recognizeauthenticitycoderequest = new RecognizeAuthenticityCodeRequest();
        recognizeauthenticitycoderequest.setCode(s);
        AndroidPlatform.getInstance().getMShopService().recognizeAuthenticityCode(recognizeauthenticitycoderequest, new RecognizeAuthenticityCodeResponseListener() {

            final ViewItActivity this$0;

            public void cancelled(ServiceCall servicecall)
            {
                enableLoading();
            }

            public void completed(RecognizeAuthenticityCodeResponse recognizeauthenticitycoderesponse, ServiceCall servicecall)
            {
                servicecall = recognizeauthenticitycoderesponse.getCodeType();
                if ("public".equalsIgnoreCase(servicecall))
                {
                    UIUtils.vibrate(ViewItActivity.this, 100L);
                    publicAuthCodeScanned = true;
                    mViewItMetricHelper.logCountMetricsPerSession("PublicCodeSession", 1);
                    mPhotoCaptureView.getViewItDialogHelper().clearErrorWindow();
                    showPublicDataMatrixCodeInfoDialog();
                } else
                if ("private".equalsIgnoreCase(servicecall))
                {
                    UIUtils.vibrate(ViewItActivity.this, 100L);
                    privateAuthCodeScanned = true;
                    mViewItMetricHelper.logCountMetricsPerSession("PrivateCodeSession", 1);
                    RefMarkerObserver.logRefMarker("fl_dm_pri_succ");
                    recognizeauthenticitycoderesponse = recognizeauthenticitycoderesponse.getLandingUrl();
                    WebUtils.openWebview(ViewItActivity.this, recognizeauthenticitycoderesponse);
                } else
                {
                    mViewItMetricHelper.logCountMetricsPerSession("UnknownCodeSession", 1);
                }
                mDataMatrixCodes = null;
            }

            public void error(final Exception errorMsg, ServiceCall servicecall)
            {
                enableLoading();
                errorMsg = getResources().getString(com.amazon.mShop.android.lib.R.string.view_it_error_server_return_error);
                servicecall = ViewItDialogHelper.DialogType.ERROR_FLOW_SERVER;
                com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(servicecall. new Runnable() {

                    final _cls6 this$1;
                    final ViewItDialogHelper.DialogType val$errorDialogType;
                    final String val$errorMsg;

                    public void run()
                    {
                        mPhotoCaptureView.getViewItDialogHelper().showDialog(null, errorMsg, errorDialogType);
                    }

            
            {
                this$1 = final__pcls6;
                errorMsg = s;
                errorDialogType = ViewItDialogHelper.DialogType.this;
                super();
            }
                });
            }

            
            {
                this$0 = ViewItActivity.this;
                super();
            }
        });
    }

    private boolean isDataMatrixCodeEnabled()
    {
        String s;
        String as[];
        s = AppLocale.getInstance().getCurrentLocaleName();
        as = getResources().getStringArray(com.amazon.mShop.android.lib.R.array.config_datamatrixSupportedLocaleIds);
        if (!Util.isEmpty(as) && !Util.isEmpty(s)) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int i;
        boolean flag1;
        flag1 = false;
        i = 0;
_L4:
        boolean flag;
        flag = flag1;
        if (i >= as.length)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!s.equals(as[i]))
        {
            break MISSING_BLOCK_LABEL_80;
        }
        flag = true;
        if (!flag || !Features.getInstance().isFeatureActivated("Android_DataMatrix")) goto _L1; else goto _L3
_L3:
        return true;
        i++;
          goto _L4
    }

    private void reportAuthScanMetrics()
    {
        if (!publicAuthCodeScanned || !privateAuthCodeScanned) goto _L2; else goto _L1
_L1:
        mViewItMetricHelper.logCountMetricsPerSession("SessionsWithPublicPrivateCodes", 1);
_L4:
        publicAuthCodeScanned = false;
        privateAuthCodeScanned = false;
        return;
_L2:
        if (publicAuthCodeScanned)
        {
            mViewItMetricHelper.logCountMetricsPerSession("SessionsWithPublicOnlyCodes", 1);
        } else
        if (privateAuthCodeScanned)
        {
            mViewItMetricHelper.logCountMetricsPerSession("SessionsWithPrivateOnlyCodes", 1);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void showLoadingWindow(List list, ResultWrapper.ResultType resulttype)
    {
        mPhotoCaptureView.getViewItDialogHelper().clearErrorWindow();
        mPhotoCaptureView.showLoadingWindow(list, resulttype);
        UIUtils.vibrate(this, 100L);
        mBarcodes = null;
        mImageAsins = null;
        mDataMatrixCodes = null;
    }

    private void showNoObjectFoundErrorDialog()
    {
        if (mPhotoCaptureView != null && !mIsBarcodeScanOnly)
        {
            com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

                final ViewItActivity this$0;

                public void run()
                {
                    mPhotoCaptureView.getViewItDialogHelper().showDialog(null, null, ViewItDialogHelper.DialogType.ERROR_NO_OBJECT_FOUND);
                }

            
            {
                this$0 = ViewItActivity.this;
                super();
            }
            });
        }
    }

    private void showPublicDataMatrixCodeInfoDialog()
    {
        if (mPhotoCaptureView != null && !mIsBarcodeScanOnly)
        {
            com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

                final ViewItActivity this$0;

                public void run()
                {
                    mPhotoCaptureView.getViewItDialogHelper().showDialog(null, null, ViewItDialogHelper.DialogType.PUBLIC_DATA_MATRIX_INFO);
                }

            
            {
                this$0 = ViewItActivity.this;
                super();
            }
            });
        }
    }

    private void upateCheckBoxGraphic(PointF pointf)
    {
        if (mGraphicsMap.containsKey(Integer.valueOf(1)))
        {
            ((FSEGraphic)mGraphicsMap.get(Integer.valueOf(1))).setCenterPoint(pointf);
        } else
        if (!mIsLoadingDisabled)
        {
            mGraphicsMap.put(Integer.valueOf(1), new BoxGraphic(this, null, pointf));
            com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

                final ViewItActivity this$0;

                public void run()
                {
                    if (mGraphicsMap.containsKey(Integer.valueOf(1)))
                    {
                        mGraphicsMap.put(Integer.valueOf(1), new NullGraphic());
                    }
                }

            
            {
                this$0 = ViewItActivity.this;
                super();
            }
            }, 700L);
            return;
        }
    }

    private void updateCameraScreen()
    {
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = mGraphicsMap.values().iterator(); iterator.hasNext(); arraylist.add((FSEGraphic)iterator.next())) { }
        getCameraBgHelper().drawScanningGraphic(arraylist);
    }

    private void updateLoadingStatus(List list)
    {
        long l = System.currentTimeMillis();
        boolean flag;
        if (l - mLastScannedTimeMillis > 8000L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag || !ViewItUtil.isSimilarObject(mLastScannedOutput, list))
        {
            mLastScannedOutput = list;
            mLastScannedTimeMillis = l;
            enableLoading();
        }
    }

    public void didDecodeTextCanvas(FlowTextCanvasInfo flowtextcanvasinfo)
    {
    }

    public void didProcessFrame(ObjectID objectid, int i, int j)
    {
    }

    public void didReceieveBadTextCanvasDecode()
    {
    }

    public void didReceieveScannerBoring()
    {
        if (mIsDrawingDisabled)
        {
            return;
        } else
        {
            showNoObjectFoundErrorDialog();
            return;
        }
    }

    public void didReceiveBarcodeDecodeSuccess(final FlowBarcodeObjectInfo barcodeFormat)
    {
        if (mIsDrawingDisabled)
        {
            clearSceenAndData();
        } else
        {
            final String barcode;
            if (barcodeFormat == null)
            {
                barcode = null;
            } else
            {
                barcode = barcodeFormat.getBarcode();
            }
            if (barcodeFormat == null)
            {
                barcodeFormat = null;
            } else
            {
                barcodeFormat = barcodeFormat.getBarcodeType();
            }
            if (mIsBarcodeScanOnly)
            {
                com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

                    final ViewItActivity this$0;
                    final String val$barcode;
                    final String val$barcodeFormat;

                    public void run()
                    {
                        Intent intent = new Intent();
                        if (!Util.isEmpty(barcode))
                        {
                            intent.putExtra("BARCODE_STRING", barcode);
                            intent.putExtra("BARCODE_FORMAT", barcodeFormat);
                            setResult(-1, intent);
                        } else
                        {
                            setResult(-1, intent);
                        }
                        finish();
                        UIUtils.vibrate(ViewItActivity.this, 100L);
                    }

            
            {
                this$0 = ViewItActivity.this;
                barcode = s;
                barcodeFormat = s1;
                super();
            }
                });
                return;
            }
            if (!Util.isEmpty(barcode))
            {
                mBarcodes = new ArrayList();
                mBarcodes.add(barcode);
                mImageAsins = null;
                mDataMatrixCodes = null;
                return;
            }
        }
    }

    public void didReceiveDataMatrixDecodeSuccess(FlowDataMatrixObjectInfo flowdatamatrixobjectinfo)
    {
        if (mIsDrawingDisabled)
        {
            clearSceenAndData();
        } else
        {
            if (flowdatamatrixobjectinfo == null)
            {
                flowdatamatrixobjectinfo = null;
            } else
            {
                flowdatamatrixobjectinfo = flowdatamatrixobjectinfo.getDataMatrixCode();
            }
            if (!Util.isEmpty(flowdatamatrixobjectinfo))
            {
                mDataMatrixCodes = new ArrayList();
                mDataMatrixCodes.add(flowdatamatrixobjectinfo);
                mBarcodes = null;
                mImageAsins = null;
                return;
            }
        }
    }

    public void didReceiveFreeText(ArrayList arraylist, ArrayList arraylist1, String s)
    {
    }

    public void didReceiveImageMatchSuccess(FlowImageMatchObjectInfo flowimagematchobjectinfo)
    {
        if (mIsDrawingDisabled)
        {
            clearSceenAndData();
        } else
        {
            if (flowimagematchobjectinfo == null)
            {
                flowimagematchobjectinfo = null;
            } else
            {
                flowimagematchobjectinfo = flowimagematchobjectinfo.getAsins();
            }
            if (!Util.isEmpty(flowimagematchobjectinfo))
            {
                mImageAsins = flowimagematchobjectinfo;
                mBarcodes = null;
                mDataMatrixCodes = null;
                return;
            }
        }
    }

    public void didReceiveInterestPoints(final ArrayList points)
    {
        if (mIsDrawingDisabled)
        {
            clearSceenAndData();
        } else
        if (!mIsBarcodeScanOnly)
        {
            com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

                final ViewItActivity this$0;
                final ArrayList val$points;

                public void run()
                {
                    mGraphicsMap.put(Integer.valueOf(2), new TrackingDotsGraphic(ViewItActivity.this, points));
                    updateCameraScreen();
                }

            
            {
                this$0 = ViewItActivity.this;
                points = arraylist;
                super();
            }
            });
            return;
        }
    }

    public void didReceiveLogoResponse(FlowLogoMatchObjectInfo flowlogomatchobjectinfo)
    {
    }

    public void didReceiveQRCodeDecodeSuccess(FlowQrCodeObjectInfo flowqrcodeobjectinfo)
    {
    }

    public void didReceiveScannerStuck()
    {
        if (mIsDrawingDisabled)
        {
            return;
        } else
        {
            showNoObjectFoundErrorDialog();
            return;
        }
    }

    public void didReceiveServerFailure(final com.flow.android.engine.library.FlowStateEngineInterface.CallbackServerFailure errorDialogType)
    {
        if (!mIsDrawingDisabled) goto _L2; else goto _L1
_L1:
        clearSceenAndData();
_L4:
        return;
_L2:
        if (mPhotoCaptureView == null || mIsBarcodeScanOnly) goto _L4; else goto _L3
_L3:
        static class _cls10
        {

            static final int $SwitchMap$com$flow$android$engine$library$FlowStateEngineInterface$CallbackServerFailure[];

            static 
            {
                $SwitchMap$com$flow$android$engine$library$FlowStateEngineInterface$CallbackServerFailure = new int[com.flow.android.engine.library.FlowStateEngineInterface.CallbackServerFailure.values().length];
                try
                {
                    $SwitchMap$com$flow$android$engine$library$FlowStateEngineInterface$CallbackServerFailure[com.flow.android.engine.library.FlowStateEngineInterface.CallbackServerFailure.NO_NETWORK.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$flow$android$engine$library$FlowStateEngineInterface$CallbackServerFailure[com.flow.android.engine.library.FlowStateEngineInterface.CallbackServerFailure.UNAUTHORIZED_ACCESS.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$flow$android$engine$library$FlowStateEngineInterface$CallbackServerFailure[com.flow.android.engine.library.FlowStateEngineInterface.CallbackServerFailure.SERVER_ERROR.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$flow$android$engine$library$FlowStateEngineInterface$CallbackServerFailure[com.flow.android.engine.library.FlowStateEngineInterface.CallbackServerFailure.UNKNOWN.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls10..SwitchMap.com.flow.android.engine.library.FlowStateEngineInterface.CallbackServerFailure[errorDialogType.ordinal()];
        JVM INSTR tableswitch 1 3: default 60
    //                   1 94
    //                   2 112
    //                   3 130;
           goto _L5 _L6 _L7 _L8
_L5:
        final String errorMsg;
        errorMsg = getResources().getString(com.amazon.mShop.android.lib.R.string.view_it_error_unknown);
        errorDialogType = ViewItDialogHelper.DialogType.ERROR_UNKNOWN;
_L10:
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final ViewItActivity this$0;
            final ViewItDialogHelper.DialogType val$errorDialogType;
            final String val$errorMsg;

            public void run()
            {
                mPhotoCaptureView.getViewItDialogHelper().showDialog(null, errorMsg, errorDialogType);
            }

            
            {
                this$0 = ViewItActivity.this;
                errorMsg = s;
                errorDialogType = dialogtype;
                super();
            }
        });
        return;
_L6:
        errorMsg = getResources().getString(com.amazon.mShop.android.lib.R.string.view_it_error_network_error);
        errorDialogType = ViewItDialogHelper.DialogType.ERROR_NETWORK;
        continue; /* Loop/switch isn't completed */
_L7:
        errorMsg = getResources().getString(com.amazon.mShop.android.lib.R.string.view_it_error_authorize_fail);
        errorDialogType = ViewItDialogHelper.DialogType.ERROR_UNAUTHORIZED;
        continue; /* Loop/switch isn't completed */
_L8:
        errorMsg = getResources().getString(com.amazon.mShop.android.lib.R.string.view_it_error_server_return_error);
        errorDialogType = ViewItDialogHelper.DialogType.ERROR_FLOW_SERVER;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public void didReceiveTextSuccess(FlowTextObjectInfo flowtextobjectinfo)
    {
    }

    public void didReceiveTrack(int i, ArrayList arraylist, PointF pointf)
    {
        mViewItMetricHelper.finishFlowTimeToSuccessObserver();
        if (!mIsDrawingDisabled) goto _L2; else goto _L1
_L1:
        clearSceenAndData();
_L4:
        return;
_L2:
        if (Util.isEmpty(mBarcodes))
        {
            break; /* Loop/switch isn't completed */
        }
        updateLoadingStatus(mBarcodes);
_L5:
        if (!mIsLoadingDisabled)
        {
            upateCheckBoxGraphic(pointf);
            disableLoading();
            if (!Util.isEmpty(mDataMatrixCodes) && !mIsBarcodeScanOnly && mPhotoCaptureView != null)
            {
                handleDataMatrixCode((String)mDataMatrixCodes.get(0));
                return;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (!Util.isEmpty(mImageAsins))
        {
            updateLoadingStatus(mImageAsins);
        } else
        if (!Util.isEmpty(mDataMatrixCodes))
        {
            updateLoadingStatus(mDataMatrixCodes);
        }
          goto _L5
        if (Util.isEmpty(mBarcodes) && Util.isEmpty(mImageAsins) || mIsBarcodeScanOnly || mPhotoCaptureView == null) goto _L4; else goto _L6
_L6:
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final ViewItActivity this$0;

            public void run()
            {
                mViewItMetricHelper.logCountMetricsPerSession("successes-per-session", 1);
                if (!Util.isEmpty(mBarcodes))
                {
                    showLoadingWindow(mBarcodes, ResultWrapper.ResultType.BARCODE);
                } else
                if (!Util.isEmpty(mImageAsins))
                {
                    showLoadingWindow(mImageAsins, ResultWrapper.ResultType.IMAGE);
                    return;
                }
            }

            
            {
                this$0 = ViewItActivity.this;
                super();
            }
        });
        return;
    }

    public void didReceiveTrackFail(int i)
    {
        mViewItMetricHelper.startFlowTimeToSuccessObserver();
        if (mIsDrawingDisabled)
        {
            clearSceenAndData();
            return;
        } else
        {
            mGraphicsMap.remove(Integer.valueOf(1));
            return;
        }
    }

    public void didStopTrackingTextCanvas(FlowTextCanvasInfo flowtextcanvasinfo)
    {
    }

    public void didTrackTextCanvas(FlowTextCanvasInfo flowtextcanvasinfo)
    {
    }

    public void didUpdateTextCanvas(FlowTextCanvasInfo flowtextcanvasinfo)
    {
    }

    public void disableDrawing()
    {
        mIsDrawingDisabled = true;
    }

    public void disableLoading()
    {
        mIsLoadingDisabled = true;
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        if (27 != keyevent.getKeyCode() && 80 != keyevent.getKeyCode()) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (84 != keyevent.getKeyCode() && 82 != keyevent.getKeyCode()) goto _L4; else goto _L3
_L3:
        if (!mPhotoCaptureView.getViewItSlidingDrawerView().isOpened()) goto _L1; else goto _L5
_L5:
        return super.dispatchKeyEvent(keyevent);
_L4:
        if (4 == keyevent.getKeyCode() && keyevent.getAction() == 0 && (getCurrentView() instanceof ViewItPhotoCaptureView) && mPhotoCaptureView.getViewItSlidingDrawerView().isOpened() && !getGNODrawer().isVisible())
        {
            mPhotoCaptureView.getViewItSlidingDrawerView().animateClose();
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public void enableDrawing()
    {
        mIsDrawingDisabled = false;
    }

    public void enableLoading()
    {
        mIsLoadingDisabled = false;
    }

    protected FrameLayout getCameraFrameLayout()
    {
        if (mPhotoCaptureView != null)
        {
            return mPhotoCaptureView.getCameraFrameLayout();
        } else
        {
            return null;
        }
    }

    protected FSECameraActivity.FSECredentials getCredentials()
    {
        return new FSECameraActivity.FSECredentials(this, "amzn-mbl-cscan-us", "5b6874d3a20417591bd5464a25a37bc6", "amzn-mbl-cscan-us");
    }

    protected Set getModuleSet()
    {
        HashSet hashset = new HashSet();
        hashset.add(com.flow.android.engine.library.FlowStateEngine.FlowObjectModule.BARCODE);
        if (!mIsBarcodeScanOnly)
        {
            hashset.add(com.flow.android.engine.library.FlowStateEngine.FlowObjectModule.IMAGEMATCH);
            if (isDataMatrixCodeEnabled())
            {
                hashset.add(com.flow.android.engine.library.FlowStateEngine.FlowObjectModule.QRCODE);
            }
        }
        return hashset;
    }

    public ViewItPhotoCaptureView getPhotoCaptureView()
    {
        return mPhotoCaptureView;
    }

    public ViewItMetricHelper getViewItMetricHelper()
    {
        return mViewItMetricHelper;
    }

    protected void handleCameraError(CameraErrorReason cameraerrorreason, String s)
    {
        cameraerrorreason = Toast.makeText(this, com.amazon.mShop.android.lib.R.string.search_error_message_cannot_open_camera, 1);
        cameraerrorreason.setGravity(17, 0, 0);
        cameraerrorreason.show();
        setResult(0, (new Intent()).putExtra("CANNOT_OPEN_CAMERA", true));
    }

    protected void handleEngineError()
    {
        handleCameraError(CameraErrorReason.UNKNOWN_ERROR, "");
    }

    protected void initLayout()
    {
        mPhotoCaptureView = (ViewItPhotoCaptureView)LayoutInflater.from(this).inflate(com.amazon.mShop.android.lib.R.layout.view_it_photo_capture_view, null);
        setRootView(mPhotoCaptureView, true, false);
        setActionBarAndSeparatorDecoratorVisibility(8);
    }

    public void lockGNODrawer()
    {
        GNODrawer gnodrawer = getGNODrawer();
        if (gnodrawer != null)
        {
            gnodrawer.lock();
        }
    }

    public void onCreate(Bundle bundle)
    {
        mViewItMetricHelper = new ViewItMetricHelper(this);
        mIsFreshStart = true;
        super.onCreate(bundle);
    }

    protected void onDestroy()
    {
        super.onDestroy();
        mPhotoCaptureView.getViewItSlidingDrawerView().getBrowser().clear();
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        mIsFreshStart = true;
        mPhotoCaptureView.getViewItSlidingDrawerView().getBrowser().clear();
    }

    protected void onPause()
    {
        super.onPause();
        stopScanning();
        sendEngineMetrics();
    }

    protected void onResume()
    {
        super.onResume();
        clearLastScanned();
        if (mIsBarcodeScanOnly)
        {
            startScanning();
            mPhotoCaptureView.getWindowOverCamera().setVisibility(8);
        } else
        {
            View view = getCurrentView();
            if (view != null && (view instanceof ViewItPhotoCaptureView))
            {
                if (mIsFreshStart)
                {
                    startScanning();
                    if (mPhotoCaptureView.getViewItSlidingDrawerView().isOpened())
                    {
                        mPhotoCaptureView.getViewItSlidingDrawerView().close();
                    }
                    mPhotoCaptureView.getViewItSlidingDrawerView().refresh();
                    mIsFreshStart = false;
                    return;
                }
                if (!mPhotoCaptureView.getViewItSlidingDrawerView().isOpened())
                {
                    startScanning();
                    return;
                }
            }
        }
    }

    public boolean onSearchRequested()
    {
        return false;
    }

    protected void onStop()
    {
        super.onStop();
        if (!isEngineStopped())
        {
            stopScanning();
            sendEngineMetrics();
        }
        reportAuthScanMetrics();
        mViewItMetricHelper.postCountMetricsPerSession();
    }

    public void pauseEngine()
    {
        super.pauseEngine();
        unLockGNODrawer();
        mPhotoCaptureView.getViewItDialogHelper().clearErrorWindow();
        mPhotoCaptureView.getViewItDialogHelper().sendStopScanningMessageDelayed();
    }

    public boolean popView(boolean flag)
    {
        View view = getCurrentView();
        flag = super.popView(flag);
        View view1 = getCurrentView();
        if (view != null && view1 != null && (view1 instanceof ViewItPhotoCaptureView))
        {
            ViewItSlidingDrawerView viewitslidingdrawerview = mPhotoCaptureView.getViewItSlidingDrawerView();
            ViewItSlidingDrawerBrowser viewitslidingdrawerbrowser = mPhotoCaptureView.getViewItSlidingDrawerBrowser();
            viewitslidingdrawerbrowser.deleteUndoObject();
            if (viewitslidingdrawerbrowser.getObjectsCount() == 0)
            {
                viewitslidingdrawerview.updateBottomToolBar();
                viewitslidingdrawerview.setListViewHeaderVisibility(0);
                viewitslidingdrawerview.updateBottomOffset(getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.view_it_vertical_bottom_empty_offset));
            }
            if (!viewitslidingdrawerview.isOpened())
            {
                if (isEngineStopped())
                {
                    startScanning();
                } else
                if (isEnginePaused())
                {
                    unpauseEngine();
                    return flag;
                }
            }
        }
        return flag;
    }

    public void pushView(View view)
    {
        super.pushView(view);
        if ((view instanceof ViewItAllMatchedResultsView) && !isEnginePaused())
        {
            pauseEngine();
        }
    }

    public void showMessage(String s)
    {
    }

    public void startScanning()
    {
        start();
        enableLoading();
        enableDrawing();
        mGraphicsMap.clear();
        lockGNODrawer();
        if (!mIsBarcodeScanOnly)
        {
            mViewItMetricHelper.startFlowSessionDurationObserver();
            mViewItMetricHelper.startFlowTimeToSuccessObserver();
            RefMarkerObserver.logRefMarker("fl_session");
        }
    }

    public void stopScanning()
    {
        stop();
        disableLoading();
        disableDrawing();
        mGraphicsMap.clear();
        unLockGNODrawer();
        mPhotoCaptureView.getViewItDialogHelper().clearErrorWindow();
        mViewItMetricHelper.finishFlowSessionDurationObserver();
        mViewItMetricHelper.cancelFlowTimeToSuccessObserver();
    }

    public void unLockGNODrawer()
    {
        GNODrawer gnodrawer = getGNODrawer();
        if (gnodrawer != null)
        {
            gnodrawer.unlock();
        }
    }

    public void unpauseEngine()
    {
        super.unpauseEngine();
        lockGNODrawer();
        mPhotoCaptureView.getViewItDialogHelper().canclePendingStopScanningMessage();
    }








/*
    static boolean access$502(ViewItActivity viewitactivity, boolean flag)
    {
        viewitactivity.publicAuthCodeScanned = flag;
        return flag;
    }

*/



/*
    static boolean access$702(ViewItActivity viewitactivity, boolean flag)
    {
        viewitactivity.privateAuthCodeScanned = flag;
        return flag;
    }

*/


/*
    static List access$802(ViewItActivity viewitactivity, List list)
    {
        viewitactivity.mDataMatrixCodes = list;
        return list;
    }

*/

}

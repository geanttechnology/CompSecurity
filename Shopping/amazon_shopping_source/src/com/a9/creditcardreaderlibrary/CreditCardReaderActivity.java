// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.creditcardreaderlibrary;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.a9.cameralibrary.A9CameraPreview;
import com.a9.cameralibrary.A9CameraUtils;
import com.a9.cameralibrary.CameraBgHelper;
import com.a9.cameralibrary.CameraErrorReason;
import com.a9.cameralibrary.CameraFrameListener;
import com.a9.cameralibrary.CameraOpenMode;
import com.a9.cameralibrary.NewCameraPreview;
import com.a9.creditcardreaderlibrary.helpers.MetricsHelper;
import com.a9.creditcardreaderlibrary.metrics.MManager;
import com.a9.creditcardreaderlibrary.utils.PreferenceUtil;
import com.a9.vs.mobile.library.impl.jni.CameraMode;
import com.a9.vs.mobile.library.impl.jni.CardRegion;
import com.a9.vs.mobile.library.impl.jni.CreditCardInfo;
import com.a9.vs.mobile.library.impl.jni.CreditCardProcessProperty;
import com.a9.vs.mobile.library.impl.jni.CreditCardReaderFacade;
import com.a9.vs.mobile.library.impl.jni.MapOfStringToDouble;
import com.a9.vs.mobile.library.impl.jni.MapOfStringToUInt;
import com.a9.vs.mobile.library.impl.jni.Orientation;
import com.a9.vs.mobile.library.impl.jni.ScanMode;
import com.a9.vs.mobile.library.impl.jni.VectorOfString;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// Referenced classes of package com.a9.creditcardreaderlibrary:
//            CreditCardDelegate, CreditCardResult

public abstract class CreditCardReaderActivity extends Activity
    implements CameraFrameListener, NewCameraPreview
{

    private static boolean s_libraryLoaded;
    private Point m_bottomLeft;
    private Point m_bottomRight;
    private CameraBgHelper m_cameraBgHelper;
    private CameraOpenMode m_cameraOpenMode;
    private A9CameraPreview m_cameraPreview;
    private CreditCardReaderFacade m_creditCardReader;
    private CreditCardDelegate m_delegate;
    private boolean m_haveCollectedCreditCardRegion;
    private boolean m_isEnginePaused;
    private int m_maxHeight;
    private int m_minHeight;
    private CreditCardProcessProperty m_processProperty;
    private Point m_topLeft;
    private Point m_topRight;

    public CreditCardReaderActivity()
    {
        m_isEnginePaused = false;
        m_minHeight = 320;
        m_maxHeight = 768;
        m_haveCollectedCreditCardRegion = false;
    }

    private CameraMode getCameraMode()
    {
        if (m_cameraOpenMode == CameraOpenMode.FIRST_BACK_FACING)
        {
            return CameraMode.REAR_FACING;
        } else
        {
            return CameraMode.FRONT_FACING;
        }
    }

    private void initCreditCardReader()
    {
        Object obj = getCameraMode();
        m_processProperty = new CreditCardProcessProperty();
        m_processProperty.setOrient(getCreditCardOrientation());
        m_processProperty.setCameraMode(((CameraMode) (obj)));
        m_processProperty.setScanMode(ScanMode.SINGLE_SCAN);
        m_processProperty.setMultiThread(true);
        if (obj == CameraMode.FRONT_FACING)
        {
            m_processProperty.setReadDate(false);
        } else
        {
            m_processProperty.setReadDate(true);
        }
        m_processProperty.setAutoFlip(false);
        m_creditCardReader = new CreditCardReaderFacade(m_processProperty);
        m_delegate = new CreditCardDelegate(new CreditCardDelegate.CreditCardCallbackInterface() {

            final CreditCardReaderActivity this$0;

            public void onDetectedCardLines(int i)
            {
                ArrayList arraylist = new ArrayList();
                if ((i & 1) > 0)
                {
                    arraylist.add(new Pair(m_topLeft, m_topRight));
                }
                if ((i & 2) > 0)
                {
                    arraylist.add(new Pair(m_bottomLeft, m_topLeft));
                }
                if ((i & 4) > 0)
                {
                    arraylist.add(new Pair(m_bottomRight, m_bottomLeft));
                }
                if ((i & 8) > 0)
                {
                    arraylist.add(new Pair(m_topRight, m_bottomRight));
                }
                didDetectGoodEdges(arraylist);
            }

            public void onPromisingCardDetection()
            {
                didPromisingCardRecognition();
            }

            public void onRecognizedCreditCard(CreditCardInfo creditcardinfo)
            {
                setCreditCardRecognitionMetrics();
                didRecognizeCreditCard(new CreditCardResult(creditcardinfo));
            }

            public void onStabilizedCardDetection()
            {
                didStableCardRecognition();
            }

            
            {
                this$0 = CreditCardReaderActivity.this;
                super();
            }
        });
        m_creditCardReader.setDelegate(m_delegate);
        obj = getDir("creditCard", 0);
        if (!((File) (obj)).exists())
        {
            if (((File) (obj)).mkdirs());
        }
        obj = writeResourceToStorage(R.raw.digit_model, ((File) (obj)), "digit_model");
        m_creditCardReader.loadDigitModel(((String) (obj)));
    }

    private void initMetricsManager()
    {
        String s;
label0:
        {
            String s1 = PreferenceUtil.getPreference(this, "device_id");
            if (s1 != null)
            {
                s = s1;
                if (s1.length() != 0)
                {
                    break label0;
                }
            }
            s = UUID.randomUUID().toString();
            PreferenceUtil.savePreference(this, "device_id", s);
        }
        String s2;
label1:
        {
            String s3 = MetricsHelper.getServiceName(this);
            if (s3 != null)
            {
                s2 = s3;
                if (s3.length() != 0)
                {
                    break label1;
                }
            }
            s2 = getString(getApplicationInfo().labelRes);
        }
        MManager.init(this, s, s2, getMarketPlace());
    }

    private void setCreditCardRecognitionMetrics()
    {
        MapOfStringToUInt mapofstringtouint = new MapOfStringToUInt();
        MapOfStringToDouble mapofstringtodouble = new MapOfStringToDouble();
        m_creditCardReader.generateReportAndClear(mapofstringtouint, mapofstringtodouble);
        VectorOfString vectorofstring1 = MapOfStringToUInt.getKeysForIntMap(mapofstringtouint);
        VectorOfString vectorofstring = MapOfStringToDouble.getKeysForDoubleMap(mapofstringtodouble);
        for (int i = 0; (long)i < vectorofstring1.size(); i++)
        {
            String s1 = vectorofstring1.get(i);
            MManager.setCounterMetric(s1, (int)mapofstringtouint.get(s1));
        }

        for (int j = 0; (long)j < vectorofstring.size(); j++)
        {
            String s = vectorofstring.get(j);
            MManager.setTimingMetric(s, mapofstringtodouble.get(s));
        }

    }

    private String writeResourceToStorage(int i, File file, String s)
    {
        InputStream inputstream;
        byte abyte0[];
        inputstream = getResources().openRawResource(i);
        file = new File(file, s);
        s = new FileOutputStream(file);
        abyte0 = new byte[4096];
_L1:
        i = inputstream.read(abyte0);
label0:
        {
            if (i == -1)
            {
                break label0;
            }
            try
            {
                s.write(abyte0, 0, i);
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                throw new UnsatisfiedLinkError("Couldn't write the output file for C++");
            }
        }
          goto _L1
        inputstream.close();
        s.close();
        file = file.getAbsolutePath();
        return file;
    }

    public void cameraError(CameraErrorReason cameraerrorreason, String s)
    {
        handleCameraError(cameraerrorreason, s);
    }

    protected abstract void didDetectGoodEdges(List list);

    protected abstract void didPromisingCardRecognition();

    public void didReceiveFrame(byte abyte0[], int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1, long l2)
    {
        if (!m_haveCollectedCreditCardRegion)
        {
            m_haveCollectedCreditCardRegion = true;
            Object obj = new CardRegion();
            m_creditCardReader.setOrientation(getCreditCardOrientation());
            m_creditCardReader.getOptimalSize(k1, l1, ((CardRegion) (obj)));
            m_topLeft = new Point(((CardRegion) (obj)).getLeft(), ((CardRegion) (obj)).getTop());
            m_topRight = new Point(((CardRegion) (obj)).getRight(), ((CardRegion) (obj)).getTop());
            m_bottomLeft = new Point(((CardRegion) (obj)).getLeft(), ((CardRegion) (obj)).getBottom());
            m_bottomRight = new Point(((CardRegion) (obj)).getRight(), ((CardRegion) (obj)).getBottom());
            obj = new ArrayList(4);
            ((List) (obj)).add(m_topLeft);
            ((List) (obj)).add(m_topRight);
            ((List) (obj)).add(m_bottomLeft);
            ((List) (obj)).add(m_bottomRight);
            initCardDetectionRegion(((List) (obj)));
        }
        m_creditCardReader.process(abyte0, i, j, i1, j1, k1, l1);
    }

    protected abstract void didRecognizeCreditCard(CreditCardResult creditcardresult);

    protected abstract void didStableCardRecognition();

    protected final A9CameraPreview getCameraPreview()
    {
        return m_cameraPreview;
    }

    protected abstract int getCameraViewHeight();

    protected abstract int getCameraViewWidth();

    protected Orientation getCreditCardOrientation()
    {
        return Orientation.PORTRAIT;
    }

    protected ViewGroup getMainLayout()
    {
        return (ViewGroup)getWindow().getDecorView();
    }

    protected abstract String getMarketPlace();

    protected int getScreenOrientation()
    {
        return 1;
    }

    protected abstract void handleCameraError(CameraErrorReason cameraerrorreason, String s);

    protected void handleClickOnCameraPreview()
    {
        if (m_cameraPreview != null)
        {
            m_cameraPreview.callFocus();
        }
    }

    protected void handleTorchOff()
    {
        if (m_cameraPreview != null)
        {
            m_cameraPreview.torchOff();
        }
    }

    protected void handleTorchOn()
    {
        if (m_cameraPreview != null && supportsFlash())
        {
            m_cameraPreview.torchOn();
        }
    }

    protected void initCamera()
    {
        FrameLayout framelayout;
        ViewGroup viewgroup = getMainLayout();
        framelayout = new FrameLayout(this);
        framelayout.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
        viewgroup.addView(framelayout, 0);
        m_cameraBgHelper = new CameraBgHelper(this, this, framelayout);
        if (!A9CameraUtils.hasBackFacingCamera()) goto _L2; else goto _L1
_L1:
        m_cameraOpenMode = CameraOpenMode.FIRST_BACK_FACING;
_L4:
        framelayout.setOnClickListener(new android.view.View.OnClickListener() {

            final CreditCardReaderActivity this$0;

            public void onClick(View view)
            {
                handleClickOnCameraPreview();
            }

            
            {
                this$0 = CreditCardReaderActivity.this;
                super();
            }
        });
        return;
_L2:
        if (A9CameraUtils.hasFrontFacingCamera())
        {
            m_cameraOpenMode = CameraOpenMode.FIRST_FRONT_FACING;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected abstract void initCardDetectionRegion(List list);

    protected abstract void initLayout();

    protected void initScreen()
    {
        setRequestedOrientation(getScreenOrientation());
        Window window = getWindow();
        window.addFlags(128);
        window.addFlags(1024);
        window.addFlags(512);
        window.requestFeature(1);
    }

    public A9CameraPreview newCameraPreview()
    {
        m_cameraPreview = new A9CameraPreview(this, this);
        return m_cameraPreview;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        initScreen();
        initLayout();
        initCamera();
        initCreditCardReader();
        initMetricsManager();
    }

    protected void onPause()
    {
        super.onPause();
        m_creditCardReader.stop();
        MManager.stopSession();
        pauseCamera();
        m_haveCollectedCreditCardRegion = false;
    }

    protected void onResume()
    {
        super.onResume();
        m_haveCollectedCreditCardRegion = false;
        if (s_libraryLoaded)
        {
            resumeCamera();
        }
        m_creditCardReader.start();
        MManager.startSession();
    }

    public void onStop()
    {
        super.onStop();
        MManager.sendMetrics(UUID.randomUUID().toString(), null);
    }

    protected void pauseCamera()
    {
        if (m_cameraBgHelper != null)
        {
            m_cameraBgHelper.pause();
        }
    }

    protected void resumeCamera()
    {
        if (m_cameraBgHelper != null)
        {
            m_cameraBgHelper.resume(m_minHeight, m_maxHeight, getCameraViewWidth(), getCameraViewHeight(), m_cameraOpenMode);
        }
    }

    protected final void setCameraPreview(A9CameraPreview a9camerapreview)
    {
        m_cameraPreview = a9camerapreview;
    }

    protected boolean supportsFlash()
    {
        return getPackageManager().hasSystemFeature("android.hardware.camera.flash");
    }

    protected final void triggerFocus()
    {
        if (m_cameraPreview != null)
        {
            m_cameraPreview.callFocus();
        }
    }

    static 
    {
        try
        {
            System.loadLibrary("A9VSMobile");
            s_libraryLoaded = true;
        }
        catch (UnsatisfiedLinkError unsatisfiedlinkerror)
        {
            s_libraryLoaded = false;
        }
    }





}

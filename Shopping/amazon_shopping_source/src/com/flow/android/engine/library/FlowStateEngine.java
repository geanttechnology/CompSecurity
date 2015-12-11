// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flow.android.engine.library;

import android.content.Context;
import android.content.res.Resources;
import com.a9.vs.mobile.library.impl.jni.CameraResRequirement;
import com.a9.vs.mobile.library.impl.jni.ExtraFrameData;
import com.a9.vs.mobile.library.impl.jni.FlowStateEngineFacade;
import com.a9.vs.mobile.library.impl.jni.FrameID;
import com.a9.vs.mobile.library.impl.jni.ImageBuffer;
import com.a9.vs.mobile.library.impl.jni.ImageDef;
import com.a9.vs.mobile.library.impl.jni.ImageFormat;
import com.a9.vs.mobile.library.impl.jni.MapOfStringToDouble;
import com.a9.vs.mobile.library.impl.jni.MapOfStringToString;
import com.a9.vs.mobile.library.impl.jni.MapOfStringToUInt;
import com.a9.vs.mobile.library.impl.jni.MobileUtils;
import com.a9.vs.mobile.library.impl.jni.ObjectID;
import com.a9.vs.mobile.library.impl.jni.SensorData;
import com.a9.vs.mobile.library.impl.jni.VectorOfImageBuffer;
import com.a9.vs.mobile.library.impl.jni.VectorOfString;
import com.flow.android.engine.library.impl.FlowStateEngineImpl;
import com.flow.android.engine.library.impl.servermatch.ClientDeviceInfo;
import com.flow.android.engine.models.FlowStateEngineIO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.flow.android.engine.library:
//            FlowStateEngineMetrics, FlowStateEngineInterface

public class FlowStateEngine
{
    public static final class FlowObjectModule extends Enum
    {

        private static final FlowObjectModule $VALUES[];
        public static final FlowObjectModule BARCODE;
        public static final FlowObjectModule DEEPLEARNING;
        public static final FlowObjectModule IMAGEMATCH;
        public static final FlowObjectModule LOGO;
        public static final FlowObjectModule QRCODE;
        public static final FlowObjectModule TEXT;

        public static FlowObjectModule valueOf(String s)
        {
            return (FlowObjectModule)Enum.valueOf(com/flow/android/engine/library/FlowStateEngine$FlowObjectModule, s);
        }

        public static FlowObjectModule[] values()
        {
            return (FlowObjectModule[])$VALUES.clone();
        }

        static 
        {
            IMAGEMATCH = new FlowObjectModule("IMAGEMATCH", 0);
            BARCODE = new FlowObjectModule("BARCODE", 1);
            QRCODE = new FlowObjectModule("QRCODE", 2);
            TEXT = new FlowObjectModule("TEXT", 3);
            LOGO = new FlowObjectModule("LOGO", 4);
            DEEPLEARNING = new FlowObjectModule("DEEPLEARNING", 5);
            $VALUES = (new FlowObjectModule[] {
                IMAGEMATCH, BARCODE, QRCODE, TEXT, LOGO, DEEPLEARNING
            });
        }

        private FlowObjectModule(String s, int i)
        {
            super(s, i);
        }
    }


    private static boolean slibraryLoaded = false;
    private SensorData mEmptySensorData;
    private FlowStateEngineFacade mEngine;
    private FlowStateEngineImpl mImpl;
    private FlowStateEngineInterface mInterface;
    private File mLogFile;
    private int mMaxImageHeight;
    private int mMinImageHeight;
    private Set mModules;
    private boolean mPrintToScreen;
    private String mTessDir;
    private String mTextXMLInputFilename;
    private boolean mUseLogFile;
    private String mZipcodeFilename;

    public FlowStateEngine(FlowStateEngineInterface flowstateengineinterface, Context context, FlowStateEngineIO flowstateengineio)
        throws UnsatisfiedLinkError
    {
        mModules = new HashSet();
        mPrintToScreen = false;
        mUseLogFile = false;
        mTextXMLInputFilename = null;
        mZipcodeFilename = null;
        mTessDir = null;
        if (!slibraryLoaded)
        {
            throw new UnsatisfiedLinkError("Couldn't load the A9VSMobile");
        }
        mEmptySensorData = new SensorData();
        mUseLogFile = flowstateengineio.isUseLogFile();
        mPrintToScreen = flowstateengineio.isPrintToScreen();
        File file = context.getDir("fse", 0);
        if (!file.exists())
        {
            if (file.mkdirs());
        }
        if (mUseLogFile || mPrintToScreen)
        {
            if (mUseLogFile)
            {
                mLogFile = new File(file, "FlowStateEngine.log");
                MobileUtils.setupLogging(mLogFile.getAbsolutePath(), mPrintToScreen);
            } else
            {
                MobileUtils.setupLogging("", mPrintToScreen);
            }
        }
        mTextXMLInputFilename = writeRawFileToPrivateStorage(context, "text", file, "text.xml");
        mZipcodeFilename = writeRawFileToPrivateStorage(context, "zip_code_database_simple", file, "zip_code_database_simple.txt");
        mInterface = flowstateengineinterface;
        flowstateengineinterface = new ClientDeviceInfo(flowstateengineio);
        flowstateengineinterface.setContext(context);
        mImpl = new FlowStateEngineImpl(mInterface, flowstateengineinterface);
        mEngine = new FlowStateEngineFacade(mImpl.getEventCallback());
    }

    private ImageFormat getImageFormat(int i)
    {
        switch (i)
        {
        default:
            return ImageFormat.UNKNOWN_FORMAT;

        case 17: // '\021'
            return ImageFormat.YUV420_NV21;

        case 4: // '\004'
            return ImageFormat.RGB565;
        }
    }

    private void initModules()
    {
        Iterator iterator = mModules.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            FlowObjectModule flowobjectmodule = (FlowObjectModule)iterator.next();
            static class _cls1
            {

                static final int $SwitchMap$com$flow$android$engine$library$FlowStateEngine$FlowObjectModule[];

                static 
                {
                    $SwitchMap$com$flow$android$engine$library$FlowStateEngine$FlowObjectModule = new int[FlowObjectModule.values().length];
                    try
                    {
                        $SwitchMap$com$flow$android$engine$library$FlowStateEngine$FlowObjectModule[FlowObjectModule.BARCODE.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        $SwitchMap$com$flow$android$engine$library$FlowStateEngine$FlowObjectModule[FlowObjectModule.IMAGEMATCH.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$flow$android$engine$library$FlowStateEngine$FlowObjectModule[FlowObjectModule.QRCODE.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$flow$android$engine$library$FlowStateEngine$FlowObjectModule[FlowObjectModule.TEXT.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls1..SwitchMap.com.flow.android.engine.library.FlowStateEngine.FlowObjectModule[flowobjectmodule.ordinal()])
            {
            case 1: // '\001'
                ObjectID objectid = ObjectID.BARCODE;
                mEngine.addObjectModule(objectid, null);
                break;

            case 2: // '\002'
                ObjectID objectid1 = ObjectID.IMGMATCHOBJ;
                com.flow.android.engine.library.impl.FlowServerCallback flowservercallback = mImpl.getImageMatchServerCallback();
                MapOfStringToString mapofstringtostring1 = new MapOfStringToString();
                mapofstringtostring1.set("imageMatch", "true");
                mapofstringtostring1.set("deepLearningRecognition", "true");
                if (mModules.contains(FlowObjectModule.LOGO))
                {
                    mapofstringtostring1.set("logoRecognition", "true");
                }
                mEngine.addObjectModule(objectid1, flowservercallback, mapofstringtostring1);
                break;

            case 3: // '\003'
                ObjectID objectid2 = ObjectID.TWOD_BARCODE;
                MapOfStringToString mapofstringtostring = new MapOfStringToString();
                mapofstringtostring.set("decodeDataMatrix", "true");
                mEngine.addObjectModule(objectid2, null, mapofstringtostring);
                break;

            case 4: // '\004'
                ObjectID objectid3 = ObjectID.TEXT;
                com.flow.android.engine.library.impl.FlowServerCallback flowservercallback1 = mImpl.getTextServerCallback();
                MapOfStringToString mapofstringtostring2 = new MapOfStringToString();
                mapofstringtostring2.set("text.detect.GlyphModelFile", mTextXMLInputFilename);
                mEngine.addObjectModule(objectid3, flowservercallback1, mapofstringtostring2);
                if (mZipcodeFilename != null)
                {
                    mEngine.setZipcodeDatabase(mZipcodeFilename);
                }
                break;
            }
        } while (true);
    }

    private String writeRawFileToPrivateStorage(Context context, String s, File file, String s1)
    {
        Resources resources = context.getResources();
        int i;
        try
        {
            context = resources.openRawResource(resources.getIdentifier(s, "raw", context.getPackageName()));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return "";
        }
        s = new File(file, s1);
        if (s.exists())
        {
            break MISSING_BLOCK_LABEL_101;
        }
        file = new FileOutputStream(s);
        s1 = new byte[4096];
_L1:
        i = context.read(s1);
label0:
        {
            if (i == -1)
            {
                break label0;
            }
            try
            {
                file.write(s1, 0, i);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return "";
            }
        }
          goto _L1
        context.close();
        file.close();
        context = s.getAbsolutePath();
        return context;
    }

    public void addFlowObjectModule(FlowObjectModule flowobjectmodule)
    {
        mModules.add(flowobjectmodule);
    }

    public boolean didLibrariesLoad()
    {
        return slibraryLoaded;
    }

    public FlowStateEngineMetrics getAndClearMetrics(boolean flag)
    {
        FlowStateEngineMetrics flowstateenginemetrics = new FlowStateEngineMetrics();
        Object obj = new MapOfStringToUInt();
        MapOfStringToDouble mapofstringtodouble = new MapOfStringToDouble();
        mEngine.getAndClearMetrics(((MapOfStringToUInt) (obj)), mapofstringtodouble, flag);
        Object obj1 = new HashMap();
        VectorOfString vectorofstring = MapOfStringToUInt.getKeysForIntMap(((MapOfStringToUInt) (obj)));
        for (int i = 0; (long)i < vectorofstring.size(); i++)
        {
            String s1 = vectorofstring.get(i);
            ((Map) (obj1)).put(s1, Integer.valueOf((int)((MapOfStringToUInt) (obj)).get(s1)));
        }

        flowstateenginemetrics.setCounters(((Map) (obj1)));
        obj = new HashMap();
        obj1 = MapOfStringToDouble.getKeysForDoubleMap(mapofstringtodouble);
        for (int j = 0; (long)j < ((VectorOfString) (obj1)).size(); j++)
        {
            String s = ((VectorOfString) (obj1)).get(j);
            ((Map) (obj)).put(s, Double.valueOf(mapofstringtodouble.get(s)));
        }

        flowstateenginemetrics.setTiming(((Map) (obj)));
        return flowstateenginemetrics;
    }

    public int getMaxImageHeight()
    {
        return mMaxImageHeight;
    }

    public int getMinImageHeight()
    {
        return mMinImageHeight;
    }

    public void pause()
    {
        mImpl.shutdownServerDelegates();
        mEngine.pauseEngine();
    }

    public void process(byte abyte0[], int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1, int i2, boolean flag, long l2)
    {
        ExtraFrameData extraframedata = new ExtraFrameData(i1, j1, k1, l1, flag, i2, (double)l2 / 1000D);
        Object obj = new ImageBuffer();
        ((ImageBuffer) (obj)).setDefinition(ImageDef.FULL_RES_COLOR);
        ((ImageBuffer) (obj)).setWidth(j);
        ((ImageBuffer) (obj)).setHeight(i);
        ((ImageBuffer) (obj)).setWidthStep(j);
        ((ImageBuffer) (obj)).setNumChannels(k);
        ((ImageBuffer) (obj)).setFormat(getImageFormat(l));
        VectorOfImageBuffer vectorofimagebuffer = new VectorOfImageBuffer();
        vectorofimagebuffer.add(((ImageBuffer) (obj)));
        obj = new FrameID();
        mEngine.getRequestImageBuffers(vectorofimagebuffer, ((FrameID) (obj)));
        vectorofimagebuffer.get(0).fillBuffer(abyte0, abyte0.length);
        mEngine.process(((FrameID) (obj)).getId(), vectorofimagebuffer, extraframedata, mEmptySensorData);
    }

    public void resume()
    {
        mImpl.resetServerDelegates();
        mEngine.resumeEngine();
    }

    public void sendFSEMetrics()
    {
        FlowStateEngineMetrics flowstateenginemetrics = getAndClearMetrics(true);
        if (flowstateenginemetrics.getCounters().keySet().size() > 0 || flowstateenginemetrics.getTiming().keySet().size() > 0)
        {
            mImpl.doMetricsReporting(flowstateenginemetrics);
        }
    }

    public void start(FlowStateEngineInterface flowstateengineinterface)
    {
        mImpl.setInterface(flowstateengineinterface);
        mImpl.resetServerDelegates();
        initModules();
        flowstateengineinterface = new CameraResRequirement();
        mEngine.getCameraResRequirement(flowstateengineinterface);
        mMinImageHeight = flowstateengineinterface.getMinHeight();
        mMaxImageHeight = flowstateengineinterface.getMaxHeight();
        mEngine.startEngine();
    }

    public void stop()
    {
        mImpl.shutdownServerDelegates();
        mEngine.stopEngine();
        mEngine.removeAllObjectModules();
        mModules.clear();
    }

    static 
    {
        try
        {
            System.loadLibrary("A9VSMobile");
            slibraryLoaded = true;
        }
        catch (UnsatisfiedLinkError unsatisfiedlinkerror)
        {
            slibraryLoaded = false;
        }
    }
}

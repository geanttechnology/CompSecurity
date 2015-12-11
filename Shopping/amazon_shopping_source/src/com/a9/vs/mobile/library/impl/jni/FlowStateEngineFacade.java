// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            EventDelegateBase, A9VSMobileJNI, ObjectID, ServerDelegate, 
//            MapOfStringToString, MapOfStringToUInt, MapOfStringToDouble, CameraResRequirement, 
//            ImageByteData, VectorOfImageBuffer, FrameID, VectorOfImageDef, 
//            ImageBuffer, ExtraFrameData, SensorData

public class FlowStateEngineFacade
{

    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected FlowStateEngineFacade(long l, boolean flag)
    {
        swigCMemOwn = flag;
        swigCPtr = l;
    }

    public FlowStateEngineFacade(EventDelegateBase eventdelegatebase)
    {
        this(A9VSMobileJNI.new_FlowStateEngineFacade(EventDelegateBase.getCPtr(eventdelegatebase), eventdelegatebase), true);
    }

    protected static long getCPtr(FlowStateEngineFacade flowstateenginefacade)
    {
        if (flowstateenginefacade == null)
        {
            return 0L;
        } else
        {
            return flowstateenginefacade.swigCPtr;
        }
    }

    public void addObjectModule(ObjectID objectid, ServerDelegate serverdelegate)
    {
        A9VSMobileJNI.FlowStateEngineFacade_addObjectModule__SWIG_0(swigCPtr, this, objectid.swigValue(), ServerDelegate.getCPtr(serverdelegate), serverdelegate);
    }

    public void addObjectModule(ObjectID objectid, ServerDelegate serverdelegate, MapOfStringToString mapofstringtostring)
    {
        A9VSMobileJNI.FlowStateEngineFacade_addObjectModule__SWIG_2(swigCPtr, this, objectid.swigValue(), ServerDelegate.getCPtr(serverdelegate), serverdelegate, MapOfStringToString.getCPtr(mapofstringtostring), mapofstringtostring);
    }

    public void addObjectModule(ObjectID objectid, ServerDelegate serverdelegate, String s)
    {
        A9VSMobileJNI.FlowStateEngineFacade_addObjectModule__SWIG_1(swigCPtr, this, objectid.swigValue(), ServerDelegate.getCPtr(serverdelegate), serverdelegate, s);
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
                A9VSMobileJNI.delete_FlowStateEngineFacade(swigCPtr);
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

    public void enableEventLogging()
    {
        A9VSMobileJNI.FlowStateEngineFacade_enableEventLogging(swigCPtr, this);
    }

    protected void finalize()
    {
        delete();
    }

    public void getAndClearMetrics(MapOfStringToUInt mapofstringtouint, MapOfStringToDouble mapofstringtodouble, boolean flag)
    {
        A9VSMobileJNI.FlowStateEngineFacade_getAndClearMetrics(swigCPtr, this, MapOfStringToUInt.getCPtr(mapofstringtouint), mapofstringtouint, MapOfStringToDouble.getCPtr(mapofstringtodouble), mapofstringtodouble, flag);
    }

    public void getCameraResRequirement(CameraResRequirement cameraresrequirement)
    {
        A9VSMobileJNI.FlowStateEngineFacade_getCameraResRequirement(swigCPtr, this, CameraResRequirement.getCPtr(cameraresrequirement), cameraresrequirement);
    }

    public boolean getDecodeFrame(String s, ImageByteData imagebytedata, boolean flag)
    {
        return A9VSMobileJNI.FlowStateEngineFacade_getDecodeFrame(swigCPtr, this, s, ImageByteData.getCPtr(imagebytedata), imagebytedata, flag);
    }

    public void getRequestImageBuffers(VectorOfImageBuffer vectorofimagebuffer, FrameID frameid)
    {
        A9VSMobileJNI.FlowStateEngineFacade_getRequestImageBuffers(swigCPtr, this, VectorOfImageBuffer.getCPtr(vectorofimagebuffer), vectorofimagebuffer, FrameID.getCPtr(frameid), frameid);
    }

    public void getRequestImageDefs(VectorOfImageDef vectorofimagedef)
    {
        A9VSMobileJNI.FlowStateEngineFacade_getRequestImageDefs(swigCPtr, this, VectorOfImageDef.getCPtr(vectorofimagedef), vectorofimagedef);
    }

    public void pauseEngine()
    {
        A9VSMobileJNI.FlowStateEngineFacade_pauseEngine(swigCPtr, this);
    }

    public void process(ImageBuffer imagebuffer, ExtraFrameData extraframedata, SensorData sensordata)
    {
        A9VSMobileJNI.FlowStateEngineFacade_process__SWIG_0(swigCPtr, this, ImageBuffer.getCPtr(imagebuffer), imagebuffer, ExtraFrameData.getCPtr(extraframedata), extraframedata, SensorData.getCPtr(sensordata), sensordata);
    }

    public void process(String s, VectorOfImageBuffer vectorofimagebuffer, ExtraFrameData extraframedata, SensorData sensordata)
    {
        A9VSMobileJNI.FlowStateEngineFacade_process__SWIG_1(swigCPtr, this, s, VectorOfImageBuffer.getCPtr(vectorofimagebuffer), vectorofimagebuffer, ExtraFrameData.getCPtr(extraframedata), extraframedata, SensorData.getCPtr(sensordata), sensordata);
    }

    public void readObjectModuleProps(ObjectID objectid, MapOfStringToString mapofstringtostring)
    {
        A9VSMobileJNI.FlowStateEngineFacade_readObjectModuleProps__SWIG_1(swigCPtr, this, objectid.swigValue(), MapOfStringToString.getCPtr(mapofstringtostring), mapofstringtostring);
    }

    public void readObjectModuleProps(ObjectID objectid, String s)
    {
        A9VSMobileJNI.FlowStateEngineFacade_readObjectModuleProps__SWIG_0(swigCPtr, this, objectid.swigValue(), s);
    }

    public void readProps(String s)
    {
        A9VSMobileJNI.FlowStateEngineFacade_readProps(swigCPtr, this, s);
    }

    public void removeAllObjectModules()
    {
        A9VSMobileJNI.FlowStateEngineFacade_removeAllObjectModules(swigCPtr, this);
    }

    public void removeObject(int i)
    {
        A9VSMobileJNI.FlowStateEngineFacade_removeObject(swigCPtr, this, i);
    }

    public void removeObjectModule(ObjectID objectid)
    {
        A9VSMobileJNI.FlowStateEngineFacade_removeObjectModule(swigCPtr, this, objectid.swigValue());
    }

    public void resumeEngine()
    {
        A9VSMobileJNI.FlowStateEngineFacade_resumeEngine(swigCPtr, this);
    }

    public void saveEventLog(String s)
    {
        A9VSMobileJNI.FlowStateEngineFacade_saveEventLog(swigCPtr, this, s);
    }

    public void setLanguage(String s)
    {
        A9VSMobileJNI.FlowStateEngineFacade_setLanguage(swigCPtr, this, s);
    }

    public void setZipcodeDatabase(String s)
    {
        A9VSMobileJNI.FlowStateEngineFacade_setZipcodeDatabase(swigCPtr, this, s);
    }

    public void setupLocalTextRecognitionEngine(String s)
    {
        A9VSMobileJNI.FlowStateEngineFacade_setupLocalTextRecognitionEngine(swigCPtr, this, s);
    }

    public void signalStrongNetworkConnection()
    {
        A9VSMobileJNI.FlowStateEngineFacade_signalStrongNetworkConnection(swigCPtr, this);
    }

    public void signalWeakNetworkConnection()
    {
        A9VSMobileJNI.FlowStateEngineFacade_signalWeakNetworkConnection(swigCPtr, this);
    }

    public void startEngine()
    {
        A9VSMobileJNI.FlowStateEngineFacade_startEngine(swigCPtr, this);
    }

    public void stopEngine()
    {
        A9VSMobileJNI.FlowStateEngineFacade_stopEngine(swigCPtr, this);
    }
}

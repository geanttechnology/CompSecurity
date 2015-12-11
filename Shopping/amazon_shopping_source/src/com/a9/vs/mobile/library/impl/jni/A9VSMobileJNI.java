// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            CreditCardReaderDelegateBase, CreditCardInfo, ObjectInfo, EventDelegateBase, 
//            VectorOfString, VectorOfPoint2f, ObjectID, StatusID, 
//            CameraStabilityIssue, JudgeVerdictOnModule, ActionID, ServerFailure, 
//            TextCanvasInfo, ServerRequest, ServerDelegate, Address, 
//            BusinessCardEntity, BusinessCardInfo, VectorOfBusinessCardEntities, Name, 
//            ByteArray, CameraAccelerometerMeasurement, Point3d, CameraGyroMeasurement, 
//            CameraMemsMeasurement, CameraResRequirement, CardRegion, CreditCardProcessProperty, 
//            CreditCardReaderFacade, MapOfStringToUInt, MapOfStringToDouble, ImageByteData, 
//            ExtraFrameData, FlowStateEngineFacade, MapOfStringToString, VectorOfImageBuffer, 
//            FrameID, VectorOfImageDef, ImageBuffer, SensorData, 
//            NEONAccelerationResult, Point2f, VectorOfFlowCameraAccelerometerMeasurement, VectorOfFlowCameraGyroMeasurement, 
//            VectorOfFlowCameraMemsMeasurement, ServerDelegateInterface, ServerResponse, ServerResponseHandler, 
//            StringPair, VectorOfObjectInfo, VectorOfDouble, VectorOfInt, 
//            VectorOfStringPairs, VectorOfVectorOfInt

public class A9VSMobileJNI
{

    public A9VSMobileJNI()
    {
    }

    public static final native String Address_city_get(long l, Address address);

    public static final native void Address_city_set(long l, Address address, String s);

    public static final native boolean Address_isVerified_get(long l, Address address);

    public static final native void Address_isVerified_set(long l, Address address, boolean flag);

    public static final native String Address_state_abbr_get(long l, Address address);

    public static final native void Address_state_abbr_set(long l, Address address, String s);

    public static final native String Address_state_full_get(long l, Address address);

    public static final native void Address_state_full_set(long l, Address address, String s);

    public static final native String Address_street_get(long l, Address address);

    public static final native void Address_street_set(long l, Address address, String s);

    public static final native String Address_zipcode_get(long l, Address address);

    public static final native void Address_zipcode_set(long l, Address address, String s);

    public static final native String BusinessCardEntity_content_get(long l, BusinessCardEntity businesscardentity);

    public static final native void BusinessCardEntity_content_set(long l, BusinessCardEntity businesscardentity, String s);

    public static final native String BusinessCardEntity_extension_get(long l, BusinessCardEntity businesscardentity);

    public static final native void BusinessCardEntity_extension_set(long l, BusinessCardEntity businesscardentity, String s);

    public static final native boolean BusinessCardEntity_isVerified_get(long l, BusinessCardEntity businesscardentity);

    public static final native void BusinessCardEntity_isVerified_set(long l, BusinessCardEntity businesscardentity, boolean flag);

    public static final native String BusinessCardEntity_type_get(long l, BusinessCardEntity businesscardentity);

    public static final native void BusinessCardEntity_type_set(long l, BusinessCardEntity businesscardentity, String s);

    public static final native long BusinessCardInfo_address_get(long l, BusinessCardInfo businesscardinfo);

    public static final native void BusinessCardInfo_address_set(long l, BusinessCardInfo businesscardinfo, long l1, Address address);

    public static final native long BusinessCardInfo_company_get(long l, BusinessCardInfo businesscardinfo);

    public static final native void BusinessCardInfo_company_set(long l, BusinessCardInfo businesscardinfo, long l1, BusinessCardEntity businesscardentity);

    public static final native long BusinessCardInfo_department_get(long l, BusinessCardInfo businesscardinfo);

    public static final native void BusinessCardInfo_department_set(long l, BusinessCardInfo businesscardinfo, long l1, BusinessCardEntity businesscardentity);

    public static final native long BusinessCardInfo_emails_get(long l, BusinessCardInfo businesscardinfo);

    public static final native void BusinessCardInfo_emails_set(long l, BusinessCardInfo businesscardinfo, long l1, VectorOfBusinessCardEntities vectorofbusinesscardentities);

    public static final native long BusinessCardInfo_jobTitle_get(long l, BusinessCardInfo businesscardinfo);

    public static final native void BusinessCardInfo_jobTitle_set(long l, BusinessCardInfo businesscardinfo, long l1, BusinessCardEntity businesscardentity);

    public static final native long BusinessCardInfo_name_get(long l, BusinessCardInfo businesscardinfo);

    public static final native void BusinessCardInfo_name_set(long l, BusinessCardInfo businesscardinfo, long l1, Name name);

    public static final native long BusinessCardInfo_otherText_get(long l, BusinessCardInfo businesscardinfo);

    public static final native void BusinessCardInfo_otherText_set(long l, BusinessCardInfo businesscardinfo, long l1, VectorOfBusinessCardEntities vectorofbusinesscardentities);

    public static final native long BusinessCardInfo_phones_get(long l, BusinessCardInfo businesscardinfo);

    public static final native void BusinessCardInfo_phones_set(long l, BusinessCardInfo businesscardinfo, long l1, VectorOfBusinessCardEntities vectorofbusinesscardentities);

    public static final native long BusinessCardInfo_urls_get(long l, BusinessCardInfo businesscardinfo);

    public static final native void BusinessCardInfo_urls_set(long l, BusinessCardInfo businesscardinfo, long l1, VectorOfBusinessCardEntities vectorofbusinesscardentities);

    public static final native void ByteArray_clear(long l, ByteArray bytearray);

    public static final native byte[] ByteArray_getData(long l, ByteArray bytearray);

    public static final native int ByteArray_getLength(long l, ByteArray bytearray);

    public static final native long CameraAccelerometerMeasurement_m_acceleration_get(long l, CameraAccelerometerMeasurement cameraaccelerometermeasurement);

    public static final native void CameraAccelerometerMeasurement_m_acceleration_set(long l, CameraAccelerometerMeasurement cameraaccelerometermeasurement, long l1, Point3d point3d);

    public static final native double CameraAccelerometerMeasurement_m_timeSinceInit_get(long l, CameraAccelerometerMeasurement cameraaccelerometermeasurement);

    public static final native void CameraAccelerometerMeasurement_m_timeSinceInit_set(long l, CameraAccelerometerMeasurement cameraaccelerometermeasurement, double d);

    public static final native long CameraGyroMeasurement_m_omega_get(long l, CameraGyroMeasurement cameragyromeasurement);

    public static final native void CameraGyroMeasurement_m_omega_set(long l, CameraGyroMeasurement cameragyromeasurement, long l1, Point3d point3d);

    public static final native double CameraGyroMeasurement_m_timeSinceInit_get(long l, CameraGyroMeasurement cameragyromeasurement);

    public static final native void CameraGyroMeasurement_m_timeSinceInit_set(long l, CameraGyroMeasurement cameragyromeasurement, double d);

    public static final native long CameraMemsMeasurement_m_acceleration_get(long l, CameraMemsMeasurement cameramemsmeasurement);

    public static final native void CameraMemsMeasurement_m_acceleration_set(long l, CameraMemsMeasurement cameramemsmeasurement, long l1, Point3d point3d);

    public static final native long CameraMemsMeasurement_m_magnetometer_get(long l, CameraMemsMeasurement cameramemsmeasurement);

    public static final native void CameraMemsMeasurement_m_magnetometer_set(long l, CameraMemsMeasurement cameramemsmeasurement, long l1, Point3d point3d);

    public static final native long CameraMemsMeasurement_m_omega_get(long l, CameraMemsMeasurement cameramemsmeasurement);

    public static final native void CameraMemsMeasurement_m_omega_set(long l, CameraMemsMeasurement cameramemsmeasurement, long l1, Point3d point3d);

    public static final native double CameraMemsMeasurement_m_timeSinceInit_get(long l, CameraMemsMeasurement cameramemsmeasurement);

    public static final native void CameraMemsMeasurement_m_timeSinceInit_set(long l, CameraMemsMeasurement cameramemsmeasurement, double d);

    public static final native int CameraResRequirement_maxHeight_get(long l, CameraResRequirement cameraresrequirement);

    public static final native void CameraResRequirement_maxHeight_set(long l, CameraResRequirement cameraresrequirement, int i);

    public static final native int CameraResRequirement_minHeight_get(long l, CameraResRequirement cameraresrequirement);

    public static final native void CameraResRequirement_minHeight_set(long l, CameraResRequirement cameraresrequirement, int i);

    public static final native int CardRegion_bottom_get(long l, CardRegion cardregion);

    public static final native void CardRegion_bottom_set(long l, CardRegion cardregion, int i);

    public static final native int CardRegion_left_get(long l, CardRegion cardregion);

    public static final native void CardRegion_left_set(long l, CardRegion cardregion, int i);

    public static final native int CardRegion_right_get(long l, CardRegion cardregion);

    public static final native void CardRegion_right_set(long l, CardRegion cardregion, int i);

    public static final native int CardRegion_top_get(long l, CardRegion cardregion);

    public static final native void CardRegion_top_set(long l, CardRegion cardregion, int i);

    public static final native long CreditCardInfo_cardDateAlternatives_get(long l, CreditCardInfo creditcardinfo);

    public static final native void CreditCardInfo_cardDateAlternatives_set(long l, CreditCardInfo creditcardinfo, long l1, VectorOfString vectorofstring);

    public static final native String CreditCardInfo_cardHolderName_get(long l, CreditCardInfo creditcardinfo);

    public static final native void CreditCardInfo_cardHolderName_set(long l, CreditCardInfo creditcardinfo, String s);

    public static final native long CreditCardInfo_cardNumberAlternatives_get(long l, CreditCardInfo creditcardinfo);

    public static final native void CreditCardInfo_cardNumberAlternatives_set(long l, CreditCardInfo creditcardinfo, long l1, VectorOfString vectorofstring);

    public static final native String CreditCardInfo_cardNumber_get(long l, CreditCardInfo creditcardinfo);

    public static final native void CreditCardInfo_cardNumber_set(long l, CreditCardInfo creditcardinfo, String s);

    public static final native String CreditCardInfo_expirationDate_get(long l, CreditCardInfo creditcardinfo);

    public static final native void CreditCardInfo_expirationDate_set(long l, CreditCardInfo creditcardinfo, String s);

    public static final native String CreditCardInfo_type_get(long l, CreditCardInfo creditcardinfo);

    public static final native void CreditCardInfo_type_set(long l, CreditCardInfo creditcardinfo, String s);

    public static final native boolean CreditCardProcessProperty_autoFlip_get(long l, CreditCardProcessProperty creditcardprocessproperty);

    public static final native void CreditCardProcessProperty_autoFlip_set(long l, CreditCardProcessProperty creditcardprocessproperty, boolean flag);

    public static final native int CreditCardProcessProperty_cameraMode_get(long l, CreditCardProcessProperty creditcardprocessproperty);

    public static final native void CreditCardProcessProperty_cameraMode_set(long l, CreditCardProcessProperty creditcardprocessproperty, int i);

    public static final native boolean CreditCardProcessProperty_multiThread_get(long l, CreditCardProcessProperty creditcardprocessproperty);

    public static final native void CreditCardProcessProperty_multiThread_set(long l, CreditCardProcessProperty creditcardprocessproperty, boolean flag);

    public static final native int CreditCardProcessProperty_orient_get(long l, CreditCardProcessProperty creditcardprocessproperty);

    public static final native void CreditCardProcessProperty_orient_set(long l, CreditCardProcessProperty creditcardprocessproperty, int i);

    public static final native boolean CreditCardProcessProperty_readDate_get(long l, CreditCardProcessProperty creditcardprocessproperty);

    public static final native void CreditCardProcessProperty_readDate_set(long l, CreditCardProcessProperty creditcardprocessproperty, boolean flag);

    public static final native int CreditCardProcessProperty_scanMode_get(long l, CreditCardProcessProperty creditcardprocessproperty);

    public static final native void CreditCardProcessProperty_scanMode_set(long l, CreditCardProcessProperty creditcardprocessproperty, int i);

    public static final native void CreditCardReaderDelegateBase_change_ownership(CreditCardReaderDelegateBase creditcardreaderdelegatebase, long l, boolean flag);

    public static final native void CreditCardReaderDelegateBase_detectBlackScreen(long l, CreditCardReaderDelegateBase creditcardreaderdelegatebase);

    public static final native void CreditCardReaderDelegateBase_detectBlackScreenSwigExplicitCreditCardReaderDelegateBase(long l, CreditCardReaderDelegateBase creditcardreaderdelegatebase);

    public static final native void CreditCardReaderDelegateBase_detectCard(long l, CreditCardReaderDelegateBase creditcardreaderdelegatebase, int i);

    public static final native void CreditCardReaderDelegateBase_detectCardPromising(long l, CreditCardReaderDelegateBase creditcardreaderdelegatebase);

    public static final native void CreditCardReaderDelegateBase_detectCardPromisingSwigExplicitCreditCardReaderDelegateBase(long l, CreditCardReaderDelegateBase creditcardreaderdelegatebase);

    public static final native void CreditCardReaderDelegateBase_detectCardStabilized(long l, CreditCardReaderDelegateBase creditcardreaderdelegatebase);

    public static final native void CreditCardReaderDelegateBase_detectCardStabilizedSwigExplicitCreditCardReaderDelegateBase(long l, CreditCardReaderDelegateBase creditcardreaderdelegatebase);

    public static final native void CreditCardReaderDelegateBase_detectCardSwigExplicitCreditCardReaderDelegateBase(long l, CreditCardReaderDelegateBase creditcardreaderdelegatebase, int i);

    public static final native void CreditCardReaderDelegateBase_detectDarkScene(long l, CreditCardReaderDelegateBase creditcardreaderdelegatebase);

    public static final native void CreditCardReaderDelegateBase_detectDarkSceneSwigExplicitCreditCardReaderDelegateBase(long l, CreditCardReaderDelegateBase creditcardreaderdelegatebase);

    public static final native void CreditCardReaderDelegateBase_director_connect(CreditCardReaderDelegateBase creditcardreaderdelegatebase, long l, boolean flag, boolean flag1);

    public static final native void CreditCardReaderDelegateBase_recognizeCreditCard(long l, CreditCardReaderDelegateBase creditcardreaderdelegatebase, long l1, CreditCardInfo creditcardinfo);

    public static final native void CreditCardReaderDelegateBase_recognizeCreditCardSwigExplicitCreditCardReaderDelegateBase(long l, CreditCardReaderDelegateBase creditcardreaderdelegatebase, long l1, CreditCardInfo creditcardinfo);

    public static final native void CreditCardReaderFacade_generateReportAndClear(long l, CreditCardReaderFacade creditcardreaderfacade, long l1, MapOfStringToUInt mapofstringtouint, long l2, 
            MapOfStringToDouble mapofstringtodouble);

    public static final native void CreditCardReaderFacade_getCreditCardImage(long l, CreditCardReaderFacade creditcardreaderfacade, long l1, ImageByteData imagebytedata);

    public static final native void CreditCardReaderFacade_getOptimalSize__SWIG_0(long l, CreditCardReaderFacade creditcardreaderfacade, int i, int j, long l1, CardRegion cardregion);

    public static final native void CreditCardReaderFacade_getOptimalSize__SWIG_1(long l, CreditCardReaderFacade creditcardreaderfacade, int i, int j, int k, long l1, 
            CardRegion cardregion);

    public static final native boolean CreditCardReaderFacade_loadDigitModel(long l, CreditCardReaderFacade creditcardreaderfacade, String s);

    public static final native void CreditCardReaderFacade_process(long l, CreditCardReaderFacade creditcardreaderfacade, byte abyte0[], int i, int j, int k, int i1, 
            int j1, int k1);

    public static final native void CreditCardReaderFacade_setDelegate(long l, CreditCardReaderFacade creditcardreaderfacade, long l1, CreditCardReaderDelegateBase creditcardreaderdelegatebase);

    public static final native void CreditCardReaderFacade_setOrientation(long l, CreditCardReaderFacade creditcardreaderfacade, int i);

    public static final native void CreditCardReaderFacade_start(long l, CreditCardReaderFacade creditcardreaderfacade);

    public static final native void CreditCardReaderFacade_stop(long l, CreditCardReaderFacade creditcardreaderfacade);

    public static final native void EventDelegateBase_change_ownership(EventDelegateBase eventdelegatebase, long l, boolean flag);

    public static final native void EventDelegateBase_didDecode(long l, EventDelegateBase eventdelegatebase, long l1, ObjectInfo objectinfo);

    public static final native void EventDelegateBase_didDecodeFreeText(long l, EventDelegateBase eventdelegatebase, long l1, VectorOfString vectorofstring, long l2, 
            VectorOfString vectorofstring1, String s);

    public static final native void EventDelegateBase_didDecodeFreeTextSwigExplicitEventDelegateBase(long l, EventDelegateBase eventdelegatebase, long l1, VectorOfString vectorofstring, long l2, 
            VectorOfString vectorofstring1, String s);

    public static final native void EventDelegateBase_didDecodeSwigExplicitEventDelegateBase(long l, EventDelegateBase eventdelegatebase, long l1, ObjectInfo objectinfo);

    public static final native void EventDelegateBase_didDecodeTextCanvas(long l, EventDelegateBase eventdelegatebase, int i, String s);

    public static final native void EventDelegateBase_didDecodeTextCanvasSwigExplicitEventDelegateBase(long l, EventDelegateBase eventdelegatebase, int i, String s);

    public static final native void EventDelegateBase_didDetect(long l, EventDelegateBase eventdelegatebase, long l1, ObjectInfo objectinfo);

    public static final native void EventDelegateBase_didDetectInterestPoints(long l, EventDelegateBase eventdelegatebase, long l1, VectorOfPoint2f vectorofpoint2f);

    public static final native void EventDelegateBase_didDetectInterestPointsSwigExplicitEventDelegateBase(long l, EventDelegateBase eventdelegatebase, long l1, VectorOfPoint2f vectorofpoint2f);

    public static final native void EventDelegateBase_didDetectSwigExplicitEventDelegateBase(long l, EventDelegateBase eventdelegatebase, long l1, ObjectInfo objectinfo);

    public static final native void EventDelegateBase_didProcessFrame(long l, EventDelegateBase eventdelegatebase, int i, int j, int k, int i1);

    public static final native void EventDelegateBase_didProcessFrameDecision(long l, EventDelegateBase eventdelegatebase, int i, double d);

    public static final native void EventDelegateBase_didProcessFrameDecisionSwigExplicitEventDelegateBase(long l, EventDelegateBase eventdelegatebase, int i, double d);

    public static final native void EventDelegateBase_didProcessFrameSwigExplicitEventDelegateBase(long l, EventDelegateBase eventdelegatebase, int i, int j, int k, int i1);

    public static final native void EventDelegateBase_didProcessModuleDecision(long l, EventDelegateBase eventdelegatebase, int i, int j);

    public static final native void EventDelegateBase_didProcessModuleDecisionSwigExplicitEventDelegateBase(long l, EventDelegateBase eventdelegatebase, int i, int j);

    public static final native void EventDelegateBase_didReceieveBadTextCanvasDecode(long l, EventDelegateBase eventdelegatebase);

    public static final native void EventDelegateBase_didReceieveBadTextCanvasDecodeSwigExplicitEventDelegateBase(long l, EventDelegateBase eventdelegatebase);

    public static final native void EventDelegateBase_didReceiveEvent(long l, EventDelegateBase eventdelegatebase, int i, int j, int k);

    public static final native void EventDelegateBase_didReceiveEventSwigExplicitEventDelegateBase(long l, EventDelegateBase eventdelegatebase, int i, int j, int k);

    public static final native void EventDelegateBase_didReceiveServerError(long l, EventDelegateBase eventdelegatebase, int i, int j);

    public static final native void EventDelegateBase_didReceiveServerErrorSwigExplicitEventDelegateBase(long l, EventDelegateBase eventdelegatebase, int i, int j);

    public static final native void EventDelegateBase_didStopTrackingTextCanvas(long l, EventDelegateBase eventdelegatebase, long l1, TextCanvasInfo textcanvasinfo);

    public static final native void EventDelegateBase_didStopTrackingTextCanvasSwigExplicitEventDelegateBase(long l, EventDelegateBase eventdelegatebase, long l1, TextCanvasInfo textcanvasinfo);

    public static final native void EventDelegateBase_didTrack(long l, EventDelegateBase eventdelegatebase, int i, long l1, VectorOfPoint2f vectorofpoint2f);

    public static final native void EventDelegateBase_didTrackFail(long l, EventDelegateBase eventdelegatebase, int i);

    public static final native void EventDelegateBase_didTrackFailSwigExplicitEventDelegateBase(long l, EventDelegateBase eventdelegatebase, int i);

    public static final native void EventDelegateBase_didTrackSwigExplicitEventDelegateBase(long l, EventDelegateBase eventdelegatebase, int i, long l1, VectorOfPoint2f vectorofpoint2f);

    public static final native void EventDelegateBase_didTrackTextCanvas(long l, EventDelegateBase eventdelegatebase, long l1, TextCanvasInfo textcanvasinfo);

    public static final native void EventDelegateBase_didTrackTextCanvasSwigExplicitEventDelegateBase(long l, EventDelegateBase eventdelegatebase, long l1, TextCanvasInfo textcanvasinfo);

    public static final native void EventDelegateBase_didUpdateTextCanvas(long l, EventDelegateBase eventdelegatebase, long l1, TextCanvasInfo textcanvasinfo);

    public static final native void EventDelegateBase_didUpdateTextCanvasSwigExplicitEventDelegateBase(long l, EventDelegateBase eventdelegatebase, long l1, TextCanvasInfo textcanvasinfo);

    public static final native void EventDelegateBase_didVerify(long l, EventDelegateBase eventdelegatebase, int i);

    public static final native void EventDelegateBase_didVerifySwigExplicitEventDelegateBase(long l, EventDelegateBase eventdelegatebase, int i);

    public static final native void EventDelegateBase_director_connect(EventDelegateBase eventdelegatebase, long l, boolean flag, boolean flag1);

    public static final native void EventDelegateBase_showMessage(long l, EventDelegateBase eventdelegatebase, String s);

    public static final native void EventDelegateBase_showMessageSwigExplicitEventDelegateBase(long l, EventDelegateBase eventdelegatebase, String s);

    public static final native void EventDelegateBase_suggestBoringEvent(long l, EventDelegateBase eventdelegatebase);

    public static final native void EventDelegateBase_suggestBoringEventSwigExplicitEventDelegateBase(long l, EventDelegateBase eventdelegatebase);

    public static final native void EventDelegateBase_suggestStuckEvent(long l, EventDelegateBase eventdelegatebase);

    public static final native void EventDelegateBase_suggestStuckEventSwigExplicitEventDelegateBase(long l, EventDelegateBase eventdelegatebase);

    public static final native boolean ExtraFrameData_flat_get(long l, ExtraFrameData extraframedata);

    public static final native void ExtraFrameData_flat_set(long l, ExtraFrameData extraframedata, boolean flag);

    public static final native int ExtraFrameData_heightDisp_get(long l, ExtraFrameData extraframedata);

    public static final native void ExtraFrameData_heightDisp_set(long l, ExtraFrameData extraframedata, int i);

    public static final native int ExtraFrameData_screenOrient_get(long l, ExtraFrameData extraframedata);

    public static final native void ExtraFrameData_screenOrient_set(long l, ExtraFrameData extraframedata, int i);

    public static final native double ExtraFrameData_timeSinceInit_get(long l, ExtraFrameData extraframedata);

    public static final native void ExtraFrameData_timeSinceInit_set(long l, ExtraFrameData extraframedata, double d);

    public static final native int ExtraFrameData_widthDisp_get(long l, ExtraFrameData extraframedata);

    public static final native void ExtraFrameData_widthDisp_set(long l, ExtraFrameData extraframedata, int i);

    public static final native int ExtraFrameData_xDisp_get(long l, ExtraFrameData extraframedata);

    public static final native void ExtraFrameData_xDisp_set(long l, ExtraFrameData extraframedata, int i);

    public static final native int ExtraFrameData_yDisp_get(long l, ExtraFrameData extraframedata);

    public static final native void ExtraFrameData_yDisp_set(long l, ExtraFrameData extraframedata, int i);

    public static final native void FlowStateEngineFacade_addObjectModule__SWIG_0(long l, FlowStateEngineFacade flowstateenginefacade, int i, long l1, ServerDelegate serverdelegate);

    public static final native void FlowStateEngineFacade_addObjectModule__SWIG_1(long l, FlowStateEngineFacade flowstateenginefacade, int i, long l1, ServerDelegate serverdelegate, String s);

    public static final native void FlowStateEngineFacade_addObjectModule__SWIG_2(long l, FlowStateEngineFacade flowstateenginefacade, int i, long l1, ServerDelegate serverdelegate, long l2, MapOfStringToString mapofstringtostring);

    public static final native void FlowStateEngineFacade_enableEventLogging(long l, FlowStateEngineFacade flowstateenginefacade);

    public static final native void FlowStateEngineFacade_getAndClearMetrics(long l, FlowStateEngineFacade flowstateenginefacade, long l1, MapOfStringToUInt mapofstringtouint, long l2, 
            MapOfStringToDouble mapofstringtodouble, boolean flag);

    public static final native void FlowStateEngineFacade_getCameraResRequirement(long l, FlowStateEngineFacade flowstateenginefacade, long l1, CameraResRequirement cameraresrequirement);

    public static final native boolean FlowStateEngineFacade_getDecodeFrame(long l, FlowStateEngineFacade flowstateenginefacade, String s, long l1, ImageByteData imagebytedata, boolean flag);

    public static final native void FlowStateEngineFacade_getRequestImageBuffers(long l, FlowStateEngineFacade flowstateenginefacade, long l1, VectorOfImageBuffer vectorofimagebuffer, long l2, 
            FrameID frameid);

    public static final native void FlowStateEngineFacade_getRequestImageDefs(long l, FlowStateEngineFacade flowstateenginefacade, long l1, VectorOfImageDef vectorofimagedef);

    public static final native void FlowStateEngineFacade_pauseEngine(long l, FlowStateEngineFacade flowstateenginefacade);

    public static final native void FlowStateEngineFacade_process__SWIG_0(long l, FlowStateEngineFacade flowstateenginefacade, long l1, ImageBuffer imagebuffer, long l2, 
            ExtraFrameData extraframedata, long l3, SensorData sensordata);

    public static final native void FlowStateEngineFacade_process__SWIG_1(long l, FlowStateEngineFacade flowstateenginefacade, String s, long l1, VectorOfImageBuffer vectorofimagebuffer, long l2, ExtraFrameData extraframedata, long l3, SensorData sensordata);

    public static final native void FlowStateEngineFacade_readObjectModuleProps__SWIG_0(long l, FlowStateEngineFacade flowstateenginefacade, int i, String s);

    public static final native void FlowStateEngineFacade_readObjectModuleProps__SWIG_1(long l, FlowStateEngineFacade flowstateenginefacade, int i, long l1, MapOfStringToString mapofstringtostring);

    public static final native void FlowStateEngineFacade_readProps(long l, FlowStateEngineFacade flowstateenginefacade, String s);

    public static final native void FlowStateEngineFacade_removeAllObjectModules(long l, FlowStateEngineFacade flowstateenginefacade);

    public static final native void FlowStateEngineFacade_removeObject(long l, FlowStateEngineFacade flowstateenginefacade, int i);

    public static final native void FlowStateEngineFacade_removeObjectModule(long l, FlowStateEngineFacade flowstateenginefacade, int i);

    public static final native void FlowStateEngineFacade_resumeEngine(long l, FlowStateEngineFacade flowstateenginefacade);

    public static final native void FlowStateEngineFacade_saveEventLog(long l, FlowStateEngineFacade flowstateenginefacade, String s);

    public static final native void FlowStateEngineFacade_setLanguage(long l, FlowStateEngineFacade flowstateenginefacade, String s);

    public static final native void FlowStateEngineFacade_setZipcodeDatabase(long l, FlowStateEngineFacade flowstateenginefacade, String s);

    public static final native void FlowStateEngineFacade_setupLocalTextRecognitionEngine(long l, FlowStateEngineFacade flowstateenginefacade, String s);

    public static final native void FlowStateEngineFacade_signalStrongNetworkConnection(long l, FlowStateEngineFacade flowstateenginefacade);

    public static final native void FlowStateEngineFacade_signalWeakNetworkConnection(long l, FlowStateEngineFacade flowstateenginefacade);

    public static final native void FlowStateEngineFacade_startEngine(long l, FlowStateEngineFacade flowstateenginefacade);

    public static final native void FlowStateEngineFacade_stopEngine(long l, FlowStateEngineFacade flowstateenginefacade);

    public static final native String FrameID_id_get(long l, FrameID frameid);

    public static final native void FrameID_id_set(long l, FrameID frameid, String s);

    public static final native int ImageBuffer_allocLen_get(long l, ImageBuffer imagebuffer);

    public static final native void ImageBuffer_allocLen_set(long l, ImageBuffer imagebuffer, int i);

    public static final native long ImageBuffer_data_get(long l, ImageBuffer imagebuffer);

    public static final native void ImageBuffer_data_set(long l, ImageBuffer imagebuffer, long l1);

    public static final native int ImageBuffer_definition_get(long l, ImageBuffer imagebuffer);

    public static final native void ImageBuffer_definition_set(long l, ImageBuffer imagebuffer, int i);

    public static final native int ImageBuffer_fillBuffer(long l, ImageBuffer imagebuffer, byte abyte0[], int i);

    public static final native int ImageBuffer_format_get(long l, ImageBuffer imagebuffer);

    public static final native void ImageBuffer_format_set(long l, ImageBuffer imagebuffer, int i);

    public static final native int ImageBuffer_height_get(long l, ImageBuffer imagebuffer);

    public static final native void ImageBuffer_height_set(long l, ImageBuffer imagebuffer, int i);

    public static final native int ImageBuffer_numChannels_get(long l, ImageBuffer imagebuffer);

    public static final native void ImageBuffer_numChannels_set(long l, ImageBuffer imagebuffer, int i);

    public static final native int ImageBuffer_widthStep_get(long l, ImageBuffer imagebuffer);

    public static final native void ImageBuffer_widthStep_set(long l, ImageBuffer imagebuffer, int i);

    public static final native int ImageBuffer_width_get(long l, ImageBuffer imagebuffer);

    public static final native void ImageBuffer_width_set(long l, ImageBuffer imagebuffer, int i);

    public static final native byte[] ImageByteData_getData(long l, ImageByteData imagebytedata);

    public static final native int ImageByteData_getHeight(long l, ImageByteData imagebytedata);

    public static final native int ImageByteData_getLength(long l, ImageByteData imagebytedata);

    public static final native int ImageByteData_getWidth(long l, ImageByteData imagebytedata);

    public static final native void MapOfStringToDouble_clear(long l, MapOfStringToDouble mapofstringtodouble);

    public static final native void MapOfStringToDouble_del(long l, MapOfStringToDouble mapofstringtodouble, String s);

    public static final native boolean MapOfStringToDouble_empty(long l, MapOfStringToDouble mapofstringtodouble);

    public static final native double MapOfStringToDouble_get(long l, MapOfStringToDouble mapofstringtodouble, String s);

    public static final native long MapOfStringToDouble_getKeysForDoubleMap(long l, MapOfStringToDouble mapofstringtodouble);

    public static final native boolean MapOfStringToDouble_has_key(long l, MapOfStringToDouble mapofstringtodouble, String s);

    public static final native void MapOfStringToDouble_set(long l, MapOfStringToDouble mapofstringtodouble, String s, double d);

    public static final native long MapOfStringToDouble_size(long l, MapOfStringToDouble mapofstringtodouble);

    public static final native void MapOfStringToString_clear(long l, MapOfStringToString mapofstringtostring);

    public static final native void MapOfStringToString_del(long l, MapOfStringToString mapofstringtostring, String s);

    public static final native boolean MapOfStringToString_empty(long l, MapOfStringToString mapofstringtostring);

    public static final native String MapOfStringToString_get(long l, MapOfStringToString mapofstringtostring, String s);

    public static final native long MapOfStringToString_getKeys(long l, MapOfStringToString mapofstringtostring);

    public static final native boolean MapOfStringToString_has_key(long l, MapOfStringToString mapofstringtostring, String s);

    public static final native void MapOfStringToString_set(long l, MapOfStringToString mapofstringtostring, String s, String s1);

    public static final native long MapOfStringToString_size(long l, MapOfStringToString mapofstringtostring);

    public static final native void MapOfStringToUInt_clear(long l, MapOfStringToUInt mapofstringtouint);

    public static final native void MapOfStringToUInt_del(long l, MapOfStringToUInt mapofstringtouint, String s);

    public static final native boolean MapOfStringToUInt_empty(long l, MapOfStringToUInt mapofstringtouint);

    public static final native long MapOfStringToUInt_get(long l, MapOfStringToUInt mapofstringtouint, String s);

    public static final native long MapOfStringToUInt_getKeysForIntMap(long l, MapOfStringToUInt mapofstringtouint);

    public static final native boolean MapOfStringToUInt_has_key(long l, MapOfStringToUInt mapofstringtouint, String s);

    public static final native void MapOfStringToUInt_set(long l, MapOfStringToUInt mapofstringtouint, String s, long l1);

    public static final native long MapOfStringToUInt_size(long l, MapOfStringToUInt mapofstringtouint);

    public static final native String MobileUtils_getDataDumpLocation();

    public static final native void MobileUtils_setDataDumpLocation(String s);

    public static final native boolean MobileUtils_setupLogging(String s, boolean flag);

    public static final native void MobileUtils_testNEON(long l, NEONAccelerationResult neonaccelerationresult);

    public static final native String NEONAccelerationResult_resultStr_get(long l, NEONAccelerationResult neonaccelerationresult);

    public static final native void NEONAccelerationResult_resultStr_set(long l, NEONAccelerationResult neonaccelerationresult, String s);

    public static final native String Name_first_get(long l, Name name);

    public static final native void Name_first_set(long l, Name name, String s);

    public static final native boolean Name_isVerified_get(long l, Name name);

    public static final native void Name_isVerified_set(long l, Name name, boolean flag);

    public static final native String Name_last_get(long l, Name name);

    public static final native void Name_last_set(long l, Name name, String s);

    public static final native String Name_middle_get(long l, Name name);

    public static final native void Name_middle_set(long l, Name name, String s);

    public static final native long ObjectInfo_alternatives_get(long l, ObjectInfo objectinfo);

    public static final native void ObjectInfo_alternatives_set(long l, ObjectInfo objectinfo, long l1, VectorOfString vectorofstring);

    public static final native String ObjectInfo_content_get(long l, ObjectInfo objectinfo);

    public static final native void ObjectInfo_content_set(long l, ObjectInfo objectinfo, String s);

    public static final native String ObjectInfo_entityType_get(long l, ObjectInfo objectinfo);

    public static final native void ObjectInfo_entityType_set(long l, ObjectInfo objectinfo, String s);

    public static final native int ObjectInfo_id_get(long l, ObjectInfo objectinfo);

    public static final native void ObjectInfo_id_set(long l, ObjectInfo objectinfo, int i);

    public static final native long ObjectInfo_location_get(long l, ObjectInfo objectinfo);

    public static final native void ObjectInfo_location_set(long l, ObjectInfo objectinfo, long l1, VectorOfPoint2f vectorofpoint2f);

    public static final native int ObjectInfo_objType_get(long l, ObjectInfo objectinfo);

    public static final native void ObjectInfo_objType_set(long l, ObjectInfo objectinfo, int i);

    public static final native String ObjectInfo_queryID_get(long l, ObjectInfo objectinfo);

    public static final native void ObjectInfo_queryID_set(long l, ObjectInfo objectinfo, String s);

    public static final native String ObjectInfo_queryStr_get(long l, ObjectInfo objectinfo);

    public static final native void ObjectInfo_queryStr_set(long l, ObjectInfo objectinfo, String s);

    public static final native float ObjectInfo_score_get(long l, ObjectInfo objectinfo);

    public static final native void ObjectInfo_score_set(long l, ObjectInfo objectinfo, float f);

    public static final native String ObjectInfo_tag_get(long l, ObjectInfo objectinfo);

    public static final native void ObjectInfo_tag_set(long l, ObjectInfo objectinfo, String s);

    public static final native String ObjectInfo_uniqueID_get(long l, ObjectInfo objectinfo);

    public static final native void ObjectInfo_uniqueID_set(long l, ObjectInfo objectinfo, String s);

    public static final native float Point2f_x_get(long l, Point2f point2f);

    public static final native void Point2f_x_set(long l, Point2f point2f, float f);

    public static final native float Point2f_y_get(long l, Point2f point2f);

    public static final native void Point2f_y_set(long l, Point2f point2f, float f);

    public static final native double Point3d_x_get(long l, Point3d point3d);

    public static final native void Point3d_x_set(long l, Point3d point3d, double d);

    public static final native double Point3d_y_get(long l, Point3d point3d);

    public static final native void Point3d_y_set(long l, Point3d point3d, double d);

    public static final native double Point3d_z_get(long l, Point3d point3d);

    public static final native void Point3d_z_set(long l, Point3d point3d, double d);

    public static final native long SensorData_rawAccData_get(long l, SensorData sensordata);

    public static final native void SensorData_rawAccData_set(long l, SensorData sensordata, long l1, VectorOfFlowCameraAccelerometerMeasurement vectorofflowcameraaccelerometermeasurement);

    public static final native long SensorData_rawGyroData_get(long l, SensorData sensordata);

    public static final native void SensorData_rawGyroData_set(long l, SensorData sensordata, long l1, VectorOfFlowCameraGyroMeasurement vectorofflowcameragyromeasurement);

    public static final native long SensorData_rawSensorData_get(long l, SensorData sensordata);

    public static final native void SensorData_rawSensorData_set(long l, SensorData sensordata, long l1, VectorOfFlowCameraMemsMeasurement vectorofflowcameramemsmeasurement);

    public static final native boolean ServerDelegateInterface_sendServerRequest(long l, ServerDelegateInterface serverdelegateinterface, long l1, ServerRequest serverrequest);

    public static final native long ServerDelegate_SWIGUpcast(long l);

    public static final native void ServerDelegate_change_ownership(ServerDelegate serverdelegate, long l, boolean flag);

    public static final native void ServerDelegate_director_connect(ServerDelegate serverdelegate, long l, boolean flag, boolean flag1);

    public static final native void ServerDelegate_pushServerResponse(long l, ServerDelegate serverdelegate, long l1, ServerResponse serverresponse);

    public static final native boolean ServerDelegate_sendServerRequest(long l, ServerDelegate serverdelegate, long l1, ServerRequest serverrequest);

    public static final native boolean ServerDelegate_sendServerRequestImpl(long l, ServerDelegate serverdelegate, long l1, ServerRequest serverrequest);

    public static final native boolean ServerDelegate_sendServerRequestSwigExplicitServerDelegate(long l, ServerDelegate serverdelegate, long l1, ServerRequest serverrequest);

    public static final native void ServerRequest_clear(long l, ServerRequest serverrequest);

    public static final native long ServerRequest_data_get(long l, ServerRequest serverrequest);

    public static final native void ServerRequest_data_set(long l, ServerRequest serverrequest, long l1, ByteArray bytearray);

    public static final native String ServerRequest_id_get(long l, ServerRequest serverrequest);

    public static final native void ServerRequest_id_set(long l, ServerRequest serverrequest, String s);

    public static final native long ServerRequest_metadata_get(long l, ServerRequest serverrequest);

    public static final native void ServerRequest_metadata_set(long l, ServerRequest serverrequest, long l1, MapOfStringToString mapofstringtostring);

    public static final native long ServerRequest_params_get(long l, ServerRequest serverrequest);

    public static final native void ServerRequest_params_set(long l, ServerRequest serverrequest, long l1, MapOfStringToString mapofstringtostring);

    public static final native long ServerRequest_responseHandler_get(long l, ServerRequest serverrequest);

    public static final native void ServerRequest_responseHandler_set(long l, ServerRequest serverrequest, long l1, ServerResponseHandler serverresponsehandler);

    public static final native void ServerResponseHandler_handleServerResponse(long l, ServerResponseHandler serverresponsehandler, long l1, ServerResponse serverresponse);

    public static final native boolean ServerResponse_compressed_get(long l, ServerResponse serverresponse);

    public static final native void ServerResponse_compressed_set(long l, ServerResponse serverresponse, boolean flag);

    public static final native String ServerResponse_id_get(long l, ServerResponse serverresponse);

    public static final native void ServerResponse_id_set(long l, ServerResponse serverresponse, String s);

    public static final native String ServerResponse_responseStr_get(long l, ServerResponse serverresponse);

    public static final native void ServerResponse_responseStr_set(long l, ServerResponse serverresponse, String s);

    public static final native int ServerResponse_responseType_get(long l, ServerResponse serverresponse);

    public static final native void ServerResponse_responseType_set(long l, ServerResponse serverresponse, int i);

    public static final native double ServerResponse_roundtripTime_get(long l, ServerResponse serverresponse);

    public static final native void ServerResponse_roundtripTime_set(long l, ServerResponse serverresponse, double d);

    public static final native String StringPair_first_get(long l, StringPair stringpair);

    public static final native void StringPair_first_set(long l, StringPair stringpair, String s);

    public static final native String StringPair_second_get(long l, StringPair stringpair);

    public static final native void StringPair_second_set(long l, StringPair stringpair, String s);

    public static void SwigDirector_CreditCardReaderDelegateBase_detectBlackScreen(CreditCardReaderDelegateBase creditcardreaderdelegatebase)
    {
        creditcardreaderdelegatebase.detectBlackScreen();
    }

    public static void SwigDirector_CreditCardReaderDelegateBase_detectCard(CreditCardReaderDelegateBase creditcardreaderdelegatebase, int i)
    {
        creditcardreaderdelegatebase.detectCard(i);
    }

    public static void SwigDirector_CreditCardReaderDelegateBase_detectCardPromising(CreditCardReaderDelegateBase creditcardreaderdelegatebase)
    {
        creditcardreaderdelegatebase.detectCardPromising();
    }

    public static void SwigDirector_CreditCardReaderDelegateBase_detectCardStabilized(CreditCardReaderDelegateBase creditcardreaderdelegatebase)
    {
        creditcardreaderdelegatebase.detectCardStabilized();
    }

    public static void SwigDirector_CreditCardReaderDelegateBase_detectDarkScene(CreditCardReaderDelegateBase creditcardreaderdelegatebase)
    {
        creditcardreaderdelegatebase.detectDarkScene();
    }

    public static void SwigDirector_CreditCardReaderDelegateBase_recognizeCreditCard(CreditCardReaderDelegateBase creditcardreaderdelegatebase, long l)
    {
        creditcardreaderdelegatebase.recognizeCreditCard(new CreditCardInfo(l, false));
    }

    public static void SwigDirector_EventDelegateBase_didDecode(EventDelegateBase eventdelegatebase, long l)
    {
        eventdelegatebase.didDecode(new ObjectInfo(l, false));
    }

    public static void SwigDirector_EventDelegateBase_didDecodeFreeText(EventDelegateBase eventdelegatebase, long l, long l1, String s)
    {
        eventdelegatebase.didDecodeFreeText(new VectorOfString(l, false), new VectorOfString(l1, false), s);
    }

    public static void SwigDirector_EventDelegateBase_didDecodeTextCanvas(EventDelegateBase eventdelegatebase, int i, String s)
    {
        eventdelegatebase.didDecodeTextCanvas(i, s);
    }

    public static void SwigDirector_EventDelegateBase_didDetect(EventDelegateBase eventdelegatebase, long l)
    {
        eventdelegatebase.didDetect(new ObjectInfo(l, false));
    }

    public static void SwigDirector_EventDelegateBase_didDetectInterestPoints(EventDelegateBase eventdelegatebase, long l)
    {
        eventdelegatebase.didDetectInterestPoints(new VectorOfPoint2f(l, false));
    }

    public static void SwigDirector_EventDelegateBase_didProcessFrame(EventDelegateBase eventdelegatebase, int i, int j, int k, int l)
    {
        eventdelegatebase.didProcessFrame(ObjectID.swigToEnum(i), StatusID.swigToEnum(j), k, l);
    }

    public static void SwigDirector_EventDelegateBase_didProcessFrameDecision(EventDelegateBase eventdelegatebase, int i, double d)
    {
        eventdelegatebase.didProcessFrameDecision(CameraStabilityIssue.swigToEnum(i), d);
    }

    public static void SwigDirector_EventDelegateBase_didProcessModuleDecision(EventDelegateBase eventdelegatebase, int i, int j)
    {
        eventdelegatebase.didProcessModuleDecision(ObjectID.swigToEnum(i), JudgeVerdictOnModule.swigToEnum(j));
    }

    public static void SwigDirector_EventDelegateBase_didReceieveBadTextCanvasDecode(EventDelegateBase eventdelegatebase)
    {
        eventdelegatebase.didReceieveBadTextCanvasDecode();
    }

    public static void SwigDirector_EventDelegateBase_didReceiveEvent(EventDelegateBase eventdelegatebase, int i, int j, int k)
    {
        eventdelegatebase.didReceiveEvent(ObjectID.swigToEnum(i), ActionID.swigToEnum(j), StatusID.swigToEnum(k));
    }

    public static void SwigDirector_EventDelegateBase_didReceiveServerError(EventDelegateBase eventdelegatebase, int i, int j)
    {
        eventdelegatebase.didReceiveServerError(ObjectID.swigToEnum(i), ServerFailure.swigToEnum(j));
    }

    public static void SwigDirector_EventDelegateBase_didStopTrackingTextCanvas(EventDelegateBase eventdelegatebase, long l)
    {
        eventdelegatebase.didStopTrackingTextCanvas(new TextCanvasInfo(l, false));
    }

    public static void SwigDirector_EventDelegateBase_didTrack(EventDelegateBase eventdelegatebase, int i, long l)
    {
        eventdelegatebase.didTrack(i, new VectorOfPoint2f(l, false));
    }

    public static void SwigDirector_EventDelegateBase_didTrackFail(EventDelegateBase eventdelegatebase, int i)
    {
        eventdelegatebase.didTrackFail(i);
    }

    public static void SwigDirector_EventDelegateBase_didTrackTextCanvas(EventDelegateBase eventdelegatebase, long l)
    {
        eventdelegatebase.didTrackTextCanvas(new TextCanvasInfo(l, false));
    }

    public static void SwigDirector_EventDelegateBase_didUpdateTextCanvas(EventDelegateBase eventdelegatebase, long l)
    {
        eventdelegatebase.didUpdateTextCanvas(new TextCanvasInfo(l, false));
    }

    public static void SwigDirector_EventDelegateBase_didVerify(EventDelegateBase eventdelegatebase, int i)
    {
        eventdelegatebase.didVerify(i);
    }

    public static void SwigDirector_EventDelegateBase_showMessage(EventDelegateBase eventdelegatebase, String s)
    {
        eventdelegatebase.showMessage(s);
    }

    public static void SwigDirector_EventDelegateBase_suggestBoringEvent(EventDelegateBase eventdelegatebase)
    {
        eventdelegatebase.suggestBoringEvent();
    }

    public static void SwigDirector_EventDelegateBase_suggestStuckEvent(EventDelegateBase eventdelegatebase)
    {
        eventdelegatebase.suggestStuckEvent();
    }

    public static boolean SwigDirector_ServerDelegate_sendServerRequest(ServerDelegate serverdelegate, long l)
    {
        return serverdelegate.sendServerRequest(new ServerRequest(l, false));
    }

    public static boolean SwigDirector_ServerDelegate_sendServerRequestImpl(ServerDelegate serverdelegate, long l)
    {
        return serverdelegate.sendServerRequestImpl(new ServerRequest(l, false));
    }

    public static final native long TextCanvasInfo_allEntities_get(long l, TextCanvasInfo textcanvasinfo);

    public static final native void TextCanvasInfo_allEntities_set(long l, TextCanvasInfo textcanvasinfo, long l1, VectorOfObjectInfo vectorofobjectinfo);

    public static final native long TextCanvasInfo_businessCard_get(long l, TextCanvasInfo textcanvasinfo);

    public static final native void TextCanvasInfo_businessCard_set(long l, TextCanvasInfo textcanvasinfo, long l1, BusinessCardInfo businesscardinfo);

    public static final native long TextCanvasInfo_canvasBounds_get(long l, TextCanvasInfo textcanvasinfo);

    public static final native void TextCanvasInfo_canvasBounds_set(long l, TextCanvasInfo textcanvasinfo, long l1, VectorOfPoint2f vectorofpoint2f);

    public static final native int TextCanvasInfo_canvasType_get(long l, TextCanvasInfo textcanvasinfo);

    public static final native void TextCanvasInfo_canvasType_set(long l, TextCanvasInfo textcanvasinfo, int i);

    public static final native int TextCanvasInfo_degreesClockwiseToAlign_get(long l, TextCanvasInfo textcanvasinfo);

    public static final native void TextCanvasInfo_degreesClockwiseToAlign_set(long l, TextCanvasInfo textcanvasinfo, int i);

    public static final native int TextCanvasInfo_id_get(long l, TextCanvasInfo textcanvasinfo);

    public static final native void TextCanvasInfo_id_set(long l, TextCanvasInfo textcanvasinfo, int i);

    public static final native boolean TextCanvasInfo_isVerified_get(long l, TextCanvasInfo textcanvasinfo);

    public static final native void TextCanvasInfo_isVerified_set(long l, TextCanvasInfo textcanvasinfo, boolean flag);

    public static final native String TextCanvasInfo_layout_get(long l, TextCanvasInfo textcanvasinfo);

    public static final native void TextCanvasInfo_layout_set(long l, TextCanvasInfo textcanvasinfo, String s);

    public static final native long TextCanvasInfo_scaledCanvasBounds_get(long l, TextCanvasInfo textcanvasinfo);

    public static final native void TextCanvasInfo_scaledCanvasBounds_set(long l, TextCanvasInfo textcanvasinfo, long l1, VectorOfPoint2f vectorofpoint2f);

    public static final native long TextCanvasInfo_scaledScreenBounds_get(long l, TextCanvasInfo textcanvasinfo);

    public static final native void TextCanvasInfo_scaledScreenBounds_set(long l, TextCanvasInfo textcanvasinfo, long l1, VectorOfPoint2f vectorofpoint2f);

    public static final native long TextCanvasInfo_scaledWords_get(long l, TextCanvasInfo textcanvasinfo);

    public static final native void TextCanvasInfo_scaledWords_set(long l, TextCanvasInfo textcanvasinfo, long l1, VectorOfObjectInfo vectorofobjectinfo);

    public static final native String TextCanvasInfo_uniqueID_get(long l, TextCanvasInfo textcanvasinfo);

    public static final native void TextCanvasInfo_uniqueID_set(long l, TextCanvasInfo textcanvasinfo, String s);

    public static final native long TextCanvasInfo_visibleWords_get(long l, TextCanvasInfo textcanvasinfo);

    public static final native void TextCanvasInfo_visibleWords_set(long l, TextCanvasInfo textcanvasinfo, long l1, VectorOfObjectInfo vectorofobjectinfo);

    public static final native void VectorOfBusinessCardEntities_add(long l, VectorOfBusinessCardEntities vectorofbusinesscardentities, long l1, BusinessCardEntity businesscardentity);

    public static final native long VectorOfBusinessCardEntities_capacity(long l, VectorOfBusinessCardEntities vectorofbusinesscardentities);

    public static final native void VectorOfBusinessCardEntities_clear(long l, VectorOfBusinessCardEntities vectorofbusinesscardentities);

    public static final native long VectorOfBusinessCardEntities_get(long l, VectorOfBusinessCardEntities vectorofbusinesscardentities, int i);

    public static final native boolean VectorOfBusinessCardEntities_isEmpty(long l, VectorOfBusinessCardEntities vectorofbusinesscardentities);

    public static final native void VectorOfBusinessCardEntities_reserve(long l, VectorOfBusinessCardEntities vectorofbusinesscardentities, long l1);

    public static final native void VectorOfBusinessCardEntities_set(long l, VectorOfBusinessCardEntities vectorofbusinesscardentities, int i, long l1, BusinessCardEntity businesscardentity);

    public static final native long VectorOfBusinessCardEntities_size(long l, VectorOfBusinessCardEntities vectorofbusinesscardentities);

    public static final native void VectorOfDouble_add(long l, VectorOfDouble vectorofdouble, double d);

    public static final native long VectorOfDouble_capacity(long l, VectorOfDouble vectorofdouble);

    public static final native void VectorOfDouble_clear(long l, VectorOfDouble vectorofdouble);

    public static final native double VectorOfDouble_get(long l, VectorOfDouble vectorofdouble, int i);

    public static final native boolean VectorOfDouble_isEmpty(long l, VectorOfDouble vectorofdouble);

    public static final native void VectorOfDouble_reserve(long l, VectorOfDouble vectorofdouble, long l1);

    public static final native void VectorOfDouble_set(long l, VectorOfDouble vectorofdouble, int i, double d);

    public static final native long VectorOfDouble_size(long l, VectorOfDouble vectorofdouble);

    public static final native void VectorOfFlowCameraAccelerometerMeasurement_add(long l, VectorOfFlowCameraAccelerometerMeasurement vectorofflowcameraaccelerometermeasurement, long l1, CameraAccelerometerMeasurement cameraaccelerometermeasurement);

    public static final native long VectorOfFlowCameraAccelerometerMeasurement_capacity(long l, VectorOfFlowCameraAccelerometerMeasurement vectorofflowcameraaccelerometermeasurement);

    public static final native void VectorOfFlowCameraAccelerometerMeasurement_clear(long l, VectorOfFlowCameraAccelerometerMeasurement vectorofflowcameraaccelerometermeasurement);

    public static final native long VectorOfFlowCameraAccelerometerMeasurement_get(long l, VectorOfFlowCameraAccelerometerMeasurement vectorofflowcameraaccelerometermeasurement, int i);

    public static final native boolean VectorOfFlowCameraAccelerometerMeasurement_isEmpty(long l, VectorOfFlowCameraAccelerometerMeasurement vectorofflowcameraaccelerometermeasurement);

    public static final native void VectorOfFlowCameraAccelerometerMeasurement_reserve(long l, VectorOfFlowCameraAccelerometerMeasurement vectorofflowcameraaccelerometermeasurement, long l1);

    public static final native void VectorOfFlowCameraAccelerometerMeasurement_set(long l, VectorOfFlowCameraAccelerometerMeasurement vectorofflowcameraaccelerometermeasurement, int i, long l1, CameraAccelerometerMeasurement cameraaccelerometermeasurement);

    public static final native long VectorOfFlowCameraAccelerometerMeasurement_size(long l, VectorOfFlowCameraAccelerometerMeasurement vectorofflowcameraaccelerometermeasurement);

    public static final native void VectorOfFlowCameraGyroMeasurement_add(long l, VectorOfFlowCameraGyroMeasurement vectorofflowcameragyromeasurement, long l1, CameraGyroMeasurement cameragyromeasurement);

    public static final native long VectorOfFlowCameraGyroMeasurement_capacity(long l, VectorOfFlowCameraGyroMeasurement vectorofflowcameragyromeasurement);

    public static final native void VectorOfFlowCameraGyroMeasurement_clear(long l, VectorOfFlowCameraGyroMeasurement vectorofflowcameragyromeasurement);

    public static final native long VectorOfFlowCameraGyroMeasurement_get(long l, VectorOfFlowCameraGyroMeasurement vectorofflowcameragyromeasurement, int i);

    public static final native boolean VectorOfFlowCameraGyroMeasurement_isEmpty(long l, VectorOfFlowCameraGyroMeasurement vectorofflowcameragyromeasurement);

    public static final native void VectorOfFlowCameraGyroMeasurement_reserve(long l, VectorOfFlowCameraGyroMeasurement vectorofflowcameragyromeasurement, long l1);

    public static final native void VectorOfFlowCameraGyroMeasurement_set(long l, VectorOfFlowCameraGyroMeasurement vectorofflowcameragyromeasurement, int i, long l1, CameraGyroMeasurement cameragyromeasurement);

    public static final native long VectorOfFlowCameraGyroMeasurement_size(long l, VectorOfFlowCameraGyroMeasurement vectorofflowcameragyromeasurement);

    public static final native void VectorOfFlowCameraMemsMeasurement_add(long l, VectorOfFlowCameraMemsMeasurement vectorofflowcameramemsmeasurement, long l1, CameraMemsMeasurement cameramemsmeasurement);

    public static final native long VectorOfFlowCameraMemsMeasurement_capacity(long l, VectorOfFlowCameraMemsMeasurement vectorofflowcameramemsmeasurement);

    public static final native void VectorOfFlowCameraMemsMeasurement_clear(long l, VectorOfFlowCameraMemsMeasurement vectorofflowcameramemsmeasurement);

    public static final native long VectorOfFlowCameraMemsMeasurement_get(long l, VectorOfFlowCameraMemsMeasurement vectorofflowcameramemsmeasurement, int i);

    public static final native boolean VectorOfFlowCameraMemsMeasurement_isEmpty(long l, VectorOfFlowCameraMemsMeasurement vectorofflowcameramemsmeasurement);

    public static final native void VectorOfFlowCameraMemsMeasurement_reserve(long l, VectorOfFlowCameraMemsMeasurement vectorofflowcameramemsmeasurement, long l1);

    public static final native void VectorOfFlowCameraMemsMeasurement_set(long l, VectorOfFlowCameraMemsMeasurement vectorofflowcameramemsmeasurement, int i, long l1, CameraMemsMeasurement cameramemsmeasurement);

    public static final native long VectorOfFlowCameraMemsMeasurement_size(long l, VectorOfFlowCameraMemsMeasurement vectorofflowcameramemsmeasurement);

    public static final native void VectorOfImageBuffer_add(long l, VectorOfImageBuffer vectorofimagebuffer, long l1, ImageBuffer imagebuffer);

    public static final native long VectorOfImageBuffer_capacity(long l, VectorOfImageBuffer vectorofimagebuffer);

    public static final native void VectorOfImageBuffer_clear(long l, VectorOfImageBuffer vectorofimagebuffer);

    public static final native long VectorOfImageBuffer_get(long l, VectorOfImageBuffer vectorofimagebuffer, int i);

    public static final native boolean VectorOfImageBuffer_isEmpty(long l, VectorOfImageBuffer vectorofimagebuffer);

    public static final native void VectorOfImageBuffer_reserve(long l, VectorOfImageBuffer vectorofimagebuffer, long l1);

    public static final native void VectorOfImageBuffer_set(long l, VectorOfImageBuffer vectorofimagebuffer, int i, long l1, ImageBuffer imagebuffer);

    public static final native long VectorOfImageBuffer_size(long l, VectorOfImageBuffer vectorofimagebuffer);

    public static final native void VectorOfImageDef_add(long l, VectorOfImageDef vectorofimagedef, int i);

    public static final native long VectorOfImageDef_capacity(long l, VectorOfImageDef vectorofimagedef);

    public static final native void VectorOfImageDef_clear(long l, VectorOfImageDef vectorofimagedef);

    public static final native int VectorOfImageDef_get(long l, VectorOfImageDef vectorofimagedef, int i);

    public static final native boolean VectorOfImageDef_isEmpty(long l, VectorOfImageDef vectorofimagedef);

    public static final native void VectorOfImageDef_reserve(long l, VectorOfImageDef vectorofimagedef, long l1);

    public static final native void VectorOfImageDef_set(long l, VectorOfImageDef vectorofimagedef, int i, int j);

    public static final native long VectorOfImageDef_size(long l, VectorOfImageDef vectorofimagedef);

    public static final native void VectorOfInt_add(long l, VectorOfInt vectorofint, int i);

    public static final native long VectorOfInt_capacity(long l, VectorOfInt vectorofint);

    public static final native void VectorOfInt_clear(long l, VectorOfInt vectorofint);

    public static final native int VectorOfInt_get(long l, VectorOfInt vectorofint, int i);

    public static final native boolean VectorOfInt_isEmpty(long l, VectorOfInt vectorofint);

    public static final native void VectorOfInt_reserve(long l, VectorOfInt vectorofint, long l1);

    public static final native void VectorOfInt_set(long l, VectorOfInt vectorofint, int i, int j);

    public static final native long VectorOfInt_size(long l, VectorOfInt vectorofint);

    public static final native void VectorOfObjectInfo_add(long l, VectorOfObjectInfo vectorofobjectinfo, long l1, ObjectInfo objectinfo);

    public static final native long VectorOfObjectInfo_capacity(long l, VectorOfObjectInfo vectorofobjectinfo);

    public static final native void VectorOfObjectInfo_clear(long l, VectorOfObjectInfo vectorofobjectinfo);

    public static final native long VectorOfObjectInfo_get(long l, VectorOfObjectInfo vectorofobjectinfo, int i);

    public static final native boolean VectorOfObjectInfo_isEmpty(long l, VectorOfObjectInfo vectorofobjectinfo);

    public static final native void VectorOfObjectInfo_reserve(long l, VectorOfObjectInfo vectorofobjectinfo, long l1);

    public static final native void VectorOfObjectInfo_set(long l, VectorOfObjectInfo vectorofobjectinfo, int i, long l1, ObjectInfo objectinfo);

    public static final native long VectorOfObjectInfo_size(long l, VectorOfObjectInfo vectorofobjectinfo);

    public static final native void VectorOfPoint2f_add(long l, VectorOfPoint2f vectorofpoint2f, long l1, Point2f point2f);

    public static final native long VectorOfPoint2f_capacity(long l, VectorOfPoint2f vectorofpoint2f);

    public static final native void VectorOfPoint2f_clear(long l, VectorOfPoint2f vectorofpoint2f);

    public static final native long VectorOfPoint2f_get(long l, VectorOfPoint2f vectorofpoint2f, int i);

    public static final native boolean VectorOfPoint2f_isEmpty(long l, VectorOfPoint2f vectorofpoint2f);

    public static final native void VectorOfPoint2f_reserve(long l, VectorOfPoint2f vectorofpoint2f, long l1);

    public static final native void VectorOfPoint2f_set(long l, VectorOfPoint2f vectorofpoint2f, int i, long l1, Point2f point2f);

    public static final native long VectorOfPoint2f_size(long l, VectorOfPoint2f vectorofpoint2f);

    public static final native void VectorOfStringPairs_add(long l, VectorOfStringPairs vectorofstringpairs, long l1, StringPair stringpair);

    public static final native long VectorOfStringPairs_capacity(long l, VectorOfStringPairs vectorofstringpairs);

    public static final native void VectorOfStringPairs_clear(long l, VectorOfStringPairs vectorofstringpairs);

    public static final native long VectorOfStringPairs_get(long l, VectorOfStringPairs vectorofstringpairs, int i);

    public static final native boolean VectorOfStringPairs_isEmpty(long l, VectorOfStringPairs vectorofstringpairs);

    public static final native void VectorOfStringPairs_reserve(long l, VectorOfStringPairs vectorofstringpairs, long l1);

    public static final native void VectorOfStringPairs_set(long l, VectorOfStringPairs vectorofstringpairs, int i, long l1, StringPair stringpair);

    public static final native long VectorOfStringPairs_size(long l, VectorOfStringPairs vectorofstringpairs);

    public static final native void VectorOfString_add(long l, VectorOfString vectorofstring, String s);

    public static final native long VectorOfString_capacity(long l, VectorOfString vectorofstring);

    public static final native void VectorOfString_clear(long l, VectorOfString vectorofstring);

    public static final native String VectorOfString_get(long l, VectorOfString vectorofstring, int i);

    public static final native boolean VectorOfString_isEmpty(long l, VectorOfString vectorofstring);

    public static final native void VectorOfString_reserve(long l, VectorOfString vectorofstring, long l1);

    public static final native void VectorOfString_set(long l, VectorOfString vectorofstring, int i, String s);

    public static final native long VectorOfString_size(long l, VectorOfString vectorofstring);

    public static final native void VectorOfVectorOfInt_add(long l, VectorOfVectorOfInt vectorofvectorofint, long l1, VectorOfInt vectorofint);

    public static final native long VectorOfVectorOfInt_capacity(long l, VectorOfVectorOfInt vectorofvectorofint);

    public static final native void VectorOfVectorOfInt_clear(long l, VectorOfVectorOfInt vectorofvectorofint);

    public static final native long VectorOfVectorOfInt_get(long l, VectorOfVectorOfInt vectorofvectorofint, int i);

    public static final native boolean VectorOfVectorOfInt_isEmpty(long l, VectorOfVectorOfInt vectorofvectorofint);

    public static final native void VectorOfVectorOfInt_reserve(long l, VectorOfVectorOfInt vectorofvectorofint, long l1);

    public static final native void VectorOfVectorOfInt_set(long l, VectorOfVectorOfInt vectorofvectorofint, int i, long l1, VectorOfInt vectorofint);

    public static final native long VectorOfVectorOfInt_size(long l, VectorOfVectorOfInt vectorofvectorofint);

    public static final native void delete_Address(long l);

    public static final native void delete_BusinessCardEntity(long l);

    public static final native void delete_BusinessCardInfo(long l);

    public static final native void delete_ByteArray(long l);

    public static final native void delete_CameraAccelerometerMeasurement(long l);

    public static final native void delete_CameraGyroMeasurement(long l);

    public static final native void delete_CameraMemsMeasurement(long l);

    public static final native void delete_CameraResRequirement(long l);

    public static final native void delete_CardRegion(long l);

    public static final native void delete_CreditCardInfo(long l);

    public static final native void delete_CreditCardProcessProperty(long l);

    public static final native void delete_CreditCardReaderDelegateBase(long l);

    public static final native void delete_CreditCardReaderFacade(long l);

    public static final native void delete_EventDelegateBase(long l);

    public static final native void delete_ExtraFrameData(long l);

    public static final native void delete_FlowStateEngineFacade(long l);

    public static final native void delete_FrameID(long l);

    public static final native void delete_ImageBuffer(long l);

    public static final native void delete_ImageByteData(long l);

    public static final native void delete_MapOfStringToDouble(long l);

    public static final native void delete_MapOfStringToString(long l);

    public static final native void delete_MapOfStringToUInt(long l);

    public static final native void delete_MobileUtils(long l);

    public static final native void delete_NEONAccelerationResult(long l);

    public static final native void delete_Name(long l);

    public static final native void delete_ObjectInfo(long l);

    public static final native void delete_Point2f(long l);

    public static final native void delete_Point3d(long l);

    public static final native void delete_SensorData(long l);

    public static final native void delete_ServerDelegate(long l);

    public static final native void delete_ServerDelegateInterface(long l);

    public static final native void delete_ServerRequest(long l);

    public static final native void delete_ServerResponse(long l);

    public static final native void delete_ServerResponseHandler(long l);

    public static final native void delete_StringPair(long l);

    public static final native void delete_TextCanvasInfo(long l);

    public static final native void delete_VectorOfBusinessCardEntities(long l);

    public static final native void delete_VectorOfDouble(long l);

    public static final native void delete_VectorOfFlowCameraAccelerometerMeasurement(long l);

    public static final native void delete_VectorOfFlowCameraGyroMeasurement(long l);

    public static final native void delete_VectorOfFlowCameraMemsMeasurement(long l);

    public static final native void delete_VectorOfImageBuffer(long l);

    public static final native void delete_VectorOfImageDef(long l);

    public static final native void delete_VectorOfInt(long l);

    public static final native void delete_VectorOfObjectInfo(long l);

    public static final native void delete_VectorOfPoint2f(long l);

    public static final native void delete_VectorOfString(long l);

    public static final native void delete_VectorOfStringPairs(long l);

    public static final native void delete_VectorOfVectorOfInt(long l);

    public static final native long new_Address();

    public static final native long new_BusinessCardEntity();

    public static final native long new_BusinessCardInfo();

    public static final native long new_ByteArray__SWIG_0();

    public static final native long new_ByteArray__SWIG_1(long l, ByteArray bytearray);

    public static final native long new_CameraAccelerometerMeasurement();

    public static final native long new_CameraGyroMeasurement();

    public static final native long new_CameraMemsMeasurement();

    public static final native long new_CameraResRequirement();

    public static final native long new_CardRegion();

    public static final native long new_CreditCardInfo();

    public static final native long new_CreditCardProcessProperty();

    public static final native long new_CreditCardReaderDelegateBase();

    public static final native long new_CreditCardReaderFacade(long l, CreditCardProcessProperty creditcardprocessproperty);

    public static final native long new_EventDelegateBase();

    public static final native long new_ExtraFrameData__SWIG_0();

    public static final native long new_ExtraFrameData__SWIG_1(int i, int j, int k, int l, boolean flag, int i1, double d);

    public static final native long new_FlowStateEngineFacade(long l, EventDelegateBase eventdelegatebase);

    public static final native long new_FrameID();

    public static final native long new_ImageBuffer__SWIG_0();

    public static final native long new_ImageBuffer__SWIG_1(int i, int j, int k, int l, int i1, int j1, long l1);

    public static final native long new_ImageByteData();

    public static final native long new_MapOfStringToDouble__SWIG_0();

    public static final native long new_MapOfStringToDouble__SWIG_1(long l, MapOfStringToDouble mapofstringtodouble);

    public static final native long new_MapOfStringToString__SWIG_0();

    public static final native long new_MapOfStringToString__SWIG_1(long l, MapOfStringToString mapofstringtostring);

    public static final native long new_MapOfStringToUInt__SWIG_0();

    public static final native long new_MapOfStringToUInt__SWIG_1(long l, MapOfStringToUInt mapofstringtouint);

    public static final native long new_MobileUtils();

    public static final native long new_NEONAccelerationResult();

    public static final native long new_Name();

    public static final native long new_ObjectInfo__SWIG_0(int i);

    public static final native long new_ObjectInfo__SWIG_1();

    public static final native long new_Point2f__SWIG_0();

    public static final native long new_Point2f__SWIG_1(float f, float f1);

    public static final native long new_Point3d__SWIG_0();

    public static final native long new_Point3d__SWIG_1(double d, double d1, double d2);

    public static final native long new_SensorData();

    public static final native long new_ServerDelegate();

    public static final native long new_ServerRequest__SWIG_0();

    public static final native long new_ServerRequest__SWIG_1(long l, ByteArray bytearray, String s, long l1, MapOfStringToString mapofstringtostring, long l2, MapOfStringToString mapofstringtostring1);

    public static final native long new_ServerRequest__SWIG_2(long l, ByteArray bytearray, String s, long l1, MapOfStringToString mapofstringtostring);

    public static final native long new_ServerRequest__SWIG_3(long l, ByteArray bytearray, String s);

    public static final native long new_ServerResponse();

    public static final native long new_StringPair__SWIG_0();

    public static final native long new_StringPair__SWIG_1(String s, String s1);

    public static final native long new_StringPair__SWIG_2(long l, StringPair stringpair);

    public static final native long new_TextCanvasInfo();

    public static final native long new_VectorOfBusinessCardEntities__SWIG_0();

    public static final native long new_VectorOfBusinessCardEntities__SWIG_1(long l);

    public static final native long new_VectorOfDouble__SWIG_0();

    public static final native long new_VectorOfDouble__SWIG_1(long l);

    public static final native long new_VectorOfFlowCameraAccelerometerMeasurement__SWIG_0();

    public static final native long new_VectorOfFlowCameraAccelerometerMeasurement__SWIG_1(long l);

    public static final native long new_VectorOfFlowCameraGyroMeasurement__SWIG_0();

    public static final native long new_VectorOfFlowCameraGyroMeasurement__SWIG_1(long l);

    public static final native long new_VectorOfFlowCameraMemsMeasurement__SWIG_0();

    public static final native long new_VectorOfFlowCameraMemsMeasurement__SWIG_1(long l);

    public static final native long new_VectorOfImageBuffer__SWIG_0();

    public static final native long new_VectorOfImageBuffer__SWIG_1(long l);

    public static final native long new_VectorOfImageDef__SWIG_0();

    public static final native long new_VectorOfImageDef__SWIG_1(long l);

    public static final native long new_VectorOfInt__SWIG_0();

    public static final native long new_VectorOfInt__SWIG_1(long l);

    public static final native long new_VectorOfObjectInfo__SWIG_0();

    public static final native long new_VectorOfObjectInfo__SWIG_1(long l);

    public static final native long new_VectorOfPoint2f__SWIG_0();

    public static final native long new_VectorOfPoint2f__SWIG_1(long l);

    public static final native long new_VectorOfStringPairs__SWIG_0();

    public static final native long new_VectorOfStringPairs__SWIG_1(long l);

    public static final native long new_VectorOfString__SWIG_0();

    public static final native long new_VectorOfString__SWIG_1(long l);

    public static final native long new_VectorOfVectorOfInt__SWIG_0();

    public static final native long new_VectorOfVectorOfInt__SWIG_1(long l);

    private static final native void swig_module_init();

    static 
    {
        swig_module_init();
    }
}

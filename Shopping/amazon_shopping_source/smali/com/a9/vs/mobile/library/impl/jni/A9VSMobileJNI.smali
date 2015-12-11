.class public Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;
.super Ljava/lang/Object;
.source "A9VSMobileJNI.java"


# direct methods
.method static constructor <clinit>()V
    .locals 0

    .prologue
    .line 686
    invoke-static {}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->swig_module_init()V

    .line 687
    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static final native Address_city_get(JLcom/a9/vs/mobile/library/impl/jni/Address;)Ljava/lang/String;
.end method

.method public static final native Address_city_set(JLcom/a9/vs/mobile/library/impl/jni/Address;Ljava/lang/String;)V
.end method

.method public static final native Address_isVerified_get(JLcom/a9/vs/mobile/library/impl/jni/Address;)Z
.end method

.method public static final native Address_isVerified_set(JLcom/a9/vs/mobile/library/impl/jni/Address;Z)V
.end method

.method public static final native Address_state_abbr_get(JLcom/a9/vs/mobile/library/impl/jni/Address;)Ljava/lang/String;
.end method

.method public static final native Address_state_abbr_set(JLcom/a9/vs/mobile/library/impl/jni/Address;Ljava/lang/String;)V
.end method

.method public static final native Address_state_full_get(JLcom/a9/vs/mobile/library/impl/jni/Address;)Ljava/lang/String;
.end method

.method public static final native Address_state_full_set(JLcom/a9/vs/mobile/library/impl/jni/Address;Ljava/lang/String;)V
.end method

.method public static final native Address_street_get(JLcom/a9/vs/mobile/library/impl/jni/Address;)Ljava/lang/String;
.end method

.method public static final native Address_street_set(JLcom/a9/vs/mobile/library/impl/jni/Address;Ljava/lang/String;)V
.end method

.method public static final native Address_zipcode_get(JLcom/a9/vs/mobile/library/impl/jni/Address;)Ljava/lang/String;
.end method

.method public static final native Address_zipcode_set(JLcom/a9/vs/mobile/library/impl/jni/Address;Ljava/lang/String;)V
.end method

.method public static final native BusinessCardEntity_content_get(JLcom/a9/vs/mobile/library/impl/jni/BusinessCardEntity;)Ljava/lang/String;
.end method

.method public static final native BusinessCardEntity_content_set(JLcom/a9/vs/mobile/library/impl/jni/BusinessCardEntity;Ljava/lang/String;)V
.end method

.method public static final native BusinessCardEntity_extension_get(JLcom/a9/vs/mobile/library/impl/jni/BusinessCardEntity;)Ljava/lang/String;
.end method

.method public static final native BusinessCardEntity_extension_set(JLcom/a9/vs/mobile/library/impl/jni/BusinessCardEntity;Ljava/lang/String;)V
.end method

.method public static final native BusinessCardEntity_isVerified_get(JLcom/a9/vs/mobile/library/impl/jni/BusinessCardEntity;)Z
.end method

.method public static final native BusinessCardEntity_isVerified_set(JLcom/a9/vs/mobile/library/impl/jni/BusinessCardEntity;Z)V
.end method

.method public static final native BusinessCardEntity_type_get(JLcom/a9/vs/mobile/library/impl/jni/BusinessCardEntity;)Ljava/lang/String;
.end method

.method public static final native BusinessCardEntity_type_set(JLcom/a9/vs/mobile/library/impl/jni/BusinessCardEntity;Ljava/lang/String;)V
.end method

.method public static final native BusinessCardInfo_address_get(JLcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;)J
.end method

.method public static final native BusinessCardInfo_address_set(JLcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;JLcom/a9/vs/mobile/library/impl/jni/Address;)V
.end method

.method public static final native BusinessCardInfo_company_get(JLcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;)J
.end method

.method public static final native BusinessCardInfo_company_set(JLcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;JLcom/a9/vs/mobile/library/impl/jni/BusinessCardEntity;)V
.end method

.method public static final native BusinessCardInfo_department_get(JLcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;)J
.end method

.method public static final native BusinessCardInfo_department_set(JLcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;JLcom/a9/vs/mobile/library/impl/jni/BusinessCardEntity;)V
.end method

.method public static final native BusinessCardInfo_emails_get(JLcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;)J
.end method

.method public static final native BusinessCardInfo_emails_set(JLcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;JLcom/a9/vs/mobile/library/impl/jni/VectorOfBusinessCardEntities;)V
.end method

.method public static final native BusinessCardInfo_jobTitle_get(JLcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;)J
.end method

.method public static final native BusinessCardInfo_jobTitle_set(JLcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;JLcom/a9/vs/mobile/library/impl/jni/BusinessCardEntity;)V
.end method

.method public static final native BusinessCardInfo_name_get(JLcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;)J
.end method

.method public static final native BusinessCardInfo_name_set(JLcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;JLcom/a9/vs/mobile/library/impl/jni/Name;)V
.end method

.method public static final native BusinessCardInfo_otherText_get(JLcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;)J
.end method

.method public static final native BusinessCardInfo_otherText_set(JLcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;JLcom/a9/vs/mobile/library/impl/jni/VectorOfBusinessCardEntities;)V
.end method

.method public static final native BusinessCardInfo_phones_get(JLcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;)J
.end method

.method public static final native BusinessCardInfo_phones_set(JLcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;JLcom/a9/vs/mobile/library/impl/jni/VectorOfBusinessCardEntities;)V
.end method

.method public static final native BusinessCardInfo_urls_get(JLcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;)J
.end method

.method public static final native BusinessCardInfo_urls_set(JLcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;JLcom/a9/vs/mobile/library/impl/jni/VectorOfBusinessCardEntities;)V
.end method

.method public static final native ByteArray_clear(JLcom/a9/vs/mobile/library/impl/jni/ByteArray;)V
.end method

.method public static final native ByteArray_getData(JLcom/a9/vs/mobile/library/impl/jni/ByteArray;)[B
.end method

.method public static final native ByteArray_getLength(JLcom/a9/vs/mobile/library/impl/jni/ByteArray;)I
.end method

.method public static final native CameraAccelerometerMeasurement_m_acceleration_get(JLcom/a9/vs/mobile/library/impl/jni/CameraAccelerometerMeasurement;)J
.end method

.method public static final native CameraAccelerometerMeasurement_m_acceleration_set(JLcom/a9/vs/mobile/library/impl/jni/CameraAccelerometerMeasurement;JLcom/a9/vs/mobile/library/impl/jni/Point3d;)V
.end method

.method public static final native CameraAccelerometerMeasurement_m_timeSinceInit_get(JLcom/a9/vs/mobile/library/impl/jni/CameraAccelerometerMeasurement;)D
.end method

.method public static final native CameraAccelerometerMeasurement_m_timeSinceInit_set(JLcom/a9/vs/mobile/library/impl/jni/CameraAccelerometerMeasurement;D)V
.end method

.method public static final native CameraGyroMeasurement_m_omega_get(JLcom/a9/vs/mobile/library/impl/jni/CameraGyroMeasurement;)J
.end method

.method public static final native CameraGyroMeasurement_m_omega_set(JLcom/a9/vs/mobile/library/impl/jni/CameraGyroMeasurement;JLcom/a9/vs/mobile/library/impl/jni/Point3d;)V
.end method

.method public static final native CameraGyroMeasurement_m_timeSinceInit_get(JLcom/a9/vs/mobile/library/impl/jni/CameraGyroMeasurement;)D
.end method

.method public static final native CameraGyroMeasurement_m_timeSinceInit_set(JLcom/a9/vs/mobile/library/impl/jni/CameraGyroMeasurement;D)V
.end method

.method public static final native CameraMemsMeasurement_m_acceleration_get(JLcom/a9/vs/mobile/library/impl/jni/CameraMemsMeasurement;)J
.end method

.method public static final native CameraMemsMeasurement_m_acceleration_set(JLcom/a9/vs/mobile/library/impl/jni/CameraMemsMeasurement;JLcom/a9/vs/mobile/library/impl/jni/Point3d;)V
.end method

.method public static final native CameraMemsMeasurement_m_magnetometer_get(JLcom/a9/vs/mobile/library/impl/jni/CameraMemsMeasurement;)J
.end method

.method public static final native CameraMemsMeasurement_m_magnetometer_set(JLcom/a9/vs/mobile/library/impl/jni/CameraMemsMeasurement;JLcom/a9/vs/mobile/library/impl/jni/Point3d;)V
.end method

.method public static final native CameraMemsMeasurement_m_omega_get(JLcom/a9/vs/mobile/library/impl/jni/CameraMemsMeasurement;)J
.end method

.method public static final native CameraMemsMeasurement_m_omega_set(JLcom/a9/vs/mobile/library/impl/jni/CameraMemsMeasurement;JLcom/a9/vs/mobile/library/impl/jni/Point3d;)V
.end method

.method public static final native CameraMemsMeasurement_m_timeSinceInit_get(JLcom/a9/vs/mobile/library/impl/jni/CameraMemsMeasurement;)D
.end method

.method public static final native CameraMemsMeasurement_m_timeSinceInit_set(JLcom/a9/vs/mobile/library/impl/jni/CameraMemsMeasurement;D)V
.end method

.method public static final native CameraResRequirement_maxHeight_get(JLcom/a9/vs/mobile/library/impl/jni/CameraResRequirement;)I
.end method

.method public static final native CameraResRequirement_maxHeight_set(JLcom/a9/vs/mobile/library/impl/jni/CameraResRequirement;I)V
.end method

.method public static final native CameraResRequirement_minHeight_get(JLcom/a9/vs/mobile/library/impl/jni/CameraResRequirement;)I
.end method

.method public static final native CameraResRequirement_minHeight_set(JLcom/a9/vs/mobile/library/impl/jni/CameraResRequirement;I)V
.end method

.method public static final native CardRegion_bottom_get(JLcom/a9/vs/mobile/library/impl/jni/CardRegion;)I
.end method

.method public static final native CardRegion_bottom_set(JLcom/a9/vs/mobile/library/impl/jni/CardRegion;I)V
.end method

.method public static final native CardRegion_left_get(JLcom/a9/vs/mobile/library/impl/jni/CardRegion;)I
.end method

.method public static final native CardRegion_left_set(JLcom/a9/vs/mobile/library/impl/jni/CardRegion;I)V
.end method

.method public static final native CardRegion_right_get(JLcom/a9/vs/mobile/library/impl/jni/CardRegion;)I
.end method

.method public static final native CardRegion_right_set(JLcom/a9/vs/mobile/library/impl/jni/CardRegion;I)V
.end method

.method public static final native CardRegion_top_get(JLcom/a9/vs/mobile/library/impl/jni/CardRegion;)I
.end method

.method public static final native CardRegion_top_set(JLcom/a9/vs/mobile/library/impl/jni/CardRegion;I)V
.end method

.method public static final native CreditCardInfo_cardDateAlternatives_get(JLcom/a9/vs/mobile/library/impl/jni/CreditCardInfo;)J
.end method

.method public static final native CreditCardInfo_cardDateAlternatives_set(JLcom/a9/vs/mobile/library/impl/jni/CreditCardInfo;JLcom/a9/vs/mobile/library/impl/jni/VectorOfString;)V
.end method

.method public static final native CreditCardInfo_cardHolderName_get(JLcom/a9/vs/mobile/library/impl/jni/CreditCardInfo;)Ljava/lang/String;
.end method

.method public static final native CreditCardInfo_cardHolderName_set(JLcom/a9/vs/mobile/library/impl/jni/CreditCardInfo;Ljava/lang/String;)V
.end method

.method public static final native CreditCardInfo_cardNumberAlternatives_get(JLcom/a9/vs/mobile/library/impl/jni/CreditCardInfo;)J
.end method

.method public static final native CreditCardInfo_cardNumberAlternatives_set(JLcom/a9/vs/mobile/library/impl/jni/CreditCardInfo;JLcom/a9/vs/mobile/library/impl/jni/VectorOfString;)V
.end method

.method public static final native CreditCardInfo_cardNumber_get(JLcom/a9/vs/mobile/library/impl/jni/CreditCardInfo;)Ljava/lang/String;
.end method

.method public static final native CreditCardInfo_cardNumber_set(JLcom/a9/vs/mobile/library/impl/jni/CreditCardInfo;Ljava/lang/String;)V
.end method

.method public static final native CreditCardInfo_expirationDate_get(JLcom/a9/vs/mobile/library/impl/jni/CreditCardInfo;)Ljava/lang/String;
.end method

.method public static final native CreditCardInfo_expirationDate_set(JLcom/a9/vs/mobile/library/impl/jni/CreditCardInfo;Ljava/lang/String;)V
.end method

.method public static final native CreditCardInfo_type_get(JLcom/a9/vs/mobile/library/impl/jni/CreditCardInfo;)Ljava/lang/String;
.end method

.method public static final native CreditCardInfo_type_set(JLcom/a9/vs/mobile/library/impl/jni/CreditCardInfo;Ljava/lang/String;)V
.end method

.method public static final native CreditCardProcessProperty_autoFlip_get(JLcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;)Z
.end method

.method public static final native CreditCardProcessProperty_autoFlip_set(JLcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;Z)V
.end method

.method public static final native CreditCardProcessProperty_cameraMode_get(JLcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;)I
.end method

.method public static final native CreditCardProcessProperty_cameraMode_set(JLcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;I)V
.end method

.method public static final native CreditCardProcessProperty_multiThread_get(JLcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;)Z
.end method

.method public static final native CreditCardProcessProperty_multiThread_set(JLcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;Z)V
.end method

.method public static final native CreditCardProcessProperty_orient_get(JLcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;)I
.end method

.method public static final native CreditCardProcessProperty_orient_set(JLcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;I)V
.end method

.method public static final native CreditCardProcessProperty_readDate_get(JLcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;)Z
.end method

.method public static final native CreditCardProcessProperty_readDate_set(JLcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;Z)V
.end method

.method public static final native CreditCardProcessProperty_scanMode_get(JLcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;)I
.end method

.method public static final native CreditCardProcessProperty_scanMode_set(JLcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;I)V
.end method

.method public static final native CreditCardReaderDelegateBase_change_ownership(Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;JZ)V
.end method

.method public static final native CreditCardReaderDelegateBase_detectBlackScreen(JLcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;)V
.end method

.method public static final native CreditCardReaderDelegateBase_detectBlackScreenSwigExplicitCreditCardReaderDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;)V
.end method

.method public static final native CreditCardReaderDelegateBase_detectCard(JLcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;I)V
.end method

.method public static final native CreditCardReaderDelegateBase_detectCardPromising(JLcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;)V
.end method

.method public static final native CreditCardReaderDelegateBase_detectCardPromisingSwigExplicitCreditCardReaderDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;)V
.end method

.method public static final native CreditCardReaderDelegateBase_detectCardStabilized(JLcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;)V
.end method

.method public static final native CreditCardReaderDelegateBase_detectCardStabilizedSwigExplicitCreditCardReaderDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;)V
.end method

.method public static final native CreditCardReaderDelegateBase_detectCardSwigExplicitCreditCardReaderDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;I)V
.end method

.method public static final native CreditCardReaderDelegateBase_detectDarkScene(JLcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;)V
.end method

.method public static final native CreditCardReaderDelegateBase_detectDarkSceneSwigExplicitCreditCardReaderDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;)V
.end method

.method public static final native CreditCardReaderDelegateBase_director_connect(Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;JZZ)V
.end method

.method public static final native CreditCardReaderDelegateBase_recognizeCreditCard(JLcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;JLcom/a9/vs/mobile/library/impl/jni/CreditCardInfo;)V
.end method

.method public static final native CreditCardReaderDelegateBase_recognizeCreditCardSwigExplicitCreditCardReaderDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;JLcom/a9/vs/mobile/library/impl/jni/CreditCardInfo;)V
.end method

.method public static final native CreditCardReaderFacade_generateReportAndClear(JLcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToUInt;JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;)V
.end method

.method public static final native CreditCardReaderFacade_getCreditCardImage(JLcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;JLcom/a9/vs/mobile/library/impl/jni/ImageByteData;)V
.end method

.method public static final native CreditCardReaderFacade_getOptimalSize__SWIG_0(JLcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;IIJLcom/a9/vs/mobile/library/impl/jni/CardRegion;)V
.end method

.method public static final native CreditCardReaderFacade_getOptimalSize__SWIG_1(JLcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;IIIJLcom/a9/vs/mobile/library/impl/jni/CardRegion;)V
.end method

.method public static final native CreditCardReaderFacade_loadDigitModel(JLcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;Ljava/lang/String;)Z
.end method

.method public static final native CreditCardReaderFacade_process(JLcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;[BIIIIII)V
.end method

.method public static final native CreditCardReaderFacade_setDelegate(JLcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;JLcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;)V
.end method

.method public static final native CreditCardReaderFacade_setOrientation(JLcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;I)V
.end method

.method public static final native CreditCardReaderFacade_start(JLcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;)V
.end method

.method public static final native CreditCardReaderFacade_stop(JLcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;)V
.end method

.method public static final native EventDelegateBase_change_ownership(Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;JZ)V
.end method

.method public static final native EventDelegateBase_didDecode(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)V
.end method

.method public static final native EventDelegateBase_didDecodeFreeText(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;JLcom/a9/vs/mobile/library/impl/jni/VectorOfString;JLcom/a9/vs/mobile/library/impl/jni/VectorOfString;Ljava/lang/String;)V
.end method

.method public static final native EventDelegateBase_didDecodeFreeTextSwigExplicitEventDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;JLcom/a9/vs/mobile/library/impl/jni/VectorOfString;JLcom/a9/vs/mobile/library/impl/jni/VectorOfString;Ljava/lang/String;)V
.end method

.method public static final native EventDelegateBase_didDecodeSwigExplicitEventDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)V
.end method

.method public static final native EventDelegateBase_didDecodeTextCanvas(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;ILjava/lang/String;)V
.end method

.method public static final native EventDelegateBase_didDecodeTextCanvasSwigExplicitEventDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;ILjava/lang/String;)V
.end method

.method public static final native EventDelegateBase_didDetect(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)V
.end method

.method public static final native EventDelegateBase_didDetectInterestPoints(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;JLcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;)V
.end method

.method public static final native EventDelegateBase_didDetectInterestPointsSwigExplicitEventDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;JLcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;)V
.end method

.method public static final native EventDelegateBase_didDetectSwigExplicitEventDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)V
.end method

.method public static final native EventDelegateBase_didProcessFrame(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;IIII)V
.end method

.method public static final native EventDelegateBase_didProcessFrameDecision(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;ID)V
.end method

.method public static final native EventDelegateBase_didProcessFrameDecisionSwigExplicitEventDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;ID)V
.end method

.method public static final native EventDelegateBase_didProcessFrameSwigExplicitEventDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;IIII)V
.end method

.method public static final native EventDelegateBase_didProcessModuleDecision(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;II)V
.end method

.method public static final native EventDelegateBase_didProcessModuleDecisionSwigExplicitEventDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;II)V
.end method

.method public static final native EventDelegateBase_didReceieveBadTextCanvasDecode(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;)V
.end method

.method public static final native EventDelegateBase_didReceieveBadTextCanvasDecodeSwigExplicitEventDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;)V
.end method

.method public static final native EventDelegateBase_didReceiveEvent(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;III)V
.end method

.method public static final native EventDelegateBase_didReceiveEventSwigExplicitEventDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;III)V
.end method

.method public static final native EventDelegateBase_didReceiveServerError(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;II)V
.end method

.method public static final native EventDelegateBase_didReceiveServerErrorSwigExplicitEventDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;II)V
.end method

.method public static final native EventDelegateBase_didStopTrackingTextCanvas(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)V
.end method

.method public static final native EventDelegateBase_didStopTrackingTextCanvasSwigExplicitEventDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)V
.end method

.method public static final native EventDelegateBase_didTrack(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;IJLcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;)V
.end method

.method public static final native EventDelegateBase_didTrackFail(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;I)V
.end method

.method public static final native EventDelegateBase_didTrackFailSwigExplicitEventDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;I)V
.end method

.method public static final native EventDelegateBase_didTrackSwigExplicitEventDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;IJLcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;)V
.end method

.method public static final native EventDelegateBase_didTrackTextCanvas(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)V
.end method

.method public static final native EventDelegateBase_didTrackTextCanvasSwigExplicitEventDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)V
.end method

.method public static final native EventDelegateBase_didUpdateTextCanvas(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)V
.end method

.method public static final native EventDelegateBase_didUpdateTextCanvasSwigExplicitEventDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)V
.end method

.method public static final native EventDelegateBase_didVerify(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;I)V
.end method

.method public static final native EventDelegateBase_didVerifySwigExplicitEventDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;I)V
.end method

.method public static final native EventDelegateBase_director_connect(Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;JZZ)V
.end method

.method public static final native EventDelegateBase_showMessage(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;Ljava/lang/String;)V
.end method

.method public static final native EventDelegateBase_showMessageSwigExplicitEventDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;Ljava/lang/String;)V
.end method

.method public static final native EventDelegateBase_suggestBoringEvent(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;)V
.end method

.method public static final native EventDelegateBase_suggestBoringEventSwigExplicitEventDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;)V
.end method

.method public static final native EventDelegateBase_suggestStuckEvent(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;)V
.end method

.method public static final native EventDelegateBase_suggestStuckEventSwigExplicitEventDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;)V
.end method

.method public static final native ExtraFrameData_flat_get(JLcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;)Z
.end method

.method public static final native ExtraFrameData_flat_set(JLcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;Z)V
.end method

.method public static final native ExtraFrameData_heightDisp_get(JLcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;)I
.end method

.method public static final native ExtraFrameData_heightDisp_set(JLcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;I)V
.end method

.method public static final native ExtraFrameData_screenOrient_get(JLcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;)I
.end method

.method public static final native ExtraFrameData_screenOrient_set(JLcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;I)V
.end method

.method public static final native ExtraFrameData_timeSinceInit_get(JLcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;)D
.end method

.method public static final native ExtraFrameData_timeSinceInit_set(JLcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;D)V
.end method

.method public static final native ExtraFrameData_widthDisp_get(JLcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;)I
.end method

.method public static final native ExtraFrameData_widthDisp_set(JLcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;I)V
.end method

.method public static final native ExtraFrameData_xDisp_get(JLcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;)I
.end method

.method public static final native ExtraFrameData_xDisp_set(JLcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;I)V
.end method

.method public static final native ExtraFrameData_yDisp_get(JLcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;)I
.end method

.method public static final native ExtraFrameData_yDisp_set(JLcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;I)V
.end method

.method public static final native FlowStateEngineFacade_addObjectModule__SWIG_0(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;IJLcom/a9/vs/mobile/library/impl/jni/ServerDelegate;)V
.end method

.method public static final native FlowStateEngineFacade_addObjectModule__SWIG_1(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;IJLcom/a9/vs/mobile/library/impl/jni/ServerDelegate;Ljava/lang/String;)V
.end method

.method public static final native FlowStateEngineFacade_addObjectModule__SWIG_2(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;IJLcom/a9/vs/mobile/library/impl/jni/ServerDelegate;JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;)V
.end method

.method public static final native FlowStateEngineFacade_enableEventLogging(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;)V
.end method

.method public static final native FlowStateEngineFacade_getAndClearMetrics(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToUInt;JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;Z)V
.end method

.method public static final native FlowStateEngineFacade_getCameraResRequirement(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;JLcom/a9/vs/mobile/library/impl/jni/CameraResRequirement;)V
.end method

.method public static final native FlowStateEngineFacade_getDecodeFrame(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;Ljava/lang/String;JLcom/a9/vs/mobile/library/impl/jni/ImageByteData;Z)Z
.end method

.method public static final native FlowStateEngineFacade_getRequestImageBuffers(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;JLcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;JLcom/a9/vs/mobile/library/impl/jni/FrameID;)V
.end method

.method public static final native FlowStateEngineFacade_getRequestImageDefs(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;JLcom/a9/vs/mobile/library/impl/jni/VectorOfImageDef;)V
.end method

.method public static final native FlowStateEngineFacade_pauseEngine(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;)V
.end method

.method public static final native FlowStateEngineFacade_process__SWIG_0(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;JLcom/a9/vs/mobile/library/impl/jni/ImageBuffer;JLcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;JLcom/a9/vs/mobile/library/impl/jni/SensorData;)V
.end method

.method public static final native FlowStateEngineFacade_process__SWIG_1(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;Ljava/lang/String;JLcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;JLcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;JLcom/a9/vs/mobile/library/impl/jni/SensorData;)V
.end method

.method public static final native FlowStateEngineFacade_readObjectModuleProps__SWIG_0(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;ILjava/lang/String;)V
.end method

.method public static final native FlowStateEngineFacade_readObjectModuleProps__SWIG_1(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;IJLcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;)V
.end method

.method public static final native FlowStateEngineFacade_readProps(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;Ljava/lang/String;)V
.end method

.method public static final native FlowStateEngineFacade_removeAllObjectModules(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;)V
.end method

.method public static final native FlowStateEngineFacade_removeObject(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;I)V
.end method

.method public static final native FlowStateEngineFacade_removeObjectModule(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;I)V
.end method

.method public static final native FlowStateEngineFacade_resumeEngine(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;)V
.end method

.method public static final native FlowStateEngineFacade_saveEventLog(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;Ljava/lang/String;)V
.end method

.method public static final native FlowStateEngineFacade_setLanguage(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;Ljava/lang/String;)V
.end method

.method public static final native FlowStateEngineFacade_setZipcodeDatabase(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;Ljava/lang/String;)V
.end method

.method public static final native FlowStateEngineFacade_setupLocalTextRecognitionEngine(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;Ljava/lang/String;)V
.end method

.method public static final native FlowStateEngineFacade_signalStrongNetworkConnection(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;)V
.end method

.method public static final native FlowStateEngineFacade_signalWeakNetworkConnection(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;)V
.end method

.method public static final native FlowStateEngineFacade_startEngine(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;)V
.end method

.method public static final native FlowStateEngineFacade_stopEngine(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;)V
.end method

.method public static final native FrameID_id_get(JLcom/a9/vs/mobile/library/impl/jni/FrameID;)Ljava/lang/String;
.end method

.method public static final native FrameID_id_set(JLcom/a9/vs/mobile/library/impl/jni/FrameID;Ljava/lang/String;)V
.end method

.method public static final native ImageBuffer_allocLen_get(JLcom/a9/vs/mobile/library/impl/jni/ImageBuffer;)I
.end method

.method public static final native ImageBuffer_allocLen_set(JLcom/a9/vs/mobile/library/impl/jni/ImageBuffer;I)V
.end method

.method public static final native ImageBuffer_data_get(JLcom/a9/vs/mobile/library/impl/jni/ImageBuffer;)J
.end method

.method public static final native ImageBuffer_data_set(JLcom/a9/vs/mobile/library/impl/jni/ImageBuffer;J)V
.end method

.method public static final native ImageBuffer_definition_get(JLcom/a9/vs/mobile/library/impl/jni/ImageBuffer;)I
.end method

.method public static final native ImageBuffer_definition_set(JLcom/a9/vs/mobile/library/impl/jni/ImageBuffer;I)V
.end method

.method public static final native ImageBuffer_fillBuffer(JLcom/a9/vs/mobile/library/impl/jni/ImageBuffer;[BI)I
.end method

.method public static final native ImageBuffer_format_get(JLcom/a9/vs/mobile/library/impl/jni/ImageBuffer;)I
.end method

.method public static final native ImageBuffer_format_set(JLcom/a9/vs/mobile/library/impl/jni/ImageBuffer;I)V
.end method

.method public static final native ImageBuffer_height_get(JLcom/a9/vs/mobile/library/impl/jni/ImageBuffer;)I
.end method

.method public static final native ImageBuffer_height_set(JLcom/a9/vs/mobile/library/impl/jni/ImageBuffer;I)V
.end method

.method public static final native ImageBuffer_numChannels_get(JLcom/a9/vs/mobile/library/impl/jni/ImageBuffer;)I
.end method

.method public static final native ImageBuffer_numChannels_set(JLcom/a9/vs/mobile/library/impl/jni/ImageBuffer;I)V
.end method

.method public static final native ImageBuffer_widthStep_get(JLcom/a9/vs/mobile/library/impl/jni/ImageBuffer;)I
.end method

.method public static final native ImageBuffer_widthStep_set(JLcom/a9/vs/mobile/library/impl/jni/ImageBuffer;I)V
.end method

.method public static final native ImageBuffer_width_get(JLcom/a9/vs/mobile/library/impl/jni/ImageBuffer;)I
.end method

.method public static final native ImageBuffer_width_set(JLcom/a9/vs/mobile/library/impl/jni/ImageBuffer;I)V
.end method

.method public static final native ImageByteData_getData(JLcom/a9/vs/mobile/library/impl/jni/ImageByteData;)[B
.end method

.method public static final native ImageByteData_getHeight(JLcom/a9/vs/mobile/library/impl/jni/ImageByteData;)I
.end method

.method public static final native ImageByteData_getLength(JLcom/a9/vs/mobile/library/impl/jni/ImageByteData;)I
.end method

.method public static final native ImageByteData_getWidth(JLcom/a9/vs/mobile/library/impl/jni/ImageByteData;)I
.end method

.method public static final native MapOfStringToDouble_clear(JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;)V
.end method

.method public static final native MapOfStringToDouble_del(JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;Ljava/lang/String;)V
.end method

.method public static final native MapOfStringToDouble_empty(JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;)Z
.end method

.method public static final native MapOfStringToDouble_get(JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;Ljava/lang/String;)D
.end method

.method public static final native MapOfStringToDouble_getKeysForDoubleMap(JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;)J
.end method

.method public static final native MapOfStringToDouble_has_key(JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;Ljava/lang/String;)Z
.end method

.method public static final native MapOfStringToDouble_set(JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;Ljava/lang/String;D)V
.end method

.method public static final native MapOfStringToDouble_size(JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;)J
.end method

.method public static final native MapOfStringToString_clear(JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;)V
.end method

.method public static final native MapOfStringToString_del(JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;Ljava/lang/String;)V
.end method

.method public static final native MapOfStringToString_empty(JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;)Z
.end method

.method public static final native MapOfStringToString_get(JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;Ljava/lang/String;)Ljava/lang/String;
.end method

.method public static final native MapOfStringToString_getKeys(JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;)J
.end method

.method public static final native MapOfStringToString_has_key(JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;Ljava/lang/String;)Z
.end method

.method public static final native MapOfStringToString_set(JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;Ljava/lang/String;Ljava/lang/String;)V
.end method

.method public static final native MapOfStringToString_size(JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;)J
.end method

.method public static final native MapOfStringToUInt_clear(JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToUInt;)V
.end method

.method public static final native MapOfStringToUInt_del(JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToUInt;Ljava/lang/String;)V
.end method

.method public static final native MapOfStringToUInt_empty(JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToUInt;)Z
.end method

.method public static final native MapOfStringToUInt_get(JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToUInt;Ljava/lang/String;)J
.end method

.method public static final native MapOfStringToUInt_getKeysForIntMap(JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToUInt;)J
.end method

.method public static final native MapOfStringToUInt_has_key(JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToUInt;Ljava/lang/String;)Z
.end method

.method public static final native MapOfStringToUInt_set(JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToUInt;Ljava/lang/String;J)V
.end method

.method public static final native MapOfStringToUInt_size(JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToUInt;)J
.end method

.method public static final native MobileUtils_getDataDumpLocation()Ljava/lang/String;
.end method

.method public static final native MobileUtils_setDataDumpLocation(Ljava/lang/String;)V
.end method

.method public static final native MobileUtils_setupLogging(Ljava/lang/String;Z)Z
.end method

.method public static final native MobileUtils_testNEON(JLcom/a9/vs/mobile/library/impl/jni/NEONAccelerationResult;)V
.end method

.method public static final native NEONAccelerationResult_resultStr_get(JLcom/a9/vs/mobile/library/impl/jni/NEONAccelerationResult;)Ljava/lang/String;
.end method

.method public static final native NEONAccelerationResult_resultStr_set(JLcom/a9/vs/mobile/library/impl/jni/NEONAccelerationResult;Ljava/lang/String;)V
.end method

.method public static final native Name_first_get(JLcom/a9/vs/mobile/library/impl/jni/Name;)Ljava/lang/String;
.end method

.method public static final native Name_first_set(JLcom/a9/vs/mobile/library/impl/jni/Name;Ljava/lang/String;)V
.end method

.method public static final native Name_isVerified_get(JLcom/a9/vs/mobile/library/impl/jni/Name;)Z
.end method

.method public static final native Name_isVerified_set(JLcom/a9/vs/mobile/library/impl/jni/Name;Z)V
.end method

.method public static final native Name_last_get(JLcom/a9/vs/mobile/library/impl/jni/Name;)Ljava/lang/String;
.end method

.method public static final native Name_last_set(JLcom/a9/vs/mobile/library/impl/jni/Name;Ljava/lang/String;)V
.end method

.method public static final native Name_middle_get(JLcom/a9/vs/mobile/library/impl/jni/Name;)Ljava/lang/String;
.end method

.method public static final native Name_middle_set(JLcom/a9/vs/mobile/library/impl/jni/Name;Ljava/lang/String;)V
.end method

.method public static final native ObjectInfo_alternatives_get(JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)J
.end method

.method public static final native ObjectInfo_alternatives_set(JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;JLcom/a9/vs/mobile/library/impl/jni/VectorOfString;)V
.end method

.method public static final native ObjectInfo_content_get(JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)Ljava/lang/String;
.end method

.method public static final native ObjectInfo_content_set(JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;Ljava/lang/String;)V
.end method

.method public static final native ObjectInfo_entityType_get(JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)Ljava/lang/String;
.end method

.method public static final native ObjectInfo_entityType_set(JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;Ljava/lang/String;)V
.end method

.method public static final native ObjectInfo_id_get(JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)I
.end method

.method public static final native ObjectInfo_id_set(JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;I)V
.end method

.method public static final native ObjectInfo_location_get(JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)J
.end method

.method public static final native ObjectInfo_location_set(JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;JLcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;)V
.end method

.method public static final native ObjectInfo_objType_get(JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)I
.end method

.method public static final native ObjectInfo_objType_set(JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;I)V
.end method

.method public static final native ObjectInfo_queryID_get(JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)Ljava/lang/String;
.end method

.method public static final native ObjectInfo_queryID_set(JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;Ljava/lang/String;)V
.end method

.method public static final native ObjectInfo_queryStr_get(JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)Ljava/lang/String;
.end method

.method public static final native ObjectInfo_queryStr_set(JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;Ljava/lang/String;)V
.end method

.method public static final native ObjectInfo_score_get(JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)F
.end method

.method public static final native ObjectInfo_score_set(JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;F)V
.end method

.method public static final native ObjectInfo_tag_get(JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)Ljava/lang/String;
.end method

.method public static final native ObjectInfo_tag_set(JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;Ljava/lang/String;)V
.end method

.method public static final native ObjectInfo_uniqueID_get(JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)Ljava/lang/String;
.end method

.method public static final native ObjectInfo_uniqueID_set(JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;Ljava/lang/String;)V
.end method

.method public static final native Point2f_x_get(JLcom/a9/vs/mobile/library/impl/jni/Point2f;)F
.end method

.method public static final native Point2f_x_set(JLcom/a9/vs/mobile/library/impl/jni/Point2f;F)V
.end method

.method public static final native Point2f_y_get(JLcom/a9/vs/mobile/library/impl/jni/Point2f;)F
.end method

.method public static final native Point2f_y_set(JLcom/a9/vs/mobile/library/impl/jni/Point2f;F)V
.end method

.method public static final native Point3d_x_get(JLcom/a9/vs/mobile/library/impl/jni/Point3d;)D
.end method

.method public static final native Point3d_x_set(JLcom/a9/vs/mobile/library/impl/jni/Point3d;D)V
.end method

.method public static final native Point3d_y_get(JLcom/a9/vs/mobile/library/impl/jni/Point3d;)D
.end method

.method public static final native Point3d_y_set(JLcom/a9/vs/mobile/library/impl/jni/Point3d;D)V
.end method

.method public static final native Point3d_z_get(JLcom/a9/vs/mobile/library/impl/jni/Point3d;)D
.end method

.method public static final native Point3d_z_set(JLcom/a9/vs/mobile/library/impl/jni/Point3d;D)V
.end method

.method public static final native SensorData_rawAccData_get(JLcom/a9/vs/mobile/library/impl/jni/SensorData;)J
.end method

.method public static final native SensorData_rawAccData_set(JLcom/a9/vs/mobile/library/impl/jni/SensorData;JLcom/a9/vs/mobile/library/impl/jni/VectorOfFlowCameraAccelerometerMeasurement;)V
.end method

.method public static final native SensorData_rawGyroData_get(JLcom/a9/vs/mobile/library/impl/jni/SensorData;)J
.end method

.method public static final native SensorData_rawGyroData_set(JLcom/a9/vs/mobile/library/impl/jni/SensorData;JLcom/a9/vs/mobile/library/impl/jni/VectorOfFlowCameraGyroMeasurement;)V
.end method

.method public static final native SensorData_rawSensorData_get(JLcom/a9/vs/mobile/library/impl/jni/SensorData;)J
.end method

.method public static final native SensorData_rawSensorData_set(JLcom/a9/vs/mobile/library/impl/jni/SensorData;JLcom/a9/vs/mobile/library/impl/jni/VectorOfFlowCameraMemsMeasurement;)V
.end method

.method public static final native ServerDelegateInterface_sendServerRequest(JLcom/a9/vs/mobile/library/impl/jni/ServerDelegateInterface;JLcom/a9/vs/mobile/library/impl/jni/ServerRequest;)Z
.end method

.method public static final native ServerDelegate_SWIGUpcast(J)J
.end method

.method public static final native ServerDelegate_change_ownership(Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;JZ)V
.end method

.method public static final native ServerDelegate_director_connect(Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;JZZ)V
.end method

.method public static final native ServerDelegate_pushServerResponse(JLcom/a9/vs/mobile/library/impl/jni/ServerDelegate;JLcom/a9/vs/mobile/library/impl/jni/ServerResponse;)V
.end method

.method public static final native ServerDelegate_sendServerRequest(JLcom/a9/vs/mobile/library/impl/jni/ServerDelegate;JLcom/a9/vs/mobile/library/impl/jni/ServerRequest;)Z
.end method

.method public static final native ServerDelegate_sendServerRequestImpl(JLcom/a9/vs/mobile/library/impl/jni/ServerDelegate;JLcom/a9/vs/mobile/library/impl/jni/ServerRequest;)Z
.end method

.method public static final native ServerDelegate_sendServerRequestSwigExplicitServerDelegate(JLcom/a9/vs/mobile/library/impl/jni/ServerDelegate;JLcom/a9/vs/mobile/library/impl/jni/ServerRequest;)Z
.end method

.method public static final native ServerRequest_clear(JLcom/a9/vs/mobile/library/impl/jni/ServerRequest;)V
.end method

.method public static final native ServerRequest_data_get(JLcom/a9/vs/mobile/library/impl/jni/ServerRequest;)J
.end method

.method public static final native ServerRequest_data_set(JLcom/a9/vs/mobile/library/impl/jni/ServerRequest;JLcom/a9/vs/mobile/library/impl/jni/ByteArray;)V
.end method

.method public static final native ServerRequest_id_get(JLcom/a9/vs/mobile/library/impl/jni/ServerRequest;)Ljava/lang/String;
.end method

.method public static final native ServerRequest_id_set(JLcom/a9/vs/mobile/library/impl/jni/ServerRequest;Ljava/lang/String;)V
.end method

.method public static final native ServerRequest_metadata_get(JLcom/a9/vs/mobile/library/impl/jni/ServerRequest;)J
.end method

.method public static final native ServerRequest_metadata_set(JLcom/a9/vs/mobile/library/impl/jni/ServerRequest;JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;)V
.end method

.method public static final native ServerRequest_params_get(JLcom/a9/vs/mobile/library/impl/jni/ServerRequest;)J
.end method

.method public static final native ServerRequest_params_set(JLcom/a9/vs/mobile/library/impl/jni/ServerRequest;JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;)V
.end method

.method public static final native ServerRequest_responseHandler_get(JLcom/a9/vs/mobile/library/impl/jni/ServerRequest;)J
.end method

.method public static final native ServerRequest_responseHandler_set(JLcom/a9/vs/mobile/library/impl/jni/ServerRequest;JLcom/a9/vs/mobile/library/impl/jni/ServerResponseHandler;)V
.end method

.method public static final native ServerResponseHandler_handleServerResponse(JLcom/a9/vs/mobile/library/impl/jni/ServerResponseHandler;JLcom/a9/vs/mobile/library/impl/jni/ServerResponse;)V
.end method

.method public static final native ServerResponse_compressed_get(JLcom/a9/vs/mobile/library/impl/jni/ServerResponse;)Z
.end method

.method public static final native ServerResponse_compressed_set(JLcom/a9/vs/mobile/library/impl/jni/ServerResponse;Z)V
.end method

.method public static final native ServerResponse_id_get(JLcom/a9/vs/mobile/library/impl/jni/ServerResponse;)Ljava/lang/String;
.end method

.method public static final native ServerResponse_id_set(JLcom/a9/vs/mobile/library/impl/jni/ServerResponse;Ljava/lang/String;)V
.end method

.method public static final native ServerResponse_responseStr_get(JLcom/a9/vs/mobile/library/impl/jni/ServerResponse;)Ljava/lang/String;
.end method

.method public static final native ServerResponse_responseStr_set(JLcom/a9/vs/mobile/library/impl/jni/ServerResponse;Ljava/lang/String;)V
.end method

.method public static final native ServerResponse_responseType_get(JLcom/a9/vs/mobile/library/impl/jni/ServerResponse;)I
.end method

.method public static final native ServerResponse_responseType_set(JLcom/a9/vs/mobile/library/impl/jni/ServerResponse;I)V
.end method

.method public static final native ServerResponse_roundtripTime_get(JLcom/a9/vs/mobile/library/impl/jni/ServerResponse;)D
.end method

.method public static final native ServerResponse_roundtripTime_set(JLcom/a9/vs/mobile/library/impl/jni/ServerResponse;D)V
.end method

.method public static final native StringPair_first_get(JLcom/a9/vs/mobile/library/impl/jni/StringPair;)Ljava/lang/String;
.end method

.method public static final native StringPair_first_set(JLcom/a9/vs/mobile/library/impl/jni/StringPair;Ljava/lang/String;)V
.end method

.method public static final native StringPair_second_get(JLcom/a9/vs/mobile/library/impl/jni/StringPair;)Ljava/lang/String;
.end method

.method public static final native StringPair_second_set(JLcom/a9/vs/mobile/library/impl/jni/StringPair;Ljava/lang/String;)V
.end method

.method public static SwigDirector_CreditCardReaderDelegateBase_detectBlackScreen(Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;)V
    .locals 0
    .param p0, "self"    # Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;

    .prologue
    .line 678
    invoke-virtual {p0}, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;->detectBlackScreen()V

    .line 679
    return-void
.end method

.method public static SwigDirector_CreditCardReaderDelegateBase_detectCard(Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;I)V
    .locals 0
    .param p0, "self"    # Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;
    .param p1, "detectedCardLines"    # I

    .prologue
    .line 666
    invoke-virtual {p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;->detectCard(I)V

    .line 667
    return-void
.end method

.method public static SwigDirector_CreditCardReaderDelegateBase_detectCardPromising(Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;)V
    .locals 0
    .param p0, "self"    # Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;

    .prologue
    .line 672
    invoke-virtual {p0}, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;->detectCardPromising()V

    .line 673
    return-void
.end method

.method public static SwigDirector_CreditCardReaderDelegateBase_detectCardStabilized(Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;)V
    .locals 0
    .param p0, "self"    # Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;

    .prologue
    .line 669
    invoke-virtual {p0}, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;->detectCardStabilized()V

    .line 670
    return-void
.end method

.method public static SwigDirector_CreditCardReaderDelegateBase_detectDarkScene(Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;)V
    .locals 0
    .param p0, "self"    # Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;

    .prologue
    .line 681
    invoke-virtual {p0}, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;->detectDarkScene()V

    .line 682
    return-void
.end method

.method public static SwigDirector_CreditCardReaderDelegateBase_recognizeCreditCard(Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;J)V
    .locals 2
    .param p0, "self"    # Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;
    .param p1, "result"    # J

    .prologue
    .line 675
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardInfo;

    const/4 v1, 0x0

    invoke-direct {v0, p1, p2, v1}, Lcom/a9/vs/mobile/library/impl/jni/CreditCardInfo;-><init>(JZ)V

    invoke-virtual {p0, v0}, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;->recognizeCreditCard(Lcom/a9/vs/mobile/library/impl/jni/CreditCardInfo;)V

    .line 676
    return-void
.end method

.method public static SwigDirector_EventDelegateBase_didDecode(Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;J)V
    .locals 2
    .param p0, "self"    # Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;
    .param p1, "objInfoOut"    # J

    .prologue
    .line 609
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;

    const/4 v1, 0x0

    invoke-direct {v0, p1, p2, v1}, Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;-><init>(JZ)V

    invoke-virtual {p0, v0}, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->didDecode(Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)V

    .line 610
    return-void
.end method

.method public static SwigDirector_EventDelegateBase_didDecodeFreeText(Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;JJLjava/lang/String;)V
    .locals 3
    .param p0, "self"    # Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;
    .param p1, "nounsBrandsModelnums"    # J
    .param p3, "words"    # J
    .param p5, "layout"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 621
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;

    invoke-direct {v0, p1, p2, v2}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;-><init>(JZ)V

    new-instance v1, Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;

    invoke-direct {v1, p3, p4, v2}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;-><init>(JZ)V

    invoke-virtual {p0, v0, v1, p5}, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->didDecodeFreeText(Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;Ljava/lang/String;)V

    .line 622
    return-void
.end method

.method public static SwigDirector_EventDelegateBase_didDecodeTextCanvas(Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;ILjava/lang/String;)V
    .locals 0
    .param p0, "self"    # Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;
    .param p1, "sessionId"    # I
    .param p2, "uniqueId"    # Ljava/lang/String;

    .prologue
    .line 627
    invoke-virtual {p0, p1, p2}, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->didDecodeTextCanvas(ILjava/lang/String;)V

    .line 628
    return-void
.end method

.method public static SwigDirector_EventDelegateBase_didDetect(Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;J)V
    .locals 2
    .param p0, "self"    # Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;
    .param p1, "objInfoOut"    # J

    .prologue
    .line 606
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;

    const/4 v1, 0x0

    invoke-direct {v0, p1, p2, v1}, Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;-><init>(JZ)V

    invoke-virtual {p0, v0}, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->didDetect(Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)V

    .line 607
    return-void
.end method

.method public static SwigDirector_EventDelegateBase_didDetectInterestPoints(Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;J)V
    .locals 2
    .param p0, "self"    # Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;
    .param p1, "points"    # J

    .prologue
    .line 624
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;

    const/4 v1, 0x0

    invoke-direct {v0, p1, p2, v1}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;-><init>(JZ)V

    invoke-virtual {p0, v0}, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->didDetectInterestPoints(Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;)V

    .line 625
    return-void
.end method

.method public static SwigDirector_EventDelegateBase_didProcessFrame(Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;IIII)V
    .locals 2
    .param p0, "self"    # Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;
    .param p1, "objectType"    # I
    .param p2, "status"    # I
    .param p3, "processFrameID"    # I
    .param p4, "intentStage"    # I

    .prologue
    .line 603
    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->swigToEnum(I)Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

    move-result-object v0

    invoke-static {p2}, Lcom/a9/vs/mobile/library/impl/jni/StatusID;->swigToEnum(I)Lcom/a9/vs/mobile/library/impl/jni/StatusID;

    move-result-object v1

    invoke-virtual {p0, v0, v1, p3, p4}, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->didProcessFrame(Lcom/a9/vs/mobile/library/impl/jni/ObjectID;Lcom/a9/vs/mobile/library/impl/jni/StatusID;II)V

    .line 604
    return-void
.end method

.method public static SwigDirector_EventDelegateBase_didProcessFrameDecision(Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;ID)V
    .locals 1
    .param p0, "self"    # Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;
    .param p1, "stabilityIssue"    # I
    .param p2, "intentScore"    # D

    .prologue
    .line 654
    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/CameraStabilityIssue;->swigToEnum(I)Lcom/a9/vs/mobile/library/impl/jni/CameraStabilityIssue;

    move-result-object v0

    invoke-virtual {p0, v0, p2, p3}, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->didProcessFrameDecision(Lcom/a9/vs/mobile/library/impl/jni/CameraStabilityIssue;D)V

    .line 655
    return-void
.end method

.method public static SwigDirector_EventDelegateBase_didProcessModuleDecision(Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;II)V
    .locals 2
    .param p0, "self"    # Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;
    .param p1, "objectType"    # I
    .param p2, "judgeOnModule"    # I

    .prologue
    .line 657
    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->swigToEnum(I)Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

    move-result-object v0

    invoke-static {p2}, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;->swigToEnum(I)Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->didProcessModuleDecision(Lcom/a9/vs/mobile/library/impl/jni/ObjectID;Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;)V

    .line 658
    return-void
.end method

.method public static SwigDirector_EventDelegateBase_didReceieveBadTextCanvasDecode(Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;)V
    .locals 0
    .param p0, "self"    # Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;

    .prologue
    .line 639
    invoke-virtual {p0}, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->didReceieveBadTextCanvasDecode()V

    .line 640
    return-void
.end method

.method public static SwigDirector_EventDelegateBase_didReceiveEvent(Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;III)V
    .locals 3
    .param p0, "self"    # Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;
    .param p1, "objectType"    # I
    .param p2, "actionType"    # I
    .param p3, "statID"    # I

    .prologue
    .line 600
    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->swigToEnum(I)Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

    move-result-object v0

    invoke-static {p2}, Lcom/a9/vs/mobile/library/impl/jni/ActionID;->swigToEnum(I)Lcom/a9/vs/mobile/library/impl/jni/ActionID;

    move-result-object v1

    invoke-static {p3}, Lcom/a9/vs/mobile/library/impl/jni/StatusID;->swigToEnum(I)Lcom/a9/vs/mobile/library/impl/jni/StatusID;

    move-result-object v2

    invoke-virtual {p0, v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->didReceiveEvent(Lcom/a9/vs/mobile/library/impl/jni/ObjectID;Lcom/a9/vs/mobile/library/impl/jni/ActionID;Lcom/a9/vs/mobile/library/impl/jni/StatusID;)V

    .line 601
    return-void
.end method

.method public static SwigDirector_EventDelegateBase_didReceiveServerError(Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;II)V
    .locals 2
    .param p0, "self"    # Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;
    .param p1, "objectType"    # I
    .param p2, "reason"    # I

    .prologue
    .line 642
    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->swigToEnum(I)Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

    move-result-object v0

    invoke-static {p2}, Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;->swigToEnum(I)Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->didReceiveServerError(Lcom/a9/vs/mobile/library/impl/jni/ObjectID;Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;)V

    .line 643
    return-void
.end method

.method public static SwigDirector_EventDelegateBase_didStopTrackingTextCanvas(Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;J)V
    .locals 2
    .param p0, "self"    # Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;
    .param p1, "canvas"    # J

    .prologue
    .line 636
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;

    const/4 v1, 0x0

    invoke-direct {v0, p1, p2, v1}, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;-><init>(JZ)V

    invoke-virtual {p0, v0}, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->didStopTrackingTextCanvas(Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)V

    .line 637
    return-void
.end method

.method public static SwigDirector_EventDelegateBase_didTrack(Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;IJ)V
    .locals 2
    .param p0, "self"    # Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;
    .param p1, "id"    # I
    .param p2, "loc"    # J

    .prologue
    .line 612
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;

    const/4 v1, 0x0

    invoke-direct {v0, p2, p3, v1}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;-><init>(JZ)V

    invoke-virtual {p0, p1, v0}, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->didTrack(ILcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;)V

    .line 613
    return-void
.end method

.method public static SwigDirector_EventDelegateBase_didTrackFail(Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;I)V
    .locals 0
    .param p0, "self"    # Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;
    .param p1, "id"    # I

    .prologue
    .line 615
    invoke-virtual {p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->didTrackFail(I)V

    .line 616
    return-void
.end method

.method public static SwigDirector_EventDelegateBase_didTrackTextCanvas(Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;J)V
    .locals 2
    .param p0, "self"    # Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;
    .param p1, "canvas"    # J

    .prologue
    .line 633
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;

    const/4 v1, 0x0

    invoke-direct {v0, p1, p2, v1}, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;-><init>(JZ)V

    invoke-virtual {p0, v0}, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->didTrackTextCanvas(Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)V

    .line 634
    return-void
.end method

.method public static SwigDirector_EventDelegateBase_didUpdateTextCanvas(Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;J)V
    .locals 2
    .param p0, "self"    # Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;
    .param p1, "canvas"    # J

    .prologue
    .line 630
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;

    const/4 v1, 0x0

    invoke-direct {v0, p1, p2, v1}, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;-><init>(JZ)V

    invoke-virtual {p0, v0}, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->didUpdateTextCanvas(Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)V

    .line 631
    return-void
.end method

.method public static SwigDirector_EventDelegateBase_didVerify(Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;I)V
    .locals 0
    .param p0, "self"    # Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;
    .param p1, "id"    # I

    .prologue
    .line 618
    invoke-virtual {p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->didVerify(I)V

    .line 619
    return-void
.end method

.method public static SwigDirector_EventDelegateBase_showMessage(Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;Ljava/lang/String;)V
    .locals 0
    .param p0, "self"    # Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    .line 651
    invoke-virtual {p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->showMessage(Ljava/lang/String;)V

    .line 652
    return-void
.end method

.method public static SwigDirector_EventDelegateBase_suggestBoringEvent(Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;)V
    .locals 0
    .param p0, "self"    # Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;

    .prologue
    .line 648
    invoke-virtual {p0}, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->suggestBoringEvent()V

    .line 649
    return-void
.end method

.method public static SwigDirector_EventDelegateBase_suggestStuckEvent(Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;)V
    .locals 0
    .param p0, "self"    # Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;

    .prologue
    .line 645
    invoke-virtual {p0}, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->suggestStuckEvent()V

    .line 646
    return-void
.end method

.method public static SwigDirector_ServerDelegate_sendServerRequest(Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;J)Z
    .locals 2
    .param p0, "self"    # Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;
    .param p1, "request"    # J

    .prologue
    .line 660
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;

    const/4 v1, 0x0

    invoke-direct {v0, p1, p2, v1}, Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;-><init>(JZ)V

    invoke-virtual {p0, v0}, Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;->sendServerRequest(Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;)Z

    move-result v0

    return v0
.end method

.method public static SwigDirector_ServerDelegate_sendServerRequestImpl(Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;J)Z
    .locals 2
    .param p0, "self"    # Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;
    .param p1, "request"    # J

    .prologue
    .line 663
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;

    const/4 v1, 0x0

    invoke-direct {v0, p1, p2, v1}, Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;-><init>(JZ)V

    invoke-virtual {p0, v0}, Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;->sendServerRequestImpl(Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;)Z

    move-result v0

    return v0
.end method

.method public static final native TextCanvasInfo_allEntities_get(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)J
.end method

.method public static final native TextCanvasInfo_allEntities_set(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;JLcom/a9/vs/mobile/library/impl/jni/VectorOfObjectInfo;)V
.end method

.method public static final native TextCanvasInfo_businessCard_get(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)J
.end method

.method public static final native TextCanvasInfo_businessCard_set(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;JLcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;)V
.end method

.method public static final native TextCanvasInfo_canvasBounds_get(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)J
.end method

.method public static final native TextCanvasInfo_canvasBounds_set(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;JLcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;)V
.end method

.method public static final native TextCanvasInfo_canvasType_get(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)I
.end method

.method public static final native TextCanvasInfo_canvasType_set(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;I)V
.end method

.method public static final native TextCanvasInfo_degreesClockwiseToAlign_get(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)I
.end method

.method public static final native TextCanvasInfo_degreesClockwiseToAlign_set(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;I)V
.end method

.method public static final native TextCanvasInfo_id_get(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)I
.end method

.method public static final native TextCanvasInfo_id_set(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;I)V
.end method

.method public static final native TextCanvasInfo_isVerified_get(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)Z
.end method

.method public static final native TextCanvasInfo_isVerified_set(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;Z)V
.end method

.method public static final native TextCanvasInfo_layout_get(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)Ljava/lang/String;
.end method

.method public static final native TextCanvasInfo_layout_set(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;Ljava/lang/String;)V
.end method

.method public static final native TextCanvasInfo_scaledCanvasBounds_get(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)J
.end method

.method public static final native TextCanvasInfo_scaledCanvasBounds_set(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;JLcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;)V
.end method

.method public static final native TextCanvasInfo_scaledScreenBounds_get(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)J
.end method

.method public static final native TextCanvasInfo_scaledScreenBounds_set(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;JLcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;)V
.end method

.method public static final native TextCanvasInfo_scaledWords_get(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)J
.end method

.method public static final native TextCanvasInfo_scaledWords_set(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;JLcom/a9/vs/mobile/library/impl/jni/VectorOfObjectInfo;)V
.end method

.method public static final native TextCanvasInfo_uniqueID_get(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)Ljava/lang/String;
.end method

.method public static final native TextCanvasInfo_uniqueID_set(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;Ljava/lang/String;)V
.end method

.method public static final native TextCanvasInfo_visibleWords_get(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)J
.end method

.method public static final native TextCanvasInfo_visibleWords_set(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;JLcom/a9/vs/mobile/library/impl/jni/VectorOfObjectInfo;)V
.end method

.method public static final native VectorOfBusinessCardEntities_add(JLcom/a9/vs/mobile/library/impl/jni/VectorOfBusinessCardEntities;JLcom/a9/vs/mobile/library/impl/jni/BusinessCardEntity;)V
.end method

.method public static final native VectorOfBusinessCardEntities_capacity(JLcom/a9/vs/mobile/library/impl/jni/VectorOfBusinessCardEntities;)J
.end method

.method public static final native VectorOfBusinessCardEntities_clear(JLcom/a9/vs/mobile/library/impl/jni/VectorOfBusinessCardEntities;)V
.end method

.method public static final native VectorOfBusinessCardEntities_get(JLcom/a9/vs/mobile/library/impl/jni/VectorOfBusinessCardEntities;I)J
.end method

.method public static final native VectorOfBusinessCardEntities_isEmpty(JLcom/a9/vs/mobile/library/impl/jni/VectorOfBusinessCardEntities;)Z
.end method

.method public static final native VectorOfBusinessCardEntities_reserve(JLcom/a9/vs/mobile/library/impl/jni/VectorOfBusinessCardEntities;J)V
.end method

.method public static final native VectorOfBusinessCardEntities_set(JLcom/a9/vs/mobile/library/impl/jni/VectorOfBusinessCardEntities;IJLcom/a9/vs/mobile/library/impl/jni/BusinessCardEntity;)V
.end method

.method public static final native VectorOfBusinessCardEntities_size(JLcom/a9/vs/mobile/library/impl/jni/VectorOfBusinessCardEntities;)J
.end method

.method public static final native VectorOfDouble_add(JLcom/a9/vs/mobile/library/impl/jni/VectorOfDouble;D)V
.end method

.method public static final native VectorOfDouble_capacity(JLcom/a9/vs/mobile/library/impl/jni/VectorOfDouble;)J
.end method

.method public static final native VectorOfDouble_clear(JLcom/a9/vs/mobile/library/impl/jni/VectorOfDouble;)V
.end method

.method public static final native VectorOfDouble_get(JLcom/a9/vs/mobile/library/impl/jni/VectorOfDouble;I)D
.end method

.method public static final native VectorOfDouble_isEmpty(JLcom/a9/vs/mobile/library/impl/jni/VectorOfDouble;)Z
.end method

.method public static final native VectorOfDouble_reserve(JLcom/a9/vs/mobile/library/impl/jni/VectorOfDouble;J)V
.end method

.method public static final native VectorOfDouble_set(JLcom/a9/vs/mobile/library/impl/jni/VectorOfDouble;ID)V
.end method

.method public static final native VectorOfDouble_size(JLcom/a9/vs/mobile/library/impl/jni/VectorOfDouble;)J
.end method

.method public static final native VectorOfFlowCameraAccelerometerMeasurement_add(JLcom/a9/vs/mobile/library/impl/jni/VectorOfFlowCameraAccelerometerMeasurement;JLcom/a9/vs/mobile/library/impl/jni/CameraAccelerometerMeasurement;)V
.end method

.method public static final native VectorOfFlowCameraAccelerometerMeasurement_capacity(JLcom/a9/vs/mobile/library/impl/jni/VectorOfFlowCameraAccelerometerMeasurement;)J
.end method

.method public static final native VectorOfFlowCameraAccelerometerMeasurement_clear(JLcom/a9/vs/mobile/library/impl/jni/VectorOfFlowCameraAccelerometerMeasurement;)V
.end method

.method public static final native VectorOfFlowCameraAccelerometerMeasurement_get(JLcom/a9/vs/mobile/library/impl/jni/VectorOfFlowCameraAccelerometerMeasurement;I)J
.end method

.method public static final native VectorOfFlowCameraAccelerometerMeasurement_isEmpty(JLcom/a9/vs/mobile/library/impl/jni/VectorOfFlowCameraAccelerometerMeasurement;)Z
.end method

.method public static final native VectorOfFlowCameraAccelerometerMeasurement_reserve(JLcom/a9/vs/mobile/library/impl/jni/VectorOfFlowCameraAccelerometerMeasurement;J)V
.end method

.method public static final native VectorOfFlowCameraAccelerometerMeasurement_set(JLcom/a9/vs/mobile/library/impl/jni/VectorOfFlowCameraAccelerometerMeasurement;IJLcom/a9/vs/mobile/library/impl/jni/CameraAccelerometerMeasurement;)V
.end method

.method public static final native VectorOfFlowCameraAccelerometerMeasurement_size(JLcom/a9/vs/mobile/library/impl/jni/VectorOfFlowCameraAccelerometerMeasurement;)J
.end method

.method public static final native VectorOfFlowCameraGyroMeasurement_add(JLcom/a9/vs/mobile/library/impl/jni/VectorOfFlowCameraGyroMeasurement;JLcom/a9/vs/mobile/library/impl/jni/CameraGyroMeasurement;)V
.end method

.method public static final native VectorOfFlowCameraGyroMeasurement_capacity(JLcom/a9/vs/mobile/library/impl/jni/VectorOfFlowCameraGyroMeasurement;)J
.end method

.method public static final native VectorOfFlowCameraGyroMeasurement_clear(JLcom/a9/vs/mobile/library/impl/jni/VectorOfFlowCameraGyroMeasurement;)V
.end method

.method public static final native VectorOfFlowCameraGyroMeasurement_get(JLcom/a9/vs/mobile/library/impl/jni/VectorOfFlowCameraGyroMeasurement;I)J
.end method

.method public static final native VectorOfFlowCameraGyroMeasurement_isEmpty(JLcom/a9/vs/mobile/library/impl/jni/VectorOfFlowCameraGyroMeasurement;)Z
.end method

.method public static final native VectorOfFlowCameraGyroMeasurement_reserve(JLcom/a9/vs/mobile/library/impl/jni/VectorOfFlowCameraGyroMeasurement;J)V
.end method

.method public static final native VectorOfFlowCameraGyroMeasurement_set(JLcom/a9/vs/mobile/library/impl/jni/VectorOfFlowCameraGyroMeasurement;IJLcom/a9/vs/mobile/library/impl/jni/CameraGyroMeasurement;)V
.end method

.method public static final native VectorOfFlowCameraGyroMeasurement_size(JLcom/a9/vs/mobile/library/impl/jni/VectorOfFlowCameraGyroMeasurement;)J
.end method

.method public static final native VectorOfFlowCameraMemsMeasurement_add(JLcom/a9/vs/mobile/library/impl/jni/VectorOfFlowCameraMemsMeasurement;JLcom/a9/vs/mobile/library/impl/jni/CameraMemsMeasurement;)V
.end method

.method public static final native VectorOfFlowCameraMemsMeasurement_capacity(JLcom/a9/vs/mobile/library/impl/jni/VectorOfFlowCameraMemsMeasurement;)J
.end method

.method public static final native VectorOfFlowCameraMemsMeasurement_clear(JLcom/a9/vs/mobile/library/impl/jni/VectorOfFlowCameraMemsMeasurement;)V
.end method

.method public static final native VectorOfFlowCameraMemsMeasurement_get(JLcom/a9/vs/mobile/library/impl/jni/VectorOfFlowCameraMemsMeasurement;I)J
.end method

.method public static final native VectorOfFlowCameraMemsMeasurement_isEmpty(JLcom/a9/vs/mobile/library/impl/jni/VectorOfFlowCameraMemsMeasurement;)Z
.end method

.method public static final native VectorOfFlowCameraMemsMeasurement_reserve(JLcom/a9/vs/mobile/library/impl/jni/VectorOfFlowCameraMemsMeasurement;J)V
.end method

.method public static final native VectorOfFlowCameraMemsMeasurement_set(JLcom/a9/vs/mobile/library/impl/jni/VectorOfFlowCameraMemsMeasurement;IJLcom/a9/vs/mobile/library/impl/jni/CameraMemsMeasurement;)V
.end method

.method public static final native VectorOfFlowCameraMemsMeasurement_size(JLcom/a9/vs/mobile/library/impl/jni/VectorOfFlowCameraMemsMeasurement;)J
.end method

.method public static final native VectorOfImageBuffer_add(JLcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;JLcom/a9/vs/mobile/library/impl/jni/ImageBuffer;)V
.end method

.method public static final native VectorOfImageBuffer_capacity(JLcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;)J
.end method

.method public static final native VectorOfImageBuffer_clear(JLcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;)V
.end method

.method public static final native VectorOfImageBuffer_get(JLcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;I)J
.end method

.method public static final native VectorOfImageBuffer_isEmpty(JLcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;)Z
.end method

.method public static final native VectorOfImageBuffer_reserve(JLcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;J)V
.end method

.method public static final native VectorOfImageBuffer_set(JLcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;IJLcom/a9/vs/mobile/library/impl/jni/ImageBuffer;)V
.end method

.method public static final native VectorOfImageBuffer_size(JLcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;)J
.end method

.method public static final native VectorOfImageDef_add(JLcom/a9/vs/mobile/library/impl/jni/VectorOfImageDef;I)V
.end method

.method public static final native VectorOfImageDef_capacity(JLcom/a9/vs/mobile/library/impl/jni/VectorOfImageDef;)J
.end method

.method public static final native VectorOfImageDef_clear(JLcom/a9/vs/mobile/library/impl/jni/VectorOfImageDef;)V
.end method

.method public static final native VectorOfImageDef_get(JLcom/a9/vs/mobile/library/impl/jni/VectorOfImageDef;I)I
.end method

.method public static final native VectorOfImageDef_isEmpty(JLcom/a9/vs/mobile/library/impl/jni/VectorOfImageDef;)Z
.end method

.method public static final native VectorOfImageDef_reserve(JLcom/a9/vs/mobile/library/impl/jni/VectorOfImageDef;J)V
.end method

.method public static final native VectorOfImageDef_set(JLcom/a9/vs/mobile/library/impl/jni/VectorOfImageDef;II)V
.end method

.method public static final native VectorOfImageDef_size(JLcom/a9/vs/mobile/library/impl/jni/VectorOfImageDef;)J
.end method

.method public static final native VectorOfInt_add(JLcom/a9/vs/mobile/library/impl/jni/VectorOfInt;I)V
.end method

.method public static final native VectorOfInt_capacity(JLcom/a9/vs/mobile/library/impl/jni/VectorOfInt;)J
.end method

.method public static final native VectorOfInt_clear(JLcom/a9/vs/mobile/library/impl/jni/VectorOfInt;)V
.end method

.method public static final native VectorOfInt_get(JLcom/a9/vs/mobile/library/impl/jni/VectorOfInt;I)I
.end method

.method public static final native VectorOfInt_isEmpty(JLcom/a9/vs/mobile/library/impl/jni/VectorOfInt;)Z
.end method

.method public static final native VectorOfInt_reserve(JLcom/a9/vs/mobile/library/impl/jni/VectorOfInt;J)V
.end method

.method public static final native VectorOfInt_set(JLcom/a9/vs/mobile/library/impl/jni/VectorOfInt;II)V
.end method

.method public static final native VectorOfInt_size(JLcom/a9/vs/mobile/library/impl/jni/VectorOfInt;)J
.end method

.method public static final native VectorOfObjectInfo_add(JLcom/a9/vs/mobile/library/impl/jni/VectorOfObjectInfo;JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)V
.end method

.method public static final native VectorOfObjectInfo_capacity(JLcom/a9/vs/mobile/library/impl/jni/VectorOfObjectInfo;)J
.end method

.method public static final native VectorOfObjectInfo_clear(JLcom/a9/vs/mobile/library/impl/jni/VectorOfObjectInfo;)V
.end method

.method public static final native VectorOfObjectInfo_get(JLcom/a9/vs/mobile/library/impl/jni/VectorOfObjectInfo;I)J
.end method

.method public static final native VectorOfObjectInfo_isEmpty(JLcom/a9/vs/mobile/library/impl/jni/VectorOfObjectInfo;)Z
.end method

.method public static final native VectorOfObjectInfo_reserve(JLcom/a9/vs/mobile/library/impl/jni/VectorOfObjectInfo;J)V
.end method

.method public static final native VectorOfObjectInfo_set(JLcom/a9/vs/mobile/library/impl/jni/VectorOfObjectInfo;IJLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)V
.end method

.method public static final native VectorOfObjectInfo_size(JLcom/a9/vs/mobile/library/impl/jni/VectorOfObjectInfo;)J
.end method

.method public static final native VectorOfPoint2f_add(JLcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;JLcom/a9/vs/mobile/library/impl/jni/Point2f;)V
.end method

.method public static final native VectorOfPoint2f_capacity(JLcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;)J
.end method

.method public static final native VectorOfPoint2f_clear(JLcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;)V
.end method

.method public static final native VectorOfPoint2f_get(JLcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;I)J
.end method

.method public static final native VectorOfPoint2f_isEmpty(JLcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;)Z
.end method

.method public static final native VectorOfPoint2f_reserve(JLcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;J)V
.end method

.method public static final native VectorOfPoint2f_set(JLcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;IJLcom/a9/vs/mobile/library/impl/jni/Point2f;)V
.end method

.method public static final native VectorOfPoint2f_size(JLcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;)J
.end method

.method public static final native VectorOfStringPairs_add(JLcom/a9/vs/mobile/library/impl/jni/VectorOfStringPairs;JLcom/a9/vs/mobile/library/impl/jni/StringPair;)V
.end method

.method public static final native VectorOfStringPairs_capacity(JLcom/a9/vs/mobile/library/impl/jni/VectorOfStringPairs;)J
.end method

.method public static final native VectorOfStringPairs_clear(JLcom/a9/vs/mobile/library/impl/jni/VectorOfStringPairs;)V
.end method

.method public static final native VectorOfStringPairs_get(JLcom/a9/vs/mobile/library/impl/jni/VectorOfStringPairs;I)J
.end method

.method public static final native VectorOfStringPairs_isEmpty(JLcom/a9/vs/mobile/library/impl/jni/VectorOfStringPairs;)Z
.end method

.method public static final native VectorOfStringPairs_reserve(JLcom/a9/vs/mobile/library/impl/jni/VectorOfStringPairs;J)V
.end method

.method public static final native VectorOfStringPairs_set(JLcom/a9/vs/mobile/library/impl/jni/VectorOfStringPairs;IJLcom/a9/vs/mobile/library/impl/jni/StringPair;)V
.end method

.method public static final native VectorOfStringPairs_size(JLcom/a9/vs/mobile/library/impl/jni/VectorOfStringPairs;)J
.end method

.method public static final native VectorOfString_add(JLcom/a9/vs/mobile/library/impl/jni/VectorOfString;Ljava/lang/String;)V
.end method

.method public static final native VectorOfString_capacity(JLcom/a9/vs/mobile/library/impl/jni/VectorOfString;)J
.end method

.method public static final native VectorOfString_clear(JLcom/a9/vs/mobile/library/impl/jni/VectorOfString;)V
.end method

.method public static final native VectorOfString_get(JLcom/a9/vs/mobile/library/impl/jni/VectorOfString;I)Ljava/lang/String;
.end method

.method public static final native VectorOfString_isEmpty(JLcom/a9/vs/mobile/library/impl/jni/VectorOfString;)Z
.end method

.method public static final native VectorOfString_reserve(JLcom/a9/vs/mobile/library/impl/jni/VectorOfString;J)V
.end method

.method public static final native VectorOfString_set(JLcom/a9/vs/mobile/library/impl/jni/VectorOfString;ILjava/lang/String;)V
.end method

.method public static final native VectorOfString_size(JLcom/a9/vs/mobile/library/impl/jni/VectorOfString;)J
.end method

.method public static final native VectorOfVectorOfInt_add(JLcom/a9/vs/mobile/library/impl/jni/VectorOfVectorOfInt;JLcom/a9/vs/mobile/library/impl/jni/VectorOfInt;)V
.end method

.method public static final native VectorOfVectorOfInt_capacity(JLcom/a9/vs/mobile/library/impl/jni/VectorOfVectorOfInt;)J
.end method

.method public static final native VectorOfVectorOfInt_clear(JLcom/a9/vs/mobile/library/impl/jni/VectorOfVectorOfInt;)V
.end method

.method public static final native VectorOfVectorOfInt_get(JLcom/a9/vs/mobile/library/impl/jni/VectorOfVectorOfInt;I)J
.end method

.method public static final native VectorOfVectorOfInt_isEmpty(JLcom/a9/vs/mobile/library/impl/jni/VectorOfVectorOfInt;)Z
.end method

.method public static final native VectorOfVectorOfInt_reserve(JLcom/a9/vs/mobile/library/impl/jni/VectorOfVectorOfInt;J)V
.end method

.method public static final native VectorOfVectorOfInt_set(JLcom/a9/vs/mobile/library/impl/jni/VectorOfVectorOfInt;IJLcom/a9/vs/mobile/library/impl/jni/VectorOfInt;)V
.end method

.method public static final native VectorOfVectorOfInt_size(JLcom/a9/vs/mobile/library/impl/jni/VectorOfVectorOfInt;)J
.end method

.method public static final native delete_Address(J)V
.end method

.method public static final native delete_BusinessCardEntity(J)V
.end method

.method public static final native delete_BusinessCardInfo(J)V
.end method

.method public static final native delete_ByteArray(J)V
.end method

.method public static final native delete_CameraAccelerometerMeasurement(J)V
.end method

.method public static final native delete_CameraGyroMeasurement(J)V
.end method

.method public static final native delete_CameraMemsMeasurement(J)V
.end method

.method public static final native delete_CameraResRequirement(J)V
.end method

.method public static final native delete_CardRegion(J)V
.end method

.method public static final native delete_CreditCardInfo(J)V
.end method

.method public static final native delete_CreditCardProcessProperty(J)V
.end method

.method public static final native delete_CreditCardReaderDelegateBase(J)V
.end method

.method public static final native delete_CreditCardReaderFacade(J)V
.end method

.method public static final native delete_EventDelegateBase(J)V
.end method

.method public static final native delete_ExtraFrameData(J)V
.end method

.method public static final native delete_FlowStateEngineFacade(J)V
.end method

.method public static final native delete_FrameID(J)V
.end method

.method public static final native delete_ImageBuffer(J)V
.end method

.method public static final native delete_ImageByteData(J)V
.end method

.method public static final native delete_MapOfStringToDouble(J)V
.end method

.method public static final native delete_MapOfStringToString(J)V
.end method

.method public static final native delete_MapOfStringToUInt(J)V
.end method

.method public static final native delete_MobileUtils(J)V
.end method

.method public static final native delete_NEONAccelerationResult(J)V
.end method

.method public static final native delete_Name(J)V
.end method

.method public static final native delete_ObjectInfo(J)V
.end method

.method public static final native delete_Point2f(J)V
.end method

.method public static final native delete_Point3d(J)V
.end method

.method public static final native delete_SensorData(J)V
.end method

.method public static final native delete_ServerDelegate(J)V
.end method

.method public static final native delete_ServerDelegateInterface(J)V
.end method

.method public static final native delete_ServerRequest(J)V
.end method

.method public static final native delete_ServerResponse(J)V
.end method

.method public static final native delete_ServerResponseHandler(J)V
.end method

.method public static final native delete_StringPair(J)V
.end method

.method public static final native delete_TextCanvasInfo(J)V
.end method

.method public static final native delete_VectorOfBusinessCardEntities(J)V
.end method

.method public static final native delete_VectorOfDouble(J)V
.end method

.method public static final native delete_VectorOfFlowCameraAccelerometerMeasurement(J)V
.end method

.method public static final native delete_VectorOfFlowCameraGyroMeasurement(J)V
.end method

.method public static final native delete_VectorOfFlowCameraMemsMeasurement(J)V
.end method

.method public static final native delete_VectorOfImageBuffer(J)V
.end method

.method public static final native delete_VectorOfImageDef(J)V
.end method

.method public static final native delete_VectorOfInt(J)V
.end method

.method public static final native delete_VectorOfObjectInfo(J)V
.end method

.method public static final native delete_VectorOfPoint2f(J)V
.end method

.method public static final native delete_VectorOfString(J)V
.end method

.method public static final native delete_VectorOfStringPairs(J)V
.end method

.method public static final native delete_VectorOfVectorOfInt(J)V
.end method

.method public static final native new_Address()J
.end method

.method public static final native new_BusinessCardEntity()J
.end method

.method public static final native new_BusinessCardInfo()J
.end method

.method public static final native new_ByteArray__SWIG_0()J
.end method

.method public static final native new_ByteArray__SWIG_1(JLcom/a9/vs/mobile/library/impl/jni/ByteArray;)J
.end method

.method public static final native new_CameraAccelerometerMeasurement()J
.end method

.method public static final native new_CameraGyroMeasurement()J
.end method

.method public static final native new_CameraMemsMeasurement()J
.end method

.method public static final native new_CameraResRequirement()J
.end method

.method public static final native new_CardRegion()J
.end method

.method public static final native new_CreditCardInfo()J
.end method

.method public static final native new_CreditCardProcessProperty()J
.end method

.method public static final native new_CreditCardReaderDelegateBase()J
.end method

.method public static final native new_CreditCardReaderFacade(JLcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;)J
.end method

.method public static final native new_EventDelegateBase()J
.end method

.method public static final native new_ExtraFrameData__SWIG_0()J
.end method

.method public static final native new_ExtraFrameData__SWIG_1(IIIIZID)J
.end method

.method public static final native new_FlowStateEngineFacade(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;)J
.end method

.method public static final native new_FrameID()J
.end method

.method public static final native new_ImageBuffer__SWIG_0()J
.end method

.method public static final native new_ImageBuffer__SWIG_1(IIIIIIJ)J
.end method

.method public static final native new_ImageByteData()J
.end method

.method public static final native new_MapOfStringToDouble__SWIG_0()J
.end method

.method public static final native new_MapOfStringToDouble__SWIG_1(JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;)J
.end method

.method public static final native new_MapOfStringToString__SWIG_0()J
.end method

.method public static final native new_MapOfStringToString__SWIG_1(JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;)J
.end method

.method public static final native new_MapOfStringToUInt__SWIG_0()J
.end method

.method public static final native new_MapOfStringToUInt__SWIG_1(JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToUInt;)J
.end method

.method public static final native new_MobileUtils()J
.end method

.method public static final native new_NEONAccelerationResult()J
.end method

.method public static final native new_Name()J
.end method

.method public static final native new_ObjectInfo__SWIG_0(I)J
.end method

.method public static final native new_ObjectInfo__SWIG_1()J
.end method

.method public static final native new_Point2f__SWIG_0()J
.end method

.method public static final native new_Point2f__SWIG_1(FF)J
.end method

.method public static final native new_Point3d__SWIG_0()J
.end method

.method public static final native new_Point3d__SWIG_1(DDD)J
.end method

.method public static final native new_SensorData()J
.end method

.method public static final native new_ServerDelegate()J
.end method

.method public static final native new_ServerRequest__SWIG_0()J
.end method

.method public static final native new_ServerRequest__SWIG_1(JLcom/a9/vs/mobile/library/impl/jni/ByteArray;Ljava/lang/String;JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;)J
.end method

.method public static final native new_ServerRequest__SWIG_2(JLcom/a9/vs/mobile/library/impl/jni/ByteArray;Ljava/lang/String;JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;)J
.end method

.method public static final native new_ServerRequest__SWIG_3(JLcom/a9/vs/mobile/library/impl/jni/ByteArray;Ljava/lang/String;)J
.end method

.method public static final native new_ServerResponse()J
.end method

.method public static final native new_StringPair__SWIG_0()J
.end method

.method public static final native new_StringPair__SWIG_1(Ljava/lang/String;Ljava/lang/String;)J
.end method

.method public static final native new_StringPair__SWIG_2(JLcom/a9/vs/mobile/library/impl/jni/StringPair;)J
.end method

.method public static final native new_TextCanvasInfo()J
.end method

.method public static final native new_VectorOfBusinessCardEntities__SWIG_0()J
.end method

.method public static final native new_VectorOfBusinessCardEntities__SWIG_1(J)J
.end method

.method public static final native new_VectorOfDouble__SWIG_0()J
.end method

.method public static final native new_VectorOfDouble__SWIG_1(J)J
.end method

.method public static final native new_VectorOfFlowCameraAccelerometerMeasurement__SWIG_0()J
.end method

.method public static final native new_VectorOfFlowCameraAccelerometerMeasurement__SWIG_1(J)J
.end method

.method public static final native new_VectorOfFlowCameraGyroMeasurement__SWIG_0()J
.end method

.method public static final native new_VectorOfFlowCameraGyroMeasurement__SWIG_1(J)J
.end method

.method public static final native new_VectorOfFlowCameraMemsMeasurement__SWIG_0()J
.end method

.method public static final native new_VectorOfFlowCameraMemsMeasurement__SWIG_1(J)J
.end method

.method public static final native new_VectorOfImageBuffer__SWIG_0()J
.end method

.method public static final native new_VectorOfImageBuffer__SWIG_1(J)J
.end method

.method public static final native new_VectorOfImageDef__SWIG_0()J
.end method

.method public static final native new_VectorOfImageDef__SWIG_1(J)J
.end method

.method public static final native new_VectorOfInt__SWIG_0()J
.end method

.method public static final native new_VectorOfInt__SWIG_1(J)J
.end method

.method public static final native new_VectorOfObjectInfo__SWIG_0()J
.end method

.method public static final native new_VectorOfObjectInfo__SWIG_1(J)J
.end method

.method public static final native new_VectorOfPoint2f__SWIG_0()J
.end method

.method public static final native new_VectorOfPoint2f__SWIG_1(J)J
.end method

.method public static final native new_VectorOfStringPairs__SWIG_0()J
.end method

.method public static final native new_VectorOfStringPairs__SWIG_1(J)J
.end method

.method public static final native new_VectorOfString__SWIG_0()J
.end method

.method public static final native new_VectorOfString__SWIG_1(J)J
.end method

.method public static final native new_VectorOfVectorOfInt__SWIG_0()J
.end method

.method public static final native new_VectorOfVectorOfInt__SWIG_1(J)J
.end method

.method private static final native swig_module_init()V
.end method

.class public Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;
.super Ljava/lang/Object;
.source "OmnitureTracker.java"

# interfaces
.implements Lcom/disney/datg/videoplatforms/sdk/analytics/IAdTracker;
.implements Lcom/disney/datg/videoplatforms/sdk/analytics/IAppTracker;
.implements Lcom/disney/datg/videoplatforms/sdk/analytics/IAuthZTracker;
.implements Lcom/disney/datg/videoplatforms/sdk/analytics/ILinkTracker;
.implements Lcom/disney/datg/videoplatforms/sdk/analytics/IMediaTracker;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker$1;
    }
.end annotation


# instance fields
.field private activity:Landroid/app/Activity;

.field private configuration:Lcom/disney/datg/videoplatforms/sdk/media/Configuration;


# direct methods
.method public constructor <init>(Landroid/app/Activity;Lcom/disney/datg/videoplatforms/sdk/media/Configuration;)V
    .locals 6
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "configuration"    # Lcom/disney/datg/videoplatforms/sdk/media/Configuration;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 56
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 57
    invoke-static {}, Lcom/adobe/adms/measurement/ADMS_Measurement;->sharedInstance()Lcom/adobe/adms/measurement/ADMS_Measurement;

    move-result-object v1

    .line 58
    .local v1, "measurement":Lcom/adobe/adms/measurement/ADMS_Measurement;
    if-eqz p2, :cond_1

    invoke-virtual {p2}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->getCurrentConfig()Lcom/disney/datg/videoplatforms/sdk/models/api/Config;

    move-result-object v3

    if-eqz v3, :cond_1

    .line 59
    invoke-virtual {p0, p2}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->setConfiguration(Lcom/disney/datg/videoplatforms/sdk/media/Configuration;)V

    .line 60
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->activity:Landroid/app/Activity;

    .line 61
    invoke-virtual {p2}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->getCurrentConfig()Lcom/disney/datg/videoplatforms/sdk/models/api/Config;

    move-result-object v3

    const-string v4, "account"

    const-string v5, "FEAT0015"

    invoke-virtual {v3, v4, v5}, Lcom/disney/datg/videoplatforms/sdk/models/api/Config;->getParamInFeatureId(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 62
    .local v0, "accountName":Ljava/lang/String;
    invoke-virtual {p2}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->getCurrentConfig()Lcom/disney/datg/videoplatforms/sdk/models/api/Config;

    move-result-object v3

    const-string v4, "trackingServer"

    const-string v5, "FEAT0015"

    invoke-virtual {v3, v4, v5}, Lcom/disney/datg/videoplatforms/sdk/models/api/Config;->getParamInFeatureId(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 63
    .local v2, "trackingServer":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_0

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 64
    invoke-virtual {v1, v0, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->configureMeasurement(Ljava/lang/String;Ljava/lang/String;)V

    .line 70
    :cond_0
    return-void

    .line 68
    .end local v0    # "accountName":Ljava/lang/String;
    .end local v2    # "trackingServer":Ljava/lang/String;
    :cond_1
    new-instance v3, Ljava/lang/Exception;

    const-string v4, "configuration cannot be null"

    invoke-direct {v3, v4}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    throw v3
.end method

.method private static makeOmnitureStringFormat(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "s"    # Ljava/lang/String;

    .prologue
    .line 1207
    sget-object v0, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {p0, v0}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object p0

    .line 1208
    const-string v0, "[ ]"

    const-string v1, "-"

    invoke-virtual {p0, v0, v1}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    .line 1209
    const-string v0, "[^a-z0-9-]"

    const-string v1, ""

    invoke-virtual {p0, v0, v1}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    .line 1210
    return-object p0
.end method

.method private populate(Lcom/adobe/adms/measurement/ADMS_Measurement;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 30
    .param p1, "measurement"    # Lcom/adobe/adms/measurement/ADMS_Measurement;
    .param p2, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    .line 734
    invoke-interface/range {p2 .. p2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getEvars()Ljava/util/List;

    move-result-object v27

    if-eqz v27, :cond_0

    .line 735
    const/4 v15, 0x0

    .local v15, "i":I
    :goto_0
    invoke-interface/range {p2 .. p2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getEvars()Ljava/util/List;

    move-result-object v27

    invoke-interface/range {v27 .. v27}, Ljava/util/List;->size()I

    move-result v27

    move/from16 v0, v27

    if-ge v15, v0, :cond_0

    .line 736
    invoke-interface/range {p2 .. p2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getEvars()Ljava/util/List;

    move-result-object v27

    move-object/from16 v0, v27

    invoke-interface {v0, v15}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v27

    check-cast v27, Lorg/apache/http/message/BasicNameValuePair;

    invoke-virtual/range {v27 .. v27}, Lorg/apache/http/message/BasicNameValuePair;->getName()Ljava/lang/String;

    move-result-object v27

    invoke-static/range {v27 .. v27}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v28

    invoke-interface/range {p2 .. p2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getEvars()Ljava/util/List;

    move-result-object v27

    move-object/from16 v0, v27

    invoke-interface {v0, v15}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v27

    check-cast v27, Lorg/apache/http/message/BasicNameValuePair;

    invoke-virtual/range {v27 .. v27}, Lorg/apache/http/message/BasicNameValuePair;->getValue()Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, p1

    move/from16 v1, v28

    move-object/from16 v2, v27

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setEvar(ILjava/lang/String;)V

    .line 735
    add-int/lit8 v15, v15, 0x1

    goto :goto_0

    .line 739
    .end local v15    # "i":I
    :cond_0
    invoke-interface/range {p2 .. p2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getProps()Ljava/util/List;

    move-result-object v27

    if-eqz v27, :cond_1

    .line 740
    const/4 v15, 0x0

    .restart local v15    # "i":I
    :goto_1
    invoke-interface/range {p2 .. p2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getProps()Ljava/util/List;

    move-result-object v27

    invoke-interface/range {v27 .. v27}, Ljava/util/List;->size()I

    move-result v27

    move/from16 v0, v27

    if-ge v15, v0, :cond_1

    .line 741
    invoke-interface/range {p2 .. p2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getProps()Ljava/util/List;

    move-result-object v27

    move-object/from16 v0, v27

    invoke-interface {v0, v15}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v27

    check-cast v27, Lorg/apache/http/message/BasicNameValuePair;

    invoke-virtual/range {v27 .. v27}, Lorg/apache/http/message/BasicNameValuePair;->getName()Ljava/lang/String;

    move-result-object v27

    invoke-static/range {v27 .. v27}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v28

    invoke-interface/range {p2 .. p2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getProps()Ljava/util/List;

    move-result-object v27

    move-object/from16 v0, v27

    invoke-interface {v0, v15}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v27

    check-cast v27, Lorg/apache/http/message/BasicNameValuePair;

    invoke-virtual/range {v27 .. v27}, Lorg/apache/http/message/BasicNameValuePair;->getValue()Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, p1

    move/from16 v1, v28

    move-object/from16 v2, v27

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setProp(ILjava/lang/String;)V

    .line 740
    add-int/lit8 v15, v15, 0x1

    goto :goto_1

    .line 744
    .end local v15    # "i":I
    :cond_1
    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    .line 745
    .local v13, "event":Ljava/lang/StringBuilder;
    invoke-interface/range {p2 .. p2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getEvents()Ljava/util/List;

    move-result-object v27

    if-eqz v27, :cond_3

    .line 746
    const/4 v15, 0x0

    .restart local v15    # "i":I
    :goto_2
    invoke-interface/range {p2 .. p2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getEvents()Ljava/util/List;

    move-result-object v27

    invoke-interface/range {v27 .. v27}, Ljava/util/List;->size()I

    move-result v27

    move/from16 v0, v27

    if-ge v15, v0, :cond_3

    .line 747
    if-lez v15, :cond_2

    .line 748
    const-string v27, ","

    move-object/from16 v0, v27

    invoke-virtual {v13, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 750
    :cond_2
    invoke-interface/range {p2 .. p2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getEvents()Ljava/util/List;

    move-result-object v27

    move-object/from16 v0, v27

    invoke-interface {v0, v15}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v27

    check-cast v27, Ljava/lang/String;

    move-object/from16 v0, v27

    invoke-virtual {v13, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 746
    add-int/lit8 v15, v15, 0x1

    goto :goto_2

    .line 754
    .end local v15    # "i":I
    :cond_3
    invoke-interface/range {p2 .. p2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v27

    const-string v28, "channel"

    invoke-interface/range {v27 .. v28}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v27

    if-eqz v27, :cond_4

    .line 755
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->activity:Landroid/app/Activity;

    move-object/from16 v27, v0

    invoke-virtual/range {v27 .. v27}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v27

    sget v28, Lcom/disney/datg/videoplatforms/sdk/R$string;->omniture_channel:I

    invoke-virtual/range {v27 .. v28}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v9

    .line 756
    .local v9, "channel":Ljava/lang/String;
    const-string v27, "%DEVICE_MODEL%"

    sget-object v28, Landroid/os/Build;->MODEL:Ljava/lang/String;

    move-object/from16 v0, v27

    move-object/from16 v1, v28

    invoke-virtual {v9, v0, v1}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v9

    .line 757
    move-object/from16 v0, p1

    invoke-virtual {v0, v9}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setChannel(Ljava/lang/String;)V

    .line 760
    .end local v9    # "channel":Ljava/lang/String;
    :cond_4
    invoke-interface/range {p2 .. p2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v27

    const-string v28, "pageName"

    invoke-interface/range {v27 .. v28}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v27

    if-eqz v27, :cond_5

    .line 761
    invoke-interface/range {p2 .. p2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v27

    const-string v28, "pageName"

    invoke-interface/range {v27 .. v28}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v27

    invoke-virtual/range {v27 .. v27}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, p1

    move-object/from16 v1, v27

    invoke-virtual {v0, v1}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setAppState(Ljava/lang/String;)V

    .line 764
    :cond_5
    const/4 v14, 0x0

    .line 766
    .local v14, "geoLocation":Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;
    :try_start_0
    invoke-static {}, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->getGeolocationManager()Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;

    move-result-object v27

    invoke-virtual/range {v27 .. v27}, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->getCurrentGeolocation()Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;

    move-result-object v27

    if-eqz v27, :cond_6

    .line 767
    invoke-static {}, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->getGeolocationManager()Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;

    move-result-object v27

    invoke-virtual/range {v27 .. v27}, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->getCurrentGeolocation()Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;
    :try_end_0
    .catch Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v14

    .line 774
    :cond_6
    :goto_3
    const-string v11, "phone"

    .line 775
    .local v11, "devicetype":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->activity:Landroid/app/Activity;

    .line 776
    .local v10, "context":Landroid/content/Context;
    if-eqz v10, :cond_7

    .line 777
    const-string v27, "phone"

    move-object/from16 v0, v27

    invoke-virtual {v10, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v23

    check-cast v23, Landroid/telephony/TelephonyManager;

    .line 778
    .local v23, "telephony":Landroid/telephony/TelephonyManager;
    invoke-virtual/range {v23 .. v23}, Landroid/telephony/TelephonyManager;->getPhoneType()I

    move-result v24

    .line 779
    .local v24, "type":I
    if-nez v24, :cond_7

    .line 780
    const-string v11, "tablet"

    .line 784
    .end local v23    # "telephony":Landroid/telephony/TelephonyManager;
    .end local v24    # "type":I
    :cond_7
    const/16 v27, 0x1

    move-object/from16 v0, p1

    move/from16 v1, v27

    invoke-virtual {v0, v1, v11}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setProp(ILjava/lang/String;)V

    .line 785
    const/16 v27, 0x2

    move-object/from16 v0, p1

    move/from16 v1, v27

    invoke-virtual {v0, v1, v11}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setEvar(ILjava/lang/String;)V

    .line 788
    invoke-static {}, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/CookieEnabledHttpRequestFactory;->getSWID()Ljava/lang/String;

    move-result-object v27

    if-eqz v27, :cond_d

    const-string v27, ""

    invoke-static {}, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/CookieEnabledHttpRequestFactory;->getSWID()Ljava/lang/String;

    move-result-object v28

    invoke-virtual/range {v27 .. v28}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v27

    if-nez v27, :cond_d

    .line 791
    const/16 v27, 0x2

    invoke-static {}, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/CookieEnabledHttpRequestFactory;->getSWID()Ljava/lang/String;

    move-result-object v28

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setProp(ILjava/lang/String;)V

    .line 792
    const/16 v27, 0x2

    invoke-static {}, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/CookieEnabledHttpRequestFactory;->getSWID()Ljava/lang/String;

    move-result-object v28

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setEvar(ILjava/lang/String;)V

    .line 799
    :goto_4
    if-eqz p2, :cond_8

    invoke-interface/range {p2 .. p2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v27

    if-eqz v27, :cond_8

    invoke-interface/range {p2 .. p2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v27

    const-string v28, "currentMVPDId"

    invoke-interface/range {v27 .. v28}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v27

    if-eqz v27, :cond_8

    .line 801
    invoke-interface/range {p2 .. p2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v27

    const-string v28, "currentMVPDId"

    invoke-interface/range {v27 .. v28}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v18

    check-cast v18, Ljava/lang/String;

    .line 802
    .local v18, "mvpdId":Ljava/lang/String;
    invoke-static/range {v18 .. v18}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v27

    if-nez v27, :cond_e

    .line 803
    const/16 v27, 0x3

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v18

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setProp(ILjava/lang/String;)V

    .line 804
    const/16 v27, 0x3

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v18

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setEvar(ILjava/lang/String;)V

    .line 812
    .end local v18    # "mvpdId":Ljava/lang/String;
    :cond_8
    :goto_5
    if-eqz p2, :cond_9

    invoke-interface/range {p2 .. p2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v27

    if-eqz v27, :cond_9

    invoke-interface/range {p2 .. p2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v27

    const-string v28, "currentMVPDGUID"

    invoke-interface/range {v27 .. v28}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v27

    if-eqz v27, :cond_9

    .line 814
    invoke-interface/range {p2 .. p2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v27

    const-string v28, "currentMVPDGUID"

    invoke-interface/range {v27 .. v28}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v17

    check-cast v17, Ljava/lang/String;

    .line 815
    .local v17, "mvpdGUID":Ljava/lang/String;
    invoke-static/range {v17 .. v17}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v27

    if-nez v27, :cond_f

    .line 816
    const/16 v27, 0x4

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v17

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setProp(ILjava/lang/String;)V

    .line 817
    const/16 v27, 0x4

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v17

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setEvar(ILjava/lang/String;)V

    .line 825
    .end local v17    # "mvpdGUID":Ljava/lang/String;
    :cond_9
    :goto_6
    if-eqz p2, :cond_a

    invoke-interface/range {p2 .. p2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v27

    if-eqz v27, :cond_a

    invoke-interface/range {p2 .. p2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v27

    const-string v28, "adobePassOS"

    invoke-interface/range {v27 .. v28}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v27

    if-eqz v27, :cond_a

    .line 826
    invoke-interface/range {p2 .. p2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v27

    const-string v28, "adobePassOS"

    invoke-interface/range {v27 .. v28}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 827
    .local v3, "adobePassOS":Ljava/lang/String;
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v27

    if-nez v27, :cond_10

    .line 828
    const/16 v27, 0x5

    move-object/from16 v0, p1

    move/from16 v1, v27

    invoke-virtual {v0, v1, v3}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setProp(ILjava/lang/String;)V

    .line 829
    const/16 v27, 0x5

    move-object/from16 v0, p1

    move/from16 v1, v27

    invoke-virtual {v0, v1, v3}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setEvar(ILjava/lang/String;)V

    .line 839
    .end local v3    # "adobePassOS":Ljava/lang/String;
    :cond_a
    :goto_7
    const/16 v27, 0x6

    const-string v28, "None"

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setProp(ILjava/lang/String;)V

    .line 840
    const/16 v27, 0x6

    const-string v28, "None"

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setEvar(ILjava/lang/String;)V

    .line 844
    if-eqz p2, :cond_b

    invoke-interface/range {p2 .. p2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v27

    if-eqz v27, :cond_b

    invoke-interface/range {p2 .. p2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v27

    const-string v28, "authenticated"

    invoke-interface/range {v27 .. v28}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v27

    if-eqz v27, :cond_b

    .line 845
    invoke-interface/range {p2 .. p2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v27

    const-string v28, "authenticated"

    invoke-interface/range {v27 .. v28}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v27

    check-cast v27, Ljava/lang/Boolean;

    invoke-virtual/range {v27 .. v27}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v8

    .line 846
    .local v8, "authenticated":Z
    if-eqz v8, :cond_11

    .line 847
    const/16 v27, 0x8

    const-string v28, "true"

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setProp(ILjava/lang/String;)V

    .line 848
    const/16 v27, 0x8

    const-string v28, "true"

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setEvar(ILjava/lang/String;)V

    .line 855
    .end local v8    # "authenticated":Z
    :cond_b
    :goto_8
    const-string v4, ""

    .line 856
    .local v4, "aff":Ljava/lang/String;
    if-eqz v14, :cond_13

    .line 857
    invoke-virtual {v14}, Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;->getAffiliates()Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliates;

    move-result-object v6

    .line 858
    .local v6, "affiliates":Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliates;
    if-eqz v6, :cond_13

    invoke-virtual {v6}, Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliates;->getAffiliates()Ljava/util/ArrayList;

    move-result-object v27

    invoke-virtual/range {v27 .. v27}, Ljava/util/ArrayList;->size()I

    move-result v27

    if-lez v27, :cond_13

    .line 859
    invoke-virtual {v6}, Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliates;->getAffiliates()Ljava/util/ArrayList;

    move-result-object v7

    .line 861
    .local v7, "affs":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliate;>;"
    invoke-virtual {v7}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v16

    .local v16, "i$":Ljava/util/Iterator;
    :cond_c
    :goto_9
    invoke-interface/range {v16 .. v16}, Ljava/util/Iterator;->hasNext()Z

    move-result v27

    if-eqz v27, :cond_12

    invoke-interface/range {v16 .. v16}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliate;

    .line 862
    .local v5, "affiliate":Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliate;
    if-eqz v5, :cond_c

    invoke-virtual {v5}, Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliate;->getId()Ljava/lang/String;

    move-result-object v27

    invoke-static/range {v27 .. v27}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v27

    if-nez v27, :cond_c

    .line 863
    new-instance v27, Ljava/lang/StringBuilder;

    invoke-direct/range {v27 .. v27}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v27

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v27

    invoke-virtual {v5}, Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliate;->getId()Ljava/lang/String;

    move-result-object v28

    invoke-virtual/range {v27 .. v28}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v27

    const-string v28, ","

    invoke-virtual/range {v27 .. v28}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v27

    invoke-virtual/range {v27 .. v27}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    goto :goto_9

    .line 769
    .end local v4    # "aff":Ljava/lang/String;
    .end local v5    # "affiliate":Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliate;
    .end local v6    # "affiliates":Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliates;
    .end local v7    # "affs":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliate;>;"
    .end local v10    # "context":Landroid/content/Context;
    .end local v11    # "devicetype":Ljava/lang/String;
    .end local v16    # "i$":Ljava/util/Iterator;
    :catch_0
    move-exception v12

    .line 770
    .local v12, "e":Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
    const-string v27, "OmnitureTracker"

    invoke-virtual {v12}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;->getMessage()Ljava/lang/String;

    move-result-object v28

    invoke-static/range {v27 .. v28}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_3

    .line 794
    .end local v12    # "e":Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
    .restart local v10    # "context":Landroid/content/Context;
    .restart local v11    # "devicetype":Ljava/lang/String;
    :cond_d
    const/16 v27, 0x2

    const-string v28, "None"

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setProp(ILjava/lang/String;)V

    .line 795
    const/16 v27, 0x2

    const-string v28, "None"

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setEvar(ILjava/lang/String;)V

    goto/16 :goto_4

    .line 806
    .restart local v18    # "mvpdId":Ljava/lang/String;
    :cond_e
    const/16 v27, 0x3

    const-string v28, "None"

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setProp(ILjava/lang/String;)V

    .line 807
    const/16 v27, 0x3

    const-string v28, "None"

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setEvar(ILjava/lang/String;)V

    goto/16 :goto_5

    .line 819
    .end local v18    # "mvpdId":Ljava/lang/String;
    .restart local v17    # "mvpdGUID":Ljava/lang/String;
    :cond_f
    const/16 v27, 0x4

    const-string v28, "None"

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setProp(ILjava/lang/String;)V

    .line 820
    const/16 v27, 0x4

    const-string v28, "None"

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setEvar(ILjava/lang/String;)V

    goto/16 :goto_6

    .line 831
    .end local v17    # "mvpdGUID":Ljava/lang/String;
    .restart local v3    # "adobePassOS":Ljava/lang/String;
    :cond_10
    const/16 v27, 0x5

    const-string v28, "None"

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setProp(ILjava/lang/String;)V

    .line 832
    const/16 v27, 0x5

    const-string v28, "None"

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setEvar(ILjava/lang/String;)V

    goto/16 :goto_7

    .line 850
    .end local v3    # "adobePassOS":Ljava/lang/String;
    .restart local v8    # "authenticated":Z
    :cond_11
    const/16 v27, 0x8

    const-string v28, "false"

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setProp(ILjava/lang/String;)V

    .line 851
    const/16 v27, 0x8

    const-string v28, "false"

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setEvar(ILjava/lang/String;)V

    goto/16 :goto_8

    .line 867
    .end local v8    # "authenticated":Z
    .restart local v4    # "aff":Ljava/lang/String;
    .restart local v6    # "affiliates":Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliates;
    .restart local v7    # "affs":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliate;>;"
    .restart local v16    # "i$":Ljava/util/Iterator;
    :cond_12
    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v27

    if-nez v27, :cond_13

    .line 868
    const/16 v27, 0x0

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v28

    add-int/lit8 v28, v28, -0x1

    move/from16 v0, v27

    move/from16 v1, v28

    invoke-virtual {v4, v0, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    .line 873
    .end local v6    # "affiliates":Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliates;
    .end local v7    # "affs":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliate;>;"
    .end local v16    # "i$":Ljava/util/Iterator;
    :cond_13
    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v27

    if-nez v27, :cond_18

    .line 875
    const/16 v27, 0x7

    move-object/from16 v0, p1

    move/from16 v1, v27

    invoke-virtual {v0, v1, v4}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setProp(ILjava/lang/String;)V

    .line 876
    const/16 v27, 0x7

    move-object/from16 v0, p1

    move/from16 v1, v27

    invoke-virtual {v0, v1, v4}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setEvar(ILjava/lang/String;)V

    .line 886
    :goto_a
    const/16 v27, 0xd

    sget-object v28, Landroid/os/Build;->DISPLAY:Ljava/lang/String;

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setProp(ILjava/lang/String;)V

    .line 887
    const/16 v27, 0xd

    sget-object v28, Landroid/os/Build;->DISPLAY:Ljava/lang/String;

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setEvar(ILjava/lang/String;)V

    .line 890
    const/16 v27, 0xd

    sget-object v28, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setProp(ILjava/lang/String;)V

    .line 891
    const/16 v27, 0xd

    sget-object v28, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setEvar(ILjava/lang/String;)V

    .line 894
    const/16 v27, 0xe

    const-string v28, "None"

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setProp(ILjava/lang/String;)V

    .line 895
    const/16 v27, 0xe

    const-string v28, "None"

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setEvar(ILjava/lang/String;)V

    .line 898
    const/16 v25, 0x0

    .line 899
    .local v25, "user":Lcom/disney/datg/videoplatforms/sdk/models/api/User;
    if-eqz v14, :cond_14

    .line 900
    invoke-virtual {v14}, Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;->getUser()Lcom/disney/datg/videoplatforms/sdk/models/api/User;

    move-result-object v25

    .line 903
    :cond_14
    if-eqz v25, :cond_15

    .line 905
    invoke-virtual/range {v25 .. v25}, Lcom/disney/datg/videoplatforms/sdk/models/api/User;->getProxy()Ljava/lang/String;

    move-result-object v27

    if-eqz v27, :cond_19

    const-string v27, ""

    invoke-virtual/range {v25 .. v25}, Lcom/disney/datg/videoplatforms/sdk/models/api/User;->getProxy()Ljava/lang/String;

    move-result-object v28

    invoke-virtual/range {v27 .. v28}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v27

    if-nez v27, :cond_19

    .line 908
    const/16 v27, 0xf

    invoke-virtual/range {v25 .. v25}, Lcom/disney/datg/videoplatforms/sdk/models/api/User;->getProxy()Ljava/lang/String;

    move-result-object v28

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setProp(ILjava/lang/String;)V

    .line 909
    const/16 v27, 0xf

    invoke-virtual/range {v25 .. v25}, Lcom/disney/datg/videoplatforms/sdk/models/api/User;->getProxy()Ljava/lang/String;

    move-result-object v28

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setEvar(ILjava/lang/String;)V

    .line 916
    :goto_b
    invoke-virtual/range {v25 .. v25}, Lcom/disney/datg/videoplatforms/sdk/models/api/User;->getAllowed()Ljava/lang/Boolean;

    move-result-object v27

    invoke-virtual/range {v27 .. v27}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v27

    if-eqz v27, :cond_1a

    .line 917
    const/16 v27, 0x10

    const-string v28, "true"

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setProp(ILjava/lang/String;)V

    .line 918
    const/16 v27, 0x10

    const-string v28, "true"

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setEvar(ILjava/lang/String;)V

    .line 925
    :goto_c
    invoke-virtual/range {v25 .. v25}, Lcom/disney/datg/videoplatforms/sdk/models/api/User;->getCity()Ljava/lang/String;

    move-result-object v27

    if-eqz v27, :cond_1b

    const-string v27, ""

    invoke-virtual/range {v25 .. v25}, Lcom/disney/datg/videoplatforms/sdk/models/api/User;->getCity()Ljava/lang/String;

    move-result-object v28

    invoke-virtual/range {v27 .. v28}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v27

    if-nez v27, :cond_1b

    .line 928
    const/16 v27, 0x11

    invoke-virtual/range {v25 .. v25}, Lcom/disney/datg/videoplatforms/sdk/models/api/User;->getCity()Ljava/lang/String;

    move-result-object v28

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setProp(ILjava/lang/String;)V

    .line 929
    const/16 v27, 0x11

    invoke-virtual/range {v25 .. v25}, Lcom/disney/datg/videoplatforms/sdk/models/api/User;->getCity()Ljava/lang/String;

    move-result-object v28

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setEvar(ILjava/lang/String;)V

    .line 936
    :goto_d
    invoke-virtual/range {v25 .. v25}, Lcom/disney/datg/videoplatforms/sdk/models/api/User;->getState()Ljava/lang/String;

    move-result-object v27

    if-eqz v27, :cond_1c

    const-string v27, ""

    invoke-virtual/range {v25 .. v25}, Lcom/disney/datg/videoplatforms/sdk/models/api/User;->getState()Ljava/lang/String;

    move-result-object v28

    invoke-virtual/range {v27 .. v28}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v27

    if-nez v27, :cond_1c

    .line 939
    const/16 v27, 0x12

    invoke-virtual/range {v25 .. v25}, Lcom/disney/datg/videoplatforms/sdk/models/api/User;->getState()Ljava/lang/String;

    move-result-object v28

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setProp(ILjava/lang/String;)V

    .line 940
    const/16 v27, 0x12

    invoke-virtual/range {v25 .. v25}, Lcom/disney/datg/videoplatforms/sdk/models/api/User;->getState()Ljava/lang/String;

    move-result-object v28

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setEvar(ILjava/lang/String;)V

    .line 947
    :goto_e
    invoke-virtual/range {v25 .. v25}, Lcom/disney/datg/videoplatforms/sdk/models/api/User;->getCountry()Ljava/lang/String;

    move-result-object v27

    if-eqz v27, :cond_1d

    const-string v27, ""

    invoke-virtual/range {v25 .. v25}, Lcom/disney/datg/videoplatforms/sdk/models/api/User;->getCountry()Ljava/lang/String;

    move-result-object v28

    invoke-virtual/range {v27 .. v28}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v27

    if-nez v27, :cond_1d

    .line 950
    const/16 v27, 0x13

    invoke-virtual/range {v25 .. v25}, Lcom/disney/datg/videoplatforms/sdk/models/api/User;->getCountry()Ljava/lang/String;

    move-result-object v28

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setProp(ILjava/lang/String;)V

    .line 951
    const/16 v27, 0x13

    invoke-virtual/range {v25 .. v25}, Lcom/disney/datg/videoplatforms/sdk/models/api/User;->getCountry()Ljava/lang/String;

    move-result-object v28

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setEvar(ILjava/lang/String;)V

    .line 959
    :cond_15
    :goto_f
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->activity:Landroid/app/Activity;

    move-object/from16 v27, v0

    invoke-virtual/range {v27 .. v27}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v27

    sget v28, Lcom/disney/datg/videoplatforms/sdk/R$string;->omniture_prop25:I

    invoke-virtual/range {v27 .. v28}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v22

    .line 960
    .local v22, "prop25":Ljava/lang/String;
    const-string v27, "%DEVICE_MODEL%"

    sget-object v28, Landroid/os/Build;->MODEL:Ljava/lang/String;

    move-object/from16 v0, v22

    move-object/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v22

    .line 961
    const/16 v27, 0x19

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v22

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setProp(ILjava/lang/String;)V

    .line 962
    const/16 v27, 0x19

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v22

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setEvar(ILjava/lang/String;)V

    .line 965
    const/16 v27, 0x1a

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->activity:Landroid/app/Activity;

    move-object/from16 v28, v0

    invoke-virtual/range {v28 .. v28}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v28

    sget v29, Lcom/disney/datg/videoplatforms/sdk/R$string;->omniture_prop26:I

    invoke-virtual/range {v28 .. v29}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v28

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setProp(ILjava/lang/String;)V

    .line 966
    const/16 v27, 0x1a

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->activity:Landroid/app/Activity;

    move-object/from16 v28, v0

    invoke-virtual/range {v28 .. v28}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v28

    sget v29, Lcom/disney/datg/videoplatforms/sdk/R$string;->omniture_prop26:I

    invoke-virtual/range {v28 .. v29}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v28

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setEvar(ILjava/lang/String;)V

    .line 969
    const/16 v27, 0x1f

    const-string v28, "http.agent"

    invoke-static/range {v28 .. v28}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v28

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setProp(ILjava/lang/String;)V

    .line 970
    const/16 v27, 0x1f

    const-string v28, "http.agent"

    invoke-static/range {v28 .. v28}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v28

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setEvar(ILjava/lang/String;)V

    .line 976
    const/16 v27, 0x34

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->activity:Landroid/app/Activity;

    move-object/from16 v28, v0

    invoke-virtual/range {v28 .. v28}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v28

    sget v29, Lcom/disney/datg/videoplatforms/sdk/R$string;->omniture_prop52:I

    invoke-virtual/range {v28 .. v29}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v28

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setProp(ILjava/lang/String;)V

    .line 977
    const/16 v27, 0x34

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->activity:Landroid/app/Activity;

    move-object/from16 v28, v0

    invoke-virtual/range {v28 .. v28}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v28

    sget v29, Lcom/disney/datg/videoplatforms/sdk/R$string;->omniture_prop52:I

    invoke-virtual/range {v28 .. v29}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v28

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setEvar(ILjava/lang/String;)V

    .line 983
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->activity:Landroid/app/Activity;

    move-object/from16 v27, v0

    invoke-virtual/range {v27 .. v27}, Landroid/app/Activity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v20

    .line 984
    .local v20, "packManager":Landroid/content/pm/PackageManager;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->activity:Landroid/app/Activity;

    move-object/from16 v27, v0

    invoke-virtual/range {v27 .. v27}, Landroid/app/Activity;->getPackageName()Ljava/lang/String;

    move-result-object v21

    .line 985
    .local v21, "packName":Ljava/lang/String;
    const/16 v19, 0x0

    .line 986
    .local v19, "pInfo":Landroid/content/pm/PackageInfo;
    const-string v26, ""

    .line 987
    .local v26, "version":Ljava/lang/String;
    if-eqz v20, :cond_16

    invoke-static/range {v21 .. v21}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v27

    if-nez v27, :cond_16

    .line 989
    const/16 v27, 0x0

    :try_start_1
    move-object/from16 v0, v20

    move-object/from16 v1, v21

    move/from16 v2, v27

    invoke-virtual {v0, v1, v2}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_1
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v19

    .line 994
    :cond_16
    :goto_10
    if-eqz v19, :cond_17

    .line 995
    move-object/from16 v0, v19

    iget-object v0, v0, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    move-object/from16 v26, v0

    .line 997
    :cond_17
    const/16 v27, 0x40

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v26

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setProp(ILjava/lang/String;)V

    .line 998
    const/16 v27, 0x40

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v26

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setEvar(ILjava/lang/String;)V

    .line 999
    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, p1

    move-object/from16 v1, v27

    invoke-virtual {v0, v1}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setEvents(Ljava/lang/String;)V

    .line 1003
    return-void

    .line 878
    .end local v19    # "pInfo":Landroid/content/pm/PackageInfo;
    .end local v20    # "packManager":Landroid/content/pm/PackageManager;
    .end local v21    # "packName":Ljava/lang/String;
    .end local v22    # "prop25":Ljava/lang/String;
    .end local v25    # "user":Lcom/disney/datg/videoplatforms/sdk/models/api/User;
    .end local v26    # "version":Ljava/lang/String;
    :cond_18
    const/16 v27, 0x7

    const-string v28, "None"

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setProp(ILjava/lang/String;)V

    .line 879
    const/16 v27, 0x7

    const-string v28, "None"

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setEvar(ILjava/lang/String;)V

    goto/16 :goto_a

    .line 911
    .restart local v25    # "user":Lcom/disney/datg/videoplatforms/sdk/models/api/User;
    :cond_19
    const/16 v27, 0xf

    const-string v28, "None"

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setProp(ILjava/lang/String;)V

    .line 912
    const/16 v27, 0xf

    const-string v28, "None"

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setEvar(ILjava/lang/String;)V

    goto/16 :goto_b

    .line 920
    :cond_1a
    const/16 v27, 0x10

    const-string v28, "false"

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setProp(ILjava/lang/String;)V

    .line 921
    const/16 v27, 0x10

    const-string v28, "false"

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setEvar(ILjava/lang/String;)V

    goto/16 :goto_c

    .line 931
    :cond_1b
    const/16 v27, 0x11

    const-string v28, "None"

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setProp(ILjava/lang/String;)V

    .line 932
    const/16 v27, 0x11

    const-string v28, "None"

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setEvar(ILjava/lang/String;)V

    goto/16 :goto_d

    .line 942
    :cond_1c
    const/16 v27, 0x12

    const-string v28, "None"

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setProp(ILjava/lang/String;)V

    .line 943
    const/16 v27, 0x12

    const-string v28, "None"

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setEvar(ILjava/lang/String;)V

    goto/16 :goto_e

    .line 953
    :cond_1d
    const/16 v27, 0x13

    const-string v28, "None"

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setProp(ILjava/lang/String;)V

    .line 954
    const/16 v27, 0x13

    const-string v28, "None"

    move-object/from16 v0, p1

    move/from16 v1, v27

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lcom/adobe/adms/measurement/ADMS_Measurement;->setEvar(ILjava/lang/String;)V

    goto/16 :goto_f

    .line 990
    .restart local v19    # "pInfo":Landroid/content/pm/PackageInfo;
    .restart local v20    # "packManager":Landroid/content/pm/PackageManager;
    .restart local v21    # "packName":Ljava/lang/String;
    .restart local v22    # "prop25":Ljava/lang/String;
    .restart local v26    # "version":Ljava/lang/String;
    :catch_1
    move-exception v12

    .line 991
    .local v12, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-static {v12}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->logException(Ljava/lang/Exception;)V

    goto/16 :goto_10
.end method

.method private populateVideoTags(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 31
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    .line 1007
    const-string v9, "None"

    .line 1008
    .local v9, "dayPart":Ljava/lang/String;
    const-string v18, "None"

    .line 1009
    .local v18, "showName":Ljava/lang/String;
    const-string v6, "None"

    .line 1010
    .local v6, "airDate":Ljava/lang/String;
    const-string v13, "None"

    .line 1011
    .local v13, "expireDate":Ljava/lang/String;
    const-string v23, "None"

    .line 1012
    .local v23, "videoEpisodeLength":Ljava/lang/String;
    const-string v11, "None"

    .line 1013
    .local v11, "episodeNumber":Ljava/lang/String;
    const-string v16, "None"

    .line 1014
    .local v16, "releaseDate":Ljava/lang/String;
    const-string v12, "None"

    .line 1015
    .local v12, "episodeTitle":Ljava/lang/String;
    const-string v24, "None"

    .line 1016
    .local v24, "videoGenre":Ljava/lang/String;
    const-string v17, "None"

    .line 1017
    .local v17, "seasonNum":Ljava/lang/String;
    const-string v20, "None"

    .line 1018
    .local v20, "uplynkSessionID":Ljava/lang/String;
    const-string v7, "None"

    .line 1019
    .local v7, "cVideo":Ljava/lang/String;
    const-string v22, "N/A"

    .line 1020
    .local v22, "videoContentType":Ljava/lang/String;
    const-string v21, "N/A"

    .line 1021
    .local v21, "videoAccessPoint":Ljava/lang/String;
    const/4 v4, 0x0

    .line 1023
    .local v4, "act":Landroid/app/Activity;
    if-eqz p1, :cond_1

    invoke-interface/range {p1 .. p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v28

    if-eqz v28, :cond_1

    invoke-interface/range {p1 .. p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v28

    const-string v29, "activity"

    invoke-interface/range {v28 .. v29}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v28

    if-eqz v28, :cond_1

    .line 1024
    invoke-interface/range {p1 .. p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v28

    const-string v29, "activity"

    invoke-interface/range {v28 .. v29}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    .line 1025
    .local v5, "activity":Ljava/lang/Object;
    instance-of v0, v5, Landroid/app/Fragment;

    move/from16 v28, v0

    if-eqz v28, :cond_0

    .line 1026
    check-cast v5, Landroid/app/Fragment;

    .end local v5    # "activity":Ljava/lang/Object;
    invoke-virtual {v5}, Landroid/app/Fragment;->getActivity()Landroid/app/Activity;

    move-result-object v5

    :cond_0
    move-object v4, v5

    .line 1028
    check-cast v4, Landroid/app/Activity;

    .line 1031
    :cond_1
    if-eqz v4, :cond_2

    .line 1032
    invoke-virtual {v4}, Landroid/app/Activity;->getApplication()Landroid/app/Application;

    move-result-object v28

    invoke-virtual/range {v28 .. v28}, Landroid/app/Application;->getResources()Landroid/content/res/Resources;

    move-result-object v28

    sget v29, Lcom/disney/datg/videoplatforms/sdk/R$string;->omniture_prop53:I

    invoke-virtual/range {v28 .. v29}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v25

    .line 1033
    .local v25, "videoPlayerName":Ljava/lang/String;
    const/16 v28, 0x35

    move-object/from16 v0, p1

    move/from16 v1, v28

    move-object/from16 v2, v25

    invoke-interface {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addProp(ILjava/lang/String;)V

    .line 1034
    const/16 v28, 0x35

    move-object/from16 v0, p1

    move/from16 v1, v28

    move-object/from16 v2, v25

    invoke-interface {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvar(ILjava/lang/String;)V

    .line 1037
    invoke-virtual {v4}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v28

    sget v29, Lcom/disney/datg/videoplatforms/sdk/R$string;->omniture_prop54:I

    invoke-virtual/range {v28 .. v29}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v26

    .line 1038
    .local v26, "videoPlayerVersion":Ljava/lang/String;
    const/16 v28, 0x36

    move-object/from16 v0, p1

    move/from16 v1, v28

    move-object/from16 v2, v26

    invoke-interface {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addProp(ILjava/lang/String;)V

    .line 1039
    const/16 v28, 0x36

    move-object/from16 v0, p1

    move/from16 v1, v28

    move-object/from16 v2, v26

    invoke-interface {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvar(ILjava/lang/String;)V

    .line 1042
    .end local v25    # "videoPlayerName":Ljava/lang/String;
    .end local v26    # "videoPlayerVersion":Ljava/lang/String;
    :cond_2
    if-eqz p1, :cond_3

    invoke-interface/range {p1 .. p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v28

    if-eqz v28, :cond_3

    invoke-interface/range {p1 .. p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v28

    const-string v29, "uplynkSessionID"

    invoke-interface/range {v28 .. v29}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v28

    if-eqz v28, :cond_3

    .line 1043
    invoke-interface/range {p1 .. p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v28

    const-string v29, "uplynkSessionID"

    invoke-interface/range {v28 .. v29}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v19

    check-cast v19, Ljava/lang/String;

    .line 1044
    .local v19, "uplynkSession":Ljava/lang/String;
    invoke-static/range {v19 .. v19}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v28

    if-nez v28, :cond_3

    .line 1045
    const/16 v28, 0x39

    move-object/from16 v0, p1

    move/from16 v1, v28

    move-object/from16 v2, v20

    invoke-interface {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addProp(ILjava/lang/String;)V

    .line 1046
    const/16 v28, 0x39

    move-object/from16 v0, p1

    move/from16 v1, v28

    move-object/from16 v2, v20

    invoke-interface {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvar(ILjava/lang/String;)V

    .line 1051
    .end local v19    # "uplynkSession":Ljava/lang/String;
    :cond_3
    const-string v27, "None"

    .line 1052
    .local v27, "videoSDKVersion":Ljava/lang/String;
    const/16 v28, 0x3e

    move-object/from16 v0, p1

    move/from16 v1, v28

    move-object/from16 v2, v27

    invoke-interface {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addProp(ILjava/lang/String;)V

    .line 1053
    const/16 v28, 0x3e

    move-object/from16 v0, p1

    move/from16 v1, v28

    move-object/from16 v2, v27

    invoke-interface {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvar(ILjava/lang/String;)V

    .line 1056
    if-eqz v4, :cond_4

    .line 1057
    invoke-virtual {v4}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v28

    sget v29, Lcom/disney/datg/videoplatforms/sdk/R$string;->omniture_prop63:I

    invoke-virtual/range {v28 .. v29}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v21

    .line 1058
    const/16 v28, 0x3f

    move-object/from16 v0, p1

    move/from16 v1, v28

    move-object/from16 v2, v21

    invoke-interface {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addProp(ILjava/lang/String;)V

    .line 1059
    const/16 v28, 0x3f

    move-object/from16 v0, p1

    move/from16 v1, v28

    move-object/from16 v2, v21

    invoke-interface {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvar(ILjava/lang/String;)V

    .line 1061
    :cond_4
    if-eqz p1, :cond_f

    invoke-interface/range {p1 .. p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v28

    if-eqz v28, :cond_f

    invoke-interface/range {p1 .. p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v28

    const-string v29, "currentMedia"

    invoke-interface/range {v28 .. v29}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v28

    if-eqz v28, :cond_f

    .line 1062
    invoke-interface/range {p1 .. p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v28

    const-string v29, "currentMedia"

    invoke-interface/range {v28 .. v29}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    .line 1063
    .local v8, "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    if-eqz v8, :cond_f

    .line 1066
    sget-object v28, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker$1;->$SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$AccessWindow:[I

    invoke-virtual {v8}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getAccessWindow()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;

    move-result-object v29

    invoke-virtual/range {v29 .. v29}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;->ordinal()I

    move-result v29

    aget v28, v28, v29

    packed-switch v28, :pswitch_data_0

    .line 1079
    :goto_0
    invoke-virtual {v8}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getMediaType()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    move-result-object v28

    invoke-virtual/range {v28 .. v28}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;->getTypes()Ljava/lang/String;

    move-result-object v22

    .line 1081
    const/16 v28, 0x24

    move-object/from16 v0, p1

    move/from16 v1, v28

    move-object/from16 v2, v22

    invoke-interface {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addProp(ILjava/lang/String;)V

    .line 1082
    const/16 v28, 0x24

    move-object/from16 v0, p1

    move/from16 v1, v28

    move-object/from16 v2, v22

    invoke-interface {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvar(ILjava/lang/String;)V

    .line 1084
    instance-of v0, v8, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;

    move/from16 v28, v0

    if-eqz v28, :cond_d

    .line 1087
    check-cast v8, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;

    move-object/from16 v28, v8

    .line 1090
    check-cast v28, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;

    invoke-virtual/range {v28 .. v28}, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->getAirDate()Ljava/lang/String;

    move-result-object v28

    invoke-static/range {v28 .. v28}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v28

    if-nez v28, :cond_5

    move-object/from16 v28, v8

    .line 1091
    check-cast v28, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;

    invoke-virtual/range {v28 .. v28}, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->getAirDate()Ljava/lang/String;

    move-result-object v6

    .line 1093
    :cond_5
    const/16 v28, 0x2b

    move-object/from16 v0, p1

    move/from16 v1, v28

    invoke-interface {v0, v1, v6}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addProp(ILjava/lang/String;)V

    .line 1094
    const/16 v28, 0x2b

    move-object/from16 v0, p1

    move/from16 v1, v28

    invoke-interface {v0, v1, v6}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvar(ILjava/lang/String;)V

    move-object/from16 v28, v8

    .line 1097
    check-cast v28, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;

    invoke-virtual/range {v28 .. v28}, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->getExpireDate()Ljava/lang/String;

    move-result-object v28

    invoke-static/range {v28 .. v28}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v28

    if-nez v28, :cond_6

    move-object/from16 v28, v8

    .line 1099
    check-cast v28, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;

    invoke-virtual/range {v28 .. v28}, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->getExpireDate()Ljava/lang/String;

    move-result-object v13

    .line 1101
    :cond_6
    const/16 v28, 0x2c

    move-object/from16 v0, p1

    move/from16 v1, v28

    invoke-interface {v0, v1, v13}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addProp(ILjava/lang/String;)V

    .line 1102
    const/16 v28, 0x2c

    move-object/from16 v0, p1

    move/from16 v1, v28

    invoke-interface {v0, v1, v13}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvar(ILjava/lang/String;)V

    move-object/from16 v28, v8

    .line 1104
    check-cast v28, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;

    invoke-virtual/range {v28 .. v28}, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->getDuration()J

    move-result-wide v28

    move-wide/from16 v0, v28

    long-to-int v0, v0

    move/from16 v28, v0

    move/from16 v0, v28

    div-int/lit16 v10, v0, 0x3e8

    .line 1105
    .local v10, "duration":I
    new-instance v28, Ljava/lang/StringBuilder;

    invoke-direct/range {v28 .. v28}, Ljava/lang/StringBuilder;-><init>()V

    const-string v29, ""

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    move-object/from16 v0, v28

    invoke-virtual {v0, v10}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v28

    invoke-virtual/range {v28 .. v28}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v23

    .line 1106
    const/16 v28, 0x2d

    move-object/from16 v0, p1

    move/from16 v1, v28

    move-object/from16 v2, v23

    invoke-interface {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addProp(ILjava/lang/String;)V

    .line 1107
    const/16 v28, 0x2d

    move-object/from16 v0, p1

    move/from16 v1, v28

    move-object/from16 v2, v23

    invoke-interface {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvar(ILjava/lang/String;)V

    move-object/from16 v28, v8

    .line 1110
    check-cast v28, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;

    invoke-virtual/range {v28 .. v28}, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->getEpisodeNumber()Ljava/lang/String;

    move-result-object v28

    invoke-static/range {v28 .. v28}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v28

    if-nez v28, :cond_7

    move-object/from16 v28, v8

    .line 1112
    check-cast v28, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;

    invoke-virtual/range {v28 .. v28}, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->getEpisodeNumber()Ljava/lang/String;

    move-result-object v11

    .line 1115
    :cond_7
    const/16 v28, 0x2e

    move-object/from16 v0, p1

    move/from16 v1, v28

    invoke-interface {v0, v1, v11}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addProp(ILjava/lang/String;)V

    .line 1116
    const/16 v28, 0x2e

    move-object/from16 v0, p1

    move/from16 v1, v28

    invoke-interface {v0, v1, v11}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvar(ILjava/lang/String;)V

    move-object/from16 v28, v8

    .line 1119
    check-cast v28, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;

    invoke-virtual/range {v28 .. v28}, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->getAvailableDate()Ljava/lang/String;

    move-result-object v28

    invoke-static/range {v28 .. v28}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v28

    if-nez v28, :cond_8

    move-object/from16 v28, v8

    .line 1121
    check-cast v28, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;

    invoke-virtual/range {v28 .. v28}, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->getAvailableDate()Ljava/lang/String;

    move-result-object v16

    .line 1124
    :cond_8
    const/16 v28, 0x2f

    move-object/from16 v0, p1

    move/from16 v1, v28

    move-object/from16 v2, v16

    invoke-interface {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addProp(ILjava/lang/String;)V

    .line 1125
    const/16 v28, 0x2f

    move-object/from16 v0, p1

    move/from16 v1, v28

    move-object/from16 v2, v16

    invoke-interface {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvar(ILjava/lang/String;)V

    move-object/from16 v28, v8

    .line 1128
    check-cast v28, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;

    invoke-virtual/range {v28 .. v28}, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->getSeasonNumber()Ljava/lang/String;

    move-result-object v28

    invoke-static/range {v28 .. v28}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v28

    if-nez v28, :cond_9

    move-object/from16 v28, v8

    .line 1130
    check-cast v28, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;

    invoke-virtual/range {v28 .. v28}, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->getSeasonNumber()Ljava/lang/String;

    move-result-object v17

    .line 1133
    :cond_9
    const/16 v28, 0x37

    move-object/from16 v0, p1

    move/from16 v1, v28

    move-object/from16 v2, v17

    invoke-interface {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addProp(ILjava/lang/String;)V

    .line 1134
    const/16 v28, 0x37

    move-object/from16 v0, p1

    move/from16 v1, v28

    move-object/from16 v2, v17

    invoke-interface {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvar(ILjava/lang/String;)V

    move-object/from16 v28, v8

    .line 1138
    check-cast v28, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;

    invoke-virtual/range {v28 .. v28}, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->getDayPart()Ljava/lang/String;

    move-result-object v28

    invoke-static/range {v28 .. v28}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v28

    if-nez v28, :cond_a

    move-object/from16 v28, v8

    .line 1140
    check-cast v28, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;

    invoke-virtual/range {v28 .. v28}, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->getDayPart()Ljava/lang/String;

    move-result-object v9

    .line 1142
    :cond_a
    const/16 v28, 0x25

    move-object/from16 v0, p1

    move/from16 v1, v28

    invoke-interface {v0, v1, v9}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addProp(ILjava/lang/String;)V

    .line 1143
    const/16 v28, 0x25

    move-object/from16 v0, p1

    move/from16 v1, v28

    invoke-interface {v0, v1, v9}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvar(ILjava/lang/String;)V

    move-object/from16 v28, v8

    .line 1147
    check-cast v28, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;

    invoke-virtual/range {v28 .. v28}, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->getCGenre()Ljava/lang/String;

    move-result-object v28

    invoke-static/range {v28 .. v28}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v28

    if-nez v28, :cond_b

    move-object/from16 v28, v8

    .line 1149
    check-cast v28, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;

    invoke-virtual/range {v28 .. v28}, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->getCGenre()Ljava/lang/String;

    move-result-object v24

    .line 1151
    :cond_b
    const/16 v28, 0x33

    move-object/from16 v0, p1

    move/from16 v1, v28

    move-object/from16 v2, v24

    invoke-interface {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addProp(ILjava/lang/String;)V

    .line 1152
    const/16 v28, 0x33

    move-object/from16 v0, p1

    move/from16 v1, v28

    move-object/from16 v2, v24

    invoke-interface {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvar(ILjava/lang/String;)V

    move-object/from16 v28, v8

    .line 1156
    check-cast v28, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;

    invoke-virtual/range {v28 .. v28}, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->getCShowName()Ljava/lang/String;

    move-result-object v28

    invoke-static/range {v28 .. v28}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v28

    if-nez v28, :cond_c

    move-object/from16 v28, v8

    .line 1158
    check-cast v28, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;

    invoke-virtual/range {v28 .. v28}, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->getCShowName()Ljava/lang/String;

    move-result-object v18

    .line 1160
    :cond_c
    const/16 v28, 0x38

    move-object/from16 v0, p1

    move/from16 v1, v28

    move-object/from16 v2, v18

    invoke-interface {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addProp(ILjava/lang/String;)V

    .line 1161
    const/16 v28, 0x38

    move-object/from16 v0, p1

    move/from16 v1, v28

    move-object/from16 v2, v18

    invoke-interface {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvar(ILjava/lang/String;)V

    move-object/from16 v28, v8

    .line 1163
    check-cast v28, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;

    invoke-virtual/range {v28 .. v28}, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->getCVideo()Ljava/lang/String;

    move-result-object v28

    invoke-static/range {v28 .. v28}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v28

    if-nez v28, :cond_d

    move-object/from16 v28, v8

    .line 1165
    check-cast v28, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;

    invoke-virtual/range {v28 .. v28}, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->getCVideo()Ljava/lang/String;

    move-result-object v7

    .line 1170
    .end local v10    # "duration":I
    :cond_d
    invoke-virtual {v8}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getMediaTitle()Ljava/lang/String;

    move-result-object v28

    invoke-static/range {v28 .. v28}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v28

    if-nez v28, :cond_e

    .line 1172
    invoke-virtual {v8}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getMediaTitle()Ljava/lang/String;

    move-result-object v12

    .line 1173
    invoke-static {v12}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->makeOmnitureStringFormat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    .line 1175
    :cond_e
    const/16 v28, 0x30

    move-object/from16 v0, p1

    move/from16 v1, v28

    invoke-interface {v0, v1, v12}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addProp(ILjava/lang/String;)V

    .line 1176
    const/16 v28, 0x30

    move-object/from16 v0, p1

    move/from16 v1, v28

    invoke-interface {v0, v1, v12}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvar(ILjava/lang/String;)V

    .line 1180
    new-instance v28, Ljava/lang/StringBuilder;

    invoke-direct/range {v28 .. v28}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v29

    sget v30, Lcom/disney/datg/videoplatforms/sdk/R$string;->omniture_prefix:I

    invoke-virtual/range {v29 .. v30}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v29

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    const-string v29, ":"

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    invoke-static/range {v22 .. v22}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->makeOmnitureStringFormat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v29

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    const-string v29, ":"

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    invoke-static/range {v21 .. v21}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->makeOmnitureStringFormat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v29

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    const-string v29, ":"

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    sget-object v29, Landroid/os/Build;->MODEL:Ljava/lang/String;

    invoke-static/range {v29 .. v29}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->makeOmnitureStringFormat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v29

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    const-string v29, ":"

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    invoke-static {v9}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->makeOmnitureStringFormat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v29

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    const-string v29, ":"

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    invoke-static/range {v24 .. v24}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->makeOmnitureStringFormat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v29

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    const-string v29, ":"

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    invoke-static/range {v18 .. v18}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->makeOmnitureStringFormat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v29

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    const-string v29, ":"

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    invoke-static {v7}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->makeOmnitureStringFormat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v29

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    const-string v29, ":"

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    invoke-static {v12}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->makeOmnitureStringFormat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v29

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    invoke-virtual/range {v28 .. v28}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v14

    .line 1189
    .local v14, "prop35":Ljava/lang/String;
    const/16 v28, 0x23

    move-object/from16 v0, p1

    move/from16 v1, v28

    invoke-interface {v0, v1, v14}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addProp(ILjava/lang/String;)V

    .line 1190
    const/16 v28, 0x23

    move-object/from16 v0, p1

    move/from16 v1, v28

    invoke-interface {v0, v1, v14}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvar(ILjava/lang/String;)V

    .line 1193
    new-instance v28, Ljava/lang/StringBuilder;

    invoke-direct/range {v28 .. v28}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v29

    sget v30, Lcom/disney/datg/videoplatforms/sdk/R$string;->omniture_old_prefix:I

    invoke-virtual/range {v29 .. v30}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v29

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    const-string v29, ":"

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    sget-object v29, Landroid/os/Build;->MODEL:Ljava/lang/String;

    invoke-static/range {v29 .. v29}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->makeOmnitureStringFormat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v29

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    const-string v29, ":content"

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    const-string v29, ":"

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    invoke-static/range {v18 .. v18}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->makeOmnitureStringFormat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v29

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    const-string v29, ":"

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    invoke-static {v7}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->makeOmnitureStringFormat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v29

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    const-string v29, ":"

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    invoke-static {v12}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->makeOmnitureStringFormat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v29

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    invoke-virtual/range {v28 .. v28}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    .line 1199
    .local v15, "prop65":Ljava/lang/String;
    const/16 v28, 0x41

    move-object/from16 v0, p1

    move/from16 v1, v28

    invoke-interface {v0, v1, v15}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addProp(ILjava/lang/String;)V

    .line 1200
    const/16 v28, 0x41

    move-object/from16 v0, p1

    move/from16 v1, v28

    invoke-interface {v0, v1, v15}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvar(ILjava/lang/String;)V

    .line 1203
    .end local v8    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    .end local v14    # "prop35":Ljava/lang/String;
    .end local v15    # "prop65":Ljava/lang/String;
    :cond_f
    return-void

    .line 1069
    .restart local v8    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    :pswitch_0
    const/16 v28, 0xa

    const-string v29, "false"

    move-object/from16 v0, p1

    move/from16 v1, v28

    move-object/from16 v2, v29

    invoke-interface {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addProp(ILjava/lang/String;)V

    .line 1070
    const/16 v28, 0xa

    const-string v29, "false"

    move-object/from16 v0, p1

    move/from16 v1, v28

    move-object/from16 v2, v29

    invoke-interface {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvar(ILjava/lang/String;)V

    goto/16 :goto_0

    .line 1073
    :pswitch_1
    const/16 v28, 0xa

    const-string v29, "true"

    move-object/from16 v0, p1

    move/from16 v1, v28

    move-object/from16 v2, v29

    invoke-interface {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addProp(ILjava/lang/String;)V

    .line 1074
    const/16 v28, 0xa

    const-string v29, "true"

    move-object/from16 v0, p1

    move/from16 v1, v28

    move-object/from16 v2, v29

    invoke-interface {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvar(ILjava/lang/String;)V

    goto/16 :goto_0

    .line 1066
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method


# virtual methods
.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 88
    const-string v0, "OMNITURE TRACKER"

    return-object v0
.end method

.method public setConfiguration(Lcom/disney/datg/videoplatforms/sdk/media/Configuration;)V
    .locals 0
    .param p1, "configuration"    # Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

    .prologue
    .line 77
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->configuration:Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

    .line 78
    return-void
.end method

.method public trackAdBreakEnd(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 0
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    .line 218
    return-void
.end method

.method public trackAdBreakStart(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 0
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    .line 213
    return-void
.end method

.method public trackAdEnd(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 14
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    const/4 v13, 0x1

    const/4 v12, 0x0

    .line 264
    if-eqz p1, :cond_1

    :try_start_0
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    if-eqz v7, :cond_1

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    const-string v8, "activity"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    if-eqz v7, :cond_1

    .line 265
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    const-string v8, "activity"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .line 266
    .local v2, "activity":Ljava/lang/Object;
    instance-of v7, v2, Landroid/app/Fragment;

    if-eqz v7, :cond_0

    .line 267
    check-cast v2, Landroid/app/Fragment;

    .end local v2    # "activity":Ljava/lang/Object;
    invoke-virtual {v2}, Landroid/app/Fragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    .line 269
    :cond_0
    move-object v0, v2

    check-cast v0, Landroid/app/Activity;

    move-object v1, v0

    .line 270
    .local v1, "act":Landroid/app/Activity;
    if-eqz p1, :cond_1

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    if-eqz v7, :cond_1

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    const-string v8, "currentMedia"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    if-eqz v7, :cond_1

    .line 272
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    const-string v8, "currentMedia"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    .line 273
    .local v3, "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    if-eqz v3, :cond_1

    .line 275
    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getMediaType()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    move-result-object v7

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;->getTypes()Ljava/lang/String;

    move-result-object v6

    .line 276
    .local v6, "videoContentType":Ljava/lang/String;
    const-string v5, ""

    .line 277
    .local v5, "trackableEvent":Ljava/lang/String;
    sget-object v7, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker$1;->$SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$MediaType:[I

    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getMediaType()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    move-result-object v8

    invoke-virtual {v8}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;->ordinal()I

    move-result v8

    aget v7, v7, v8

    packed-switch v7, :pswitch_data_0

    .line 290
    :goto_0
    invoke-direct {p0, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->populateVideoTags(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    .line 291
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->getName()Ljava/lang/String;

    move-result-object v7

    const-string v8, "trackAdEnd"

    invoke-static {v7, v8}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 292
    const-string v7, "o"

    invoke-virtual {p0, v7, v5, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->trackLink(Ljava/lang/String;Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    .line 299
    .end local v1    # "act":Landroid/app/Activity;
    .end local v3    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    .end local v5    # "trackableEvent":Ljava/lang/String;
    .end local v6    # "videoContentType":Ljava/lang/String;
    :cond_1
    :goto_1
    return-void

    .line 279
    .restart local v1    # "act":Landroid/app/Activity;
    .restart local v3    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    .restart local v5    # "trackableEvent":Ljava/lang/String;
    .restart local v6    # "videoContentType":Ljava/lang/String;
    :pswitch_0
    const-string v7, "event20"

    invoke-interface {p1, v7}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvent(Ljava/lang/String;)V

    .line 280
    const-string v7, "%s:%s:video ad end"

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v10

    sget v11, Lcom/disney/datg/videoplatforms/sdk/R$string;->omniture_prefix:I

    invoke-virtual {v10, v11}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v9

    const/4 v9, 0x1

    aput-object v6, v8, v9

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    .line 282
    goto :goto_0

    .line 284
    :pswitch_1
    const-string v7, "event20"

    invoke-interface {p1, v7}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvent(Ljava/lang/String;)V

    .line 285
    const-string v7, "%s:%s:feed ad end"

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v10

    sget v11, Lcom/disney/datg/videoplatforms/sdk/R$string;->omniture_prefix:I

    invoke-virtual {v10, v11}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v9

    const/4 v9, 0x1

    aput-object v6, v8, v9

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v5

    goto :goto_0

    .line 296
    .end local v1    # "act":Landroid/app/Activity;
    .end local v3    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    .end local v5    # "trackableEvent":Ljava/lang/String;
    .end local v6    # "videoContentType":Ljava/lang/String;
    :catch_0
    move-exception v4

    .line 297
    .local v4, "e":Ljava/lang/Exception;
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->getName()Ljava/lang/String;

    move-result-object v7

    const-string v8, "trackAdEnd could not be executed : %s"

    new-array v9, v13, [Ljava/lang/Object;

    invoke-virtual {v4}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v10

    aput-object v10, v9, v12

    invoke-static {v8, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 277
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public trackAdError(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 0
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    .line 305
    return-void
.end method

.method public trackAdFirstQuartile(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 0
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    .line 311
    return-void
.end method

.method public trackAdMidpoint(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 0
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    .line 317
    return-void
.end method

.method public trackAdStart(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 14
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    const/4 v13, 0x1

    const/4 v12, 0x0

    .line 223
    if-eqz p1, :cond_1

    :try_start_0
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    if-eqz v7, :cond_1

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    const-string v8, "activity"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    if-eqz v7, :cond_1

    .line 224
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    const-string v8, "activity"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .line 225
    .local v2, "activity":Ljava/lang/Object;
    instance-of v7, v2, Landroid/app/Fragment;

    if-eqz v7, :cond_0

    .line 226
    check-cast v2, Landroid/app/Fragment;

    .end local v2    # "activity":Ljava/lang/Object;
    invoke-virtual {v2}, Landroid/app/Fragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    .line 228
    :cond_0
    move-object v0, v2

    check-cast v0, Landroid/app/Activity;

    move-object v1, v0

    .line 229
    .local v1, "act":Landroid/app/Activity;
    if-eqz p1, :cond_1

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    if-eqz v7, :cond_1

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    const-string v8, "currentMedia"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    if-eqz v7, :cond_1

    .line 231
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    const-string v8, "currentMedia"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    .line 232
    .local v3, "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    if-eqz v3, :cond_1

    .line 234
    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getMediaType()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    move-result-object v7

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;->getTypes()Ljava/lang/String;

    move-result-object v6

    .line 235
    .local v6, "videoContentType":Ljava/lang/String;
    const-string v5, ""

    .line 236
    .local v5, "trackableEvent":Ljava/lang/String;
    sget-object v7, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker$1;->$SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$MediaType:[I

    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getMediaType()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    move-result-object v8

    invoke-virtual {v8}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;->ordinal()I

    move-result v8

    aget v7, v7, v8

    packed-switch v7, :pswitch_data_0

    .line 249
    :goto_0
    invoke-direct {p0, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->populateVideoTags(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    .line 250
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->getName()Ljava/lang/String;

    move-result-object v7

    const-string v8, "trackAdStart"

    invoke-static {v7, v8}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 251
    const-string v7, "o"

    invoke-virtual {p0, v7, v5, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->trackLink(Ljava/lang/String;Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    .line 258
    .end local v1    # "act":Landroid/app/Activity;
    .end local v3    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    .end local v5    # "trackableEvent":Ljava/lang/String;
    .end local v6    # "videoContentType":Ljava/lang/String;
    :cond_1
    :goto_1
    return-void

    .line 238
    .restart local v1    # "act":Landroid/app/Activity;
    .restart local v3    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    .restart local v5    # "trackableEvent":Ljava/lang/String;
    .restart local v6    # "videoContentType":Ljava/lang/String;
    :pswitch_0
    const-string v7, "event19"

    invoke-interface {p1, v7}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvent(Ljava/lang/String;)V

    .line 239
    const-string v7, "%s:%s:video ad start"

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v10

    sget v11, Lcom/disney/datg/videoplatforms/sdk/R$string;->omniture_prefix:I

    invoke-virtual {v10, v11}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v9

    const/4 v9, 0x1

    aput-object v6, v8, v9

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    .line 241
    goto :goto_0

    .line 243
    :pswitch_1
    const-string v7, "event19"

    invoke-interface {p1, v7}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvent(Ljava/lang/String;)V

    .line 244
    const-string v7, "%s:%s:feed ad start"

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v10

    sget v11, Lcom/disney/datg/videoplatforms/sdk/R$string;->omniture_prefix:I

    invoke-virtual {v10, v11}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v9

    const/4 v9, 0x1

    aput-object v6, v8, v9

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v5

    goto :goto_0

    .line 255
    .end local v1    # "act":Landroid/app/Activity;
    .end local v3    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    .end local v5    # "trackableEvent":Ljava/lang/String;
    .end local v6    # "videoContentType":Ljava/lang/String;
    :catch_0
    move-exception v4

    .line 256
    .local v4, "e":Ljava/lang/Exception;
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->getName()Ljava/lang/String;

    move-result-object v7

    const-string v8, "trackAdStart could not be executed : %s"

    new-array v9, v13, [Ljava/lang/Object;

    invoke-virtual {v4}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v10

    aput-object v10, v9, v12

    invoke-static {v8, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 236
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public trackAdThirdQuartile(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 0
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    .line 323
    return-void
.end method

.method public trackAuthZFailure(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 14
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    const/4 v13, 0x1

    const/4 v12, 0x0

    .line 173
    if-eqz p1, :cond_1

    :try_start_0
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    if-eqz v7, :cond_1

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    const-string v8, "activity"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    if-eqz v7, :cond_1

    .line 174
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    const-string v8, "activity"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .line 175
    .local v2, "activity":Ljava/lang/Object;
    instance-of v7, v2, Landroid/app/Fragment;

    if-eqz v7, :cond_0

    .line 176
    check-cast v2, Landroid/app/Fragment;

    .end local v2    # "activity":Ljava/lang/Object;
    invoke-virtual {v2}, Landroid/app/Fragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    .line 178
    :cond_0
    move-object v0, v2

    check-cast v0, Landroid/app/Activity;

    move-object v1, v0

    .line 179
    .local v1, "act":Landroid/app/Activity;
    if-eqz p1, :cond_1

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    if-eqz v7, :cond_1

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    const-string v8, "currentMedia"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    if-eqz v7, :cond_1

    .line 181
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    const-string v8, "currentMedia"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    .line 182
    .local v3, "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    if-eqz v3, :cond_1

    .line 184
    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getMediaType()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    move-result-object v7

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;->getTypes()Ljava/lang/String;

    move-result-object v6

    .line 185
    .local v6, "videoContentType":Ljava/lang/String;
    const-string v5, ""

    .line 186
    .local v5, "trackableEvent":Ljava/lang/String;
    sget-object v7, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker$1;->$SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$MediaType:[I

    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getMediaType()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    move-result-object v8

    invoke-virtual {v8}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;->ordinal()I

    move-result v8

    aget v7, v7, v8

    packed-switch v7, :pswitch_data_0

    .line 199
    :goto_0
    invoke-direct {p0, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->populateVideoTags(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    .line 200
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->getName()Ljava/lang/String;

    move-result-object v7

    const-string v8, "trackAuthZFailure"

    invoke-static {v7, v8}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 201
    const-string v7, "o"

    invoke-virtual {p0, v7, v5, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->trackLink(Ljava/lang/String;Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    .line 208
    .end local v1    # "act":Landroid/app/Activity;
    .end local v3    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    .end local v5    # "trackableEvent":Ljava/lang/String;
    .end local v6    # "videoContentType":Ljava/lang/String;
    :cond_1
    :goto_1
    return-void

    .line 188
    .restart local v1    # "act":Landroid/app/Activity;
    .restart local v3    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    .restart local v5    # "trackableEvent":Ljava/lang/String;
    .restart local v6    # "videoContentType":Ljava/lang/String;
    :pswitch_0
    const-string v7, "event3"

    invoke-interface {p1, v7}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvent(Ljava/lang/String;)V

    .line 189
    const-string v7, "%s:%s:video playback:authorization fail"

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v10

    sget v11, Lcom/disney/datg/videoplatforms/sdk/R$string;->omniture_prefix:I

    invoke-virtual {v10, v11}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v9

    const/4 v9, 0x1

    aput-object v6, v8, v9

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    .line 191
    goto :goto_0

    .line 193
    :pswitch_1
    const-string v7, "event3"

    invoke-interface {p1, v7}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvent(Ljava/lang/String;)V

    .line 194
    const-string v7, "%s:%s:feed:authorization fail"

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v10

    sget v11, Lcom/disney/datg/videoplatforms/sdk/R$string;->omniture_prefix:I

    invoke-virtual {v10, v11}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v9

    const/4 v9, 0x1

    aput-object v6, v8, v9

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v5

    goto :goto_0

    .line 205
    .end local v1    # "act":Landroid/app/Activity;
    .end local v3    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    .end local v5    # "trackableEvent":Ljava/lang/String;
    .end local v6    # "videoContentType":Ljava/lang/String;
    :catch_0
    move-exception v4

    .line 206
    .local v4, "e":Ljava/lang/Exception;
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->getName()Ljava/lang/String;

    move-result-object v7

    const-string v8, "trackAuthZFailure could not be executed : %s"

    new-array v9, v13, [Ljava/lang/Object;

    invoke-virtual {v4}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v10

    aput-object v10, v9, v12

    invoke-static {v8, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 186
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public trackAuthZStarted(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 14
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    const/4 v13, 0x1

    const/4 v12, 0x0

    .line 94
    if-eqz p1, :cond_1

    :try_start_0
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    if-eqz v7, :cond_1

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    const-string v8, "activity"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    if-eqz v7, :cond_1

    .line 95
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    const-string v8, "activity"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .line 96
    .local v2, "activity":Ljava/lang/Object;
    instance-of v7, v2, Landroid/app/Fragment;

    if-eqz v7, :cond_0

    .line 97
    check-cast v2, Landroid/app/Fragment;

    .end local v2    # "activity":Ljava/lang/Object;
    invoke-virtual {v2}, Landroid/app/Fragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    .line 99
    :cond_0
    move-object v0, v2

    check-cast v0, Landroid/app/Activity;

    move-object v1, v0

    .line 100
    .local v1, "act":Landroid/app/Activity;
    if-eqz p1, :cond_1

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    if-eqz v7, :cond_1

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    const-string v8, "currentMedia"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    if-eqz v7, :cond_1

    .line 102
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    const-string v8, "currentMedia"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    .line 103
    .local v3, "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    if-eqz v3, :cond_1

    .line 105
    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getMediaType()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    move-result-object v7

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;->getTypes()Ljava/lang/String;

    move-result-object v6

    .line 106
    .local v6, "videoContentType":Ljava/lang/String;
    const-string v5, ""

    .line 107
    .local v5, "trackableEvent":Ljava/lang/String;
    sget-object v7, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker$1;->$SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$MediaType:[I

    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getMediaType()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    move-result-object v8

    invoke-virtual {v8}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;->ordinal()I

    move-result v8

    aget v7, v7, v8

    packed-switch v7, :pswitch_data_0

    .line 120
    :goto_0
    invoke-direct {p0, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->populateVideoTags(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    .line 121
    const-string v7, "o"

    invoke-virtual {p0, v7, v5, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->trackLink(Ljava/lang/String;Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    .line 128
    .end local v1    # "act":Landroid/app/Activity;
    .end local v3    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    .end local v5    # "trackableEvent":Ljava/lang/String;
    .end local v6    # "videoContentType":Ljava/lang/String;
    :cond_1
    :goto_1
    return-void

    .line 109
    .restart local v1    # "act":Landroid/app/Activity;
    .restart local v3    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    .restart local v5    # "trackableEvent":Ljava/lang/String;
    .restart local v6    # "videoContentType":Ljava/lang/String;
    :pswitch_0
    const-string v7, "event2"

    invoke-interface {p1, v7}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvent(Ljava/lang/String;)V

    .line 110
    const-string v7, "%s:%s:video playback:authorization attempt"

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v10

    sget v11, Lcom/disney/datg/videoplatforms/sdk/R$string;->omniture_prefix:I

    invoke-virtual {v10, v11}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v9

    const/4 v9, 0x1

    aput-object v6, v8, v9

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    .line 112
    goto :goto_0

    .line 114
    :pswitch_1
    const-string v7, "event2"

    invoke-interface {p1, v7}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvent(Ljava/lang/String;)V

    .line 115
    const-string v7, "%s:%s:feed:authorization attempt"

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v10

    sget v11, Lcom/disney/datg/videoplatforms/sdk/R$string;->omniture_prefix:I

    invoke-virtual {v10, v11}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v9

    const/4 v9, 0x1

    aput-object v6, v8, v9

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v5

    goto :goto_0

    .line 125
    .end local v1    # "act":Landroid/app/Activity;
    .end local v3    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    .end local v5    # "trackableEvent":Ljava/lang/String;
    .end local v6    # "videoContentType":Ljava/lang/String;
    :catch_0
    move-exception v4

    .line 126
    .local v4, "e":Ljava/lang/Exception;
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->getName()Ljava/lang/String;

    move-result-object v7

    const-string v8, "trackAuthZStarted could not be executed : %s"

    new-array v9, v13, [Ljava/lang/Object;

    invoke-virtual {v4}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v10

    aput-object v10, v9, v12

    invoke-static {v8, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 107
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public trackAuthZSuccess(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 14
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    const/4 v13, 0x1

    const/4 v12, 0x0

    .line 133
    if-eqz p1, :cond_1

    :try_start_0
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    if-eqz v7, :cond_1

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    const-string v8, "activity"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    if-eqz v7, :cond_1

    .line 134
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    const-string v8, "activity"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .line 135
    .local v2, "activity":Ljava/lang/Object;
    instance-of v7, v2, Landroid/app/Fragment;

    if-eqz v7, :cond_0

    .line 136
    check-cast v2, Landroid/app/Fragment;

    .end local v2    # "activity":Ljava/lang/Object;
    invoke-virtual {v2}, Landroid/app/Fragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    .line 138
    :cond_0
    move-object v0, v2

    check-cast v0, Landroid/app/Activity;

    move-object v1, v0

    .line 139
    .local v1, "act":Landroid/app/Activity;
    if-eqz p1, :cond_1

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    if-eqz v7, :cond_1

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    const-string v8, "currentMedia"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    if-eqz v7, :cond_1

    .line 141
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    const-string v8, "currentMedia"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    .line 142
    .local v3, "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    if-eqz v3, :cond_1

    .line 144
    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getMediaType()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    move-result-object v7

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;->getTypes()Ljava/lang/String;

    move-result-object v6

    .line 145
    .local v6, "videoContentType":Ljava/lang/String;
    const-string v5, ""

    .line 146
    .local v5, "trackableEvent":Ljava/lang/String;
    sget-object v7, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker$1;->$SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$MediaType:[I

    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getMediaType()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    move-result-object v8

    invoke-virtual {v8}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;->ordinal()I

    move-result v8

    aget v7, v7, v8

    packed-switch v7, :pswitch_data_0

    .line 159
    :goto_0
    invoke-direct {p0, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->populateVideoTags(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    .line 160
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->getName()Ljava/lang/String;

    move-result-object v7

    const-string v8, "trackAuthZSuccess"

    invoke-static {v7, v8}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 161
    const-string v7, "o"

    invoke-virtual {p0, v7, v5, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->trackLink(Ljava/lang/String;Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    .line 168
    .end local v1    # "act":Landroid/app/Activity;
    .end local v3    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    .end local v5    # "trackableEvent":Ljava/lang/String;
    .end local v6    # "videoContentType":Ljava/lang/String;
    :cond_1
    :goto_1
    return-void

    .line 148
    .restart local v1    # "act":Landroid/app/Activity;
    .restart local v3    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    .restart local v5    # "trackableEvent":Ljava/lang/String;
    .restart local v6    # "videoContentType":Ljava/lang/String;
    :pswitch_0
    const-string v7, "event4"

    invoke-interface {p1, v7}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvent(Ljava/lang/String;)V

    .line 149
    const-string v7, "%s:%s:video playback:authorization success"

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v10

    sget v11, Lcom/disney/datg/videoplatforms/sdk/R$string;->omniture_prefix:I

    invoke-virtual {v10, v11}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v9

    const/4 v9, 0x1

    aput-object v6, v8, v9

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    .line 151
    goto :goto_0

    .line 153
    :pswitch_1
    const-string v7, "event4"

    invoke-interface {p1, v7}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvent(Ljava/lang/String;)V

    .line 154
    const-string v7, "%s:%s:feed:authorization success"

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v10

    sget v11, Lcom/disney/datg/videoplatforms/sdk/R$string;->omniture_prefix:I

    invoke-virtual {v10, v11}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v9

    const/4 v9, 0x1

    aput-object v6, v8, v9

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v5

    goto :goto_0

    .line 165
    .end local v1    # "act":Landroid/app/Activity;
    .end local v3    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    .end local v5    # "trackableEvent":Ljava/lang/String;
    .end local v6    # "videoContentType":Ljava/lang/String;
    :catch_0
    move-exception v4

    .line 166
    .local v4, "e":Ljava/lang/Exception;
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->getName()Ljava/lang/String;

    move-result-object v7

    const-string v8, "trackAuthZSuccess could not be executed : %s"

    new-array v9, v13, [Ljava/lang/Object;

    invoke-virtual {v4}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v10

    aput-object v10, v9, v12

    invoke-static {v8, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 146
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public trackLink(Ljava/lang/String;Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 8
    .param p1, "linkType"    # Ljava/lang/String;
    .param p2, "linkName"    # Ljava/lang/String;
    .param p3, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    .line 645
    if-eqz p3, :cond_1

    :try_start_0
    invoke-interface {p3}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v1

    if-eqz v1, :cond_1

    invoke-interface {p3}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v1

    const-string v2, "activity"

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 646
    invoke-interface {p3}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v1

    const-string v2, "activity"

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    .line 647
    .local v6, "activity":Ljava/lang/Object;
    instance-of v1, v6, Landroid/app/Fragment;

    if-eqz v1, :cond_0

    .line 648
    check-cast v6, Landroid/app/Fragment;

    .end local v6    # "activity":Ljava/lang/Object;
    invoke-virtual {v6}, Landroid/app/Fragment;->getActivity()Landroid/app/Activity;

    move-result-object v6

    .line 650
    :cond_0
    check-cast v6, Landroid/app/Activity;

    invoke-static {v6}, Lcom/adobe/adms/measurement/ADMS_Measurement;->sharedInstance(Landroid/content/Context;)Lcom/adobe/adms/measurement/ADMS_Measurement;

    move-result-object v0

    .line 651
    .local v0, "measurement":Lcom/adobe/adms/measurement/ADMS_Measurement;
    invoke-direct {p0, v0, p3}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->populate(Lcom/adobe/adms/measurement/ADMS_Measurement;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    .line 652
    const/4 v1, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    move-object v2, p1

    move-object v3, p2

    invoke-virtual/range {v0 .. v5}, Lcom/adobe/adms/measurement/ADMS_Measurement;->trackLink(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Hashtable;Ljava/util/Hashtable;)V

    .line 653
    invoke-virtual {v0}, Lcom/adobe/adms/measurement/ADMS_Measurement;->clearVars()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 658
    .end local v0    # "measurement":Lcom/adobe/adms/measurement/ADMS_Measurement;
    :cond_1
    :goto_0
    return-void

    .line 655
    :catch_0
    move-exception v7

    .line 656
    .local v7, "e":Ljava/lang/Exception;
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->getName()Ljava/lang/String;

    move-result-object v1

    const-string v2, "trackLink could not be executed : %s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-virtual {v7}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public trackMediaComplete(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 14
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    const/4 v13, 0x1

    const/4 v12, 0x0

    .line 552
    if-eqz p1, :cond_1

    :try_start_0
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    if-eqz v7, :cond_1

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    const-string v8, "activity"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    if-eqz v7, :cond_1

    .line 553
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    const-string v8, "activity"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .line 554
    .local v2, "activity":Ljava/lang/Object;
    instance-of v7, v2, Landroid/app/Fragment;

    if-eqz v7, :cond_0

    .line 555
    check-cast v2, Landroid/app/Fragment;

    .end local v2    # "activity":Ljava/lang/Object;
    invoke-virtual {v2}, Landroid/app/Fragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    .line 557
    :cond_0
    move-object v0, v2

    check-cast v0, Landroid/app/Activity;

    move-object v1, v0

    .line 558
    .local v1, "act":Landroid/app/Activity;
    if-eqz p1, :cond_1

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    if-eqz v7, :cond_1

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    const-string v8, "currentMedia"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    if-eqz v7, :cond_1

    .line 560
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    const-string v8, "currentMedia"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    .line 561
    .local v3, "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    if-eqz v3, :cond_1

    .line 563
    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getMediaType()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    move-result-object v7

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;->getTypes()Ljava/lang/String;

    move-result-object v6

    .line 564
    .local v6, "videoContentType":Ljava/lang/String;
    const-string v5, ""

    .line 566
    .local v5, "trackableEvent":Ljava/lang/String;
    sget-object v7, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker$1;->$SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$MediaType:[I

    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getMediaType()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    move-result-object v8

    invoke-virtual {v8}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;->ordinal()I

    move-result v8

    aget v7, v7, v8

    packed-switch v7, :pswitch_data_0

    .line 579
    :goto_0
    invoke-direct {p0, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->populateVideoTags(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    .line 580
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->getName()Ljava/lang/String;

    move-result-object v7

    const-string v8, "trackMediaComplete"

    invoke-static {v7, v8}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 581
    const-string v7, "o"

    invoke-virtual {p0, v7, v5, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->trackLink(Ljava/lang/String;Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    .line 589
    .end local v1    # "act":Landroid/app/Activity;
    .end local v3    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    .end local v5    # "trackableEvent":Ljava/lang/String;
    .end local v6    # "videoContentType":Ljava/lang/String;
    :cond_1
    :goto_1
    return-void

    .line 568
    .restart local v1    # "act":Landroid/app/Activity;
    .restart local v3    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    .restart local v5    # "trackableEvent":Ljava/lang/String;
    .restart local v6    # "videoContentType":Ljava/lang/String;
    :pswitch_0
    const-string v7, "event11"

    invoke-interface {p1, v7}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvent(Ljava/lang/String;)V

    .line 569
    const-string v7, "event18"

    invoke-interface {p1, v7}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvent(Ljava/lang/String;)V

    .line 570
    const-string v7, "%s:%s:video playback:episode complete"

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v10

    sget v11, Lcom/disney/datg/videoplatforms/sdk/R$string;->omniture_prefix:I

    invoke-virtual {v10, v11}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v9

    const/4 v9, 0x1

    aput-object v6, v8, v9

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    .line 572
    goto :goto_0

    .line 574
    :pswitch_1
    const-string v7, "%s:%s:feed:done"

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v10

    sget v11, Lcom/disney/datg/videoplatforms/sdk/R$string;->omniture_prefix:I

    invoke-virtual {v10, v11}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v9

    const/4 v9, 0x1

    aput-object v6, v8, v9

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v5

    goto :goto_0

    .line 585
    .end local v1    # "act":Landroid/app/Activity;
    .end local v3    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    .end local v5    # "trackableEvent":Ljava/lang/String;
    .end local v6    # "videoContentType":Ljava/lang/String;
    :catch_0
    move-exception v4

    .line 586
    .local v4, "e":Ljava/lang/Exception;
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->getName()Ljava/lang/String;

    move-result-object v7

    const-string v8, "trackMediaComplete could not be executed : %s"

    new-array v9, v13, [Ljava/lang/Object;

    invoke-virtual {v4}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v10

    aput-object v10, v9, v12

    invoke-static {v8, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 566
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public trackMediaError(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 14
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    const/4 v13, 0x1

    const/4 v12, 0x0

    .line 595
    if-eqz p1, :cond_1

    :try_start_0
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v6

    if-eqz v6, :cond_1

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v6

    const-string v7, "activity"

    invoke-interface {v6, v7}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    if-eqz v6, :cond_1

    .line 596
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v6

    const-string v7, "activity"

    invoke-interface {v6, v7}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .line 597
    .local v2, "activity":Ljava/lang/Object;
    instance-of v6, v2, Landroid/app/Fragment;

    if-eqz v6, :cond_0

    .line 598
    check-cast v2, Landroid/app/Fragment;

    .end local v2    # "activity":Ljava/lang/Object;
    invoke-virtual {v2}, Landroid/app/Fragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    .line 601
    :cond_0
    move-object v0, v2

    check-cast v0, Landroid/app/Activity;

    move-object v1, v0

    .line 602
    .local v1, "act":Landroid/app/Activity;
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v6

    const-string v7, "error"

    invoke-interface {v6, v7}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    if-eqz v6, :cond_1

    .line 604
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v6

    const-string v7, "trackCode"

    invoke-interface {v6, v7}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    .line 605
    .local v5, "linkMsg":Ljava/lang/String;
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v6

    const-string v7, "error"

    invoke-interface {v6, v7}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 608
    .local v4, "errorMsg":Ljava/lang/String;
    const/16 v6, 0x31

    invoke-interface {p1, v6, v5}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addProp(ILjava/lang/String;)V

    .line 609
    const/16 v6, 0x31

    invoke-interface {p1, v6, v5}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvar(ILjava/lang/String;)V

    .line 612
    const/16 v6, 0x32

    invoke-interface {p1, v6, v4}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addProp(ILjava/lang/String;)V

    .line 613
    const/16 v6, 0x32

    invoke-interface {p1, v6, v4}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvar(ILjava/lang/String;)V

    .line 614
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->getName()Ljava/lang/String;

    move-result-object v6

    const-string v7, "trackMediaError"

    invoke-static {v6, v7}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 615
    const-string v6, "o"

    const-string v7, "%s:%s"

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v10

    sget v11, Lcom/disney/datg/videoplatforms/sdk/R$string;->omniture_prefix:I

    invoke-virtual {v10, v11}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v9

    const/4 v9, 0x1

    aput-object v4, v8, v9

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {p0, v6, v7, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->trackLink(Ljava/lang/String;Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 625
    .end local v1    # "act":Landroid/app/Activity;
    .end local v4    # "errorMsg":Ljava/lang/String;
    .end local v5    # "linkMsg":Ljava/lang/String;
    :cond_1
    :goto_0
    return-void

    .line 621
    :catch_0
    move-exception v3

    .line 622
    .local v3, "e":Ljava/lang/Exception;
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->getName()Ljava/lang/String;

    move-result-object v6

    const-string v7, "trackMediaError could not be executed : %s"

    new-array v8, v13, [Ljava/lang/Object;

    invoke-virtual {v3}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v9

    aput-object v9, v8, v12

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public trackMediaFirstQuarter(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 14
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    const/4 v13, 0x1

    const/4 v12, 0x0

    .line 467
    if-eqz p1, :cond_1

    :try_start_0
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    if-eqz v7, :cond_1

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    const-string v8, "activity"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    if-eqz v7, :cond_1

    .line 468
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    const-string v8, "activity"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .line 469
    .local v2, "activity":Ljava/lang/Object;
    instance-of v7, v2, Landroid/app/Fragment;

    if-eqz v7, :cond_0

    .line 470
    check-cast v2, Landroid/app/Fragment;

    .end local v2    # "activity":Ljava/lang/Object;
    invoke-virtual {v2}, Landroid/app/Fragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    .line 472
    :cond_0
    move-object v0, v2

    check-cast v0, Landroid/app/Activity;

    move-object v1, v0

    .line 473
    .local v1, "act":Landroid/app/Activity;
    if-eqz p1, :cond_1

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    if-eqz v7, :cond_1

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    const-string v8, "currentMedia"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    if-eqz v7, :cond_1

    .line 475
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    const-string v8, "currentMedia"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    .line 476
    .local v3, "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    if-eqz v3, :cond_1

    .line 477
    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getMediaType()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    move-result-object v7

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;->getTypes()Ljava/lang/String;

    move-result-object v6

    .line 478
    .local v6, "videoContentType":Ljava/lang/String;
    const-string v7, "event8"

    invoke-interface {p1, v7}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvent(Ljava/lang/String;)V

    .line 479
    invoke-direct {p0, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->populateVideoTags(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    .line 480
    const-string v7, "%s:%s:video playback:25 complete"

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v10

    sget v11, Lcom/disney/datg/videoplatforms/sdk/R$string;->omniture_prefix:I

    invoke-virtual {v10, v11}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v9

    const/4 v9, 0x1

    aput-object v6, v8, v9

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    .line 482
    .local v5, "trackableEvent":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->getName()Ljava/lang/String;

    move-result-object v7

    const-string v8, "trackMediaFirstQuarter"

    invoke-static {v7, v8}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 483
    const-string v7, "o"

    invoke-virtual {p0, v7, v5, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->trackLink(Ljava/lang/String;Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 490
    .end local v1    # "act":Landroid/app/Activity;
    .end local v3    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    .end local v5    # "trackableEvent":Ljava/lang/String;
    .end local v6    # "videoContentType":Ljava/lang/String;
    :cond_1
    :goto_0
    return-void

    .line 487
    :catch_0
    move-exception v4

    .line 488
    .local v4, "e":Ljava/lang/Exception;
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->getName()Ljava/lang/String;

    move-result-object v7

    const-string v8, "trackMediaFirstQuarter could not be executed : %s"

    new-array v9, v13, [Ljava/lang/Object;

    invoke-virtual {v4}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v10

    aput-object v10, v9, v12

    invoke-static {v8, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public trackMediaForward(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 0
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    .line 444
    return-void
.end method

.method public trackMediaMidpoint(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 14
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    const/4 v13, 0x1

    const/4 v12, 0x0

    .line 495
    if-eqz p1, :cond_1

    :try_start_0
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    if-eqz v7, :cond_1

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    const-string v8, "activity"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    if-eqz v7, :cond_1

    .line 496
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    const-string v8, "activity"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .line 497
    .local v2, "activity":Ljava/lang/Object;
    instance-of v7, v2, Landroid/app/Fragment;

    if-eqz v7, :cond_0

    .line 498
    check-cast v2, Landroid/app/Fragment;

    .end local v2    # "activity":Ljava/lang/Object;
    invoke-virtual {v2}, Landroid/app/Fragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    .line 500
    :cond_0
    move-object v0, v2

    check-cast v0, Landroid/app/Activity;

    move-object v1, v0

    .line 501
    .local v1, "act":Landroid/app/Activity;
    if-eqz p1, :cond_1

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    if-eqz v7, :cond_1

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    const-string v8, "currentMedia"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    if-eqz v7, :cond_1

    .line 503
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    const-string v8, "currentMedia"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    .line 504
    .local v3, "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    if-eqz v3, :cond_1

    .line 505
    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getMediaType()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    move-result-object v7

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;->getTypes()Ljava/lang/String;

    move-result-object v6

    .line 506
    .local v6, "videoContentType":Ljava/lang/String;
    const-string v7, "event9"

    invoke-interface {p1, v7}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvent(Ljava/lang/String;)V

    .line 507
    invoke-direct {p0, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->populateVideoTags(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    .line 508
    const-string v7, "%s:%s:video playback:50 complete"

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v10

    sget v11, Lcom/disney/datg/videoplatforms/sdk/R$string;->omniture_prefix:I

    invoke-virtual {v10, v11}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v9

    const/4 v9, 0x1

    aput-object v6, v8, v9

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    .line 510
    .local v5, "trackableEvent":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->getName()Ljava/lang/String;

    move-result-object v7

    const-string v8, "trackMediaMidpoint"

    invoke-static {v7, v8}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 511
    const-string v7, "o"

    invoke-virtual {p0, v7, v5, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->trackLink(Ljava/lang/String;Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 518
    .end local v1    # "act":Landroid/app/Activity;
    .end local v3    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    .end local v5    # "trackableEvent":Ljava/lang/String;
    .end local v6    # "videoContentType":Ljava/lang/String;
    :cond_1
    :goto_0
    return-void

    .line 515
    :catch_0
    move-exception v4

    .line 516
    .local v4, "e":Ljava/lang/Exception;
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->getName()Ljava/lang/String;

    move-result-object v7

    const-string v8, "trackMediaMidpoint could not be executed : %s"

    new-array v9, v13, [Ljava/lang/Object;

    invoke-virtual {v4}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v10

    aput-object v10, v9, v12

    invoke-static {v8, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public trackMediaPaused(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 14
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    const/4 v13, 0x1

    const/4 v12, 0x0

    .line 369
    if-eqz p1, :cond_1

    :try_start_0
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    if-eqz v7, :cond_1

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    const-string v8, "activity"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    if-eqz v7, :cond_1

    .line 370
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    const-string v8, "activity"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .line 371
    .local v2, "activity":Ljava/lang/Object;
    instance-of v7, v2, Landroid/app/Fragment;

    if-eqz v7, :cond_0

    .line 372
    check-cast v2, Landroid/app/Fragment;

    .end local v2    # "activity":Ljava/lang/Object;
    invoke-virtual {v2}, Landroid/app/Fragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    .line 374
    :cond_0
    move-object v0, v2

    check-cast v0, Landroid/app/Activity;

    move-object v1, v0

    .line 375
    .local v1, "act":Landroid/app/Activity;
    if-eqz p1, :cond_1

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    if-eqz v7, :cond_1

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    const-string v8, "currentMedia"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    if-eqz v7, :cond_1

    .line 377
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    const-string v8, "currentMedia"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    .line 378
    .local v3, "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    if-eqz v3, :cond_1

    .line 380
    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getMediaType()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    move-result-object v7

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;->getTypes()Ljava/lang/String;

    move-result-object v6

    .line 381
    .local v6, "videoContentType":Ljava/lang/String;
    const-string v5, ""

    .line 382
    .local v5, "trackableEvent":Ljava/lang/String;
    sget-object v7, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker$1;->$SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$MediaType:[I

    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getMediaType()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    move-result-object v8

    invoke-virtual {v8}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;->ordinal()I

    move-result v8

    aget v7, v7, v8

    packed-switch v7, :pswitch_data_0

    .line 401
    .end local v1    # "act":Landroid/app/Activity;
    .end local v3    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    .end local v5    # "trackableEvent":Ljava/lang/String;
    .end local v6    # "videoContentType":Ljava/lang/String;
    :cond_1
    :goto_0
    return-void

    .line 384
    .restart local v1    # "act":Landroid/app/Activity;
    .restart local v3    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    .restart local v5    # "trackableEvent":Ljava/lang/String;
    .restart local v6    # "videoContentType":Ljava/lang/String;
    :pswitch_0
    const-string v7, "event12"

    invoke-interface {p1, v7}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvent(Ljava/lang/String;)V

    .line 385
    const-string v7, "%s:%s:video playback:pause button click"

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v10

    sget v11, Lcom/disney/datg/videoplatforms/sdk/R$string;->omniture_prefix:I

    invoke-virtual {v10, v11}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v9

    const/4 v9, 0x1

    aput-object v6, v8, v9

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    .line 387
    invoke-direct {p0, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->populateVideoTags(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    .line 388
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->getName()Ljava/lang/String;

    move-result-object v7

    const-string v8, "trackMediaPaused"

    invoke-static {v7, v8}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 389
    const-string v7, "o"

    invoke-virtual {p0, v7, v5, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->trackLink(Ljava/lang/String;Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 397
    .end local v1    # "act":Landroid/app/Activity;
    .end local v3    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    .end local v5    # "trackableEvent":Ljava/lang/String;
    .end local v6    # "videoContentType":Ljava/lang/String;
    :catch_0
    move-exception v4

    .line 398
    .local v4, "e":Ljava/lang/Exception;
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->getName()Ljava/lang/String;

    move-result-object v7

    const-string v8, "trackMediaResumed could not be executed : %s"

    new-array v9, v13, [Ljava/lang/Object;

    invoke-virtual {v4}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v10

    aput-object v10, v9, v12

    invoke-static {v8, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 382
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method

.method public trackMediaResumed(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 14
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    const/4 v13, 0x1

    const/4 v12, 0x0

    .line 406
    if-eqz p1, :cond_1

    :try_start_0
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    if-eqz v7, :cond_1

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    const-string v8, "activity"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    if-eqz v7, :cond_1

    .line 407
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    const-string v8, "activity"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .line 408
    .local v2, "activity":Ljava/lang/Object;
    instance-of v7, v2, Landroid/app/Fragment;

    if-eqz v7, :cond_0

    .line 409
    check-cast v2, Landroid/app/Fragment;

    .end local v2    # "activity":Ljava/lang/Object;
    invoke-virtual {v2}, Landroid/app/Fragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    .line 411
    :cond_0
    move-object v0, v2

    check-cast v0, Landroid/app/Activity;

    move-object v1, v0

    .line 412
    .local v1, "act":Landroid/app/Activity;
    if-eqz p1, :cond_1

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    if-eqz v7, :cond_1

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    const-string v8, "currentMedia"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    if-eqz v7, :cond_1

    .line 414
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    const-string v8, "currentMedia"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    .line 415
    .local v3, "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    if-eqz v3, :cond_1

    .line 417
    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getMediaType()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    move-result-object v7

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;->getTypes()Ljava/lang/String;

    move-result-object v6

    .line 418
    .local v6, "videoContentType":Ljava/lang/String;
    const-string v5, ""

    .line 419
    .local v5, "trackableEvent":Ljava/lang/String;
    const-string v7, "event1"

    invoke-interface {p1, v7}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvent(Ljava/lang/String;)V

    .line 420
    sget-object v7, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker$1;->$SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$MediaType:[I

    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getMediaType()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    move-result-object v8

    invoke-virtual {v8}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;->ordinal()I

    move-result v8

    aget v7, v7, v8

    packed-switch v7, :pswitch_data_0

    .line 438
    .end local v1    # "act":Landroid/app/Activity;
    .end local v3    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    .end local v5    # "trackableEvent":Ljava/lang/String;
    .end local v6    # "videoContentType":Ljava/lang/String;
    :cond_1
    :goto_0
    return-void

    .line 422
    .restart local v1    # "act":Landroid/app/Activity;
    .restart local v3    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    .restart local v5    # "trackableEvent":Ljava/lang/String;
    .restart local v6    # "videoContentType":Ljava/lang/String;
    :pswitch_0
    const-string v7, "event13"

    invoke-interface {p1, v7}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvent(Ljava/lang/String;)V

    .line 423
    const-string v7, "%s:%s:video playback:episode resume"

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v10

    sget v11, Lcom/disney/datg/videoplatforms/sdk/R$string;->omniture_prefix:I

    invoke-virtual {v10, v11}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v9

    const/4 v9, 0x1

    aput-object v6, v8, v9

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    .line 425
    invoke-direct {p0, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->populateVideoTags(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    .line 426
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->getName()Ljava/lang/String;

    move-result-object v7

    const-string v8, "trackMediaResumed"

    invoke-static {v7, v8}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 427
    const-string v7, "o"

    invoke-virtual {p0, v7, v5, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->trackLink(Ljava/lang/String;Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 435
    .end local v1    # "act":Landroid/app/Activity;
    .end local v3    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    .end local v5    # "trackableEvent":Ljava/lang/String;
    .end local v6    # "videoContentType":Ljava/lang/String;
    :catch_0
    move-exception v4

    .line 436
    .local v4, "e":Ljava/lang/Exception;
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->getName()Ljava/lang/String;

    move-result-object v7

    const-string v8, "trackMediaResumed could not be executed : %s"

    new-array v9, v13, [Ljava/lang/Object;

    invoke-virtual {v4}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v10

    aput-object v10, v9, v12

    invoke-static {v8, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 420
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method

.method public trackMediaRewind(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 0
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    .line 450
    return-void
.end method

.method public trackMediaStarted(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 14
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    const/4 v13, 0x1

    const/4 v12, 0x0

    .line 328
    if-eqz p1, :cond_1

    :try_start_0
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    if-eqz v7, :cond_1

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    const-string v8, "activity"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    if-eqz v7, :cond_1

    .line 329
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    const-string v8, "activity"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .line 330
    .local v2, "activity":Ljava/lang/Object;
    instance-of v7, v2, Landroid/app/Fragment;

    if-eqz v7, :cond_0

    .line 331
    check-cast v2, Landroid/app/Fragment;

    .end local v2    # "activity":Ljava/lang/Object;
    invoke-virtual {v2}, Landroid/app/Fragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    .line 333
    :cond_0
    move-object v0, v2

    check-cast v0, Landroid/app/Activity;

    move-object v1, v0

    .line 334
    .local v1, "act":Landroid/app/Activity;
    if-eqz p1, :cond_1

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    if-eqz v7, :cond_1

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    const-string v8, "currentMedia"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    if-eqz v7, :cond_1

    .line 336
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    const-string v8, "currentMedia"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    .line 337
    .local v3, "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    if-eqz v3, :cond_1

    .line 339
    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getMediaType()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    move-result-object v7

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;->getTypes()Ljava/lang/String;

    move-result-object v6

    .line 340
    .local v6, "videoContentType":Ljava/lang/String;
    const-string v5, ""

    .line 341
    .local v5, "trackableEvent":Ljava/lang/String;
    const-string v7, "event1"

    invoke-interface {p1, v7}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvent(Ljava/lang/String;)V

    .line 342
    sget-object v7, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker$1;->$SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$MediaType:[I

    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getMediaType()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    move-result-object v8

    invoke-virtual {v8}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;->ordinal()I

    move-result v8

    aget v7, v7, v8

    packed-switch v7, :pswitch_data_0

    .line 355
    :goto_0
    invoke-direct {p0, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->populateVideoTags(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    .line 356
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->getName()Ljava/lang/String;

    move-result-object v7

    const-string v8, "trackMediaStarted"

    invoke-static {v7, v8}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 357
    const-string v7, "o"

    invoke-virtual {p0, v7, v5, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->trackLink(Ljava/lang/String;Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    .line 364
    .end local v1    # "act":Landroid/app/Activity;
    .end local v3    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    .end local v5    # "trackableEvent":Ljava/lang/String;
    .end local v6    # "videoContentType":Ljava/lang/String;
    :cond_1
    :goto_1
    return-void

    .line 344
    .restart local v1    # "act":Landroid/app/Activity;
    .restart local v3    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    .restart local v5    # "trackableEvent":Ljava/lang/String;
    .restart local v6    # "videoContentType":Ljava/lang/String;
    :pswitch_0
    const-string v7, "event14"

    invoke-interface {p1, v7}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvent(Ljava/lang/String;)V

    .line 345
    const-string v7, "%s:%s:video playback:episode start"

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v10

    sget v11, Lcom/disney/datg/videoplatforms/sdk/R$string;->omniture_prefix:I

    invoke-virtual {v10, v11}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v9

    const/4 v9, 0x1

    aput-object v6, v8, v9

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    .line 347
    goto :goto_0

    .line 349
    :pswitch_1
    const-string v7, "event15"

    invoke-interface {p1, v7}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvent(Ljava/lang/String;)V

    .line 350
    const-string v7, "%s:%s:feed:start"

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v10

    sget v11, Lcom/disney/datg/videoplatforms/sdk/R$string;->omniture_prefix:I

    invoke-virtual {v10, v11}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v9

    const/4 v9, 0x1

    aput-object v6, v8, v9

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v5

    goto :goto_0

    .line 361
    .end local v1    # "act":Landroid/app/Activity;
    .end local v3    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    .end local v5    # "trackableEvent":Ljava/lang/String;
    .end local v6    # "videoContentType":Ljava/lang/String;
    :catch_0
    move-exception v4

    .line 362
    .local v4, "e":Ljava/lang/Exception;
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->getName()Ljava/lang/String;

    move-result-object v7

    const-string v8, "trackMediaStarted could not be executed : %s"

    new-array v9, v13, [Ljava/lang/Object;

    invoke-virtual {v4}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v10

    aput-object v10, v9, v12

    invoke-static {v8, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 342
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public trackMediaStateUpdated(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 0
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    .line 462
    return-void
.end method

.method public trackMediaStopped(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 0
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    .line 456
    return-void
.end method

.method public trackMediaThirdQuarter(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 14
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    const/4 v13, 0x1

    const/4 v12, 0x0

    .line 523
    if-eqz p1, :cond_1

    :try_start_0
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    if-eqz v7, :cond_1

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    const-string v8, "activity"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    if-eqz v7, :cond_1

    .line 524
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    const-string v8, "activity"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .line 525
    .local v2, "activity":Ljava/lang/Object;
    instance-of v7, v2, Landroid/app/Fragment;

    if-eqz v7, :cond_0

    .line 526
    check-cast v2, Landroid/app/Fragment;

    .end local v2    # "activity":Ljava/lang/Object;
    invoke-virtual {v2}, Landroid/app/Fragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    .line 528
    :cond_0
    move-object v0, v2

    check-cast v0, Landroid/app/Activity;

    move-object v1, v0

    .line 529
    .local v1, "act":Landroid/app/Activity;
    if-eqz p1, :cond_1

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    if-eqz v7, :cond_1

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    const-string v8, "currentMedia"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    if-eqz v7, :cond_1

    .line 531
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v7

    const-string v8, "currentMedia"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    .line 532
    .local v3, "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    if-eqz v3, :cond_1

    .line 533
    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getMediaType()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    move-result-object v7

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;->getTypes()Ljava/lang/String;

    move-result-object v6

    .line 534
    .local v6, "videoContentType":Ljava/lang/String;
    const-string v7, "event10"

    invoke-interface {p1, v7}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvent(Ljava/lang/String;)V

    .line 535
    invoke-direct {p0, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->populateVideoTags(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    .line 536
    const-string v7, "%s:%s:video playback:75 complete"

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v10

    sget v11, Lcom/disney/datg/videoplatforms/sdk/R$string;->omniture_prefix:I

    invoke-virtual {v10, v11}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v9

    const/4 v9, 0x1

    aput-object v6, v8, v9

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    .line 538
    .local v5, "trackableEvent":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->getName()Ljava/lang/String;

    move-result-object v7

    const-string v8, "trackMediaThirdQuarter"

    invoke-static {v7, v8}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 539
    const-string v7, "o"

    invoke-virtual {p0, v7, v5, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->trackLink(Ljava/lang/String;Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 546
    .end local v1    # "act":Landroid/app/Activity;
    .end local v3    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    .end local v5    # "trackableEvent":Ljava/lang/String;
    .end local v6    # "videoContentType":Ljava/lang/String;
    :cond_1
    :goto_0
    return-void

    .line 543
    :catch_0
    move-exception v4

    .line 544
    .local v4, "e":Ljava/lang/Exception;
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;->getName()Ljava/lang/String;

    move-result-object v7

    const-string v8, "trackMediaThirdQuarter could not be executed : %s"

    new-array v9, v13, [Ljava/lang/Object;

    invoke-virtual {v4}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v10

    aput-object v10, v9, v12

    invoke-static {v8, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public trackPing(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 0
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    .line 635
    return-void
.end method

.class public Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;
.super Ljava/lang/Object;
.source "SloggerTracker.java"

# interfaces
.implements Lcom/disney/datg/videoplatforms/sdk/analytics/IAdTracker;
.implements Lcom/disney/datg/videoplatforms/sdk/analytics/IAuthZTracker;
.implements Lcom/disney/datg/videoplatforms/sdk/analytics/ILinkTracker;
.implements Lcom/disney/datg/videoplatforms/sdk/analytics/IMediaTracker;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker$2;
    }
.end annotation


# static fields
.field public static networks:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private configuration:Lcom/disney/datg/videoplatforms/sdk/media/Configuration;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 63
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker$1;

    invoke-direct {v0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker$1;-><init>()V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->networks:Ljava/util/Map;

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/disney/datg/videoplatforms/sdk/media/Configuration;)V
    .locals 2
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "configuration"    # Lcom/disney/datg/videoplatforms/sdk/media/Configuration;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 77
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 78
    if-eqz p2, :cond_0

    invoke-virtual {p2}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->getCurrentConfig()Lcom/disney/datg/videoplatforms/sdk/models/api/Config;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 79
    invoke-virtual {p0, p2}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->setConfiguration(Lcom/disney/datg/videoplatforms/sdk/media/Configuration;)V

    .line 84
    return-void

    .line 82
    :cond_0
    new-instance v0, Ljava/lang/Exception;

    const-string v1, "configuration cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method private getHeaders()Ljava/util/Map;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 520
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 521
    .local v0, "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-static {}, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/CookieEnabledHttpRequestFactory;->getSWID()Ljava/lang/String;

    move-result-object v1

    .line 522
    .local v1, "swid":Ljava/lang/String;
    const-string v2, "Cookie"

    invoke-interface {v0, v2, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 523
    const-string v2, "Accept"

    const-string v3, "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8"

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 524
    const-string v2, "User-Agent"

    const-string v3, "http.agent"

    invoke-static {v3}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 525
    return-object v0
.end method

.method private getParams(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;Ljava/lang/String;Landroid/content/Context;)Ljava/util/Map;
    .locals 40
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;
    .param p2, "linkName"    # Ljava/lang/String;
    .param p3, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;",
            "Ljava/lang/String;",
            "Landroid/content/Context;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 531
    move-object/from16 v3, p3

    check-cast v3, Landroid/app/Activity;

    .line 533
    .local v3, "activity":Landroid/app/Activity;
    new-instance v30, Ljava/util/HashMap;

    invoke-direct/range {v30 .. v30}, Ljava/util/HashMap;-><init>()V

    .line 536
    .local v30, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {v3}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v37

    sget v38, Lcom/disney/datg/videoplatforms/sdk/R$string;->slogger_app_id:I

    invoke-virtual/range {v37 .. v38}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v8

    .line 537
    .local v8, "appid":Ljava/lang/String;
    const-string v37, "appid"

    move-object/from16 v0, v30

    move-object/from16 v1, v37

    invoke-interface {v0, v1, v8}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 540
    const-string v16, "phone"

    .line 541
    .local v16, "devicetype":Ljava/lang/String;
    if-eqz p3, :cond_0

    .line 542
    const-string v37, "phone"

    move-object/from16 v0, p3

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v32

    check-cast v32, Landroid/telephony/TelephonyManager;

    .line 543
    .local v32, "telephony":Landroid/telephony/TelephonyManager;
    invoke-virtual/range {v32 .. v32}, Landroid/telephony/TelephonyManager;->getPhoneType()I

    move-result v33

    .line 544
    .local v33, "type":I
    if-nez v33, :cond_0

    .line 545
    const-string v16, "tablet"

    .line 550
    .end local v32    # "telephony":Landroid/telephony/TelephonyManager;
    .end local v33    # "type":I
    :cond_0
    invoke-virtual {v3}, Landroid/app/Activity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v28

    .line 551
    .local v28, "packManager":Landroid/content/pm/PackageManager;
    invoke-virtual {v3}, Landroid/app/Activity;->getPackageName()Ljava/lang/String;

    move-result-object v29

    .line 552
    .local v29, "packName":Ljava/lang/String;
    const/16 v27, 0x0

    .line 553
    .local v27, "pInfo":Landroid/content/pm/PackageInfo;
    const-string v35, ""

    .line 554
    .local v35, "version":Ljava/lang/String;
    if-eqz v28, :cond_1

    invoke-static/range {v29 .. v29}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v37

    if-nez v37, :cond_1

    .line 556
    const/16 v37, 0x0

    :try_start_0
    move-object/from16 v0, v28

    move-object/from16 v1, v29

    move/from16 v2, v37

    invoke-virtual {v0, v1, v2}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v27

    .line 561
    :cond_1
    :goto_0
    if-eqz v27, :cond_2

    .line 562
    move-object/from16 v0, v27

    iget-object v0, v0, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    move-object/from16 v35, v0

    .line 564
    :cond_2
    invoke-virtual {v3}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v37

    sget v38, Lcom/disney/datg/videoplatforms/sdk/R$string;->slogger_dinfo:I

    invoke-virtual/range {v37 .. v38}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v17

    .line 565
    .local v17, "dinfo":Ljava/lang/String;
    const-string v37, "%DEVICE_TYPE%"

    move-object/from16 v0, v17

    move-object/from16 v1, v37

    move-object/from16 v2, v16

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v37

    const-string v38, "%DEVICE_NAME%"

    sget-object v39, Landroid/os/Build;->MODEL:Ljava/lang/String;

    invoke-virtual/range {v37 .. v39}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v37

    const-string v38, "%DEVICE_VERSION%"

    sget-object v39, Landroid/os/Build;->DISPLAY:Ljava/lang/String;

    invoke-virtual/range {v37 .. v39}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v37

    const-string v38, "%OS_NAME%"

    const-string v39, "android"

    invoke-virtual/range {v37 .. v39}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v37

    const-string v38, "%OS_VERSION%"

    sget-object v39, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    invoke-virtual/range {v37 .. v39}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v37

    const-string v38, "%APP_NAME%"

    move-object/from16 v0, v37

    move-object/from16 v1, v38

    move-object/from16 v2, v29

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v37

    const-string v38, "%APP_VERSION%"

    move-object/from16 v0, v37

    move-object/from16 v1, v38

    move-object/from16 v2, v35

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v17

    .line 568
    const-string v37, "dinfo"

    move-object/from16 v0, v30

    move-object/from16 v1, v37

    move-object/from16 v2, v17

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 571
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->configuration:Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

    move-object/from16 v37, v0

    invoke-virtual/range {v37 .. v37}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->getCurrentPartnerName()Ljava/lang/String;

    move-result-object v25

    .line 572
    .local v25, "mvpdId":Ljava/lang/String;
    if-eqz p1, :cond_3

    invoke-interface/range {p1 .. p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v37

    if-eqz v37, :cond_3

    invoke-interface/range {p1 .. p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v37

    const-string v38, "currentMVPDId"

    invoke-interface/range {v37 .. v38}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v37

    if-eqz v37, :cond_3

    .line 573
    invoke-interface/range {p1 .. p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v37

    const-string v38, "currentMVPDId"

    invoke-interface/range {v37 .. v38}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v25

    .end local v25    # "mvpdId":Ljava/lang/String;
    check-cast v25, Ljava/lang/String;

    .line 575
    .restart local v25    # "mvpdId":Ljava/lang/String;
    :cond_3
    invoke-static/range {v25 .. v25}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v37

    if-nez v37, :cond_4

    .line 576
    const-string v37, "mvp"

    move-object/from16 v0, v30

    move-object/from16 v1, v37

    move-object/from16 v2, v25

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 579
    :cond_4
    if-eqz p1, :cond_5

    invoke-interface/range {p1 .. p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v37

    if-eqz v37, :cond_5

    invoke-interface/range {p1 .. p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v37

    const-string v38, "currentMVPDGUID"

    invoke-interface/range {v37 .. v38}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v37

    if-eqz v37, :cond_5

    .line 580
    invoke-interface/range {p1 .. p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v37

    const-string v38, "currentMVPDGUID"

    invoke-interface/range {v37 .. v38}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v24

    check-cast v24, Ljava/lang/String;

    .line 581
    .local v24, "mvpdGUID":Ljava/lang/String;
    invoke-static/range {v24 .. v24}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v37

    if-nez v37, :cond_5

    .line 582
    const-string v37, "mvpuid"

    move-object/from16 v0, v30

    move-object/from16 v1, v37

    move-object/from16 v2, v24

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 589
    .end local v24    # "mvpdGUID":Ljava/lang/String;
    :cond_5
    const-string v4, ""

    .line 590
    .local v4, "aff":Ljava/lang/String;
    const-string v31, "0"

    .line 591
    .local v31, "proxy":Ljava/lang/String;
    const-string v23, "none"

    .line 592
    .local v23, "lbs":Ljava/lang/String;
    const/16 v21, 0x0

    .line 594
    .local v21, "geoLocation":Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;
    :try_start_1
    invoke-static {}, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->getGeolocationManager()Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;

    move-result-object v37

    invoke-virtual/range {v37 .. v37}, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->getCurrentGeolocation()Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;

    move-result-object v37

    if-eqz v37, :cond_6

    .line 595
    invoke-static {}, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->getGeolocationManager()Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;

    move-result-object v37

    invoke-virtual/range {v37 .. v37}, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->getCurrentGeolocation()Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;

    move-result-object v21

    .line 598
    :cond_6
    if-eqz v21, :cond_b

    .line 599
    invoke-virtual/range {v21 .. v21}, Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;->getAffiliates()Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliates;

    move-result-object v6

    .line 600
    .local v6, "affiliates":Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliates;
    if-eqz v6, :cond_9

    invoke-virtual {v6}, Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliates;->getAffiliates()Ljava/util/ArrayList;

    move-result-object v37

    invoke-virtual/range {v37 .. v37}, Ljava/util/ArrayList;->size()I

    move-result v37

    if-lez v37, :cond_9

    .line 601
    invoke-virtual {v6}, Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliates;->getAffiliates()Ljava/util/ArrayList;

    move-result-object v7

    .line 603
    .local v7, "affs":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliate;>;"
    invoke-virtual {v7}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v22

    .local v22, "i$":Ljava/util/Iterator;
    :cond_7
    :goto_1
    invoke-interface/range {v22 .. v22}, Ljava/util/Iterator;->hasNext()Z

    move-result v37

    if-eqz v37, :cond_8

    invoke-interface/range {v22 .. v22}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliate;

    .line 604
    .local v5, "affiliate":Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliate;
    if-eqz v5, :cond_7

    invoke-virtual {v5}, Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliate;->getId()Ljava/lang/String;

    move-result-object v37

    invoke-static/range {v37 .. v37}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v37

    if-nez v37, :cond_7

    .line 605
    new-instance v37, Ljava/lang/StringBuilder;

    invoke-direct/range {v37 .. v37}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v37

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v37

    invoke-virtual {v5}, Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliate;->getId()Ljava/lang/String;

    move-result-object v38

    invoke-virtual/range {v37 .. v38}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v37

    const-string v38, ","

    invoke-virtual/range {v37 .. v38}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v37

    invoke-virtual/range {v37 .. v37}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_1
    .catch Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v4

    goto :goto_1

    .line 557
    .end local v4    # "aff":Ljava/lang/String;
    .end local v5    # "affiliate":Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliate;
    .end local v6    # "affiliates":Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliates;
    .end local v7    # "affs":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliate;>;"
    .end local v17    # "dinfo":Ljava/lang/String;
    .end local v21    # "geoLocation":Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;
    .end local v22    # "i$":Ljava/util/Iterator;
    .end local v23    # "lbs":Ljava/lang/String;
    .end local v25    # "mvpdId":Ljava/lang/String;
    .end local v31    # "proxy":Ljava/lang/String;
    :catch_0
    move-exception v18

    .line 558
    .local v18, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-static/range {v18 .. v18}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->logException(Ljava/lang/Exception;)V

    goto/16 :goto_0

    .line 609
    .end local v18    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    .restart local v4    # "aff":Ljava/lang/String;
    .restart local v6    # "affiliates":Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliates;
    .restart local v7    # "affs":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliate;>;"
    .restart local v17    # "dinfo":Ljava/lang/String;
    .restart local v21    # "geoLocation":Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;
    .restart local v22    # "i$":Ljava/util/Iterator;
    .restart local v23    # "lbs":Ljava/lang/String;
    .restart local v25    # "mvpdId":Ljava/lang/String;
    .restart local v31    # "proxy":Ljava/lang/String;
    :cond_8
    :try_start_2
    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v37

    if-nez v37, :cond_9

    .line 610
    const/16 v37, 0x0

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v38

    add-int/lit8 v38, v38, -0x1

    move/from16 v0, v37

    move/from16 v1, v38

    invoke-virtual {v4, v0, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    .line 614
    .end local v7    # "affs":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliate;>;"
    .end local v22    # "i$":Ljava/util/Iterator;
    :cond_9
    invoke-virtual/range {v21 .. v21}, Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;->getUser()Lcom/disney/datg/videoplatforms/sdk/models/api/User;

    move-result-object v37

    if-eqz v37, :cond_b

    .line 615
    invoke-virtual/range {v21 .. v21}, Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;->getUser()Lcom/disney/datg/videoplatforms/sdk/models/api/User;

    move-result-object v34

    .line 617
    .local v34, "user":Lcom/disney/datg/videoplatforms/sdk/models/api/User;
    invoke-virtual/range {v34 .. v34}, Lcom/disney/datg/videoplatforms/sdk/models/api/User;->getProxy()Ljava/lang/String;

    move-result-object v37

    if-eqz v37, :cond_a

    const-string v37, ""

    invoke-virtual/range {v34 .. v34}, Lcom/disney/datg/videoplatforms/sdk/models/api/User;->getProxy()Ljava/lang/String;

    move-result-object v38

    invoke-virtual/range {v37 .. v38}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v37

    if-nez v37, :cond_a

    .line 618
    const-string v31, "1"

    .line 620
    :cond_a
    invoke-virtual/range {v34 .. v34}, Lcom/disney/datg/videoplatforms/sdk/models/api/User;->getZipCode()Ljava/lang/String;

    move-result-object v37

    if-eqz v37, :cond_b

    const-string v37, ""

    invoke-virtual/range {v34 .. v34}, Lcom/disney/datg/videoplatforms/sdk/models/api/User;->getZipCode()Ljava/lang/String;

    move-result-object v38

    invoke-virtual/range {v37 .. v38}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v37

    if-nez v37, :cond_b

    .line 621
    invoke-virtual/range {v34 .. v34}, Lcom/disney/datg/videoplatforms/sdk/models/api/User;->getZipCode()Ljava/lang/String;
    :try_end_2
    .catch Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException; {:try_start_2 .. :try_end_2} :catch_1

    move-result-object v23

    .line 630
    .end local v6    # "affiliates":Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliates;
    .end local v34    # "user":Lcom/disney/datg/videoplatforms/sdk/models/api/User;
    :cond_b
    :goto_2
    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v37

    if-nez v37, :cond_c

    .line 632
    const-string v37, "aff"

    move-object/from16 v0, v30

    move-object/from16 v1, v37

    invoke-interface {v0, v1, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 634
    :cond_c
    const-string v37, "aprx"

    move-object/from16 v0, v30

    move-object/from16 v1, v37

    move-object/from16 v2, v31

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 635
    const-string v37, "lbs"

    move-object/from16 v0, v30

    move-object/from16 v1, v37

    move-object/from16 v2, v23

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 638
    const-string v37, "netw"

    sget-object v38, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->networks:Ljava/util/Map;

    invoke-virtual/range {p0 .. p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->getConfiguration()Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

    move-result-object v39

    invoke-virtual/range {v39 .. v39}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->getCurrentNetwork()Ljava/lang/String;

    move-result-object v39

    invoke-interface/range {v38 .. v39}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v38

    move-object/from16 v0, v30

    move-object/from16 v1, v37

    move-object/from16 v2, v38

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 639
    invoke-virtual {v3}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v38

    sget-object v37, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->networks:Ljava/util/Map;

    invoke-virtual/range {p0 .. p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->getConfiguration()Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

    move-result-object v39

    invoke-virtual/range {v39 .. v39}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->getCurrentNetwork()Ljava/lang/String;

    move-result-object v39

    move-object/from16 v0, v37

    move-object/from16 v1, v39

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v37

    check-cast v37, Ljava/lang/Integer;

    invoke-virtual/range {v37 .. v37}, Ljava/lang/Integer;->intValue()I

    move-result v37

    move-object/from16 v0, v38

    move/from16 v1, v37

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v26

    .line 640
    .local v26, "netw":Ljava/lang/String;
    const-string v37, "netw"

    move-object/from16 v0, v30

    move-object/from16 v1, v37

    move-object/from16 v2, v26

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 643
    const-string v37, "connectivity"

    move-object/from16 v0, p3

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Landroid/net/ConnectivityManager;

    .line 644
    .local v12, "cn":Landroid/net/ConnectivityManager;
    invoke-virtual {v12}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v37

    invoke-virtual/range {v37 .. v37}, Landroid/net/NetworkInfo;->getTypeName()Ljava/lang/String;

    move-result-object v15

    .line 645
    .local v15, "cxntyp":Ljava/lang/String;
    const-string v37, "cxntyp"

    move-object/from16 v0, v30

    move-object/from16 v1, v37

    invoke-interface {v0, v1, v15}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 648
    const-string v37, "sdkver"

    sget-object v38, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    move-object/from16 v0, v30

    move-object/from16 v1, v37

    move-object/from16 v2, v38

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 650
    const/4 v14, 0x0

    .line 651
    .local v14, "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    if-eqz p1, :cond_d

    invoke-interface/range {p1 .. p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v37

    if-eqz v37, :cond_d

    invoke-interface/range {p1 .. p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v37

    const-string v38, "currentMedia"

    invoke-interface/range {v37 .. v38}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v37

    if-eqz v37, :cond_d

    .line 652
    invoke-interface/range {p1 .. p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v37

    const-string v38, "currentMedia"

    invoke-interface/range {v37 .. v38}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v14

    .end local v14    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    check-cast v14, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    .line 653
    .restart local v14    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    if-eqz v14, :cond_d

    .line 654
    invoke-virtual {v14}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getMediaType()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    move-result-object v37

    invoke-virtual/range {v37 .. v37}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;->getTypes()Ljava/lang/String;

    move-result-object v36

    .line 655
    .local v36, "videoContentType":Ljava/lang/String;
    const-string v37, "lf,es,mp"

    move-object/from16 v0, v37

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v37

    if-eqz v37, :cond_16

    .line 656
    const-string v37, "ctyp"

    const-string v38, "lf"

    move-object/from16 v0, v30

    move-object/from16 v1, v37

    move-object/from16 v2, v38

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 664
    .end local v36    # "videoContentType":Ljava/lang/String;
    :cond_d
    :goto_3
    if-eqz v14, :cond_e

    .line 665
    invoke-virtual {v14}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getMediaId()Ljava/lang/String;

    move-result-object v11

    .line 666
    .local v11, "cid":Ljava/lang/String;
    const-string v37, "cid"

    move-object/from16 v0, v30

    move-object/from16 v1, v37

    invoke-interface {v0, v1, v11}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 670
    .end local v11    # "cid":Ljava/lang/String;
    :cond_e
    invoke-static/range {v25 .. v25}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v37

    if-nez v37, :cond_f

    .line 671
    const-string v37, "accpt"

    move-object/from16 v0, v30

    move-object/from16 v1, v37

    move-object/from16 v2, v25

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 676
    :cond_f
    if-eqz p1, :cond_10

    invoke-interface/range {p1 .. p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v37

    if-eqz v37, :cond_10

    invoke-interface/range {p1 .. p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v37

    const-string v38, "errc"

    invoke-interface/range {v37 .. v38}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v37

    if-eqz v37, :cond_10

    .line 677
    invoke-interface/range {p1 .. p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v37

    const-string v38, "errc"

    invoke-interface/range {v37 .. v38}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v19

    check-cast v19, Ljava/lang/String;

    .line 678
    .local v19, "errc":Ljava/lang/String;
    invoke-static/range {v19 .. v19}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v37

    if-nez v37, :cond_10

    .line 679
    const-string v37, "errc"

    move-object/from16 v0, v30

    move-object/from16 v1, v37

    move-object/from16 v2, v19

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 683
    .end local v19    # "errc":Ljava/lang/String;
    :cond_10
    if-eqz p1, :cond_11

    invoke-interface/range {p1 .. p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v37

    if-eqz v37, :cond_11

    invoke-interface/range {p1 .. p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v37

    const-string v38, "errmsg"

    invoke-interface/range {v37 .. v38}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v37

    if-eqz v37, :cond_11

    .line 684
    invoke-interface/range {p1 .. p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v37

    const-string v38, "errmsg"

    invoke-interface/range {v37 .. v38}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v20

    check-cast v20, Ljava/lang/String;

    .line 685
    .local v20, "errmsg":Ljava/lang/String;
    invoke-static/range {v20 .. v20}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v37

    if-nez v37, :cond_11

    .line 686
    const-string v37, "errmsg"

    move-object/from16 v0, v30

    move-object/from16 v1, v37

    move-object/from16 v2, v20

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 691
    .end local v20    # "errmsg":Ljava/lang/String;
    :cond_11
    if-eqz p1, :cond_12

    invoke-interface/range {p1 .. p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v37

    if-eqz v37, :cond_12

    invoke-interface/range {p1 .. p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v37

    const-string v38, "authzerror"

    invoke-interface/range {v37 .. v38}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v37

    if-eqz v37, :cond_12

    .line 692
    invoke-interface/range {p1 .. p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v37

    const-string v38, "authzerror"

    invoke-interface/range {v37 .. v38}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Ljava/lang/String;

    .line 693
    .local v10, "authzerror":Ljava/lang/String;
    invoke-static {v10}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v37

    if-nez v37, :cond_12

    .line 694
    const-string v37, "authzerror"

    move-object/from16 v0, v30

    move-object/from16 v1, v37

    invoke-interface {v0, v1, v10}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 699
    .end local v10    # "authzerror":Ljava/lang/String;
    :cond_12
    const-string v37, "authz"

    move-object/from16 v0, v37

    move-object/from16 v1, p2

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v37

    if-nez v37, :cond_13

    if-eqz v14, :cond_13

    .line 700
    sget-object v37, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker$2;->$SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$AccessWindow:[I

    invoke-virtual {v14}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getAccessWindow()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;

    move-result-object v38

    invoke-virtual/range {v38 .. v38}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;->ordinal()I

    move-result v38

    aget v37, v37, v38

    packed-switch v37, :pswitch_data_0

    .line 715
    :cond_13
    :goto_4
    const-string v37, "authz"

    move-object/from16 v0, v37

    move-object/from16 v1, p2

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v37

    if-nez v37, :cond_14

    if-eqz p1, :cond_14

    invoke-interface/range {p1 .. p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v37

    if-eqz v37, :cond_14

    invoke-interface/range {p1 .. p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v37

    const-string v38, "authenticated"

    invoke-interface/range {v37 .. v38}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v37

    if-eqz v37, :cond_14

    .line 716
    invoke-interface/range {p1 .. p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v37

    const-string v38, "authenticated"

    invoke-interface/range {v37 .. v38}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v37

    check-cast v37, Ljava/lang/Boolean;

    invoke-virtual/range {v37 .. v37}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v9

    .line 717
    .local v9, "authenticated":Z
    if-eqz v9, :cond_17

    .line 718
    const-string v37, "athu"

    const-string v38, "1"

    move-object/from16 v0, v30

    move-object/from16 v1, v37

    move-object/from16 v2, v38

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 725
    .end local v9    # "authenticated":Z
    :cond_14
    :goto_5
    const-string v37, "authz"

    move-object/from16 v0, v37

    move-object/from16 v1, p2

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v37

    if-nez v37, :cond_15

    if-eqz p1, :cond_15

    invoke-interface/range {p1 .. p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v37

    if-eqz v37, :cond_15

    invoke-interface/range {p1 .. p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v37

    const-string v38, "position"

    invoke-interface/range {v37 .. v38}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v37

    if-eqz v37, :cond_15

    .line 726
    invoke-interface/range {p1 .. p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v37

    const-string v38, "position"

    invoke-interface/range {v37 .. v38}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v37

    check-cast v37, Ljava/lang/Integer;

    invoke-virtual/range {v37 .. v37}, Ljava/lang/Integer;->intValue()I

    move-result v13

    .line 727
    .local v13, "cpos":I
    const-string v37, "cpos"

    new-instance v38, Ljava/lang/StringBuilder;

    invoke-direct/range {v38 .. v38}, Ljava/lang/StringBuilder;-><init>()V

    div-int/lit16 v0, v13, 0x3e8

    move/from16 v39, v0

    invoke-virtual/range {v38 .. v39}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v38

    const-string v39, ""

    invoke-virtual/range {v38 .. v39}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v38

    invoke-virtual/range {v38 .. v38}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v38

    move-object/from16 v0, v30

    move-object/from16 v1, v37

    move-object/from16 v2, v38

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 746
    .end local v13    # "cpos":I
    :cond_15
    return-object v30

    .line 626
    .end local v12    # "cn":Landroid/net/ConnectivityManager;
    .end local v14    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    .end local v15    # "cxntyp":Ljava/lang/String;
    .end local v26    # "netw":Ljava/lang/String;
    :catch_1
    move-exception v18

    .line 627
    .local v18, "e":Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
    const-string v37, "SloggerTracker"

    invoke-virtual/range {v18 .. v18}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;->getMessage()Ljava/lang/String;

    move-result-object v38

    invoke-static/range {v37 .. v38}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_2

    .line 658
    .end local v18    # "e":Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
    .restart local v12    # "cn":Landroid/net/ConnectivityManager;
    .restart local v14    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    .restart local v15    # "cxntyp":Ljava/lang/String;
    .restart local v26    # "netw":Ljava/lang/String;
    .restart local v36    # "videoContentType":Ljava/lang/String;
    :cond_16
    const-string v37, "ctyp"

    move-object/from16 v0, v30

    move-object/from16 v1, v37

    move-object/from16 v2, v36

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_3

    .line 704
    .end local v36    # "videoContentType":Ljava/lang/String;
    :pswitch_0
    const-string v37, "gt"

    const-string v38, "0"

    move-object/from16 v0, v30

    move-object/from16 v1, v37

    move-object/from16 v2, v38

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_4

    .line 708
    :pswitch_1
    const-string v37, "gt"

    const-string v38, "1"

    move-object/from16 v0, v30

    move-object/from16 v1, v37

    move-object/from16 v2, v38

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_4

    .line 720
    .restart local v9    # "authenticated":Z
    :cond_17
    const-string v37, "athu"

    const-string v38, "0"

    move-object/from16 v0, v30

    move-object/from16 v1, v37

    move-object/from16 v2, v38

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_5

    .line 700
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method


# virtual methods
.method public getConfiguration()Lcom/disney/datg/videoplatforms/sdk/media/Configuration;
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->configuration:Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 102
    const-string v0, "SLOGGER TRACKER"

    return-object v0
.end method

.method public setConfiguration(Lcom/disney/datg/videoplatforms/sdk/media/Configuration;)V
    .locals 0
    .param p1, "configuration"    # Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

    .prologue
    .line 91
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->configuration:Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

    .line 92
    return-void
.end method

.method public track(Ljava/lang/String;Ljava/util/Map;Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;)V
    .locals 6
    .param p1, "url"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 751
    .local p2, "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .local p3, "asyncHandler":Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;, "Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler<Ljava/lang/String;>;"
    new-instance v2, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;

    const/4 v3, 0x0

    invoke-direct {v2, p1, p2, v3}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;-><init>(Ljava/lang/String;Ljava/util/Map;Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;)V

    .line 755
    .local v2, "slogger":Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;
    :try_start_0
    invoke-virtual {v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;->getServiceAsync()Ljava/util/concurrent/Future;

    move-result-object v1

    .line 756
    .local v1, "futureSloggerAccessor":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<Lorg/springframework/http/ResponseEntity<[B>;>;"
    const-wide/16 v4, 0x5

    sget-object v3, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface {v1, v4, v5, v3}, Ljava/util/concurrent/Future;->get(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_2

    .line 777
    .end local v1    # "futureSloggerAccessor":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<Lorg/springframework/http/ResponseEntity<[B>;>;"
    :cond_0
    :goto_0
    return-void

    .line 766
    :catch_0
    move-exception v0

    .line 767
    .local v0, "e":Ljava/lang/InterruptedException;
    if-eqz p3, :cond_0

    .line 768
    new-instance v3, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v4, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_SLOGGER_ERROR:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v3, v4, v0}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/Throwable;)V

    invoke-interface {p3, v3}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onError(Ljava/lang/Exception;)V

    goto :goto_0

    .line 769
    .end local v0    # "e":Ljava/lang/InterruptedException;
    :catch_1
    move-exception v0

    .line 770
    .local v0, "e":Ljava/util/concurrent/ExecutionException;
    if-eqz p3, :cond_0

    .line 771
    new-instance v3, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v4, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_SLOGGER_ERROR:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v3, v4, v0}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/Throwable;)V

    invoke-interface {p3, v3}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onError(Ljava/lang/Exception;)V

    goto :goto_0

    .line 772
    .end local v0    # "e":Ljava/util/concurrent/ExecutionException;
    :catch_2
    move-exception v0

    .line 773
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 774
    if-eqz p3, :cond_0

    .line 775
    new-instance v3, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v4, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_SLOGGER_ERROR:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v3, v4, v0}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/Throwable;)V

    invoke-interface {p3, v3}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onError(Ljava/lang/Exception;)V

    goto :goto_0
.end method

.method public trackAdBreakEnd(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 0
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    .line 176
    return-void
.end method

.method public trackAdBreakStart(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 0
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    .line 171
    return-void
.end method

.method public trackAdEnd(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 7
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    .line 203
    if-eqz p1, :cond_0

    :try_start_0
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    const-string v3, "activity"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 205
    if-eqz p1, :cond_0

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    const-string v3, "currentMedia"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 207
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    const-string v3, "currentMedia"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    .line 208
    .local v0, "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    if-eqz v0, :cond_0

    .line 210
    const-string v2, "ad1"

    invoke-interface {p1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvent(Ljava/lang/String;)V

    .line 212
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->getName()Ljava/lang/String;

    move-result-object v2

    const-string v3, "trackAdEnd"

    invoke-static {v2, v3}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 213
    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {p0, v2, v3, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->trackLink(Ljava/lang/String;Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 220
    .end local v0    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    :cond_0
    :goto_0
    return-void

    .line 217
    :catch_0
    move-exception v1

    .line 218
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->getName()Ljava/lang/String;

    move-result-object v2

    const-string v3, "trackAdEnd could not be executed : %s"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public trackAdError(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 0
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    .line 226
    return-void
.end method

.method public trackAdFirstQuartile(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 0
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    .line 232
    return-void
.end method

.method public trackAdMidpoint(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 0
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    .line 238
    return-void
.end method

.method public trackAdStart(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 7
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    .line 181
    if-eqz p1, :cond_0

    :try_start_0
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    const-string v3, "activity"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 183
    if-eqz p1, :cond_0

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    const-string v3, "currentMedia"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 185
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    const-string v3, "currentMedia"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    .line 186
    .local v0, "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    if-eqz v0, :cond_0

    .line 188
    const-string v2, "ad0"

    invoke-interface {p1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvent(Ljava/lang/String;)V

    .line 190
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->getName()Ljava/lang/String;

    move-result-object v2

    const-string v3, "trackAdStart"

    invoke-static {v2, v3}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 191
    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {p0, v2, v3, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->trackLink(Ljava/lang/String;Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 198
    .end local v0    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    :cond_0
    :goto_0
    return-void

    .line 195
    :catch_0
    move-exception v1

    .line 196
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->getName()Ljava/lang/String;

    move-result-object v2

    const-string v3, "trackAdStart could not be executed : %s"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public trackAdThirdQuartile(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 0
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    .line 244
    return-void
.end method

.method public trackAuthZFailure(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 7
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    .line 149
    if-eqz p1, :cond_0

    :try_start_0
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    const-string v3, "activity"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 151
    if-eqz p1, :cond_0

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    const-string v3, "currentMedia"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 152
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    const-string v3, "currentMedia"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    .line 154
    .local v0, "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    if-eqz v0, :cond_0

    .line 155
    const-string v2, "atz2"

    invoke-interface {p1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvent(Ljava/lang/String;)V

    .line 156
    const-string v2, "authzerror"

    const-string v3, "AuthZFailure"

    invoke-interface {p1, v2, v3}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addContext(Ljava/lang/String;Ljava/lang/Object;)V

    .line 158
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->getName()Ljava/lang/String;

    move-result-object v2

    const-string v3, "trackAuthZFailure"

    invoke-static {v2, v3}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 159
    const/4 v2, 0x0

    const-string v3, "authz"

    invoke-virtual {p0, v2, v3, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->trackLink(Ljava/lang/String;Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 166
    .end local v0    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    :cond_0
    :goto_0
    return-void

    .line 163
    :catch_0
    move-exception v1

    .line 164
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->getName()Ljava/lang/String;

    move-result-object v2

    const-string v3, "trackAuthZFailure could not be executed : %s"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public trackAuthZStarted(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 7
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    .line 108
    if-eqz p1, :cond_0

    :try_start_0
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    const-string v3, "activity"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 109
    if-eqz p1, :cond_0

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    const-string v3, "currentMedia"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 111
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    const-string v3, "currentMedia"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    .line 112
    .local v0, "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    if-eqz v0, :cond_0

    .line 114
    const-string v2, "atz0"

    invoke-interface {p1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvent(Ljava/lang/String;)V

    .line 115
    const/4 v2, 0x0

    const-string v3, "authz"

    invoke-virtual {p0, v2, v3, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->trackLink(Ljava/lang/String;Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 122
    .end local v0    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    :cond_0
    :goto_0
    return-void

    .line 119
    :catch_0
    move-exception v1

    .line 120
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->getName()Ljava/lang/String;

    move-result-object v2

    const-string v3, "trackAuthZStarted could not be executed : %s"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public trackAuthZSuccess(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 7
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    .line 127
    if-eqz p1, :cond_0

    :try_start_0
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    const-string v3, "activity"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 129
    if-eqz p1, :cond_0

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    const-string v3, "currentMedia"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 131
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    const-string v3, "currentMedia"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    .line 132
    .local v0, "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    if-eqz v0, :cond_0

    .line 134
    const-string v2, "atz1"

    invoke-interface {p1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvent(Ljava/lang/String;)V

    .line 136
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->getName()Ljava/lang/String;

    move-result-object v2

    const-string v3, "trackAuthZSuccess"

    invoke-static {v2, v3}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 137
    const/4 v2, 0x0

    const-string v3, "authz"

    invoke-virtual {p0, v2, v3, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->trackLink(Ljava/lang/String;Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 144
    .end local v0    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    :cond_0
    :goto_0
    return-void

    .line 141
    :catch_0
    move-exception v1

    .line 142
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->getName()Ljava/lang/String;

    move-result-object v2

    const-string v3, "trackAuthZSuccess could not be executed : %s"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public trackLink(Ljava/lang/String;Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 15
    .param p1, "linkType"    # Ljava/lang/String;
    .param p2, "linkName"    # Ljava/lang/String;
    .param p3, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    .line 493
    if-eqz p3, :cond_2

    :try_start_0
    invoke-interface/range {p3 .. p3}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v10

    if-eqz v10, :cond_2

    invoke-interface/range {p3 .. p3}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v10

    const-string v11, "activity"

    invoke-interface {v10, v11}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    if-eqz v10, :cond_2

    .line 494
    invoke-interface/range {p3 .. p3}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v10

    const-string v11, "activity"

    invoke-interface {v10, v11}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .line 495
    .local v2, "activity":Ljava/lang/Object;
    instance-of v10, v2, Landroid/app/Fragment;

    if-eqz v10, :cond_0

    .line 496
    check-cast v2, Landroid/app/Fragment;

    .end local v2    # "activity":Ljava/lang/Object;
    invoke-virtual {v2}, Landroid/app/Fragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    .line 499
    :cond_0
    move-object v0, v2

    check-cast v0, Landroid/app/Activity;

    move-object v3, v0

    .line 500
    .local v3, "acty":Landroid/app/Activity;
    move-object/from16 v0, p3

    move-object/from16 v1, p2

    invoke-direct {p0, v0, v1, v3}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->getParams(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;Ljava/lang/String;Landroid/content/Context;)Ljava/util/Map;

    move-result-object v8

    .line 501
    .local v8, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->getHeaders()Ljava/util/Map;

    move-result-object v5

    .line 503
    .local v5, "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v11

    sget v12, Lcom/disney/datg/videoplatforms/sdk/R$string;->slogger_url:I

    invoke-virtual {v11, v12}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, "?"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    .line 504
    .local v9, "url":Ljava/lang/String;
    if-eqz v8, :cond_1

    .line 505
    invoke-interface {v8}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v10

    invoke-interface {v10}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v6

    .local v6, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v10

    if-eqz v10, :cond_1

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    .line 506
    .local v7, "key":Ljava/lang/String;
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v10, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, "="

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-interface {v8, v7}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Ljava/lang/String;

    const-string v12, "UTF-8"

    invoke-static {v10, v12}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v11, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, "&"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    .line 507
    goto :goto_0

    .line 509
    .end local v6    # "i$":Ljava/util/Iterator;
    .end local v7    # "key":Ljava/lang/String;
    :cond_1
    const/4 v10, 0x0

    invoke-virtual {p0, v9, v5, v10}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->track(Ljava/lang/String;Ljava/util/Map;Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 515
    .end local v3    # "acty":Landroid/app/Activity;
    .end local v5    # "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v8    # "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v9    # "url":Ljava/lang/String;
    :cond_2
    :goto_1
    return-void

    .line 511
    :catch_0
    move-exception v4

    .line 512
    .local v4, "e":Ljava/lang/Exception;
    invoke-virtual {v4}, Ljava/lang/Exception;->printStackTrace()V

    .line 513
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->getName()Ljava/lang/String;

    move-result-object v10

    const-string v11, "trackLink could not be executed : %s"

    const/4 v12, 0x1

    new-array v12, v12, [Ljava/lang/Object;

    const/4 v13, 0x0

    invoke-virtual {v4}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v14

    aput-object v14, v12, v13

    invoke-static {v11, v12}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v11

    invoke-static {v10, v11}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method

.method public trackMediaComplete(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 7
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    .line 420
    if-eqz p1, :cond_0

    :try_start_0
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    const-string v3, "activity"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 422
    if-eqz p1, :cond_0

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    const-string v3, "currentMedia"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 424
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    const-string v3, "currentMedia"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    .line 425
    .local v0, "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    if-eqz v0, :cond_0

    .line 427
    const-string v2, "end1"

    invoke-interface {p1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvent(Ljava/lang/String;)V

    .line 429
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->getName()Ljava/lang/String;

    move-result-object v2

    const-string v3, "trackMediaComplete"

    invoke-static {v2, v3}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 430
    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {p0, v2, v3, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->trackLink(Ljava/lang/String;Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 438
    .end local v0    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    :cond_0
    :goto_0
    return-void

    .line 434
    :catch_0
    move-exception v1

    .line 435
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->getName()Ljava/lang/String;

    move-result-object v2

    const-string v3, "trackMediaComplete could not be executed : %s"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public trackMediaError(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 8
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    .line 443
    if-eqz p1, :cond_0

    :try_start_0
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v3

    if-eqz v3, :cond_0

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v3

    const-string v4, "activity"

    invoke-interface {v3, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    if-eqz v3, :cond_0

    .line 445
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v3

    const-string v4, "error"

    invoke-interface {v3, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    if-eqz v3, :cond_0

    .line 447
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v3

    const-string v4, "trackCode"

    invoke-interface {v3, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 448
    .local v2, "linkMsg":Ljava/lang/String;
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v3

    const-string v4, "error"

    invoke-interface {v3, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 451
    .local v1, "errorMsg":Ljava/lang/String;
    const-string v3, "errc"

    invoke-interface {p1, v3, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addContext(Ljava/lang/String;Ljava/lang/Object;)V

    .line 453
    const-string v3, "errmsg"

    invoke-interface {p1, v3, v1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addContext(Ljava/lang/String;Ljava/lang/Object;)V

    .line 455
    const-string v3, "err0"

    invoke-interface {p1, v3}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvent(Ljava/lang/String;)V

    .line 456
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->getName()Ljava/lang/String;

    move-result-object v3

    const-string v4, "trackMediaError"

    invoke-static {v3, v4}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 457
    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-virtual {p0, v3, v4, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->trackLink(Ljava/lang/String;Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 465
    .end local v1    # "errorMsg":Ljava/lang/String;
    .end local v2    # "linkMsg":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 461
    :catch_0
    move-exception v0

    .line 462
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->getName()Ljava/lang/String;

    move-result-object v3

    const-string v4, "trackMediaError could not be executed : %s"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public trackMediaFirstQuarter(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 0
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    .line 405
    return-void
.end method

.method public trackMediaForward(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 7
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    .line 350
    if-eqz p1, :cond_0

    :try_start_0
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    const-string v3, "activity"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 352
    if-eqz p1, :cond_0

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    const-string v3, "currentMedia"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 354
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    const-string v3, "currentMedia"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    .line 355
    .local v0, "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    if-eqz v0, :cond_0

    .line 357
    const-string v2, "start5"

    invoke-interface {p1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvent(Ljava/lang/String;)V

    .line 359
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->getName()Ljava/lang/String;

    move-result-object v2

    const-string v3, "trackMediaForward"

    invoke-static {v2, v3}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 360
    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {p0, v2, v3, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->trackLink(Ljava/lang/String;Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 368
    .end local v0    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    :cond_0
    :goto_0
    return-void

    .line 364
    :catch_0
    move-exception v1

    .line 365
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->getName()Ljava/lang/String;

    move-result-object v2

    const-string v3, "trackMediaForward could not be executed : %s"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public trackMediaMidpoint(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 0
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    .line 410
    return-void
.end method

.method public trackMediaPaused(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 7
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    .line 279
    if-eqz p1, :cond_0

    :try_start_0
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    const-string v3, "activity"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 281
    if-eqz p1, :cond_0

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    const-string v3, "currentMedia"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 283
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    const-string v3, "currentMedia"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    .line 284
    .local v0, "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    if-eqz v0, :cond_0

    .line 286
    const-string v2, "stop0"

    invoke-interface {p1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvent(Ljava/lang/String;)V

    .line 288
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->getName()Ljava/lang/String;

    move-result-object v2

    const-string v3, "trackMediaPaused"

    invoke-static {v2, v3}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 289
    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {p0, v2, v3, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->trackLink(Ljava/lang/String;Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 297
    .end local v0    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    :cond_0
    :goto_0
    return-void

    .line 293
    :catch_0
    move-exception v1

    .line 294
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->getName()Ljava/lang/String;

    move-result-object v2

    const-string v3, "trackMediaPaused could not be executed : %s"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public trackMediaResumed(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 10
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    .line 302
    if-eqz p1, :cond_1

    :try_start_0
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v5

    if-eqz v5, :cond_1

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v5

    const-string v6, "activity"

    invoke-interface {v5, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    if-eqz v5, :cond_1

    .line 303
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v5

    const-string v6, "activity"

    invoke-interface {v5, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .line 304
    .local v2, "activity":Ljava/lang/Object;
    instance-of v5, v2, Landroid/app/Fragment;

    if-eqz v5, :cond_0

    .line 305
    check-cast v2, Landroid/app/Fragment;

    .end local v2    # "activity":Ljava/lang/Object;
    invoke-virtual {v2}, Landroid/app/Fragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    .line 307
    :cond_0
    move-object v0, v2

    check-cast v0, Landroid/app/Activity;

    move-object v1, v0

    .line 308
    .local v1, "act":Landroid/app/Activity;
    if-eqz p1, :cond_1

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v5

    if-eqz v5, :cond_1

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v5

    const-string v6, "currentMedia"

    invoke-interface {v5, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    if-eqz v5, :cond_1

    .line 310
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v5

    const-string v6, "currentMedia"

    invoke-interface {v5, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    .line 311
    .local v3, "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    if-eqz v3, :cond_1

    .line 313
    const-string v5, "start4"

    invoke-interface {p1, v5}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvent(Ljava/lang/String;)V

    .line 315
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->getName()Ljava/lang/String;

    move-result-object v5

    const-string v6, "trackMediaResumed"

    invoke-static {v5, v6}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 316
    const/4 v5, 0x0

    const/4 v6, 0x0

    invoke-virtual {p0, v5, v6, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->trackLink(Ljava/lang/String;Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 323
    .end local v1    # "act":Landroid/app/Activity;
    .end local v3    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    :cond_1
    :goto_0
    return-void

    .line 320
    :catch_0
    move-exception v4

    .line 321
    .local v4, "e":Ljava/lang/Exception;
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->getName()Ljava/lang/String;

    move-result-object v5

    const-string v6, "trackMediaResumed could not be executed : %s"

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    invoke-virtual {v4}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v9

    aput-object v9, v7, v8

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public trackMediaRewind(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 7
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    .line 372
    if-eqz p1, :cond_1

    :try_start_0
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    if-eqz v2, :cond_1

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    const-string v3, "activity"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 374
    if-eqz p1, :cond_1

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    if-eqz v2, :cond_1

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    const-string v3, "currentMedia"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 376
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    const-string v3, "currentMedia"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    .line 377
    .local v0, "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    if-eqz v0, :cond_1

    .line 379
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    const-string v3, "10_sec_rewind"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 380
    const-string v2, "start7"

    invoke-interface {p1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvent(Ljava/lang/String;)V

    .line 382
    :cond_0
    const-string v2, "start6"

    invoke-interface {p1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvent(Ljava/lang/String;)V

    .line 385
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->getName()Ljava/lang/String;

    move-result-object v2

    const-string v3, "trackMediaRewind"

    invoke-static {v2, v3}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 386
    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {p0, v2, v3, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->trackLink(Ljava/lang/String;Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 394
    .end local v0    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    :cond_1
    :goto_0
    return-void

    .line 390
    :catch_0
    move-exception v1

    .line 391
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->getName()Ljava/lang/String;

    move-result-object v2

    const-string v3, "trackMediaRewind could not be executed : %s"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public trackMediaStarted(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 10
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    .line 249
    if-eqz p1, :cond_1

    :try_start_0
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v5

    if-eqz v5, :cond_1

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v5

    const-string v6, "activity"

    invoke-interface {v5, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    if-eqz v5, :cond_1

    .line 250
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v5

    const-string v6, "activity"

    invoke-interface {v5, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .line 251
    .local v2, "activity":Ljava/lang/Object;
    instance-of v5, v2, Landroid/app/Fragment;

    if-eqz v5, :cond_0

    .line 252
    check-cast v2, Landroid/app/Fragment;

    .end local v2    # "activity":Ljava/lang/Object;
    invoke-virtual {v2}, Landroid/app/Fragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    .line 254
    :cond_0
    move-object v0, v2

    check-cast v0, Landroid/app/Activity;

    move-object v1, v0

    .line 255
    .local v1, "act":Landroid/app/Activity;
    if-eqz p1, :cond_1

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v5

    if-eqz v5, :cond_1

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v5

    const-string v6, "currentMedia"

    invoke-interface {v5, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    if-eqz v5, :cond_1

    .line 257
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v5

    const-string v6, "currentMedia"

    invoke-interface {v5, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    .line 258
    .local v3, "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    if-eqz v3, :cond_1

    .line 260
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v5

    const-string v6, "start_video"

    invoke-interface {v5, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    if-eqz v5, :cond_2

    .line 261
    const-string v5, "start3"

    invoke-interface {p1, v5}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvent(Ljava/lang/String;)V

    .line 266
    :goto_0
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->getName()Ljava/lang/String;

    move-result-object v5

    const-string v6, "trackMediaStarted"

    invoke-static {v5, v6}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 267
    const/4 v5, 0x0

    const/4 v6, 0x0

    invoke-virtual {p0, v5, v6, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->trackLink(Ljava/lang/String;Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    .line 274
    .end local v1    # "act":Landroid/app/Activity;
    .end local v3    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    :cond_1
    :goto_1
    return-void

    .line 263
    .restart local v1    # "act":Landroid/app/Activity;
    .restart local v3    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    :cond_2
    const-string v5, "start1"

    invoke-interface {p1, v5}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvent(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 271
    .end local v1    # "act":Landroid/app/Activity;
    .end local v3    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    :catch_0
    move-exception v4

    .line 272
    .local v4, "e":Ljava/lang/Exception;
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->getName()Ljava/lang/String;

    move-result-object v5

    const-string v6, "trackMediaStarted could not be executed : %s"

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    invoke-virtual {v4}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v9

    aput-object v9, v7, v8

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method

.method public trackMediaStateUpdated(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 0
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    .line 400
    return-void
.end method

.method public trackMediaStopped(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 7
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    .line 328
    if-eqz p1, :cond_0

    :try_start_0
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    const-string v3, "activity"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 330
    if-eqz p1, :cond_0

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    const-string v3, "currentMedia"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 332
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    const-string v3, "currentMedia"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    .line 333
    .local v0, "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    if-eqz v0, :cond_0

    .line 335
    const-string v2, "stop1"

    invoke-interface {p1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvent(Ljava/lang/String;)V

    .line 337
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->getName()Ljava/lang/String;

    move-result-object v2

    const-string v3, "trackMediaStopped"

    invoke-static {v2, v3}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 338
    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {p0, v2, v3, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->trackLink(Ljava/lang/String;Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 346
    .end local v0    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    :cond_0
    :goto_0
    return-void

    .line 342
    :catch_0
    move-exception v1

    .line 343
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->getName()Ljava/lang/String;

    move-result-object v2

    const-string v3, "trackMediaStopped could not be executed : %s"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public trackMediaThirdQuarter(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 0
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    .line 415
    return-void
.end method

.method public trackPing(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 7
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    .line 470
    if-eqz p1, :cond_0

    :try_start_0
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    const-string v3, "activity"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 472
    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getContextData()Ljava/util/Map;

    move-result-object v2

    const-string v3, "currentMedia"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    .line 473
    .local v0, "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    if-eqz v0, :cond_0

    .line 475
    const-string v2, "ping0"

    invoke-interface {p1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->addEvent(Ljava/lang/String;)V

    .line 477
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->getName()Ljava/lang/String;

    move-result-object v2

    const-string v3, "trackPing"

    invoke-static {v2, v3}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 478
    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {p0, v2, v3, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->trackLink(Ljava/lang/String;Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 485
    .end local v0    # "currentMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    :cond_0
    :goto_0
    return-void

    .line 481
    :catch_0
    move-exception v1

    .line 482
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;->getName()Ljava/lang/String;

    move-result-object v2

    const-string v3, "trackPing could not be executed : %s"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

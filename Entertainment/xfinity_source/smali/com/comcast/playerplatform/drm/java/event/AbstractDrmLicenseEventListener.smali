.class public Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;
.super Ljava/lang/Object;
.source "AbstractDrmLicenseEventListener.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public acquiringLicense(Ljava/lang/String;)V
    .locals 0
    .param p1, "asset"    # Ljava/lang/String;

    .prologue
    .line 42
    return-void
.end method

.method public drmComplete(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;)V
    .locals 0
    .param p1, "asset"    # Ljava/lang/String;
    .param p2, "licenseStart"    # Ljava/util/Date;
    .param p3, "licenseEnd"    # Ljava/util/Date;

    .prologue
    .line 50
    return-void
.end method

.method public drmFailure(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V
    .locals 0
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;
    .param p3, "messageId"    # Ljava/lang/String;
    .param p4, "e"    # Ljava/lang/Exception;

    .prologue
    .line 58
    return-void
.end method

.method public licenseReturnFailure(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V
    .locals 0
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;
    .param p3, "messageId"    # Ljava/lang/String;
    .param p4, "e"    # Ljava/lang/Exception;

    .prologue
    .line 62
    return-void
.end method

.method public offlineDRMComplete(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;)V
    .locals 0
    .param p1, "asset"    # Ljava/lang/String;
    .param p2, "licenseStart"    # Ljava/util/Date;
    .param p3, "licenseEnd"    # Ljava/util/Date;
    .param p4, "policyId"    # Ljava/lang/String;

    .prologue
    .line 29
    return-void
.end method

.method public offlineDRMFailure(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;
    .param p3, "messageId"    # Ljava/lang/String;

    .prologue
    .line 36
    return-void
.end method

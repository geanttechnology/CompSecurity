.class public Lcom/xfinity/playerlib/downloads/MediaLicenseClient$LicenseAcquisitionTimeoutException;
.super Lcom/comcast/cim/cmasl/utils/exceptions/CimException;
.source "MediaLicenseClient.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/downloads/MediaLicenseClient;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LicenseAcquisitionTimeoutException"
.end annotation


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 0
    .param p1, "detailMessage"    # Ljava/lang/String;
    .param p2, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 98
    invoke-direct {p0, p1, p2}, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 99
    return-void
.end method

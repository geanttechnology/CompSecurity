.class public Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$GenericWebResponseParser$ResponseInfo;
.super Ljava/lang/Object;
.source "AmazonOODMSUserIdentifier.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$GenericWebResponseParser;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xc
    name = "ResponseInfo"
.end annotation


# instance fields
.field public final httpCode:J

.field public final response:Ljava/lang/String;


# direct methods
.method public constructor <init>(JLjava/lang/String;)V
    .locals 0
    .param p1, "givenHttpCode"    # J
    .param p3, "givenResponse"    # Ljava/lang/String;

    .prologue
    .line 225
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 226
    iput-wide p1, p0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$GenericWebResponseParser$ResponseInfo;->httpCode:J

    .line 227
    iput-object p3, p0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$GenericWebResponseParser$ResponseInfo;->response:Ljava/lang/String;

    .line 228
    return-void
.end method

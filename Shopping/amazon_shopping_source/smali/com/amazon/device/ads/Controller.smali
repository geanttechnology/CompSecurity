.class Lcom/amazon/device/ads/Controller;
.super Ljava/lang/Object;
.source "Controller.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/device/ads/Controller$PlayerProperties;,
        Lcom/amazon/device/ads/Controller$Dimensions;,
        Lcom/amazon/device/ads/Controller$ReflectedParcelable;
    }
.end annotation


# static fields
.field private static LOG_TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 16
    const-string/jumbo v0, "Controller"

    sput-object v0, Lcom/amazon/device/ads/Controller;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 129
    return-void
.end method

.method static synthetic access$000()Ljava/lang/String;
    .locals 1

    .prologue
    .line 14
    sget-object v0, Lcom/amazon/device/ads/Controller;->LOG_TAG:Ljava/lang/String;

    return-object v0
.end method

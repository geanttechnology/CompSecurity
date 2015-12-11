.class public Lcom/amazon/device/ads/AmazonOOAppEvent;
.super Lcom/amazon/device/ads/AppEvent;
.source "AmazonOOAppEvent.java"


# static fields
.field public static final FIRST_LOGIN:Lcom/amazon/device/ads/AmazonOOAppEvent;

.field public static final FIRST_PURCHASE:Lcom/amazon/device/ads/AmazonOOAppEvent;

.field public static final LOGIN:Lcom/amazon/device/ads/AmazonOOAppEvent;

.field public static final PURCHASE:Lcom/amazon/device/ads/AmazonOOAppEvent;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 15
    new-instance v0, Lcom/amazon/device/ads/AmazonOOAppEvent;

    const-string/jumbo v1, "firstLogin"

    invoke-direct {v0, v1}, Lcom/amazon/device/ads/AmazonOOAppEvent;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/AmazonOOAppEvent;->FIRST_LOGIN:Lcom/amazon/device/ads/AmazonOOAppEvent;

    .line 18
    new-instance v0, Lcom/amazon/device/ads/AmazonOOAppEvent;

    const-string/jumbo v1, "firstPurchase"

    invoke-direct {v0, v1}, Lcom/amazon/device/ads/AmazonOOAppEvent;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/AmazonOOAppEvent;->FIRST_PURCHASE:Lcom/amazon/device/ads/AmazonOOAppEvent;

    .line 21
    new-instance v0, Lcom/amazon/device/ads/AmazonOOAppEvent;

    const-string/jumbo v1, "login"

    invoke-direct {v0, v1}, Lcom/amazon/device/ads/AmazonOOAppEvent;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/AmazonOOAppEvent;->LOGIN:Lcom/amazon/device/ads/AmazonOOAppEvent;

    .line 24
    new-instance v0, Lcom/amazon/device/ads/AmazonOOAppEvent;

    const-string/jumbo v1, "purchase"

    invoke-direct {v0, v1}, Lcom/amazon/device/ads/AmazonOOAppEvent;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/AmazonOOAppEvent;->PURCHASE:Lcom/amazon/device/ads/AmazonOOAppEvent;

    return-void
.end method

.method constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "eventName"    # Ljava/lang/String;

    .prologue
    .line 33
    invoke-direct {p0, p1}, Lcom/amazon/device/ads/AppEvent;-><init>(Ljava/lang/String;)V

    .line 34
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;J)V
    .locals 0
    .param p1, "eventName"    # Ljava/lang/String;
    .param p2, "timestamp"    # J

    .prologue
    .line 43
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/device/ads/AppEvent;-><init>(Ljava/lang/String;J)V

    .line 44
    return-void
.end method

.method public static createAppEventWithTimestamp(Lcom/amazon/device/ads/AmazonOOAppEvent;J)Lcom/amazon/device/ads/AmazonOOAppEvent;
    .locals 2
    .param p0, "appEvent"    # Lcom/amazon/device/ads/AmazonOOAppEvent;
    .param p1, "timestamp"    # J

    .prologue
    .line 54
    new-instance v0, Lcom/amazon/device/ads/AmazonOOAppEvent;

    invoke-virtual {p0}, Lcom/amazon/device/ads/AmazonOOAppEvent;->getEventName()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1, p1, p2}, Lcom/amazon/device/ads/AmazonOOAppEvent;-><init>(Ljava/lang/String;J)V

    return-object v0
.end method


# virtual methods
.method public bridge synthetic getEventName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 12
    invoke-super {p0}, Lcom/amazon/device/ads/AppEvent;->getEventName()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic getProperty(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "x0"    # Ljava/lang/String;

    .prologue
    .line 12
    invoke-super {p0, p1}, Lcom/amazon/device/ads/AppEvent;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic getPropertyEntries()Ljava/util/Set;
    .locals 1

    .prologue
    .line 12
    invoke-super {p0}, Lcom/amazon/device/ads/AppEvent;->getPropertyEntries()Ljava/util/Set;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic getTimestamp()J
    .locals 2

    .prologue
    .line 12
    invoke-super {p0}, Lcom/amazon/device/ads/AppEvent;->getTimestamp()J

    move-result-wide v0

    return-wide v0
.end method

.method public bridge synthetic setProperty(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/device/ads/AppEvent;
    .locals 1
    .param p1, "x0"    # Ljava/lang/String;
    .param p2, "x1"    # Ljava/lang/String;

    .prologue
    .line 12
    invoke-super {p0, p1, p2}, Lcom/amazon/device/ads/AppEvent;->setProperty(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/device/ads/AppEvent;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 12
    invoke-super {p0}, Lcom/amazon/device/ads/AppEvent;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

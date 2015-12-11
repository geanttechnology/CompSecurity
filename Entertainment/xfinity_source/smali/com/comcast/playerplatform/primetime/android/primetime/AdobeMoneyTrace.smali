.class public Lcom/comcast/playerplatform/primetime/android/primetime/AdobeMoneyTrace;
.super Lcom/adobe/mediacore/system/NetworkConfiguration;
.source "AdobeMoneyTrace.java"


# instance fields
.field customHeaders:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "[",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field moneyTrace:Lcom/comcast/playerplatform/util/android/MoneyTrace;

.field random:Ljava/util/Random;


# direct methods
.method public constructor <init>(Lcom/comcast/playerplatform/util/android/MoneyTrace;)V
    .locals 3
    .param p1, "moneyTrace"    # Lcom/comcast/playerplatform/util/android/MoneyTrace;

    .prologue
    .line 18
    invoke-direct {p0}, Lcom/adobe/mediacore/system/NetworkConfiguration;-><init>()V

    .line 13
    new-instance v1, Ljava/util/Random;

    invoke-direct {v1}, Ljava/util/Random;-><init>()V

    iput-object v1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/AdobeMoneyTrace;->random:Ljava/util/Random;

    .line 16
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    iput-object v1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/AdobeMoneyTrace;->customHeaders:Ljava/util/HashMap;

    .line 19
    if-eqz p1, :cond_0

    .line 20
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/AdobeMoneyTrace;->moneyTrace:Lcom/comcast/playerplatform/util/android/MoneyTrace;

    .line 21
    const/4 v1, 0x3

    new-array v0, v1, [Ljava/lang/String;

    .line 22
    .local v0, "array":[Ljava/lang/String;
    const/4 v1, 0x0

    invoke-virtual {p1}, Lcom/comcast/playerplatform/util/android/MoneyTrace;->getTraceId()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v0, v1

    .line 25
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/AdobeMoneyTrace;->customHeaders:Ljava/util/HashMap;

    invoke-virtual {p1}, Lcom/comcast/playerplatform/util/android/MoneyTrace;->getHttpHeader()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 26
    invoke-virtual {p1}, Lcom/comcast/playerplatform/util/android/MoneyTrace;->getHttpHeader()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1, v0}, Lcom/comcast/playerplatform/primetime/android/primetime/AdobeMoneyTrace;->addCustomHeader(Ljava/lang/String;[Ljava/lang/String;)V

    .line 28
    .end local v0    # "array":[Ljava/lang/String;
    :cond_0
    return-void
.end method


# virtual methods
.method public getCustomHeaders()Ljava/util/HashMap;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "[",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v6, 0x1

    .line 32
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/AdobeMoneyTrace;->moneyTrace:Lcom/comcast/playerplatform/util/android/MoneyTrace;

    if-eqz v1, :cond_1

    .line 33
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/AdobeMoneyTrace;->customHeaders:Ljava/util/HashMap;

    iget-object v4, p0, Lcom/comcast/playerplatform/primetime/android/primetime/AdobeMoneyTrace;->moneyTrace:Lcom/comcast/playerplatform/util/android/MoneyTrace;

    invoke-virtual {v4}, Lcom/comcast/playerplatform/util/android/MoneyTrace;->getHttpHeader()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Ljava/lang/String;

    .line 34
    .local v0, "array":[Ljava/lang/String;
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/AdobeMoneyTrace;->random:Ljava/util/Random;

    invoke-virtual {v1}, Ljava/util/Random;->nextLong()J

    move-result-wide v2

    .line 35
    .local v2, "nextLong":J
    const-wide/16 v4, 0x0

    cmp-long v1, v2, v4

    if-gez v1, :cond_0

    .line 36
    neg-long v2, v2

    .line 38
    :cond_0
    invoke-static {v2, v3}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v1

    aput-object v1, v0, v6

    .line 39
    const/4 v1, 0x2

    aget-object v4, v0, v6

    aput-object v4, v0, v1

    .line 42
    .end local v0    # "array":[Ljava/lang/String;
    .end local v2    # "nextLong":J
    :cond_1
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/AdobeMoneyTrace;->customHeaders:Ljava/util/HashMap;

    return-object v1
.end method

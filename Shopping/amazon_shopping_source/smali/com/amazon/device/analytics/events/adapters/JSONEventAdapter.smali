.class public Lcom/amazon/device/analytics/events/adapters/JSONEventAdapter;
.super Ljava/lang/Object;
.source "JSONEventAdapter.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;"
    }
.end annotation


# static fields
.field private static logger:Lcom/amazon/device/analytics/log/Logger;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 14
    const-class v0, Lcom/amazon/device/analytics/events/adapters/JSONEventAdapter;

    invoke-static {v0}, Lcom/amazon/device/analytics/log/Logging;->getLogger(Ljava/lang/Class;)Lcom/amazon/device/analytics/log/Logger;

    move-result-object v0

    sput-object v0, Lcom/amazon/device/analytics/events/adapters/JSONEventAdapter;->logger:Lcom/amazon/device/analytics/log/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    new-instance v0, Lcom/amazon/device/analytics/util/JSONBuilder;

    invoke-direct {v0, p0}, Lcom/amazon/device/analytics/util/JSONBuilder;-><init>(Ljava/lang/Object;)V

    invoke-virtual {v0}, Lcom/amazon/device/analytics/util/JSONBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public translateFromEvent(Lcom/amazon/device/analytics/events/Event;)Lorg/json/JSONObject;
    .locals 3
    .param p1, "source"    # Lcom/amazon/device/analytics/events/Event;

    .prologue
    .line 18
    if-nez p1, :cond_1

    .line 19
    sget-object v1, Lcom/amazon/device/analytics/events/adapters/JSONEventAdapter;->logger:Lcom/amazon/device/analytics/log/Logger;

    const-string/jumbo v2, "The Event provided was null"

    invoke-virtual {v1, v2}, Lcom/amazon/device/analytics/log/Logger;->i(Ljava/lang/String;)V

    .line 20
    const/4 v0, 0x0

    .line 29
    :cond_0
    :goto_0
    return-object v0

    .line 22
    :cond_1
    invoke-virtual {p1}, Lcom/amazon/device/analytics/events/Event;->toJSONObject()Lorg/json/JSONObject;

    move-result-object v0

    .line 23
    .local v0, "json":Lorg/json/JSONObject;
    const-string/jumbo v1, "class"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 24
    const-string/jumbo v1, "class"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->remove(Ljava/lang/String;)Ljava/lang/Object;

    .line 26
    :cond_2
    const-string/jumbo v1, "hashCode"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 27
    const-string/jumbo v1, "hashCode"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->remove(Ljava/lang/String;)Ljava/lang/Object;

    goto :goto_0
.end method

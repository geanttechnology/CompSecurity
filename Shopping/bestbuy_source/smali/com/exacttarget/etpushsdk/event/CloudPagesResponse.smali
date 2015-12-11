.class public Lcom/exacttarget/etpushsdk/event/CloudPagesResponse;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/exacttarget/etpushsdk/event/IEventFactory;


# static fields
.field protected static final JF_MESSAGES:Ljava/lang/String; = "messages"

.field private static final TAG:Ljava/lang/String; = "~!CloudPagesResponse"


# instance fields
.field private messages:Ljava/util/ArrayList;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public fromJson(Ljava/lang/String;)Lcom/exacttarget/etpushsdk/event/CloudPagesResponse;
    .locals 6

    .prologue
    .line 83
    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 84
    const-string v1, "messages"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v1

    .line 85
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 87
    if-eqz v1, :cond_0

    .line 88
    invoke-virtual {v1}, Lorg/json/JSONArray;->length()I

    move-result v3

    .line 89
    const/4 v0, 0x0

    :goto_0
    if-ge v0, v3, :cond_0

    .line 90
    invoke-virtual {v1, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v4

    .line 91
    new-instance v5, Lcom/exacttarget/etpushsdk/data/Message;

    invoke-direct {v5, v4}, Lcom/exacttarget/etpushsdk/data/Message;-><init>(Lorg/json/JSONObject;)V

    .line 92
    invoke-virtual {v2, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 89
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 95
    :cond_0
    invoke-virtual {p0, v2}, Lcom/exacttarget/etpushsdk/event/CloudPagesResponse;->setMessages(Ljava/util/ArrayList;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 99
    :goto_1
    return-object p0

    .line 97
    :catch_0
    move-exception v0

    .line 98
    const-string v1, "~!CloudPagesResponse"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 99
    const/4 p0, 0x0

    goto :goto_1
.end method

.method public bridge synthetic fromJson(Ljava/lang/String;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 28
    invoke-virtual {p0, p1}, Lcom/exacttarget/etpushsdk/event/CloudPagesResponse;->fromJson(Ljava/lang/String;)Lcom/exacttarget/etpushsdk/event/CloudPagesResponse;

    move-result-object v0

    return-object v0
.end method

.method public getMessages()Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/event/CloudPagesResponse;->messages:Ljava/util/ArrayList;

    return-object v0
.end method

.method public setDatabaseIds(Lcom/exacttarget/etpushsdk/event/CloudPagesResponse;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 105
    return-void
.end method

.method public bridge synthetic setDatabaseIds(Ljava/lang/Object;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 28
    check-cast p1, Lcom/exacttarget/etpushsdk/event/CloudPagesResponse;

    invoke-virtual {p0, p1, p2}, Lcom/exacttarget/etpushsdk/event/CloudPagesResponse;->setDatabaseIds(Lcom/exacttarget/etpushsdk/event/CloudPagesResponse;Ljava/util/List;)V

    return-void
.end method

.method public setMessages(Ljava/util/ArrayList;)V
    .locals 0

    .prologue
    .line 39
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/event/CloudPagesResponse;->messages:Ljava/util/ArrayList;

    .line 40
    return-void
.end method

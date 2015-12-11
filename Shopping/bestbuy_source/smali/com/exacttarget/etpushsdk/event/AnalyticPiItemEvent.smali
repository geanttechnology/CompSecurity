.class public Lcom/exacttarget/etpushsdk/event/AnalyticPiItemEvent;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/exacttarget/etpushsdk/event/IEventFactory;


# static fields
.field public static final JF_SESSION_ID:Ljava/lang/String; = "session_id"

.field public static final JF_USER_ID:Ljava/lang/String; = "user_id"

.field private static final TAG:Ljava/lang/String; = "~!AnalyticPiItemEvent"

.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private databaseIds:Ljava/util/List;

.field private sessionId:Ljava/lang/String;

.field private userId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public fromJson(Ljava/lang/String;)Lcom/exacttarget/etpushsdk/event/AnalyticPiItemEvent;
    .locals 3

    .prologue
    .line 69
    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 70
    const-string v1, "user_id"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/exacttarget/etpushsdk/event/AnalyticPiItemEvent;->setUserId(Ljava/lang/String;)V

    .line 71
    const-string v1, "session_id"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/exacttarget/etpushsdk/event/AnalyticPiItemEvent;->setSessionId(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 75
    :goto_0
    return-object p0

    .line 73
    :catch_0
    move-exception v0

    .line 74
    const-string v1, "~!AnalyticPiItemEvent"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 75
    const/4 p0, 0x0

    goto :goto_0
.end method

.method public bridge synthetic fromJson(Ljava/lang/String;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 25
    invoke-virtual {p0, p1}, Lcom/exacttarget/etpushsdk/event/AnalyticPiItemEvent;->fromJson(Ljava/lang/String;)Lcom/exacttarget/etpushsdk/event/AnalyticPiItemEvent;

    move-result-object v0

    return-object v0
.end method

.method public getDatabaseIds()Ljava/util/List;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/event/AnalyticPiItemEvent;->databaseIds:Ljava/util/List;

    return-object v0
.end method

.method public getSessionId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/event/AnalyticPiItemEvent;->sessionId:Ljava/lang/String;

    return-object v0
.end method

.method public getUserId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/event/AnalyticPiItemEvent;->userId:Ljava/lang/String;

    return-object v0
.end method

.method public setDatabaseIds(Lcom/exacttarget/etpushsdk/event/AnalyticPiItemEvent;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 81
    invoke-virtual {p1, p2}, Lcom/exacttarget/etpushsdk/event/AnalyticPiItemEvent;->setDatabaseIds(Ljava/util/List;)V

    .line 82
    return-void
.end method

.method public bridge synthetic setDatabaseIds(Ljava/lang/Object;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 25
    check-cast p1, Lcom/exacttarget/etpushsdk/event/AnalyticPiItemEvent;

    invoke-virtual {p0, p1, p2}, Lcom/exacttarget/etpushsdk/event/AnalyticPiItemEvent;->setDatabaseIds(Lcom/exacttarget/etpushsdk/event/AnalyticPiItemEvent;Ljava/util/List;)V

    return-void
.end method

.method public setDatabaseIds(Ljava/util/List;)V
    .locals 0

    .prologue
    .line 56
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/event/AnalyticPiItemEvent;->databaseIds:Ljava/util/List;

    .line 57
    return-void
.end method

.method public setSessionId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 48
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/event/AnalyticPiItemEvent;->sessionId:Ljava/lang/String;

    .line 49
    return-void
.end method

.method public setUserId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 40
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/event/AnalyticPiItemEvent;->userId:Ljava/lang/String;

    .line 41
    return-void
.end method

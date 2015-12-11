.class public Lcom/poshmark/data_model/models/ActiveUserInfo;
.super Ljava/lang/Object;
.source "ActiveUserInfo.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/data_model/models/ActiveUserInfo$PushNotificationInfo;,
        Lcom/poshmark/data_model/models/ActiveUserInfo$LocalNotificationInfo;,
        Lcom/poshmark/data_model/models/ActiveUserInfo$DeepLinkInfo;
    }
.end annotation


# instance fields
.field public deep_link:Lcom/poshmark/data_model/models/ActiveUserInfo$DeepLinkInfo;

.field public local_ntf:Lcom/poshmark/data_model/models/ActiveUserInfo$LocalNotificationInfo;

.field public push_ntf:Lcom/poshmark/data_model/models/ActiveUserInfo$PushNotificationInfo;

.field public type:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 10
    new-instance v0, Ljava/lang/String;

    invoke-direct {v0}, Ljava/lang/String;-><init>()V

    iput-object v0, p0, Lcom/poshmark/data_model/models/ActiveUserInfo;->type:Ljava/lang/String;

    .line 49
    return-void
.end method


# virtual methods
.method public addDeepLink(Ljava/lang/String;)V
    .locals 1
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 16
    new-instance v0, Lcom/poshmark/data_model/models/ActiveUserInfo$DeepLinkInfo;

    invoke-direct {v0, p0, p1}, Lcom/poshmark/data_model/models/ActiveUserInfo$DeepLinkInfo;-><init>(Lcom/poshmark/data_model/models/ActiveUserInfo;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/poshmark/data_model/models/ActiveUserInfo;->deep_link:Lcom/poshmark/data_model/models/ActiveUserInfo$DeepLinkInfo;

    .line 17
    return-void
.end method

.method public addLocalNotification(Ljava/lang/String;)V
    .locals 1
    .param p1, "eventId"    # Ljava/lang/String;

    .prologue
    .line 20
    new-instance v0, Lcom/poshmark/data_model/models/ActiveUserInfo$LocalNotificationInfo;

    invoke-direct {v0, p0, p1}, Lcom/poshmark/data_model/models/ActiveUserInfo$LocalNotificationInfo;-><init>(Lcom/poshmark/data_model/models/ActiveUserInfo;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/poshmark/data_model/models/ActiveUserInfo;->local_ntf:Lcom/poshmark/data_model/models/ActiveUserInfo$LocalNotificationInfo;

    .line 21
    return-void
.end method

.method public addPushNotification(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "pushMessage"    # Ljava/lang/String;
    .param p2, "badge"    # Ljava/lang/String;
    .param p3, "messageType"    # Ljava/lang/String;

    .prologue
    .line 24
    new-instance v0, Lcom/poshmark/data_model/models/ActiveUserInfo$PushNotificationInfo;

    invoke-direct {v0, p0, p1, p2, p3}, Lcom/poshmark/data_model/models/ActiveUserInfo$PushNotificationInfo;-><init>(Lcom/poshmark/data_model/models/ActiveUserInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/poshmark/data_model/models/ActiveUserInfo;->push_ntf:Lcom/poshmark/data_model/models/ActiveUserInfo$PushNotificationInfo;

    .line 25
    return-void
.end method

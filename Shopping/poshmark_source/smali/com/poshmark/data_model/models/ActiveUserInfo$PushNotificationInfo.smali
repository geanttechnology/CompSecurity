.class public Lcom/poshmark/data_model/models/ActiveUserInfo$PushNotificationInfo;
.super Ljava/lang/Object;
.source "ActiveUserInfo.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/models/ActiveUserInfo;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "PushNotificationInfo"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/data_model/models/ActiveUserInfo$PushNotificationInfo$PushPayload;
    }
.end annotation


# instance fields
.field aps:Lcom/poshmark/data_model/models/ActiveUserInfo$PushNotificationInfo$PushPayload;

.field final synthetic this$0:Lcom/poshmark/data_model/models/ActiveUserInfo;

.field type:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/poshmark/data_model/models/ActiveUserInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p2, "message"    # Ljava/lang/String;
    .param p3, "badge"    # Ljava/lang/String;
    .param p4, "messageType"    # Ljava/lang/String;

    .prologue
    .line 53
    iput-object p1, p0, Lcom/poshmark/data_model/models/ActiveUserInfo$PushNotificationInfo;->this$0:Lcom/poshmark/data_model/models/ActiveUserInfo;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 50
    new-instance v0, Lcom/poshmark/data_model/models/ActiveUserInfo$PushNotificationInfo$PushPayload;

    invoke-direct {v0, p0}, Lcom/poshmark/data_model/models/ActiveUserInfo$PushNotificationInfo$PushPayload;-><init>(Lcom/poshmark/data_model/models/ActiveUserInfo$PushNotificationInfo;)V

    iput-object v0, p0, Lcom/poshmark/data_model/models/ActiveUserInfo$PushNotificationInfo;->aps:Lcom/poshmark/data_model/models/ActiveUserInfo$PushNotificationInfo$PushPayload;

    .line 54
    if-eqz p2, :cond_0

    .line 55
    iget-object v0, p0, Lcom/poshmark/data_model/models/ActiveUserInfo$PushNotificationInfo;->aps:Lcom/poshmark/data_model/models/ActiveUserInfo$PushNotificationInfo$PushPayload;

    iput-object p2, v0, Lcom/poshmark/data_model/models/ActiveUserInfo$PushNotificationInfo$PushPayload;->alert:Ljava/lang/String;

    .line 58
    :cond_0
    if-eqz p3, :cond_1

    .line 59
    iget-object v0, p0, Lcom/poshmark/data_model/models/ActiveUserInfo$PushNotificationInfo;->aps:Lcom/poshmark/data_model/models/ActiveUserInfo$PushNotificationInfo$PushPayload;

    invoke-static {p3}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v1

    iput v1, v0, Lcom/poshmark/data_model/models/ActiveUserInfo$PushNotificationInfo$PushPayload;->badge:I

    .line 62
    :cond_1
    if-eqz p4, :cond_2

    .line 63
    iput-object p4, p0, Lcom/poshmark/data_model/models/ActiveUserInfo$PushNotificationInfo;->type:Ljava/lang/String;

    .line 65
    :cond_2
    return-void
.end method

.class Lcom/poshmark/data_model/models/ActiveUserInfo$PushNotificationInfo$PushPayload;
.super Ljava/lang/Object;
.source "ActiveUserInfo.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/models/ActiveUserInfo$PushNotificationInfo;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "PushPayload"
.end annotation


# instance fields
.field alert:Ljava/lang/String;

.field badge:I

.field final synthetic this$1:Lcom/poshmark/data_model/models/ActiveUserInfo$PushNotificationInfo;

.field type:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/poshmark/data_model/models/ActiveUserInfo$PushNotificationInfo;)V
    .locals 0

    .prologue
    .line 67
    iput-object p1, p0, Lcom/poshmark/data_model/models/ActiveUserInfo$PushNotificationInfo$PushPayload;->this$1:Lcom/poshmark/data_model/models/ActiveUserInfo$PushNotificationInfo;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

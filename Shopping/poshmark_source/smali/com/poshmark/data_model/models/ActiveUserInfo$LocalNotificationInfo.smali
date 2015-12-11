.class public Lcom/poshmark/data_model/models/ActiveUserInfo$LocalNotificationInfo;
.super Ljava/lang/Object;
.source "ActiveUserInfo.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/models/ActiveUserInfo;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "LocalNotificationInfo"
.end annotation


# instance fields
.field oi:Ljava/lang/String;

.field ot:Ljava/lang/String;

.field final synthetic this$0:Lcom/poshmark/data_model/models/ActiveUserInfo;

.field vb:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/poshmark/data_model/models/ActiveUserInfo;Ljava/lang/String;)V
    .locals 1
    .param p2, "eventId"    # Ljava/lang/String;

    .prologue
    .line 44
    iput-object p1, p0, Lcom/poshmark/data_model/models/ActiveUserInfo$LocalNotificationInfo;->this$0:Lcom/poshmark/data_model/models/ActiveUserInfo;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 40
    const-string v0, "rm"

    iput-object v0, p0, Lcom/poshmark/data_model/models/ActiveUserInfo$LocalNotificationInfo;->vb:Ljava/lang/String;

    .line 41
    new-instance v0, Ljava/lang/String;

    invoke-direct {v0}, Ljava/lang/String;-><init>()V

    iput-object v0, p0, Lcom/poshmark/data_model/models/ActiveUserInfo$LocalNotificationInfo;->oi:Ljava/lang/String;

    .line 42
    const-string v0, "ev"

    iput-object v0, p0, Lcom/poshmark/data_model/models/ActiveUserInfo$LocalNotificationInfo;->ot:Ljava/lang/String;

    .line 45
    iput-object p2, p0, Lcom/poshmark/data_model/models/ActiveUserInfo$LocalNotificationInfo;->oi:Ljava/lang/String;

    .line 46
    return-void
.end method

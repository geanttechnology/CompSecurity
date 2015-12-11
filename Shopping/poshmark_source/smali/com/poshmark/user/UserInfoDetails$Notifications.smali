.class Lcom/poshmark/user/UserInfoDetails$Notifications;
.super Ljava/lang/Object;
.source "UserInfoDetails.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/user/UserInfoDetails;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "Notifications"
.end annotation


# instance fields
.field comment:Z

.field event_invite:Z

.field event_reminder:Z

.field follow:Z

.field like:Z

.field final synthetic this$0:Lcom/poshmark/user/UserInfoDetails;


# direct methods
.method constructor <init>(Lcom/poshmark/user/UserInfoDetails;)V
    .locals 0

    .prologue
    .line 262
    iput-object p1, p0, Lcom/poshmark/user/UserInfoDetails$Notifications;->this$0:Lcom/poshmark/user/UserInfoDetails;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

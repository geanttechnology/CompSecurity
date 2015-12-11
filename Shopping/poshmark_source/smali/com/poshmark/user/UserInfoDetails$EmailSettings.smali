.class Lcom/poshmark/user/UserInfoDetails$EmailSettings;
.super Ljava/lang/Object;
.source "UserInfoDetails.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/user/UserInfoDetails;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "EmailSettings"
.end annotation


# instance fields
.field announcement:Z

.field comment:Z

.field event_invite:Z

.field follow:Z

.field like:Z

.field final synthetic this$0:Lcom/poshmark/user/UserInfoDetails;


# direct methods
.method constructor <init>(Lcom/poshmark/user/UserInfoDetails;)V
    .locals 0

    .prologue
    .line 270
    iput-object p1, p0, Lcom/poshmark/user/UserInfoDetails$EmailSettings;->this$0:Lcom/poshmark/user/UserInfoDetails;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

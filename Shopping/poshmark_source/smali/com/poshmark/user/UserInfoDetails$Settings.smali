.class public Lcom/poshmark/user/UserInfoDetails$Settings;
.super Ljava/lang/Object;
.source "UserInfoDetails.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/user/UserInfoDetails;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "Settings"
.end annotation


# instance fields
.field public email:Lcom/poshmark/user/UserInfoDetails$EmailSettings;

.field public notifications:Lcom/poshmark/user/UserInfoDetails$Notifications;

.field public search_visibility:Z

.field final synthetic this$0:Lcom/poshmark/user/UserInfoDetails;

.field public timeline:Z


# direct methods
.method public constructor <init>(Lcom/poshmark/user/UserInfoDetails;)V
    .locals 0

    .prologue
    .line 250
    iput-object p1, p0, Lcom/poshmark/user/UserInfoDetails$Settings;->this$0:Lcom/poshmark/user/UserInfoDetails;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

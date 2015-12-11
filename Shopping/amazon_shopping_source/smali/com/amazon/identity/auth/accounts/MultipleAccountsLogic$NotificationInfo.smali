.class Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$NotificationInfo;
.super Ljava/lang/Object;
.source "MultipleAccountsLogic.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "NotificationInfo"
.end annotation


# instance fields
.field public final action:Ljava/lang/String;

.field public final extras:Landroid/os/Bundle;

.field public final packageName:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "givenAction"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    .line 51
    invoke-direct {p0, p1, v0, v0}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$NotificationInfo;-><init>(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V

    .line 52
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V
    .locals 0
    .param p1, "givenAction"    # Ljava/lang/String;
    .param p2, "givenPackageName"    # Ljava/lang/String;
    .param p3, "givenExtras"    # Landroid/os/Bundle;

    .prologue
    .line 55
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 56
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$NotificationInfo;->action:Ljava/lang/String;

    .line 57
    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$NotificationInfo;->packageName:Ljava/lang/String;

    .line 58
    iput-object p3, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$NotificationInfo;->extras:Landroid/os/Bundle;

    .line 59
    return-void
.end method

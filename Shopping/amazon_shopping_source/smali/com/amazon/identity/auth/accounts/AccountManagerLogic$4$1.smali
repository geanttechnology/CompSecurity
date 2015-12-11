.class Lcom/amazon/identity/auth/accounts/AccountManagerLogic$4$1;
.super Ljava/lang/Object;
.source "AccountManagerLogic.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/accounts/AccountManagerLogic$4;->success(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/identity/auth/accounts/AccountManagerLogic$4;

.field final synthetic val$accountName:Ljava/lang/String;

.field final synthetic val$accountType:Ljava/lang/String;

.field final synthetic val$extras:Landroid/os/Bundle;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/accounts/AccountManagerLogic$4;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 772
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$4$1;->this$1:Lcom/amazon/identity/auth/accounts/AccountManagerLogic$4;

    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$4$1;->val$accountType:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$4$1;->val$accountName:Ljava/lang/String;

    iput-object p4, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$4$1;->val$extras:Landroid/os/Bundle;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 7

    .prologue
    .line 777
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$4$1;->this$1:Lcom/amazon/identity/auth/accounts/AccountManagerLogic$4;

    iget-object v0, v0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$4;->this$0:Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$4$1;->this$1:Lcom/amazon/identity/auth/accounts/AccountManagerLogic$4;

    iget-object v1, v1, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$4;->val$regType:Lcom/amazon/identity/auth/device/api/RegistrationType;

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$4$1;->this$1:Lcom/amazon/identity/auth/accounts/AccountManagerLogic$4;

    iget-object v2, v2, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$4;->val$regData:Landroid/os/Bundle;

    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$4$1;->this$1:Lcom/amazon/identity/auth/accounts/AccountManagerLogic$4;

    iget-object v3, v3, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$4;->val$callback:Lcom/amazon/identity/auth/device/api/Callback;

    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$4$1;->val$accountType:Ljava/lang/String;

    iget-object v5, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$4$1;->val$accountName:Ljava/lang/String;

    iget-object v6, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$4$1;->val$extras:Landroid/os/Bundle;

    invoke-static/range {v0 .. v6}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->access$500(Lcom/amazon/identity/auth/accounts/AccountManagerLogic;Lcom/amazon/identity/auth/device/api/RegistrationType;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V

    .line 778
    return-void
.end method

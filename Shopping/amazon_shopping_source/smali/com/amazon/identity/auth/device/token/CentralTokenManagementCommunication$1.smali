.class Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication$1;
.super Ljava/lang/Object;
.source "CentralTokenManagementCommunication.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;

.field final synthetic val$account:Landroid/accounts/Account;

.field final synthetic val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

.field final synthetic val$directedId:Ljava/lang/String;

.field final synthetic val$options:Landroid/os/Bundle;

.field final synthetic val$token:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;Ljava/lang/String;Landroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/callback/CallbackFuture;)V
    .locals 0

    .prologue
    .line 206
    iput-object p1, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication$1;->this$0:Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;

    iput-object p2, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication$1;->val$token:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication$1;->val$account:Landroid/accounts/Account;

    iput-object p4, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication$1;->val$directedId:Ljava/lang/String;

    iput-object p5, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication$1;->val$options:Landroid/os/Bundle;

    iput-object p6, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication$1;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 211
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication$1;->this$0:Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication$1;->val$token:Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication$1;->val$account:Landroid/accounts/Account;

    iget-object v3, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication$1;->val$directedId:Ljava/lang/String;

    iget-object v4, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication$1;->val$options:Landroid/os/Bundle;

    iget-object v5, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication$1;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-static/range {v0 .. v5}, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;->access$000(Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;Ljava/lang/String;Landroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/callback/CallbackFuture;)V

    .line 212
    return-void
.end method

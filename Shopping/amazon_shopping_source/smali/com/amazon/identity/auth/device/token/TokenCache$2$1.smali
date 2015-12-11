.class Lcom/amazon/identity/auth/device/token/TokenCache$2$1;
.super Ljava/lang/Object;
.source "TokenCache.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/device/token/TokenCache$2;->run(Landroid/accounts/AccountManagerFuture;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/identity/auth/device/token/TokenCache$2;

.field final synthetic val$future:Landroid/accounts/AccountManagerFuture;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/token/TokenCache$2;Landroid/accounts/AccountManagerFuture;)V
    .locals 0

    .prologue
    .line 484
    iput-object p1, p0, Lcom/amazon/identity/auth/device/token/TokenCache$2$1;->this$1:Lcom/amazon/identity/auth/device/token/TokenCache$2;

    iput-object p2, p0, Lcom/amazon/identity/auth/device/token/TokenCache$2$1;->val$future:Landroid/accounts/AccountManagerFuture;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 488
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenCache$2$1;->this$1:Lcom/amazon/identity/auth/device/token/TokenCache$2;

    iget-object v0, v0, Lcom/amazon/identity/auth/device/token/TokenCache$2;->val$callback:Landroid/accounts/AccountManagerCallback;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/TokenCache$2$1;->val$future:Landroid/accounts/AccountManagerFuture;

    invoke-interface {v0, v1}, Landroid/accounts/AccountManagerCallback;->run(Landroid/accounts/AccountManagerFuture;)V

    .line 489
    return-void
.end method

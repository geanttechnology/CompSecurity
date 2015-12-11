.class public abstract Lcom/amazon/identity/auth/device/framework/AccountManagerCallbackAdapter;
.super Ljava/lang/Object;
.source "AccountManagerCallbackAdapter.java"

# interfaces
.implements Landroid/accounts/AccountManagerCallback;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Landroid/accounts/AccountManagerCallback",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private final mCallback:Lcom/amazon/identity/auth/device/api/Callback;


# direct methods
.method public constructor <init>(Lcom/amazon/identity/auth/device/api/Callback;)V
    .locals 0
    .param p1, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;

    .prologue
    .line 20
    .local p0, "this":Lcom/amazon/identity/auth/device/framework/AccountManagerCallbackAdapter;, "Lcom/amazon/identity/auth/device/framework/AccountManagerCallbackAdapter<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    iput-object p1, p0, Lcom/amazon/identity/auth/device/framework/AccountManagerCallbackAdapter;->mCallback:Lcom/amazon/identity/auth/device/api/Callback;

    .line 22
    return-void
.end method


# virtual methods
.method protected abstract onResult(Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/Object;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/identity/auth/device/api/Callback;",
            "TT;)V"
        }
    .end annotation
.end method

.method public run(Landroid/accounts/AccountManagerFuture;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/accounts/AccountManagerFuture",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 27
    .local p0, "this":Lcom/amazon/identity/auth/device/framework/AccountManagerCallbackAdapter;, "Lcom/amazon/identity/auth/device/framework/AccountManagerCallbackAdapter<TT;>;"
    .local p1, "accountManFuture":Landroid/accounts/AccountManagerFuture;, "Landroid/accounts/AccountManagerFuture<TT;>;"
    :try_start_0
    invoke-interface {p1}, Landroid/accounts/AccountManagerFuture;->getResult()Ljava/lang/Object;

    move-result-object v2

    .line 32
    .local v2, "result":Ljava/lang/Object;, "TT;"
    iget-object v3, p0, Lcom/amazon/identity/auth/device/framework/AccountManagerCallbackAdapter;->mCallback:Lcom/amazon/identity/auth/device/api/Callback;

    invoke-virtual {p0, v3, v2}, Lcom/amazon/identity/auth/device/framework/AccountManagerCallbackAdapter;->onResult(Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Landroid/accounts/OperationCanceledException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Landroid/accounts/AuthenticatorException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_3

    .line 59
    .end local v2    # "result":Ljava/lang/Object;, "TT;"
    :goto_0
    return-void

    .line 35
    :catch_0
    move-exception v3

    invoke-virtual {v3}, Ljava/lang/IllegalArgumentException;->getMessage()Ljava/lang/String;

    move-result-object v1

    .line 40
    .local v1, "errorMessage":Ljava/lang/String;
    const/4 v0, 0x5

    .line 58
    .local v0, "accountManagerErrorCode":I
    :goto_1
    iget-object v3, p0, Lcom/amazon/identity/auth/device/framework/AccountManagerCallbackAdapter;->mCallback:Lcom/amazon/identity/auth/device/api/Callback;

    invoke-static {v3, v0, v1}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->onAccountManagerError(Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;)V

    goto :goto_0

    .line 42
    .end local v0    # "accountManagerErrorCode":I
    .end local v1    # "errorMessage":Ljava/lang/String;
    :catch_1
    move-exception v3

    invoke-virtual {v3}, Landroid/accounts/OperationCanceledException;->getMessage()Ljava/lang/String;

    move-result-object v1

    .line 45
    .restart local v1    # "errorMessage":Ljava/lang/String;
    const/4 v0, 0x4

    .line 56
    .restart local v0    # "accountManagerErrorCode":I
    goto :goto_1

    .line 47
    .end local v0    # "accountManagerErrorCode":I
    .end local v1    # "errorMessage":Ljava/lang/String;
    :catch_2
    move-exception v3

    invoke-virtual {v3}, Landroid/accounts/AuthenticatorException;->getMessage()Ljava/lang/String;

    move-result-object v1

    .line 50
    .restart local v1    # "errorMessage":Ljava/lang/String;
    const/4 v0, 0x5

    .line 56
    .restart local v0    # "accountManagerErrorCode":I
    goto :goto_1

    .line 52
    .end local v0    # "accountManagerErrorCode":I
    .end local v1    # "errorMessage":Ljava/lang/String;
    :catch_3
    move-exception v3

    invoke-virtual {v3}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v1

    .line 55
    .restart local v1    # "errorMessage":Ljava/lang/String;
    const/4 v0, 0x3

    .restart local v0    # "accountManagerErrorCode":I
    goto :goto_1
.end method

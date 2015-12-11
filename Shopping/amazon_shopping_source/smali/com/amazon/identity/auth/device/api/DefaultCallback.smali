.class public Lcom/amazon/identity/auth/device/api/DefaultCallback;
.super Ljava/lang/Object;
.source "DefaultCallback.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/api/Callback;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 28
    return-void
.end method

.method public onSuccess(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 20
    return-void
.end method

.class public interface abstract Lcom/amazon/identity/auth/device/AuthenticationWebViewClient$AuthenticationWebViewClientCallback;
.super Ljava/lang/Object;
.source "AuthenticationWebViewClient.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "AuthenticationWebViewClientCallback"
.end annotation


# virtual methods
.method public abstract onCodeEnterFinished()V
.end method

.method public abstract onPageFinished()V
.end method

.method public abstract onPageStarted(Ljava/lang/String;)V
.end method

.method public abstract setError(Landroid/os/Bundle;)V
.end method

.method public abstract setResult(Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;)V
.end method

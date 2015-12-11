.class public interface abstract Lcom/amazon/identity/auth/device/token/TokenCache$Listener;
.super Ljava/lang/Object;
.source "TokenCache.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/token/TokenCache;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "Listener"
.end annotation


# virtual methods
.method public abstract failure(Ljava/lang/String;ILjava/lang/String;)V
.end method

.method public abstract failure(Ljava/lang/String;Landroid/os/Bundle;)V
.end method

.method public abstract success()V
.end method

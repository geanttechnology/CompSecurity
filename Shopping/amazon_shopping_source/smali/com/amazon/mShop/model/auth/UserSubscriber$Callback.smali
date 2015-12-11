.class public interface abstract Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;
.super Ljava/lang/Object;
.source "UserSubscriber.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/model/auth/UserSubscriber;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "Callback"
.end annotation


# virtual methods
.method public abstract userCancelledSignIn()V
.end method

.method public abstract userSuccessfullySignedIn()V
.end method

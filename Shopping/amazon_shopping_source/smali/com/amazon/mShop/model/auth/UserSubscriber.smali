.class public interface abstract Lcom/amazon/mShop/model/auth/UserSubscriber;
.super Ljava/lang/Object;
.source "UserSubscriber.java"

# interfaces
.implements Lcom/amazon/mShop/control/GenericSubscriber;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;
    }
.end annotation


# virtual methods
.method public abstract onRequiresUserLogin(Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;)V
.end method

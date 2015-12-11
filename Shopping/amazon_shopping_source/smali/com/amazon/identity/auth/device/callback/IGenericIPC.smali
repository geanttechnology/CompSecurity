.class public interface abstract Lcom/amazon/identity/auth/device/callback/IGenericIPC;
.super Ljava/lang/Object;
.source "IGenericIPC.java"

# interfaces
.implements Landroid/os/IInterface;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/callback/IGenericIPC$Stub;
    }
.end annotation


# virtual methods
.method public abstract call(Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/callback/IRemoteCallback;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation
.end method

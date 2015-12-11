.class public interface abstract Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadedCallback;
.super Ljava/lang/Object;
.source "IVirtuosoDownloadedCallback.java"

# interfaces
.implements Landroid/os/IInterface;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadedCallback$Stub;
    }
.end annotation


# virtual methods
.method public abstract engineContentInDownloadedList(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;II)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation
.end method

.method public abstract engineDownloadedListChanged()V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation
.end method

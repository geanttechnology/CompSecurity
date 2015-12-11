.class public interface abstract Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback;
.super Ljava/lang/Object;
.source "IVirtuosoEngineCallback.java"

# interfaces
.implements Landroid/os/IInterface;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback$Stub;
    }
.end annotation


# virtual methods
.method public abstract collectionsChanged([Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation
.end method

.method public abstract collectionsDeleted([Ljava/lang/String;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation
.end method

.method public abstract downloadEngineStatusDidChange(Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation
.end method

.method public abstract engineContentInList(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;II)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation
.end method

.method public abstract engineListChanged()V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation
.end method

.method public abstract itemUpdated(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation
.end method

.method public abstract settingChanged(I)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation
.end method

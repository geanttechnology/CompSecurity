.class public interface abstract Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback;
.super Ljava/lang/Object;
.source "IVirtuosoDownloadQueueCallback.java"

# interfaces
.implements Landroid/os/IInterface;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback$Stub;
    }
.end annotation


# virtual methods
.method public abstract collectionsComplete([Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation
.end method

.method public abstract collectionsProgressUpdated([Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation
.end method

.method public abstract downloadEngineDidFinishDownloadingFile(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation
.end method

.method public abstract downloadEngineDidFinishDownloadingFileMin(Ljava/lang/String;IDDI)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation
.end method

.method public abstract downloadEngineDidStartDownloadingFile(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation
.end method

.method public abstract downloadEngineDidStartDownloadingFileMin(Ljava/lang/String;IDDI)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation
.end method

.method public abstract downloadEngineFileWithError(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation
.end method

.method public abstract downloadEngineFileWithErrorMin(Ljava/lang/String;IDDI)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation
.end method

.method public abstract downloadEngineProgressUpdatedForFile(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation
.end method

.method public abstract downloadEngineProgressUpdatedForFileMin(Ljava/lang/String;IDDI)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation
.end method

.method public abstract engineContentInQueuedList(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;II)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation
.end method

.method public abstract engineDownloadQueueChanged()V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation
.end method

.method public abstract fragmentComplete(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation
.end method

.method public abstract fragmentCompleteMin(Ljava/lang/String;IDDI)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation
.end method

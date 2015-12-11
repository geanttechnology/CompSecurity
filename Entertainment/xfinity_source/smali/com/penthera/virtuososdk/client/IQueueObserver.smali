.class public interface abstract Lcom/penthera/virtuososdk/client/IQueueObserver;
.super Ljava/lang/Object;
.source "IQueueObserver.java"


# virtual methods
.method public abstract downloadEngineDidFinishDownloadingFile(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
.end method

.method public abstract downloadEngineDidStartDownloadingFile(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
.end method

.method public abstract downloadEngineFileWithError(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
.end method

.method public abstract downloadEngineProgressUpdatedForFile(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
.end method

.method public abstract engineDownloadQueueChanged()V
.end method

.method public abstract fragmentComplete(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
.end method

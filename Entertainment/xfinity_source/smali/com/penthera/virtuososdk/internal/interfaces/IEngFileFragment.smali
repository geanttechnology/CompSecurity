.class public interface abstract Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;
.super Ljava/lang/Object;
.source "IEngFileFragment.java"

# interfaces
.implements Lcom/penthera/virtuososdk/client/IFileFragment;


# virtual methods
.method public abstract generateFilePath()V
.end method

.method public abstract markComplete()V
.end method

.method public abstract setCurrentSize(D)V
.end method

.method public abstract setDownloadStatus(Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;)V
.end method

.method public abstract setExpectedSize(D)V
.end method

.method public abstract setFilePath(Ljava/lang/String;)V
.end method

.method public abstract setPending(Z)V
.end method

.method public abstract update(Landroid/content/Context;)Z
.end method

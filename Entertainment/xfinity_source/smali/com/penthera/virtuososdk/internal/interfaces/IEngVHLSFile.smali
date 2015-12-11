.class public interface abstract Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;
.super Ljava/lang/Object;
.source "IEngVHLSFile.java"

# interfaces
.implements Lcom/penthera/virtuososdk/client/IVirtuosoHLSFile;
.implements Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;


# virtual methods
.method public abstract pendingFragments(Landroid/content/Context;)Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;",
            ">;"
        }
    .end annotation
.end method

.method public abstract regenerateFilePath(Landroid/content/ContentResolver;Ljava/lang/String;Landroid/content/Context;)V
.end method

.method public abstract setCompletedCount(I)V
.end method

.method public abstract setCurrentSize(D)V
.end method

.method public abstract setLocalBaseDir(Ljava/lang/String;)V
.end method

.method public abstract setPending(Z)V
.end method

.method public abstract updateFragment(Landroid/content/Context;Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;)Z
.end method

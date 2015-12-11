.class public interface abstract Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;
.super Ljava/lang/Object;
.source "IEngVFile.java"

# interfaces
.implements Lcom/penthera/virtuososdk/client/IVirtuosoFile;
.implements Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;


# virtual methods
.method public abstract isPending()Z
.end method

.method public abstract md5State()Lcom/penthera/virtuososdk/download/MD5State;
.end method

.method public abstract md5StateAsByteArray()[B
.end method

.method public abstract regenerateFilePath(Landroid/content/ContentResolver;Ljava/lang/String;Landroid/content/Context;)V
.end method

.method public abstract setCurrentSize(D)V
.end method

.method public abstract setErrorCount(J)V
.end method

.method public abstract setFilePath(Ljava/lang/String;)V
.end method

.method public abstract setMd5State(Lcom/penthera/virtuososdk/download/MD5State;)V
.end method

.method public abstract setPending(Z)V
.end method

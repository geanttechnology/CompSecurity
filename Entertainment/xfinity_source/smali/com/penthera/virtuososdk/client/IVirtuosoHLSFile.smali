.class public interface abstract Lcom/penthera/virtuososdk/client/IVirtuosoHLSFile;
.super Ljava/lang/Object;
.source "IVirtuosoHLSFile.java"

# interfaces
.implements Lcom/penthera/virtuososdk/client/IVirtuosoAsset;


# virtual methods
.method public abstract addFragments(Ljava/util/List;)I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)I"
        }
    .end annotation
.end method

.method public abstract expectedSize()D
.end method

.method public abstract fragments()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/penthera/virtuososdk/client/IFileFragment;",
            ">;"
        }
    .end annotation
.end method

.method public abstract isPending()Z
.end method

.method public abstract localBaseDir()Ljava/lang/String;
.end method

.method public abstract totalFragments()I
.end method

.method public abstract totalFragmentsComplete()I
.end method

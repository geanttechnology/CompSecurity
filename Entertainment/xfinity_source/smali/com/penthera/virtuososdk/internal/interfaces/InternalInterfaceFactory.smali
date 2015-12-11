.class public final Lcom/penthera/virtuososdk/internal/interfaces/InternalInterfaceFactory;
.super Lcom/penthera/virtuososdk/interfaces/toolkit/InterfaceFactory;
.source "InternalInterfaceFactory.java"


# direct methods
.method public static virtuosoHLSFile(Ljava/lang/String;Ljava/lang/String;)Lcom/penthera/virtuososdk/client/IVirtuosoHLSFile;
    .locals 1
    .param p0, "aAssetId"    # Ljava/lang/String;
    .param p1, "aMetaData"    # Ljava/lang/String;

    .prologue
    .line 28
    invoke-static {p0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/InterfaceFactory;->virtuosoHLSFile(Ljava/lang/String;Ljava/lang/String;)Lcom/penthera/virtuososdk/client/IVirtuosoHLSFile;

    move-result-object v0

    return-object v0
.end method

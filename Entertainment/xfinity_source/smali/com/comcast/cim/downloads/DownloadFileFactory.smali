.class public abstract Lcom/comcast/cim/downloads/DownloadFileFactory;
.super Ljava/lang/Object;
.source "DownloadFileFactory.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Lcom/comcast/cim/downloads/DownloadFile;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private final LOG:Lorg/slf4j/Logger;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 11
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadFileFactory;, "Lcom/comcast/cim/downloads/DownloadFileFactory<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 9
    const-class v0, Lcom/comcast/cim/downloads/DownloadFileFactory;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/downloads/DownloadFileFactory;->LOG:Lorg/slf4j/Logger;

    .line 12
    return-void
.end method


# virtual methods
.method public abstract create(Lcom/penthera/virtuososdk/client/IVirtuosoAsset;)Lcom/comcast/cim/downloads/DownloadFile;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/penthera/virtuososdk/client/IVirtuosoAsset;",
            ")TT;"
        }
    .end annotation
.end method

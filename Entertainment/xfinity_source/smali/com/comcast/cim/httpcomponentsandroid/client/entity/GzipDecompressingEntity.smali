.class public Lcom/comcast/cim/httpcomponentsandroid/client/entity/GzipDecompressingEntity;
.super Lcom/comcast/cim/httpcomponentsandroid/client/entity/DecompressingEntity;
.source "GzipDecompressingEntity.java"


# direct methods
.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;)V
    .locals 0
    .param p1, "entity"    # Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    .prologue
    .line 51
    invoke-direct {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/client/entity/DecompressingEntity;-><init>(Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;)V

    .line 52
    return-void
.end method


# virtual methods
.method public bridge synthetic getContent()Ljava/io/InputStream;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 41
    invoke-super {p0}, Lcom/comcast/cim/httpcomponentsandroid/client/entity/DecompressingEntity;->getContent()Ljava/io/InputStream;

    move-result-object v0

    return-object v0
.end method

.method public getContentEncoding()Lcom/comcast/cim/httpcomponentsandroid/Header;
    .locals 1

    .prologue
    .line 66
    const/4 v0, 0x0

    return-object v0
.end method

.method public getContentLength()J
    .locals 2

    .prologue
    .line 76
    const-wide/16 v0, -0x1

    return-wide v0
.end method

.method getDecompressingInputStream(Ljava/io/InputStream;)Ljava/io/InputStream;
    .locals 1
    .param p1, "wrapped"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 56
    new-instance v0, Ljava/util/zip/GZIPInputStream;

    invoke-direct {v0, p1}, Ljava/util/zip/GZIPInputStream;-><init>(Ljava/io/InputStream;)V

    return-object v0
.end method

.method public bridge synthetic writeTo(Ljava/io/OutputStream;)V
    .locals 0
    .param p1, "x0"    # Ljava/io/OutputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 41
    invoke-super {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/client/entity/DecompressingEntity;->writeTo(Ljava/io/OutputStream;)V

    return-void
.end method

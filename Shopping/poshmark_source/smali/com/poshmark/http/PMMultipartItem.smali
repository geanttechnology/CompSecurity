.class public Lcom/poshmark/http/PMMultipartItem;
.super Ljava/lang/Object;
.source "PMMultipartItem.java"


# instance fields
.field public data:[B

.field public fileName:Ljava/lang/String;

.field public mimeType:Ljava/lang/String;


# direct methods
.method public constructor <init>([BLjava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "data"    # [B
    .param p2, "mimeType"    # Ljava/lang/String;
    .param p3, "fileName"    # Ljava/lang/String;

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    iput-object p1, p0, Lcom/poshmark/http/PMMultipartItem;->data:[B

    .line 18
    iput-object p3, p0, Lcom/poshmark/http/PMMultipartItem;->fileName:Ljava/lang/String;

    .line 19
    iput-object p2, p0, Lcom/poshmark/http/PMMultipartItem;->mimeType:Ljava/lang/String;

    .line 20
    return-void
.end method

.method public static getMultipartJPGItem(Ljava/lang/String;)Lcom/poshmark/http/PMMultipartItem;
    .locals 4
    .param p0, "fileName"    # Ljava/lang/String;

    .prologue
    .line 24
    new-instance v0, Lcom/poshmark/http/PMMultipartItem;

    invoke-static {p0}, Lcom/poshmark/http/httpUtils/PMHttpUtils;->getJPGContents(Ljava/lang/String;)[B

    move-result-object v1

    const-string v2, "image/jpeg"

    const-string v3, "file.jpg"

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/PMMultipartItem;-><init>([BLjava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

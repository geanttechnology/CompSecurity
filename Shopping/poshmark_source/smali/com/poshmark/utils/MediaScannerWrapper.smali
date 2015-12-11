.class public Lcom/poshmark/utils/MediaScannerWrapper;
.super Ljava/lang/Object;
.source "MediaScannerWrapper.java"

# interfaces
.implements Landroid/media/MediaScannerConnection$MediaScannerConnectionClient;


# instance fields
.field private mConnection:Landroid/media/MediaScannerConnection;

.field private mMimeType:Ljava/lang/String;

.field private mPath:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "ctx"    # Landroid/content/Context;
    .param p2, "filePath"    # Ljava/lang/String;
    .param p3, "mime"    # Ljava/lang/String;

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    iput-object p2, p0, Lcom/poshmark/utils/MediaScannerWrapper;->mPath:Ljava/lang/String;

    .line 18
    iput-object p3, p0, Lcom/poshmark/utils/MediaScannerWrapper;->mMimeType:Ljava/lang/String;

    .line 19
    new-instance v0, Landroid/media/MediaScannerConnection;

    invoke-direct {v0, p1, p0}, Landroid/media/MediaScannerConnection;-><init>(Landroid/content/Context;Landroid/media/MediaScannerConnection$MediaScannerConnectionClient;)V

    iput-object v0, p0, Lcom/poshmark/utils/MediaScannerWrapper;->mConnection:Landroid/media/MediaScannerConnection;

    .line 20
    return-void
.end method


# virtual methods
.method public onMediaScannerConnected()V
    .locals 3

    .prologue
    .line 29
    iget-object v0, p0, Lcom/poshmark/utils/MediaScannerWrapper;->mConnection:Landroid/media/MediaScannerConnection;

    iget-object v1, p0, Lcom/poshmark/utils/MediaScannerWrapper;->mPath:Ljava/lang/String;

    iget-object v2, p0, Lcom/poshmark/utils/MediaScannerWrapper;->mMimeType:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/media/MediaScannerConnection;->scanFile(Ljava/lang/String;Ljava/lang/String;)V

    .line 31
    return-void
.end method

.method public onScanCompleted(Ljava/lang/String;Landroid/net/Uri;)V
    .locals 0
    .param p1, "path"    # Ljava/lang/String;
    .param p2, "uri"    # Landroid/net/Uri;

    .prologue
    .line 35
    return-void
.end method

.method public scan()V
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/poshmark/utils/MediaScannerWrapper;->mConnection:Landroid/media/MediaScannerConnection;

    invoke-virtual {v0}, Landroid/media/MediaScannerConnection;->connect()V

    .line 25
    return-void
.end method

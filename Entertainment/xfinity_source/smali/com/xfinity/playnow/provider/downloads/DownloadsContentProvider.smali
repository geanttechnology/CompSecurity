.class public Lcom/xfinity/playnow/provider/downloads/DownloadsContentProvider;
.super Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;
.source "DownloadsContentProvider.java"


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 9
    const-string v0, "com.xfinity.playnow.provider.downloads"

    invoke-static {v0}, Lcom/xfinity/playnow/provider/downloads/DownloadsContentProvider;->setAuthority(Ljava/lang/String;)V

    .line 10
    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 5
    invoke-direct {p0}, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;-><init>()V

    return-void
.end method


# virtual methods
.method protected getAuthority()Ljava/lang/String;
    .locals 1

    .prologue
    .line 13
    const-string v0, "com.xfinity.playnow.provider.downloads"

    return-object v0
.end method

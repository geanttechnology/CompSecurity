.class public Lcom/disney/datg/videoplatforms/sdk/cache/DiskCacheProperties;
.super Lcom/disney/datg/videoplatforms/sdk/cache/CacheProperties;
.source "DiskCacheProperties.java"


# static fields
.field public static DEFAULT_CLEAR_DISK_CACHE_ON_START:Z

.field public static DEFAULT_DISK_CACHE_DIR:Ljava/lang/String;

.field public static DEFAULT_INIT_DISK_CACHE_ON_CREATE:Z


# instance fields
.field public diskCacheDir:Ljava/io/File;

.field public diskCacheSize:I


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 17
    const-string v0, "default"

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskCacheProperties;->DEFAULT_DISK_CACHE_DIR:Ljava/lang/String;

    .line 22
    sput-boolean v1, Lcom/disney/datg/videoplatforms/sdk/cache/DiskCacheProperties;->DEFAULT_CLEAR_DISK_CACHE_ON_START:Z

    .line 24
    sput-boolean v1, Lcom/disney/datg/videoplatforms/sdk/cache/DiskCacheProperties;->DEFAULT_INIT_DISK_CACHE_ON_CREATE:Z

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 29
    invoke-direct {p0}, Lcom/disney/datg/videoplatforms/sdk/cache/CacheProperties;-><init>()V

    .line 27
    const/high16 v0, 0xa00000

    iput v0, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskCacheProperties;->diskCacheSize:I

    .line 30
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskCacheProperties;->DEFAULT_DISK_CACHE_DIR:Ljava/lang/String;

    invoke-static {p1, v0}, Lcom/disney/datg/videoplatforms/sdk/cache/DiskCache;->getDiskCacheDir(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;

    move-result-object v0

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskCacheProperties;->diskCacheDir:Ljava/io/File;

    .line 31
    return-void
.end method

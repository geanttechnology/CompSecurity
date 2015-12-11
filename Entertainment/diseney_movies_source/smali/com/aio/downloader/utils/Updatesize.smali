.class public Lcom/aio/downloader/utils/Updatesize;
.super Ljava/lang/Object;
.source "Updatesize.java"


# static fields
.field private static manager:Lcom/aio/downloader/utils/Updatesize;


# instance fields
.field public list_update:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 11
    new-instance v0, Lcom/aio/downloader/utils/Updatesize;

    invoke-direct {v0}, Lcom/aio/downloader/utils/Updatesize;-><init>()V

    sput-object v0, Lcom/aio/downloader/utils/Updatesize;->manager:Lcom/aio/downloader/utils/Updatesize;

    return-void
.end method

.method private constructor <init>()V
    .locals 1

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 9
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/utils/Updatesize;->list_update:Ljava/util/ArrayList;

    .line 14
    return-void
.end method

.method public static getUpdatesize()Lcom/aio/downloader/utils/Updatesize;
    .locals 1

    .prologue
    .line 17
    sget-object v0, Lcom/aio/downloader/utils/Updatesize;->manager:Lcom/aio/downloader/utils/Updatesize;

    return-object v0
.end method

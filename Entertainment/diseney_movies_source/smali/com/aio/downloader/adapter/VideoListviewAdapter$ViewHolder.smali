.class Lcom/aio/downloader/adapter/VideoListviewAdapter$ViewHolder;
.super Ljava/lang/Object;
.source "VideoListviewAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/adapter/VideoListviewAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "ViewHolder"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/adapter/VideoListviewAdapter;

.field tv_format:Landroid/widget/TextView;

.field tv_size:Landroid/widget/TextView;

.field tv_type:Landroid/widget/TextView;


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/VideoListviewAdapter;)V
    .locals 0

    .prologue
    .line 87
    iput-object p1, p0, Lcom/aio/downloader/adapter/VideoListviewAdapter$ViewHolder;->this$0:Lcom/aio/downloader/adapter/VideoListviewAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

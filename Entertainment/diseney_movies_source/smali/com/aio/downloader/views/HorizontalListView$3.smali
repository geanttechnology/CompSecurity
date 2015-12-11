.class Lcom/aio/downloader/views/HorizontalListView$3;
.super Ljava/lang/Object;
.source "HorizontalListView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/views/HorizontalListView;->onLayout(ZIIII)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/views/HorizontalListView;


# direct methods
.method constructor <init>(Lcom/aio/downloader/views/HorizontalListView;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/views/HorizontalListView$3;->this$0:Lcom/aio/downloader/views/HorizontalListView;

    .line 172
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 175
    iget-object v0, p0, Lcom/aio/downloader/views/HorizontalListView$3;->this$0:Lcom/aio/downloader/views/HorizontalListView;

    invoke-virtual {v0}, Lcom/aio/downloader/views/HorizontalListView;->requestLayout()V

    .line 176
    return-void
.end method

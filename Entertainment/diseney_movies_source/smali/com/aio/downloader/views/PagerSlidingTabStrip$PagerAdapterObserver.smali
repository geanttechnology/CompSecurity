.class Lcom/aio/downloader/views/PagerSlidingTabStrip$PagerAdapterObserver;
.super Landroid/database/DataSetObserver;
.source "PagerSlidingTabStrip.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/views/PagerSlidingTabStrip;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "PagerAdapterObserver"
.end annotation


# instance fields
.field private attached:Z

.field final synthetic this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;


# direct methods
.method private constructor <init>(Lcom/aio/downloader/views/PagerSlidingTabStrip;)V
    .locals 1

    .prologue
    .line 602
    iput-object p1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$PagerAdapterObserver;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    invoke-direct {p0}, Landroid/database/DataSetObserver;-><init>()V

    .line 604
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$PagerAdapterObserver;->attached:Z

    return-void
.end method

.method synthetic constructor <init>(Lcom/aio/downloader/views/PagerSlidingTabStrip;Lcom/aio/downloader/views/PagerSlidingTabStrip$PagerAdapterObserver;)V
    .locals 0

    .prologue
    .line 602
    invoke-direct {p0, p1}, Lcom/aio/downloader/views/PagerSlidingTabStrip$PagerAdapterObserver;-><init>(Lcom/aio/downloader/views/PagerSlidingTabStrip;)V

    return-void
.end method


# virtual methods
.method public isAttached()Z
    .locals 1

    .prologue
    .line 616
    iget-boolean v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$PagerAdapterObserver;->attached:Z

    return v0
.end method

.method public onChanged()V
    .locals 1

    .prologue
    .line 608
    iget-object v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$PagerAdapterObserver;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    invoke-virtual {v0}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->notifyDataSetChanged()V

    .line 609
    return-void
.end method

.method public setAttached(Z)V
    .locals 0
    .param p1, "attached"    # Z

    .prologue
    .line 612
    iput-boolean p1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$PagerAdapterObserver;->attached:Z

    .line 613
    return-void
.end method

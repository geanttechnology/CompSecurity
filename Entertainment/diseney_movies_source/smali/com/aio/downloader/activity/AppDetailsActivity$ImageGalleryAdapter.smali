.class Lcom/aio/downloader/activity/AppDetailsActivity$ImageGalleryAdapter;
.super Landroid/widget/BaseAdapter;
.source "AppDetailsActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/AppDetailsActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ImageGalleryAdapter"
.end annotation


# instance fields
.field private ctx:Landroid/content/Context;

.field private image:Landroid/widget/ImageView;

.field final synthetic this$0:Lcom/aio/downloader/activity/AppDetailsActivity;


# direct methods
.method public constructor <init>(Lcom/aio/downloader/activity/AppDetailsActivity;Landroid/content/Context;)V
    .locals 0
    .param p2, "ctx"    # Landroid/content/Context;

    .prologue
    .line 1778
    iput-object p1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$ImageGalleryAdapter;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 1779
    iput-object p2, p0, Lcom/aio/downloader/activity/AppDetailsActivity$ImageGalleryAdapter;->ctx:Landroid/content/Context;

    .line 1780
    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 1784
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$ImageGalleryAdapter;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->list:Ljava/util/ArrayList;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$24(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 1789
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 1794
    int-to-long v0, p1

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 3
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 1801
    if-nez p2, :cond_0

    .line 1802
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$ImageGalleryAdapter;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$ImageGalleryAdapter;->ctx:Landroid/content/Context;

    invoke-static {v1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$61(Lcom/aio/downloader/activity/AppDetailsActivity;Landroid/view/LayoutInflater;)V

    .line 1803
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$ImageGalleryAdapter;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->inflate:Landroid/view/LayoutInflater;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$62(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/view/LayoutInflater;

    move-result-object v0

    .line 1804
    const v1, 0x7f03005f

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 1805
    const v0, 0x7f070245

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$ImageGalleryAdapter;->image:Landroid/widget/ImageView;

    .line 1807
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$ImageGalleryAdapter;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->app:Lcom/aio/downloader/mydownload/MyApplcation;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$42(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/MyApplcation;

    move-result-object v1

    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$ImageGalleryAdapter;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->list:Ljava/util/ArrayList;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$24(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getScreenshots()Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity$ImageGalleryAdapter;->image:Landroid/widget/ImageView;

    invoke-virtual {v1, v0, v2}, Lcom/aio/downloader/mydownload/MyApplcation;->asyncLoadImage1(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 1809
    return-object p2
.end method

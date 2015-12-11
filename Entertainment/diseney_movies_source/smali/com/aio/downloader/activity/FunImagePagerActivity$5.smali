.class Lcom/aio/downloader/activity/FunImagePagerActivity$5;
.super Ljava/lang/Object;
.source "FunImagePagerActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/FunImagePagerActivity;->onPageSelected(I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

.field private final synthetic val$arg0:I


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/FunImagePagerActivity;I)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$5;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    iput p2, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$5;->val$arg0:I

    .line 432
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 440
    iget-object v1, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$5;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$5;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    # getter for: Lcom/aio/downloader/activity/FunImagePagerActivity;->list:Ljava/util/ArrayList;
    invoke-static {v0}, Lcom/aio/downloader/activity/FunImagePagerActivity;->access$14(Lcom/aio/downloader/activity/FunImagePagerActivity;)Ljava/util/ArrayList;

    move-result-object v0

    iget v2, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$5;->val$arg0:I

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    # invokes: Lcom/aio/downloader/activity/FunImagePagerActivity;->getImage(Ljava/lang/String;)V
    invoke-static {v1, v0}, Lcom/aio/downloader/activity/FunImagePagerActivity;->access$15(Lcom/aio/downloader/activity/FunImagePagerActivity;Ljava/lang/String;)V

    .line 442
    return-void
.end method

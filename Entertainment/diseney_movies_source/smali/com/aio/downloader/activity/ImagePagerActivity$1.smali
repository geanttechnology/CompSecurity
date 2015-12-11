.class Lcom/aio/downloader/activity/ImagePagerActivity$1;
.super Ljava/lang/Object;
.source "ImagePagerActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/ImagePagerActivity;->init()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/ImagePagerActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/ImagePagerActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/ImagePagerActivity$1;->this$0:Lcom/aio/downloader/activity/ImagePagerActivity;

    .line 51
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 56
    iget-object v0, p0, Lcom/aio/downloader/activity/ImagePagerActivity$1;->this$0:Lcom/aio/downloader/activity/ImagePagerActivity;

    invoke-virtual {v0}, Lcom/aio/downloader/activity/ImagePagerActivity;->finish()V

    .line 57
    return-void
.end method

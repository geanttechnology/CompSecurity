.class Lcom/aio/downloader/activity/AcquireWebview$1;
.super Ljava/lang/Object;
.source "AcquireWebview.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/AcquireWebview;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/AcquireWebview;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/AcquireWebview;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/AcquireWebview$1;->this$0:Lcom/aio/downloader/activity/AcquireWebview;

    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/aio/downloader/activity/AcquireWebview$1;->this$0:Lcom/aio/downloader/activity/AcquireWebview;

    invoke-virtual {v0}, Lcom/aio/downloader/activity/AcquireWebview;->finish()V

    .line 39
    return-void
.end method

.class Lcom/aio/downloader/activity/ChapingActivity$1;
.super Ljava/lang/Object;
.source "ChapingActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/ChapingActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/ChapingActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/ChapingActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/ChapingActivity$1;->this$0:Lcom/aio/downloader/activity/ChapingActivity;

    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 30
    iget-object v0, p0, Lcom/aio/downloader/activity/ChapingActivity$1;->this$0:Lcom/aio/downloader/activity/ChapingActivity;

    invoke-virtual {v0}, Lcom/aio/downloader/activity/ChapingActivity;->finish()V

    .line 31
    return-void
.end method

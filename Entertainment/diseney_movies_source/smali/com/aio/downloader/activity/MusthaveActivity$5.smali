.class Lcom/aio/downloader/activity/MusthaveActivity$5;
.super Ljava/lang/Object;
.source "MusthaveActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/MusthaveActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/MusthaveActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MusthaveActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MusthaveActivity$5;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    .line 402
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 407
    iget-object v0, p0, Lcom/aio/downloader/activity/MusthaveActivity$5;->this$0:Lcom/aio/downloader/activity/MusthaveActivity;

    invoke-virtual {v0}, Lcom/aio/downloader/activity/MusthaveActivity;->finish()V

    .line 408
    return-void
.end method

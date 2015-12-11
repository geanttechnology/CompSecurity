.class Lcom/aio/downloader/activity/AppDetatils_moreActivity$1;
.super Ljava/lang/Object;
.source "AppDetatils_moreActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/AppDetatils_moreActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/AppDetatils_moreActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/AppDetatils_moreActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/AppDetatils_moreActivity$1;->this$0:Lcom/aio/downloader/activity/AppDetatils_moreActivity;

    .line 62
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 67
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetatils_moreActivity$1;->this$0:Lcom/aio/downloader/activity/AppDetatils_moreActivity;

    invoke-virtual {v0}, Lcom/aio/downloader/activity/AppDetatils_moreActivity;->finish()V

    .line 68
    return-void
.end method

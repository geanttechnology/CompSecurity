.class Lcom/aio/downloader/activity/AppDetailsActivity$9$1;
.super Landroid/os/AsyncTask;
.source "AppDetailsActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/AppDetailsActivity$9;->onReceive(Landroid/content/Context;Landroid/content/Intent;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/activity/AppDetailsActivity$9;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/AppDetailsActivity$9;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$9$1;->this$1:Lcom/aio/downloader/activity/AppDetailsActivity$9;

    .line 244
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/AppDetailsActivity$9$1;->doInBackground([Ljava/lang/Void;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/String;
    .locals 2
    .param p1, "arg0"    # [Ljava/lang/Void;

    .prologue
    .line 247
    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$9$1;->this$1:Lcom/aio/downloader/activity/AppDetailsActivity$9;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity$9;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity$9;->access$0(Lcom/aio/downloader/activity/AppDetailsActivity$9;)Lcom/aio/downloader/activity/AppDetailsActivity;

    move-result-object v1

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->ds:Ljava/util/List;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$12(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v0

    .line 248
    .local v0, "number":I
    invoke-static {v0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/AppDetailsActivity$9$1;->onPostExecute(Ljava/lang/String;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/String;)V
    .locals 2
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    .line 253
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 254
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$9$1;->this$1:Lcom/aio/downloader/activity/AppDetailsActivity$9;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity$9;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity$9;->access$0(Lcom/aio/downloader/activity/AppDetailsActivity$9;)Lcom/aio/downloader/activity/AppDetailsActivity;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->mAnimImageView:Landroid/widget/ImageView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$13(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/ImageView;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 255
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$9$1;->this$1:Lcom/aio/downloader/activity/AppDetailsActivity$9;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity$9;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity$9;->access$0(Lcom/aio/downloader/activity/AppDetailsActivity$9;)Lcom/aio/downloader/activity/AppDetailsActivity;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->mAnimImageView:Landroid/widget/ImageView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$13(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/ImageView;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$9$1;->this$1:Lcom/aio/downloader/activity/AppDetailsActivity$9;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity$9;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity$9;->access$0(Lcom/aio/downloader/activity/AppDetailsActivity$9;)Lcom/aio/downloader/activity/AppDetailsActivity;

    move-result-object v1

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->mAnimation:Landroid/view/animation/Animation;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$14(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/view/animation/Animation;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 256
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$9$1;->this$1:Lcom/aio/downloader/activity/AppDetailsActivity$9;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity$9;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity$9;->access$0(Lcom/aio/downloader/activity/AppDetailsActivity$9;)Lcom/aio/downloader/activity/AppDetailsActivity;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->badgedownimg:Lcom/aio/downloader/views/BadgeView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$15(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/views/BadgeView;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/aio/downloader/views/BadgeView;->setText(Ljava/lang/CharSequence;)V

    .line 257
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$9$1;->this$1:Lcom/aio/downloader/activity/AppDetailsActivity$9;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity$9;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity$9;->access$0(Lcom/aio/downloader/activity/AppDetailsActivity$9;)Lcom/aio/downloader/activity/AppDetailsActivity;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->badgedownimg:Lcom/aio/downloader/views/BadgeView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$15(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/views/BadgeView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/aio/downloader/views/BadgeView;->show()V

    .line 258
    return-void
.end method

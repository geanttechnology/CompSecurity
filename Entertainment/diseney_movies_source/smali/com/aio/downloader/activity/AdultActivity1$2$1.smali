.class Lcom/aio/downloader/activity/AdultActivity1$2$1;
.super Landroid/os/AsyncTask;
.source "AdultActivity1.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/AdultActivity1$2;->onReceive(Landroid/content/Context;Landroid/content/Intent;)V
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
.field final synthetic this$1:Lcom/aio/downloader/activity/AdultActivity1$2;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/AdultActivity1$2;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/AdultActivity1$2$1;->this$1:Lcom/aio/downloader/activity/AdultActivity1$2;

    .line 158
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/AdultActivity1$2$1;->doInBackground([Ljava/lang/Void;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/String;
    .locals 2
    .param p1, "arg0"    # [Ljava/lang/Void;

    .prologue
    .line 162
    iget-object v1, p0, Lcom/aio/downloader/activity/AdultActivity1$2$1;->this$1:Lcom/aio/downloader/activity/AdultActivity1$2;

    # getter for: Lcom/aio/downloader/activity/AdultActivity1$2;->this$0:Lcom/aio/downloader/activity/AdultActivity1;
    invoke-static {v1}, Lcom/aio/downloader/activity/AdultActivity1$2;->access$0(Lcom/aio/downloader/activity/AdultActivity1$2;)Lcom/aio/downloader/activity/AdultActivity1;

    move-result-object v1

    # getter for: Lcom/aio/downloader/activity/AdultActivity1;->ds:Ljava/util/List;
    invoke-static {v1}, Lcom/aio/downloader/activity/AdultActivity1;->access$4(Lcom/aio/downloader/activity/AdultActivity1;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v0

    .line 164
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

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/AdultActivity1$2$1;->onPostExecute(Ljava/lang/String;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/String;)V
    .locals 2
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    .line 170
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 171
    iget-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1$2$1;->this$1:Lcom/aio/downloader/activity/AdultActivity1$2;

    # getter for: Lcom/aio/downloader/activity/AdultActivity1$2;->this$0:Lcom/aio/downloader/activity/AdultActivity1;
    invoke-static {v0}, Lcom/aio/downloader/activity/AdultActivity1$2;->access$0(Lcom/aio/downloader/activity/AdultActivity1$2;)Lcom/aio/downloader/activity/AdultActivity1;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/AdultActivity1;->mAnimImageView:Landroid/widget/ImageView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AdultActivity1;->access$5(Lcom/aio/downloader/activity/AdultActivity1;)Landroid/widget/ImageView;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 172
    iget-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1$2$1;->this$1:Lcom/aio/downloader/activity/AdultActivity1$2;

    # getter for: Lcom/aio/downloader/activity/AdultActivity1$2;->this$0:Lcom/aio/downloader/activity/AdultActivity1;
    invoke-static {v0}, Lcom/aio/downloader/activity/AdultActivity1$2;->access$0(Lcom/aio/downloader/activity/AdultActivity1$2;)Lcom/aio/downloader/activity/AdultActivity1;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/AdultActivity1;->mAnimImageView:Landroid/widget/ImageView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AdultActivity1;->access$5(Lcom/aio/downloader/activity/AdultActivity1;)Landroid/widget/ImageView;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/activity/AdultActivity1$2$1;->this$1:Lcom/aio/downloader/activity/AdultActivity1$2;

    # getter for: Lcom/aio/downloader/activity/AdultActivity1$2;->this$0:Lcom/aio/downloader/activity/AdultActivity1;
    invoke-static {v1}, Lcom/aio/downloader/activity/AdultActivity1$2;->access$0(Lcom/aio/downloader/activity/AdultActivity1$2;)Lcom/aio/downloader/activity/AdultActivity1;

    move-result-object v1

    # getter for: Lcom/aio/downloader/activity/AdultActivity1;->mAnimation:Landroid/view/animation/Animation;
    invoke-static {v1}, Lcom/aio/downloader/activity/AdultActivity1;->access$6(Lcom/aio/downloader/activity/AdultActivity1;)Landroid/view/animation/Animation;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 173
    iget-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1$2$1;->this$1:Lcom/aio/downloader/activity/AdultActivity1$2;

    # getter for: Lcom/aio/downloader/activity/AdultActivity1$2;->this$0:Lcom/aio/downloader/activity/AdultActivity1;
    invoke-static {v0}, Lcom/aio/downloader/activity/AdultActivity1$2;->access$0(Lcom/aio/downloader/activity/AdultActivity1$2;)Lcom/aio/downloader/activity/AdultActivity1;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/AdultActivity1;->badgedownimg:Lcom/aio/downloader/views/BadgeView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AdultActivity1;->access$7(Lcom/aio/downloader/activity/AdultActivity1;)Lcom/aio/downloader/views/BadgeView;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/aio/downloader/views/BadgeView;->setText(Ljava/lang/CharSequence;)V

    .line 174
    iget-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1$2$1;->this$1:Lcom/aio/downloader/activity/AdultActivity1$2;

    # getter for: Lcom/aio/downloader/activity/AdultActivity1$2;->this$0:Lcom/aio/downloader/activity/AdultActivity1;
    invoke-static {v0}, Lcom/aio/downloader/activity/AdultActivity1$2;->access$0(Lcom/aio/downloader/activity/AdultActivity1$2;)Lcom/aio/downloader/activity/AdultActivity1;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/AdultActivity1;->badgedownimg:Lcom/aio/downloader/views/BadgeView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AdultActivity1;->access$7(Lcom/aio/downloader/activity/AdultActivity1;)Lcom/aio/downloader/views/BadgeView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/aio/downloader/views/BadgeView;->show()V

    .line 176
    return-void
.end method

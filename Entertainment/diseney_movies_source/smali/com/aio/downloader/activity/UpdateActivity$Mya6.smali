.class Lcom/aio/downloader/activity/UpdateActivity$Mya6;
.super Landroid/os/AsyncTask;
.source "UpdateActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/UpdateActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "Mya6"
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
.field final synthetic this$0:Lcom/aio/downloader/activity/UpdateActivity;

.field private url1:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/UpdateActivity;)V
    .locals 0

    .prologue
    .line 274
    iput-object p1, p0, Lcom/aio/downloader/activity/UpdateActivity$Mya6;->this$0:Lcom/aio/downloader/activity/UpdateActivity;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method

.method private ShowResult7(Ljava/lang/String;)V
    .locals 4
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    .line 303
    iget-object v1, p0, Lcom/aio/downloader/activity/UpdateActivity$Mya6;->this$0:Lcom/aio/downloader/activity/UpdateActivity;

    # getter for: Lcom/aio/downloader/activity/UpdateActivity;->progress_wheel:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v1}, Lcom/aio/downloader/activity/UpdateActivity;->access$0(Lcom/aio/downloader/activity/UpdateActivity;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v1

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 304
    iget-object v1, p0, Lcom/aio/downloader/activity/UpdateActivity$Mya6;->this$0:Lcom/aio/downloader/activity/UpdateActivity;

    iget-object v1, v1, Lcom/aio/downloader/activity/UpdateActivity;->list_update:Ljava/util/ArrayList;

    invoke-static {p1}, Lcom/aio/downloader/utils/Myutils;->parseupdata(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 305
    sget v1, Lcom/aio/downloader/utils/Myutils;->status:I

    const/4 v2, 0x1

    if-ne v1, v2, :cond_0

    .line 306
    const-string v1, "update"

    new-instance v2, Ljava/lang/StringBuilder;

    iget-object v3, p0, Lcom/aio/downloader/activity/UpdateActivity$Mya6;->this$0:Lcom/aio/downloader/activity/UpdateActivity;

    iget-object v3, v3, Lcom/aio/downloader/activity/UpdateActivity;->list_update:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 307
    new-instance v0, Lcom/aio/downloader/adapter/UndateAdapter;

    .line 308
    iget-object v1, p0, Lcom/aio/downloader/activity/UpdateActivity$Mya6;->this$0:Lcom/aio/downloader/activity/UpdateActivity;

    invoke-virtual {v1}, Lcom/aio/downloader/activity/UpdateActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/aio/downloader/activity/UpdateActivity$Mya6;->this$0:Lcom/aio/downloader/activity/UpdateActivity;

    iget-object v2, v2, Lcom/aio/downloader/activity/UpdateActivity;->list_update:Ljava/util/ArrayList;

    .line 307
    invoke-direct {v0, v1, v2}, Lcom/aio/downloader/adapter/UndateAdapter;-><init>(Landroid/content/Context;Ljava/util/ArrayList;)V

    .line 309
    .local v0, "adapter":Lcom/aio/downloader/adapter/UndateAdapter;
    iget-object v1, p0, Lcom/aio/downloader/activity/UpdateActivity$Mya6;->this$0:Lcom/aio/downloader/activity/UpdateActivity;

    # getter for: Lcom/aio/downloader/activity/UpdateActivity;->lv_uninstall:Landroid/widget/ListView;
    invoke-static {v1}, Lcom/aio/downloader/activity/UpdateActivity;->access$2(Lcom/aio/downloader/activity/UpdateActivity;)Landroid/widget/ListView;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 317
    .end local v0    # "adapter":Lcom/aio/downloader/adapter/UndateAdapter;
    :goto_0
    return-void

    .line 311
    :cond_0
    iget-object v1, p0, Lcom/aio/downloader/activity/UpdateActivity$Mya6;->this$0:Lcom/aio/downloader/activity/UpdateActivity;

    # getter for: Lcom/aio/downloader/activity/UpdateActivity;->ll_downnull:Landroid/widget/LinearLayout;
    invoke-static {v1}, Lcom/aio/downloader/activity/UpdateActivity;->access$3(Lcom/aio/downloader/activity/UpdateActivity;)Landroid/widget/LinearLayout;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 312
    iget-object v1, p0, Lcom/aio/downloader/activity/UpdateActivity$Mya6;->this$0:Lcom/aio/downloader/activity/UpdateActivity;

    # getter for: Lcom/aio/downloader/activity/UpdateActivity;->iv_ioio:Landroid/widget/ImageView;
    invoke-static {v1}, Lcom/aio/downloader/activity/UpdateActivity;->access$4(Lcom/aio/downloader/activity/UpdateActivity;)Landroid/widget/ImageView;

    move-result-object v1

    const v2, 0x7f040006

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 313
    iget-object v2, p0, Lcom/aio/downloader/activity/UpdateActivity$Mya6;->this$0:Lcom/aio/downloader/activity/UpdateActivity;

    iget-object v1, p0, Lcom/aio/downloader/activity/UpdateActivity$Mya6;->this$0:Lcom/aio/downloader/activity/UpdateActivity;

    # getter for: Lcom/aio/downloader/activity/UpdateActivity;->iv_ioio:Landroid/widget/ImageView;
    invoke-static {v1}, Lcom/aio/downloader/activity/UpdateActivity;->access$4(Lcom/aio/downloader/activity/UpdateActivity;)Landroid/widget/ImageView;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/ImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v1

    check-cast v1, Landroid/graphics/drawable/AnimationDrawable;

    invoke-static {v2, v1}, Lcom/aio/downloader/activity/UpdateActivity;->access$5(Lcom/aio/downloader/activity/UpdateActivity;Landroid/graphics/drawable/AnimationDrawable;)V

    .line 314
    iget-object v1, p0, Lcom/aio/downloader/activity/UpdateActivity$Mya6;->this$0:Lcom/aio/downloader/activity/UpdateActivity;

    # getter for: Lcom/aio/downloader/activity/UpdateActivity;->animationDrawable:Landroid/graphics/drawable/AnimationDrawable;
    invoke-static {v1}, Lcom/aio/downloader/activity/UpdateActivity;->access$6(Lcom/aio/downloader/activity/UpdateActivity;)Landroid/graphics/drawable/AnimationDrawable;

    move-result-object v1

    invoke-virtual {v1}, Landroid/graphics/drawable/AnimationDrawable;->start()V

    goto :goto_0
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/UpdateActivity$Mya6;->doInBackground([Ljava/lang/Void;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/String;
    .locals 4
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    .line 286
    const-string v1, "update"

    new-instance v2, Ljava/lang/StringBuilder;

    iget-object v3, p0, Lcom/aio/downloader/activity/UpdateActivity$Mya6;->this$0:Lcom/aio/downloader/activity/UpdateActivity;

    # getter for: Lcom/aio/downloader/activity/UpdateActivity;->upJsonStr:Ljava/lang/String;
    invoke-static {v3}, Lcom/aio/downloader/activity/UpdateActivity;->access$1(Lcom/aio/downloader/activity/UpdateActivity;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, "==="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 287
    iget-object v1, p0, Lcom/aio/downloader/activity/UpdateActivity$Mya6;->this$0:Lcom/aio/downloader/activity/UpdateActivity;

    # getter for: Lcom/aio/downloader/activity/UpdateActivity;->upJsonStr:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/activity/UpdateActivity;->access$1(Lcom/aio/downloader/activity/UpdateActivity;)Ljava/lang/String;

    move-result-object v0

    .line 288
    .local v0, "jsonData":Ljava/lang/String;
    return-object v0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/UpdateActivity$Mya6;->onPostExecute(Ljava/lang/String;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/String;)V
    .locals 3
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    .line 293
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 294
    if-nez p1, :cond_0

    .line 299
    :goto_0
    return-void

    .line 297
    :cond_0
    const-string v0, "update"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "result="

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 298
    invoke-direct {p0, p1}, Lcom/aio/downloader/activity/UpdateActivity$Mya6;->ShowResult7(Ljava/lang/String;)V

    goto :goto_0
.end method

.method protected onPreExecute()V
    .locals 2

    .prologue
    .line 279
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 280
    iget-object v0, p0, Lcom/aio/downloader/activity/UpdateActivity$Mya6;->this$0:Lcom/aio/downloader/activity/UpdateActivity;

    # getter for: Lcom/aio/downloader/activity/UpdateActivity;->progress_wheel:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/activity/UpdateActivity;->access$0(Lcom/aio/downloader/activity/UpdateActivity;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 281
    return-void
.end method

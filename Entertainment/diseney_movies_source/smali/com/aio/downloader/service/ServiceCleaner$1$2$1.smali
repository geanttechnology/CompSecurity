.class Lcom/aio/downloader/service/ServiceCleaner$1$2$1;
.super Landroid/os/AsyncTask;
.source "ServiceCleaner.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/service/ServiceCleaner$1$2;->onClick(Landroid/view/View;)V
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
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$2:Lcom/aio/downloader/service/ServiceCleaner$1$2;


# direct methods
.method constructor <init>(Lcom/aio/downloader/service/ServiceCleaner$1$2;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceCleaner$1$2$1;->this$2:Lcom/aio/downloader/service/ServiceCleaner$1$2;

    .line 190
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/service/ServiceCleaner$1$2$1;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 3
    .param p1, "arg0"    # [Ljava/lang/Void;

    .prologue
    .line 199
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceCleaner$1$2$1;->this$2:Lcom/aio/downloader/service/ServiceCleaner$1$2;

    # getter for: Lcom/aio/downloader/service/ServiceCleaner$1$2;->this$1:Lcom/aio/downloader/service/ServiceCleaner$1;
    invoke-static {v0}, Lcom/aio/downloader/service/ServiceCleaner$1$2;->access$0(Lcom/aio/downloader/service/ServiceCleaner$1$2;)Lcom/aio/downloader/service/ServiceCleaner$1;

    move-result-object v0

    # getter for: Lcom/aio/downloader/service/ServiceCleaner$1;->this$0:Lcom/aio/downloader/service/ServiceCleaner;
    invoke-static {v0}, Lcom/aio/downloader/service/ServiceCleaner$1;->access$1(Lcom/aio/downloader/service/ServiceCleaner$1;)Lcom/aio/downloader/service/ServiceCleaner;

    move-result-object v0

    # getter for: Lcom/aio/downloader/service/ServiceCleaner;->AIOCALLERDOWN:Ljava/io/File;
    invoke-static {v0}, Lcom/aio/downloader/service/ServiceCleaner;->access$4(Lcom/aio/downloader/service/ServiceCleaner;)Ljava/io/File;

    move-result-object v0

    .line 200
    iget-object v1, p0, Lcom/aio/downloader/service/ServiceCleaner$1$2$1;->this$2:Lcom/aio/downloader/service/ServiceCleaner$1$2;

    # getter for: Lcom/aio/downloader/service/ServiceCleaner$1$2;->this$1:Lcom/aio/downloader/service/ServiceCleaner$1;
    invoke-static {v1}, Lcom/aio/downloader/service/ServiceCleaner$1$2;->access$0(Lcom/aio/downloader/service/ServiceCleaner$1$2;)Lcom/aio/downloader/service/ServiceCleaner$1;

    move-result-object v1

    # getter for: Lcom/aio/downloader/service/ServiceCleaner$1;->this$0:Lcom/aio/downloader/service/ServiceCleaner;
    invoke-static {v1}, Lcom/aio/downloader/service/ServiceCleaner$1;->access$1(Lcom/aio/downloader/service/ServiceCleaner$1;)Lcom/aio/downloader/service/ServiceCleaner;

    move-result-object v1

    # getter for: Lcom/aio/downloader/service/ServiceCleaner;->AIOCALLERAPK:Ljava/io/File;
    invoke-static {v1}, Lcom/aio/downloader/service/ServiceCleaner;->access$3(Lcom/aio/downloader/service/ServiceCleaner;)Ljava/io/File;

    move-result-object v1

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    .line 198
    invoke-static {v0, v1, v2}, Lcom/aio/downloader/utils/Myutils;->copyfile(Ljava/io/File;Ljava/io/File;Ljava/lang/Boolean;)V

    .line 201
    const/4 v0, 0x0

    return-object v0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/service/ServiceCleaner$1$2$1;->onPostExecute(Ljava/lang/Void;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/Void;)V
    .locals 3
    .param p1, "result"    # Ljava/lang/Void;

    .prologue
    .line 210
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 211
    new-instance v0, Landroid/content/Intent;

    .line 212
    const-string v1, "android.intent.action.VIEW"

    .line 211
    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 214
    .local v0, "intent":Landroid/content/Intent;
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "file://"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 215
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceCleaner$1$2$1;->this$2:Lcom/aio/downloader/service/ServiceCleaner$1$2;

    # getter for: Lcom/aio/downloader/service/ServiceCleaner$1$2;->this$1:Lcom/aio/downloader/service/ServiceCleaner$1;
    invoke-static {v2}, Lcom/aio/downloader/service/ServiceCleaner$1$2;->access$0(Lcom/aio/downloader/service/ServiceCleaner$1$2;)Lcom/aio/downloader/service/ServiceCleaner$1;

    move-result-object v2

    # getter for: Lcom/aio/downloader/service/ServiceCleaner$1;->this$0:Lcom/aio/downloader/service/ServiceCleaner;
    invoke-static {v2}, Lcom/aio/downloader/service/ServiceCleaner$1;->access$1(Lcom/aio/downloader/service/ServiceCleaner$1;)Lcom/aio/downloader/service/ServiceCleaner;

    move-result-object v2

    # getter for: Lcom/aio/downloader/service/ServiceCleaner;->AIOCALLERAPK:Ljava/io/File;
    invoke-static {v2}, Lcom/aio/downloader/service/ServiceCleaner;->access$3(Lcom/aio/downloader/service/ServiceCleaner;)Ljava/io/File;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 214
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 216
    const-string v2, "application/vnd.android.package-archive"

    .line 213
    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 217
    const/high16 v1, 0x10000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 218
    iget-object v1, p0, Lcom/aio/downloader/service/ServiceCleaner$1$2$1;->this$2:Lcom/aio/downloader/service/ServiceCleaner$1$2;

    # getter for: Lcom/aio/downloader/service/ServiceCleaner$1$2;->this$1:Lcom/aio/downloader/service/ServiceCleaner$1;
    invoke-static {v1}, Lcom/aio/downloader/service/ServiceCleaner$1$2;->access$0(Lcom/aio/downloader/service/ServiceCleaner$1$2;)Lcom/aio/downloader/service/ServiceCleaner$1;

    move-result-object v1

    # getter for: Lcom/aio/downloader/service/ServiceCleaner$1;->this$0:Lcom/aio/downloader/service/ServiceCleaner;
    invoke-static {v1}, Lcom/aio/downloader/service/ServiceCleaner$1;->access$1(Lcom/aio/downloader/service/ServiceCleaner$1;)Lcom/aio/downloader/service/ServiceCleaner;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/aio/downloader/service/ServiceCleaner;->startActivity(Landroid/content/Intent;)V

    .line 219
    return-void
.end method

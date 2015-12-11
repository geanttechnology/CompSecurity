.class Lcom/aio/downloader/cleaner/RubActivity$1$1;
.super Landroid/os/AsyncTask;
.source "RubActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/cleaner/RubActivity$1;->handleMessage(Landroid/os/Message;)V
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
.field final synthetic this$1:Lcom/aio/downloader/cleaner/RubActivity$1;


# direct methods
.method constructor <init>(Lcom/aio/downloader/cleaner/RubActivity$1;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/cleaner/RubActivity$1$1;->this$1:Lcom/aio/downloader/cleaner/RubActivity$1;

    .line 159
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method

.method static synthetic access$2(Lcom/aio/downloader/cleaner/RubActivity$1$1;)Lcom/aio/downloader/cleaner/RubActivity$1;
    .locals 1

    .prologue
    .line 159
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity$1$1;->this$1:Lcom/aio/downloader/cleaner/RubActivity$1;

    return-object v0
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/cleaner/RubActivity$1$1;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 3
    .param p1, "arg0"    # [Ljava/lang/Void;

    .prologue
    .line 163
    const-wide/16 v1, 0x3e8

    :try_start_0
    invoke-static {v1, v2}, Ljava/lang/Thread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 168
    :goto_0
    const/4 v1, 0x0

    return-object v1

    .line 164
    :catch_0
    move-exception v0

    .line 166
    .local v0, "e":Ljava/lang/InterruptedException;
    invoke-virtual {v0}, Ljava/lang/InterruptedException;->printStackTrace()V

    goto :goto_0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/cleaner/RubActivity$1$1;->onPostExecute(Ljava/lang/Void;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/Void;)V
    .locals 6
    .param p1, "result"    # Ljava/lang/Void;

    .prologue
    .line 173
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 174
    iget-object v4, p0, Lcom/aio/downloader/cleaner/RubActivity$1$1;->this$1:Lcom/aio/downloader/cleaner/RubActivity$1;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity$1;->this$0:Lcom/aio/downloader/cleaner/RubActivity;
    invoke-static {v4}, Lcom/aio/downloader/cleaner/RubActivity$1;->access$0(Lcom/aio/downloader/cleaner/RubActivity$1;)Lcom/aio/downloader/cleaner/RubActivity;

    move-result-object v4

    # invokes: Lcom/aio/downloader/cleaner/RubActivity;->getAssetFile()Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/cleaner/RubActivity;->access$14(Lcom/aio/downloader/cleaner/RubActivity;)Ljava/io/File;

    .line 175
    new-instance v4, Lcom/aio/downloader/cleaner/RubActivity$1$1$1;

    invoke-direct {v4, p0}, Lcom/aio/downloader/cleaner/RubActivity$1$1$1;-><init>(Lcom/aio/downloader/cleaner/RubActivity$1$1;)V

    .line 184
    invoke-virtual {v4}, Lcom/aio/downloader/cleaner/RubActivity$1$1$1;->start()V

    .line 185
    new-instance v3, Lcom/aio/downloader/dialog/CleanerDialog1;

    .line 186
    iget-object v4, p0, Lcom/aio/downloader/cleaner/RubActivity$1$1;->this$1:Lcom/aio/downloader/cleaner/RubActivity$1;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity$1;->this$0:Lcom/aio/downloader/cleaner/RubActivity;
    invoke-static {v4}, Lcom/aio/downloader/cleaner/RubActivity$1;->access$0(Lcom/aio/downloader/cleaner/RubActivity$1;)Lcom/aio/downloader/cleaner/RubActivity;

    move-result-object v4

    const v5, 0x7f0c000e

    .line 185
    invoke-direct {v3, v4, v5}, Lcom/aio/downloader/dialog/CleanerDialog1;-><init>(Landroid/content/Context;I)V

    .line 187
    .local v3, "dialog1":Lcom/aio/downloader/dialog/CleanerDialog1;
    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Lcom/aio/downloader/dialog/CleanerDialog1;->setCanceledOnTouchOutside(Z)V

    .line 188
    invoke-virtual {v3}, Lcom/aio/downloader/dialog/CleanerDialog1;->show()V

    .line 191
    const v4, 0x7f070154

    invoke-virtual {v3, v4}, Lcom/aio/downloader/dialog/CleanerDialog1;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 190
    check-cast v0, Landroid/widget/Button;

    .line 193
    .local v0, "cancel":Landroid/widget/Button;
    const v4, 0x7f070155

    invoke-virtual {v3, v4}, Lcom/aio/downloader/dialog/CleanerDialog1;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 192
    check-cast v1, Landroid/widget/Button;

    .line 195
    .local v1, "clean":Landroid/widget/Button;
    const v4, 0x7f070093

    invoke-virtual {v3, v4}, Lcom/aio/downloader/dialog/CleanerDialog1;->findViewById(I)Landroid/view/View;

    move-result-object v2

    .line 194
    check-cast v2, Landroid/widget/TextView;

    .line 198
    .local v2, "descriptiontv":Landroid/widget/TextView;
    const-string v4, "Boost your phone up to 50% by<font color=\'#3261b4\'> <b>AIO Cleaner</b></font> , Continue? "

    invoke-static {v4}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v4

    .line 197
    invoke-virtual {v2, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 202
    new-instance v4, Lcom/aio/downloader/cleaner/RubActivity$1$1$2;

    invoke-direct {v4, p0, v3}, Lcom/aio/downloader/cleaner/RubActivity$1$1$2;-><init>(Lcom/aio/downloader/cleaner/RubActivity$1$1;Lcom/aio/downloader/dialog/CleanerDialog1;)V

    invoke-virtual {v0, v4}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 208
    new-instance v4, Lcom/aio/downloader/cleaner/RubActivity$1$1$3;

    invoke-direct {v4, p0, v3}, Lcom/aio/downloader/cleaner/RubActivity$1$1$3;-><init>(Lcom/aio/downloader/cleaner/RubActivity$1$1;Lcom/aio/downloader/dialog/CleanerDialog1;)V

    invoke-virtual {v1, v4}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 298
    return-void
.end method

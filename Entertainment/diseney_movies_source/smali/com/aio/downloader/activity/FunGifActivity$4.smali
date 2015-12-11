.class Lcom/aio/downloader/activity/FunGifActivity$4;
.super Ljava/lang/Object;
.source "FunGifActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/FunGifActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/FunGifActivity;

.field private url_share:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/FunGifActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/FunGifActivity$4;->this$0:Lcom/aio/downloader/activity/FunGifActivity;

    .line 219
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/FunGifActivity$4;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 220
    iget-object v0, p0, Lcom/aio/downloader/activity/FunGifActivity$4;->url_share:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 225
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "http://welaf.com/fun/stat.php?type=share&serial="

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 226
    iget-object v3, p0, Lcom/aio/downloader/activity/FunGifActivity$4;->this$0:Lcom/aio/downloader/activity/FunGifActivity;

    # getter for: Lcom/aio/downloader/activity/FunGifActivity;->detailserial:Ljava/lang/String;
    invoke-static {v3}, Lcom/aio/downloader/activity/FunGifActivity;->access$6(Lcom/aio/downloader/activity/FunGifActivity;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 225
    iput-object v2, p0, Lcom/aio/downloader/activity/FunGifActivity$4;->url_share:Ljava/lang/String;

    .line 227
    new-instance v2, Lcom/aio/downloader/activity/FunGifActivity$4$1;

    invoke-direct {v2, p0}, Lcom/aio/downloader/activity/FunGifActivity$4$1;-><init>(Lcom/aio/downloader/activity/FunGifActivity$4;)V

    .line 237
    invoke-virtual {v2}, Lcom/aio/downloader/activity/FunGifActivity$4$1;->start()V

    .line 238
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Share: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/aio/downloader/activity/FunGifActivity$4;->this$0:Lcom/aio/downloader/activity/FunGifActivity;

    # getter for: Lcom/aio/downloader/activity/FunGifActivity;->detailtitle:Ljava/lang/String;
    invoke-static {v3}, Lcom/aio/downloader/activity/FunGifActivity;->access$7(Lcom/aio/downloader/activity/FunGifActivity;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 239
    const-string v3, "\nhttp://welaf.com/fun/share.php?id="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/aio/downloader/activity/FunGifActivity$4;->this$0:Lcom/aio/downloader/activity/FunGifActivity;

    # getter for: Lcom/aio/downloader/activity/FunGifActivity;->detailserial:Ljava/lang/String;
    invoke-static {v3}, Lcom/aio/downloader/activity/FunGifActivity;->access$6(Lcom/aio/downloader/activity/FunGifActivity;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 238
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 240
    .local v1, "share_t":Ljava/lang/String;
    new-instance v0, Landroid/content/Intent;

    const-string v2, "android.intent.action.SEND"

    invoke-direct {v0, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 241
    .local v0, "intent":Landroid/content/Intent;
    const-string v2, "text/plain"

    invoke-virtual {v0, v2}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 242
    const-string v2, "android.intent.extra.TEXT"

    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 243
    iget-object v2, p0, Lcom/aio/downloader/activity/FunGifActivity$4;->this$0:Lcom/aio/downloader/activity/FunGifActivity;

    const-string v3, "AIO Downloaded"

    invoke-static {v0, v3}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/aio/downloader/activity/FunGifActivity;->startActivity(Landroid/content/Intent;)V

    .line 244
    return-void
.end method

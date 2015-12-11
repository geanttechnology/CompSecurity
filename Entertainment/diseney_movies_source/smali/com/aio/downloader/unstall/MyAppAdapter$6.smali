.class Lcom/aio/downloader/unstall/MyAppAdapter$6;
.super Ljava/lang/Object;
.source "MyAppAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/unstall/MyAppAdapter;->popuWindow(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/unstall/MyAppAdapter;

.field private final synthetic val$myPackageNmae:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/aio/downloader/unstall/MyAppAdapter;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/unstall/MyAppAdapter$6;->this$0:Lcom/aio/downloader/unstall/MyAppAdapter;

    iput-object p2, p0, Lcom/aio/downloader/unstall/MyAppAdapter$6;->val$myPackageNmae:Ljava/lang/String;

    .line 270
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 274
    iget-object v0, p0, Lcom/aio/downloader/unstall/MyAppAdapter$6;->this$0:Lcom/aio/downloader/unstall/MyAppAdapter;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "http://android.downloadatoz.com/_201409/market/app_detail_more.php?url_id="

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 275
    iget-object v2, p0, Lcom/aio/downloader/unstall/MyAppAdapter$6;->val$myPackageNmae:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 274
    invoke-static {v0, v1}, Lcom/aio/downloader/unstall/MyAppAdapter;->access$10(Lcom/aio/downloader/unstall/MyAppAdapter;Ljava/lang/String;)V

    .line 276
    iget-object v0, p0, Lcom/aio/downloader/unstall/MyAppAdapter$6;->this$0:Lcom/aio/downloader/unstall/MyAppAdapter;

    iget-object v1, p0, Lcom/aio/downloader/unstall/MyAppAdapter$6;->val$myPackageNmae:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/aio/downloader/unstall/MyAppAdapter;->access$11(Lcom/aio/downloader/unstall/MyAppAdapter;Ljava/lang/String;)V

    .line 277
    new-instance v0, Lcom/aio/downloader/unstall/MyAppAdapter$Mya1;

    iget-object v1, p0, Lcom/aio/downloader/unstall/MyAppAdapter$6;->this$0:Lcom/aio/downloader/unstall/MyAppAdapter;

    invoke-direct {v0, v1}, Lcom/aio/downloader/unstall/MyAppAdapter$Mya1;-><init>(Lcom/aio/downloader/unstall/MyAppAdapter;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/unstall/MyAppAdapter$Mya1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 278
    iget-object v0, p0, Lcom/aio/downloader/unstall/MyAppAdapter$6;->this$0:Lcom/aio/downloader/unstall/MyAppAdapter;

    # getter for: Lcom/aio/downloader/unstall/MyAppAdapter;->mWindow:Landroid/widget/PopupWindow;
    invoke-static {v0}, Lcom/aio/downloader/unstall/MyAppAdapter;->access$8(Lcom/aio/downloader/unstall/MyAppAdapter;)Landroid/widget/PopupWindow;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/PopupWindow;->dismiss()V

    .line 279
    return-void
.end method

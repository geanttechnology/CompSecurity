.class Lcom/aio/downloader/unstall/MyAppAdapter$4;
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
    iput-object p1, p0, Lcom/aio/downloader/unstall/MyAppAdapter$4;->this$0:Lcom/aio/downloader/unstall/MyAppAdapter;

    iput-object p2, p0, Lcom/aio/downloader/unstall/MyAppAdapter$4;->val$myPackageNmae:Ljava/lang/String;

    .line 233
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 238
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.DELETE"

    .line 239
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "package:"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/aio/downloader/unstall/MyAppAdapter$4;->val$myPackageNmae:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    .line 238
    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 240
    .local v0, "intent":Landroid/content/Intent;
    iget-object v1, p0, Lcom/aio/downloader/unstall/MyAppAdapter$4;->this$0:Lcom/aio/downloader/unstall/MyAppAdapter;

    # getter for: Lcom/aio/downloader/unstall/MyAppAdapter;->inflate:Landroid/view/LayoutInflater;
    invoke-static {v1}, Lcom/aio/downloader/unstall/MyAppAdapter;->access$9(Lcom/aio/downloader/unstall/MyAppAdapter;)Landroid/view/LayoutInflater;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/LayoutInflater;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 241
    iget-object v1, p0, Lcom/aio/downloader/unstall/MyAppAdapter$4;->this$0:Lcom/aio/downloader/unstall/MyAppAdapter;

    # getter for: Lcom/aio/downloader/unstall/MyAppAdapter;->mWindow:Landroid/widget/PopupWindow;
    invoke-static {v1}, Lcom/aio/downloader/unstall/MyAppAdapter;->access$8(Lcom/aio/downloader/unstall/MyAppAdapter;)Landroid/widget/PopupWindow;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/PopupWindow;->dismiss()V

    .line 261
    return-void
.end method

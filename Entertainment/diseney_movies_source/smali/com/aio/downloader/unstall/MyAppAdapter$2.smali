.class Lcom/aio/downloader/unstall/MyAppAdapter$2;
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
    iput-object p1, p0, Lcom/aio/downloader/unstall/MyAppAdapter$2;->this$0:Lcom/aio/downloader/unstall/MyAppAdapter;

    iput-object p2, p0, Lcom/aio/downloader/unstall/MyAppAdapter$2;->val$myPackageNmae:Ljava/lang/String;

    .line 201
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 205
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "package:"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/aio/downloader/unstall/MyAppAdapter$2;->val$myPackageNmae:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 206
    .local v1, "packageURI":Landroid/net/Uri;
    new-instance v0, Landroid/content/Intent;

    .line 207
    const-string v2, "android.settings.APPLICATION_DETAILS_SETTINGS"

    .line 206
    invoke-direct {v0, v2, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 209
    .local v0, "intent":Landroid/content/Intent;
    iget-object v2, p0, Lcom/aio/downloader/unstall/MyAppAdapter$2;->this$0:Lcom/aio/downloader/unstall/MyAppAdapter;

    # getter for: Lcom/aio/downloader/unstall/MyAppAdapter;->context:Landroid/content/Context;
    invoke-static {v2}, Lcom/aio/downloader/unstall/MyAppAdapter;->access$5(Lcom/aio/downloader/unstall/MyAppAdapter;)Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 210
    iget-object v2, p0, Lcom/aio/downloader/unstall/MyAppAdapter$2;->this$0:Lcom/aio/downloader/unstall/MyAppAdapter;

    # getter for: Lcom/aio/downloader/unstall/MyAppAdapter;->mWindow:Landroid/widget/PopupWindow;
    invoke-static {v2}, Lcom/aio/downloader/unstall/MyAppAdapter;->access$8(Lcom/aio/downloader/unstall/MyAppAdapter;)Landroid/widget/PopupWindow;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/PopupWindow;->dismiss()V

    .line 211
    return-void
.end method

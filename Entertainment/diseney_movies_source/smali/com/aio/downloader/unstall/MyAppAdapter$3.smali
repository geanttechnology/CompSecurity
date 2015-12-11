.class Lcom/aio/downloader/unstall/MyAppAdapter$3;
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
    iput-object p1, p0, Lcom/aio/downloader/unstall/MyAppAdapter$3;->this$0:Lcom/aio/downloader/unstall/MyAppAdapter;

    iput-object p2, p0, Lcom/aio/downloader/unstall/MyAppAdapter$3;->val$myPackageNmae:Ljava/lang/String;

    .line 213
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 219
    :try_start_0
    iget-object v2, p0, Lcom/aio/downloader/unstall/MyAppAdapter$3;->this$0:Lcom/aio/downloader/unstall/MyAppAdapter;

    # getter for: Lcom/aio/downloader/unstall/MyAppAdapter;->context:Landroid/content/Context;
    invoke-static {v2}, Lcom/aio/downloader/unstall/MyAppAdapter;->access$5(Lcom/aio/downloader/unstall/MyAppAdapter;)Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    .line 220
    iget-object v3, p0, Lcom/aio/downloader/unstall/MyAppAdapter$3;->val$myPackageNmae:Ljava/lang/String;

    invoke-virtual {v2, v3}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v1

    .line 221
    .local v1, "intentopen_this_app":Landroid/content/Intent;
    const/high16 v2, 0x10000000

    invoke-virtual {v1, v2}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 222
    iget-object v2, p0, Lcom/aio/downloader/unstall/MyAppAdapter$3;->this$0:Lcom/aio/downloader/unstall/MyAppAdapter;

    # getter for: Lcom/aio/downloader/unstall/MyAppAdapter;->context:Landroid/content/Context;
    invoke-static {v2}, Lcom/aio/downloader/unstall/MyAppAdapter;->access$5(Lcom/aio/downloader/unstall/MyAppAdapter;)Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 230
    .end local v1    # "intentopen_this_app":Landroid/content/Intent;
    :goto_0
    return-void

    .line 223
    :catch_0
    move-exception v0

    .line 225
    .local v0, "e":Ljava/lang/Exception;
    iget-object v2, p0, Lcom/aio/downloader/unstall/MyAppAdapter$3;->this$0:Lcom/aio/downloader/unstall/MyAppAdapter;

    # getter for: Lcom/aio/downloader/unstall/MyAppAdapter;->context:Landroid/content/Context;
    invoke-static {v2}, Lcom/aio/downloader/unstall/MyAppAdapter;->access$5(Lcom/aio/downloader/unstall/MyAppAdapter;)Landroid/content/Context;

    move-result-object v2

    const-string v3, "This program is protected"

    .line 226
    const/4 v4, 0x0

    .line 225
    invoke-static {v2, v3, v4}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v2

    .line 226
    invoke-virtual {v2}, Landroid/widget/Toast;->show()V

    .line 227
    iget-object v2, p0, Lcom/aio/downloader/unstall/MyAppAdapter$3;->this$0:Lcom/aio/downloader/unstall/MyAppAdapter;

    # getter for: Lcom/aio/downloader/unstall/MyAppAdapter;->mWindow:Landroid/widget/PopupWindow;
    invoke-static {v2}, Lcom/aio/downloader/unstall/MyAppAdapter;->access$8(Lcom/aio/downloader/unstall/MyAppAdapter;)Landroid/widget/PopupWindow;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/PopupWindow;->dismiss()V

    goto :goto_0
.end method

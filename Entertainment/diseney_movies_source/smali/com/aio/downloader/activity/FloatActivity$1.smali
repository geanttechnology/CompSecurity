.class Lcom/aio/downloader/activity/FloatActivity$1;
.super Ljava/lang/Object;
.source "FloatActivity.java"

# interfaces
.implements Landroid/view/View$OnKeyListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/FloatActivity;->init()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/FloatActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/FloatActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/FloatActivity$1;->this$0:Lcom/aio/downloader/activity/FloatActivity;

    .line 224
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onKey(Landroid/view/View;ILandroid/view/KeyEvent;)Z
    .locals 5
    .param p1, "v"    # Landroid/view/View;
    .param p2, "keyCode"    # I
    .param p3, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v4, 0x0

    .line 230
    invoke-virtual {p3}, Landroid/view/KeyEvent;->getAction()I

    move-result v2

    if-nez v2, :cond_1

    .line 231
    const/16 v2, 0x42

    if-ne p2, v2, :cond_1

    .line 234
    :try_start_0
    iget-object v2, p0, Lcom/aio/downloader/activity/FloatActivity$1;->this$0:Lcom/aio/downloader/activity/FloatActivity;

    # getter for: Lcom/aio/downloader/activity/FloatActivity;->float_search_view:Lcom/aio/downloader/views/DeletableEditText;
    invoke-static {v2}, Lcom/aio/downloader/activity/FloatActivity;->access$0(Lcom/aio/downloader/activity/FloatActivity;)Lcom/aio/downloader/views/DeletableEditText;

    move-result-object v2

    .line 235
    invoke-virtual {v2}, Lcom/aio/downloader/views/DeletableEditText;->getContext()Landroid/content/Context;

    move-result-object v2

    .line 236
    const-string v3, "input_method"

    .line 235
    invoke-virtual {v2, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 234
    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 238
    .local v0, "inputManager":Landroid/view/inputmethod/InputMethodManager;
    iget-object v2, p0, Lcom/aio/downloader/activity/FloatActivity$1;->this$0:Lcom/aio/downloader/activity/FloatActivity;

    # getter for: Lcom/aio/downloader/activity/FloatActivity;->float_search_view:Lcom/aio/downloader/views/DeletableEditText;
    invoke-static {v2}, Lcom/aio/downloader/activity/FloatActivity;->access$0(Lcom/aio/downloader/activity/FloatActivity;)Lcom/aio/downloader/views/DeletableEditText;

    move-result-object v2

    invoke-virtual {v2}, Lcom/aio/downloader/views/DeletableEditText;->getWindowToken()Landroid/os/IBinder;

    move-result-object v2

    const/4 v3, 0x0

    .line 237
    invoke-virtual {v0, v2, v3}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 245
    .end local v0    # "inputManager":Landroid/view/inputmethod/InputMethodManager;
    :goto_0
    :try_start_1
    iget-object v2, p0, Lcom/aio/downloader/activity/FloatActivity$1;->this$0:Lcom/aio/downloader/activity/FloatActivity;

    # getter for: Lcom/aio/downloader/activity/FloatActivity;->float_search_view:Lcom/aio/downloader/views/DeletableEditText;
    invoke-static {v2}, Lcom/aio/downloader/activity/FloatActivity;->access$0(Lcom/aio/downloader/activity/FloatActivity;)Lcom/aio/downloader/views/DeletableEditText;

    move-result-object v2

    invoke-virtual {v2}, Lcom/aio/downloader/views/DeletableEditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-interface {v2}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, ""

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 246
    iget-object v2, p0, Lcom/aio/downloader/activity/FloatActivity$1;->this$0:Lcom/aio/downloader/activity/FloatActivity;

    # getter for: Lcom/aio/downloader/activity/FloatActivity;->float_search_view:Lcom/aio/downloader/views/DeletableEditText;
    invoke-static {v2}, Lcom/aio/downloader/activity/FloatActivity;->access$0(Lcom/aio/downloader/activity/FloatActivity;)Lcom/aio/downloader/views/DeletableEditText;

    move-result-object v2

    const-string v3, "AIO Cleaner"

    invoke-virtual {v2, v3}, Lcom/aio/downloader/views/DeletableEditText;->setText(Ljava/lang/CharSequence;)V

    .line 248
    :cond_0
    new-instance v1, Landroid/content/Intent;

    iget-object v2, p0, Lcom/aio/downloader/activity/FloatActivity$1;->this$0:Lcom/aio/downloader/activity/FloatActivity;

    invoke-virtual {v2}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    .line 249
    const-class v3, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    .line 248
    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 250
    .local v1, "intent3":Landroid/content/Intent;
    const-string v2, "searchid"

    iget-object v3, p0, Lcom/aio/downloader/activity/FloatActivity$1;->this$0:Lcom/aio/downloader/activity/FloatActivity;

    # getter for: Lcom/aio/downloader/activity/FloatActivity;->float_search_view:Lcom/aio/downloader/views/DeletableEditText;
    invoke-static {v3}, Lcom/aio/downloader/activity/FloatActivity;->access$0(Lcom/aio/downloader/activity/FloatActivity;)Lcom/aio/downloader/views/DeletableEditText;

    move-result-object v3

    .line 251
    invoke-virtual {v3}, Lcom/aio/downloader/views/DeletableEditText;->getText()Landroid/text/Editable;

    move-result-object v3

    invoke-interface {v3}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v3

    .line 250
    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 252
    const-string v2, "searchint"

    const/4 v3, 0x1

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 253
    const/high16 v2, 0x10000000

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 254
    iget-object v2, p0, Lcom/aio/downloader/activity/FloatActivity$1;->this$0:Lcom/aio/downloader/activity/FloatActivity;

    invoke-virtual {v2, v1}, Lcom/aio/downloader/activity/FloatActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    .line 262
    .end local v1    # "intent3":Landroid/content/Intent;
    :cond_1
    :goto_1
    return v4

    .line 256
    :catch_0
    move-exception v2

    goto :goto_1

    .line 240
    :catch_1
    move-exception v2

    goto :goto_0
.end method

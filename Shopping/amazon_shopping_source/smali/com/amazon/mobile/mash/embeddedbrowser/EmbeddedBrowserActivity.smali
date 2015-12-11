.class public Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserActivity;
.super Landroid/app/Activity;
.source "EmbeddedBrowserActivity.java"

# interfaces
.implements Lorg/apache/cordova/CordovaInterface;


# instance fields
.field private mEmbeddedBrowserContainer:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method


# virtual methods
.method public getActivity()Landroid/app/Activity;
    .locals 0

    .prologue
    .line 61
    return-object p0
.end method

.method public getThreadPool()Ljava/util/concurrent/ExecutorService;
    .locals 1

    .prologue
    .line 99
    const/4 v0, 0x0

    return-object v0
.end method

.method public onBackPressed()V
    .locals 1

    .prologue
    .line 66
    iget-object v0, p0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserActivity;->mEmbeddedBrowserContainer:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;

    invoke-virtual {v0}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->goBack()Z

    move-result v0

    if-nez v0, :cond_0

    .line 67
    invoke-super {p0}, Landroid/app/Activity;->onBackPressed()V

    .line 69
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 33
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 34
    new-instance v0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;

    invoke-direct {v0, p0}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;-><init>(Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserActivity;)V

    iput-object v0, p0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserActivity;->mEmbeddedBrowserContainer:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;

    .line 35
    iget-object v0, p0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserActivity;->mEmbeddedBrowserContainer:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;

    invoke-virtual {p0, v0}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserActivity;->setContentView(Landroid/view/View;)V

    .line 36
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 3
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    const/4 v2, 0x0

    .line 40
    const/4 v0, 0x1

    sget v1, Lcom/amazon/mobile/mash/R$string;->open_in_browser:I

    invoke-interface {p1, v2, v0, v2, v1}, Landroid/view/Menu;->add(IIII)Landroid/view/MenuItem;

    .line 41
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreateOptionsMenu(Landroid/view/Menu;)Z

    move-result v0

    return v0
.end method

.method public onDestroy()V
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserActivity;->mEmbeddedBrowserContainer:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;

    invoke-virtual {v0}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->destroy()V

    .line 56
    invoke-super {p0}, Landroid/app/Activity;->onDestroy()V

    .line 57
    return-void
.end method

.method public onMenuItemSelected(ILandroid/view/MenuItem;)Z
    .locals 2
    .param p1, "featureId"    # I
    .param p2, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 46
    invoke-interface {p2}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    .line 47
    iget-object v0, p0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserActivity;->mEmbeddedBrowserContainer:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;

    invoke-virtual {v0}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->openInExternalBrowser()V

    .line 49
    :cond_0
    invoke-super {p0, p1, p2}, Landroid/app/Activity;->onMenuItemSelected(ILandroid/view/MenuItem;)Z

    move-result v0

    return v0
.end method

.method public onMessage(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "data"    # Ljava/lang/Object;

    .prologue
    .line 104
    const/4 v0, 0x0

    return-object v0
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 73
    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    .line 74
    iget-object v0, p0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserActivity;->mEmbeddedBrowserContainer:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;

    invoke-virtual {v0}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->handleOnPause()V

    .line 75
    return-void
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 79
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 80
    iget-object v0, p0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserActivity;->mEmbeddedBrowserContainer:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;

    invoke-virtual {v0}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->handleOnResume()V

    .line 81
    return-void
.end method

.method public setActivityResultCallback(Lorg/apache/cordova/CordovaPlugin;)V
    .locals 0
    .param p1, "plugin"    # Lorg/apache/cordova/CordovaPlugin;

    .prologue
    .line 95
    return-void
.end method

.method public startActivityForResult(Lorg/apache/cordova/CordovaPlugin;Landroid/content/Intent;I)V
    .locals 0
    .param p1, "command"    # Lorg/apache/cordova/CordovaPlugin;
    .param p2, "intent"    # Landroid/content/Intent;
    .param p3, "requestCode"    # I

    .prologue
    .line 91
    return-void
.end method

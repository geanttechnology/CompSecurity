.class Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;
.super Landroid/os/AsyncTask;
.source "MraidBrowser.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/MraidBrowser;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "LoadButtonsTask"
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
.field private final buttonHeight:I

.field private final buttonWidth:I

.field private final intent:Landroid/content/Intent;

.field private final layout:Landroid/view/ViewGroup;

.field final synthetic this$0:Lcom/amazon/device/ads/MraidBrowser;


# direct methods
.method public constructor <init>(Lcom/amazon/device/ads/MraidBrowser;Landroid/content/Intent;Landroid/view/ViewGroup;II)V
    .locals 0
    .param p2, "intent"    # Landroid/content/Intent;
    .param p3, "layout"    # Landroid/view/ViewGroup;
    .param p4, "buttonWidth"    # I
    .param p5, "buttonHeight"    # I

    .prologue
    .line 398
    iput-object p1, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->this$0:Lcom/amazon/device/ads/MraidBrowser;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 399
    iput-object p2, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->intent:Landroid/content/Intent;

    .line 400
    iput-object p3, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->layout:Landroid/view/ViewGroup;

    .line 401
    iput p4, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->buttonWidth:I

    .line 402
    iput p5, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->buttonHeight:I

    .line 403
    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # [Ljava/lang/Object;

    .prologue
    .line 390
    check-cast p1, [Ljava/lang/Void;

    .end local p1    # "x0":[Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 10
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    const/4 v3, -0x1

    const/4 v6, 0x1

    .line 407
    iget-object v7, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->this$0:Lcom/amazon/device/ads/MraidBrowser;

    iget-object v0, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->this$0:Lcom/amazon/device/ads/MraidBrowser;

    invoke-static {}, Lcom/amazon/device/ads/Assets;->getInstance()Lcom/amazon/device/ads/Assets;

    move-result-object v1

    const-string/jumbo v2, "amazon_ads_leftarrow.png"

    invoke-virtual {v1, v2}, Lcom/amazon/device/ads/Assets;->getFilePath(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const/16 v2, 0x9

    iget v4, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->buttonWidth:I

    iget v5, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->buttonHeight:I

    # invokes: Lcom/amazon/device/ads/MraidBrowser;->createButton(Ljava/lang/String;IIII)Landroid/widget/ImageButton;
    invoke-static/range {v0 .. v5}, Lcom/amazon/device/ads/MraidBrowser;->access$400(Lcom/amazon/device/ads/MraidBrowser;Ljava/lang/String;IIII)Landroid/widget/ImageButton;

    move-result-object v0

    # setter for: Lcom/amazon/device/ads/MraidBrowser;->mBrowserBackButton:Landroid/widget/ImageButton;
    invoke-static {v7, v0}, Lcom/amazon/device/ads/MraidBrowser;->access$302(Lcom/amazon/device/ads/MraidBrowser;Landroid/widget/ImageButton;)Landroid/widget/ImageButton;

    .line 408
    iget-object v0, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->this$0:Lcom/amazon/device/ads/MraidBrowser;

    # getter for: Lcom/amazon/device/ads/MraidBrowser;->mBrowserBackButton:Landroid/widget/ImageButton;
    invoke-static {v0}, Lcom/amazon/device/ads/MraidBrowser;->access$300(Lcom/amazon/device/ads/MraidBrowser;)Landroid/widget/ImageButton;

    move-result-object v0

    const/16 v1, 0x2929

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setId(I)V

    .line 409
    iget-object v0, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->this$0:Lcom/amazon/device/ads/MraidBrowser;

    iget-object v4, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->this$0:Lcom/amazon/device/ads/MraidBrowser;

    invoke-static {}, Lcom/amazon/device/ads/Assets;->getInstance()Lcom/amazon/device/ads/Assets;

    move-result-object v1

    const-string/jumbo v2, "amazon_ads_rightarrow.png"

    invoke-virtual {v1, v2}, Lcom/amazon/device/ads/Assets;->getFilePath(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iget-object v1, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->this$0:Lcom/amazon/device/ads/MraidBrowser;

    # getter for: Lcom/amazon/device/ads/MraidBrowser;->mBrowserBackButton:Landroid/widget/ImageButton;
    invoke-static {v1}, Lcom/amazon/device/ads/MraidBrowser;->access$300(Lcom/amazon/device/ads/MraidBrowser;)Landroid/widget/ImageButton;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/ImageButton;->getId()I

    move-result v7

    iget v8, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->buttonWidth:I

    iget v9, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->buttonHeight:I

    # invokes: Lcom/amazon/device/ads/MraidBrowser;->createButton(Ljava/lang/String;IIII)Landroid/widget/ImageButton;
    invoke-static/range {v4 .. v9}, Lcom/amazon/device/ads/MraidBrowser;->access$400(Lcom/amazon/device/ads/MraidBrowser;Ljava/lang/String;IIII)Landroid/widget/ImageButton;

    move-result-object v1

    # setter for: Lcom/amazon/device/ads/MraidBrowser;->mBrowserForwardButton:Landroid/widget/ImageButton;
    invoke-static {v0, v1}, Lcom/amazon/device/ads/MraidBrowser;->access$502(Lcom/amazon/device/ads/MraidBrowser;Landroid/widget/ImageButton;)Landroid/widget/ImageButton;

    .line 410
    iget-object v0, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->this$0:Lcom/amazon/device/ads/MraidBrowser;

    # getter for: Lcom/amazon/device/ads/MraidBrowser;->mBrowserForwardButton:Landroid/widget/ImageButton;
    invoke-static {v0}, Lcom/amazon/device/ads/MraidBrowser;->access$500(Lcom/amazon/device/ads/MraidBrowser;)Landroid/widget/ImageButton;

    move-result-object v0

    const/16 v1, 0x2a2a

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setId(I)V

    .line 411
    iget-object v7, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->this$0:Lcom/amazon/device/ads/MraidBrowser;

    iget-object v0, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->this$0:Lcom/amazon/device/ads/MraidBrowser;

    invoke-static {}, Lcom/amazon/device/ads/Assets;->getInstance()Lcom/amazon/device/ads/Assets;

    move-result-object v1

    const-string/jumbo v2, "amazon_ads_close.png"

    invoke-virtual {v1, v2}, Lcom/amazon/device/ads/Assets;->getFilePath(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const/16 v2, 0xb

    iget v4, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->buttonWidth:I

    iget v5, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->buttonHeight:I

    # invokes: Lcom/amazon/device/ads/MraidBrowser;->createButton(Ljava/lang/String;IIII)Landroid/widget/ImageButton;
    invoke-static/range {v0 .. v5}, Lcom/amazon/device/ads/MraidBrowser;->access$400(Lcom/amazon/device/ads/MraidBrowser;Ljava/lang/String;IIII)Landroid/widget/ImageButton;

    move-result-object v0

    # setter for: Lcom/amazon/device/ads/MraidBrowser;->mCloseButton:Landroid/widget/ImageButton;
    invoke-static {v7, v0}, Lcom/amazon/device/ads/MraidBrowser;->access$602(Lcom/amazon/device/ads/MraidBrowser;Landroid/widget/ImageButton;)Landroid/widget/ImageButton;

    .line 413
    iget-object v0, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->this$0:Lcom/amazon/device/ads/MraidBrowser;

    # getter for: Lcom/amazon/device/ads/MraidBrowser;->showOpenExternalBrowserButton:Z
    invoke-static {v0}, Lcom/amazon/device/ads/MraidBrowser;->access$700(Lcom/amazon/device/ads/MraidBrowser;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 415
    iget-object v0, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->this$0:Lcom/amazon/device/ads/MraidBrowser;

    iget-object v4, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->this$0:Lcom/amazon/device/ads/MraidBrowser;

    invoke-static {}, Lcom/amazon/device/ads/Assets;->getInstance()Lcom/amazon/device/ads/Assets;

    move-result-object v1

    const-string/jumbo v2, "amazon_ads_open_external_browser.png"

    invoke-virtual {v1, v2}, Lcom/amazon/device/ads/Assets;->getFilePath(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iget-object v1, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->this$0:Lcom/amazon/device/ads/MraidBrowser;

    # getter for: Lcom/amazon/device/ads/MraidBrowser;->mBrowserForwardButton:Landroid/widget/ImageButton;
    invoke-static {v1}, Lcom/amazon/device/ads/MraidBrowser;->access$500(Lcom/amazon/device/ads/MraidBrowser;)Landroid/widget/ImageButton;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/ImageButton;->getId()I

    move-result v7

    iget v8, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->buttonWidth:I

    iget v9, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->buttonHeight:I

    # invokes: Lcom/amazon/device/ads/MraidBrowser;->createButton(Ljava/lang/String;IIII)Landroid/widget/ImageButton;
    invoke-static/range {v4 .. v9}, Lcom/amazon/device/ads/MraidBrowser;->access$400(Lcom/amazon/device/ads/MraidBrowser;Ljava/lang/String;IIII)Landroid/widget/ImageButton;

    move-result-object v1

    # setter for: Lcom/amazon/device/ads/MraidBrowser;->mOpenExternalBrowserButton:Landroid/widget/ImageButton;
    invoke-static {v0, v1}, Lcom/amazon/device/ads/MraidBrowser;->access$802(Lcom/amazon/device/ads/MraidBrowser;Landroid/widget/ImageButton;)Landroid/widget/ImageButton;

    .line 416
    iget-object v0, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->this$0:Lcom/amazon/device/ads/MraidBrowser;

    # getter for: Lcom/amazon/device/ads/MraidBrowser;->mOpenExternalBrowserButton:Landroid/widget/ImageButton;
    invoke-static {v0}, Lcom/amazon/device/ads/MraidBrowser;->access$800(Lcom/amazon/device/ads/MraidBrowser;)Landroid/widget/ImageButton;

    move-result-object v0

    const/16 v1, 0x2a2b

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setId(I)V

    .line 417
    iget-object v0, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->this$0:Lcom/amazon/device/ads/MraidBrowser;

    iget-object v4, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->this$0:Lcom/amazon/device/ads/MraidBrowser;

    invoke-static {}, Lcom/amazon/device/ads/Assets;->getInstance()Lcom/amazon/device/ads/Assets;

    move-result-object v1

    const-string/jumbo v2, "amazon_ads_refresh.png"

    invoke-virtual {v1, v2}, Lcom/amazon/device/ads/Assets;->getFilePath(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iget-object v1, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->this$0:Lcom/amazon/device/ads/MraidBrowser;

    # getter for: Lcom/amazon/device/ads/MraidBrowser;->mOpenExternalBrowserButton:Landroid/widget/ImageButton;
    invoke-static {v1}, Lcom/amazon/device/ads/MraidBrowser;->access$800(Lcom/amazon/device/ads/MraidBrowser;)Landroid/widget/ImageButton;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/ImageButton;->getId()I

    move-result v7

    iget v8, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->buttonWidth:I

    iget v9, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->buttonHeight:I

    # invokes: Lcom/amazon/device/ads/MraidBrowser;->createButton(Ljava/lang/String;IIII)Landroid/widget/ImageButton;
    invoke-static/range {v4 .. v9}, Lcom/amazon/device/ads/MraidBrowser;->access$400(Lcom/amazon/device/ads/MraidBrowser;Ljava/lang/String;IIII)Landroid/widget/ImageButton;

    move-result-object v1

    # setter for: Lcom/amazon/device/ads/MraidBrowser;->mRefreshButton:Landroid/widget/ImageButton;
    invoke-static {v0, v1}, Lcom/amazon/device/ads/MraidBrowser;->access$902(Lcom/amazon/device/ads/MraidBrowser;Landroid/widget/ImageButton;)Landroid/widget/ImageButton;

    .line 424
    :goto_0
    const/4 v0, 0x0

    return-object v0

    .line 421
    :cond_0
    iget-object v0, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->this$0:Lcom/amazon/device/ads/MraidBrowser;

    iget-object v4, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->this$0:Lcom/amazon/device/ads/MraidBrowser;

    invoke-static {}, Lcom/amazon/device/ads/Assets;->getInstance()Lcom/amazon/device/ads/Assets;

    move-result-object v1

    const-string/jumbo v2, "amazon_ads_refresh.png"

    invoke-virtual {v1, v2}, Lcom/amazon/device/ads/Assets;->getFilePath(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iget-object v1, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->this$0:Lcom/amazon/device/ads/MraidBrowser;

    # getter for: Lcom/amazon/device/ads/MraidBrowser;->mBrowserForwardButton:Landroid/widget/ImageButton;
    invoke-static {v1}, Lcom/amazon/device/ads/MraidBrowser;->access$500(Lcom/amazon/device/ads/MraidBrowser;)Landroid/widget/ImageButton;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/ImageButton;->getId()I

    move-result v7

    iget v8, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->buttonWidth:I

    iget v9, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->buttonHeight:I

    # invokes: Lcom/amazon/device/ads/MraidBrowser;->createButton(Ljava/lang/String;IIII)Landroid/widget/ImageButton;
    invoke-static/range {v4 .. v9}, Lcom/amazon/device/ads/MraidBrowser;->access$400(Lcom/amazon/device/ads/MraidBrowser;Ljava/lang/String;IIII)Landroid/widget/ImageButton;

    move-result-object v1

    # setter for: Lcom/amazon/device/ads/MraidBrowser;->mRefreshButton:Landroid/widget/ImageButton;
    invoke-static {v0, v1}, Lcom/amazon/device/ads/MraidBrowser;->access$902(Lcom/amazon/device/ads/MraidBrowser;Landroid/widget/ImageButton;)Landroid/widget/ImageButton;

    goto :goto_0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 390
    check-cast p1, Ljava/lang/Void;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->onPostExecute(Ljava/lang/Void;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/Void;)V
    .locals 2
    .param p1, "param"    # Ljava/lang/Void;

    .prologue
    .line 430
    iget-object v0, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->layout:Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->this$0:Lcom/amazon/device/ads/MraidBrowser;

    # getter for: Lcom/amazon/device/ads/MraidBrowser;->mBrowserBackButton:Landroid/widget/ImageButton;
    invoke-static {v1}, Lcom/amazon/device/ads/MraidBrowser;->access$300(Lcom/amazon/device/ads/MraidBrowser;)Landroid/widget/ImageButton;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 431
    iget-object v0, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->layout:Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->this$0:Lcom/amazon/device/ads/MraidBrowser;

    # getter for: Lcom/amazon/device/ads/MraidBrowser;->mBrowserForwardButton:Landroid/widget/ImageButton;
    invoke-static {v1}, Lcom/amazon/device/ads/MraidBrowser;->access$500(Lcom/amazon/device/ads/MraidBrowser;)Landroid/widget/ImageButton;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 432
    iget-object v0, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->layout:Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->this$0:Lcom/amazon/device/ads/MraidBrowser;

    # getter for: Lcom/amazon/device/ads/MraidBrowser;->mRefreshButton:Landroid/widget/ImageButton;
    invoke-static {v1}, Lcom/amazon/device/ads/MraidBrowser;->access$900(Lcom/amazon/device/ads/MraidBrowser;)Landroid/widget/ImageButton;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 433
    iget-object v0, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->layout:Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->this$0:Lcom/amazon/device/ads/MraidBrowser;

    # getter for: Lcom/amazon/device/ads/MraidBrowser;->mCloseButton:Landroid/widget/ImageButton;
    invoke-static {v1}, Lcom/amazon/device/ads/MraidBrowser;->access$600(Lcom/amazon/device/ads/MraidBrowser;)Landroid/widget/ImageButton;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 435
    iget-object v0, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->this$0:Lcom/amazon/device/ads/MraidBrowser;

    # getter for: Lcom/amazon/device/ads/MraidBrowser;->showOpenExternalBrowserButton:Z
    invoke-static {v0}, Lcom/amazon/device/ads/MraidBrowser;->access$700(Lcom/amazon/device/ads/MraidBrowser;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 437
    iget-object v0, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->layout:Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->this$0:Lcom/amazon/device/ads/MraidBrowser;

    # getter for: Lcom/amazon/device/ads/MraidBrowser;->mOpenExternalBrowserButton:Landroid/widget/ImageButton;
    invoke-static {v1}, Lcom/amazon/device/ads/MraidBrowser;->access$800(Lcom/amazon/device/ads/MraidBrowser;)Landroid/widget/ImageButton;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 440
    :cond_0
    iget-object v0, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->this$0:Lcom/amazon/device/ads/MraidBrowser;

    iget-object v1, p0, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;->intent:Landroid/content/Intent;

    # invokes: Lcom/amazon/device/ads/MraidBrowser;->initializeButtons(Landroid/content/Intent;)V
    invoke-static {v0, v1}, Lcom/amazon/device/ads/MraidBrowser;->access$1000(Lcom/amazon/device/ads/MraidBrowser;Landroid/content/Intent;)V

    .line 441
    return-void
.end method

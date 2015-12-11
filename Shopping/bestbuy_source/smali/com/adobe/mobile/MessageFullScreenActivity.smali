.class public Lcom/adobe/mobile/MessageFullScreenActivity;
.super Lcom/adobe/mobile/AdobeMarketingActivity;
.source "SourceFile"


# instance fields
.field protected message:Lcom/adobe/mobile/MessageFullScreen;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 26
    invoke-direct {p0}, Lcom/adobe/mobile/AdobeMarketingActivity;-><init>()V

    return-void
.end method


# virtual methods
.method public onBackPressed()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 74
    iget-object v0, p0, Lcom/adobe/mobile/MessageFullScreenActivity;->message:Lcom/adobe/mobile/MessageFullScreen;

    iput-boolean v1, v0, Lcom/adobe/mobile/MessageFullScreen;->isVisible:Z

    .line 75
    iget-object v0, p0, Lcom/adobe/mobile/MessageFullScreenActivity;->message:Lcom/adobe/mobile/MessageFullScreen;

    invoke-virtual {v0}, Lcom/adobe/mobile/MessageFullScreen;->viewed()V

    .line 76
    invoke-virtual {p0}, Lcom/adobe/mobile/MessageFullScreenActivity;->finish()V

    .line 77
    invoke-virtual {p0, v1, v1}, Lcom/adobe/mobile/MessageFullScreenActivity;->overridePendingTransition(II)V

    .line 78
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 31
    invoke-super {p0, p1}, Lcom/adobe/mobile/AdobeMarketingActivity;->onCreate(Landroid/os/Bundle;)V

    .line 32
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/adobe/mobile/MessageFullScreenActivity;->requestWindowFeature(I)Z

    .line 35
    new-instance v0, Landroid/widget/LinearLayout;

    invoke-direct {v0, p0}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 36
    invoke-virtual {p0, v0}, Lcom/adobe/mobile/MessageFullScreenActivity;->setContentView(Landroid/view/View;)V

    .line 38
    invoke-static {}, Lcom/adobe/mobile/Messages;->getCurrentFullscreenMessage()Lcom/adobe/mobile/MessageFullScreen;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mobile/MessageFullScreenActivity;->message:Lcom/adobe/mobile/MessageFullScreen;

    .line 39
    iget-object v0, p0, Lcom/adobe/mobile/MessageFullScreenActivity;->message:Lcom/adobe/mobile/MessageFullScreen;

    iput-object p0, v0, Lcom/adobe/mobile/MessageFullScreen;->messageFullScreenActivity:Landroid/app/Activity;

    .line 40
    return-void
.end method

.method public onResume()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 44
    invoke-super {p0}, Lcom/adobe/mobile/AdobeMarketingActivity;->onResume()V

    .line 48
    const v0, 0x1020002

    :try_start_0
    invoke-virtual {p0, v0}, Lcom/adobe/mobile/MessageFullScreenActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    .line 50
    if-nez v0, :cond_0

    .line 51
    const-string v0, "Messages - unable to get root view group from os"

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 52
    invoke-virtual {p0}, Lcom/adobe/mobile/MessageFullScreenActivity;->finish()V

    .line 53
    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/adobe/mobile/MessageFullScreenActivity;->overridePendingTransition(II)V

    .line 70
    :goto_0
    return-void

    .line 56
    :cond_0
    new-instance v1, Lcom/adobe/mobile/MessageFullScreenActivity$1;

    invoke-direct {v1, p0, v0}, Lcom/adobe/mobile/MessageFullScreenActivity$1;-><init>(Lcom/adobe/mobile/MessageFullScreenActivity;Landroid/view/ViewGroup;)V

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->post(Ljava/lang/Runnable;)Z
    :try_end_0
    .catch Ljava/lang/NullPointerException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 65
    :catch_0
    move-exception v0

    .line 66
    const-string v1, "Messages - content view is in undefined state (%s)"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/NullPointerException;->getMessage()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v2, v3

    invoke-static {v1, v2}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 67
    invoke-virtual {p0}, Lcom/adobe/mobile/MessageFullScreenActivity;->finish()V

    .line 68
    invoke-virtual {p0, v3, v3}, Lcom/adobe/mobile/MessageFullScreenActivity;->overridePendingTransition(II)V

    goto :goto_0
.end method

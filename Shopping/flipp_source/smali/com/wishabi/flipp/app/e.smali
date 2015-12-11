.class public Lcom/wishabi/flipp/app/e;
.super Lcom/wishabi/flipp/app/dl;
.source "SourceFile"


# instance fields
.field private a:Ljava/lang/String;

.field private c:Landroid/webkit/WebView;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Lcom/wishabi/flipp/app/dl;-><init>()V

    return-void
.end method

.method public static a(Ljava/lang/String;)Landroid/os/Bundle;
    .locals 2

    .prologue
    .line 27
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 28
    const-string v1, "SAVE_STATE_BARCODE_URL_KEY"

    invoke-virtual {v0, v1, p0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 29
    return-object v0
.end method

.method public static a(Landroid/os/Bundle;)Lcom/wishabi/flipp/app/e;
    .locals 1

    .prologue
    .line 38
    new-instance v0, Lcom/wishabi/flipp/app/e;

    invoke-direct {v0}, Lcom/wishabi/flipp/app/e;-><init>()V

    .line 39
    invoke-virtual {v0, p0}, Lcom/wishabi/flipp/app/e;->setArguments(Landroid/os/Bundle;)V

    .line 40
    return-object v0
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 45
    invoke-super {p0, p1}, Lcom/wishabi/flipp/app/dl;->onCreate(Landroid/os/Bundle;)V

    .line 47
    if-nez p1, :cond_0

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/e;->getArguments()Landroid/os/Bundle;

    move-result-object p1

    .line 50
    :cond_0
    if-eqz p1, :cond_1

    .line 51
    const-string v0, "SAVE_STATE_BARCODE_URL_KEY"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/app/e;->a:Ljava/lang/String;

    .line 52
    :cond_1
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 8

    .prologue
    const/4 v7, 0x2

    const/4 v1, 0x0

    const/4 v6, 0x0

    .line 59
    invoke-super {p0, p1, p2, p3}, Lcom/wishabi/flipp/app/dl;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 61
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/e;->getActivity()Landroid/app/Activity;

    move-result-object v3

    .line 62
    if-nez v3, :cond_0

    move-object v0, v1

    .line 96
    :goto_0
    return-object v0

    .line 65
    :cond_0
    const v0, 0x7f030005

    invoke-virtual {p1, v0, p2, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    .line 66
    if-nez v2, :cond_1

    move-object v0, v1

    .line 67
    goto :goto_0

    .line 70
    :cond_1
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v4, "<html><img src=\""

    invoke-direct {v0, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v4, p0, Lcom/wishabi/flipp/app/e;->a:Ljava/lang/String;

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, "\" style=\"position:absolute; margin:auto; left:0; top:0; right:0; bottom:0; max-width: 100%; max-height: 100%;\"></html>"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 77
    const v0, 0x7f0b002d

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/webkit/WebView;

    iput-object v0, p0, Lcom/wishabi/flipp/app/e;->c:Landroid/webkit/WebView;

    .line 78
    iget-object v0, p0, Lcom/wishabi/flipp/app/e;->c:Landroid/webkit/WebView;

    const-string v5, "text/html"

    invoke-virtual {v0, v4, v5, v1}, Landroid/webkit/WebView;->loadData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 79
    iget-object v0, p0, Lcom/wishabi/flipp/app/e;->c:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/webkit/WebSettings;->setBuiltInZoomControls(Z)V

    .line 80
    iget-object v0, p0, Lcom/wishabi/flipp/app/e;->c:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    invoke-virtual {v0, v6}, Landroid/webkit/WebSettings;->setDisplayZoomControls(Z)V

    .line 81
    iget-object v0, p0, Lcom/wishabi/flipp/app/e;->c:Landroid/webkit/WebView;

    invoke-virtual {v0, v6}, Landroid/webkit/WebView;->setHorizontalScrollBarEnabled(Z)V

    .line 82
    iget-object v0, p0, Lcom/wishabi/flipp/app/e;->c:Landroid/webkit/WebView;

    invoke-virtual {v0, v6}, Landroid/webkit/WebView;->setVerticalScrollBarEnabled(Z)V

    .line 83
    iget-object v0, p0, Lcom/wishabi/flipp/app/e;->c:Landroid/webkit/WebView;

    invoke-virtual {v0, v7}, Landroid/webkit/WebView;->setOverScrollMode(I)V

    .line 85
    const v0, 0x7f0e006b

    invoke-virtual {v3, v0}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/e;->b(Ljava/lang/String;)V

    .line 88
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/e;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v0

    iget v0, v0, Landroid/content/res/Configuration;->orientation:I

    .line 89
    if-ne v0, v7, :cond_2

    .line 90
    const/4 v0, 0x6

    invoke-virtual {v3, v0}, Landroid/app/Activity;->setRequestedOrientation(I)V

    :goto_1
    move-object v0, v2

    .line 96
    goto :goto_0

    .line 93
    :cond_2
    const/4 v0, 0x7

    invoke-virtual {v3, v0}, Landroid/app/Activity;->setRequestedOrientation(I)V

    goto :goto_1
.end method

.method public onDestroyView()V
    .locals 2

    .prologue
    .line 135
    invoke-super {p0}, Lcom/wishabi/flipp/app/dl;->onDestroyView()V

    .line 137
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/e;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 138
    if-nez v0, :cond_0

    .line 143
    :goto_0
    return-void

    .line 142
    :cond_0
    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/app/Activity;->setRequestedOrientation(I)V

    goto :goto_0
.end method

.method public onPause()V
    .locals 3

    .prologue
    .line 121
    invoke-super {p0}, Lcom/wishabi/flipp/app/dl;->onPause()V

    .line 123
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/e;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 124
    if-nez v0, :cond_0

    .line 131
    :goto_0
    return-void

    .line 128
    :cond_0
    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object v1

    .line 129
    const/high16 v2, -0x40800000    # -1.0f

    iput v2, v1, Landroid/view/WindowManager$LayoutParams;->screenBrightness:F

    .line 130
    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/view/Window;->setAttributes(Landroid/view/WindowManager$LayoutParams;)V

    goto :goto_0
.end method

.method public onResume()V
    .locals 3

    .prologue
    .line 107
    invoke-super {p0}, Lcom/wishabi/flipp/app/dl;->onResume()V

    .line 109
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/e;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 110
    if-nez v0, :cond_0

    .line 117
    :goto_0
    return-void

    .line 114
    :cond_0
    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object v1

    .line 115
    const/high16 v2, 0x3f800000    # 1.0f

    iput v2, v1, Landroid/view/WindowManager$LayoutParams;->screenBrightness:F

    .line 116
    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/view/Window;->setAttributes(Landroid/view/WindowManager$LayoutParams;)V

    goto :goto_0
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 101
    invoke-super {p0, p1}, Lcom/wishabi/flipp/app/dl;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 102
    const-string v0, "SAVE_STATE_BARCODE_URL_KEY"

    iget-object v1, p0, Lcom/wishabi/flipp/app/e;->a:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 103
    return-void
.end method

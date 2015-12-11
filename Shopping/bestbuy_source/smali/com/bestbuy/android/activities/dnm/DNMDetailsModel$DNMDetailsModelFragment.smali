.class public Lcom/bestbuy/android/activities/dnm/DNMDetailsModel$DNMDetailsModelFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/dnm/DNMDetailsModel;

.field private b:Ljava/lang/String;

.field private c:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/bestbuy/android/activities/dnm/DNMDetailsModel;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 59
    iput-object p1, p0, Lcom/bestbuy/android/activities/dnm/DNMDetailsModel$DNMDetailsModelFragment;->a:Lcom/bestbuy/android/activities/dnm/DNMDetailsModel;

    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 60
    iput-object p2, p0, Lcom/bestbuy/android/activities/dnm/DNMDetailsModel$DNMDetailsModelFragment;->b:Ljava/lang/String;

    .line 61
    iput-object p3, p0, Lcom/bestbuy/android/activities/dnm/DNMDetailsModel$DNMDetailsModelFragment;->c:Ljava/lang/String;

    .line 62
    return-void
.end method


# virtual methods
.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 76
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 77
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 65
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 66
    iput-object p1, p0, Lcom/bestbuy/android/activities/dnm/DNMDetailsModel$DNMDetailsModelFragment;->d:Landroid/app/Activity;

    .line 67
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 71
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 72
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 5

    .prologue
    .line 81
    const v0, 0x7f030111

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    .line 82
    const v0, 0x7f0c00a2

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/webkit/WebView;

    .line 83
    const-string v1, "http.agent"

    invoke-static {v1}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 85
    invoke-virtual {v0}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v3

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, "Mozilla/5.0 (Linux; U; Android 4.2.2; en-us; google_sdk Build/JB_MR1.1) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30"

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v3, v1}, Landroid/webkit/WebSettings;->setUserAgentString(Ljava/lang/String;)V

    .line 86
    invoke-virtual {v0}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v1

    const/4 v3, 0x1

    invoke-virtual {v1, v3}, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V

    .line 87
    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMDetailsModel$DNMDetailsModelFragment;->b:Ljava/lang/String;

    const-string v3, "file:///android_asset/"

    invoke-virtual {v1, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 88
    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMDetailsModel$DNMDetailsModelFragment;->b:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 89
    :cond_0
    const v0, 0x7f0c0396

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 90
    const-string v1, ""

    .line 91
    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMDetailsModel$DNMDetailsModelFragment;->c:Ljava/lang/String;

    const v3, 0x7f08006c

    invoke-virtual {p0, v3}, Lcom/bestbuy/android/activities/dnm/DNMDetailsModel$DNMDetailsModelFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 92
    const v1, 0x7f08006d

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/dnm/DNMDetailsModel$DNMDetailsModelFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 99
    :goto_0
    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 100
    const v0, 0x7f0c00a1

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 101
    new-instance v1, Lcom/bestbuy/android/activities/dnm/DNMDetailsModel$DNMDetailsModelFragment$1;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/dnm/DNMDetailsModel$DNMDetailsModelFragment$1;-><init>(Lcom/bestbuy/android/activities/dnm/DNMDetailsModel$DNMDetailsModelFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 109
    return-object v2

    .line 93
    :cond_1
    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMDetailsModel$DNMDetailsModelFragment;->c:Ljava/lang/String;

    const v3, 0x7f080077

    invoke-virtual {p0, v3}, Lcom/bestbuy/android/activities/dnm/DNMDetailsModel$DNMDetailsModelFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 94
    const v1, 0x7f080078

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/dnm/DNMDetailsModel$DNMDetailsModelFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 95
    :cond_2
    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMDetailsModel$DNMDetailsModelFragment;->c:Ljava/lang/String;

    const v3, 0x7f080075

    invoke-virtual {p0, v3}, Lcom/bestbuy/android/activities/dnm/DNMDetailsModel$DNMDetailsModelFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 96
    const v1, 0x7f080076

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/dnm/DNMDetailsModel$DNMDetailsModelFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 98
    :cond_3
    const v1, 0x7f080037

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/dnm/DNMDetailsModel$DNMDetailsModelFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

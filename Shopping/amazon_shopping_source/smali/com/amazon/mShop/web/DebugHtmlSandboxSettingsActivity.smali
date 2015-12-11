.class public Lcom/amazon/mShop/web/DebugHtmlSandboxSettingsActivity;
.super Lcom/amazon/mShop/AmazonActivity;
.source "DebugHtmlSandboxSettingsActivity.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;-><init>()V

    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 20
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onCreate(Landroid/os/Bundle;)V

    .line 22
    invoke-static {p0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$layout;->html_sandbox_debug_settings:I

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 24
    .local v0, "content":Landroid/view/View;
    sget v2, Lcom/amazon/mShop/android/lib/R$id;->html_go_button:I

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    .line 25
    .local v1, "goButton":Landroid/widget/Button;
    new-instance v2, Lcom/amazon/mShop/web/DebugHtmlSandboxSettingsActivity$1;

    invoke-direct {v2, p0, v0}, Lcom/amazon/mShop/web/DebugHtmlSandboxSettingsActivity$1;-><init>(Lcom/amazon/mShop/web/DebugHtmlSandboxSettingsActivity;Landroid/view/View;)V

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 38
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/web/DebugHtmlSandboxSettingsActivity;->pushView(Landroid/view/View;)V

    .line 40
    return-void
.end method

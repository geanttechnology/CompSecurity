.class Lcom/amazon/mShop/web/DebugHtmlSandboxSettingsActivity$1;
.super Ljava/lang/Object;
.source "DebugHtmlSandboxSettingsActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/web/DebugHtmlSandboxSettingsActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/web/DebugHtmlSandboxSettingsActivity;

.field final synthetic val$content:Landroid/view/View;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/web/DebugHtmlSandboxSettingsActivity;Landroid/view/View;)V
    .locals 0

    .prologue
    .line 25
    iput-object p1, p0, Lcom/amazon/mShop/web/DebugHtmlSandboxSettingsActivity$1;->this$0:Lcom/amazon/mShop/web/DebugHtmlSandboxSettingsActivity;

    iput-object p2, p0, Lcom/amazon/mShop/web/DebugHtmlSandboxSettingsActivity$1;->val$content:Landroid/view/View;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 29
    iget-object v3, p0, Lcom/amazon/mShop/web/DebugHtmlSandboxSettingsActivity$1;->val$content:Landroid/view/View;

    sget v4, Lcom/amazon/mShop/android/lib/R$id;->html_sandbox_url:I

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    .line 30
    .local v0, "edit":Landroid/widget/EditText;
    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    .line 31
    .local v2, "url":Ljava/lang/String;
    new-instance v1, Landroid/content/Intent;

    iget-object v3, p0, Lcom/amazon/mShop/web/DebugHtmlSandboxSettingsActivity$1;->this$0:Lcom/amazon/mShop/web/DebugHtmlSandboxSettingsActivity;

    const-class v4, Lcom/amazon/mShop/web/MShopWebActivity;

    invoke-direct {v1, v3, v4}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 32
    .local v1, "intent":Landroid/content/Intent;
    invoke-static {}, Lcom/amazon/mobile/mash/constants/WebConstants;->getWebViewUrlKey()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 33
    iget-object v3, p0, Lcom/amazon/mShop/web/DebugHtmlSandboxSettingsActivity$1;->this$0:Lcom/amazon/mShop/web/DebugHtmlSandboxSettingsActivity;

    invoke-virtual {v3, v1}, Lcom/amazon/mShop/web/DebugHtmlSandboxSettingsActivity;->startActivity(Landroid/content/Intent;)V

    .line 34
    return-void
.end method

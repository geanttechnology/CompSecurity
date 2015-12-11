.class final Lcom/amazon/mShop/util/TextUtils$1;
.super Landroid/text/style/ClickableSpan;
.source "TextUtils.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/util/TextUtils;->makeLinkClickable(Landroid/text/SpannableStringBuilder;Landroid/text/style/URLSpan;Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$url:Ljava/lang/String;


# direct methods
.method constructor <init>(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 54
    iput-object p1, p0, Lcom/amazon/mShop/util/TextUtils$1;->val$url:Ljava/lang/String;

    invoke-direct {p0}, Landroid/text/style/ClickableSpan;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 56
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    .line 57
    .local v0, "context":Landroid/content/Context;
    const-class v2, Lcom/amazon/mShop/web/MShopWebActivity;

    iget-object v3, p0, Lcom/amazon/mShop/util/TextUtils$1;->val$url:Ljava/lang/String;

    const/4 v4, -0x1

    invoke-static {v0, v2, v3, v4}, Lcom/amazon/mShop/util/ActivityUtils;->getStartWebActivityIntent(Landroid/content/Context;Ljava/lang/Class;Ljava/lang/String;I)Landroid/content/Intent;

    move-result-object v1

    .line 58
    .local v1, "intent":Landroid/content/Intent;
    invoke-virtual {v0, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 59
    return-void
.end method

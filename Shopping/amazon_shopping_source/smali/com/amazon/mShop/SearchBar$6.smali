.class Lcom/amazon/mShop/SearchBar$6;
.super Ljava/lang/Object;
.source "SearchBar.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/SearchBar;->setupVoiceSearch()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/SearchBar;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/SearchBar;)V
    .locals 0

    .prologue
    .line 274
    iput-object p1, p0, Lcom/amazon/mShop/SearchBar$6;->this$0:Lcom/amazon/mShop/SearchBar;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 278
    if-eqz p1, :cond_0

    :try_start_0
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    instance-of v1, v1, Landroid/app/Activity;

    if-nez v1, :cond_1

    .line 279
    :cond_0
    # getter for: Lcom/amazon/mShop/SearchBar;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/SearchBar;->access$400()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "Invalid context"

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 287
    :goto_0
    return-void

    .line 283
    :cond_1
    invoke-static {}, Lcom/amazon/mShop/voice/MShopVoicePackageProxy;->getInstance()Lcom/amazon/mShop/voice/MShopVoicePackageProxy;

    move-result-object v2

    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    check-cast v1, Landroid/app/Activity;

    const/4 v3, 0x0

    invoke-virtual {v2, v1, v3}, Lcom/amazon/mShop/voice/MShopVoicePackageProxy;->openVoiceSearch(Landroid/app/Activity;Z)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 284
    :catch_0
    move-exception v0

    .line 285
    .local v0, "e":Ljava/lang/Exception;
    # getter for: Lcom/amazon/mShop/SearchBar;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/SearchBar;->access$400()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "Error"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

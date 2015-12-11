.class Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity$6;
.super Ljava/lang/Object;
.source "MShopWebDebugSettingsActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->getDebugSettingsEntryView()Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;)V
    .locals 0

    .prologue
    .line 130
    iput-object p1, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity$6;->this$0:Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 134
    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity$6;->this$0:Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;

    const-class v2, Lcom/amazon/mShop/social/SocialConnectDebugSettingsActivity;

    const/4 v3, -0x1

    invoke-static {v1, v2, v3}, Lcom/amazon/mShop/util/ActivityUtils;->getStartActivityIntent(Landroid/content/Context;Ljava/lang/Class;I)Landroid/content/Intent;

    move-result-object v0

    .line 136
    .local v0, "socialConnectSettingsIntent":Landroid/content/Intent;
    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity$6;->this$0:Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;

    invoke-virtual {v1, v0}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->startActivity(Landroid/content/Intent;)V

    .line 137
    return-void
.end method

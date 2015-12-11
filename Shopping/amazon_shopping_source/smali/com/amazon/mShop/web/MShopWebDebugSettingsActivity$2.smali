.class Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity$2;
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
    .line 91
    iput-object p1, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity$2;->this$0:Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 94
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity$2;->this$0:Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;

    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity$2;->this$0:Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;

    # invokes: Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->getHTMLFeatureEnvSettingsView()Landroid/view/View;
    invoke-static {v1}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->access$000(Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->pushView(Landroid/view/View;)V

    .line 95
    return-void
.end method

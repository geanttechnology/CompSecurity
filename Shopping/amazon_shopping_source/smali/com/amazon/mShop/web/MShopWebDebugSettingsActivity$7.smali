.class Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity$7;
.super Ljava/lang/Object;
.source "MShopWebDebugSettingsActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->getHTMLFeatureEnvSettingsView()Landroid/view/View;
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
    .line 208
    iput-object p1, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity$7;->this$0:Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 211
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity$7;->this$0:Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;

    # invokes: Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->recordEditedSettings()V
    invoke-static {v0}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->access$100(Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;)V

    .line 212
    invoke-static {}, Lcom/amazon/mShop/util/AppUtils;->restartApp()V

    .line 213
    return-void
.end method

.class Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity$3;
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
    .line 99
    iput-object p1, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity$3;->this$0:Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 103
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity$3;->this$0:Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;

    new-instance v1, Lcom/amazon/mShop/web/WeinreDebugSettingsView;

    iget-object v2, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity$3;->this$0:Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;

    const/4 v3, 0x0

    invoke-direct {v1, v2, v3}, Lcom/amazon/mShop/web/WeinreDebugSettingsView;-><init>(Lcom/amazon/mShop/AmazonActivity;Landroid/util/AttributeSet;)V

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->pushView(Landroid/view/View;)V

    .line 104
    return-void
.end method

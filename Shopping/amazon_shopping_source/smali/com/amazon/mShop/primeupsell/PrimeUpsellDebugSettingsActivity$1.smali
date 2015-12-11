.class Lcom/amazon/mShop/primeupsell/PrimeUpsellDebugSettingsActivity$1;
.super Ljava/lang/Object;
.source "PrimeUpsellDebugSettingsActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/primeupsell/PrimeUpsellDebugSettingsActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/primeupsell/PrimeUpsellDebugSettingsActivity;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/primeupsell/PrimeUpsellDebugSettingsActivity;)V
    .locals 0

    .prologue
    .line 53
    iput-object p1, p0, Lcom/amazon/mShop/primeupsell/PrimeUpsellDebugSettingsActivity$1;->this$0:Lcom/amazon/mShop/primeupsell/PrimeUpsellDebugSettingsActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 56
    iget-object v0, p0, Lcom/amazon/mShop/primeupsell/PrimeUpsellDebugSettingsActivity$1;->this$0:Lcom/amazon/mShop/primeupsell/PrimeUpsellDebugSettingsActivity;

    # invokes: Lcom/amazon/mShop/primeupsell/PrimeUpsellDebugSettingsActivity;->saveDebugSettings()V
    invoke-static {v0}, Lcom/amazon/mShop/primeupsell/PrimeUpsellDebugSettingsActivity;->access$000(Lcom/amazon/mShop/primeupsell/PrimeUpsellDebugSettingsActivity;)V

    .line 57
    iget-object v0, p0, Lcom/amazon/mShop/primeupsell/PrimeUpsellDebugSettingsActivity$1;->this$0:Lcom/amazon/mShop/primeupsell/PrimeUpsellDebugSettingsActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/primeupsell/PrimeUpsellDebugSettingsActivity;->finish()V

    .line 58
    return-void
.end method

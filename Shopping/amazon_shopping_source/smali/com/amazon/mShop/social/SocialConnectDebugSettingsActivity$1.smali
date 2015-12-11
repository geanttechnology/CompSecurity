.class Lcom/amazon/mShop/social/SocialConnectDebugSettingsActivity$1;
.super Ljava/lang/Object;
.source "SocialConnectDebugSettingsActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/social/SocialConnectDebugSettingsActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/social/SocialConnectDebugSettingsActivity;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/social/SocialConnectDebugSettingsActivity;)V
    .locals 0

    .prologue
    .line 49
    iput-object p1, p0, Lcom/amazon/mShop/social/SocialConnectDebugSettingsActivity$1;->this$0:Lcom/amazon/mShop/social/SocialConnectDebugSettingsActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 52
    iget-object v0, p0, Lcom/amazon/mShop/social/SocialConnectDebugSettingsActivity$1;->this$0:Lcom/amazon/mShop/social/SocialConnectDebugSettingsActivity;

    # invokes: Lcom/amazon/mShop/social/SocialConnectDebugSettingsActivity;->saveDebugSettings()V
    invoke-static {v0}, Lcom/amazon/mShop/social/SocialConnectDebugSettingsActivity;->access$000(Lcom/amazon/mShop/social/SocialConnectDebugSettingsActivity;)V

    .line 53
    iget-object v0, p0, Lcom/amazon/mShop/social/SocialConnectDebugSettingsActivity$1;->this$0:Lcom/amazon/mShop/social/SocialConnectDebugSettingsActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/social/SocialConnectDebugSettingsActivity;->finish()V

    .line 54
    return-void
.end method

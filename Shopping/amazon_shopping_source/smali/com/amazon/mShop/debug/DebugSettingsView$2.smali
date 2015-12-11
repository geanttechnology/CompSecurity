.class Lcom/amazon/mShop/debug/DebugSettingsView$2;
.super Ljava/lang/Object;
.source "DebugSettingsView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/debug/DebugSettingsView;-><init>(Lcom/amazon/mShop/debug/DebugSettingsActivity;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/debug/DebugSettingsView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/debug/DebugSettingsView;)V
    .locals 0

    .prologue
    .line 87
    iput-object p1, p0, Lcom/amazon/mShop/debug/DebugSettingsView$2;->this$0:Lcom/amazon/mShop/debug/DebugSettingsView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 90
    iget-object v1, p0, Lcom/amazon/mShop/debug/DebugSettingsView$2;->this$0:Lcom/amazon/mShop/debug/DebugSettingsView;

    # getter for: Lcom/amazon/mShop/debug/DebugSettingsView;->mLocaleOptionsSpinner:Landroid/widget/Spinner;
    invoke-static {v1}, Lcom/amazon/mShop/debug/DebugSettingsView;->access$100(Lcom/amazon/mShop/debug/DebugSettingsView;)Landroid/widget/Spinner;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/Spinner;->getSelectedItem()Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 91
    .local v0, "localeName":Ljava/lang/String;
    iget-object v1, p0, Lcom/amazon/mShop/debug/DebugSettingsView$2;->this$0:Lcom/amazon/mShop/debug/DebugSettingsView;

    invoke-virtual {v1, v0}, Lcom/amazon/mShop/debug/DebugSettingsView;->reloadDefaultUrlToDisplay(Ljava/lang/String;)V

    .line 92
    iget-object v1, p0, Lcom/amazon/mShop/debug/DebugSettingsView$2;->this$0:Lcom/amazon/mShop/debug/DebugSettingsView;

    iget-object v2, p0, Lcom/amazon/mShop/debug/DebugSettingsView$2;->this$0:Lcom/amazon/mShop/debug/DebugSettingsView;

    # getter for: Lcom/amazon/mShop/debug/DebugSettingsView;->mLocaleOptionsSpinner:Landroid/widget/Spinner;
    invoke-static {v2}, Lcom/amazon/mShop/debug/DebugSettingsView;->access$100(Lcom/amazon/mShop/debug/DebugSettingsView;)Landroid/widget/Spinner;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/Spinner;->getSelectedItem()Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/debug/DebugSettingsView;->recordEditedSettings(Ljava/lang/String;)V

    .line 93
    return-void
.end method

.class Lcom/amazon/mShop/debug/DebugSettingsView$LocaleSpinnerOnItemSelectedListener;
.super Ljava/lang/Object;
.source "DebugSettingsView.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemSelectedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/debug/DebugSettingsView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "LocaleSpinnerOnItemSelectedListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/debug/DebugSettingsView;


# direct methods
.method private constructor <init>(Lcom/amazon/mShop/debug/DebugSettingsView;)V
    .locals 0

    .prologue
    .line 266
    iput-object p1, p0, Lcom/amazon/mShop/debug/DebugSettingsView$LocaleSpinnerOnItemSelectedListener;->this$0:Lcom/amazon/mShop/debug/DebugSettingsView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/mShop/debug/DebugSettingsView;Lcom/amazon/mShop/debug/DebugSettingsView$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/mShop/debug/DebugSettingsView;
    .param p2, "x1"    # Lcom/amazon/mShop/debug/DebugSettingsView$1;

    .prologue
    .line 266
    invoke-direct {p0, p1}, Lcom/amazon/mShop/debug/DebugSettingsView$LocaleSpinnerOnItemSelectedListener;-><init>(Lcom/amazon/mShop/debug/DebugSettingsView;)V

    return-void
.end method


# virtual methods
.method public onItemSelected(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 2
    .param p2, "v"    # Landroid/view/View;
    .param p3, "pos"    # I
    .param p4, "row"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .line 270
    .local p1, "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    iget-object v0, p0, Lcom/amazon/mShop/debug/DebugSettingsView$LocaleSpinnerOnItemSelectedListener;->this$0:Lcom/amazon/mShop/debug/DebugSettingsView;

    iget-object v1, p0, Lcom/amazon/mShop/debug/DebugSettingsView$LocaleSpinnerOnItemSelectedListener;->this$0:Lcom/amazon/mShop/debug/DebugSettingsView;

    # getter for: Lcom/amazon/mShop/debug/DebugSettingsView;->mSelectedLocaleName:Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/debug/DebugSettingsView;->access$200(Lcom/amazon/mShop/debug/DebugSettingsView;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/debug/DebugSettingsView;->recordEditedSettings(Ljava/lang/String;)V

    .line 271
    iget-object v0, p0, Lcom/amazon/mShop/debug/DebugSettingsView$LocaleSpinnerOnItemSelectedListener;->this$0:Lcom/amazon/mShop/debug/DebugSettingsView;

    invoke-virtual {p1, p3}, Landroid/widget/AdapterView;->getItemAtPosition(I)Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    # setter for: Lcom/amazon/mShop/debug/DebugSettingsView;->mSelectedLocaleName:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/amazon/mShop/debug/DebugSettingsView;->access$202(Lcom/amazon/mShop/debug/DebugSettingsView;Ljava/lang/String;)Ljava/lang/String;

    .line 272
    iget-object v0, p0, Lcom/amazon/mShop/debug/DebugSettingsView$LocaleSpinnerOnItemSelectedListener;->this$0:Lcom/amazon/mShop/debug/DebugSettingsView;

    iget-object v1, p0, Lcom/amazon/mShop/debug/DebugSettingsView$LocaleSpinnerOnItemSelectedListener;->this$0:Lcom/amazon/mShop/debug/DebugSettingsView;

    # getter for: Lcom/amazon/mShop/debug/DebugSettingsView;->mSelectedLocaleName:Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/debug/DebugSettingsView;->access$200(Lcom/amazon/mShop/debug/DebugSettingsView;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/debug/DebugSettingsView;->loadToDisplay(Ljava/lang/String;)V

    .line 273
    return-void
.end method

.method public onNothingSelected(Landroid/widget/AdapterView;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 278
    .local p1, "arg0":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    return-void
.end method

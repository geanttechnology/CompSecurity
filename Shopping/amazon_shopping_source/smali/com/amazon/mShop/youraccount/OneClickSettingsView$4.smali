.class Lcom/amazon/mShop/youraccount/OneClickSettingsView$4;
.super Ljava/lang/Object;
.source "OneClickSettingsView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/youraccount/OneClickSettingsView;-><init>(Lcom/amazon/mShop/AmazonActivity;Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/youraccount/OneClickSettingsView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/youraccount/OneClickSettingsView;)V
    .locals 0

    .prologue
    .line 156
    iput-object p1, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView$4;->this$0:Lcom/amazon/mShop/youraccount/OneClickSettingsView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 159
    iget-object v0, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView$4;->this$0:Lcom/amazon/mShop/youraccount/OneClickSettingsView;

    # invokes: Lcom/amazon/mShop/youraccount/OneClickSettingsView;->performAboutOneClick()V
    invoke-static {v0}, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->access$400(Lcom/amazon/mShop/youraccount/OneClickSettingsView;)V

    .line 160
    return-void
.end method

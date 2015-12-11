.class Lcom/amazon/mShop/youraccount/OneClickSettingsView$5;
.super Ljava/lang/Object;
.source "OneClickSettingsView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/youraccount/OneClickSettingsView;-><init>(Lcom/amazon/mShop/AmazonActivity;ZZ)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/youraccount/OneClickSettingsView;

.field final synthetic val$amazonActivity:Lcom/amazon/mShop/AmazonActivity;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/youraccount/OneClickSettingsView;Lcom/amazon/mShop/AmazonActivity;)V
    .locals 0

    .prologue
    .line 187
    iput-object p1, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView$5;->this$0:Lcom/amazon/mShop/youraccount/OneClickSettingsView;

    iput-object p2, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView$5;->val$amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 191
    iget-object v0, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView$5;->val$amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-static {v0}, Lcom/amazon/mShop/util/ActivityUtils;->startHomeActivity(Landroid/content/Context;)Z

    .line 192
    return-void
.end method

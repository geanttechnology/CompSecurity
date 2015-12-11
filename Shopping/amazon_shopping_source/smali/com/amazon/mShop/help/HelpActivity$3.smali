.class Lcom/amazon/mShop/help/HelpActivity$3;
.super Ljava/lang/Object;
.source "HelpActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/help/HelpActivity;->getRootView()Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/help/HelpActivity;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/help/HelpActivity;)V
    .locals 0

    .prologue
    .line 249
    iput-object p1, p0, Lcom/amazon/mShop/help/HelpActivity$3;->this$0:Lcom/amazon/mShop/help/HelpActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 253
    iget-object v0, p0, Lcom/amazon/mShop/help/HelpActivity$3;->this$0:Lcom/amazon/mShop/help/HelpActivity;

    invoke-static {v0}, Lcom/amazon/mShop/util/ActivityUtils;->startContactUsActivity(Landroid/content/Context;)Z

    .line 254
    return-void
.end method

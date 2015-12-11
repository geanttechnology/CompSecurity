.class Lcom/amazon/mShop/mash/AmazonMASHTestActivity$MASHTestView$1;
.super Ljava/lang/Object;
.source "AmazonMASHTestActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/mash/AmazonMASHTestActivity$MASHTestView;-><init>(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;Lcom/amazon/mShop/mash/AmazonMASHTestActivity;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/mash/AmazonMASHTestActivity$MASHTestView;

.field final synthetic val$this$0:Lcom/amazon/mShop/mash/AmazonMASHTestActivity;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/mash/AmazonMASHTestActivity$MASHTestView;Lcom/amazon/mShop/mash/AmazonMASHTestActivity;)V
    .locals 0

    .prologue
    .line 118
    iput-object p1, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity$MASHTestView$1;->this$1:Lcom/amazon/mShop/mash/AmazonMASHTestActivity$MASHTestView;

    iput-object p2, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity$MASHTestView$1;->val$this$0:Lcom/amazon/mShop/mash/AmazonMASHTestActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 121
    iget-object v0, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity$MASHTestView$1;->this$1:Lcom/amazon/mShop/mash/AmazonMASHTestActivity$MASHTestView;

    iget-object v1, p0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity$MASHTestView$1;->this$1:Lcom/amazon/mShop/mash/AmazonMASHTestActivity$MASHTestView;

    iget-object v1, v1, Lcom/amazon/mShop/mash/AmazonMASHTestActivity$MASHTestView;->this$0:Lcom/amazon/mShop/mash/AmazonMASHTestActivity;

    # getter for: Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->mashTestHomeUrl:Landroid/widget/EditText;
    invoke-static {v1}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;->access$1400(Lcom/amazon/mShop/mash/AmazonMASHTestActivity;)Landroid/widget/EditText;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    # invokes: Lcom/amazon/mShop/mash/AmazonMASHTestActivity$MASHTestView;->startMASHTestActivity(Ljava/lang/String;)V
    invoke-static {v0, v1}, Lcom/amazon/mShop/mash/AmazonMASHTestActivity$MASHTestView;->access$1600(Lcom/amazon/mShop/mash/AmazonMASHTestActivity$MASHTestView;Ljava/lang/String;)V

    .line 122
    return-void
.end method

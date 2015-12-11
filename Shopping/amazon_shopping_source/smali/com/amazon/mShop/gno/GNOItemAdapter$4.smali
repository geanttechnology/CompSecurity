.class Lcom/amazon/mShop/gno/GNOItemAdapter$4;
.super Ljava/lang/Object;
.source "GNOItemAdapter.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/gno/GNOItemAdapter;->expandGroup(Ljava/lang/String;Z)Z
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/gno/GNOItemAdapter;

.field final synthetic val$activity:Lcom/amazon/mShop/AmazonActivity;

.field final synthetic val$shouldShowExpandingArea:Z


# direct methods
.method constructor <init>(Lcom/amazon/mShop/gno/GNOItemAdapter;ZLcom/amazon/mShop/AmazonActivity;)V
    .locals 0

    .prologue
    .line 328
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNOItemAdapter$4;->this$0:Lcom/amazon/mShop/gno/GNOItemAdapter;

    iput-boolean p2, p0, Lcom/amazon/mShop/gno/GNOItemAdapter$4;->val$shouldShowExpandingArea:Z

    iput-object p3, p0, Lcom/amazon/mShop/gno/GNOItemAdapter$4;->val$activity:Lcom/amazon/mShop/AmazonActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 334
    iget-boolean v0, p0, Lcom/amazon/mShop/gno/GNOItemAdapter$4;->val$shouldShowExpandingArea:Z

    if-eqz v0, :cond_0

    .line 335
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOItemAdapter$4;->val$activity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonActivity;->getGNODrawer()Lcom/amazon/mShop/gno/GNODrawer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/gno/GNODrawer;->getListView()Landroid/widget/ListView;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setTranscriptMode(I)V

    .line 337
    :cond_0
    return-void
.end method

.class Lcom/amazon/mShop/history/HistoryView$2;
.super Ljava/lang/Object;
.source "HistoryView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/history/HistoryView;-><init>(Landroid/content/Context;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/history/HistoryView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/history/HistoryView;)V
    .locals 0

    .prologue
    .line 95
    iput-object p1, p0, Lcom/amazon/mShop/history/HistoryView$2;->this$0:Lcom/amazon/mShop/history/HistoryView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 98
    iget-object v0, p0, Lcom/amazon/mShop/history/HistoryView$2;->this$0:Lcom/amazon/mShop/history/HistoryView;

    invoke-virtual {v0}, Lcom/amazon/mShop/history/HistoryView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/ActivityUtils;->startCategoryBrowseActivity(Landroid/content/Context;)Z

    .line 99
    return-void
.end method

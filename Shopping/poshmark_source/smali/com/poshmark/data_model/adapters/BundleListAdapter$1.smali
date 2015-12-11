.class Lcom/poshmark/data_model/adapters/BundleListAdapter$1;
.super Ljava/lang/Object;
.source "BundleListAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/data_model/adapters/BundleListAdapter;->bindView(Landroid/view/View;Landroid/content/Context;Landroid/database/Cursor;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/data_model/adapters/BundleListAdapter;


# direct methods
.method constructor <init>(Lcom/poshmark/data_model/adapters/BundleListAdapter;)V
    .locals 0

    .prologue
    .line 96
    iput-object p1, p0, Lcom/poshmark/data_model/adapters/BundleListAdapter$1;->this$0:Lcom/poshmark/data_model/adapters/BundleListAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 99
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 100
    .local v0, "position":Ljava/lang/Integer;
    iget-object v1, p0, Lcom/poshmark/data_model/adapters/BundleListAdapter$1;->this$0:Lcom/poshmark/data_model/adapters/BundleListAdapter;

    iget-object v1, v1, Lcom/poshmark/data_model/adapters/BundleListAdapter;->removeItemListener:Lcom/poshmark/utils/BundleItemRemoveClickListener;

    if-eqz v1, :cond_0

    .line 101
    iget-object v1, p0, Lcom/poshmark/data_model/adapters/BundleListAdapter$1;->this$0:Lcom/poshmark/data_model/adapters/BundleListAdapter;

    iget-object v1, v1, Lcom/poshmark/data_model/adapters/BundleListAdapter;->removeItemListener:Lcom/poshmark/utils/BundleItemRemoveClickListener;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v2

    invoke-interface {v1, v2}, Lcom/poshmark/utils/BundleItemRemoveClickListener;->removeItemFromBundle(I)V

    .line 103
    :cond_0
    return-void
.end method

.class Lcom/poshmark/ui/fragments/MetaItemListViewFragment$1;
.super Ljava/lang/Object;
.source "MetaItemListViewFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->setupActionBar()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/MetaItemListViewFragment;)V
    .locals 0

    .prologue
    .line 139
    iput-object p1, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$1;->this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 142
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$1;->this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->multiSelectList:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 143
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$1;->this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->returnData()V

    .line 145
    :cond_0
    return-void
.end method

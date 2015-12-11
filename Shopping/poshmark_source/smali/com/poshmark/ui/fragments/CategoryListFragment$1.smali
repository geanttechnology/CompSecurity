.class Lcom/poshmark/ui/fragments/CategoryListFragment$1;
.super Ljava/lang/Object;
.source "CategoryListFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/CategoryListFragment;->setupActionBar()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/CategoryListFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/CategoryListFragment;)V
    .locals 0

    .prologue
    .line 109
    iput-object p1, p0, Lcom/poshmark/ui/fragments/CategoryListFragment$1;->this$0:Lcom/poshmark/ui/fragments/CategoryListFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 112
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CategoryListFragment$1;->this$0:Lcom/poshmark/ui/fragments/CategoryListFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/CategoryListFragment;->returnData()V

    .line 113
    return-void
.end method

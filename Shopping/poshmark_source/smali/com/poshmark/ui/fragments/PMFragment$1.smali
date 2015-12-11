.class Lcom/poshmark/ui/fragments/PMFragment$1;
.super Ljava/lang/Object;
.source "PMFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/PMFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/PMFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/PMFragment;)V
    .locals 0

    .prologue
    .line 687
    iput-object p1, p0, Lcom/poshmark/ui/fragments/PMFragment$1;->this$0:Lcom/poshmark/ui/fragments/PMFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 690
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PMFragment$1;->this$0:Lcom/poshmark/ui/fragments/PMFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMContainerActivity;

    .line 691
    .local v0, "parent":Lcom/poshmark/ui/PMContainerActivity;
    invoke-virtual {v0}, Lcom/poshmark/ui/PMContainerActivity;->toggleDrawer()V

    .line 692
    return-void
.end method

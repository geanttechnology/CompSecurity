.class Lcom/poshmark/ui/fragments/NewFeedFragment$5;
.super Ljava/lang/Object;
.source "NewFeedFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/NewFeedFragment;->setupActionBar()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/NewFeedFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/NewFeedFragment;)V
    .locals 0

    .prologue
    .line 164
    iput-object p1, p0, Lcom/poshmark/ui/fragments/NewFeedFragment$5;->this$0:Lcom/poshmark/ui/fragments/NewFeedFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 167
    iget-object v0, p0, Lcom/poshmark/ui/fragments/NewFeedFragment$5;->this$0:Lcom/poshmark/ui/fragments/NewFeedFragment;

    # invokes: Lcom/poshmark/ui/fragments/NewFeedFragment;->showFindPeopleFragment()V
    invoke-static {v0}, Lcom/poshmark/ui/fragments/NewFeedFragment;->access$100(Lcom/poshmark/ui/fragments/NewFeedFragment;)V

    .line 168
    return-void
.end method

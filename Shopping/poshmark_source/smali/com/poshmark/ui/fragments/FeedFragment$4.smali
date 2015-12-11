.class Lcom/poshmark/ui/fragments/FeedFragment$4;
.super Ljava/lang/Object;
.source "FeedFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/FeedFragment;->setupActionBar()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/FeedFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/FeedFragment;)V
    .locals 0

    .prologue
    .line 126
    iput-object p1, p0, Lcom/poshmark/ui/fragments/FeedFragment$4;->this$0:Lcom/poshmark/ui/fragments/FeedFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 129
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedFragment$4;->this$0:Lcom/poshmark/ui/fragments/FeedFragment;

    # invokes: Lcom/poshmark/ui/fragments/FeedFragment;->showFindPeopleFragment()V
    invoke-static {v0}, Lcom/poshmark/ui/fragments/FeedFragment;->access$100(Lcom/poshmark/ui/fragments/FeedFragment;)V

    .line 130
    return-void
.end method

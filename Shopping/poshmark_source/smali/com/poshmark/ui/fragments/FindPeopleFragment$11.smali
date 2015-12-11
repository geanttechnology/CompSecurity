.class Lcom/poshmark/ui/fragments/FindPeopleFragment$11;
.super Ljava/lang/Object;
.source "FindPeopleFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/FindPeopleFragment;->setupHeaderView()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/FindPeopleFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/FindPeopleFragment;)V
    .locals 0

    .prologue
    .line 366
    iput-object p1, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment$11;->this$0:Lcom/poshmark/ui/fragments/FindPeopleFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 369
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment$11;->this$0:Lcom/poshmark/ui/fragments/FindPeopleFragment;

    # invokes: Lcom/poshmark/ui/fragments/FindPeopleFragment;->showTwitterFriends()V
    invoke-static {v0}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->access$200(Lcom/poshmark/ui/fragments/FindPeopleFragment;)V

    .line 370
    return-void
.end method

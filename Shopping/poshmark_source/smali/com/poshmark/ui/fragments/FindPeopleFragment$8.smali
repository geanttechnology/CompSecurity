.class Lcom/poshmark/ui/fragments/FindPeopleFragment$8;
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
    .line 331
    iput-object p1, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment$8;->this$0:Lcom/poshmark/ui/fragments/FindPeopleFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 334
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment$8;->this$0:Lcom/poshmark/ui/fragments/FindPeopleFragment;

    # getter for: Lcom/poshmark/ui/fragments/FindPeopleFragment;->searchEditText:Lcom/poshmark/ui/customviews/PMEditText;
    invoke-static {v0}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->access$400(Lcom/poshmark/ui/fragments/FindPeopleFragment;)Lcom/poshmark/ui/customviews/PMEditText;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMEditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_0

    .line 335
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment$8;->this$0:Lcom/poshmark/ui/fragments/FindPeopleFragment;

    # getter for: Lcom/poshmark/ui/fragments/FindPeopleFragment;->searchEditText:Lcom/poshmark/ui/customviews/PMEditText;
    invoke-static {v0}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->access$400(Lcom/poshmark/ui/fragments/FindPeopleFragment;)Lcom/poshmark/ui/customviews/PMEditText;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMEditText;->requestFocus()Z

    .line 336
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment$8;->this$0:Lcom/poshmark/ui/fragments/FindPeopleFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->showKeyboard()V

    .line 341
    :goto_0
    return-void

    .line 338
    :cond_0
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment$8;->this$0:Lcom/poshmark/ui/fragments/FindPeopleFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->hideKeyboard()V

    .line 339
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment$8;->this$0:Lcom/poshmark/ui/fragments/FindPeopleFragment;

    # invokes: Lcom/poshmark/ui/fragments/FindPeopleFragment;->findUsers()V
    invoke-static {v0}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->access$500(Lcom/poshmark/ui/fragments/FindPeopleFragment;)V

    goto :goto_0
.end method

.class Lcom/poshmark/ui/fragments/FindPeopleFragment$7;
.super Ljava/lang/Object;
.source "FindPeopleFragment.java"

# interfaces
.implements Landroid/view/View$OnKeyListener;


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
    .line 318
    iput-object p1, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment$7;->this$0:Lcom/poshmark/ui/fragments/FindPeopleFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onKey(Landroid/view/View;ILandroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "view"    # Landroid/view/View;
    .param p2, "i"    # I
    .param p3, "keyEvent"    # Landroid/view/KeyEvent;

    .prologue
    .line 321
    invoke-virtual {p3}, Landroid/view/KeyEvent;->getAction()I

    move-result v0

    if-nez v0, :cond_2

    const/16 v0, 0x54

    if-eq p2, v0, :cond_0

    const/16 v0, 0x42

    if-ne p2, v0, :cond_2

    .line 322
    :cond_0
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment$7;->this$0:Lcom/poshmark/ui/fragments/FindPeopleFragment;

    # getter for: Lcom/poshmark/ui/fragments/FindPeopleFragment;->searchEditText:Lcom/poshmark/ui/customviews/PMEditText;
    invoke-static {v0}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->access$400(Lcom/poshmark/ui/fragments/FindPeopleFragment;)Lcom/poshmark/ui/customviews/PMEditText;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMEditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_1

    .line 323
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FindPeopleFragment$7;->this$0:Lcom/poshmark/ui/fragments/FindPeopleFragment;

    # invokes: Lcom/poshmark/ui/fragments/FindPeopleFragment;->findUsers()V
    invoke-static {v0}, Lcom/poshmark/ui/fragments/FindPeopleFragment;->access$500(Lcom/poshmark/ui/fragments/FindPeopleFragment;)V

    .line 325
    :cond_1
    const/4 v0, 0x1

    .line 327
    :goto_0
    return v0

    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method

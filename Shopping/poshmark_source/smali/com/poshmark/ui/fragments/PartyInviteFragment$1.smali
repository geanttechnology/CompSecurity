.class Lcom/poshmark/ui/fragments/PartyInviteFragment$1;
.super Ljava/lang/Object;
.source "PartyInviteFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/PartyInviteFragment;->setupView(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/PartyInviteFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/PartyInviteFragment;)V
    .locals 0

    .prologue
    .line 111
    iput-object p1, p0, Lcom/poshmark/ui/fragments/PartyInviteFragment$1;->this$0:Lcom/poshmark/ui/fragments/PartyInviteFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 114
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyInviteFragment$1;->this$0:Lcom/poshmark/ui/fragments/PartyInviteFragment;

    # invokes: Lcom/poshmark/ui/fragments/PartyInviteFragment;->showPartyGuidelines()V
    invoke-static {v0}, Lcom/poshmark/ui/fragments/PartyInviteFragment;->access$000(Lcom/poshmark/ui/fragments/PartyInviteFragment;)V

    .line 115
    return-void
.end method

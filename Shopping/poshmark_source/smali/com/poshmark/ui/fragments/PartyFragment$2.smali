.class Lcom/poshmark/ui/fragments/PartyFragment$2;
.super Ljava/lang/Object;
.source "PartyFragment.java"

# interfaces
.implements Lcom/poshmark/ui/customviews/PMListView$LoadMoreItemsListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/PartyFragment;->setupListView()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/PartyFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/PartyFragment;)V
    .locals 0

    .prologue
    .line 180
    iput-object p1, p0, Lcom/poshmark/ui/fragments/PartyFragment$2;->this$0:Lcom/poshmark/ui/fragments/PartyFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public loadItems(Z)V
    .locals 1
    .param p1, "isPagination"    # Z

    .prologue
    .line 183
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment$2;->this$0:Lcom/poshmark/ui/fragments/PartyFragment;

    # invokes: Lcom/poshmark/ui/fragments/PartyFragment;->getPartyListings(Z)V
    invoke-static {v0, p1}, Lcom/poshmark/ui/fragments/PartyFragment;->access$000(Lcom/poshmark/ui/fragments/PartyFragment;Z)V

    .line 184
    return-void
.end method

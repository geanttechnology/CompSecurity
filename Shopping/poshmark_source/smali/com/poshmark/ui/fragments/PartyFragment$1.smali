.class Lcom/poshmark/ui/fragments/PartyFragment$1;
.super Ljava/lang/Object;
.source "PartyFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/PartyFragment;->setupActionBar()V
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
    .line 153
    iput-object p1, p0, Lcom/poshmark/ui/fragments/PartyFragment$1;->this$0:Lcom/poshmark/ui/fragments/PartyFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 156
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/PartyFragment$1;->this$0:Lcom/poshmark/ui/fragments/PartyFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/PartyFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v2, "party"

    const-string v3, "refresh_party_clicked"

    const/4 v4, 0x0

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 157
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment$1;->this$0:Lcom/poshmark/ui/fragments/PartyFragment;

    const/4 v1, 0x0

    # invokes: Lcom/poshmark/ui/fragments/PartyFragment;->getPartyListings(Z)V
    invoke-static {v0, v1}, Lcom/poshmark/ui/fragments/PartyFragment;->access$000(Lcom/poshmark/ui/fragments/PartyFragment;Z)V

    .line 158
    return-void
.end method

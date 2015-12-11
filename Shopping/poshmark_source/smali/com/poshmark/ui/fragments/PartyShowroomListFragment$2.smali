.class Lcom/poshmark/ui/fragments/PartyShowroomListFragment$2;
.super Ljava/lang/Object;
.source "PartyShowroomListFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->updateHeaderView()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/PartyShowroomListFragment;

.field final synthetic val$hostUserId:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/PartyShowroomListFragment;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 141
    iput-object p1, p0, Lcom/poshmark/ui/fragments/PartyShowroomListFragment$2;->this$0:Lcom/poshmark/ui/fragments/PartyShowroomListFragment;

    iput-object p2, p0, Lcom/poshmark/ui/fragments/PartyShowroomListFragment$2;->val$hostUserId:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 145
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 146
    .local v0, "b":Landroid/os/Bundle;
    const-string v2, "NAME"

    iget-object v3, p0, Lcom/poshmark/ui/fragments/PartyShowroomListFragment$2;->val$hostUserId:Ljava/lang/String;

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 147
    iget-object v2, p0, Lcom/poshmark/ui/fragments/PartyShowroomListFragment$2;->this$0:Lcom/poshmark/ui/fragments/PartyShowroomListFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/PMActivity;

    .line 148
    .local v1, "parentActivity":Lcom/poshmark/ui/PMActivity;
    const-class v2, Lcom/poshmark/ui/fragments/ClosetFragment;

    const/4 v3, 0x0

    invoke-virtual {v1, v0, v2, v3}, Lcom/poshmark/ui/PMActivity;->launchFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 150
    iget-object v2, p0, Lcom/poshmark/ui/fragments/PartyShowroomListFragment$2;->this$0:Lcom/poshmark/ui/fragments/PartyShowroomListFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/PartyShowroomListFragment;->dismiss()V

    .line 151
    return-void
.end method

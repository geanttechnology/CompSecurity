.class Lcom/poshmark/data_model/adapters/HetroFeedListAdapter$5;
.super Ljava/lang/Object;
.source "HetroFeedListAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;


# direct methods
.method constructor <init>(Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;)V
    .locals 0

    .prologue
    .line 148
    iput-object p1, p0, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter$5;->this$0:Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 151
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/ListingSocial;

    .line 153
    .local v1, "feedItem":Lcom/poshmark/data_model/models/ListingSocial;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 154
    .local v0, "b":Landroid/os/Bundle;
    const-string v3, "MODE"

    sget-object v4, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->LIKES_MODE:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    invoke-virtual {v4}, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->name()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 155
    const-string v3, "ID"

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/ListingSocial;->getIdAsString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 157
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/PMActivity;

    .line 158
    .local v2, "parentActivity":Lcom/poshmark/ui/PMActivity;
    const-class v3, Lcom/poshmark/ui/fragments/UserListFragment;

    const/4 v4, 0x0

    invoke-virtual {v2, v0, v3, v4}, Lcom/poshmark/ui/PMActivity;->launchFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 160
    return-void
.end method

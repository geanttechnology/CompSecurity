.class Lcom/poshmark/data_model/adapters/FindPeopleAdapter$1;
.super Ljava/lang/Object;
.source "FindPeopleAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/adapters/FindPeopleAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/data_model/adapters/FindPeopleAdapter;


# direct methods
.method constructor <init>(Lcom/poshmark/data_model/adapters/FindPeopleAdapter;)V
    .locals 0

    .prologue
    .line 28
    iput-object p1, p0, Lcom/poshmark/data_model/adapters/FindPeopleAdapter$1;->this$0:Lcom/poshmark/data_model/adapters/FindPeopleAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 31
    move-object v0, p1

    check-cast v0, Landroid/widget/Button;

    .line 32
    .local v0, "btn":Landroid/widget/Button;
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/inner_models/UserReference;

    .line 33
    .local v1, "userReference":Lcom/poshmark/data_model/models/inner_models/UserReference;
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/UserReference;->isCallerFollowing()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 34
    iget-object v2, p0, Lcom/poshmark/data_model/adapters/FindPeopleAdapter$1;->this$0:Lcom/poshmark/data_model/adapters/FindPeopleAdapter;

    iget-object v2, v2, Lcom/poshmark/data_model/adapters/FindPeopleAdapter;->context:Landroid/content/Context;

    invoke-static {v2, v0}, Lcom/poshmark/utils/FollowFollowingHelper;->setFollowButton(Landroid/content/Context;Landroid/widget/Button;)V

    .line 35
    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/poshmark/data_model/models/inner_models/UserReference;->setCallerFollowing(Z)V

    .line 36
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/UserReference;->getUserId()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/poshmark/utils/FollowFollowingHelper;->fireUnfollowCall(Ljava/lang/String;)V

    .line 43
    :goto_0
    return-void

    .line 39
    :cond_0
    iget-object v2, p0, Lcom/poshmark/data_model/adapters/FindPeopleAdapter$1;->this$0:Lcom/poshmark/data_model/adapters/FindPeopleAdapter;

    iget-object v2, v2, Lcom/poshmark/data_model/adapters/FindPeopleAdapter;->context:Landroid/content/Context;

    invoke-static {v2, v0}, Lcom/poshmark/utils/FollowFollowingHelper;->setFollowingButton(Landroid/content/Context;Landroid/widget/Button;)V

    .line 40
    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lcom/poshmark/data_model/models/inner_models/UserReference;->setCallerFollowing(Z)V

    .line 41
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/UserReference;->getUserId()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/poshmark/utils/FollowFollowingHelper;->fireFollowCall(Ljava/lang/String;)V

    goto :goto_0
.end method

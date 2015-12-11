.class Lio/branch/referral/ShareLinkManager$1;
.super Ljava/lang/Object;
.source "ShareLinkManager.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/branch/referral/ShareLinkManager;->createShareDialog(Ljava/util/List;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lio/branch/referral/ShareLinkManager;

.field final synthetic val$adapter:Lio/branch/referral/ShareLinkManager$ChooserArrayAdapter;

.field final synthetic val$matchingApps:Ljava/util/List;


# direct methods
.method constructor <init>(Lio/branch/referral/ShareLinkManager;Ljava/util/List;Lio/branch/referral/ShareLinkManager$ChooserArrayAdapter;)V
    .locals 0

    .prologue
    .line 150
    iput-object p1, p0, Lio/branch/referral/ShareLinkManager$1;->this$0:Lio/branch/referral/ShareLinkManager;

    iput-object p2, p0, Lio/branch/referral/ShareLinkManager$1;->val$matchingApps:Ljava/util/List;

    iput-object p3, p0, Lio/branch/referral/ShareLinkManager$1;->val$adapter:Lio/branch/referral/ShareLinkManager$ChooserArrayAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 3
    .param p2, "view"    # Landroid/view/View;
    .param p3, "pos"    # I
    .param p4, "l"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .line 153
    .local p1, "adapterView":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    instance-of v0, v0, Lio/branch/referral/ShareLinkManager$MoreShareItem;

    if-eqz v0, :cond_1

    .line 154
    iget-object v0, p0, Lio/branch/referral/ShareLinkManager$1;->this$0:Lio/branch/referral/ShareLinkManager;

    iget-object v1, p0, Lio/branch/referral/ShareLinkManager$1;->val$matchingApps:Ljava/util/List;

    # setter for: Lio/branch/referral/ShareLinkManager;->appList_:Ljava/util/List;
    invoke-static {v0, v1}, Lio/branch/referral/ShareLinkManager;->access$302(Lio/branch/referral/ShareLinkManager;Ljava/util/List;)Ljava/util/List;

    .line 155
    iget-object v0, p0, Lio/branch/referral/ShareLinkManager$1;->val$adapter:Lio/branch/referral/ShareLinkManager$ChooserArrayAdapter;

    invoke-virtual {v0}, Lio/branch/referral/ShareLinkManager$ChooserArrayAdapter;->notifyDataSetChanged()V

    .line 167
    :cond_0
    :goto_0
    return-void

    .line 157
    :cond_1
    iget-object v0, p0, Lio/branch/referral/ShareLinkManager$1;->this$0:Lio/branch/referral/ShareLinkManager;

    iget-object v0, v0, Lio/branch/referral/ShareLinkManager;->callback_:Lio/branch/referral/Branch$BranchLinkShareListener;

    if-eqz v0, :cond_2

    .line 158
    iget-object v0, p0, Lio/branch/referral/ShareLinkManager$1;->this$0:Lio/branch/referral/ShareLinkManager;

    iget-object v1, v0, Lio/branch/referral/ShareLinkManager;->callback_:Lio/branch/referral/Branch$BranchLinkShareListener;

    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/pm/ResolveInfo;

    iget-object v2, p0, Lio/branch/referral/ShareLinkManager$1;->this$0:Lio/branch/referral/ShareLinkManager;

    iget-object v2, v2, Lio/branch/referral/ShareLinkManager;->context_:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/content/pm/ResolveInfo;->loadLabel(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;

    move-result-object v0

    invoke-interface {v0}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v1, v0}, Lio/branch/referral/Branch$BranchLinkShareListener;->onChannelSelected(Ljava/lang/String;)V

    .line 160
    :cond_2
    iget-object v0, p0, Lio/branch/referral/ShareLinkManager$1;->val$adapter:Lio/branch/referral/ShareLinkManager$ChooserArrayAdapter;

    iput p3, v0, Lio/branch/referral/ShareLinkManager$ChooserArrayAdapter;->selectedPos:I

    .line 161
    iget-object v0, p0, Lio/branch/referral/ShareLinkManager$1;->val$adapter:Lio/branch/referral/ShareLinkManager$ChooserArrayAdapter;

    invoke-virtual {v0}, Lio/branch/referral/ShareLinkManager$ChooserArrayAdapter;->notifyDataSetChanged()V

    .line 162
    iget-object v1, p0, Lio/branch/referral/ShareLinkManager$1;->this$0:Lio/branch/referral/ShareLinkManager;

    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/pm/ResolveInfo;

    # invokes: Lio/branch/referral/ShareLinkManager;->invokeSharingClient(Landroid/content/pm/ResolveInfo;)V
    invoke-static {v1, v0}, Lio/branch/referral/ShareLinkManager;->access$400(Lio/branch/referral/ShareLinkManager;Landroid/content/pm/ResolveInfo;)V

    .line 163
    iget-object v0, p0, Lio/branch/referral/ShareLinkManager$1;->this$0:Lio/branch/referral/ShareLinkManager;

    iget-object v0, v0, Lio/branch/referral/ShareLinkManager;->shareDlg_:Lio/branch/referral/AnimatedDialog;

    if-eqz v0, :cond_0

    .line 164
    iget-object v0, p0, Lio/branch/referral/ShareLinkManager$1;->this$0:Lio/branch/referral/ShareLinkManager;

    iget-object v0, v0, Lio/branch/referral/ShareLinkManager;->shareDlg_:Lio/branch/referral/AnimatedDialog;

    invoke-virtual {v0}, Lio/branch/referral/AnimatedDialog;->cancel()V

    goto :goto_0
.end method

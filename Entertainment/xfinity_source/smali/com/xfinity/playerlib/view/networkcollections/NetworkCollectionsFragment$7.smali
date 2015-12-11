.class Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$7;
.super Ljava/lang/Object;
.source "NetworkCollectionsFragment.java"

# interfaces
.implements Lit/sephiroth/android/library/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->getOnItemClickListener()Lit/sephiroth/android/library/widget/AdapterView$OnItemClickListener;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    .prologue
    .line 357
    iput-object p1, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$7;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Lit/sephiroth/android/library/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 6
    .param p2, "view"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lit/sephiroth/android/library/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .line 361
    .local p1, "adapter":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<*>;"
    invoke-virtual {p1, p3}, Lit/sephiroth/android/library/widget/AdapterView;->getItemAtPosition(I)Ljava/lang/Object;

    move-result-object v2

    invoke-static {v2}, Lcom/comcast/cim/cmasl/utils/CommonUtils;->uncheckedCast(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    .line 363
    .local v1, "program":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    new-instance v2, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    invoke-direct {v2, v1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;-><init>(Lcom/xfinity/playerlib/model/dibic/DibicProgram;)V

    iget-object v3, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$7;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    .line 364
    # getter for: Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->network:Lcom/xfinity/playerlib/model/tags/Network;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->access$500(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;)Lcom/xfinity/playerlib/model/tags/Network;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/tags/Network;->getCompanyId()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->companyId(Ljava/lang/Long;)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v2

    .line 365
    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->build()Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;

    move-result-object v2

    iget-object v3, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$7;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    .line 366
    invoke-virtual {v3}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->getIntent(Landroid/content/Context;)Landroid/content/Intent;

    move-result-object v0

    .line 368
    .local v0, "intent":Landroid/content/Intent;
    iget-object v2, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$7;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    invoke-virtual {v2, v0}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->startActivity(Landroid/content/Intent;)V

    .line 369
    return-void
.end method

.class Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$1;
.super Ljava/lang/Object;
.source "PhoneNetworkCollectionsFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->getOnClickListenerForProgramDetail(Lcom/xfinity/playerlib/model/tags/FeaturedShow;)Landroid/view/View$OnClickListener;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;

.field final synthetic val$featuredShow:Lcom/xfinity/playerlib/model/tags/FeaturedShow;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;Lcom/xfinity/playerlib/model/tags/FeaturedShow;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;

    .prologue
    .line 286
    iput-object p1, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$1;->this$0:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$1;->val$featuredShow:Lcom/xfinity/playerlib/model/tags/FeaturedShow;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 290
    new-instance v1, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$1;->val$featuredShow:Lcom/xfinity/playerlib/model/tags/FeaturedShow;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;-><init>(Lcom/xfinity/playerlib/model/MerlinId;)V

    .line 291
    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->build()Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;

    move-result-object v1

    iget-object v2, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$1;->this$0:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;

    .line 292
    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->getIntent(Landroid/content/Context;)Landroid/content/Intent;

    move-result-object v0

    .line 294
    .local v0, "intent":Landroid/content/Intent;
    iget-object v1, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$1;->this$0:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;

    invoke-virtual {v1, v0}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->startActivity(Landroid/content/Intent;)V

    .line 296
    return-void
.end method

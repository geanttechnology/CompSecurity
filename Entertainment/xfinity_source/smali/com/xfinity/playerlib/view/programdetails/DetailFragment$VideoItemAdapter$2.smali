.class Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter$2;
.super Ljava/lang/Object;
.source "DetailFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->setupDownloadButton(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;ZLcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Landroid/view/ViewGroup;Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;

.field final synthetic val$video:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

.field final synthetic val$watchable:Lcom/xfinity/playerlib/model/consumable/Watchable;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;Lcom/xfinity/playerlib/model/consumable/Watchable;Lcom/xfinity/playerlib/model/consumable/VideoFacade;)V
    .locals 0
    .param p1, "this$1"    # Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;

    .prologue
    .line 969
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter$2;->this$1:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter$2;->val$watchable:Lcom/xfinity/playerlib/model/consumable/Watchable;

    iput-object p3, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter$2;->val$video:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 8
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 971
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter$2;->this$1:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/Activity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    .line 972
    .local v0, "fm":Landroid/app/FragmentManager;
    invoke-virtual {v0}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v1

    .line 973
    .local v1, "ft":Landroid/app/FragmentTransaction;
    sget-object v2, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->FRAGMENT_TAG:Ljava/lang/String;

    invoke-virtual {v0, v2}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v2

    if-nez v2, :cond_0

    .line 974
    new-instance v2, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter$2;->val$watchable:Lcom/xfinity/playerlib/model/consumable/Watchable;

    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter$2;->val$video:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    new-instance v5, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$FlowEventListener;

    iget-object v6, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter$2;->this$1:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;

    iget-object v6, v6, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    const/4 v7, 0x0

    invoke-direct {v5, v6, v7}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$FlowEventListener;-><init>(Lcom/xfinity/playerlib/view/programdetails/DetailFragment;Lcom/xfinity/playerlib/view/programdetails/DetailFragment$1;)V

    invoke-direct {v2, v3, v4, v5}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;-><init>(Lcom/xfinity/playerlib/model/consumable/Watchable;Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$PreDownloadFlowEventListener;)V

    sget-object v3, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->FRAGMENT_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/app/FragmentTransaction;->add(Landroid/app/Fragment;Ljava/lang/String;)Landroid/app/FragmentTransaction;

    .line 977
    :cond_0
    invoke-virtual {v1}, Landroid/app/FragmentTransaction;->commit()I

    .line 978
    return-void
.end method

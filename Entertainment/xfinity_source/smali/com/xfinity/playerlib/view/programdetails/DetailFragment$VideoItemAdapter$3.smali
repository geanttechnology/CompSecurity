.class Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter$3;
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


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;Lcom/xfinity/playerlib/model/consumable/VideoFacade;)V
    .locals 0
    .param p1, "this$1"    # Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;

    .prologue
    .line 993
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter$3;->this$1:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter$3;->val$video:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 996
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter$3;->this$1:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/Activity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    .line 997
    .local v0, "fm":Landroid/app/FragmentManager;
    sget-object v2, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;->DOWNLOAD:Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter$3;->val$video:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    invoke-static {v2, v3}, Lcom/xfinity/playerlib/view/common/UpsellDialog;->newInstance(Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;Lcom/xfinity/playerlib/model/consumable/VideoFacade;)Lcom/xfinity/playerlib/view/common/UpsellDialog;

    move-result-object v1

    .line 998
    .local v1, "upsellDialog":Lcom/xfinity/playerlib/view/common/UpsellDialog;
    const-string v2, "upsell_dialog"

    invoke-virtual {v1, v0, v2}, Lcom/xfinity/playerlib/view/common/UpsellDialog;->show(Landroid/app/FragmentManager;Ljava/lang/String;)V

    .line 999
    return-void
.end method

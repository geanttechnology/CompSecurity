.class Lcom/livemixtapes/ProfileFragment$ProfileListAdapter$2;
.super Ljava/lang/Object;
.source "ProfileFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;

.field private final synthetic val$map:Ljava/util/Map;


# direct methods
.method constructor <init>(Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;Ljava/util/Map;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter$2;->this$1:Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;

    iput-object p2, p0, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter$2;->val$map:Ljava/util/Map;

    .line 211
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 215
    iget-object v2, p0, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter$2;->val$map:Ljava/util/Map;

    sput-object v2, Lcom/livemixtapes/profile/SelectedPlayList;->map:Ljava/util/Map;

    .line 217
    iget-object v2, p0, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter$2;->this$1:Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;

    # getter for: Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;->activity:Lcom/livemixtapes/ui/BaseActivity;
    invoke-static {v2}, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;->access$0(Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;)Lcom/livemixtapes/ui/BaseActivity;

    move-result-object v2

    invoke-virtual {v2}, Lcom/livemixtapes/ui/BaseActivity;->getAnimatedFragmentTransaction()Landroid/app/FragmentTransaction;

    move-result-object v0

    .line 218
    .local v0, "fragmentTransaction":Landroid/app/FragmentTransaction;
    new-instance v1, Lcom/livemixtapes/profile/SelectedPlayList;

    invoke-direct {v1}, Lcom/livemixtapes/profile/SelectedPlayList;-><init>()V

    .line 219
    .local v1, "selectedPlaylist":Lcom/livemixtapes/profile/SelectedPlayList;
    const v2, 0x7f0800cc

    const-string v3, "SELECTED"

    invoke-virtual {v0, v2, v1, v3}, Landroid/app/FragmentTransaction;->replace(ILandroid/app/Fragment;Ljava/lang/String;)Landroid/app/FragmentTransaction;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/app/FragmentTransaction;

    .line 220
    invoke-virtual {v0}, Landroid/app/FragmentTransaction;->commit()I

    .line 223
    return-void
.end method

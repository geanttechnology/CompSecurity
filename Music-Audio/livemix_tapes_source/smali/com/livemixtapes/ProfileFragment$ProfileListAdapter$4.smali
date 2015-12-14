.class Lcom/livemixtapes/ProfileFragment$ProfileListAdapter$4;
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
    iput-object p1, p0, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter$4;->this$1:Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;

    iput-object p2, p0, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter$4;->val$map:Ljava/util/Map;

    .line 280
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 283
    iget-object v0, p0, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter$4;->this$1:Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;

    # getter for: Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;->this$0:Lcom/livemixtapes/ProfileFragment;
    invoke-static {v0}, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;->access$1(Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;)Lcom/livemixtapes/ProfileFragment;

    move-result-object v1

    iget-object v0, p0, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter$4;->this$1:Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;

    # getter for: Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;->activity:Lcom/livemixtapes/ui/BaseActivity;
    invoke-static {v0}, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;->access$0(Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;)Lcom/livemixtapes/ui/BaseActivity;

    move-result-object v2

    iget-object v0, p0, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter$4;->val$map:Ljava/util/Map;

    check-cast v0, Ljava/util/HashMap;

    invoke-virtual {v1, v2, v0}, Lcom/livemixtapes/ProfileFragment;->showMixtapeFragment(Landroid/content/Context;Ljava/util/HashMap;)V

    .line 284
    return-void
.end method

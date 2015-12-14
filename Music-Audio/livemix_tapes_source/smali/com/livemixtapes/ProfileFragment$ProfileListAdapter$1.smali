.class Lcom/livemixtapes/ProfileFragment$ProfileListAdapter$1;
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

.field private final synthetic val$position:I


# direct methods
.method constructor <init>(Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;I)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter$1;->this$1:Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;

    iput p2, p0, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter$1;->val$position:I

    .line 171
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v1, 0x1

    .line 174
    iget v0, p0, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter$1;->val$position:I

    if-nez v0, :cond_0

    .line 175
    iget-object v0, p0, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter$1;->this$1:Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;

    # getter for: Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;->this$0:Lcom/livemixtapes/ProfileFragment;
    invoke-static {v0}, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;->access$1(Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;)Lcom/livemixtapes/ProfileFragment;

    move-result-object v0

    invoke-virtual {v0, v1}, Lcom/livemixtapes/ProfileFragment;->openSeeAllFragment(I)V

    .line 181
    :goto_0
    return-void

    .line 176
    :cond_0
    iget v0, p0, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter$1;->val$position:I

    if-ne v0, v1, :cond_1

    .line 177
    iget-object v0, p0, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter$1;->this$1:Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;

    # getter for: Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;->this$0:Lcom/livemixtapes/ProfileFragment;
    invoke-static {v0}, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;->access$1(Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;)Lcom/livemixtapes/ProfileFragment;

    move-result-object v0

    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Lcom/livemixtapes/ProfileFragment;->openSeeAllFragment(I)V

    goto :goto_0

    .line 179
    :cond_1
    iget-object v0, p0, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter$1;->this$1:Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;

    # getter for: Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;->this$0:Lcom/livemixtapes/ProfileFragment;
    invoke-static {v0}, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;->access$1(Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;)Lcom/livemixtapes/ProfileFragment;

    move-result-object v0

    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Lcom/livemixtapes/ProfileFragment;->openSeeAllFragment(I)V

    goto :goto_0
.end method

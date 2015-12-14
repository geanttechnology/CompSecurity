.class Lcom/livemixtapes/ProfileFragment$ProfileListAdapter$3;
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

.field private final synthetic val$albumId:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter$3;->this$1:Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;

    iput-object p2, p0, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter$3;->val$albumId:Ljava/lang/String;

    .line 248
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 251
    new-instance v0, Lcom/livemixtapes/ProfileFragment$LoadDownloadData;

    iget-object v1, p0, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter$3;->this$1:Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;

    # getter for: Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;->this$0:Lcom/livemixtapes/ProfileFragment;
    invoke-static {v1}, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;->access$1(Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;)Lcom/livemixtapes/ProfileFragment;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/livemixtapes/ProfileFragment$LoadDownloadData;-><init>(Lcom/livemixtapes/ProfileFragment;)V

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter$3;->val$albumId:Ljava/lang/String;

    aput-object v3, v1, v2

    invoke-virtual {v0, v1}, Lcom/livemixtapes/ProfileFragment$LoadDownloadData;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 252
    return-void
.end method

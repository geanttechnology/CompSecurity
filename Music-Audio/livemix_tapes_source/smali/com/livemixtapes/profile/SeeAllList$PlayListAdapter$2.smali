.class Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter$2;
.super Ljava/lang/Object;
.source "SeeAllList.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;

.field private final synthetic val$map:Ljava/util/Map;


# direct methods
.method constructor <init>(Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;Ljava/util/Map;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter$2;->this$1:Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;

    iput-object p2, p0, Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter$2;->val$map:Ljava/util/Map;

    .line 286
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 289
    iget-object v0, p0, Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter$2;->this$1:Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;

    # getter for: Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;->this$0:Lcom/livemixtapes/profile/SeeAllList;
    invoke-static {v0}, Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;->access$0(Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;)Lcom/livemixtapes/profile/SeeAllList;

    move-result-object v0

    iget-object v1, p0, Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter$2;->val$map:Ljava/util/Map;

    const-string v2, "albumId"

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/livemixtapes/profile/SeeAllList;->deleteDownload(Ljava/lang/String;)V

    .line 290
    return-void
.end method

.class Lcom/livemixtapes/LazyAdapterSearch$1;
.super Ljava/lang/Object;
.source "LazyAdapterSearch.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/LazyAdapterSearch;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/LazyAdapterSearch;

.field private final synthetic val$obj:Ljava/util/HashMap;

.field private final synthetic val$position:I


# direct methods
.method constructor <init>(Lcom/livemixtapes/LazyAdapterSearch;ILjava/util/HashMap;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/LazyAdapterSearch$1;->this$0:Lcom/livemixtapes/LazyAdapterSearch;

    iput p2, p0, Lcom/livemixtapes/LazyAdapterSearch$1;->val$position:I

    iput-object p3, p0, Lcom/livemixtapes/LazyAdapterSearch$1;->val$obj:Ljava/util/HashMap;

    .line 165
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 168
    const-string v0, "Nithin"

    const-string v1, "Clicked"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 169
    iget-object v1, p0, Lcom/livemixtapes/LazyAdapterSearch$1;->this$0:Lcom/livemixtapes/LazyAdapterSearch;

    iget-object v0, p0, Lcom/livemixtapes/LazyAdapterSearch$1;->this$0:Lcom/livemixtapes/LazyAdapterSearch;

    iget-object v0, v0, Lcom/livemixtapes/LazyAdapterSearch;->data:Ljava/util/ArrayList;

    iget v2, p0, Lcom/livemixtapes/LazyAdapterSearch$1;->val$position:I

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/HashMap;

    iget v2, p0, Lcom/livemixtapes/LazyAdapterSearch$1;->val$position:I

    iget-object v3, p0, Lcom/livemixtapes/LazyAdapterSearch$1;->val$obj:Ljava/util/HashMap;

    invoke-virtual {v1, v0, v2, v3}, Lcom/livemixtapes/LazyAdapterSearch;->openNowPlaying(Ljava/util/HashMap;ILjava/util/HashMap;)V

    .line 170
    return-void
.end method

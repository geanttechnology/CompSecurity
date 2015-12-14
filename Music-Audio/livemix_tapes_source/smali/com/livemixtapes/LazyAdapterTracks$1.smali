.class Lcom/livemixtapes/LazyAdapterTracks$1;
.super Ljava/lang/Object;
.source "LazyAdapterTracks.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/LazyAdapterTracks;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/LazyAdapterTracks;

.field private final synthetic val$position:I


# direct methods
.method constructor <init>(Lcom/livemixtapes/LazyAdapterTracks;I)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/LazyAdapterTracks$1;->this$0:Lcom/livemixtapes/LazyAdapterTracks;

    iput p2, p0, Lcom/livemixtapes/LazyAdapterTracks$1;->val$position:I

    .line 135
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 139
    :try_start_0
    iget-object v0, p0, Lcom/livemixtapes/LazyAdapterTracks$1;->this$0:Lcom/livemixtapes/LazyAdapterTracks;

    iget-object v0, v0, Lcom/livemixtapes/LazyAdapterTracks;->mixTape:Lcom/livemixtapes/Mixtape;

    iget v1, p0, Lcom/livemixtapes/LazyAdapterTracks$1;->val$position:I

    invoke-virtual {v0, v1}, Lcom/livemixtapes/Mixtape;->download(I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 145
    :goto_0
    return-void

    .line 141
    :catch_0
    move-exception v0

    goto :goto_0
.end method

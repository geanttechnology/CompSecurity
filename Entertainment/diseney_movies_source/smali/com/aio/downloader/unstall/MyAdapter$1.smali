.class Lcom/aio/downloader/unstall/MyAdapter$1;
.super Ljava/lang/Object;
.source "MyAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/unstall/MyAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/unstall/MyAdapter;

.field private final synthetic val$position:I


# direct methods
.method constructor <init>(Lcom/aio/downloader/unstall/MyAdapter;I)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/unstall/MyAdapter$1;->this$0:Lcom/aio/downloader/unstall/MyAdapter;

    iput p2, p0, Lcom/aio/downloader/unstall/MyAdapter$1;->val$position:I

    .line 125
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 130
    new-instance v0, Landroid/content/Intent;

    const-string v2, "android.intent.action.DELETE"

    .line 131
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v1, "package:"

    invoke-direct {v3, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 132
    iget-object v1, p0, Lcom/aio/downloader/unstall/MyAdapter$1;->this$0:Lcom/aio/downloader/unstall/MyAdapter;

    # getter for: Lcom/aio/downloader/unstall/MyAdapter;->infos:Ljava/util/List;
    invoke-static {v1}, Lcom/aio/downloader/unstall/MyAdapter;->access$0(Lcom/aio/downloader/unstall/MyAdapter;)Ljava/util/List;

    move-result-object v1

    iget v4, p0, Lcom/aio/downloader/unstall/MyAdapter$1;->val$position:I

    invoke-interface {v1, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/unstall/Info;

    invoke-virtual {v1}, Lcom/aio/downloader/unstall/Info;->getPackagename()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 131
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 130
    invoke-direct {v0, v2, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 133
    .local v0, "intent":Landroid/content/Intent;
    iget-object v1, p0, Lcom/aio/downloader/unstall/MyAdapter$1;->this$0:Lcom/aio/downloader/unstall/MyAdapter;

    # getter for: Lcom/aio/downloader/unstall/MyAdapter;->inflate:Landroid/view/LayoutInflater;
    invoke-static {v1}, Lcom/aio/downloader/unstall/MyAdapter;->access$1(Lcom/aio/downloader/unstall/MyAdapter;)Landroid/view/LayoutInflater;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/LayoutInflater;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 134
    return-void
.end method

.class Lcom/aio/downloader/unstall/Move2SDAdapter$1;
.super Ljava/lang/Object;
.source "Move2SDAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/unstall/Move2SDAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/unstall/Move2SDAdapter;

.field private final synthetic val$position:I


# direct methods
.method constructor <init>(Lcom/aio/downloader/unstall/Move2SDAdapter;I)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/unstall/Move2SDAdapter$1;->this$0:Lcom/aio/downloader/unstall/Move2SDAdapter;

    iput p2, p0, Lcom/aio/downloader/unstall/Move2SDAdapter$1;->val$position:I

    .line 126
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 135
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v2, "package:"

    invoke-direct {v3, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/aio/downloader/unstall/Move2SDAdapter$1;->this$0:Lcom/aio/downloader/unstall/Move2SDAdapter;

    # getter for: Lcom/aio/downloader/unstall/Move2SDAdapter;->infos:Ljava/util/List;
    invoke-static {v2}, Lcom/aio/downloader/unstall/Move2SDAdapter;->access$0(Lcom/aio/downloader/unstall/Move2SDAdapter;)Ljava/util/List;

    move-result-object v2

    iget v4, p0, Lcom/aio/downloader/unstall/Move2SDAdapter$1;->val$position:I

    invoke-interface {v2, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/unstall/Info;

    invoke-virtual {v2}, Lcom/aio/downloader/unstall/Info;->getPackagename()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 136
    .local v1, "packageURI":Landroid/net/Uri;
    new-instance v0, Landroid/content/Intent;

    .line 137
    const-string v2, "android.settings.APPLICATION_DETAILS_SETTINGS"

    .line 136
    invoke-direct {v0, v2, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 139
    .local v0, "intent":Landroid/content/Intent;
    iget-object v2, p0, Lcom/aio/downloader/unstall/Move2SDAdapter$1;->this$0:Lcom/aio/downloader/unstall/Move2SDAdapter;

    # getter for: Lcom/aio/downloader/unstall/Move2SDAdapter;->context:Landroid/content/Context;
    invoke-static {v2}, Lcom/aio/downloader/unstall/Move2SDAdapter;->access$1(Lcom/aio/downloader/unstall/Move2SDAdapter;)Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 140
    return-void
.end method

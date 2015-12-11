.class Lcom/aio/downloader/unstall/Move2NOSD$1;
.super Ljava/lang/Object;
.source "Move2NOSD.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/unstall/Move2NOSD;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/unstall/Move2NOSD;


# direct methods
.method constructor <init>(Lcom/aio/downloader/unstall/Move2NOSD;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/unstall/Move2NOSD$1;->this$0:Lcom/aio/downloader/unstall/Move2NOSD;

    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 42
    iget-object v0, p0, Lcom/aio/downloader/unstall/Move2NOSD$1;->this$0:Lcom/aio/downloader/unstall/Move2NOSD;

    invoke-virtual {v0}, Lcom/aio/downloader/unstall/Move2NOSD;->finish()V

    .line 43
    return-void
.end method

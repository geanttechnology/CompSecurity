.class Lcom/aio/downloader/cleaner/ShowCleanActivity1$3;
.super Ljava/lang/Object;
.source "ShowCleanActivity1.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/cleaner/ShowCleanActivity1;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;


# direct methods
.method constructor <init>(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$3;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    .line 133
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 137
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$3;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    invoke-virtual {v0}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->finish()V

    .line 138
    return-void
.end method
